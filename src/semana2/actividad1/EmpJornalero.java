package semana2.actividad1;

public class EmpJornalero extends Empleado{
	
	private double valorHora;
	private double horasRealizadasMes;
	
	public EmpJornalero() {}
	
	public EmpJornalero(String nombre, String apellido, Integer numeroBps, Integer numeroFuncionario, String direccion,
			String telefono, double valorHora, double horasRealizadasMes ) {
		
		super(nombre, apellido, numeroBps, numeroFuncionario, direccion, telefono);
		this.valorHora = valorHora;
		this.horasRealizadasMes = horasRealizadasMes;
	}
	
	public EmpJornalero(double valorHora, double horasRealizadasMes) {
		super();
		this.valorHora = valorHora;
		this.horasRealizadasMes = horasRealizadasMes;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

	public double getHorasRealizadasMes() {
		return horasRealizadasMes;
	}

	public void setHorasRealizadasMes(double horasRealizadasMes) {
		this.horasRealizadasMes = horasRealizadasMes;
	}
	
	public double getSueldo() {
	return valorHora*horasRealizadasMes;
	}	

}
