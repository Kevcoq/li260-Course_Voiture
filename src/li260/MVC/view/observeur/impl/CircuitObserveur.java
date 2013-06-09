package li260.MVC.view.observeur.impl;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import li260.MVC.view.observeur.Observeur;

public class CircuitObserveur implements Observeur {
	private BufferedImage im;

	public CircuitObserveur(BufferedImage im) {
		super();
		this.im = im;
	}

	@Override
	public void print(BufferedImage im) {
		// TODO Auto-generated method stub

	}

	@Override
	public void print(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(im, 0, 0, null);
	}

}
