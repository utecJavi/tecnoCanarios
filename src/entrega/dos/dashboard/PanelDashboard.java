package entrega.dos.dashboard;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.List;
import javax.swing.JPanel;


import entrega.dos.Departamentos;
import entrega.dos.Main;
import entrega.dos.PanelGrillaPersonas;
import entrega.dos.Persona;


public class PanelDashboard extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Persona> personas = PanelGrillaPersonas.getPersonas();
	private String[] departamentos = Departamentos.getAsArray();

	private Main frame;
	
	public PanelDashboard() {
	}

	public PanelDashboard(Main frame) {
		this.frame = frame;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Graphics2D g2d = (Graphics2D) g;

		HashMap<String, Integer> vehiculosPorDepartamento = new HashMap<>();
		for (String departamento : departamentos) {
			vehiculosPorDepartamento.put(departamento, 0);
		}

		double totalVehiculos = 0;
		for (Persona persona : personas) {
			totalVehiculos += persona.getVehiculos().size();
		}

		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
		g2d.drawString("Cantidad vehículos ingresados: " + (int) totalVehiculos, 30, 20);
		g2d.drawString("Promedio vehículos por persona: " + obtenerPromedioVehiculos(totalVehiculos), 30, 50);
		g2d.drawString("Cantidad personas ingresadas: " + personas.size(), 30, 80);

		int x = 50, y = 550;
		final int WIDTH = 30;
		final int MIN_HEIGHT = 0;
		final int MAX_HEIGHT = 450;
		for (int i = 0; i < departamentos.length; i++) {
			String departamento = departamentos[i];

			for (int j = 0; j < personas.size(); j++) {
				Persona persona = personas.get(j);

				if (persona.getDptoResidencia().equals(departamento)) {
					vehiculosPorDepartamento.put(departamento,
							vehiculosPorDepartamento.get(departamento) + persona.getVehiculos().size());
				}
			}

			int cantVehiculoDepto = vehiculosPorDepartamento.get(departamento);
			if (cantVehiculoDepto > 0) {
				double promedio = (cantVehiculoDepto - MIN_HEIGHT) / (totalVehiculos - MIN_HEIGHT);
				int height = (int) (promedio * MAX_HEIGHT);

				g2d.setColor(Color.YELLOW);
				g2d.fillRect(x, y - height, WIDTH, height);

				g2d.setStroke(new BasicStroke(2f));
				g2d.setColor(Color.BLACK);
				g2d.drawRect(x, y - height, WIDTH + 1, height + 1);
			}
			g2d.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
			g2d.drawString(departamento, x, y + 15);

			g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
			g2d.drawString("" + vehiculosPorDepartamento.get(departamento), x + 12, y - 15);

			x += 80;
		}

		g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		g2d.drawString("Vehículos por Departamento", (x - 200) / 2, y + 50);
	}

	private double obtenerPromedioVehiculos(double totalVehiculos) {
		double promedio = 0;

		if (personas.size() > 0)
			promedio = totalVehiculos / (double) personas.size();

		return promedio;
	}

	public Main getFrame() {
		return frame;
	}

	public void setFrame(Main frame) {
		this.frame = frame;
	}

}
