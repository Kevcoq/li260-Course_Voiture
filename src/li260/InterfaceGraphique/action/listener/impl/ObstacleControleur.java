package li260.InterfaceGraphique.action.listener.impl;

import java.awt.event.ActionEvent;

import javax.swing.event.ChangeEvent;

import li260.InterfaceGraphique.Mouse.listener.ObstacleJMouse;
import li260.InterfaceGraphique.Mouse.listener.PointJMouse;
import li260.InterfaceGraphique.Mouse.listener.ZoneJMouse;
import li260.InterfaceGraphique.action.listener.Controleur;
import li260.InterfaceGraphique.action.listener.VariableControleur;
import li260.MVC.view.observeur.impl.ObstacleObserveur;
import li260.MVC.view.observeur.impl.PointsObserveur;
import li260.MVC.view.observeur.impl.ZoneObserveur;
import li260.Plateau.circuit.zone.Zone;
import li260.Plateau.geometrie.Vecteur;

public class ObstacleControleur implements Controleur {
	private VariableControleur vc;

	// Sous traitence souris
	private ObstacleJMouse ojm;
	private ZoneJMouse zjm;
	private PointJMouse pjm;

	public ObstacleControleur(VariableControleur vc) {
		this.vc = vc;
		ojm = new ObstacleJMouse(vc.getJeu(), vc.getgObs());
		zjm = new ZoneJMouse(vc.getJeu(), vc.getgObs(), Zone.Normal);
		pjm = new PointJMouse(vc.getgObs(), vc.getlPts());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (vc.getgObs().getObs() == null)
			return;

		// Obstacle
		if (e.getActionCommand().equals("Creer obstacle")) {
			vc.getgObs().getObs().addMouseListener(ojm);
			vc.getgObs()
					.getObs()
					.add(new ObstacleObserveur(vc.getJeu()
							.getC().getObst()));
			vc.getFen().fini("Obstacle");
		}

		if (e.getActionCommand().equals("prec Obstacle")) {
			if (!vc.getJeu().getC().getObst().isEmpty()) {
				vc.getJeu().getC().getObst()
						.remove(vc.getJeu().getC().getObst()
								.size() - 1);
				vc.getFen().getJp().repaint();
			}
		}

		if (e.getActionCommand().equals("Obstacle")) {
			vc.getgObs().getObs().removeMouseListener(ojm);
			vc.getJeu().getC().getDijk().calcule();
		}

		if (e.getActionCommand().equals("Retirer Obstacle")) {
			while (!vc.getJeu().getC().getObst().isEmpty())
				vc.getJeu().getC().getObst().remove(0);
			vc.getJeu().getC().getDijk().calcule();
			vc.getFen().getJp().repaint();
		}

		// Zone
		if (e.getActionCommand().equals("Creer zone")) {
			vc.getgObs().getObs().addMouseListener(zjm);
			vc.getgObs()
					.getObs()
					.add(new ZoneObserveur(vc.getJeu().getC()
							.getZone()));
			vc.getFen().finiZone();
		}

		if (e.getActionCommand().equals("prec Zone"))
			if (!vc.getJeu().getC().getZone().isEmpty()) {
				 vc.getJeu().getC().getZone()
						.remove(vc.getJeu().getC().getZone()
								.size() - 1);
				vc.getFen().getJp().repaint();

			}

		if (e.getActionCommand().equals("Zone")) {
			vc.getgObs().getObs().removeMouseListener(zjm);
		}

		if (e.getActionCommand().equals("Retirer Zone")) {
			while (!vc.getJeu().getC().getZone().isEmpty())
				vc.getJeu().getC().getZone().remove(0);
			vc.getFen().getJp().repaint();
		}

		// Liste de point
		if (e.getActionCommand().equals("Creer liste de pts")) {
			vc.getgObs().getObs().addMouseListener(pjm);
			vc.getgObs().getObs().add(new PointsObserveur(vc.getlPts()));
			vc.getFen().fini("Points");
		}

		if (e.getActionCommand().equals("prec Points"))
			if (!vc.getlPts().isEmpty()) {
				vc.getlPts().remove(vc.getlPts().size() - 1);
				vc.getFen().getJp().repaint();
			}

		if (e.getActionCommand().equals("Points"))
			vc.getgObs().getObs().removeMouseListener(pjm);

		if (e.getActionCommand().equals("Retirer liste de pts")) {
			while (!vc.getlPts().isEmpty())
				vc.getlPts().remove(0);
			vc.getFen().getJp().repaint();
		}

		if (e.getActionCommand().equals("Afficher LPaP"))
			Vecteur.liste(vc.getlPts());
	}

	public void setZone(String string) {
		// TODO Auto-generated method stub
		if (string.equals("Lent"))
			zjm.setZone(Zone.Lent);
		if (string.equals("Normal"))
			zjm.setZone(Zone.Normal);
		if (string.equals("Rapide"))
			zjm.setZone(Zone.Rapide);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub

	}
}
