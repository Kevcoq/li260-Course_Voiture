package li260.InterfaceGraphique.JPanel.Menu;

import javax.swing.JMenuBar;

import li260.InterfaceGraphique.JPanel.Menu.Item.ItemApp;
import li260.InterfaceGraphique.JPanel.Menu.Item.ItemChargement;
import li260.InterfaceGraphique.JPanel.Menu.Item.ItemCircuit;
import li260.InterfaceGraphique.JPanel.Menu.Item.ItemEdit;
import li260.InterfaceGraphique.JPanel.Menu.Item.ItemFichier;
import li260.InterfaceGraphique.JPanel.Menu.Item.ItemObs;
import li260.InterfaceGraphique.JPanel.Menu.Item.ItemSauvegarde;
import li260.InterfaceGraphique.JPanel.Menu.Item.ItemVitesse;
import li260.InterfaceGraphique.action.listener.Controleur;

public class Menu {
	private Controleur cjp;

	public Menu(Controleur cjp) {
		this.cjp = cjp;
	}
	
	





	

	public JMenuBar jMenuBar() {
		ItemFichier fichier = new ItemFichier(cjp);
		ItemEdit edit = new ItemEdit(cjp);
		ItemCircuit circuit = new ItemCircuit(cjp);
		ItemChargement chargement = new ItemChargement(cjp);
		ItemSauvegarde sauvegarde = new ItemSauvegarde(cjp);
		ItemApp app = new ItemApp(cjp);
		ItemObs obs = new ItemObs(cjp);
		ItemVitesse vitesse = new ItemVitesse(cjp);
		
		
		JMenuBar menu = new JMenuBar();
		menu.add(fichier.item());
		menu.add(edit.item());
		menu.add(circuit.item());
		menu.add(chargement.item());
		menu.add(sauvegarde.item());
		menu.add(app.item());
		menu.add(obs.item());
		menu.add(vitesse.item());
		return menu;
	}

	




}
