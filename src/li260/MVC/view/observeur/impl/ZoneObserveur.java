package li260.MVC.view.observeur.impl;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import li260.MVC.view.observeur.Observeur;
import li260.Plateau.circuit.zone.Zone;
import li260.Plateau.obstacle.ObstacleZone;

public class ZoneObserveur implements Observeur {
	private ArrayList<ObstacleZone> zone;

	public ZoneObserveur(ArrayList<ObstacleZone> zone) {
		super();
		this.zone = zone;
	}

	@Override
	public void print(BufferedImage im) {
		// TODO Auto-generated method stub

	}

	@Override
	public void print(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.orange);
		for (ObstacleZone z : zone) {
			if(z.getZone()==Zone.Lent)
				g.setColor(Color.CYAN);
			if(z.getZone()==Zone.Normal)
				g.setColor(Color.GRAY);
			if(z.getZone()==Zone.Rapide)
				g.setColor(Color.RED);
			
			g.drawRect(z.getX(), z.getY(), Math.abs(z.getX() - z.getX2()),
					Math.abs(z.getY() - z.getY2()));
		}
	}
}
