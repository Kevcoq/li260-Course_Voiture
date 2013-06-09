package li260.Plateau.voiture.impl;

import li260.Plateau.geometrie.VTools;
import li260.Plateau.geometrie.Vecteur;
import li260.Plateau.voiture.Voiture;
import li260.Plateau.voiture.VoitureException;
import li260.Plateau.voiture.commande.Commande;
import li260.Plateau.voiture.fact.FerrariFactory;

public class VoitureImpl implements Voiture {
	private double vmax;
	private double alpha_c;
	private double braquage;
	private double alpha_f;
	private double beta_f;
	@SuppressWarnings("unused")
	private double alpha_derapage;
	@SuppressWarnings("unused")
	private double masse;
	@SuppressWarnings("unused")
	private double vitesse_sortie_derapage;
	/*****/
	private double vitesse; // vitesse initiale
	private Vecteur position = null;
	private Vecteur direction = null;

	/*****/

	private double[] tabVitesse = { 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8,
			0.9, 1. };
	private double[] tabTurn = { 1., 1., 0.8, 0.7, 0.6, 0.4, 0.3, 0.2, 0.1,
			0.075 };

	public VoitureImpl(double vmax, double alpha_c, double braquage,
			double alpha_f, double beta_f, double alpha_derapage, double masse,
			double vitesse_sortie_derapage, double vitesse, Vecteur position,
			Vecteur direction) {
		super();
		this.vmax = vmax;
		this.alpha_c = alpha_c;
		this.braquage = braquage;
		this.alpha_f = alpha_f;
		this.beta_f = beta_f;
		this.alpha_derapage = alpha_derapage;
		this.masse = masse;
		this.vitesse_sortie_derapage = vitesse_sortie_derapage;
		this.vitesse = vitesse;
		this.position = position;
		this.direction = direction;
	}

	/*****/

	@Override
	public Voiture clone() {
		FerrariFactory f1 = new FerrariFactory(position, direction);
		Voiture v = f1.build();
		return v;
	}

	@Override
	public void drive(Commande c) throws VoitureException {
		// TODO Auto-generated method stub
		driveSansDerapage(c);
	}

	public void driveSansDerapage(Commande c) {
		// approche normale
		// 1) gestion du volant
		VTools.rotation(direction, c.getTurn() * braquage);

		// 2.1) gestion des frottements

		vitesse -= alpha_f;
		vitesse -= beta_f * vitesse;

		// 2.2) gestion de l'acceleration/freinage

		vitesse += c.getAcc() * alpha_c;

		// 2.3) garanties, bornes...
		VTools.unitaire(direction);

		vitesse = Math.max(0., vitesse); // pas de vitesse négative
		vitesse = Math.min(vmax, vitesse);

		// 3) mise à jour de la position

		VTools.additionC(position, VTools.multiplication(direction, vitesse));
	}
	
	@Override
	public double getBraquage() {
		// TODO Auto-generated method stub
		return braquage;
	}

	@Override
	public boolean getDerapage() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Vecteur getDirection() {
		// TODO Auto-generated method stub
		return direction;
	}

	@Override
	public double getMaxTurnSansDerapage() {
		// TODO Auto-generated method stub
		for (int i = 0; i < tabVitesse.length; i++)
			if (vitesse <= vmax * tabVitesse[i])
				return tabTurn[i];
		return 0;
	}

	@Override
	public Vecteur getPosition() {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public double getVitesse() {
		// TODO Auto-generated method stub
		return vitesse;
	}

	@Override
	public void setPosition(Vecteur vct) {
		// TODO Auto-generated method stub
		position = vct;
	}
}
