package entrega.dos.vehiculo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
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
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import entrega.dos.Main;

import entrega.dos.persona.PanelGrillaPersonas;
import entrega.dos.persona.Persona;

public class PanelGrillaVehiculos extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static List<Vehiculo> vehiculos;
	private TableModel dataModel;
	private static JTable table;
	private static JScrollPane scrollpane;
	public static JPanel botones;
	private JButton botonAgregar, botonEliminar;
	private static String filtroNombre = "", filtroColor = "", filtroTipoVehiculo = "Todos";
	private JPanel labelsFieldsJPanel;

	private JTextField longitudField, cantidadPasajerosField, esloraField, mangaField;
	private JLabel longitudLabel, cantidadPasajerosLabel, esloraLabel, mangaLabel;
	private Main frame;

	/**
	 * Create the panel.
	 * 
	 * @param frame
	 */

	public PanelGrillaVehiculos(Main frame) {
		this.frame = frame;
		init();
	}

	private void init() {
		// TODO Auto-generated method stub

		setLayout(new BorderLayout());

		JPanel filtrosJPanel = new JPanel();
		filtrosJPanel.setBackground(Color.BLACK);
		filtrosJPanel.setPreferredSize(new Dimension(900, 180));

		PanelFiltrosGrillaVehiculos panelFiltrosGrillaVehiculos = new PanelFiltrosGrillaVehiculos();

		JLabel iconLabel = new JLabel();
		ImageIcon icono = new ImageIcon("logo_tecno.jpg");
		iconLabel.setIcon(new ImageIcon(icono.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));

		filtrosJPanel.add(iconLabel);
		filtrosJPanel.add(panelFiltrosGrillaVehiculos);

		add(filtrosJPanel, BorderLayout.NORTH);

		vehiculos = new LinkedList<Vehiculo>();

		Vehiculo vehiculo1 = new Barco(1, "Titanic", "Blanco", 150, 75);
		Vehiculo vehiculo2 = new Avion(2, "Boening 747", "Plateado", 60, 200);
		Vehiculo vehiculo3 = new Avion(3, "Boening 747", "Plateado", 60, 200);

		vehiculos.add(vehiculo1);
		vehiculos.add(vehiculo2);
		vehiculos.add(vehiculo3);

		dataModel = loadDataModel(vehiculos);

		table = new JTable(dataModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		setScrollpane(new JScrollPane(table));
		add(getScrollpane(), BorderLayout.CENTER);

		botones = new JPanel();

		botonAgregar = new JButton("Agregar");

		JDialog dialog = new JDialog(frame, "Agregar Vehículo", true);
		JPanel datosPersona = new JPanel(new BorderLayout());

		JButton botonConfirmarVehiculo = new JButton("Confirmar");

		JPanel labelsJPanel = new JPanel();
		BoxLayout labelsLayout = new BoxLayout(labelsJPanel, BoxLayout.Y_AXIS);
		labelsJPanel.setLayout(labelsLayout);

		String labels[] = new String[] { "Id", "Nombre", "Color", "Tipo Vehículo" };

		for (String label : labels) {
			JLabel l = new JLabel(label);
			l.setAlignmentX(Component.RIGHT_ALIGNMENT);
			l.setBorder(new EmptyBorder(0, 5, 5, 0));
			labelsJPanel.add(l);
		}

		longitudLabel = new JLabel("Longitud");
		cantidadPasajerosLabel = new JLabel("Cantidad Pasajeros");

		// por defecto ocultos
		esloraLabel = new JLabel("Eslora");
		esloraLabel.setVisible(false);
		mangaLabel = new JLabel("Manga");
		mangaLabel.setVisible(false);

		List<JLabel> listaLabel = new ArrayList<JLabel>(
				Arrays.asList(longitudLabel, cantidadPasajerosLabel, esloraLabel, mangaLabel));

		for (JLabel jLabel : listaLabel) {
			jLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
			jLabel.setBorder(new EmptyBorder(0, 5, 5, 0));
			labelsJPanel.add(jLabel);
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

		JTextField colorField = new JTextField(10);
		fieldsJPanel.add(colorField);

		JComboBox<String> tipoVehiculoField = new JComboBox<>(new String[] { "Avión", "Barco" });
		tipoVehiculoField.addActionListener(new ActionListener() {

			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) {

				if (((JComboBox<String>) e.getSource()).getSelectedItem().equals("Avión")) {
					longitudLabel.setVisible(true);
					longitudField.setVisible(true);
					cantidadPasajerosLabel.setVisible(true);
					cantidadPasajerosField.setVisible(true);
					esloraLabel.setVisible(false);
					esloraField.setVisible(false);
					mangaLabel.setVisible(false);
					mangaField.setVisible(false);

				} else if (((JComboBox<String>) e.getSource()).getSelectedItem().equals("Barco")) {
					longitudLabel.setVisible(false);
					longitudField.setVisible(false);
					cantidadPasajerosLabel.setVisible(false);
					cantidadPasajerosField.setVisible(false);
					esloraLabel.setVisible(true);
					esloraField.setVisible(true);
					mangaLabel.setVisible(true);
					mangaField.setVisible(true);
				}

				labelsFieldsJPanel.revalidate();
				labelsFieldsJPanel.repaint();
			}
		});

		fieldsJPanel.add(tipoVehiculoField);

		longitudField = new JTextField(10);
		longitudField.setText("0");
		fieldsJPanel.add(longitudField);

		cantidadPasajerosField = new JTextField(10);
		cantidadPasajerosField.setText("0");
		fieldsJPanel.add(cantidadPasajerosField);

		esloraField = new JTextField(10);
		esloraField.setText("0");
		esloraField.setVisible(false);
		fieldsJPanel.add(esloraField);

		mangaField = new JTextField(10);
		mangaField.setText("0");
		mangaField.setVisible(false);
		fieldsJPanel.add(mangaField);

		labelsFieldsJPanel = new JPanel();
		labelsFieldsJPanel.add(labelsJPanel);
		labelsFieldsJPanel.add(fieldsJPanel);

		JPanel tituloPanel = new JPanel();
		tituloPanel.setBackground(Color.BLACK);

		JLabel titulo = new JLabel("Datos Vehículo");
		titulo.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setVerticalAlignment(SwingConstants.CENTER);
		titulo.setForeground(new Color(240, 215, 63));

		tituloPanel.add(titulo);

		botonConfirmarVehiculo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				double longitud = -1;
				int cantidadPasajeros = -1;
				double eslora = -1;
				double manga = -1;

				try {

					int idVehiculo = Integer.valueOf(idField.getText());

					if (nombreField.getText().length() < 4) {
						throw new Exception("ERROR: Nombre demasiado corto.");
					}
					if (colorField.getText().length() < 3) {
						throw new Exception("ERROR: Color demasiado corto.");
					}

					Vehiculo nuevoVehiculo = null;
					if (tipoVehiculoField.getSelectedItem().equals("Avión")) {
						longitud = Double.valueOf(longitudField.getText());
						cantidadPasajeros = Integer.valueOf(cantidadPasajerosField.getText());
						nuevoVehiculo = new Avion(idVehiculo, nombreField.getText(), colorField.getText(), longitud,
								cantidadPasajeros);

					} else if (tipoVehiculoField.getSelectedItem().equals("Barco")) {
						eslora = Double.valueOf(esloraField.getText());
						manga = Double.valueOf(mangaField.getText());
						nuevoVehiculo = new Barco(idVehiculo, nombreField.getText(), colorField.getText(), eslora,
								manga);
					}

					vehiculos.add(nuevoVehiculo);

					actualizarGrillaVehiculos();

					dialog.dispose();

				} catch (NumberFormatException err) {
					if (longitud == -1) {
						JOptionPane.showMessageDialog(dialog, "ERROR: Longitud no válida.", "ERROR",
								JOptionPane.ERROR_MESSAGE, null);
					}
					if (cantidadPasajeros == -1) {
						JOptionPane.showMessageDialog(dialog, "ERROR: Cantidad pasajeros no válida.", "ERROR",
								JOptionPane.ERROR_MESSAGE, null);
					}
					if (eslora == -1) {
						JOptionPane.showMessageDialog(dialog, "ERROR: Eslora no válida.", "ERROR",
								JOptionPane.ERROR_MESSAGE, null);
					}
					if (manga == -1) {
						JOptionPane.showMessageDialog(dialog, "ERROR: Manga no válida.", "ERROR",
								JOptionPane.ERROR_MESSAGE, null);
					}

				} catch (Exception err) {
					JOptionPane.showMessageDialog(dialog, err.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE, null);
				}

			}
		});

		datosPersona.add(tituloPanel, BorderLayout.NORTH);
		datosPersona.add(labelsFieldsJPanel, BorderLayout.CENTER);

		datosPersona.add(botonConfirmarVehiculo, BorderLayout.SOUTH);

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
				colorField.setText("");
				tipoVehiculoField.setSelectedIndex(0);
				longitudField.setText("0");
				cantidadPasajerosField.setText("");

			}
		});

		botones.add(botonAgregar);

		botonEliminar = new JButton("Eliminar");

		botonEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (table.getSelectedRow() > -1) {

					for (Persona persona : PanelGrillaPersonas.getPersonas()) {
						persona.getVehiculos().remove(vehiculos.get(table.getSelectedRow()));
					}

					vehiculos.remove(table.getSelectedRow());

					actualizarGrillaVehiculos();
				} else {
					JOptionPane.showMessageDialog(table, "Debe seleccionar un registro", "ERROR",
							JOptionPane.ERROR_MESSAGE, null);
				}
			}
		});

		botones.add(botonEliminar);

		add(botones, BorderLayout.SOUTH);
	}

	public static void actualizarGrillaVehiculos() {
		table.setModel(loadDataModel(vehiculos));

		getScrollpane().revalidate();
		getScrollpane().repaint();
	}

	private int getNextId() {
		int valorId = 0;
		for (Vehiculo vehiculo : vehiculos) {
			if (vehiculo != null) {
				if (vehiculo.idVehiculo > valorId) {
					valorId = vehiculo.idVehiculo;
				}
			}
		}

		return ++valorId;
	}

	public static TableModel loadDataModel(List<Vehiculo> listaVehiculos) {
		return new AbstractTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public int getColumnCount() {
				return 4;
			}

			public int getRowCount() {
				return listaVehiculos.size();
			}

			public Object getValueAt(int row, int col) {

				try {

					boolean cumpleFiltrosFila = true;

					Vehiculo vehiculo = listaVehiculos.get(row);

					cumpleFiltrosFila = vehiculo.getNombre().toUpperCase().indexOf(filtroNombre.toUpperCase()) > -1
							? cumpleFiltrosFila
							: false;
					cumpleFiltrosFila = vehiculo.getColor().toUpperCase().indexOf(filtroColor.toUpperCase()) > -1
							? cumpleFiltrosFila
							: false;

					String tipoVehiculo = "";
					if (vehiculo instanceof Avion) {
						tipoVehiculo = "Avión";
					} else if (vehiculo instanceof Barco) {
						tipoVehiculo = "Barco";
					}

					cumpleFiltrosFila = (tipoVehiculo.equals(filtroTipoVehiculo) || filtroTipoVehiculo.equals("Todos"))
							? cumpleFiltrosFila
							: false;

					if (cumpleFiltrosFila) {
						switch (col) {
						case 0:
							return vehiculo.getIdVehiculo();
						case 1:
							return vehiculo.getNombre();
						case 2:
							return vehiculo.getColor();
						case 3:
							return tipoVehiculo;
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
					return "Color";
				case 3:
					return "Tipo Vehículo";
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
		PanelGrillaVehiculos.filtroNombre = filtroNombre;
	}

	public static JScrollPane getScrollpane() {
		return scrollpane;
	}

	public static void setScrollpane(JScrollPane scrollpane) {
		PanelGrillaVehiculos.scrollpane = scrollpane;
	}

	public static String getFiltroColor() {
		return filtroColor;
	}

	public static void setFiltroColor(String filtroColor) {
		PanelGrillaVehiculos.filtroColor = filtroColor;
	}

	public static String getFiltroTipoVehiculo() {
		return filtroTipoVehiculo;
	}

	public static void setFiltroTipoVehiculo(String filtroVehiculo) {
		PanelGrillaVehiculos.filtroTipoVehiculo = filtroVehiculo;
	}

	public static List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

}
