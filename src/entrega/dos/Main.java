package entrega.dos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entrega.dos.accion_menu.ActionAcercaDe;
import entrega.dos.dashboard.PanelDashboard;
import entrega.dos.persona.PanelGrillaPersonas;
import entrega.dos.vehiculo.PanelGrillaVehiculos;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel contentPane, grillaPersonas, grillaVehiculos, panelDashboard;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();

					grillaVehiculos = new PanelGrillaVehiculos(frame);
					grillaPersonas = new PanelGrillaPersonas(frame);
					panelDashboard = new PanelDashboard(frame);

					contentPane.add(grillaPersonas);

					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("TecnoCanarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 700);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mainMenu = new JMenu("Menú");
		menuBar.add(mainMenu);

		JMenuItem grillaPersonasMenuItem = new JMenuItem("Grilla personas");
		grillaPersonasMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				changeContentPane(grillaPersonas);
			}
		});
		mainMenu.add(grillaPersonasMenuItem);

		JMenuItem grillaVehiculosMenuItem = new JMenuItem("Grilla vehiculos");
		grillaVehiculosMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				changeContentPane(grillaVehiculos);
			}
		});
		mainMenu.add(grillaVehiculosMenuItem);

		
		JMenuItem panelDashboardMenuItem = new JMenuItem("Dashboard");
		panelDashboardMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeContentPane(panelDashboard);
			}
		});
		mainMenu.add(panelDashboardMenuItem);
		
		JMenuItem acercaDeMenuItem = new JMenuItem("Acerca de");
		acercaDeMenuItem.addActionListener(new ActionAcercaDe(this));
		mainMenu.add(acercaDeMenuItem);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	private static void changeContentPane(JPanel panel) {
		contentPane.removeAll();
		contentPane.add(panel);
		contentPane.revalidate();
		contentPane.repaint();
	}

}
