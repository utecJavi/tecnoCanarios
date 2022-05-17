package semana2.actividad1;

public class EmpMensual extends Empleado {
	
	private double salarioMensual;
	private String regimen;
	
	public EmpMensual() {}
	
	public EmpMensual(String nombre, String apellido, Integer numeroBps, Integer numeroFuncionario, String direccion,
			String telefono, double salarioMensual, String regimen ) {
		
		super(nombre, apellido, numeroBps, numeroFuncionario, direccion, telefono);
		this.salarioMensual = salarioMensual;
		this.regimen = regimen;
	}
	
	public EmpMensual(double salarioMensual, String regimen) {
		super();
		this.salarioMensual = salarioMensual;
		this.regimen = regimen;
	}

	public double getSalarioMensual() {
		return salarioMensual;
	}

	public void setSalarioMensual(double salarioMensual) {
		this.salarioMensual = salarioMensual;
	}

	public String getRegimen() {
		return regimen;
	}

	public void setRegimen(String regimen) {
		this.regimen = regimen;
	}
	
	public double getSueldo() {
		return salarioMensual;
	}
	
	

}
