package proze;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 * Klasa ktorej zadaniem jest obslugiwanie klawiatury.
 * @author Tomasz Palka, Ignacy Katkowski
 * @version 1.0.0  6 maj 2019 18:30
 */
public class ObslugaKlawiatury extends KeyAdapter {
	Gra gra;
	/**
	 * Definiowanie funkcji.
	 */
	public ObslugaKlawiatury(Gra gra) {
		this.gra=gra;
	}
	public void keyPressed(KeyEvent e) {
		gra.keyPressed(e);
	}
	
	public void keyReleased(KeyEvent e) {
		gra.keyReleased(e);
	}
}
