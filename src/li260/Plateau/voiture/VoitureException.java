package li260.Plateau.voiture;

@SuppressWarnings("serial")
public class VoitureException extends Exception {

	public VoitureException(String message) {
		super("la commande n'est pas entre [-1;1]");
		// TODO Auto-generated constructor stub
	}

}
