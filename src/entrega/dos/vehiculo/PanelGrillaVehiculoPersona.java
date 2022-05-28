package entrega.dos.vehiculo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import entrega.dos.Main;
import entrega.dos.persona.PanelGrillaPersonas;
import entrega.dos.persona.Persona;
import entrega.dos.vehiculo_persona.VehiculoPersona;

public class PanelGrillaVehiculoPersona extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static List<Vehiculo> vehiculos;
	private TableModel dataModel;
	private JTable table;
	private static JScrollPane scrollpane;
	public static JPanel botones;
	private JButton botonAgregar, botonDetalle;
	private static String filtroNombre = "", filtroColor = "", filtroTipoVehiculo = "Todos";
	private VehiculoPersona vehiculoPersona;
	private boolean vehiculosDePersona;
	private Main frame;

	/**
	 * Create the panel.
	 * 
	 * @param frame
	 * @param vehiculosDePersona
	 */

	public PanelGrillaVehiculoPersona(Main frame, VehiculoPersona vehiculoPersona, boolean vehiculosDePersona) {
		this.frame = frame;
		this.vehiculoPersona = vehiculoPersona;
		this.vehiculosDePersona = vehiculosDePersona;
		init();
	}

	public PanelGrillaVehiculoPersona(Main frame) {
		this.frame = frame;
		this.vehiculoPersona = null;
		init();
	}

	private void init() {
		// TODO Auto-generated method stub

		setLayout(new BorderLayout());

		JPanel filtrosJPanel = new JPanel();
		filtrosJPanel.setBackground(Color.BLACK);
		filtrosJPanel.setPreferredSize(new Dimension(900, 180));

		PanelFiltrosGrillaVehiculosPersona panelFiltrosGrillaVehiculosPersona = new PanelFiltrosGrillaVehiculosPersona();
		filtroNombre = "";
		filtroColor = "";
		filtroTipoVehiculo = "Todos";

		JLabel iconLabel = new JLabel();
		ImageIcon icono = new ImageIcon("logo_tecno.jpg");
		iconLabel.setIcon(new ImageIcon(icono.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));

		filtrosJPanel.add(iconLabel);
		filtrosJPanel.add(panelFiltrosGrillaVehiculosPersona);

		add(filtrosJPanel, BorderLayout.NORTH);

		if (vehiculosDePersona) {
			vehiculos = vehiculoPersona.getPersona().getVehiculos();
		} else {
			vehiculos = PanelGrillaVehiculos.getVehiculos();
		}

		dataModel = loadDataModel(vehiculos);

		table = new JTable(dataModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		setScrollpane(new JScrollPane(table));
		add(getScrollpane(), BorderLayout.CENTER);

		botones = new JPanel();

		JPanel tituloPanel = new JPanel();
		tituloPanel.setBackground(Color.BLACK);

		if (vehiculosDePersona == false) {

			botonAgregar = new JButton("Agregar");
			botonAgregar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					if (table.getSelectedRow() > -1) {

						boolean yaSeEncuentraAsociado = false;
						for (Persona persona : PanelGrillaPersonas.getPersonas()) {

							if (persona.getVehiculos().indexOf(vehiculos.get(table.getSelectedRow())) > -1) {
								yaSeEncuentraAsociado = true;
								break;
							}
						}

						if (yaSeEncuentraAsociado) {
							JOptionPane.showMessageDialog(table,
									"El vehículo seleccionado ya se encuentra asociado a una persona.", "ERROR",
									JOptionPane.ERROR_MESSAGE, null);
						} else {
							vehiculoPersona.getPersona().getVehiculos().add(vehiculos.get(table.getSelectedRow()));

							PanelGrillaPersonas.actualizarGrillaPersonas();

							vehiculoPersona.dispose();
						}

					} else {
						JOptionPane.showMessageDialog(table, "Debe seleccionar un registro", "ERROR",
								JOptionPane.ERROR_MESSAGE, null);
					}

				}
			});

			botones.add(botonAgregar);
		} else {

			botonDetalle = new JButton("Detalle");
			botonDetalle.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					if (table.getSelectedRow() > -1) {

						JOptionPane.showMessageDialog(table, vehiculos.get(table.getSelectedRow()), "Vehículo",
								JOptionPane.INFORMATION_MESSAGE, null);
					} else {
						JOptionPane.showMessageDialog(table, "Debe seleccionar un registro", "ERROR",
								JOptionPane.ERROR_MESSAGE, null);
					}
				}
			});

			botones.add(botonDetalle);
		}

		add(botones, BorderLayout.SOUTH);
	}

	public TableModel loadDataModel(List<Vehiculo> listaVehiculos) {
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
		PanelGrillaVehiculoPersona.filtroNombre = filtroNombre;
	}

	public static JScrollPane getScrollpane() {
		return scrollpane;
	}

	public static void setScrollpane(JScrollPane scrollpane) {
		PanelGrillaVehiculoPersona.scrollpane = scrollpane;
	}

	public static String getFiltroColor() {
		return filtroColor;
	}

	public static void setFiltroColor(String filtroColor) {
		PanelGrillaVehiculoPersona.filtroColor = filtroColor;
	}

	public static String getFiltroTipoVehiculo() {
		return filtroTipoVehiculo;
	}

	public static void setFiltroTipoVehiculo(String filtroVehiculo) {
		PanelGrillaVehiculoPersona.filtroTipoVehiculo = filtroVehiculo;
	}

	public static List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public Main getFrame() {
		return frame;
	}

	public void setFrame(Main frame) {
		this.frame = frame;
	}

}
