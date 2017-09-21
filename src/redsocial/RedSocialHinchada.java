package redsocial;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import redsocial.Persona.Genero;

public class RedSocialHinchada {
	
	private String NombreRed;	
	private List<Fanatico> miembros = new ArrayList<Fanatico>();
	
	//Enfoque 1: 
	public static List<Fanatico> buscarPersonasPorEquipo(List<Fanatico> miembros, Equipo e){
		List<Fanatico> resultadosBusqueda = new ArrayList<Fanatico>();
		System.out.println("Las personas del equipo "+ e +"son: ");
		for (Fanatico f : miembros) {
			if(f.getEquipo().equals(e)){
				resultadosBusqueda.add(f);
				System.out.println(f);
			}
		}
		return resultadosBusqueda;
	}
	
	public List<Fanatico> buscarPersonasPorGenero(Genero g){
		List<Fanatico> resultadosBusqueda = new ArrayList<Fanatico>();
		System.out.println("Las personas del equipo "+ g +"son: ");
		for (Fanatico f : miembros) {
			if(f.getGenero().equals(g)){
				resultadosBusqueda.add(f);
				System.out.println(f);
			}
		}
		return resultadosBusqueda;
	}
	
	//Enfoque 2: creterios por rango
	public static List<Fanatico> buscarPersonasPorRangoFechaNacimiento(List<Fanatico> miembros, LocalDate fechaMinima, LocalDate fechaMaxima)
	{
		List<Fanatico> resultadosBusqueda= new ArrayList<Fanatico>();
		System.out.println("Las hinchas nacidos entre  "+ fechaMinima +" y  "+fechaMaxima);
		for(Fanatico f:miembros){
			if(f.getFechaNacimiento().isAfter(fechaMinima) && f.getFechaNacimiento().isBefore(fechaMaxima)){
				resultadosBusqueda.add(f);
				System.out.println(f);
			}
		}
		return resultadosBusqueda;
	}
	
	//Enfoque 3: Criterio General
	public static List<Fanatico> buscarFanaticosPorCriterioDado(List<Fanatico> miembros,Criterio criterio){
		List<Fanatico> resultadosBusqueda = new ArrayList<Fanatico>();
		System.out.println("Las fanaticos que cumplen con el criterio son: ");
		for(Fanatico f: miembros){
			if(criterio.verificar(f)){
				resultadosBusqueda.add(f);
				System.out.println(f);
			}
		}
		return resultadosBusqueda; 
	}
	
	//Enfoque 
	public static List<Fanatico> buscarFanaticosPorCriterioDadoInterfazFuncionalEstandar(List<Fanatico> miembros,Predicate<Fanatico> predicate, String detalleCriterio){
		List<Fanatico> resultadosBusqueda = new ArrayList<Fanatico>();
		System.out.println("Los fanaticos con el criterio "+detalleCriterio+" son: ");
		for(Fanatico f:miembros){
			if(predicate.test(f)){
				resultadosBusqueda.add(f);
				System.out.println(f);
			}
		}
		return resultadosBusqueda;
	}
	
	
	//Enfoque 7:Aplicar accion sobre filtrado
	public static List<Fanatico> buscarFanaticosAplicandoAccion(List<Fanatico> miembros, Predicate<Fanatico> predicate, String detalleCriterio, Consumer<Fanatico> consumidor){
		List<Fanatico> resultadoBusqueda = new ArrayList<Fanatico>();
		for(Fanatico f:miembros){
			if(predicate.test(f)){
				System.out.println("Antes de aplicar la accion: "+f);
				consumidor.accept(f);
				resultadoBusqueda.add(f);
				System.out.println("Despues de aplicar la accion: "+f);
			}
		}
		return resultadoBusqueda;
	}

	//Enfoque 7.2: Aplicar accion sobre infiltrados
	public static List<Fanatico> buscarFanaticosAplicandoAccionMapeando(List<Fanatico> miembros, Predicate<Fanatico> predicate, String detalleCriterio,
			Consumer<Fanatico> consumidor,Function<Fanatico,String> mapeadora,
			Consumer<String> procesadoraCadenita){
		List<Fanatico> resultadoBusqueda = new ArrayList<Fanatico>();
		for(Fanatico f:miembros){
			if(predicate.test(f)){
				System.out.println("Antes de aplicar la accion: "+f);
				consumidor.accept(f);
				String cadenita = mapeadora.apply(f);
				System.out.println("");
				procesadoraCadenita.accept(cadenita);
				resultadoBusqueda.add(f);
				System.out.println("Despues de aplicar la accion: "+f);
			}
		}
		return resultadoBusqueda;
	}
	
	//Enfoque 8: 
	public static <X,Y> List<X> procesarElementos(Iterable<X> elementos, Predicate<X> predicate, Function<X, Y> mapeadora,
			Consumer<Y> consumidora){
		List<X> elementosProcesados = new ArrayList<X>();
		for(X x:elementos){
			if(predicate.test(x)){
				System.out.println("El elemento es: " + x );
				elementosProcesados.add(x);
				Y resultadoMapeo = mapeadora.apply(x);
				System.out.println("El objeto producto del mapeo es: "+ resultadoMapeo);
				consumidora.accept(resultadoMapeo);
			}
		}
		return elementosProcesados;
	}
	
	public RedSocialHinchada(String nombre){
		this.NombreRed = nombre;
		miembros = new ArrayList<Fanatico>();
	}
	
	public List<Fanatico> getMiembros() {
		return miembros;
	}

	public void setMiembros(List<Fanatico> miembros) {
		this.miembros = miembros;
	}
	
	public void agregarMiembro(Fanatico f)
	{
		this.miembros.add(f);
	}

	public String getNombreRed() {
		return NombreRed;
	}

	public void setNombreRed(String nombreRed) {
		NombreRed = nombreRed;
	}
}
