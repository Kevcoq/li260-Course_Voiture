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
import li260.Tactique.strategie.impl.StrategieArrive;

public class ArriveObserveur implements Observeur {
	private Voiture v;
	private Strategie stratA;

	public ArriveObserveur(Voiture v, Strategie sArrive) {
		this.v = v;
		if (sArrive instanceof StratDecorateur)
			this.stratA = ((StratDecorateur) sArrive).getStrat();
		else
			this.stratA = sArrive;
	}

	@Override
	public void print(BufferedImage im) {
		// TODO Auto-generated method stub

	}

	@Override
	public void print(Graphics g) {
		// TODO Auto-generated method stub
		Vecteur dir = VTools.unitaire(((StrategieArrive) stratA).getDir()
				.clonage());
		int pix = ((StrategieArrive) stratA).getPixel();
		g.setColor(Color.MAGENTA);
		g.drawLine((int) v.getPosition().getX(), (int) v.getPosition().getY(),
				(int) (v.getPosition().getX() + VTools.multiplication(dir, pix)
						.getX()), (int) (v.getPosition().getY() + VTools
						.multiplication(dir, pix).getY()));
	}
}
