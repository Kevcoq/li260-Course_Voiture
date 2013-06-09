package li260.Plateau.circuit.impl;

import java.util.ArrayList;

import li260.Plateau.circuit.Circuit;
import li260.Plateau.circuit.zone.Zone;
import li260.Plateau.geometrie.Vecteur;
import li260.Plateau.obstacle.ObstacleZone;

@SuppressWarnings("serial")
public class CircuitZone extends CircuitDeco {
	private ArrayList<ObstacleZone> zone;
	
	public CircuitZone(Circuit c) {
		super(c);
		// TODO Auto-generated constructor stub
		zone = new ArrayList<ObstacleZone>();
	}

	public void addZone(ObstacleZone z) {
		zone.add(z);
	}

	public ArrayList<ObstacleZone> getZone() {
		return zone;
	}
	
	public Zone quelZone(int i, int j) {
		// TODO Auto-generated method stub
		for (ObstacleZone z : zone)
			if (i >= z.getX() && i <= z.getX2() && j >= z.getY()
					&& j <= z.getY2())
				return z.getZone();
		return Zone.Normal;
		
	}


	public Zone quelZone(Vecteur p) {
		// TODO Auto-generated method stub
		return quelZone((int) p.getX(), (int) p.getY());
	}
}
