package li260.simulation;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import li260.Plateau.voiture.commande.Commande;

public class SimuTools {
	public static ArrayList<Commande> loadListeCommande(File svcmd)
			throws IOException {
		ArrayList<Commande> liste = null;

		try {
			DataInputStream os = new DataInputStream(new FileInputStream(
					svcmd));

			liste = new ArrayList<Commande>();
			double a, t;
			while (true) { // on attend la fin de fichier
				a = os.readDouble();
				t = os.readDouble();
				liste.add(new Commande(t, a));
			}

		} catch (EOFException e) {
			return liste;
		}
	}

	public static void saveListeCommande(ArrayList<Commande> liste,
			File svcmd) {
		try {
			DataOutputStream os = new DataOutputStream(new FileOutputStream(
					svcmd));
			for (Commande c : liste) {
				os.writeDouble(c.getAcc());
				os.writeDouble(c.getTurn());
			}
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}