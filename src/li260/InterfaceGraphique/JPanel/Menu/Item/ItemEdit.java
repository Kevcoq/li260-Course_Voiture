package li260.InterfaceGraphique.JPanel.Menu.Item;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import li260.InterfaceGraphique.action.listener.Controleur;

public class ItemEdit {
	private Controleur cjp;
	
	public ItemEdit(Controleur cjp) {
		super();
		this.cjp = cjp;
	}

	public JMenu item() {
		JMenu edit = new JMenu("Editer");
		JMenu obst = new JMenu("Obstacle");
		JMenuItem cObst = new JMenuItem("Creer obstacle");
		cObst.addActionListener(cjp);
		JMenuItem fObst = new JMenuItem("Retirer Obstacle");
		fObst.addActionListener(cjp);

		cObst.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				InputEvent.CTRL_MASK));
	
		obst.add(cObst);
		obst.add(fObst);

		JMenu zone = new JMenu("Zone");
		JMenuItem cZone = new JMenuItem("Creer zone");
		cZone.addActionListener(cjp);
		JMenuItem fZone = new JMenuItem("Retirer Zone");
		fZone.addActionListener(cjp);

		cZone.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,
				InputEvent.CTRL_MASK));
		
		zone.add(cZone);
		zone.add(fZone);

		JMenu point = new JMenu("Points");
		JMenuItem cLPaP = new JMenuItem("Creer liste de pts");
		cLPaP.addActionListener(cjp);
		JMenuItem rLPaP = new JMenuItem("Retirer liste de pts");
		rLPaP.addActionListener(cjp);
		JMenuItem aLPaP = new JMenuItem("Afficher LPaP");
		aLPaP.addActionListener(cjp);

		cLPaP.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
				InputEvent.SHIFT_MASK));
		rLPaP.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
				InputEvent.SHIFT_MASK));
		aLPaP.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				InputEvent.SHIFT_MASK));

		point.add(cLPaP);
		point.add(rLPaP);
		point.add(aLPaP);

		JMenuItem strat = new JMenuItem("Strategie");
		strat.addActionListener(cjp);

		strat.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				InputEvent.CTRL_MASK));

		edit.add(strat);
		edit.add(obst);
		edit.add(zone);
		edit.add(point);
		return edit;
	}
}
