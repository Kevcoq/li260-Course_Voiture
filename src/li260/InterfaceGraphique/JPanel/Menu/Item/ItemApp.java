package li260.InterfaceGraphique.JPanel.Menu.Item;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

import li260.InterfaceGraphique.action.listener.Controleur;

public class ItemApp {
	private Controleur cjp;
	
	public ItemApp(Controleur cjp) {
		super();
		this.cjp = cjp;
	}

	public JMenu item() {
		JMenu app = new JMenu("Application");

		JMenu lancer = new JMenu("Lancer");
		JRadioButtonMenuItem lssc = new JRadioButtonMenuItem(
				"Sans modif Circuit");
		lssc.addActionListener(cjp);
		lancer.add(lssc);

		JMenuItem play = new JMenuItem("Play");
		play.addActionListener(cjp);
		JMenuItem reset = new JMenuItem("Reset");
		reset.addActionListener(cjp);

		lssc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
				InputEvent.CTRL_MASK));
		play.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
				InputEvent.CTRL_MASK));
		reset.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
				InputEvent.CTRL_MASK));

		app.add(lancer);
		app.add(play);
		app.add(reset);
		return app;
	}
}
