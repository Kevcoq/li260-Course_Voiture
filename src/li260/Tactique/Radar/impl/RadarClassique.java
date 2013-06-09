package li260.Tactique.Radar.impl;

import li260.Plateau.circuit.Circuit;
import li260.Plateau.circuit.terrain.ToolsTerrain;
import li260.Plateau.geometrie.VTools;
import li260.Plateau.geometrie.Vecteur;
import li260.Plateau.voiture.Voiture;
import li260.Tactique.Radar.Radar;
import li260.mains.TestFile;

@SuppressWarnings("serial")
public class RadarClassique implements Radar {
	protected double[] thetas;
	protected transient Voiture voit;
	protected transient Circuit circ;

	protected int[] pixel;
	protected int[] scores;
	protected int bestIndex;

	public RadarClassique(double[] thetas, Voiture voit, Circuit circ) {
		super();
		this.thetas = thetas;
		this.voit = voit;
		this.circ = circ;
		scores = new int[thetas.length]; // Attribut de la classe
		pixel = new int[thetas.length];
		bestIndex = 0; // attribut de la classe
	}

	public int calcScore(int k) {
		int i = -1;
		Vecteur pos = voit.getPosition().clonage();
		Vecteur dir = voit.getDirection().clonage();
		VTools.rotation(dir, thetas[k]);

		do {
			VTools.additionC(pos, VTools.multiplication(dir, TestFile.pas));
			i++;
		} while (ToolsTerrain.estValide(circ.getTerrain(pos)));
		pixel[k] = (int) (i * TestFile.pas);
		return i;
	}

	@Override
	public int getBestIndex() {
		// TODO Auto-generated method stub
		return bestIndex;
	}

	@Override
	public int[] getPixel() {
		return pixel;
	}

	@Override
	public void init(Circuit c, Voiture v) {
		// TODO Auto-generated method stub
		this.circ = c;
		this.voit = v;
	}

	@Override
	public void scores() {
		// TODO Auto-generated method stub
		for (int i = 0; i < thetas.length; i++) {
			scores[i] = calcScore(i);
			if (scores[i] > scores[bestIndex])
				bestIndex = i;
			if (scores[i] == scores[bestIndex])
				if (pixel[i] > pixel[bestIndex])
					bestIndex = i;
		}
	}

	@Override
	public double[] thetas() {
		// TODO Auto-generated method stub
		return thetas;
	}

}