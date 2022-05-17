package semana2;

public class Ejercicio4 {

	public static void main(String[] args) {
		
		Estudiante e1 = new Estudiante(1,"Juan Ramon");
		Estudiante e2 = new Estudiante(2, "Romina Pases");
		Estudiante e3 = new Estudiante(3, "Ricardo Pay");
		Estudiante e4 = new Estudiante(4,"Eliana Guer");
		
		Curso c1 = new Curso(1,"Java");
		Curso c2 = new Curso(2,"BDatos");
		
		c1.agregarEstudiante(e1);
		c1.agregarEstudiante(e2);
		
		c2.agregarEstudiante(e3);
		c2.agregarEstudiante(e4);
				
		Docente d = new Docente(1,"Roberto Can");
		
		d.agregarCursoDocente(c1);
		d.agregarCursoDocente(c2);
		
		System.out.println("Docente: "+ d.getCodProfesor()+"-"+d.getNombre()+" dicta los siguientes cursos: ");
			for(Curso c: d.getListCursosDicta()){
				System.out.println("Curso: "+ c.getNombre());
				System.out.println("Alumnos: ");
				for(Estudiante e: c.getEstudiantes().values()) {
					System.out.println("-"+e.getNombre());
				}
				System.out.println("");
			}
		

	}

}
