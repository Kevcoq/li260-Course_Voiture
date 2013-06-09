package li260.InterfaceGraphique.JPanel.Menu.Item;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import li260.InterfaceGraphique.action.listener.Controleur;

public class ItemCircuit {
	private Controleur cjp;
	
	public ItemCircuit(Controleur cjp) {
		super();
		this.cjp = cjp;
	}

	public JMenu item() {
		JMenu circ = new JMenu("Circuit");
		JMenuItem c1 = new JMenuItem("1");
		c1.addActionListener(cjp);
		c1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,
				InputEvent.CTRL_MASK));

		JMenuItem c2 = new JMenuItem("2");
		c2.addActionListener(cjp);
		c2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,
				InputEvent.CTRL_MASK));

		JMenuItem c3 = new JMenuItem("3");
		c3.addActionListener(cjp);
		c3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3,
				InputEvent.CTRL_MASK));

		JMenuItem c4 = new JMenuItem("4");
		c4.addActionListener(cjp);
		c4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4,
				InputEvent.CTRL_MASK));

		JMenuItem c5 = new JMenuItem("5");
		c5.addActionListener(cjp);
		c5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5,
				InputEvent.CTRL_MASK));

		JMenuItem c6 = new JMenuItem("6");
		c6.addActionListener(cjp);
		c6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_6,
				InputEvent.CTRL_MASK));

		JMenuItem c7 = new JMenuItem("7");
		c7.addActionListener(cjp);
		c7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_7,
				InputEvent.CTRL_MASK));

		JMenuItem c8 = new JMenuItem("8");
		c8.addActionListener(cjp);
		c8.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_8,
				InputEvent.CTRL_MASK));

		JMenuItem c9 = new JMenuItem("aufeu");
		c9.setActionCommand("9");
		c9.addActionListener(cjp);
		c9.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_9,
				InputEvent.CTRL_MASK));

		JMenuItem c10 = new JMenuItem("bond_safe");
		c10.setActionCommand("10");
		c10.addActionListener(cjp);
		c10.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_0,
				InputEvent.CTRL_MASK));

		JMenuItem c11 = new JMenuItem("Een2");
		c11.setActionCommand("11");
		c11.addActionListener(cjp);
		// c11.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_9,InputEvent.CTRL_MASK));

		JMenuItem c12 = new JMenuItem("labymod");
		c12.setActionCommand("12");
		c12.addActionListener(cjp);
		// c9.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_9,
		// InputEvent.CTRL_MASK));

		JMenuItem c13 = new JMenuItem("labyperso");
		c13.setActionCommand("13");
		c13.addActionListener(cjp);
		// c11.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_9,InputEvent.CTRL_MASK));

		JMenuItem c14 = new JMenuItem("perso");
		c14.setActionCommand("14");
		c14.addActionListener(cjp);
		// c9.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_9,
		// InputEvent.CTRL_MASK));

		JMenuItem c15 = new JMenuItem("t2009");
		c15.setActionCommand("15");
		c15.addActionListener(cjp);
		// c11.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_9,InputEvent.CTRL_MASK));

		JMenuItem c16 = new JMenuItem("t260_safe");
		c16.setActionCommand("16");
		c16.addActionListener(cjp);
		// c9.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_9,
		// InputEvent.CTRL_MASK));

		circ.add(c1);
		circ.add(c2);
		circ.add(c3);
		circ.add(c4);
		circ.add(c5);
		circ.add(c6);
		circ.add(c7);
		circ.add(c8);
		circ.add(c9);
		circ.add(c10);
		circ.add(c11);
		circ.add(c12);
		circ.add(c13);
		circ.add(c14);
		circ.add(c15);
		circ.add(c16);
		return circ;
	}
}
