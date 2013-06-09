package li260.InterfaceGraphique.action.listener.impl;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;

import javax.swing.event.ChangeEvent;

import li260.InterfaceGraphique.JPanel.Menu.delegation.ObservJPanel;
import li260.InterfaceGraphique.action.listener.Controleur;
import li260.InterfaceGraphique.action.listener.VariableControleur;
import li260.MVC.view.observeur.impl.CircuitObserveur;
import li260.MVC.view.observeur.impl.VoitureObserveur;
import li260.Plateau.circuit.tools.CstrImage;

public class ObserveurControleur implements Controleur {
	private VariableControleur vc;
	
	// Sous-traitence "panel"
	private ObservJPanel ojp;

	public ObserveurControleur(VariableControleur vc) {
		this.vc = vc;
		ojp = new ObservJPanel(vc.getJeu());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Observeur
		if (vc.isCharger() && e.getActionCommand().equals("Statique")
				&& vc.getgObs().getObs() != null) {
			vc.getgObs().getObs().add(new VoitureObserveur(vc.getJeu().getV()));
			vc.getJeu().add(vc.getgObs().getObs());
		}
		if (vc.isCharger() && e.getActionCommand().equals("Base")) {
			vc.getgObs().getObs().add(new CircuitObserveur(CstrImage.buildImage(vc.getJeu().getC())));
			vc.getgObs().getObs().setPreferredSize(new Dimension(768, 1024));
			vc.getJeu().add(vc.getgObs().getObs());
			vc.getFen().getJp().add(vc.getgObs().getObs(), BorderLayout.CENTER);
			vc.getFen().getJFra().setExtendedState(Frame.MAXIMIZED_BOTH);
		}
		if (vc.isCharger() && e.getActionCommand().equals("Trajectoire")
				&& vc.getgObs().getObs() != null)
			vc.getgObs().getObs().add(ojp.traj());
		if (vc.isCharger() && e.getActionCommand().equals("Dijkstra")
				&& vc.getgObs().getObs() != null)
			vc.getgObs().getObs().add(ojp.dijk());

	}

	@Override
	public void stateChanged(ChangeEvent e) {
	}
}
