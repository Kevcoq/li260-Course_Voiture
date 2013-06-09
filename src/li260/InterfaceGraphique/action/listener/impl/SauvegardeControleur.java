package li260.InterfaceGraphique.action.listener.impl;

import java.awt.event.ActionEvent;

import javax.swing.event.ChangeEvent;

import li260.InterfaceGraphique.action.listener.Controleur;
import li260.InterfaceGraphique.action.listener.VariableControleur;
import li260.InterfaceGraphique.file.Sauvegarde;
import li260.InterfaceGraphique.file.SauvegardeCircuit;
import li260.InterfaceGraphique.file.SauvegardeParametre;
import li260.InterfaceGraphique.file.SauvegardeStrategie;
import li260.mains.TestFile;
import li260.simulation.SimuTools;

public class SauvegardeControleur implements Controleur {
	private VariableControleur vc;

	public SauvegardeControleur(VariableControleur vc) {
		this.vc = vc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Sv parametre")) {
			SauvegardeParametre.svCmd(TestFile.nom_dossier + "Commande/"
					+ TestFile.nom_circuit + ".commande");
			SauvegardeParametre.svThetas(TestFile.nom_dossier + "Thetas/"
					+ TestFile.nom_circuit + ".thetas");
		}

		if (e.getActionCommand().equals("Sv Commande"))
			if (vc.getJeu().getI() != 0)
				SimuTools.saveListeCommande(vc.getJeu().getRecord(),
						Sauvegarde.svCmd());

		if (e.getActionCommand().equals("Sv Circuit"))
			SauvegardeCircuit.svCircuit(vc.getJeu().getC());

		if (vc.isCharger() && vc.getJeu().getStrat() != null
				&& e.getActionCommand().equals("Sv Strategie"))
			SauvegardeStrategie.svStrategie(vc.getJeu().getStrat());

	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub

	}

}
