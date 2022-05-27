package entrega.dos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel contentPane, grillaPersonas, grillaVehiculos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();

					grillaPersonas = new PanelGrillaPersonas(frame);
					grillaVehiculos = new PanelGrillaVehiculo(frame);

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
		setBounds(100, 100, 900, 600);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mainMenu = new JMenu("Main");
		menuBar.add(mainMenu);

		JMenuItem grillaPersonasMenuItem = new JMenuItem("Grilla personas");
		grillaPersonasMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				contentPane.removeAll();
				contentPane.add(grillaPersonas);

				contentPane.revalidate();
				contentPane.repaint();

			}

		});
		mainMenu.add(grillaPersonasMenuItem);

		JMenuItem grillaVehiculosMenuItem = new JMenuItem("Grilla vehiculos");
		grillaVehiculosMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				contentPane.removeAll();
				contentPane.add(grillaVehiculos);
				
				contentPane.revalidate();
				contentPane.repaint();

			}

		});
		mainMenu.add(grillaVehiculosMenuItem);

		JMenuItem acercaDeMenuItem = new JMenuItem("Acerca de");
		acercaDeMenuItem.addActionListener(new ActionAcercaDe(this));
		mainMenu.add(acercaDeMenuItem);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

	}

}
