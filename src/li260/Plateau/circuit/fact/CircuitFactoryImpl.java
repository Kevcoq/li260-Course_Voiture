package li260.Plateau.circuit.fact;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import li260.Plateau.circuit.CircuitM;
import li260.Plateau.circuit.Difcolexception;
import li260.Plateau.circuit.impl.CircuitImpl;
import li260.Plateau.circuit.terrain.Terrain;
import li260.Plateau.circuit.terrain.ToolsTerrain;
import li260.Plateau.geometrie.Vecteur;

public class CircuitFactoryImpl implements CircuitFactory {
	private File fichier;
	/* private boolean special; */
	private Vecteur dirDepart = new Vecteur(0, 1);
	private Vecteur dirArrivee = new Vecteur(0, 1);

	public CircuitFactoryImpl(File fichier) {
		// TODO Auto-generated constructor stub
		this.fichier = fichier;
	}

	/*
	 * public CircuitFactory(String filename, boolean special) {
	 * this.filename=filename; this.special=special; }
	 */

	public CircuitFactoryImpl(String filename) {
		this.fichier = new File(filename);
	}

	public CircuitM build() throws Difcolexception {
		// lecture fichier
		try {
			FileReader fr = new FileReader(fichier);
			BufferedReader in = new BufferedReader(fr);
			int nbC = Integer.parseInt(in.readLine());
			int nbL = Integer.parseInt(in.readLine());
			Vecteur depart = null;

			ArrayList<Vecteur> arrivees = new ArrayList<Vecteur>();
			Terrain tab[][] = new Terrain[nbL][nbC];
			for (int i = 0; i < nbL; i++) {
				String buf = in.readLine();
				for (int j = 0; j < nbC; j++) {
					if (buf.length() != nbC) {
						throw new Difcolexception(
								"Nombre de colonnes inconstant !!!");
					}
					tab[i][j] = ToolsTerrain.terrainFromChar(buf.charAt(j));

					if (tab[i][j] == Terrain.StartPoint) {
						depart = new Vecteur(i, j);
					}
					if (tab[i][j] == Terrain.EndLine) {
						arrivees.add(new Vecteur(i, j));
					}
				}
			}
			in.close();
			return new CircuitImpl(tab, depart, dirDepart, dirArrivee, arrivees);
		} catch (FileNotFoundException e) {
			System.err.println("Unable to find ");
			return null;
		} catch (IOException e) {
			System.err.println("Can't open file "
					+ " for reading... Loading aborted");
			return null;
		} catch (Difcolexception e) {
			System.err.println(e);
			return null;
		} catch (Exception e) {
			System.err.println("Invalid Format : " + "... Loading aborted");
			return null;

		}
	}
}
