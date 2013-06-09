package li260.Plateau.circuit.fact;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import li260.Plateau.circuit.Circuit;
import li260.Plateau.circuit.impl.CircuitImpl;
import li260.Plateau.circuit.terrain.Terrain;
import li260.Plateau.circuit.terrain.ToolsTerrain;
import li260.Plateau.geometrie.Vecteur;

public class CircuitFactoryImpl2 implements CircuitFactory {
	private String filename;
	/* private boolean special; */
	private Vecteur dirDepart = new Vecteur(0, 1);
	private Vecteur dirArrivee = new Vecteur(0, 1);

	public CircuitFactoryImpl2(String filename) {
		this.filename = filename;
	}

	/*
	 * public CircuitFactory2(String filename, boolean special) {
	 * this.filename=filename; this.special=special; }
	 */

	public Circuit build() throws IOException {
		BufferedImage im = ImageIO.read(new File(filename));
		Terrain tab[][];
		Vecteur depart = null;
		ArrayList<Vecteur> arrivees = new ArrayList<Vecteur>();
		int nbC, nbL;
		nbC = im.getWidth();
		nbL = im.getHeight();
		tab = new Terrain[nbC][nbL];

		for (int j = 0; j < nbL; j++)
			for (int i = 0; i < nbC; i++) {
				tab[i][j] = ToolsTerrain.terrainFromColor(im.getRGB(i, j));
				if (tab[i][j] == Terrain.StartPoint) {
					depart = new Vecteur(i, j);
				}
				if (tab[i][j] == Terrain.EndLine) {
					arrivees.add(new Vecteur(i, j));
				}
			}
		return new CircuitImpl(tab, depart, dirDepart, dirArrivee, arrivees);
	}
}