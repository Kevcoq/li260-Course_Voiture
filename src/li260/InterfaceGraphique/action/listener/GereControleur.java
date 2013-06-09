package li260.InterfaceGraphique.action.listener;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.event.ChangeEvent;

import li260.InterfaceGraphique.JPanel.Fenetre;
import li260.InterfaceGraphique.action.listener.impl.CircuitControleur;
import li260.InterfaceGraphique.action.listener.impl.ObserveurControleur;
import li260.InterfaceGraphique.action.listener.impl.ObstacleControleur;
import li260.InterfaceGraphique.action.listener.impl.SauvegardeControleur;
import li260.InterfaceGraphique.action.listener.impl.SimulationControleur;
import li260.InterfaceGraphique.action.listener.impl.StrategieControleur;

public class GereControleur implements Controleur {
	private boolean charger = false;
	private ArrayList<Controleur> lCtrl;
	private VariableControleur vc;

	public GereControleur(Fenetre fen) {
		lCtrl = new ArrayList<Controleur>();
		vc = new VariableControleur(fen);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		init();
		for (Controleur c : lCtrl)
			c.actionPerformed(e);
	}

	public void add(Controleur c) {
		lCtrl.add(c);
	}

	public void init() {
		if (!charger) {
			if (lCtrl.size() == 0)
				lCtrl.add(new CircuitControleur(vc));

			if (vc.isCharger()) {
				lCtrl.add(new StrategieControleur(vc));
				lCtrl.add(new ObserveurControleur(vc));
				lCtrl.add(new SimulationControleur(vc));
				lCtrl.add(new ObstacleControleur(vc));
				lCtrl.add(new SauvegardeControleur(vc));
				charger = true;
			}
		}
	}

	public void setZone(String string) {
	for (Controleur c : lCtrl)
		if(c instanceof ObstacleControleur)
			((ObstacleControleur) c).setZone(string);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		 init();
		 for (Controleur c : lCtrl)
		 c.stateChanged(e);
	}
}
