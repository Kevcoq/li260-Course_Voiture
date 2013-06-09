package li260.InterfaceGraphique.action.listener.impl;

import java.awt.event.ActionEvent;

import javax.swing.event.ChangeEvent;

import li260.InterfaceGraphique.JPanel.Menu.delegation.StratJPanel;
import li260.InterfaceGraphique.action.listener.Controleur;
import li260.InterfaceGraphique.action.listener.VariableControleur;
import li260.InterfaceGraphique.file.SauvegardeStrategie;

public class StrategieControleur implements Controleur {
	VariableControleur vc;
	
	// Sous-traitence "panel"
	private StratJPanel sjp;

	public StrategieControleur(VariableControleur vc) {
		this.vc = vc;
		sjp = new StratJPanel(vc.getJeu(), vc.getgObs(), vc.getlPts());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Strategie
		if (vc.isCharger() && e.getActionCommand().equals("Strategie"))
			sjp.choixStrat();

		
		// Chargement strategie sérialisé
		if (vc.isCharger() && e.getActionCommand().equals("Charg Strategie"))
			vc.getJeu().setStrat(SauvegardeStrategie.chargStrategie(vc.getJeu().getC(),
					vc.getJeu().getV()));
	}

	
	@Override
	public void stateChanged(ChangeEvent e) {
	}
}
