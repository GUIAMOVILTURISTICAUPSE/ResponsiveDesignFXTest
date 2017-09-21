package redsocial;

import java.time.LocalDate;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Stream;

import org.omg.Messaging.SyncScopeHelper;

import redsocial.Fanatico.Estado;
import redsocial.Persona.Genero;

public class SimuladorRedHinchada {

	public static void main(String[] args) {
		RedSocialHinchada redSocialHinchada= new RedSocialHinchada("facebook");
		
		Fanatico Jimmy = new Fanatico("Jimmy",LocalDate.of(1995, 7, 27),Genero.MASCULINO,"jimmy@hincha.com",Equipo.EMELEC);
		Fanatico Collantes = new Fanatico("Gary",LocalDate.of(1995, 8, 30),Genero.MASCULINO,"gary@hincha.com",Equipo.EMELEC);
		Fanatico manuelito = new Fanatico("manuelito",LocalDate.of(1995, 8, 14),Genero.MASCULINO,"manuelito@hincha.com",Equipo.BARCELONA,true,true,4,Estado.ACTIVO);
		Fanatico angelica = new Fanatico("Angelica",LocalDate.of(1994, 2, 11),Genero.FEMENINO,"angelica@hincha.com",Equipo.LIGA_QUITO,true);
		Fanatico pro = new Fanatico("Jorge",LocalDate.of(1997, 9, 6),Genero.MASCULINO,"Pro@hincha.com",Equipo.RAPTOR,true,false,2,Estado.ACTIVO);
		Fanatico william = new Fanatico("William",LocalDate.of(1997, 4, 4),Genero.MASCULINO, "william@hincha.com", Equipo.BARCELONA,true);
		Fanatico gabriela = new Fanatico("Gaby",LocalDate.of(1996, 5, 7),Genero.FEMENINO,"gaby@hincha.com",Equipo.BARCELONA);
		Fanatico katherine = new Fanatico("Katherine",LocalDate.of(1992, 7, 23),Genero.FEMENINO,"katherine@hincha.com",Equipo.BARCELONA,true,false,2,Estado.ACTIVO);
		Fanatico capitanCavernicola = new Fanatico("capitanCavernicola",LocalDate.of(1911, 12, 5),Genero.MASCULINO,"capitan@hincha.com",Equipo.BARCELONA,true,true,20,Estado.INHABILITADO);
		Fanatico cavani = new Fanatico("Guiseppe",LocalDate.of(1955, 3, 15),Genero.OTROS,"guisepe@hincha.com",Equipo.EMELEC,true,true,18,Estado.INACTIVO);
		Fanatico gordaNatosa = new Fanatico("Gorda",LocalDate.of(1972, 8, 7),Genero.FEMENINO,"gorda@hincha.com",Equipo.EMELEC,true,false,15,Estado.ACTIVO);
		Fanatico guambrito = new Fanatico("guambrito",LocalDate.of(2003, 5, 18),"guambritoff@hincha.com",Equipo.LIGA_QUITO);
		Fanatico orozcoJ = new Fanatico("Jaime",LocalDate.of(1968, 10, 1),Genero.MASCULINO,"jaime@hincha.com",Equipo.OLMEDO,true);
		Fanatico chavon = new Fanatico("chavon", LocalDate.of(1998, 5, 8),Genero.OTROS,"chavon@hincha.com",Equipo.DELFIN);
		Fanatico cuencano = new Fanatico("cuencano",LocalDate.of(1995, 10, 26),"cuencano@hincha.com",Equipo.CUENCA);
	
		redSocialHinchada.agregarMiembro(cuencano);
		redSocialHinchada.agregarMiembro(chavon);
		redSocialHinchada.agregarMiembro(orozcoJ);
		redSocialHinchada.agregarMiembro(guambrito);
		redSocialHinchada.agregarMiembro(gordaNatosa);
		redSocialHinchada.agregarMiembro(cavani);
		redSocialHinchada.agregarMiembro(capitanCavernicola);
		redSocialHinchada.agregarMiembro(katherine);
		redSocialHinchada.agregarMiembro(gabriela);
		redSocialHinchada.agregarMiembro(william);
		redSocialHinchada.agregarMiembro(pro);
		redSocialHinchada.agregarMiembro(angelica);
		redSocialHinchada.agregarMiembro(manuelito);
		redSocialHinchada.agregarMiembro(Collantes);
		redSocialHinchada.agregarMiembro(Jimmy);
		
		//redSocialHinchada.buscarPersonasPorEquipo(redSocialHinchada.getMiembros(),Equipo.BARCELONA);
		//redSocialHinchada.buscarPersonasPorGenero(Genero.MASCULINO);
		//redSocialHinchada.buscarPersonasPorRangoFechaNacimiento(redSocialHinchada.getMiembros(),LocalDate.of(1994, 05, 01), LocalDate.of(1996, 8, 10));
		//CriterioBusquedaPorAntecedentes criterioAntecedentes=new CriterioBusquedaPorAntecedentes();
		//CriterioBusquedaPorEstado criterioEstado = new CriterioBusquedaPorEstado();
		//redSocialHinchada.buscarFanaticosPorCriterioDado(redSocialHinchada.getMiembros(),criterioAntecedentes);
		//redSocialHinchada.buscarFanaticosPorCriterioDado(redSocialHinchada.getMiembros(), criterioEstado);
		/*RedSocialHinchada.buscarFanaticosPorCriterioDado(redSocialHinchada.getMiembros(), new Criterio() {
			
			@Override
			public boolean verificar(Fanatico f) {
				return f.getEstado().equals(Estado.ACTIVO);
			}
			@Override
			public String toString(){
				return " activos ";
			}
		});*/
		
		
	/*RedSocialHinchada.buscarPersonasPorCriteriDado(redSocialHinchada.getMiembros(), new Criterio() {
		
		@Override
		public boolean verificar(Fanatico f) {
			if(f.isSocio() && f.getAntiguedadAños() >2){
				return true;
			}
			return false;
		}
		
		@Override
		public String toString(){
			return "Socios con derecho avotos";
		}
	});*/
	

	/*RedSocialHinchada.buscarPersonasPorCriteriDado(redSocialHinchada.getMiembros(), new Criterio() {
		
		@Override
		public boolean verificar(Fanatico f) {
			int edad = LocalDate.now().getYear() - f.getFechaNacimiento().getYear();
			if(f.isSocio() && edad>18 && f.isAntecedentes() && !(f.getEstado()==Estado.INHABILITADO)){
				return true;
			}
			return false;
		}
		
		@Override
		public String toString(){
			return "Bandalos que deben ser vigilados";
		}
	});*/
	
	
	//Enfoque 5: Expresiones Lambda
	//RedSocialHinchada.buscarPersonasPorCriteriDado(redSocialHinchada.getMiembros(), f-> f.isAntecedentes());
	
	/*RedSocialHinchada.buscarPersonasPorCriteriDado(redSocialHinchada.getMiembros(), (Fanatico f) ->{
		if(f.getAntiguedadAños()>=2 && f.getEstado().equals(Estado.ACTIVO) && f.isSocio()){
			return true;
		}else
			return false;
	});*/
	
	/*RedSocialHinchada.buscarPersonasPorCriteriDado(redSocialHinchada.getMiembros(), (Fanatico f) ->{
		int edad = LocalDate.now().getYear()-f.getFechaNacimiento().getYear();
		if(edad>18 && f.isAntecedentes() && !(f.getEstado()==Estado.INHABILITADO)){
			return true;
		}else
			return false;
	});
	
	//Enfoque 6: Lambdas con Interfaces funcionales Estandar
	   RedSocialHinchada.buscarFanaticosPorCriterioDadoInterfazFuncionalEstandar(redSocialHinchada.getMiembros(),
			   f->f.isAntecedentes()," con antecedentes");
	   */ 
	 //DEBER IMPLEMENTAR LA VERIFICACION DE SOCIOS A VOTAR CON EL ENFOQUE 6
		
		//RedSocialHinchada.buscarFanaticosPorCriterioDadoInterfazFuncionalEstandar(redSocialHinchada.getMiembros(),
			//	f -> f.isSocio() && f.getAntiguedadAños()>=2, " con derecho a voto...");
	   
		
		
		
		//Enfoque 7: Aplicamos accion sobre hinchas filtrados atraves de lambdas y otras interfaces funcionales(Customer)
		/*List<Fanatico> listaFanaticosAntecedentesBorrados = 
				RedSocialHinchada.buscarFanaticosAplicandoAccion(redSocialHinchada.getMiembros(), f -> f.isAntecedentes(), " antecedentes ", f -> f.setAntecedentes(false));
		
		System.out.println("La lista a los que borramos antecedentes es: "+ listaFanaticosAntecedentesBorrados);
		System.out.println("Lista sin antecedentes: \n"+redSocialHinchada.getMiembros());
		*/
		
		//Filtrar Hinchas que sean socios con mas de 2 años y simular enviarles un email
		//( Imprimir nombre y email diciendole que se acerque a votar).
		
		//Enfoque 7.1
		/*List<Fanatico> listaDeFanaticoAVotar = RedSocialHinchada.buscarFanaticosAplicandoAccion(redSocialHinchada.getMiembros(),
				f -> f.isSocio() && f.getAntiguedadAños()>2, " socios con mas de 2 Años ", 
				f -> System.out.println("Usted "+f.getNombre()+" con email: "+f.getEmail()+" tiene que acercarse a votar...."));
		
		System.out.println("La lista de Fanaticos a votar: "+listaDeFanaticoAVotar);		
	*/
		//Enfoque 7.2: Usando la funcion Mapper
		/*List<Fanatico> sociasMuejeresPromo = RedSocialHinchada.buscarFanaticosAplicandoAccionMapeando(redSocialHinchada.getMiembros(),
				f -> f.getGenero().equals(Genero.FEMENINO) && f.isSocio(), " promocion mujeres hinchas", f -> f.setAntiguedadAños(f.getAntiguedadAños()*2),
				f -> f.getEmail(), s -> procesarEmail(s));
		
		System.out.println("Lista de mujeres "+sociasMuejeresPromo);
		
		*/
		//Enfoque 8: Genericos emails a socios activos a votar
		/*List<Fanatico> hinchasVotantesNotificados = RedSocialHinchada.procesarElementos(
				redSocialHinchada.getMiembros(),
				(Fanatico f) -> f.isSocio() && f.getAntiguedadAños()>=2 && f.getEstado().equals(Estado.ACTIVO),
				(Fanatico f) -> {return (Persona) f;},
				(Persona p)-> {
					if(LocalDate.now().getDayOfMonth()== p.getFechaNacimiento().getDayOfMonth() && LocalDate.now().getMonthValue()==p.getFechaNacimiento().getMonthValue())
					{
						p.emailFelicitacionCumple();
					}
				});
		System.out.println("Hinchas votantes notificados: "+ hinchasVotantesNotificados);*/
		
		//EJERCICIO ENFOQUE 8
		//PREGUNTAR SI EL FANATICO ES DE EL EQUIPO  BARCELONA
		//RETORNAR ESE EQUIPO COMO STRING
		//EN BASE AL STRING VAMOS A EJECUTAR UNA FUNCION QUE HAGA UN BARRA PARA ESE EQUIPO(CONSUMER)
		/*List<Fanatico> hinchasDeBarras = RedSocialHinchada.procesarElementos(
				redSocialHinchada.getMiembros(),
				(Fanatico f) -> f.getEquipo().equals(Equipo.BARCELONA),
				(Fanatico f)-> {return f.getEquipo().toString();},
				(String e)-> {
						System.out.println("VAMOSSS "+ e + "!!!!!");
				});		
		System.out.println("Hinchas de Barras : "+ hinchasDeBarras);*/
		
		
		//Enfoque 9: Aggregated Operations
		/*redSocialHinchada.getMiembros().stream()
		.filter(f -> f.isSocio())
		.map(f -> f.getEmail())
		.forEach(s -> procesarEmail(s));*/
	
		/*int añoMinimoNacimiento = redSocialHinchada.getMiembros().stream()
		.filter(f -> f.getGenero().equals(Genero.MASCULINO))
		.mapToInt( f -> f.getFechaNacimiento().getYear())
		.min().getAsInt();
		
		System.out.println("El año minimo de nacimiento de un socio es: "+añoMinimoNacimiento);
		
		 int conteoMujeresHinchas = (int) redSocialHinchada.getMiembros().stream()
		.filter(f -> f.getGenero().equals(Genero.FEMENINO))
		.count();
		 System.out.println("El numero de mujeres inscritas en la red social son: "+conteoMujeresHinchas);
		 */
		
		 redSocialHinchada.getMiembros().stream()
		 .map(f -> (Persona) f)
		 .forEach(f -> {if(LocalDate.now().getMonthValue() == f.getFechaNacimiento().getMonthValue() && 
				 LocalDate.now().getDayOfMonth()== f.getFechaNacimiento().getDayOfMonth())
		 	{
			 	f.emailFelicitacionCumple();
		 	}
		 });
	
	}

	public static void procesarEmail(String s){
		System.out.println("Enviando email a: "+s);
	}
}
