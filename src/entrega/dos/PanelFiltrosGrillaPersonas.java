package entrega.dos;

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

public class PanelFiltrosGrillaPersonas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelFiltrosGrillaPersonas() {
		setLayout(new GridLayout(0, 1));
		JPanel gridFiltros = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		JLabel filtrosTexto = new JLabel("Filtros");
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
				PanelGrillaPersonas.setFiltroNombre(filtroNombre.getText());
				refreshGrid();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				PanelGrillaPersonas.setFiltroNombre(filtroNombre.getText());
				refreshGrid();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				PanelGrillaPersonas.setFiltroNombre(filtroNombre.getText());
				refreshGrid();
			}
		};
		filtroNombre.getDocument().addDocumentListener(nombreListener);
		gridFiltros.add(filtroNombre, constraints);


		JLabel apellidoJLabel = new JLabel("Apellido");
		constraints.gridx = 2;
		constraints.gridy = 0;
		constraints.insets = new Insets(0, 10, 0, 0);
		gridFiltros.add(apellidoJLabel, constraints);

		JTextField filtroApellido = new JTextField(10);
		constraints.gridx = 3;
		constraints.gridy = 0;
		constraints.insets = new Insets(0, 5, 0, 15);
		

		DocumentListener apellidoListener = new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				PanelGrillaPersonas.setFiltroApellido(filtroApellido.getText());
				refreshGrid();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				PanelGrillaPersonas.setFiltroApellido(filtroApellido.getText());
				refreshGrid();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				PanelGrillaPersonas.setFiltroApellido(filtroApellido.getText());
				refreshGrid();
			}
		};
		filtroApellido.getDocument().addDocumentListener(apellidoListener);
		gridFiltros.add(filtroApellido, constraints);
		
		
		JLabel departamentoJLabel = new JLabel("Departamento");
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.insets = new Insets(10, 10, 20, 0);
		gridFiltros.add(departamentoJLabel, constraints);

		String[] departamentos = Departamentos.getAsArray();
		String[] filtroDepartamentos = new String[departamentos.length + 1];
		filtroDepartamentos[0] = "Todos";
		for (int i = 0; i < departamentos.length; i++) {
			filtroDepartamentos[i + 1] = departamentos[i];
		}
		JComboBox<String> departamentosCombo = new JComboBox<>(filtroDepartamentos);
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.insets = new Insets(10, 10, 20, 0);
		
		departamentosCombo.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent e) {
				PanelGrillaPersonas.setFiltroDepartamento(e.getItem().toString());
				refreshGrid();
			}
		});
		
		gridFiltros.add(departamentosCombo, constraints);

		add(gridFiltros);
	}
	
	private void refreshGrid() {
		PanelGrillaPersonas.getScrollpane().revalidate();
		PanelGrillaPersonas.getScrollpane().repaint();
	}
}
