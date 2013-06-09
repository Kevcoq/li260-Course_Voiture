package li260.InterfaceGraphique.Mouse.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import li260.Plateau.obstacle.impl.ObstacleImpl;
import li260.mains.tools.IHM;
import li260.mains.tools.Jeu;

public class ObstacleJMouse implements MouseListener {
	private Jeu jeu;
	private IHM ihm;
	private int x, y, x2, y2;

	public ObstacleJMouse(Jeu jeu, IHM ihm) {
		super();
		this.jeu = jeu;
		this.ihm = ihm;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		jeu.getC().addObst(new ObstacleImpl(e.getX() - 2, e
				.getY() - 2, e.getX() + 2, e.getY() + 2));
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
		x = e.getX();
		y = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		x2 = e.getX();
		y2 = e.getY();
		if (x > x2) {
			int tmp = x;
			x = x2;
			x2 = tmp;
		}
		if (y > y2) {
			int tmp = y;
			y = y2;
			y2 = tmp;
		}

		jeu.getC().addObst(new ObstacleImpl(x, y, x2, y2));
		ihm.getObs().repaint();
	}
}
