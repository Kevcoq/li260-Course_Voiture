package li260.MVC.view.observeur.impl;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import li260.MVC.view.observeur.Observeur;
import li260.Tactique.dijkstra.Dijkstra;

public class DijkstraObserveur implements Observeur {
	private Dijkstra dijk;
	private BufferedImage im;
	private boolean affiche;

	public DijkstraObserveur(Dijkstra dijk) {
		super();
		this.dijk = dijk;
		im = creer();
		affiche = false;
	}

	private BufferedImage creer() {
		// TODO Auto-generated method stub
		int nbL = dijk.getMap().length, nbC = dijk.getMap()[0].length;
		BufferedImage p = new BufferedImage(nbL, nbC,
				BufferedImage.TYPE_INT_ARGB);
		for (int j = 0; j < nbC; j++)
			for (int i = 0; i < nbL; i++) {
				if (dijk.getMap()[i][j] != Integer.MAX_VALUE) {
					Color coul = new Color(dijk.getMap()[i][j] % 255, 0, 0);
					p.setRGB(i, j, coul.getRGB());
				}
			}
		return p;
	}

	@Override
	public void print(BufferedImage im) {
		if (affiche)
			return;

		affiche = true;
		// TODO Auto-generated method stub
		for (int i = 0; i < dijk.getMap().length; i++)
			for (int j = 0; j < dijk.getMap()[0].length; j++) {
				if (dijk.getMap()[i][j] != Integer.MAX_VALUE) {
					Color coul = new Color(dijk.getMap()[i][j] % 255, 0, 0);
					im.setRGB(i, j, coul.getRGB());
				}
			}
	}

	@Override
	public void print(Graphics g) {
		g.drawImage(im, 0, 0, null);
	}
}
