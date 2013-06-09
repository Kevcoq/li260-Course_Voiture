package li260.MVC.view.observeur.impl;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import li260.MVC.view.observeur.Observeur;
import li260.Plateau.geometrie.Vecteur;

public class ListePointObserveur implements Observeur {
	private ArrayList<Vecteur> lPaP;

	public ListePointObserveur(ArrayList<Vecteur> lPaP) {
		super();
		this.lPaP = lPaP;
	}

	@Override
	public void print(BufferedImage im) {
		// TODO Auto-generated method stub

	}

	@Override
	public void print(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.orange);
		for (Vecteur a : lPaP)
			g.drawLine((int) a.getX(), (int) a.getY(), (int) a.getX(),
					(int) a.getY());
	}

}
