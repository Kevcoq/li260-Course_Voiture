package li260.Plateau.voiture;

import li260.Plateau.geometrie.Vecteur;
import li260.Plateau.voiture.commande.Commande;

public interface Voiture {
	public Voiture clone();

	// pour le pilotage
	public void drive(Commande c) throws VoitureException;

	public double getBraquage();

	public boolean getDerapage();

	public Vecteur getDirection();

	public double getMaxTurnSansDerapage();

	public Vecteur getPosition();

	// pour l'observation
	public double getVitesse();

	public void setPosition(Vecteur vct);

}
