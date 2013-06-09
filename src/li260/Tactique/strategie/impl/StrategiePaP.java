package li260.Tactique.strategie.impl;

import li260.Plateau.circuit.Circuit;
import li260.Plateau.geometrie.VTools;
import li260.Plateau.geometrie.Vecteur;
import li260.Plateau.voiture.Voiture;
import li260.Plateau.voiture.commande.Commande;
import li260.Tactique.selecteur.Selecteur;
import li260.Tactique.selecteur.impl.SelecteurPaP;
import li260.Tactique.strategie.Strategie;

@SuppressWarnings("serial")
public class StrategiePaP implements Strategie {
	private transient Voiture v;
	private SelecteurPaP s;
	private Vecteur dir;

	public StrategiePaP(Voiture v, Selecteur s) {
		super();
		this.v = v;
		this.s = (SelecteurPaP) s;
		dir = null;
	}

	private Vecteur direction() {
		return new Vecteur(v.getPosition(), s.getListeP().get(0));
	}

	@Override
	public Commande getCommande() {
		// TODO Auto-generated method stub
		dir = direction();
		double turn = (VTools.angle(v.getDirection(), dir)) / v.getBraquage();
		double acc = 1;
		if (turn > 1) {
			turn = 1;
			acc = -1;
		}
		if (turn < -1) {
			turn = -1;
			acc = -1;
		}

		if (Math.abs(turn) > Math.PI / 8)
			acc = 0;

		return new Commande(turn, acc);
	}

	public Vecteur getDir() {
		return dir;
	}

	public int getPixel() {
		return s.getPixel();
	}

	@Override
	public void init(Circuit c, Voiture v) {
		// TODO Auto-generated method stub
		this.v = v;
		s.init(c, v);
	}

}