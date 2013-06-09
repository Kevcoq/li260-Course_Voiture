package li260.Examen2012;

import li260.Plateau.circuit.Circuit;
import li260.Plateau.voiture.Voiture;
import li260.Plateau.voiture.commande.Commande;
import li260.Tactique.strategie.Strategie;

@SuppressWarnings("serial")
public class StratDiagoKC implements Strategie {
	private Strategie strat;
	private int i;
	
	
	
	public StratDiagoKC(Strategie strat) {
		super();
		this.strat = strat;
		this.i = 0;
	}

	@Override
	public Commande getCommande() {
		// TODO Auto-generated method stub
		i++;
		if(i<30) {
			if(i>4)
				return new Commande(0, 1);
			if(i>3)
				return new Commande(0.927, 0);
			return new Commande(1, 0);
		}
		return strat.getCommande();
	}

	@Override
	public void init(Circuit c, Voiture v) {
		// TODO Auto-generated method stub
		strat.init(c, v);
	}

}
