package li260.MVC.view.observeur.impl;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import li260.MVC.view.observeur.Observeur;
import li260.Plateau.obstacle.Obstacle;

public class ObstacleObserveur implements Observeur {
	private ArrayList<Obstacle> obst;

	public ObstacleObserveur(ArrayList<Obstacle> obst) {
		super();
		this.obst = obst;
	}

	@Override
	public void print(BufferedImage im) {
		// TODO Auto-generated method stub

	}

	@Override
	public void print(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.orange);
		for (Obstacle o : obst)
			g.drawRect(o.getX(), o.getY(), Math.abs(o.getX() - o.getX2()),
					Math.abs(o.getY() - o.getY2()));
	}

}
