package controllers;

import java.io.IOException;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import redsocial.Context;
import redsocial.Equipo;
import redsocial.Fanatico;
import redsocial.Fanatico.Estado;
import redsocial.Persona.Genero;
import redsocial.RedSocialHinchada;

public class ControllerFanatico {
	
	@FXML Button btnGuardar;
	@FXML TextField txtNombre;
	@FXML TextField txtEmail;
	@FXML DatePicker dtpFecha;
	@FXML ComboBox<Genero> cmbGenero;
	@FXML ComboBox<Equipo> cmbEquipo;
	@FXML ComboBox<Estado> cmbEstado;
	@FXML CheckBox chkAntecedentes;
	@FXML CheckBox chkSocio;
	@FXML Spinner<Integer> spnAntiguedad;
	@FXML TextField txtId;
	@FXML Button btnLimpiar;
	@FXML Button btnCancelar;
	
	private Fanatico fanaticoPojo;
	Context context= Context.getInstance();
	private RedSocialHinchada redSocial;
	private boolean modificar;
		
	public void initialize()
	{
		txtId.setVisible(false);
		ObservableList<Genero> itemsGeneroFanatico = FXCollections.observableArrayList(Genero.values());
		cmbGenero.setItems(itemsGeneroFanatico);
		ObservableList<Equipo> itemsEquipoFanatico = FXCollections.observableArrayList(Equipo.values());
		cmbEquipo.setItems(itemsEquipoFanatico);
		ObservableList<Estado> itemsEstadoFanatico = FXCollections.observableArrayList(Estado.values());
		cmbEstado.setItems(itemsEstadoFanatico);
		if(context.getFanaticoSeleccionado() != null)
		{
			fanaticoPojo = context.getFanaticoSeleccionado();
			cargar(fanaticoPojo);
			modificar = true;
		}else
		{
			fanaticoPojo = new Fanatico();
		}
		txtId.setEditable(false);
		redSocial = context.getRedSocial();
		limpiar();
		guardar();
		presionarCancelar();
		//asignarManejoEventos();
	}
	
	private void cargar(Fanatico f) {
		txtId.setText(f.getIdFanatico());
		txtEmail.setText(f.getEmail());
		txtNombre.setText(f.getNombre());
		cmbGenero.setValue(f.getGenero());
		dtpFecha.setValue(f.getFechaNacimiento());
		cmbEquipo.setValue(f.getEquipo());
		cmbEstado.setValue(f.getEstado());
		chkAntecedentes.setSelected(f.isAntecedentes());;
		chkSocio.setSelected(f.isSocio());
		spnAntiguedad.getValueFactory().setValue(f.getAntiguedadAños());
	}

	public void limpiar()
	{
		btnLimpiar.setOnMouseClicked(e -> {
			txtEmail.setText("");
			txtNombre.setText("");
			cmbGenero.setValue(null);
			dtpFecha.setValue(null);
			cmbEquipo.setValue(null);
			cmbEstado.setValue(null);
			chkAntecedentes.setSelected(false);
			chkSocio.setSelected(false);
			spnAntiguedad.getValueFactory().setValue(null);
		});;
	}
	
	public void guardar()
	{
		btnGuardar.setOnMouseClicked(e -> {
				
				if(modificar)
				{
					guardarModificado();
				}
				else
				{
					fanaticoPojo = new Fanatico();
					cargarDatosEnPantalla();
					System.out.println(fanaticoPojo.toString());
					txtNombre.setText(fanaticoPojo.getNombre());
					if(redSocial != null)
					{
						redSocial.getMiembros().add(fanaticoPojo);
						System.out.println(redSocial);
						llamarGUIRedSocial();
					}else{
						System.out.println("Todo fanatico debe tener una red social");
					}
				}
		});
	}
	
	private void guardarModificado() {
			cargarDatosEnPantalla();
			
			if(redSocial != null)
			{
				List<Fanatico> listaFanatico = redSocial.getMiembros();
				for(Fanatico f: listaFanatico){
					if(f.getIdFanatico()==fanaticoPojo.getIdFanatico())
					{
						f= fanaticoPojo;
						break;
					}
				}
				System.out.println(redSocial);
				llamarGUIRedSocial();
			}else{
				System.out.println("Error todo fanatico debe tener una red social");
			}
	}

	public void presionarCancelar() {
		btnCancelar.setOnMouseClicked(evento ->
		{
		llamarGUIRedSocial();
		});
	}

	public void llamarGUIRedSocial() {
		try{
			Parent root = FXMLLoader.load(getClass().getResource("/ViewRedSocial.fxml"));
			Stage escenario = new Stage();
			Scene escena = new Scene(root);
			escenario.setScene(escena);
			escenario.show();
			Stage stageRedSocial = (Stage) txtNombre.getScene().getWindow();
			stageRedSocial.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}

	private void cargarDatosEnPantalla() {
		fanaticoPojo.setEmail(txtEmail.getText());
		fanaticoPojo.setNombre(txtNombre.getText());
		fanaticoPojo.setGenero(cmbGenero.getValue());
		fanaticoPojo.setFechaNacimiento(dtpFecha.getValue());
		fanaticoPojo.setAntecedentes(chkAntecedentes.isSelected());
		fanaticoPojo.setSocio(chkSocio.isSelected());
		fanaticoPojo.setEquipo(cmbEquipo.getValue());
		fanaticoPojo.setEstado(cmbEstado.getValue());
		fanaticoPojo.setAntiguedadAños(spnAntiguedad.getValue());
	}

	private void asignarManejoEventos()
	{
		btnGuardar.setOnDragDetected(
				e -> System.out.println("Oye no me arrastres como Rody!!"));
	}
}
