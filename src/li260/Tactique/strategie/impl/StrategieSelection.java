package li260.Tactique.strategie.impl;

import java.util.ArrayList;

import li260.Plateau.circuit.Circuit;
import li260.Plateau.voiture.Voiture;
import li260.Plateau.voiture.commande.Commande;
import li260.Tactique.selecteur.Selecteur;
import li260.Tactique.strategie.Strategie;
import li260.Tactique.strategie.StrategieSelect;

@SuppressWarnings("serial")
public class StrategieSelection implements Strategie, StrategieSelect {
	// C’est une stratégie!  
	private ArrayList<Strategie> liStrategy; // Tout abstrait !
	private ArrayList<Selecteur> liSelect;

	public StrategieSelection() {
		liStrategy = new ArrayList<Strategie>();
		liSelect = new ArrayList<Selecteur>();
	}

	// Plutot sécurisé: on est sur qu'il y a concordance
	@Override
	public void add(Strategie str, Selecteur select) {
		liStrategy.add(str);
		liSelect.add(select);
	}

	@Override
	public Commande getCommande() {
		for (int i = 0; i < liStrategy.size(); i++) {
			if (liSelect.get(i).isSelected())
				return liStrategy.get(i).getCommande();
		}
		// normalement on ne passe pas ici...
		return liStrategy.get(liStrategy.size() - 1).getCommande();
	}

	@Override
	public void init(Circuit c, Voiture v) {
		// TODO Auto-generated method stub
		for (int i = 0; i < liStrategy.size(); i++) {
			liStrategy.get(i).init(c, v);
			liSelect.get(i).init(c, v);
		}
	}
}
