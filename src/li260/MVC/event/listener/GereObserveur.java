package li260.MVC.event.listener;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

import li260.MVC.view.observeur.Observeur;

@SuppressWarnings("serial")
public class GereObserveur extends JPanel implements UpdateEventListener {
	private ArrayList<Observeur> list;
	private BufferedImage image;
	private int cpt = 0;

	public GereObserveur(BufferedImage image) {
		super();
		this.list = new ArrayList<Observeur>();
		this.image = image;
	}

	public void add(Observeur obj) {
		list.add(obj);
	}

	public BufferedImage getImage() {
		return image;
	}

	@Override
	public void manageUpdate() {
		// TODO Auto-generated method stub
		// MISE A JOUR Statique
		for (Observeur o : list)
			if (o != null)
				o.print(image);

		if (cpt % 20 == 0)
			paintImmediately(getBounds());
		cpt++;
	}

	@Override
	public void paint(Graphics g) {
		for (Observeur o : list)
			if (o != null)
				o.print(g);
	}
	
	public void reset() {
		list.clear();
	}
}
