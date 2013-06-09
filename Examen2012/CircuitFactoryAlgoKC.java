package li260.Examen2012;

import java.io.IOException;
import java.util.ArrayList;

import li260.Plateau.circuit.Circuit;
import li260.Plateau.circuit.Difcolexception;
import li260.Plateau.circuit.fact.CircuitFactory;
import li260.Plateau.circuit.impl.CircuitImpl;
import li260.Plateau.circuit.terrain.Terrain;
import li260.Plateau.geometrie.Vecteur;

public class CircuitFactoryAlgoKC implements CircuitFactory {
	private int sizeX, sizeY, bordure;
	private Vecteur depart, dirDepart = new Vecteur(0, 1),
			dirArrivee = new Vecteur(0, 1);
	private ArrayList<Vecteur> arrivees = new ArrayList<Vecteur>();

	public CircuitFactoryAlgoKC() {
		super();
		this.sizeX = 600;
		this.sizeY = 600;
		this.bordure = 20;
	}

	@Override
	public Circuit build() throws IOException, Difcolexception {
		// TODO Auto-generated method stub
		Terrain track[][] = new Terrain[sizeX][sizeY];
		for (int i = 0; i < sizeX; i++)
			for (int j = 0; j < sizeY; j++) {
				if (i < bordure || j < bordure || i > sizeX - bordure
						|| j > sizeY - bordure)
					track[i][j] = Terrain.Herbe;
				else
					track[i][j] = Terrain.Route;
			}

		depart = new Vecteur(bordure + 10, bordure + 10);
		track[(int) depart.getX()][(int) depart.getY()] = Terrain.StartPoint;

		for (int i = 0; i < 20; i++) {
			track[300 - i][300] = Terrain.EndLine;
			arrivees.add(new Vecteur(300-i, 300));
		}

		double a = 1, b = 0;
		int nbPas = 10000;

		for (int i = 1; i < nbPas; i++) {
			double thetas = i * Math.PI * 10 / (double) nbPas, phi = a * thetas
					+ b;
			int x = (int) (phi * Math.cos(thetas) * 8 + 300), y = (int) (phi
					* Math.sin(thetas) * 8 + 300);

			track[x][y] = Terrain.Herbe;
			for (int j = 0; j < 2; j++) {
				track[x + j][y] = Terrain.Herbe;
				track[x][y + j] = Terrain.Herbe;
			}
		}
		
		return new CircuitImpl(track, depart, dirDepart, dirArrivee, arrivees);
	}

}
