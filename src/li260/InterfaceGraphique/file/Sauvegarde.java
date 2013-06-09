package li260.InterfaceGraphique.file;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Sauvegarde {
	public static File svCmd() {
		JFileChooser choix = new JFileChooser("./");
		ExtFileFilter filtre = new ExtFileFilter(".com", "Fichier commande");
		choix.addChoosableFileFilter(filtre);
		File file;

		if (choix.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			file = choix.getSelectedFile();
			// Si l'extension est valide
			if (choix.getFileFilter().accept(file)) {
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

	public static File svImg() {
		JFileChooser choix = new JFileChooser("./");
		ExtFileFilter filtre = new ExtFileFilter(".png", "Fichier image");
		choix.addChoosableFileFilter(filtre);
		File file;

		if (choix.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			file = choix.getSelectedFile();
			// Si l'extension est valide
			if (choix.getFileFilter().accept(file)) {
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
}
