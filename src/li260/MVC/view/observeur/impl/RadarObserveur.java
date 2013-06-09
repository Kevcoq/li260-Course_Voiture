package li260.MVC.view.observeur.impl;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import li260.MVC.view.observeur.Observeur;
import li260.Plateau.geometrie.VTools;
import li260.Plateau.geometrie.Vecteur;
import li260.Plateau.voiture.Voiture;
import li260.Tactique.Radar.Radar;

public class RadarObserveur implements Observeur {
	private Voiture v;
	private Radar r;

	public RadarObserveur(Voiture v, Radar r) {
		super();
		this.v = v;
		this.r = r;
	}

	@Override
	public void print(BufferedImage im) {
		// TODO Auto-generated method stub

	}

	@Override
	public void print(Graphics g) {
		// TODO Auto-generated method stub
		Color purple = new Color(102, 102, 204);
		Color bleu_gris = new Color(102, 170, 204);

		for (int i = 0; i < r.thetas().length; i++) {
			Vecteur dirR = v.getDirection().clonage();
			VTools.rotation(dirR, r.thetas()[i]);
			if (i == r.getBestIndex())
				g.setColor(bleu_gris);
			else
				g.setColor(purple);
			g.drawLine(
					(int) v.getPosition().getX(),
					(int) v.getPosition().getY(),
					(int) (v.getPosition().getX() + VTools.multiplication(dirR,
							r.getPixel()[i]).getX()),
					(int) (v.getPosition().getY() + VTools.multiplication(dirR,
							r.getPixel()[i]).getY()));
		}
	}
}
