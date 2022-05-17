package semana2;

import java.util.LinkedList;

public class Docente {
	
	private int codProfesor;
	private String nombre;
	private LinkedList<Curso> listCursosDicta;
	
	
	public Docente(int cod, String nom) {
		super();
		this.codProfesor = cod;
		this.nombre = nom;
		this.listCursosDicta = new LinkedList<Curso>();
	}


	public int getCodProfesor() {
		return codProfesor;
	}

	public void setCodProfesor(int codProfesor) {
		this.codProfesor = codProfesor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LinkedList<Curso> getListCursosDicta() {
		return listCursosDicta;
	}

	public void setListCursosDicta(LinkedList<Curso> listCursosDicta) {
		this.listCursosDicta = listCursosDicta;
	}
	
	public void agregarCursoDocente(Curso c){
		this.listCursosDicta.add(c);
		
	}
	
	

}
