package li260.InterfaceGraphique.JPanel.Menu.Strat;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import li260.InterfaceGraphique.JPanel.Menu.delegation.StratJPanel;
import li260.InterfaceGraphique.file.Sauvegarde;
import li260.MVC.view.observeur.Observeur;
import li260.MVC.view.observeur.impl.ArriveObserveur;
import li260.MVC.view.observeur.impl.PapObserveur;
import li260.MVC.view.observeur.impl.RadarObserveur;
import li260.MVC.view.observeur.impl.SelecteurObserveur;
import li260.Plateau.geometrie.Vecteur;
import li260.Plateau.voiture.commande.Commande;
import li260.Tactique.Radar.impl.RadarClassique;
import li260.Tactique.Radar.impl.RadarDijkstra;
import li260.Tactique.selecteur.Selecteur;
import li260.Tactique.selecteur.impl.SelecteurArrive;
import li260.Tactique.selecteur.impl.SelecteurPaP;
import li260.Tactique.selecteur.impl.SelecteurVrai;
import li260.Tactique.selecteur.impl.SelecteurZone;
import li260.Tactique.strategie.Strategie;
import li260.Tactique.strategie.impl.StratDecorateur;
import li260.Tactique.strategie.impl.StrategieArrive;
import li260.Tactique.strategie.impl.StrategieListeCommande;
import li260.Tactique.strategie.impl.StrategiePaP;
import li260.Tactique.strategie.impl.StrategieRadar;
import li260.Tactique.strategie.impl.StrategieSelection;
import li260.mains.TestFile;
import li260.mains.tools.Jeu;
import li260.simulation.SimuTools;

public class SsoCrea {
	private Jeu jeu;

	private Strategie strat = null;
	private Selecteur select = null;
	private Observeur obs = null;
	private ArrayList<Vecteur> list = null;

	private StratDialogInfo sInfo = null;

	public SsoCrea(Jeu jeu, ArrayList<Vecteur> list) {
		super();
		this.jeu = jeu;
		this.list = list;
	}

	public void creer() {
		StratDialog sd = new StratDialog(null, "Definir sa strategie", true);
		sd.setSSO(this);
		sInfo = sd.showSDialog();
		if (sInfo.toString().equals("Aucune information !"))
			return;
		defSelect();
		defStrat();
		defObs();
	}

	private void defObs() {
		if (sInfo.isObserveur()) {
			if (sInfo.getStrategie().equals(StratJPanel.getStringStrat()[0])) {
			}
			/* A corriger */
			if (sInfo.getStrategie().equals(StratJPanel.getStringStrat()[1]))
				obs = new RadarObserveur(jeu.getV(),
						((StrategieRadar) ((StratDecorateur) strat).getStrat())
								.getRadar());
			if (sInfo.getStrategie().equals(StratJPanel.getStringStrat()[2]))
				obs = new RadarObserveur(jeu.getV(),
						((StrategieRadar) ((StratDecorateur) strat).getStrat())
								.getRadar());
			if (sInfo.getStrategie().equals(StratJPanel.getStringStrat()[3]))
				obs = new ArriveObserveur(jeu.getV(), strat);
			if (sInfo.getStrategie().equals(StratJPanel.getStringStrat()[4]))
				obs = new PapObserveur(jeu.getV(), strat);
			if (sInfo.getStrategie().equals(StratJPanel.getStringStrat()[5]))
				obs = null;
		}
	}

	private void defSelect() {
		// TODO Auto-generated method stub
		if (sInfo.getStrategie().equals(StratJPanel.getStringStrat()[0])) {
			if (sInfo.getSelecteur().equals(StratJPanel.getStringSelect()[0]))
				select = new SelecteurVrai();
			if (sInfo.getSelecteur().equals(StratJPanel.getStringSelect()[1])) {
				double d = Double.parseDouble(JOptionPane.showInputDialog(null,
						"Choisir le % de la zone", "ZONE",
						JOptionPane.QUESTION_MESSAGE));
				select = new SelecteurZone(jeu.getC().getDijk(), jeu.getV(), d);
			}
		}
	}

	private void defSSelect() {
		// TODO Auto-generated method stub
		StrategieSelection strategietmp = new StrategieSelection();
		SelecteurObserveur observeurtmp = new SelecteurObserveur();
		// SelecteurObserveur observeurtmp = new SelecteurObserveur();
		int cpt = Integer.parseInt(JOptionPane.showInputDialog(null,
				"Entrez le nombre de strat a ajouter", "STRATEGIE",
				JOptionPane.QUESTION_MESSAGE));

		SsoCrea sso = new SsoCrea(jeu, list);
		for (int i = 0; i < cpt; i++) {
			sso.creer();
			strategietmp.add(sso.getStrat(), sso.getSelect());
			observeurtmp.add(sso.getObs(), sso.getSelect());
		}
		strat = new StratDecorateur(strategietmp, jeu.getV(), jeu.getC());
		obs = observeurtmp;
	}

	private void defStrat() {
		// TODO Auto-generated method stub
		if (sInfo.getStrategie().equals(StratJPanel.getStringStrat()[0]))
			defSSelect();
		if (sInfo.getStrategie().equals(StratJPanel.getStringStrat()[1])) {
			select = new SelecteurVrai();
			strat = new StratDecorateur(new StrategieRadar(TestFile.cmd,
					new RadarDijkstra(TestFile.thetas, jeu.getV(), jeu.getC(),
							jeu.getC().getDijk())), jeu.getV(), jeu.getC());
		}
		if (sInfo.getStrategie().equals(StratJPanel.getStringStrat()[2])) {
			select = new SelecteurVrai();
			strat = new StratDecorateur(
					new StrategieRadar(TestFile.cmd, new RadarClassique(
							TestFile.thetas, jeu.getV(), jeu.getC())),
					jeu.getV(), jeu.getC());
		}
		if (sInfo.getStrategie().equals(StratJPanel.getStringStrat()[3])) {
			select = new SelecteurArrive(jeu.getV(), jeu.getC());
			strat = new StratDecorateur(new StrategieArrive(jeu.getC(),
					jeu.getV(), select), jeu.getV(), jeu.getC());
		}
		if (sInfo.getStrategie().equals(StratJPanel.getStringStrat()[4])) {
			select = new SelecteurPaP(jeu.getC(), jeu.getV(), list);
			strat = new StratDecorateur(new StrategiePaP(jeu.getV(), select),
					jeu.getV(), jeu.getC());
		}
		if (sInfo.getStrategie().equals(StratJPanel.getStringStrat()[5])) {
			select = new SelecteurVrai();
			try {
				ArrayList<Commande> cmd = SimuTools
						.loadListeCommande(Sauvegarde.svCmd());
				strat = new StrategieListeCommande(cmd);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Jeu getJeu() {
		return jeu;
	}

	public Observeur getObs() {
		return obs;
	}

	public Selecteur getSelect() {
		return select;
	}

	public Strategie getStrat() {
		return strat;
	}

	public void setStrat(Strategie strat) {
		this.strat = strat;
	}

}
