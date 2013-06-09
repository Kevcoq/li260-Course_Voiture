package li260.Plateau.geometrie;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Vecteur implements Serializable {
	public static void liste(ArrayList<Vecteur> lPts) {
		// TODO Auto-generated method stub
		for (Vecteur p : lPts)
			System.out.println(p.toString());
	}

	private double x, y;

	public Vecteur(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Vecteur(Vecteur a, Vecteur b) {
		this(b.getX() - a.getX(), b.getY() - a.getY());
	}

	public Vecteur clonage() {
		return new Vecteur(this.getX(), this.getY());
	}

	@Override
	public boolean equals(Object obj) {
		return (this.x == ((Vecteur) obj).getX() && this.y == ((Vecteur) obj)
				.getY());
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Vecteur [" + x + ";" + y + "]";
	}

}
