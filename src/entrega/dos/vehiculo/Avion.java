package entrega.dos.vehiculo;

public class Avion extends Vehiculo {

	public double longitud;
	public int cantPasajeros;

	public Avion() {
		// TODO Auto-generated constructor stub
	}

	public Avion(int idVehiculo, String nombre, String color, double longitud, int cantPasajeros) {
		super(idVehiculo, nombre, color);
		this.longitud = longitud;
		this.cantPasajeros = cantPasajeros;
	}

	public Avion(double longitud, int cantPasajeros) {
		super();
		this.longitud = longitud;
		this.cantPasajeros = cantPasajeros;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public int getCantPasajeros() {
		return cantPasajeros;
	}

	public void setCantPasajeros(int cantPasajeros) {
		this.cantPasajeros = cantPasajeros;
	}

	@Override
	public String toString() {
		return super.toString() + " longitud=" + longitud + " cantPasajeros=" + cantPasajeros;
	}

}
