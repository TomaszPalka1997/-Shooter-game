package proze;

import java.awt.Rectangle;
/**
 * Klasa ktorej zadaniem jest tworzenie wszystkich obiektow gry.
 * @author Tomasz Palka, Ignacy Katkowski
 * @version 1.0.0  6 maj 2019 18:30
 */
public class ObiektGry {
	/**
	 * Deklaracja zmienncyh.
	 */
	public double x, y;
	/**
	 * Definiowanie funkcji.
	 */
	public  ObiektGry(double x,double y) {
		this.x=x;
		this.y=y;
	}
	
	public Rectangle getBounds(int width,int height) {
		return new Rectangle((int)x, (int)y,width,height);
	}
}
