package li260.Plateau.geometrie;

public class VTools {
	public static Vecteur addition(Vecteur a, Vecteur b) {
		return new Vecteur(a.getX() + b.getX(), a.getY() + b.getY());
	}

	public static void additionC(Vecteur a, Vecteur b) {
		a.setX(a.getX() + b.getX());
		a.setY(a.getY() + b.getY());
	}

	//
	// public static Vecteur alea(int max) {
	// // rend un double dans l'intervalle [-max;max]
	// double a=(Math.random()*2*max)-max,
	// b=(Math.random()*2*max)-max;
	// return new Vecteur(a,b);
	// }
	//
	// public static boolean orthogonaux(Vecteur a, Vecteur b){
	// return prodScal(a,b)==0;
	// }
	//
	public static double angle(Vecteur a, Vecteur b) {
		double Na = norme(a), Nb = norme(b);
		double C = (prodScal(a, b)) / (Na * Nb);
		if (C > 1)
			C = 1;
		if (C < -1)
			C = -1;
		double S = (a.getX() * b.getY() - a.getY() * b.getX());
		return Math.signum(S) * Math.acos(C);
	}

	public static Vecteur multiplication(Vecteur a, double k) {
		return new Vecteur(a.getX() * k, a.getY() * k);
	}

	public static void multiplicationC(Vecteur a, double k) {
		a.setX(a.getX() * k);
		a.setY(a.getY() * k);
	}

	public static double norme(Vecteur a) {
		// racine(x2+y2)
		return Math.sqrt(a.getX() * a.getX() + a.getY() * a.getY());
	}

	public static double prodScal(Vecteur a, Vecteur b) {
		return (a.getX() * b.getX()) + (a.getY() * b.getY());
	}

	public static void rotation(Vecteur a, double rad) {
		double x = a.getX();
		a.setX(x * Math.cos(rad) - a.getY() * Math.sin(rad));
		a.setY(x * Math.sin(rad) + a.getY() * Math.cos(rad));
	}

	public static Vecteur soustraction(Vecteur a, Vecteur b) {
		return new Vecteur(a.getX() - b.getX(), a.getY() - b.getY());
	}

	public static Vecteur unitaire(Vecteur a) {
		return new Vecteur((a.getX() / norme(a)), (a.getY() / norme(a)));
	}

	public static int Zsigne(Vecteur a, Vecteur b) {
		if (a.getX() * b.getY() - b.getX() * a.getY() < 0) {
			return -1;
		}
		return 1;
	}
}
