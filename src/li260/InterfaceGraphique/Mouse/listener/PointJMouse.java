package li260.InterfaceGraphique.Mouse.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import li260.Plateau.geometrie.Vecteur;
import li260.mains.tools.IHM;

public class PointJMouse implements MouseListener {
	private IHM ihm;
	private ArrayList<Vecteur> lPts;

	public PointJMouse(IHM ihm, ArrayList<Vecteur> lPts) {
		super();
		this.ihm = ihm;
		this.lPts = lPts;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		lPts.add(new Vecteur(e.getX(), e.getY()));
		ihm.getObs().repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
