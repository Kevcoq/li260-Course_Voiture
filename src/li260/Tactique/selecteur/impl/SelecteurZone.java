package li260.Tactique.selecteur.impl;

import li260.Plateau.circuit.Circuit;
import li260.Plateau.voiture.Voiture;
import li260.Tactique.dijkstra.Dijkstra;
import li260.Tactique.selecteur.Selecteur;

@SuppressWarnings("serial")
public class SelecteurZone implements Selecteur {
	private Dijkstra dijk;
	private Voiture v;
	private double scoreMAX;
	private double d;

	public SelecteurZone(Dijkstra dijk, Voiture v, double d) {
		super();
		this.dijk = dijk;
		this.v = v;
		this.scoreMAX = dijk.getScoreMAX() / 100;
		this.d = d;
	}

	@Override
	public void init(Circuit c, Voiture v) {
		// TODO Auto-generated method stub
		this.v = v;
	}

	@Override
	public boolean isSelected() {
		// TODO Auto-generated method stub
		return ((100 - d) < (dijk.getMap()[(int) v.getPosition().getX()][(int) v
				.getPosition().getY()]) / scoreMAX);
	}

}
