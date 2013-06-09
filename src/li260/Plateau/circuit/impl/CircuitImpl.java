package li260.Plateau.circuit.impl;

import java.util.ArrayList;

import li260.Plateau.circuit.CircuitM;
import li260.Plateau.circuit.terrain.Terrain;
import li260.Plateau.geometrie.Vecteur;

@SuppressWarnings("serial")
public class CircuitImpl implements CircuitM {
	private Terrain tab[][];
	private Vecteur depart, Ddepart, Darrivees;
	private ArrayList<Vecteur> arrivees;

	/* private boolean special; */

	public CircuitImpl(Terrain[][] tab, Vecteur depart, Vecteur ddepart,
			Vecteur darrivees, ArrayList<Vecteur> arrivees) {
		super();
		this.tab = tab;
		this.depart = depart;
		Ddepart = ddepart;
		Darrivees = darrivees;
		this.arrivees = arrivees;
	}

	@Override
	public ArrayList<Vecteur> getArrivees() {
		// TODO Auto-generated method stub
		return arrivees;
	}

	@Override
	public Vecteur getDirectionArrivee() {
		// TODO Auto-generated method stub
		return Darrivees;
	}

	@Override
	public Vecteur getDirectionDepart() {
		// TODO Auto-generated method stub
		return Ddepart;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return tab[0].length;
	}

	@Override
	public Vecteur getPointDepart() {
		// TODO Auto-generated method stub
		return depart;
	}

	@Override
	public boolean getSpecial() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Terrain[][] getTerrain() {
		// TODO Auto-generated method stub
		return tab;
	}

	@Override
	public Terrain getTerrain(int d, int e) {
		// TODO Auto-generated method stub
		return tab[d][e];
	}

	/*
	 * public boolean getSpecial() { return special; }
	 */

	@Override
	public Terrain getTerrain(Vecteur p) {
		// TODO Auto-generated method stub
		return getTerrain((int) p.getX(), (int) p.getY());
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return tab.length;
	}
}
