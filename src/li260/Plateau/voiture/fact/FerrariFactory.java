package li260.Plateau.voiture.fact;

import li260.Plateau.circuit.Circuit;
import li260.Plateau.geometrie.Vecteur;
import li260.Plateau.voiture.Voiture;
import li260.Plateau.voiture.impl.VoitureImpl;

public class FerrariFactory implements VoitureFactory {
	private static final double vmax = 0.9;
	private static final double alpha_c = 0.02;
	private static final double braquage = 0.2;
	private static final double alpha_f = 0.001;
	private static final double beta_f = 0.002;
	private static final double alpha_derapage = 0.01;
	private static final double masse = 1;
	private static final double vitesse_sortie_derapage = 0.6;
	private static final double vitesse = 0;

	private Vecteur position;
	private Vecteur direction;

	public FerrariFactory(Circuit c) {
		// TODO Auto-generated constructor stub
		this(c.getPointDepart(), c.getDirectionDepart());
	}

	public FerrariFactory(Vecteur position, Vecteur direction) {
		super();
		this.position = position.clonage();
		this.direction = direction.clonage();
	}

	@Override
	public Voiture build() {
		return new VoitureImpl(vmax, alpha_c, braquage, alpha_f, beta_f,
				alpha_derapage, masse, vitesse_sortie_derapage, vitesse,
				position, direction);
	}
}
