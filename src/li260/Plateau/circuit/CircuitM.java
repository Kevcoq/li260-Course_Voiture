package li260.Plateau.circuit;

import java.util.ArrayList;

import li260.Plateau.circuit.terrain.Terrain;
import li260.Plateau.geometrie.Vecteur;

public interface CircuitM extends Circuit {
	@Override
	public ArrayList<Vecteur> getArrivees();

	@Override
	public Vecteur getDirectionArrivee();

	@Override
	public Vecteur getDirectionDepart();

	@Override
	public int getHeight();

	@Override
	public Vecteur getPointDepart();

	public boolean getSpecial();

	public Terrain[][] getTerrain();

	@Override
	public Terrain getTerrain(int i, int j);

	@Override
	public Terrain getTerrain(Vecteur p);

	@Override
	public int getWidth();
}
