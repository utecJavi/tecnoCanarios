package semana2;

import java.util.HashMap;

public class Curso {
	
	private int codCurso;
	private String nombre;
	private HashMap<Integer,Estudiante> estudiantes;
	
	public Curso(int codCurso, String nombre) {
		super();
		this.codCurso = codCurso;
		this.nombre = nombre;
		this.estudiantes= new HashMap <Integer,Estudiante>();
	}

	public int getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public HashMap<Integer, Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(HashMap<Integer, Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
	
	
	
	public void agregarEstudiante (Estudiante e) {
		this.estudiantes.put(e.getNumEstudiante(), e);
	}
	

}
