package li260.InterfaceGraphique.JPanel.Menu.delegation;

import java.util.ArrayList;

import li260.MVC.view.observeur.impl.DijkstraObserveur;
import li260.MVC.view.observeur.impl.ListePointObserveur;
import li260.MVC.view.observeur.impl.VoitureObserveur;
import li260.Plateau.geometrie.Vecteur;
import li260.mains.tools.Jeu;

public class ObservJPanel {
	private Jeu jeu;

	public ObservJPanel(Jeu jeu) {
		// TODO Auto-generated constructor stub
		super();
		this.jeu = jeu;
	}

	public DijkstraObserveur dijk() {
		// TODO Auto-generated method stub
		return new DijkstraObserveur(jeu.getC().getDijk());
	}

	public ListePointObserveur listePaP(ArrayList<Vecteur> lPaP) {
		// TODO Auto-generated method stub
		return new ListePointObserveur(lPaP);
	}

	public VoitureObserveur traj() {
		// TODO Auto-generated method stub
		return new VoitureObserveur(jeu.getV());
	}
}
