package semana2.actividad1;

public class Principal {

	public static void main(String[] args) {
		
		Sucursal suc1 = new Sucursal("Casa Central", 1, "Montevideo", "28082888", "259142368838");
		Sucursal suc2 = new Sucursal("Sucursal Durazno", 3, "Durazno", "25823698", "248648282536");
		
		EmpJornalero empJor1 = new EmpJornalero("juan","Zabala",328672,68,"Durazno","26223858",215.5,120);
		EmpJornalero empJor2 = new EmpJornalero("Pedro","Rosen",669825,30,"Montevideo","2852639",280.0,100.5);
		
		EmpMensual empMens1 = new EmpMensual("Romina","Paito",333458,50,"Durazno","2528655",38000,"Comercial");
		EmpMensual empMens2 = new EmpMensual("Lucas","Manzi",225698,45,"Montevideo","2887469",38500,"Comercial");
	}
	}


