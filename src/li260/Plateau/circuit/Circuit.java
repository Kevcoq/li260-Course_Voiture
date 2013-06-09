package li260.Plateau.circuit;

import java.io.Serializable;
import java.util.ArrayList;

import li260.Plateau.circuit.terrain.Terrain;
import li260.Plateau.geometrie.Vecteur;

public interface Circuit extends Serializable {
	public ArrayList<Vecteur> getArrivees();

	public Vecteur getDirectionArrivee();

	public Vecteur getDirectionDepart();

	public int getHeight();

	public Vecteur getPointDepart();

	public Terrain getTerrain(int i, int j);

	public Terrain getTerrain(Vecteur p);

	public int getWidth();
}
