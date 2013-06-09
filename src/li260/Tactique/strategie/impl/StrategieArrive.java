package li260.Tactique.strategie.impl;

import li260.Plateau.circuit.Circuit;
import li260.Plateau.geometrie.VTools;
import li260.Plateau.geometrie.Vecteur;
import li260.Plateau.voiture.Voiture;
import li260.Plateau.voiture.commande.Commande;
import li260.Tactique.selecteur.Selecteur;
import li260.Tactique.selecteur.impl.SelecteurArrive;
import li260.Tactique.strategie.Strategie;
import li260.mains.TestFile;

@SuppressWarnings("serial")
public class StrategieArrive implements Strategie {
	private Selecteur select;
	private transient Circuit c;
	private transient Voiture v;
	private int pixel = 0;
	private Vecteur dir = new Vecteur(0, 0);

	private static final double coeff = 1;

	public StrategieArrive(Circuit c, Voiture v, Selecteur select) {
		super();
		this.c = c;
		this.v = v;
		this.select = select;
	}

	private void direction() {
		int[] score = ((SelecteurArrive) select).getScore();
		int bestIndex = 0;
		for (int i = 1; i < score.length; i++)
			if (score[bestIndex] > score[i])
				bestIndex = i;

		pixel = ((int) (score[bestIndex] * TestFile.pas));
		dir = new Vecteur(v.getPosition(), c.getArrivees().get(bestIndex*TestFile.arrivee));
	}

	@Override
	public Commande getCommande() {
		// TODO Auto-generated method stub
		direction();
		double turn = (VTools.angle(v.getDirection(), VTools.unitaire(dir)))
				/ v.getBraquage();
		double acc;
		if (turn > 1) {
			turn = 1;
			acc = -1;
		}
		if (turn < -1) {
			turn = -1;
			acc = -1;
		}

		if (Math.abs(turn) > Math.PI / 4)
			acc = -1 * coeff * Math.abs(turn);
		else
			acc = 1 - coeff * Math.abs(turn);
		// if(v.getVitesse()<TestFile.minAcc && acc<TestFile.minAcc) {
		// acc=TestFile.minAcc;
		// }
		//
		// double turnAbs = Math.min( Math.abs(turn),
		// v.getMaxTurnSansDerapage());
		// return new Commande(turnAbs * Math.signum(turn), acc);
		return new Commande(turn, acc);
	}

	public Vecteur getDir() {
		return dir;
	}

	public int getPixel() {
		return pixel;
	}

	@Override
	public void init(Circuit c, Voiture v) {
		// TODO Auto-generated method stub
		this.c = c;
		this.v = v;
		select.init(c, v);
	}
}
