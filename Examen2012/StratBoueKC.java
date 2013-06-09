package li260.Examen2012;

import li260.Plateau.circuit.Circuit;
import li260.Plateau.circuit.terrain.Terrain;
import li260.Plateau.voiture.Voiture;
import li260.Plateau.voiture.commande.Commande;
import li260.Tactique.strategie.Strategie;


@SuppressWarnings("serial")
public class StratBoueKC implements Strategie{
	private Strategie strat;
	private Circuit c;
	private Voiture v;

	public StratBoueKC(Strategie strat, Circuit c, Voiture v) {
		super();
		this.strat = strat;
		this.c = c;
		this.v = v;
	}

	@Override
	public Commande getCommande() {
		// TODO Auto-generated method stub
		if(c.getTerrain(v.getPosition()) == Terrain.Boue && v.getVitesse() > 0.3)
			return new Commande(strat.getCommande().getTurn(), -1);
		return strat.getCommande();
	}

	@Override
	public void init(Circuit c, Voiture v) {
		// TODO Auto-generated method stub
		strat.init(c, v);
	}

	public Strategie getStrat() {
		return strat;
	}
}
