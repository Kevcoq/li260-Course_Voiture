package li260.InterfaceGraphique.action.listener.impl;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

import li260.InterfaceGraphique.JPanel.FenetreTools;
import li260.InterfaceGraphique.JPanel.Menu.delegation.AppJPanel;
import li260.InterfaceGraphique.JPanel.Menu.delegation.VitesseJPanel;
import li260.InterfaceGraphique.action.listener.Controleur;
import li260.InterfaceGraphique.action.listener.VariableControleur;

public class SimulationControleur implements Controleur {
	private VariableControleur vc;

	// Sous-traitence "panel"
	private AppJPanel appjp;
	private VitesseJPanel vjp;

	// Pour la JSlider
	private boolean bool = false;

	public SimulationControleur(VariableControleur vc) {
		this.vc = vc;
		vjp = new VitesseJPanel();
		appjp = new AppJPanel(vc.getFen(), vc.getJeu(), vc.getgObs());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Application
		if (vc.isCharger() && e.getActionCommand().equals("Play"))
			appjp.jouer();
		if (vc.isCharger() && e.getActionCommand().equals("Reset"))
			appjp.reset();

		// Vitesse
		if (e.getActionCommand().equals("Lent"))
			vjp.lent();
		if (e.getActionCommand().equals("Moyenne"))
			vjp.moyenne();
		if (e.getActionCommand().equals("Rapide"))
			vjp.rapide();

		if (e.getActionCommand().equals("Ok"))
			bool = true;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if (bool) {
			try {
				FenetreTools.trouve("inst", vc.getFen().getJlab()).setText(
						"Valeur actuelle : "
								+ ((JSlider) e.getSource()).getValue());
				appjp.retrace(((JSlider) e.getSource()).getValue());
				bool = false;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
