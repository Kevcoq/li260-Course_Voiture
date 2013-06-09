package li260.Plateau.voiture.commande;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Commande implements Serializable {
	private double Turn, Acc;

	public Commande(double turn, double acc) {
		super();
		Turn = turn;
		Acc = acc;
	}

	public double getAcc() {
		return Acc;
	}

	public double getTurn() {
		return Turn;
	}

	public void setAcc(double acc) {
		Acc = acc;
	}

	public void setTurn(double turn) {
		Turn = turn;
	}

	@Override
	public String toString() {
		return "Commande [Turn=" + Turn + ", Acc=" + Acc + "]";
	}
}
