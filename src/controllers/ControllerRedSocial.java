package controllers;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import redsocial.Context;
import redsocial.Fanatico;
import redsocial.RedSocialHinchada;

public class ControllerRedSocial {
	
	@FXML ListView<Fanatico> lstMiembros;
	@FXML TextField txtNombre;
	@FXML Button btnAgregar;
	@FXML Button btnModificar;
	@FXML Button btnBorrar;
	@FXML Button btnCrearRed;
	
	Context context = Context.getInstance();
	private RedSocialHinchada redSocial;
	
	public void initialize(){
		ObservableList<Fanatico> listaDeFanatico;
		if(context.getRedSocial() != null)
		{
			redSocial = context.getRedSocial();
			listaDeFanatico = FXCollections.observableArrayList(redSocial.getMiembros());
			lstMiembros.setItems(listaDeFanatico);
			txtNombre.setText(redSocial.getNombreRed());
			txtNombre.setEditable(false);
		}
		crearRedSocial();
		administrarMiembros();
		modificarMiembros();
		eliminarMiembros();
	}
	
	public void administrarMiembros(){
		btnAgregar.setOnMouseClicked( event -> {
		if(redSocial != null)
		{
			try {
				context.setFanaticoSeleccionado(null);
				Parent root = FXMLLoader.load(getClass().getResource("/ViewFanatico.fxml"));
				Stage escenario = new Stage();
				Scene escena = new Scene(root);
				escenario.setScene(escena);
				escenario.show();
				Stage stageRedSocial = (Stage) lstMiembros.getScene().getWindow();
				stageRedSocial.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("Primero debe crear la red social");
		}
		});
	}
	
	public void modificarMiembros(){
		btnModificar.setOnMouseClicked(event ->{
		Fanatico fanaticoAModificar = lstMiembros.getSelectionModel().getSelectedItem();
		try {
			if(fanaticoAModificar != null)
			{
				context.setFanaticoSeleccionado(lstMiembros.getSelectionModel().getSelectedItem());
				Parent root = FXMLLoader.load(getClass().getResource("/ViewFanatico.fxml"));
				Stage escenario = new Stage();
				Scene escena = new Scene(root);
				escenario.setScene(escena);
				escenario.show();
				Stage stageRedSocial = (Stage) txtNombre.getScene().getWindow();
				stageRedSocial.close();
			}else{
				System.out.println("Fanatico no seleccionado");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		});
	}
	
	public void eliminarMiembros()
	{
		btnBorrar.setOnMouseClicked(event -> {
		Fanatico fanaticoABorrar = lstMiembros.getSelectionModel().getSelectedItem();
		lstMiembros.getItems().remove(fanaticoABorrar);
		if(redSocial != null)
		{
			redSocial.getMiembros().remove(fanaticoABorrar);
		}
		});
	}
	
	public void crearRedSocial(){
		btnCrearRed.setOnMouseClicked( e -> {
		String nombreRedSocial = txtNombre.getText();
		if(nombreRedSocial != null && nombreRedSocial !="")
		{
			redSocial = new RedSocialHinchada(nombreRedSocial);
			context.setRedSocial(redSocial);
			System.out.println(redSocial);
		}
		});
	}
}
