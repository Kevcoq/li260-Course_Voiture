package li260.Tactique.selecteur.impl;

import li260.Plateau.circuit.Circuit;
import li260.Plateau.circuit.terrain.Terrain;
import li260.Plateau.circuit.terrain.ToolsTerrain;
import li260.Plateau.geometrie.VTools;
import li260.Plateau.geometrie.Vecteur;
import li260.Plateau.voiture.Voiture;
import li260.Tactique.selecteur.Selecteur;
import li260.mains.TestFile;

@SuppressWarnings("serial")
public class SelecteurArrive implements Selecteur {
	private transient Voiture v;
	private transient Circuit c;
	private boolean[] tblB;
	private int[] score;


	public SelecteurArrive(Voiture v, Circuit c) {
		super();
		this.v = v;
		this.c = c;
		this.tblB = new boolean[c.getArrivees().size() / TestFile.arrivee];
		this.score = new int[c.getArrivees().size() / TestFile.arrivee];
	}

	public int[] getScore() {
		return score;
	}

	@Override
	public void init(Circuit c, Voiture v) {
		// TODO Auto-generated method stub
		this.c = c;
		this.v = v;
	}

	@Override
	public boolean isSelected() {
		// TODO Auto-generated method stub
		visible();
		for (int i = 0; i < tblB.length; i++) {
			if (tblB[i]) {
				return true;
			}
		}
		return false;
	}

	private void visible() {
		for (int i = 0; i < tblB.length; i++) {
			int cpt = -1;
			score[i] = Integer.MAX_VALUE;
			tblB[i] = false;

			Vecteur pos = v.getPosition().clonage();
			Vecteur dir = VTools.unitaire(new Vecteur(pos, c.getArrivees().get(
					i * TestFile.arrivee)));

			if (VTools.prodScal(dir, c.getDirectionArrivee()) >= 0) {
				// Modification valable pour dijkstra
				if (VTools.prodScal(v.getDirection(), c.getDirectionArrivee()) >= 0) {
					do {
						cpt++;
						VTools.additionC(pos,
								VTools.multiplication(dir, TestFile.pas));
						if (c.getTerrain(pos) == Terrain.EndLine) {
							tblB[i] = true;
							score[i] = cpt;
							break;
						}
					} while (ToolsTerrain.getValide(c, pos));
				}
			}
		}
	}
}