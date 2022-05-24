package entrega.dos;

public class Vehiculo {
	
	public int idVehiculo;
	public String nombre, color;
	
	public Vehiculo() {
		// TODO Auto-generated constructor stub
	}
	
	public Vehiculo(int idVehiculo, String nombre, String color) {
		super();
		this.idVehiculo = idVehiculo;
		this.nombre = nombre;
		this.color = color;
	}

	public int getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Vehículo [idVehículo=" + idVehiculo + ", nombre=" + nombre + ", color=" + color + "]";
	}
	
	
}
