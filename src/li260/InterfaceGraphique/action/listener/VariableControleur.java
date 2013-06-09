package li260.InterfaceGraphique.action.listener;

import java.util.ArrayList;

import li260.InterfaceGraphique.JPanel.Fenetre;
import li260.Plateau.geometrie.Vecteur;
import li260.mains.tools.IHM;
import li260.mains.tools.Jeu;

public class VariableControleur {
	private Fenetre fen;
	private boolean charger = false;
	private Jeu jeu;
	private IHM gObs = null;
	private ArrayList<Vecteur> lPts;

	
	public VariableControleur (Fenetre fen) {
		this.fen = fen;
		jeu = new Jeu();
		lPts = new ArrayList<Vecteur>();
	}


	public Fenetre getFen() {
		return fen;
	}


	public IHM getgObs() {
		return gObs;
	}


	public Jeu getJeu() {
		return jeu;
	}


	public ArrayList<Vecteur> getlPts() {
		return lPts;
	}


	public boolean isCharger() {
		return charger;
	}


	public void setCharger(boolean charger) {
		this.charger = charger;
	}


	public void setFen(Fenetre fen) {
		this.fen = fen;
	}


	public void setgObs(IHM gObs) {
		this.gObs = gObs;
	}


	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}


	public void setlPts(ArrayList<Vecteur> lPts) {
		this.lPts = lPts;
	}
	
	
	
}
