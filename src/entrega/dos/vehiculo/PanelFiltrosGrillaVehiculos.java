package entrega.dos.vehiculo;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class PanelFiltrosGrillaVehiculos extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelFiltrosGrillaVehiculos() {
		setLayout(new GridLayout(0, 1));
		JPanel gridFiltros = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		JLabel filtrosTexto = new JLabel("Filtros VehÝculos");
		filtrosTexto.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
		filtrosTexto.setHorizontalAlignment(SwingConstants.CENTER);
		add(filtrosTexto, BorderLayout.NORTH);

		JLabel nombreJLabel = new JLabel("Nombre");
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.insets = new Insets(0, 30, 0, 0);
		gridFiltros.add(nombreJLabel, constraints);

		JTextField filtroNombre = new JTextField(10);
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.insets = new Insets(0, 0, 0, 0);

		DocumentListener nombreListener = new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				PanelGrillaVehiculos.setFiltroNombre(filtroNombre.getText());
				refreshGrid();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				PanelGrillaVehiculos.setFiltroNombre(filtroNombre.getText());
				refreshGrid();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				PanelGrillaVehiculos.setFiltroNombre(filtroNombre.getText());
				refreshGrid();
			}
		};
		filtroNombre.getDocument().addDocumentListener(nombreListener);
		gridFiltros.add(filtroNombre, constraints);

		JLabel colorJLabel = new JLabel("Color");
		constraints.gridx = 2;
		constraints.gridy = 0;
		constraints.insets = new Insets(0, 10, 0, 0);
		gridFiltros.add(colorJLabel, constraints);

		JTextField filtroApellido = new JTextField(10);
		constraints.gridx = 3;
		constraints.gridy = 0;
		constraints.insets = new Insets(0, 5, 0, 15);

		DocumentListener colorListener = new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				PanelGrillaVehiculos.setFiltroColor(filtroApellido.getText());
				refreshGrid();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				PanelGrillaVehiculos.setFiltroColor(filtroApellido.getText());
				refreshGrid();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				PanelGrillaVehiculos.setFiltroColor(filtroApellido.getText());
				refreshGrid();
			}
		};
		filtroApellido.getDocument().addDocumentListener(colorListener);
		gridFiltros.add(filtroApellido, constraints);

		JLabel tipoVehiculoJLabel = new JLabel("Tipo VehÝculo");
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.insets = new Insets(10, 10, 20, 0);
		gridFiltros.add(tipoVehiculoJLabel, constraints);

		String[] filtroTipoVehiculo = new String[] { "Todos", "Aviˇn", "Barco" };

		JComboBox<String> tipoVehiculoCombo = new JComboBox<>(filtroTipoVehiculo);
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.insets = new Insets(10, -40, 20, 0);

		tipoVehiculoCombo.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				PanelGrillaVehiculos.setFiltroTipoVehiculo(e.getItem().toString());
				refreshGrid();
			}
		});

		gridFiltros.add(tipoVehiculoCombo, constraints);

		add(gridFiltros);
	}

	private void refreshGrid() {
		PanelGrillaVehiculos.getScrollpane().revalidate();
		PanelGrillaVehiculos.getScrollpane().repaint();
	}
}
