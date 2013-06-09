package li260.InterfaceGraphique.JPanel.Menu.delegation;

import li260.mains.TestFile;

public class VitesseJPanel {
	public void lent() {
		TestFile.sleep = 5;
	}

	public void moyenne() {
		TestFile.sleep = 2;
	}

	public void rapide() {
		TestFile.sleep = 0;
	}
}
