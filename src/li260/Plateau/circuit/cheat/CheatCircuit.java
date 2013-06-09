package li260.Plateau.circuit.cheat;

import li260.Plateau.circuit.Circuit;
import li260.Plateau.circuit.CircuitM;
import li260.Plateau.circuit.terrain.Terrain;
import li260.Plateau.circuit.terrain.ToolsTerrain;

public class CheatCircuit {
	public static void modifCircuit(Circuit c) {
		System.out.println("erf");
		for (int i = 2; i < c.getWidth() - 2; i++)
			for (int j = 2; j < c.getHeight() - 2; j++) {
				if (ToolsTerrain.estValide(c.getTerrain(i, j))) {
					if ((!ToolsTerrain.estValide(c.getTerrain(i - 2, j)) && !ToolsTerrain
							.estValide(c.getTerrain(i + 2, j)))
							|| (!ToolsTerrain.estValide(c.getTerrain(i, j - 2)) && !ToolsTerrain
									.estValide(c.getTerrain(i, j + 2)))) {
						((CircuitM) c).getTerrain()[i][j - 1] = Terrain.Obstacle;
						((CircuitM) c).getTerrain()[i + 1][j + 1] = Terrain.Obstacle;
						((CircuitM) c).getTerrain()[i][j] = Terrain.Obstacle;
						((CircuitM) c).getTerrain()[i - 1][j] = Terrain.Obstacle;
						((CircuitM) c).getTerrain()[i + 1][j] = Terrain.Obstacle;
					}
				}
			}
	}
}
