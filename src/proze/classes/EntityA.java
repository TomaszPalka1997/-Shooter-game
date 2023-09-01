package proze.classes;

import java.awt.Graphics;
import java.awt.Rectangle;
/**
 * Interface gracza i pociskow.
 * @author Tomasz Palka, Ignacy Katkowski
 * @version 1.0.0  6 maj 2019 18:30
 */
public interface EntityA {
	/**
	 * Definiowanie funkcji.
	 */
	public void tick();
	public void render(Graphics g);
	public Rectangle getBounds();

public double getX();
public double getY();

}
