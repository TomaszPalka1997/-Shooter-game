package proze;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import proze.classes.EntityA;

/**
 * Klasa ktora tworzy pociski.
 * @author Tomasz Palka, Ignacy Katkowski
 * @version 1.0.0  6 maj 2019 18:30
 */
public class Pocisk extends ObiektGry implements EntityA {
	/**
	 * Deklaracja zmienncyh.
	 */
	private Tekstury tex;
	private Gra gra;
	private Color color1;
	private Kontroler c;
	public Pocisk(double x, double y, Tekstury tex, Kontroler c,Gra gra) {
		
	super(x,y);
	this.tex=tex;
	this.gra=gra;
	this.c=c;
	color1=Color.RED;
}
	/**
	 * Definiowanie funkcji.
	 */
	public void tick() {
		y-=5;
		//if(Physics.Collision(this, gra.eb)) {
		//	System.out.println("kolizja");
			//c.removeEntity(this);
			
			
		//}
		if(y<0) {
			c.removeEntity(this);
		}
	}
	/**
	 * Getery.
	 */
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y,20,20);
	}
public void render(Graphics g) {
	g.setColor(color1);
	g.fillOval((int) (x+50), (int) (y),4,6);
}
public double getY() {
	return y;
}

public double getX() {
	return x;
}
}