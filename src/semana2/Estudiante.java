package semana2;

public class Estudiante {
	
	private Integer numEstudiante;
	private String nombre;
	
		
	public Estudiante(Integer numEstudiante, String nombre) {
		super();
		this.numEstudiante = numEstudiante;
		this.nombre = nombre;
	}
	public Integer getNumEstudiante() {
		return numEstudiante;
	}
	public void setNumEstudiante(Integer numEstudiante) {
		this.numEstudiante = numEstudiante;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
