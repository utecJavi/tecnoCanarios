package entrega.dos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicBorders;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import com.toedter.calendar.JCalendar;

public class PanelGrillaPersonas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Persona> personas;
	private TableModel dataModel;
	private JTable table;
	private static JScrollPane scrollpane;
	public static JPanel botones;
	private JButton botonAgregar, botonEliminar, botonMostrarVehiculos, agregarVehiculoPersona;
	private static String filtroNombre = "", filtroApellido = "", filtroDepartamento = "Todos";

	/**
	 * Create the panel.
	 * 
	 * @param frame
	 */
	public PanelGrillaPersonas(Main frame) {

		setLayout(new BorderLayout());

		JPanel filtrosJPanel = new JPanel();
		filtrosJPanel.setBackground(Color.BLACK);
		filtrosJPanel.setPreferredSize(new Dimension(900, 180));

		PanelFiltrosGrillaPersonas panelFiltrosGrillaPersonas = new PanelFiltrosGrillaPersonas();

		JLabel iconLabel = new JLabel();
		ImageIcon icono = new ImageIcon("logo_tecno.jpg");
		iconLabel.setIcon(new ImageIcon(icono.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));

		filtrosJPanel.add(iconLabel);
		filtrosJPanel.add(panelFiltrosGrillaPersonas);

		add(filtrosJPanel, BorderLayout.NORTH);

		personas = new LinkedList<Persona>();

		personas.add(new Persona(1, "Danny", "Gutiérrez", "Canelones", (byte) 0, LocalDate.of(1983, 10, 19)));
		personas.add(new Persona(2, "Marcos", "Lacerda", "Montevideo", (byte) 0, LocalDate.of(1986, 9, 10)));
		personas.add(new Persona(3, "Javier", "Asuaga", "Montevideo", (byte) 0, LocalDate.of(1986, 9, 27)));
		personas.add(new Persona(4, "Maximiliano", "Orlando", "San José", (byte) 0, LocalDate.of(1995, 8, 8)));
		personas.add(new Persona(5, "Luciano", "Pereira", "Paysandú", (byte) 0, LocalDate.of(2000, 10, 10)));

		Vehiculo vehiculo1 = new Barco(1, "Titanic", "Blanco", 150, 75);
		Vehiculo vehiculo2 = new Avion(2, "Boening 747", "Plateado", 60, 200);

		personas.get(0).agregarVehiculo(vehiculo1);
		personas.get(0).agregarVehiculo(vehiculo2);

		Collections.reverse(personas.get(0).getVehiculos());

		dataModel = loadDataModel(personas);

		table = new JTable(dataModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		setScrollpane(new JScrollPane(table));
		add(getScrollpane(), BorderLayout.CENTER);

		botones = new JPanel();

		botonAgregar = new JButton("Agregar");

		JDialog dialog = new JDialog(frame, "Agregar Persona", true);
		JPanel datosPersona = new JPanel(new BorderLayout());

		JButton botonConfirmarPersona = new JButton("Confirmar");

		JPanel labelsJPanel = new JPanel();
		BoxLayout labelsLayout = new BoxLayout(labelsJPanel, BoxLayout.Y_AXIS);
		labelsJPanel.setLayout(labelsLayout);

		String labels[] = new String[] { "Id", "Nombre", "Apellido", "Departamento", "Hijos", "Fecha nacimiento" };

		for (String label : labels) {
			JLabel l = new JLabel(label);
			l.setAlignmentX(Component.RIGHT_ALIGNMENT);
			l.setBorder(
					new BasicBorders.FieldBorder(getBackground(), getBackground(), getForeground(), getBackground()));
			labelsJPanel.add(l);
		}

		JPanel fieldsJPanel = new JPanel();
		BoxLayout fieldsLayout = new BoxLayout(fieldsJPanel, BoxLayout.Y_AXIS);
		fieldsJPanel.setLayout(fieldsLayout);

		// CAMPOS
		JTextField idField = new JTextField(10);
		idField.setText(String.valueOf(getNextId()));
		idField.setEditable(false);
		fieldsJPanel.add(idField);

		JTextField nombreField = new JTextField(10);
		fieldsJPanel.add(nombreField);

		JTextField apellidoField = new JTextField(10);
		fieldsJPanel.add(apellidoField);

		JComboBox<String> departamentosField = new JComboBox<>(Departamentos.getAsArray()); // Departamentos.getAsArray()
		fieldsJPanel.add(departamentosField);

		JTextField hijosField = new JTextField(10);
		hijosField.setText("0");
		fieldsJPanel.add(hijosField);

		JTextField fechaNacimientoField = new JTextField(10);
		fechaNacimientoField.setEditable(false);
		fieldsJPanel.add(fechaNacimientoField);

		JPanel labelsFieldsJPanel = new JPanel();
		labelsFieldsJPanel.add(labelsJPanel);
		labelsFieldsJPanel.add(fieldsJPanel);

		JPanel tituloPanel = new JPanel();
		tituloPanel.setBackground(Color.BLACK);

		JLabel titulo = new JLabel("Datos Persona");
		titulo.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setVerticalAlignment(SwingConstants.CENTER);
		titulo.setForeground(new Color(240, 215, 63));

		tituloPanel.add(titulo);

		JCalendar calendar = new JCalendar();
		labelsFieldsJPanel.add(calendar);

		botonConfirmarPersona.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				byte hijos;
				try {
					hijos = Byte.valueOf(hijosField.getText());

					int idPersona = Integer.valueOf(idField.getText());

					if (nombreField.getText().length() < 4) {
						throw new Exception("ERROR: Nombre demasiado corto.");
					}
					if (apellidoField.getText().length() < 4) {
						throw new Exception("ERROR: Apellido demasiado corto.");
					}

					LocalDate fecha = Instant.ofEpochMilli(calendar.getDate().getTime()).atZone(ZoneId.systemDefault())
							.toLocalDate();

					Persona nuevaPersona = new Persona(idPersona, nombreField.getText(), apellidoField.getText(),
							departamentosField.getSelectedItem().toString(), hijos, fecha);

					personas.add(nuevaPersona);

					actualizarGrillaPersonas();

					dialog.dispose();

				} catch (NumberFormatException err) {
					JOptionPane.showMessageDialog(dialog, "ERROR: Cantidad de hijos no válida.", "ERROR",
							JOptionPane.ERROR_MESSAGE, null);
				} catch (Exception err) {
					JOptionPane.showMessageDialog(dialog, err.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE, null);
				}

			}
		});

		datosPersona.add(tituloPanel, BorderLayout.NORTH);
		datosPersona.add(labelsFieldsJPanel, BorderLayout.CENTER);

		datosPersona.add(botonConfirmarPersona, BorderLayout.SOUTH);

		botonAgregar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dialog.setBounds(200, 200, 450, 400);
				dialog.setLocationRelativeTo(frame);
				dialog.getContentPane().add(datosPersona);
				dialog.setVisible(true);

				// RESET VALUES
				idField.setText(String.valueOf(getNextId()));
				idField.setEditable(false);
				nombreField.setText("");
				nombreField.grabFocus();
				apellidoField.setText("");
				departamentosField.setSelectedIndex(0);
				hijosField.setText("0");
				fechaNacimientoField.setText("");
			}
		});

		botones.add(botonAgregar);

		botonEliminar = new JButton("Eliminar");

		botonEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (table.getSelectedRow() > -1) {
					personas.remove(table.getSelectedRow());
					actualizarGrillaPersonas();
				} else {
					JOptionPane.showMessageDialog(table, "Debe seleccionar un registro", "ERROR",
							JOptionPane.ERROR_MESSAGE, null);
				}
			}
		});

		botones.add(botonEliminar);

		botonMostrarVehiculos = new JButton("Mostrar vehículos");
		botonMostrarVehiculos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (table.getSelectedRow() > -1) {

					if (personas.get(table.getSelectedRow()).getVehiculos().size() == 0) {
						JOptionPane.showMessageDialog(table, "No se encontraron vehículos", "Vehículo",
								JOptionPane.INFORMATION_MESSAGE, null);
					}
					for (Vehiculo v : personas.get(table.getSelectedRow()).getVehiculos()) {
						JOptionPane.showMessageDialog(table, v, "Vehículo", JOptionPane.INFORMATION_MESSAGE, null);
					}

				} else {
					JOptionPane.showMessageDialog(table, "Debe seleccionar un registro", "ERROR",
							JOptionPane.ERROR_MESSAGE, null);
				}

			}
		});

		botones.add(botonMostrarVehiculos);
		agregarVehiculoPersona = new JButton("Agregar Vehiculo");
		botones.add(agregarVehiculoPersona);
		add(botones, BorderLayout.SOUTH);
	}

	private void actualizarGrillaPersonas() {
		table.setModel(loadDataModel(personas));

		getScrollpane().revalidate();
		getScrollpane().repaint();
	}

	private int getNextId() {
		int valorId = 0;
		for (Persona persona : personas) {
			if (persona != null) {
				if (persona.idPersona > valorId) {
					valorId = persona.idPersona;
				}
			}
		}

		return ++valorId;
	}

	public TableModel loadDataModel(List<Persona> listaPersonas) {
		return new AbstractTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public int getColumnCount() {
				return 6;
			}

			public int getRowCount() {
				return listaPersonas.size();
			}

			public Object getValueAt(int row, int col) {

				try {

					boolean cumpleFiltrosFila = true;

					Persona persona = listaPersonas.get(row);

					cumpleFiltrosFila = persona.getNombre().toUpperCase().indexOf(filtroNombre.toUpperCase()) > -1
							? cumpleFiltrosFila
							: false;
					cumpleFiltrosFila = persona.getApellido().toUpperCase().indexOf(filtroApellido.toUpperCase()) > -1
							? cumpleFiltrosFila
							: false;
					cumpleFiltrosFila = (persona.getDptoResidencia().equals(filtroDepartamento)
							|| filtroDepartamento.equals("Todos")) ? cumpleFiltrosFila : false;

					if (cumpleFiltrosFila) {
						switch (col) {
						case 0:
							return persona.getIdPersona();
						case 1:
							return persona.getNombre();
						case 2:
							return persona.getApellido();
						case 3:
							return persona.getDptoResidencia();
						case 4:
							return persona.getCantHijos();
						case 5:
							return persona.getFechaNacimiento();
						default:
							throw new IllegalArgumentException("Unexpected value: " + col);
						}
					} else {
						return null;
					}

				} catch (Exception e) {
					return null;
				}

			}

			public String getColumnName(int column) {
				switch (column) {
				case 0:
					return "Id";
				case 1:
					return "Nombre";
				case 2:
					return "Apellido";
				case 3:
					return "Departamento";
				case 4:
					return "Hijos";
				case 5:
					return "Fecha nacimiento";
				default:
					throw new IllegalArgumentException("Unexpected value: " + column);
				}

			}
		};
	}

	public static String getFiltroNombre() {
		return filtroNombre;
	}

	public static void setFiltroNombre(String filtroNombre) {
		PanelGrillaPersonas.filtroNombre = filtroNombre;
	}

	public static JScrollPane getScrollpane() {
		return scrollpane;
	}

	public static void setScrollpane(JScrollPane scrollpane) {
		PanelGrillaPersonas.scrollpane = scrollpane;
	}

	public static String getFiltroApellido() {
		return filtroApellido;
	}

	public static void setFiltroApellido(String filtroApellido) {
		PanelGrillaPersonas.filtroApellido = filtroApellido;
	}

	public static String getFiltroDepartamento() {
		return filtroDepartamento;
	}

	public static void setFiltroDepartamento(String filtroDepartamento) {
		PanelGrillaPersonas.filtroDepartamento = filtroDepartamento;
	}

}
