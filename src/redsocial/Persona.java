package redsocial;

import java.time.LocalDate;

public class Persona {
	
	public enum Genero{
		MASCULINO,FEMENINO,OTROS, PREFIERO_NO_DECIR;
	}
	
	private Genero genero;
	private String nombre;
	private String email;
	private LocalDate fechaNacimiento;
	
	public Persona(){
		
	}
	

	public Persona(String nombre, String email, LocalDate fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = Genero.PREFIERO_NO_DECIR;
	}

	public Persona(String nombre, LocalDate fechaNacimiento, Genero genero, String email) {
		this.genero = genero;
		this.nombre = nombre;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Persona [genero=" + genero + ", nombre=" + nombre + ", email=" + email + ", fechaNacimiento="
				+ fechaNacimiento + "]";
	}
	
	public void emailFelicitacionCumple()
	{
		System.out.println("Hola " + nombre + " solo te escribia para decirte. Feliz cumpleaños!" );
		System.out.println("Haz que este "+ fechaNacimiento.getDayOfMonth() +" / " + fechaNacimiento.getMonthValue()+" sea especial");
		SimuladorRedHinchada.procesarEmail(email);
	}
		
	
}
