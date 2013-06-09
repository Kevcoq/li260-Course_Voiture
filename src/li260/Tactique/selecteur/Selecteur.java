package li260.Tactique.selecteur;

import java.io.Serializable;

import li260.Plateau.circuit.Circuit;
import li260.Plateau.voiture.Voiture;

public interface Selecteur extends Serializable {
	public void init(Circuit c, Voiture v);

	public boolean isSelected();
}
