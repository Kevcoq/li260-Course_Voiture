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
import li260.Plateau.voiture.Voiture;
import li260.Tactique.strategie.Strategie;

public class SauvegardeStrategie {
	public static Strategie chargStrategie(Circuit c, Voiture v) {
		Strategie strat = null;
		JFileChooser choix = new JFileChooser("strat/");
		ExtFileFilter filtre = new ExtFileFilter(".strat",
				"Fichier strategie sérialisé");
		choix.addChoosableFileFilter(filtre);
		File file;

		if (choix.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			file = choix.getSelectedFile();
			// Si l'extension est valide
			if (choix.getFileFilter().accept(file)) {
				try {
					ObjectInputStream ois = new ObjectInputStream(
							new BufferedInputStream(new FileInputStream(file)));

					try {
						strat = (Strategie) ois.readObject();
						strat.init(c, v);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

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
		return strat;
	}

	public static void svStrategie(Strategie strat) {
		JFileChooser choix = new JFileChooser("strat/");
		ExtFileFilter filtre = new ExtFileFilter(".strat",
				"Fichier strategie sérialisé");
		choix.addChoosableFileFilter(filtre);
		File file;

		if (choix.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			file = choix.getSelectedFile();
			// Si l'extension est valide
			if (choix.getFileFilter().accept(file)) {
				try {
					ObjectOutputStream oos = new ObjectOutputStream(
							new BufferedOutputStream(new FileOutputStream(file)));
					oos.writeObject(strat);
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
}