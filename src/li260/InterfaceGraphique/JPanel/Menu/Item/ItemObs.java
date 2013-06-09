package li260.InterfaceGraphique.JPanel.Menu.Item;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import li260.InterfaceGraphique.action.listener.Controleur;

public class ItemObs {
	private Controleur cjp;
	
	public ItemObs(Controleur cjp) {
		super();
		this.cjp = cjp;
	}

	public JMenu item() {
		JMenu obs = new JMenu("Observeur");
		JMenuItem statique = new JMenuItem("Statique");
		statique.addActionListener(cjp);
		statique.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				InputEvent.SHIFT_MASK));

		JMenu swing = new JMenu("SWING");

		JCheckBoxMenuItem base = new JCheckBoxMenuItem("Base");
		base.addActionListener(cjp);

		JCheckBoxMenuItem traj = new JCheckBoxMenuItem("Trajectoire");
		traj.addActionListener(cjp);

		JCheckBoxMenuItem dijkstra = new JCheckBoxMenuItem("Dijkstra");
		dijkstra.addActionListener(cjp);

		JCheckBoxMenuItem listePaP = new JCheckBoxMenuItem("Liste de points");
		listePaP.addActionListener(cjp);
		swing.add(base);
		swing.add(traj);
		swing.add(dijkstra);
		swing.add(listePaP);

		base.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
				InputEvent.SHIFT_MASK));
		traj.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,
				InputEvent.SHIFT_MASK));
		dijkstra.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,
				InputEvent.SHIFT_MASK));

		obs.add(statique);
		obs.add(swing);
		return obs;
	}
}
