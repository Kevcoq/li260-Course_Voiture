package li260.Tactique.Radar.impl;

import li260.Plateau.circuit.Circuit;
import li260.Plateau.circuit.terrain.ToolsTerrain;
import li260.Plateau.geometrie.VTools;
import li260.Plateau.geometrie.Vecteur;
import li260.Plateau.voiture.Voiture;
import li260.Tactique.dijkstra.Dijkstra;
import li260.mains.TestFile;

@SuppressWarnings("serial")
public class RadarDijkstra extends RadarClassique {
	private transient Dijkstra dijk;

	public RadarDijkstra(double[] thetas, Voiture voit, Circuit circ,
			Dijkstra dijk) {
		super(thetas, voit, circ);
		this.dijk = dijk;
	}

	@Override
	public int calcScore(int k) {
		int cpt = -1, n = Integer.MAX_VALUE;
		Vecteur pos = voit.getPosition().clonage();
		Vecteur dir = voit.getDirection().clonage();
		VTools.rotation(dir, thetas[k]);

		do {
			VTools.additionC(pos, VTools.multiplication(dir, TestFile.pas));
			int i = (dijk.getMap()[(int) pos.getX()][(int) pos.getY()]);
			if (n > i)
				n = i;
			cpt++;
		} while (ToolsTerrain.estValide(circ.getTerrain(pos)));
		pixel[k] = (int) (cpt * TestFile.pas);
		return -n;
	}

	@Override
	public void init(Circuit c, Voiture v) {
		super.init(c, v);
		dijk = new Dijkstra(c);
	}

	@Override
	public String toString() {
		return "Je suis un rd dijk";
	}
}
