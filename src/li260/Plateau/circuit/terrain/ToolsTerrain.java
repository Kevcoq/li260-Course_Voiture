package li260.Plateau.circuit.terrain;

import java.awt.Color;

import li260.Plateau.circuit.Circuit;
import li260.Plateau.geometrie.Vecteur;

public class ToolsTerrain {
	private static Color vert = new Color(0, 102, 0);
	private static Color marron = new Color(88, 41, 0);

	public static int colorFromTerrain(Terrain t) {
		switch (t) {
		case Herbe:
			return vert.getRGB();
		case Eau:
			return Color.blue.getRGB();
		case Route:
			return Color.darkGray.getRGB();
		case BandeBlanche:
			return Color.white.getRGB();
		case BandeRouge:
			return Color.red.getRGB();
		case StartPoint:
			return Color.orange.getRGB();
		case EndLine:
			return Color.cyan.getRGB();
		case Obstacle:
			return Color.yellow.getRGB();
		case Boue:
			return marron.getRGB();
		default:
			return Color.black.getRGB();
		}
	}

	public static boolean estValide(Terrain t) {
		return t == Terrain.Route || t == Terrain.BandeBlanche
				|| t == Terrain.BandeRouge || t == Terrain.EndLine
				|| t == Terrain.StartPoint || t == Terrain.Boue;
	}

	public static boolean getValide(Circuit c, int i, int j) {
		/*
		 * if(((CircuitM) c).getSpecial()) return ((CircuitM)
		 * c).getTerrain()[i][j]==Terrain.Route || ((CircuitM)
		 * c).getTerrain()[i][j]==Terrain.EndLine || ((CircuitM)
		 * c).getTerrain()[i][j]==Terrain.StartPoint; else
		 */
		return c.getTerrain(i, j) == Terrain.Route
				|| c.getTerrain(i, j) == Terrain.BandeBlanche
				|| c.getTerrain(i, j) == Terrain.BandeRouge
				|| c.getTerrain(i, j) == Terrain.EndLine
				|| c.getTerrain(i, j) == Terrain.StartPoint
				|| c.getTerrain(i, j) == Terrain.Boue;
	}

	public static boolean getValide(Circuit c, Vecteur p) {
		return getValide(c, (int) p.getX(), (int) p.getY());
	}

	public static Terrain terrainFromChar(char c) {
		switch (c) {
		case 'g':
			return Terrain.Herbe;
		case 'b':
			return Terrain.Eau;
		case '.':
			return Terrain.Route;
		case 'w':
			return Terrain.BandeBlanche;
		case 'r':
			return Terrain.BandeRouge;
		case '*':
			return Terrain.StartPoint;
		case '!':
			return Terrain.EndLine;
		case 'm':
			return Terrain.Boue;
		default:
			return Terrain.Obstacle;
		}
	}

	public static Terrain terrainFromColor(int c) {

		if (c == vert.getRGB())
			return Terrain.Herbe;
		if (c == Color.blue.getRGB())
			return Terrain.Eau;
		if (c == Color.darkGray.getRGB())
			return Terrain.Route;
		if (c == Color.white.getRGB())
			return Terrain.BandeBlanche;
		if (c == Color.red.getRGB())
			return Terrain.BandeRouge;
		if (c == Color.orange.getRGB())
			return Terrain.StartPoint;
		if (c == Color.cyan.getRGB())
			return Terrain.EndLine;
		if (c == Color.yellow.getRGB())
			return Terrain.Obstacle;
		if (c == marron.getRGB())
			return Terrain.Boue;
		else
			return Terrain.Obstacle;
	}
}
