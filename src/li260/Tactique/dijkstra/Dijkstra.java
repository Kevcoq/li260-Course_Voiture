package li260.Tactique.dijkstra;

import java.awt.Dimension;
import java.util.concurrent.PriorityBlockingQueue;

import javax.swing.JFrame;

import li260.Plateau.circuit.Circuit;
import li260.Plateau.circuit.terrain.Terrain;
import li260.Plateau.circuit.terrain.ToolsTerrain;
import li260.Plateau.geometrie.VTools;
import li260.Plateau.geometrie.Vecteur;

public class Dijkstra {
	private Circuit c;
	private int[][] map;
	private int scoreMAX;
	private PriorityBlockingQueue<Vecteur> pile;
	private Boolean enCour = false;

	public Dijkstra(Circuit c) {
		super();
		this.c = c;
		map = new int[c.getWidth()][c.getHeight()];
		pile = new PriorityBlockingQueue<Vecteur>(1000, new ComparatorDijk(map));
		scoreMAX = 0;
	}

	public void calcule() {
		if (enCour == true)
			return;
		enCour = true;

		JFrame jf = new JFrame("Dijkstra");
		jf.setMinimumSize(new Dimension(100, 100));
		jf.setLocation(300, 300);
		jf.setVisible(true);
		jf.pack();

		for (int i = 0; i < map.length; i++)
			for (int j = 0; j < map[0].length; j++)
				map[i][j] = Integer.MAX_VALUE;

		for (Vecteur a : c.getArrivees()) {
			map[(int) a.getX()][(int) a.getY()] = 0;
			pile.add(a);
		}

		while (pile.size() != 0) {
			Vecteur a = pile.peek();
			maj(a);
		}
		scoreMAX = map[(int) c.getPointDepart().getX()][(int) c
				.getPointDepart().getY()];

		jf.dispose();

		enCour = false;
	}

	public int[][] getMap() {
		return map;
	}

	public int getScoreMAX() {
		return scoreMAX;
	}

	public Vecteur getVect() {
		return pile.peek();
	}

	private void maj(Vecteur p) {
		int coeff = 1;
		int x = (int) p.getX(), y = (int) p.getY();
		for (int i = -1; i <= 1; i++)
			for (int j = -1; j <= 1; j++) {
				if ((i == 0 && j == 0) || (x + i) < 0 || (x + i) > map.length
						|| (y + j) < 0 || (y + j) > map[0].length
						|| !ToolsTerrain.estValide(c.getTerrain(x + i, y + j)))
					continue;
				if (c.getTerrain(x, y) == Terrain.EndLine)
					if (VTools.prodScal(new Vecteur(i, j),
							c.getDirectionArrivee()) >= 0)
						continue;

				int score = map[x][y];

				if (c.getTerrain(x + i, y + j) == Terrain.Boue)
					coeff = 2;
				else
					coeff = 1;

				if (i == j || i == -j)
					score += 14 * coeff;
				else
					score += 10 * coeff;

				if (score < 0) {
					System.out.println(score);
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (map[x + i][y + j] > score) {
					pile.remove(new Vecteur(x + i, y + j));
					map[x + i][y + j] = score;
					pile.add(new Vecteur(x + i, y + j));
				}
			}
		pile.remove(p);
	}
}
