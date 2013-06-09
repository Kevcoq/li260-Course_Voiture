package li260.Tactique.strategie.impl;

import li260.Plateau.circuit.Circuit;
import li260.Plateau.voiture.Voiture;
import li260.Plateau.voiture.commande.Commande;
import li260.Tactique.Radar.Radar;
import li260.Tactique.strategie.Strategie;

@SuppressWarnings("serial")
public class StrategieRadar implements Strategie {
	private Commande[] cmd;
	protected Radar rd;

	public StrategieRadar(Commande[] cmd, Radar rd) {
		super();
		this.cmd = cmd;
		this.rd = rd;
	}

	@Override
	public Commande getCommande() {
		// TODO Auto-generated method stub
		rd.scores();
		return cmd[rd.getBestIndex()];
	}

	public Radar getRadar() {
		return rd;
	}

	@Override
	public void init(Circuit c, Voiture v) {
		// TODO Auto-generated method stub
		rd.init(c, v);
	}

	@Override
	public String toString() {
		String commande = "";
		for (Commande c : cmd) {
			commande += c.toString() + "\t";
		}
		return "Strategie Radar : " + rd.toString() + "\t" + commande;
	}

}
