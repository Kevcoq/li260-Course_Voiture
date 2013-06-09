package li260.InterfaceGraphique.JPanel.Menu.delegation;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import li260.InterfaceGraphique.JPanel.Fenetre;
import li260.InterfaceGraphique.JPanel.FenetreTools;
import li260.MVC.view.observeur.impl.CircuitObserveur;
import li260.MVC.view.observeur.impl.VoitureObserveur;
import li260.Plateau.circuit.tools.CstrImage;
import li260.Tactique.strategie.impl.StrategieListeCommande;
import li260.mains.TestFile;
import li260.mains.tools.IHM;
import li260.mains.tools.Jeu;
import li260.simulation.SimuTools;

public class AppJPanel {
	private Jeu jeu;
	private IHM ihm;
	private Fenetre fen;

	public AppJPanel(Fenetre fen, Jeu jeu, IHM ihm) {
		super();
		this.jeu = jeu;
		this.fen = fen;
		this.ihm = ihm;
	}

	public void jouer() {
		Thread t = new Thread() {
			@Override
			public void run() {
				if (jeu.getStrat() == null)
					JOptionPane.showMessageDialog(null, "Il faut une strat");
				else {
					JLabel nbC = FenetreTools.trouve("nbC", fen.getJlab());
					JLabel reussi = FenetreTools
							.trouve("reussi", fen.getJlab());

					jeu.play(nbC, reussi);
					SimuTools
							.saveListeCommande(jeu.getRecord(), TestFile.svcmd);
					fen.getJp().add(fen.instant(jeu.getRecord().size()),
							BorderLayout.SOUTH);

					if (ihm != null) {

						try {
							ImageIO.write(ihm.getObs().getImage(), "png",
									TestFile.svimg);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					if (nbC != null)
						nbC.setText("Nb coup :" + jeu.getI());
					if (reussi != null)
						reussi.setText(" | Etat : " + jeu.getEtat());
					fen.getJp().revalidate();
					System.out.println("Jeu realise !");
				}
			}
		};
		t.start();
	}

	public void reset() {
		jeu.reset();
		JLabel nbC = FenetreTools.trouve("nbC", fen.getJlab());
		nbC.setText("Nb coup :" + jeu.getI());
		JLabel reussi = FenetreTools.trouve("reussi", fen.getJlab());
		reussi.setText(" | Etat : en attente");

		ihm.reset();
		ihm.getObs()
				.add(new CircuitObserveur(CstrImage.buildImage(jeu.getC())));
		ihm.getObs().add(new VoitureObserveur(jeu.getV()));

		fen.getJp().revalidate();
	}

	public void retrace(int value) throws IOException {
		// TODO Auto-generated method stub
		reset();

		jeu.setStrat(new StrategieListeCommande(SimuTools.loadListeCommande(TestFile.svcmd)));
		jeu.retrace(value);
	}

}