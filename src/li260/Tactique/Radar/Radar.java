package li260.Tactique.Radar;

import java.io.Serializable;

import li260.Plateau.circuit.Circuit;
import li260.Plateau.voiture.Voiture;

public interface Radar extends Serializable {
	public int getBestIndex(); // meilleur indice

	public int[] getPixel();

	public void init(Circuit c, Voiture v);

	public void scores(); // score de chaque branche

	public double[] thetas(); // angles de chaque faisceau
}
