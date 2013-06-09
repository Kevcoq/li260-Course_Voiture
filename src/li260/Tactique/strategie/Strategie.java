package li260.Tactique.strategie;

import java.io.Serializable;

import li260.Plateau.circuit.Circuit;
import li260.Plateau.voiture.Voiture;
import li260.Plateau.voiture.commande.Commande;

public interface Strategie extends Serializable {
	public Commande getCommande();

	public void init(Circuit c, Voiture v);
}
