package li260.Tactique.strategie.impl;

import li260.Plateau.circuit.Circuit;
import li260.Plateau.circuit.CircuitExtends;
import li260.Plateau.circuit.zone.Zone;
import li260.Plateau.voiture.Voiture;
import li260.Plateau.voiture.commande.Commande;
import li260.Tactique.strategie.Strategie;
import li260.mains.TestFile;

@SuppressWarnings("serial")
public class StratDecorateur implements Strategie {
	private Strategie strat;
	private transient Voiture v;
	private transient Circuit c;

	public StratDecorateur(Strategie strat, Voiture v, Circuit c) {
		super();
		this.strat = strat;
		this.v = v;
		this.c = c;
	}

	@Override
	public Commande getCommande() {
		// TODO Auto-generated method stub
		Commande cmd = strat.getCommande();

		
		if(c instanceof CircuitExtends) {
		if (((CircuitExtends) c).quelZone(v.getPosition()) == Zone.Lent)
			cmd.setAcc(cmd.getAcc() / 2);

		if (((CircuitExtends) c).quelZone(v.getPosition()) == Zone.Rapide)
			cmd.setAcc(1);
		}

		if (v.getVitesse() < TestFile.minAcc && cmd.getAcc() < TestFile.minAcc) {
			cmd.setAcc(TestFile.minAcc);
		}

		double turnAbs = Math.min(Math.abs(cmd.getTurn()),
				v.getMaxTurnSansDerapage());
		return new Commande(turnAbs * Math.signum(cmd.getTurn()), cmd.getAcc());
	}

	public Strategie getStrat() {
		return strat;
	}

	@Override
	public void init(Circuit c, Voiture v) {
		// TODO Auto-generated method stub
		this.v = v;
		this.c = c;
		strat.init(c, v);
	}

	@Override
	public String toString() {
		return strat.toString();
	}

}
