package li260.MVC.view.observeur.impl;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import li260.MVC.view.observeur.Observeur;
import li260.Plateau.geometrie.Vecteur;
import li260.Plateau.voiture.Voiture;

public class VoitureObserveur implements Observeur {
	private Voiture v;
	private ArrayList<Vecteur> traj;
	private Color color = Color.yellow;
	private Color colorDerape = Color.red;

	public VoitureObserveur(Voiture voiture) {
		this.v = voiture;
		traj = new ArrayList<Vecteur>();
	}

	public Color getColor() {
		if (v.getDerapage())
			return colorDerape;
		return color;
	}

	public int getX() {
		return (int) v.getPosition().getX();
	}

	public int getY() {
		return (int) v.getPosition().getY();
	}

	@Override
	public void print(BufferedImage im) {
		im.setRGB(getX(), getY(), getColor().getRGB());
	}

	@Override
	public void print(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.white);
		traj.add(v.getPosition().clonage());
		for (int i = 1; i < traj.size(); i++)
			g.drawLine((int) traj.get(i - 1).getX(), (int) traj.get(i - 1)
					.getY(), (int) traj.get(i).getX(), (int) traj.get(i).getY());
	}
}
