package semana2.actividad1;

import java.util.LinkedList;
import java.util.List;

public class Sucursal {

	private String nombre;
	private Integer identificador;
	private String direccion;
	private String telefono;
	private String rut;
	private LinkedList<Empleado> listaDeEmpleados;
	
	public Sucursal() {}
		

	public Sucursal(String nombre, Integer identificador, String direccion, String telefono, String rut) {
		super();
		this.nombre = nombre;
		this.identificador = identificador;
		this.direccion = direccion;
		this.telefono = telefono;
		this.rut = rut;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getIdentificador() {
		return identificador;
	}


	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getRut() {
		return rut;
	}


	public void setRut(String rut) {
		this.rut = rut;
	}


	public LinkedList<Empleado> getListaDeEmpleados() {
		return listaDeEmpleados;
	}


	public void setListaDeEmpleados(LinkedList<Empleado> listaDeEmpleados) {
		this.listaDeEmpleados = listaDeEmpleados;
	}


	
	

}
