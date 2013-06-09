package li260.InterfaceGraphique.action.listener.impl;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;

import li260.InterfaceGraphique.JPanel.Menu.delegation.FichierJPanel;
import li260.InterfaceGraphique.action.listener.Controleur;
import li260.InterfaceGraphique.action.listener.VariableControleur;
import li260.InterfaceGraphique.file.Sauvegarde;
import li260.InterfaceGraphique.file.SauvegardeCircuit;
import li260.Plateau.circuit.CircuitExtends;
import li260.Plateau.circuit.tools.CstrImage;
import li260.mains.TestFile;
import li260.mains.tools.IHM;

public class CircuitControleur implements Controleur {
	private VariableControleur vc;

	// Sous-traitence "panel"
	private FichierJPanel fjp;

	public CircuitControleur(VariableControleur vc) {
		this.vc = vc;
		fjp = new FichierJPanel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Notice
		if (e.getActionCommand().equals("Notice"))
			fjp.notice();
		else {
			// Fichier
			if (e.getActionCommand().equals("Emplacement circuit"))
				lancer(fjp.creerCircuit(SauvegardeCircuit.chargCircuitBase()));
			else {
				if (e.getActionCommand().equals("Emplacement cmd"))
					TestFile.svcmd = Sauvegarde.svCmd();
				else {
					if (e.getActionCommand().equals("Emplacement img"))
						TestFile.svimg = Sauvegarde.svImg();
					else {
						// Chargement Circuit
						// sérialisé
						if (e.getActionCommand().equals("Charg Circuit"))
							lancer(SauvegardeCircuit.chargCircuit());
						else {
							// Methode lancer
							// sans
							// cheat circuit
							if (e.getActionCommand().equals(
									"Sans modif Circuit"))
								lancer(fjp.creerCircuit(SauvegardeCircuit
										.chargCircuitBase()));
							else
								try {
									int i = Integer.parseInt(e
											.getActionCommand());
									switch (i) {
									case 1:
										lancer(fjp
												.creerCircuit(SauvegardeCircuit
														.chargCircuitBase("track09/1_safe.trk")));
										break;
									case 2:
										lancer(fjp
												.creerCircuit(SauvegardeCircuit
														.chargCircuitBase("track09/2_safe.trk")));
										break;
									case 3:
										lancer(fjp
												.creerCircuit(SauvegardeCircuit
														.chargCircuitBase("track09/3_safe.trk")));
										break;
									case 4:
										lancer(fjp
												.creerCircuit(SauvegardeCircuit
														.chargCircuitBase("track09/4_safe.trk")));
										break;
									case 5:
										lancer(fjp
												.creerCircuit(SauvegardeCircuit
														.chargCircuitBase("track09/5_safe.trk")));
										break;
									case 6:
										lancer(fjp
												.creerCircuit(SauvegardeCircuit
														.chargCircuitBase("track09/6_safe.trk")));
										break;
									case 7:
										lancer(fjp
												.creerCircuit(SauvegardeCircuit
														.chargCircuitBase("track09/7_safe.trk")));
										break;
									case 8:
										lancer(fjp
												.creerCircuit(SauvegardeCircuit
														.chargCircuitBase("track09/8_safe.trk")));
										break;
									case 9:
										lancer(fjp
												.creerCircuit(SauvegardeCircuit
														.chargCircuitBase("track09/aufeu.trk")));
										break;
									case 10:
										lancer(fjp
												.creerCircuit(SauvegardeCircuit
														.chargCircuitBase("track09/bond_safe.trk")));
										break;
									case 11:
										lancer(fjp
												.creerCircuit(SauvegardeCircuit
														.chargCircuitBase("track09/Een2.trk")));
										break;
									case 12:
										lancer(fjp
												.creerCircuit(SauvegardeCircuit
														.chargCircuitBase("track09/labymod.trk")));
										break;
									case 13:
										lancer(fjp
												.creerCircuit(SauvegardeCircuit
														.chargCircuitBase("track09/labyperso.trk")));
										break;
									case 14:
										lancer(fjp
												.creerCircuit(SauvegardeCircuit
														.chargCircuitBase("track09/perso.trk")));
										break;
									case 15:
										lancer(fjp
												.creerCircuit(SauvegardeCircuit
														.chargCircuitBase("track09/t2009.trk")));
										break;
									case 16:
										lancer(fjp
												.creerCircuit(SauvegardeCircuit
														.chargCircuitBase("track09/t260_safe.trk")));
										break;
									default:
										if (!vc.isCharger())
											JOptionPane
													.showMessageDialog(
															null,
															"Veuillez d'abord choisir un circuit",
															"SVP !", 0);
									}
								} catch (Exception e1) {
									if (!vc.isCharger())
										JOptionPane
												.showMessageDialog(
														null,
														"Veuillez d'abord choisir un circuit",
														"SVP !", 0);
								}
						}
					}
				}
			}
		}
	}

	public void lancer(CircuitExtends c) {
		if (vc.isCharger() || c == null)
			return;

		while (vc.getFen().getJp().getComponentCount() != 0)
			vc.getFen().getJp().remove(0);

		vc.getJeu().setC(c);
		vc.getJeu().setV(fjp.creerVoiture(vc.getJeu().getC()));
		vc.getFen().getJp().add(vc.getFen().hbox(), BorderLayout.EAST);
		vc.getFen().getJFra().validate();

		vc.setgObs(new IHM(CstrImage.buildImage(vc.getJeu().getC())));
		vc.setCharger(true);

	}

	@Override
	public void stateChanged(ChangeEvent e) {
	}
}
