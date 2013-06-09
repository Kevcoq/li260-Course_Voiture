package li260.InterfaceGraphique.JPanel.Menu.delegation;

import java.util.ArrayList;

import li260.InterfaceGraphique.JPanel.Menu.Strat.SsoCrea;
import li260.Plateau.geometrie.Vecteur;
import li260.mains.tools.IHM;
import li260.mains.tools.Jeu;

public class StratJPanel {
	private Jeu jeu;
	private IHM ihm = null;
	private ArrayList<Vecteur> list;

	private static String[] stringStrat = { "Selection", "Rd Dijkstra",
			"Rd Classique", "Arrive", "Point a Point", "Liste de cmd" };
	private static String[] stringSelect = { "Automatique", "Selecteur Zone" };

	public static String[] getStringSelect() {
		return stringSelect;
	}

	public static String[] getStringStrat() {
		return stringStrat;
	}

	public StratJPanel(Jeu jeu, IHM ihm, ArrayList<Vecteur> list) {
		super();
		this.jeu = jeu;
		this.ihm = ihm;
		this.list = list;
	}

	public void choixStrat() {
		SsoCrea sso = new SsoCrea(jeu, list);
		sso.creer();
		jeu.setStrat(sso.getStrat());
		ihm.getObs().add(sso.getObs());
	}
}
