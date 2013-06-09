package li260.InterfaceGraphique.JPanel;

import java.util.ArrayList;

import javax.swing.JLabel;

public class FenetreTools {
	public static JLabel trouve(String name, ArrayList<JLabel> jLab) {
		if (jLab != null && jLab.size() < 1)
			return null;
		for (JLabel i : jLab)
			if (i.getName().equals(name))
				return i;
		return null;
	}
}
