package li260.Plateau.circuit.tools;

import java.awt.image.BufferedImage;

import li260.Plateau.circuit.Circuit;
import li260.Plateau.circuit.terrain.ToolsTerrain;

public class CstrImage {
	public static BufferedImage buildImage(Circuit c) {

		BufferedImage p = new BufferedImage(c.getWidth(), c.getHeight(),
				BufferedImage.TYPE_INT_ARGB);
		int nbL = c.getHeight(), nbC = c.getWidth();
		for (int j = 0; j < nbL; j++)
			for (int i = 0; i < nbC; i++) {
				// System.out.println(i+" "+j);
				p.setRGB(i, j,
						ToolsTerrain.colorFromTerrain(c.getTerrain(i, j)));
			}
		return p;
	}
}
