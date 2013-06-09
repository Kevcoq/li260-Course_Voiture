package li260.InterfaceGraphique.JPanel.Menu.Item;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import li260.InterfaceGraphique.action.listener.Controleur;

public class ItemChargement {
	private Controleur cjp;

	public ItemChargement(Controleur cjp) {
		super();
		this.cjp = cjp;
	}

	public JMenu item() {
		JMenu charg = new JMenu("Chargement");

		JMenuItem circuit = new JMenuItem("Charg Circuit");
		JMenuItem strategie = new JMenuItem("Charg Strategie");

		circuit.addActionListener(cjp);
		strategie.addActionListener(cjp);

		charg.add(circuit);
		charg.add(strategie);

		return charg;
	}
}
