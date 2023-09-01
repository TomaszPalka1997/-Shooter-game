package proze;

import java.awt.image.BufferedImage;
/**
 * Klasa ktora tworzy statek gracza.
 * @author Tomasz Palka, Ignacy Katkowski
 * @version 1.0.0  6 maj 2019 18:30
 */
public class StatekGracza {

	private BufferedImage obraz;
	/**
	 * Definiowanie funkcji.
	 */
	public StatekGracza(BufferedImage obraz) {
		    this.obraz=obraz;
	}
	
	public BufferedImage grabImage(int col, int row, int width, int height) {
		BufferedImage img=obraz.getSubimage(0, 0, width, height);
	return img;
	}
}
