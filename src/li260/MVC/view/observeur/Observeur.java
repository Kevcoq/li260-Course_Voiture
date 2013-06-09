package li260.MVC.view.observeur;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public interface Observeur {
	public void print(BufferedImage im);

	public void print(Graphics g);
}
