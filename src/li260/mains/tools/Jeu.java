package li260.mains.tools;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JLabel;

import li260.InterfaceGraphique.file.SauvegardeCircuit;
import li260.MVC.event.listener.UpdateEventListener;
import li260.MVC.event.sender.UpdateEventSender;
import li260.Plateau.circuit.CircuitExtends;
import li260.Plateau.voiture.Voiture;
import li260.Plateau.voiture.VoitureException;
import li260.Plateau.voiture.commande.Commande;
import li260.Plateau.voiture.fact.FerrariFactory;
import li260.Tactique.strategie.Strategie;
import li260.simulation.EtatSimulation;
import li260.simulation.Simulation;

public class Jeu implements UpdateEventSender, UpdateEventListener {
	private CircuitExtends c = null;
	private Voiture v = null;
	private Strategie strat = null;
	private Simulation simu = null;
	private ArrayList<UpdateEventListener> uEL = new ArrayList<UpdateEventListener>();

	private File fic = new File("circuit.trk.reset");

	@Override
	public void add(UpdateEventListener listener) {
		// TODO Auto-generated method stub
		uEL.add(listener);
	}

	public CircuitExtends getC() {
		return c;
	}

	public EtatSimulation getEtat() {
		// TODO Auto-generated method stub
		return simu.getEtat();
	}

	public int getI() {
		// TODO Auto-generated method stub
		if (simu != null)
			return simu.getI();
		return 0;
	}

	public ArrayList<Commande> getRecord() {
		// TODO Auto-generated method stub
		return simu.getRecord();
	}

	public Strategie getStrat() {
		return strat;
	}

	public Voiture getV() {
		return v;
	}

	@Override
	public void manageUpdate() {
		update();
	}

	@Override
	public void update() {
		for (UpdateEventListener o : uEL) {
			o.manageUpdate();
		}
	}

	public void play() {
		// TODO Auto-generated method stub
		SauvegardeCircuit.svCircuitFile(c, fic);
		simu = new Simulation(v, c, strat);
		simu.add(this);
		try {
			simu.play();
		} catch (VoitureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void play(JLabel nbC, JLabel reussi) {
		// TODO Auto-generated method stub
		SauvegardeCircuit.svCircuitFile(c, fic);
		simu = new Simulation(v, c, strat);
		if (nbC != null)
			nbC.setText("Nb coup :" + simu.getI());
		if (reussi != null)
			reussi.setText(" | Etat : " + simu.getEtat());
		simu.add(this);
		try {
			simu.play(nbC);
		} catch (VoitureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void retrace(int t) {
		// TODO Auto-generated method stub
		simu = new Simulation(v, c, strat);
		simu.add(this);
		try {
			simu.retrace(t);
		} catch (VoitureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void reset() {
		// TODO Auto-generated method stub
		c = SauvegardeCircuit.chargCircuitFic(fic);
		FerrariFactory f1 = new FerrariFactory(c);
		v = f1.build();
		strat = null;
		simu = null;
	}

	public void setC(CircuitExtends c) {
		this.c = c;
	}

	public void setStrat(Strategie strat) {
		this.strat = strat;
	}

	public void setV(Voiture v) {
		this.v = v;
	}
}
