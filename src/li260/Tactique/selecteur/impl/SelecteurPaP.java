package li260.Tactique.selecteur.impl;

import java.util.ArrayList;

import li260.Plateau.circuit.Circuit;
import li260.Plateau.circuit.terrain.Terrain;
import li260.Plateau.circuit.terrain.ToolsTerrain;
import li260.Plateau.geometrie.VTools;
import li260.Plateau.geometrie.Vecteur;
import li260.Plateau.voiture.Voiture;
import li260.Tactique.selecteur.Selecteur;

@SuppressWarnings("serial")
public class SelecteurPaP implements Selecteur {
	private Voiture v;
	private Circuit c;
	private ArrayList<Vecteur> listeP = new ArrayList<Vecteur>();
	private int pixel;
	private static double pas = 0.1;

	public SelecteurPaP(Circuit c, Voiture v, ArrayList<Vecteur> lPts) {
		super();
		this.v = v;
		this.c = c;
		for (Vecteur p : lPts)
			listeP.add(p);
		pixel = 0;
	}

	public ArrayList<Vecteur> getListeP() {
		return listeP;
	}

	public int getPixel() {
		return pixel;
	}

	@Override
	public void init(Circuit c, Voiture v) {
		// TODO Auto-generated method stub
		this.c = c;
		this.v = v;
	}

	@Override
	public boolean isSelected() {
		if (listeP.size() <= 0)
			return false;
		if (VTools.norme(VTools.soustraction(listeP.get(0), v.getPosition())) < 0.9)
			listeP.remove(0);

		int cpt = -1;
		Vecteur pos = v.getPosition().clonage();
		Vecteur dir = VTools.unitaire(new Vecteur(pos, listeP.get(0)));

		do {
			if (c.getTerrain(pos) == Terrain.EndLine
					&& VTools.prodScal(dir, c.getDirectionArrivee()) < 0)
				return false;

			cpt++;
			VTools.additionC(pos, VTools.multiplication(dir, pas));
			if (VTools.norme(VTools.soustraction(listeP.get(0), pos)) < 0.9) {
				pixel = (int) (cpt * pas);
				return true;
			}
		} while (ToolsTerrain.getValide(c, pos));
		return false;
	}
}
