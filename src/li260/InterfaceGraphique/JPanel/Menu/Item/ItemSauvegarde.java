package li260.InterfaceGraphique.JPanel.Menu.Item;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import li260.InterfaceGraphique.action.listener.Controleur;

public class ItemSauvegarde {
	private Controleur cjp;
	
	public ItemSauvegarde(Controleur cjp) {
		super();
		this.cjp = cjp;
	}

	public JMenu item() {
		JMenu sv = new JMenu("Sauvegarde");

		JMenuItem svpara = new JMenuItem("Sv parametre");
		JMenuItem svcmd = new JMenuItem("Sv Commande");
		JMenuItem circuit = new JMenuItem("Sv Circuit");
		JMenuItem strategie = new JMenuItem("Sv Strategie");

		svcmd.addActionListener(cjp);
		svpara.addActionListener(cjp);
		circuit.addActionListener(cjp);
		strategie.addActionListener(cjp);

		sv.add(svcmd);
		sv.add(svpara);
		sv.add(circuit);
		sv.add(strategie);

		return sv;
	}
}
