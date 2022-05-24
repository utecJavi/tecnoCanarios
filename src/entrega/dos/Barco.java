package entrega.dos;

public class Barco extends Vehiculo {

	public double eslora, manga;

	public Barco() {
		// TODO Auto-generated constructor stub
	}

	public Barco(int idVehiculo, String nombre, String color, double eslora, double manga) {
		super(idVehiculo, nombre, color);
		this.eslora = eslora;
		this.manga = manga;
	}

	public Barco(double eslora, double manga) {
		super();
		this.eslora = eslora;
		this.manga = manga;
	}

	public double getEslora() {
		return eslora;
	}

	public void setEslora(double eslora) {
		this.eslora = eslora;
	}

	public double getManga() {
		return manga;
	}

	public void setManga(double manga) {
		this.manga = manga;
	}

}
