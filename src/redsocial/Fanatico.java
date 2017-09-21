package redsocial;

import java.time.LocalDate;
import java.util.UUID;

public class Fanatico extends Persona{

	public enum Estado{
		ACTIVO,INACTIVO,INHABILITADO;
	}
	
	private String IdFanatico;
	private Estado estado= Estado.INACTIVO;
	private Equipo equipo;
	private boolean socio=false;
	private boolean antecedentes=false;
	private int antiguedadAños=0;
	
	public Fanatico(){
		this.IdFanatico = UUID.randomUUID().toString();
	}
				
	public Fanatico(String nombre,LocalDate fechaNacimiento,Genero genero,String email,Equipo equipo,boolean socio,boolean antecedentes,int antiguedadAños,Estado estado)
	{
		super(nombre,fechaNacimiento,genero,email);
		this.IdFanatico = UUID.randomUUID().toString();
		this.equipo = equipo;
		this.antecedentes = antecedentes;
		this.antiguedadAños = antiguedadAños;
		this.estado = estado;
		this.socio = socio;
	}
	
	public Fanatico(String nombre,LocalDate fechaNacimiento,String email,Equipo equipo)
	{
		super(nombre, email, fechaNacimiento);
		this.IdFanatico = UUID.randomUUID().toString();
		this.equipo = equipo;
	}

	
	public Fanatico(String nombre,LocalDate fechaNacimiento,Genero genero,String email,Equipo equipo,boolean socio)
	{
		super(nombre, fechaNacimiento, genero, email);
		this.IdFanatico = UUID.randomUUID().toString();
		this.equipo = equipo;
		this.socio = socio;
	}
	
	public Fanatico(String nombre,LocalDate fechaNacimiento,Genero genero,String email,Equipo equipo)
	{
		super(nombre, fechaNacimiento, genero, email);
		this.IdFanatico = UUID.randomUUID().toString();
		this.equipo = equipo;
	}

	public Fanatico(String nombre, String email, LocalDate fechaNacimiento) {
		super(nombre, email, fechaNacimiento);
		this.IdFanatico = UUID.randomUUID().toString();
	}

	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	public Equipo getEquipo() {
		return equipo;
	}


	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}


	public boolean isSocio() {
		return socio;
	}


	public void setSocio(boolean socio) {
		this.socio = socio;
	}


	public boolean isAntecedentes() {
		return antecedentes;
	}


	public void setAntecedentes(boolean antecedentes) {
		this.antecedentes = antecedentes;
	}


	public int getAntiguedadAños() {
		return antiguedadAños;
	}


	public void setAntiguedadAños(int antiguedadAños) {
		this.antiguedadAños = antiguedadAños;
	}


	@Override
	public String toString() {
		return "Fanatico ["+super.toString() +", estado = "+ estado + ", equipo=" + equipo + ", socio=" + socio + ", antecedentes="
				+ antecedentes + ", antiguedadAños=" + antiguedadAños + "]\n";
	}

	public String getIdFanatico() {
		return IdFanatico;
	}

}
