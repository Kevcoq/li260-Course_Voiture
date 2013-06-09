package li260.simulation;

import java.util.ArrayList;

import javax.swing.JLabel;

import li260.MVC.event.listener.UpdateEventListener;
import li260.MVC.event.sender.UpdateEventSender;
import li260.Plateau.circuit.Circuit;
import li260.Plateau.circuit.terrain.Terrain;
import li260.Plateau.circuit.terrain.ToolsTerrain;
import li260.Plateau.geometrie.VTools;
import li260.Plateau.voiture.Voiture;
import li260.Plateau.voiture.VoitureException;
import li260.Plateau.voiture.commande.Commande;
import li260.Tactique.strategie.Strategie;
import li260.mains.TestFile;

public class Simulation implements UpdateEventSender {
	private Voiture voit;
	private Circuit circ;
	private Strategie strat;
	private int i;
	private ArrayList<Commande> record = new ArrayList<Commande>();
	private ArrayList<UpdateEventListener> uEL = new ArrayList<UpdateEventListener>();
	private EtatSimulation etat;

	public Simulation(Voiture voit, Circuit circ, Strategie strat) {
		super();
		this.voit = voit;
		this.circ = circ;
		this.strat = strat;
		i = 0;
		etat = EtatSimulation.Run;
	}

	@Override
	public void add(UpdateEventListener listener) {
		// TODO Auto-generated method stub
		uEL.add(listener);
	}

	public EtatSimulation getEtat() {
		return etat;
	}

	public int getI() {
		return i;
	}

	public ArrayList<Commande> getRecord() {
		return record;
	}

	public void play() throws VoitureException {
		while ((etat = updateState()) == EtatSimulation.Run)
			playOneShot();
	}

	public void play(JLabel nbC) throws VoitureException {
		// TODO Auto-generated method stub
		while ((etat = updateState()) == EtatSimulation.Run) {
			playOneShot();
			if (nbC != null)
				nbC.setText("Nb coup :" + i);
		}
	}

	public void retrace(int t) throws VoitureException {
		// TODO Auto-generated method stub
		for (int i = 0; i < t; i++)
			playOneShot();
	}

	private void playOneShot() throws VoitureException {
		i++;
		record.add(strat.getCommande());
		voit.drive(record.get(record.size() - 1));
		update();
		try {
			Thread.sleep((int) (TestFile.sleep / voit.getVitesse()));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		for (UpdateEventListener o : uEL) {
			o.manageUpdate();
		}
	}

	private EtatSimulation updateState() {
		if (circ.getTerrain(voit.getPosition()) == Terrain.EndLine)
			if (VTools
					.prodScal(voit.getDirection(), circ.getDirectionArrivee()) >= 0)
				return EtatSimulation.Succes;
			else
				return EtatSimulation.Echec;
		if (!ToolsTerrain.getValide(circ, voit.getPosition()))
			return EtatSimulation.Echec;
		return EtatSimulation.Run;
	}
}
