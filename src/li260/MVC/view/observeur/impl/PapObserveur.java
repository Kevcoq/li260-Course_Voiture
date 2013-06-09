package li260.MVC.view.observeur.impl;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import li260.MVC.view.observeur.Observeur;
import li260.Plateau.geometrie.VTools;
import li260.Plateau.geometrie.Vecteur;
import li260.Plateau.voiture.Voiture;
import li260.Tactique.strategie.Strategie;
import li260.Tactique.strategie.impl.StratDecorateur;
import li260.Tactique.strategie.impl.StrategiePaP;

public class PapObserveur implements Observeur {
	private Voiture v;
	private Strategie sPaP;

	public PapObserveur(Voiture v, Strategie sPaP) {
		super();
		this.v = v;
		if (sPaP instanceof StratDecorateur)
			this.sPaP = ((StratDecorateur) sPaP).getStrat();
		else
			this.sPaP = sPaP;
	}

	@Override
	public void print(BufferedImage im) {
		// TODO Auto-generated method stub

	}

	@Override
	public void print(Graphics g) {
		// TODO Auto-generated method stub
		Vecteur dir = ((StrategiePaP) sPaP).getDir();
		int pix = ((StrategiePaP) sPaP).getPixel();
		g.setColor(Color.MAGENTA);
		g.drawLine((int) v.getPosition().getX(), (int) v.getPosition().getY(),
				(int) (v.getPosition().getX() + VTools.multiplication(dir, pix)
						.getX()), (int) (v.getPosition().getY() + VTools
						.multiplication(dir, pix).getY()));

	}
}
