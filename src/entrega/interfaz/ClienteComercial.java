package entrega.interfaz;

public class ClienteComercial extends Cliente implements CargoFijo {
	
//	Defina otra implementación de nombre ClienteComercial para la interfaz, que:
//		• tenga los siguientes atributos: el nombre, dirección, rut y los metros consumidos en
//		una variable del tipo entera.

	private String nombre;
	private String direccion;
	private String rut;
	private int metrosConsumidos;
	
	
	public ClienteComercial() {
		super();
		
	}
	public ClienteComercial(String nombre, String direccion, String rut, int metrosConsumidos) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.rut = rut;
		this.metrosConsumidos = metrosConsumidos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public int getMetrosConsumidos() {
		return metrosConsumidos;
	}
	public void setMetrosConsumidos(int metrosConsumidos) {
		this.metrosConsumidos = metrosConsumidos;
	}
	@Override
	
	
	public double calcularGastoDeConsumo() {
		
//		Para el caso del cliente comercial cambia el cargo fijo y el rango de valores es 130, 150, 160,
//		pero la forma de los rangos es la misma que para el cliente familiar.

	double resultado = 0;

		if (metrosConsumidos > 20) {
			resultado = CARGOFIJOCOM + metrosConsumidos * 160;
		} else if (metrosConsumidos > 10) {
			resultado = CARGOFIJOCOM + metrosConsumidos * 150;
		} else {
			resultado = CARGOFIJOCOM + metrosConsumidos * 130;
		}

		return resultado;
	}
	@Override
	public String toString() {
		return "ClienteComercial [nombre=" + nombre + ", direccion=" + direccion + ", rut=" + rut
				+ ", metrosConsumidos=" + metrosConsumidos + ", calcularGastoDeConsumo()=" + calcularGastoDeConsumo()
				+ "]";
	}
	
	
	

}
