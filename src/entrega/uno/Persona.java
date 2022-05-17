package entrega.uno;

import java.time.LocalDate;

public class Persona {
	public int persona;
	public String nombre;
	public String apellido;
	public String dptoResidencia;
	private byte cantHijos;
	private LocalDate fechaNacimiento;
	
	public Persona(){
		
	}
	
	
	public Persona(int persona, String nombre, String apellido, String dptoResidencia, byte cantHijos,
			LocalDate fechaNacimiento) {
		super();
		this.persona = persona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dptoResidencia = dptoResidencia;
		this.cantHijos = cantHijos;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public int getPersona() {
		return persona;
	}
	public void setPersona(int persona) {
		this.persona = persona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDptoResidencia() {
		return dptoResidencia;
	}
	public void setDptoResidencia(String dptoResidencia) {
		this.dptoResidencia = dptoResidencia;
	}
	public byte getCantHijos() {
		return cantHijos;
	}
	public void setCantHijos(byte cantHijos) {
		this.cantHijos = cantHijos;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}
