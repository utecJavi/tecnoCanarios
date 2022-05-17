package semana2.actividad1;

public class Empleado {

	private String nombre;
	private String apellido;
	private Integer numeroBps;
	private Integer numeroFuncionario;
	private String direccion;
	private String telefono;
	
	public Empleado(){} 

	public Empleado(String nombre, String apellido, Integer numeroBps, Integer numeroFuncionario, String direccion,
			String telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.numeroBps = numeroBps;
		this.numeroFuncionario = numeroFuncionario;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getNumeroBps() {
		return numeroBps;
	}

	public void setNumeroBps(Integer numeroBps) {
		this.numeroBps = numeroBps;
	}

	public Integer getNumeroFuncionario() {
		return numeroFuncionario;
	}

	public void setNumeroFuncionario(Integer numeroFuncionario) {
		this.numeroFuncionario = numeroFuncionario;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public double getSueldo(double sueldo) {
		return sueldo;
	}
}
