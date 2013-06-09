package li260.mains;

import java.io.File;
import java.io.IOException;

import li260.InterfaceGraphique.JPanel.Fenetre;
import li260.Plateau.circuit.Difcolexception;
import li260.Plateau.voiture.VoitureException;
import li260.Plateau.voiture.commande.Commande;

public class TestFile {

	/**
	 * @param args
	 * @throws Difcolexception
	 * @throws IOException
	 * @throws VoitureException
	 */

	// Variable globale permettant de modifier la rapidit� du programme sans
	// recherch� dans les diverses classes.
	public static final double pas = 0.1;
	public static final int arrivee = 10;
	public static double sleep = 0;

	// Variable d'envirronnement
	public static File svcmd = new File("cmd.com"), svimg = new File(
			"cvoit.png");
	public static String nom_dossier, nom_circuit;

	// Variable lier au comportement de la voiture
	public static final double minAcc = 0.075;

	public static double[] thetas = { 0., -Math.PI / 4, -Math.PI / 6,
			-Math.PI / 12, -Math.PI / 20, Math.PI / 20, Math.PI / 12,
			Math.PI / 6, Math.PI / 4 };
	public static double acc = 0.5, dir = 0, frein20 = -1, dir20 = 0.05,
			frein12 = -1, dir12 = 0.1, frein6 = -1, dir6 = 0.25, frein4 = -1,
			dir4 = 0.35;
	public static Commande[] cmd = { new Commande(dir, acc),
			new Commande(-dir4, frein4), new Commande(-dir6, frein6),
			new Commande(-dir12, frein12), new Commande(-dir20, frein20),
			new Commande(dir20, frein20), new Commande(dir12, frein12),
			new Commande(dir6, frein6), new Commande(dir4, frein4) };

	// public static double[] thetas = { 0., -Math.PI / 2, -Math.PI / 6,
	// -Math.PI / 12, Math.PI / 12, Math.PI / 6, Math.PI / 2 };
	// public static double acc = 1, dir = 0, frein12 = 1, dir12 = 0.1,
	// frein6 = -1, dir6 = 0.25, frein2 = -1, dir2 = 0.7;
	// public static Commande[] cmd = { new Commande(dir, acc),
	// new Commande(-dir2, frein2), new Commande(-dir6, frein6),
	// new Commande(-dir12, frein12), new Commande(dir12, frein12),
	// new Commande(dir6, frein6), new Commande(dir2, frein2) };

	public static void main(String[] args) throws Difcolexception, IOException,
			VoitureException, InterruptedException {
		Fenetre fenetre = new Fenetre();
		fenetre.fenetre();

		while (fenetre.getJFra().isVisible())
			Thread.sleep(3000);

		File fic = new File("circuit.trk.reset");
		if (fic.exists())
			fic.delete();
		System.exit(0);
	}
}
