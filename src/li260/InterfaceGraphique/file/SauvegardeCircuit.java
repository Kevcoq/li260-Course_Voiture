package li260.InterfaceGraphique.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import li260.Plateau.circuit.Circuit;
import li260.Plateau.circuit.CircuitExtends;
import li260.Plateau.circuit.impl.CircuitZone;
import li260.Tactique.dijkstra.Dijkstra;
import li260.mains.TestFile;

public class SauvegardeCircuit {
	public static CircuitExtends chargCircuit() {
		CircuitExtends c = null;
		JFileChooser choix = new JFileChooser("track09/");
		ExtFileFilter filtre = new ExtFileFilter(".trk.seria",
				"Fichier circuit sérialisé");
		choix.addChoosableFileFilter(filtre);
		File file;

		if (choix.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			file = choix.getSelectedFile();
			// Si l'extension est valide
			if (choix.getFileFilter().accept(file)) {
				try {
					maj(file);
					ObjectInputStream ois = new ObjectInputStream(
							new BufferedInputStream(new FileInputStream(file)));
					c = new CircuitZone((Circuit) ois.readObject());
					chargPara(file);

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				// Si vous n'avez pas spécifié une extension valide !
				JOptionPane
						.showMessageDialog(
								null,
								"Erreur d'extension de fichier ! \nVotre sauvegarde a échoué !",
								"Erreur", JOptionPane.ERROR_MESSAGE);
			}
		}
		return c;
	}

	public static File chargCircuitBase() {
		JFileChooser choix = new JFileChooser("track09/");
		ExtFileFilter filtre = new ExtFileFilter(".trk", "Fichier circuit");
		choix.addChoosableFileFilter(filtre);
		File file;
		if (choix.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			file = choix.getSelectedFile();
			// Si l'extension est valide
			if (choix.getFileFilter().accept(file)) {
				maj(file);
				chargPara(file);
				return file;
			} else {
				// Si vous n'avez pas spécifié une extension valide !
				JOptionPane
						.showMessageDialog(
								null,
								"Erreur d'extension de fichier ! \nVotre sauvegarde a échoué !",
								"Erreur", JOptionPane.ERROR_MESSAGE);
			}
		}
		return null;
	}

	public static File chargCircuitBase(String name) {
		File file;
		file = new File(name);
		maj(file);

		return file;
	}

	public static CircuitExtends chargCircuitFic(File fic) {
		CircuitExtends c = null;
		try {
			maj(fic);
			ObjectInputStream ois = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(fic)));
			c = (CircuitExtends) ois.readObject();
			//CircuitZone cz = new CircuitZone(c);
			c.setDijk(new Dijkstra(c));
			c.getDijk().calcule();
			chargPara(fic);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	private static void chargPara(File fic) {
		File thetas = new File(fic.getAbsolutePath() + "Thetas/"
				+ fic.getName() + ".thetas");
		File cmd = new File(fic.getAbsolutePath() + "Commande/" + fic.getName()
				+ ".commande");
		if (thetas.exists())
			SauvegardeParametre.chargThetas(thetas);
		if (cmd.exists())
			SauvegardeParametre.chargCmd(cmd);
	}

	private static void maj(File fic) {
		TestFile.nom_dossier = fic.getParent() + '/';
		TestFile.nom_circuit = fic.getName();
	}

	public static void svCircuit(Circuit c) {
		JFileChooser choix = new JFileChooser("track09/");
		ExtFileFilter filtre = new ExtFileFilter(".trk.seria",
				"Fichier circuit sérialisé");
		choix.addChoosableFileFilter(filtre);
		File file;

		if (choix.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			file = choix.getSelectedFile();
			// Si l'extension est valide
			if (choix.getFileFilter().accept(file)) {
				try {
					ObjectOutputStream oos = new ObjectOutputStream(
							new BufferedOutputStream(new FileOutputStream(file)));
					oos.writeObject(c);
					oos.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				// Si vous n'avez pas spécifié une extension valide !
				JOptionPane
						.showMessageDialog(
								null,
								"Erreur d'extension de fichier ! \nVotre sauvegarde a échoué !",
								"Erreur", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public static void svCircuitFile(CircuitExtends c, File fic) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream(fic)));
			oos.writeObject(c);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}