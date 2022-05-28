package entrega.interfaz;

public class ClienteFamiliar extends Cliente implements CargoFijo {

//	Defina una implementación de nombre ClienteFamiliar para la interfaz, que:
//		• tenga los siguientes atributos: el nombre, dirección, cédula y los metros consumidos
//		en una variable del tipo entera.

	private String nombre, direccion,cedula;
	private int metrosConsumidos;
	
	public ClienteFamiliar() {
	}

	public ClienteFamiliar(String nombre, String direccion, String cedula, int metrosConsumidos) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.cedula = cedula;
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

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public int getMetrosConsumidos() {
		return metrosConsumidos;
	}

	public void setMetrosConsumidos(int metrosConsumidos) {
		this.metrosConsumidos = metrosConsumidos;
	}

	@Override
	public double calcularGastoDeConsumo() {

//		Para usar el método de calcular el gasto del consumo de agua en el caso del cliente familiar se
//		debe hacer de la siguiente forma:
//		• Cargo fijo familia + metros * 100 (si es menor igual a 10)
//		• Lo anterior más diferencia en mayor que 10 * 120
//		• Lo anterior más diferencia en mayor que 20 * 135
//		
		double resultado = 0;

		if (metrosConsumidos > 20) {
			resultado = CARGOFIJOFLIA + metrosConsumidos * 135;
		} else if (metrosConsumidos > 10) {
			resultado = CARGOFIJOFLIA + metrosConsumidos * 120;
		} else {
			resultado = CARGOFIJOFLIA + metrosConsumidos * 100;
		}

		return resultado;
	}

	@Override
	public String toString() {
		return "ClienteFamiliar [nombre=" + nombre + ", direccion=" + direccion + ", cedula=" + cedula
				+ ", metrosConsumidos=" + metrosConsumidos + ", calcularGastoDeConsumo()=" + calcularGastoDeConsumo()
				+ "]";
	}
	

}
