package li260.InterfaceGraphique.JPanel.Menu.Item;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import li260.InterfaceGraphique.action.listener.Controleur;

public class ItemFichier {
	private Controleur cjp;
	
	public ItemFichier(Controleur cjp) {
		super();
		this.cjp = cjp;
	}

	public JMenu item() {
		JMenu fichier = new JMenu("Fichier");
		JMenuItem circuit = new JMenuItem("Emplacement circuit");
		circuit.addActionListener(cjp);
		JMenuItem svcmd = new JMenuItem("Emplacement cmd");
		svcmd.addActionListener(cjp);
		JMenuItem svimg = new JMenuItem("Emplacement img");
		svimg.addActionListener(cjp);

		fichier.add(circuit);
		fichier.add(svcmd);
		fichier.add(svimg);
		return fichier;
	}	
}
