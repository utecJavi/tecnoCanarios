package entrega.dos.accion_menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ActionAcercaDe implements ActionListener {

	private JFrame main ;
	public ActionAcercaDe(JFrame main) {
		this.main = main;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(main, "TecnoCanarios", "TecnoCanarios", JOptionPane.INFORMATION_MESSAGE, null);
	}

}
