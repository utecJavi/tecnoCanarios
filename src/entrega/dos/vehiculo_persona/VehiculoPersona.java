package entrega.dos.vehiculo_persona;

import javax.swing.JDialog;

import entrega.dos.Main;
import entrega.dos.persona.Persona;
import entrega.dos.vehiculo.PanelGrillaVehiculoPersona;

public class VehiculoPersona extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Persona persona;

	public VehiculoPersona(Main frame, Persona persona, boolean vehiculosDePersona) {
		super(frame, vehiculosDePersona ? "Vehículos de una persona" : "Agregar Vehículo a Persona", true);

		this.persona = persona;

		setBounds(200, 200, 650, 400);
		setLocationRelativeTo(frame);
		add(new PanelGrillaVehiculoPersona(frame, this, vehiculosDePersona));

		setVisible(true);
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
