package li260.Plateau.circuit;

import java.util.ArrayList;

import li260.Plateau.circuit.zone.Zone;
import li260.Plateau.geometrie.Vecteur;
import li260.Plateau.obstacle.Obstacle;
import li260.Plateau.obstacle.ObstacleZone;
import li260.Tactique.dijkstra.Dijkstra;

public interface CircuitExtends extends Circuit {
	public Circuit getCircuit();
	
	public Dijkstra getDijk();
	
	public void setDijk(Dijkstra dijk);
	
	public void addObst(Obstacle o);

	public ArrayList<Obstacle> getObst();

	public void addZone(ObstacleZone z);

	public ArrayList<ObstacleZone> getZone();

	public Zone quelZone(int i, int j);

	public Zone quelZone(Vecteur p);
}
