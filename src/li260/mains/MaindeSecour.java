package li260.mains;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import li260.InterfaceGraphique.file.SauvegardeCircuit;
import li260.MVC.event.listener.GereObserveur;
import li260.MVC.view.observeur.impl.ArriveObserveur;
import li260.MVC.view.observeur.impl.CircuitObserveur;
import li260.MVC.view.observeur.impl.RadarObserveur;
import li260.MVC.view.observeur.impl.SelecteurObserveur;
import li260.MVC.view.observeur.impl.VoitureObserveur;
import li260.Plateau.circuit.CircuitExtends;
import li260.Plateau.circuit.Difcolexception;
import li260.Plateau.circuit.fact.CircuitFactoryImpl;
import li260.Plateau.circuit.impl.CircuitDeco;
import li260.Plateau.circuit.tools.CstrImage;
import li260.Plateau.voiture.VoitureException;
import li260.Plateau.voiture.commande.Commande;
import li260.Plateau.voiture.fact.FerrariFactory;
import li260.Tactique.Radar.impl.RadarDijkstra;
import li260.Tactique.selecteur.Selecteur;
import li260.Tactique.selecteur.impl.SelecteurArrive;
import li260.Tactique.selecteur.impl.SelecteurVrai;
import li260.Tactique.strategie.Strategie;
import li260.Tactique.strategie.StrategieSelect;
import li260.Tactique.strategie.impl.StratDecorateur;
import li260.Tactique.strategie.impl.StrategieArrive;
import li260.Tactique.strategie.impl.StrategieRadar;
import li260.Tactique.strategie.impl.StrategieSelection;
import li260.mains.tools.Jeu;
import li260.simulation.SimuTools;

public class MaindeSecour {

	/**
	 * @param args
	 * @throws Difcolexception
	 * @throws IOException
	 * @throws VoitureException
	 */

	public static void main(String[] args) throws Difcolexception, IOException,
			VoitureException, InterruptedException {

		Jeu jeu = new Jeu();

		// Creation circuit
		CircuitFactoryImpl cf1 = new CircuitFactoryImpl(
				SauvegardeCircuit.chargCircuitBase());
		CircuitExtends c = new CircuitDeco(cf1.build());
		jeu.setC(c);

		// Creation voiture
		FerrariFactory f1 = new FerrariFactory(jeu.getC().getPointDepart(), jeu
				.getC().getDirectionDepart());
		jeu.setV(f1.build());

		// Creation th�tas et cmd associ�
		double[] thetas = { 0., -Math.PI / 6, -Math.PI / 12, Math.PI / 12,
				Math.PI / 6 };
		double acc = 1, dir = 0, frein12 = 1, dir12 = 0.1, frein6 = -1, dir6 = 0.25;
		Commande[] cmd = { new Commande(dir, acc), new Commande(-dir6, frein6),
				new Commande(-dir12, frein12), new Commande(dir12, frein12),
				new Commande(dir6, frein6) };

		// Creation selec
		Selecteur selectDijk = new SelecteurVrai();
		Selecteur selectArrive = new SelecteurArrive(jeu.getV(), jeu.getC());

		// Creation strat
		Strategie sDijk = new StrategieRadar(cmd, new RadarDijkstra(thetas,
				jeu.getV(), jeu.getC(), jeu.getC().getDijk()));
		Strategie sArrive = new StrategieArrive(jeu.getC(), jeu.getV(),
				selectArrive);

		StrategieSelect sSelect = new StrategieSelection();
		sSelect.add(sArrive, selectArrive);
		sSelect.add(sDijk, selectDijk);

		jeu.setStrat(new StratDecorateur(sSelect, jeu.getV(), jeu.getC()));

		// Creation des EventListener
		// Tps reel
		GereObserveur gObs = new GereObserveur(CstrImage.buildImage(jeu.getC()));
		gObs.add(new CircuitObserveur(CstrImage.buildImage(jeu.getC())));
		// gObs.add(new DijkstraObserveur(jeu.getC().getDijk()));
		gObs.add(new VoitureObserveur(jeu.getV()));

		SelecteurObserveur soS = new SelecteurObserveur();
		soS.add(new ArriveObserveur(jeu.getV(), sArrive), selectArrive);
		soS.add(new RadarObserveur(jeu.getV(), ((StrategieRadar) sDijk)
				.getRadar()), selectDijk);
		gObs.add(soS);

		gObs.setPreferredSize(new Dimension(768, 1024));

		jeu.add(gObs);

		JFrame fen = new JFrame("Simu LI260");
		JScrollPane jsp = new JScrollPane(gObs);

		fen.setContentPane(jsp);
		fen.setVisible(true);
		fen.pack();
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Jeu
		jeu.play();
		System.out.print(jeu.getEtat() + "\t" + jeu.getI() + "\n");

		// Enregistrement de l'image et de la liste des cmd
		// ImageIO.write(gObs.getImage(), "png", TestFile.svimg);
		SimuTools.saveListeCommande(jeu.getRecord(), TestFile.svcmd);
		System.out.println("Fini");

		// SauvegardeStrategie.svStrategie(sSelect);
	}
}
