package li260.MVC.view.observeur.impl;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import li260.MVC.view.observeur.Observeur;
import li260.Plateau.geometrie.Vecteur;

public class PointsObserveur implements Observeur {
	private ArrayList<Vecteur> pts;

	public PointsObserveur(ArrayList<Vecteur> pts) {
		super();
		this.pts = pts;
	}

	@Override
	public void print(BufferedImage im) {
		// TODO Auto-generated method stub

	}

	@Override
	public void print(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.green);
		for (Vecteur p : pts)
			g.drawRect((int) p.getX(), (int) p.getY(), 1, 1);
	}
}
