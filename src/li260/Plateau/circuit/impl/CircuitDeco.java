package li260.Plateau.circuit.impl;

import java.util.ArrayList;

import li260.Plateau.circuit.Circuit;
import li260.Plateau.circuit.CircuitExtends;
import li260.Plateau.circuit.terrain.Terrain;
import li260.Plateau.circuit.zone.Zone;
import li260.Plateau.geometrie.Vecteur;
import li260.Plateau.obstacle.Obstacle;
import li260.Plateau.obstacle.ObstacleZone;
import li260.Tactique.dijkstra.Dijkstra;

@SuppressWarnings("serial")
public class CircuitDeco implements CircuitExtends {
	private Circuit c;
	private ArrayList<Obstacle> obst;
	private transient Dijkstra dijk;

	public CircuitDeco(Circuit c) {
		super();
		this.c = c;
		this.obst = new ArrayList<Obstacle>();
		dijk = new Dijkstra(this);
		dijk.calcule();
	}

	public void addObst(Obstacle o) {
		obst.add(o);
	}

	@Override
	public ArrayList<Vecteur> getArrivees() {
		// TODO Auto-generated method stub
		ArrayList<Vecteur> lv = c.getArrivees();
		for (Vecteur test : lv)
			if (getTerrain(test) == Terrain.Obstacle)
				lv.remove(test);
		return lv;
	}

	@Override
	public Dijkstra getDijk() {
		// TODO Auto-generated method stub
		return dijk;
	}

	@Override
	public Vecteur getDirectionArrivee() {
		// TODO Auto-generated method stub
		return c.getDirectionArrivee();
	}

	@Override
	public Vecteur getDirectionDepart() {
		// TODO Auto-generated method stub
		return c.getDirectionDepart();
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return c.getHeight();
	}

	public ArrayList<Obstacle> getObst() {
		return obst;
	}

	@Override
	public Vecteur getPointDepart() {
		// TODO Auto-generated method stub
		return c.getPointDepart();
	}

	@Override
	public Terrain getTerrain(int i, int j) {
		// TODO Auto-generated method stub
		for (Obstacle o : obst)
			if (i >= o.getX() && i <= o.getX2() && j >= o.getY()
					&& j <= o.getY2())
				return Terrain.Obstacle;
		return c.getTerrain(i, j);
	}

	@Override
	public Terrain getTerrain(Vecteur p) {
		// TODO Auto-generated method stub
		return getTerrain((int) p.getX(), (int) p.getY());
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return c.getWidth();
	}

	@Override
	public void setDijk(Dijkstra dijk) {
		// TODO Auto-generated method stub
		this.dijk = dijk;
	}

	@Override
	public Circuit getCircuit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addZone(ObstacleZone z) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<ObstacleZone> getZone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Zone quelZone(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Zone quelZone(Vecteur p) {
		// TODO Auto-generated method stub
		return null;
	}

}
