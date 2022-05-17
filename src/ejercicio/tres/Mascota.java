package ejercicio.tres;


	public class Mascota {

		private int idMascota, cantidadDePatas;
		private String nombre;

		public Mascota() {
		}

		public Mascota(int idMascota, int cantidadDePatas, String nombre) {
		    super();
		    this.idMascota = idMascota;
		    this.cantidadDePatas = cantidadDePatas;
		    this.nombre = nombre;
		}
		public int getIdMascota() {
		    return idMascota;
		}
		public void setIdMascota(int idMascota) {
		    this.idMascota = idMascota;
		}
		public int getCantidadDePatas() {
		    return cantidadDePatas;
		}
		public void setCantidadDePatas(int cantidadDePatas) {
		    this.cantidadDePatas = cantidadDePatas;
		}
		public String getNombre() {
		    return nombre;
		}
		public void setNombre(String nombre) {
		    this.nombre = nombre;
		}
		}


