package li260.MVC.view.observeur.impl;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import li260.MVC.view.observeur.Observeur;
import li260.Tactique.selecteur.Selecteur;

public class SelecteurObserveur implements Observeur {
	private ArrayList<Selecteur> lSelect;
	private ArrayList<Observeur> lSWING;

	public SelecteurObserveur() {
		lSWING = new ArrayList<Observeur>();
		lSelect = new ArrayList<Selecteur>();
	}

	public void add(Observeur str, Selecteur select) {
		lSWING.add(str);
		lSelect.add(select);
	}

	@Override
	public void print(BufferedImage im) {
		// TODO Auto-generated method stub

	}

	@Override
	public void print(Graphics g) {
		for (int i = 0; i < lSWING.size(); i++)
			if (lSelect.get(i).isSelected()) {
				lSWING.get(i).print(g);
				break;
			}
	}

}
