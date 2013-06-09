package li260.InterfaceGraphique.JPanel.Menu.Item;

import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;

import li260.InterfaceGraphique.action.listener.Controleur;

public class ItemVitesse {
	private Controleur cjp;

	public ItemVitesse(Controleur cjp) {
		super();
		this.cjp = cjp;
	}

	public JMenu item() {
		JMenu vitesse = new JMenu("Vitesse");

		JRadioButtonMenuItem lent = new JRadioButtonMenuItem("Lent");
		lent.addActionListener(cjp);
		JRadioButtonMenuItem moyenne = new JRadioButtonMenuItem("Moyenne");
		moyenne.addActionListener(cjp);
		JRadioButtonMenuItem rapide = new JRadioButtonMenuItem("Rapide");
		rapide.addActionListener(cjp);

		rapide.setSelected(true);
		vitesse.add(lent);
		vitesse.add(moyenne);
		vitesse.add(rapide);
		return vitesse;
	}
}
