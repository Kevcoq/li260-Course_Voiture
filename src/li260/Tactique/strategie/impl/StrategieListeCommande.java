package li260.Tactique.strategie.impl;

import java.util.ArrayList;

import li260.Plateau.circuit.Circuit;
import li260.Plateau.voiture.Voiture;
import li260.Plateau.voiture.commande.Commande;
import li260.Tactique.strategie.Strategie;

@SuppressWarnings("serial")
public class StrategieListeCommande implements Strategie {
	private ArrayList<Commande> cmd;
	private int i = 0;

	public StrategieListeCommande(ArrayList<Commande> cmd) {
		super();
		i = 0;
		this.cmd = cmd;
	}

	@Override
	public Commande getCommande() {
		// TODO Auto-generated method stub
		if (i >= cmd.size()) {
			return cmd.get(cmd.size()-1);
		}	
		return cmd.get(i++);
	}

	@Override
	public void init(Circuit c, Voiture v) {
		// TODO Auto-generated method stub
	}

}