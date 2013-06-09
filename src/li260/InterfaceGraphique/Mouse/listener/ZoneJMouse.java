package li260.InterfaceGraphique.Mouse.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import li260.Plateau.circuit.zone.Zone;
import li260.Plateau.obstacle.impl.ObstacleZoneImpl;
import li260.mains.tools.IHM;
import li260.mains.tools.Jeu;

public class ZoneJMouse implements MouseListener {
		private Jeu jeu;
		private IHM ihm;
		private Zone zone;
		private int x, y, x2, y2;

		public ZoneJMouse(Jeu jeu, IHM ihm, Zone zone) {
			super();
			this.jeu = jeu;
			this.ihm = ihm;
			this.zone = zone;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
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
			jeu.getC().addZone(new ObstacleZoneImpl(zone, x, y, x2, y2));
			ihm.getObs().repaint();
		}

		public void setZone(Zone zone) {
			this.zone = zone;
		}
	}
