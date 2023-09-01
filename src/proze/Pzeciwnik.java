package proze;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import proze.classes.EntityA;
import proze.classes.EntityB;
/**
 * Klasa ktora tworzy przeciwnikow.
 * @author Tomasz Palka, Ignacy Katkowski
 * @version 1.0.0  6 maj 2019 18:30
 */
public class Pzeciwnik extends ObiektGry implements EntityB {

	
	/**
	 * Deklaracja zmienncyh.
	 */
	Random r=new Random();
	
	private int speed=r.nextInt(2)+1;
	
	private Tekstury tex;
	private Gra gra;
	private Kontroler c;
	
	public Pzeciwnik(double x, double y, Tekstury tex, Kontroler c, Gra gra) {
		super(x,y);
		this.tex=tex;
		this.c=c;
		this.gra=gra;
	}
	/**
	 * Definiowanie funkcji.
	 */
public void tick() {
	y+=speed;
	
	if(y>Gra.wysokosc) {
		speed=r.nextInt(3)+1;
		x=r.nextInt(Gra.szerokosc);
		y=-10;
	}
	if(x>Gra.szerokosc-70) {
		x=Gra.szerokosc -70;
	}
	
	for(int i=0;i<gra.ea.size();i++) {
		EntityA tempEnt=gra.ea.get(i);
		
		if(Physics.Collision(this, tempEnt)) {
			c.removeEntity(tempEnt);
			c.removeEntity(this);
			gra.setPrzeciwnik_killed(gra.getPrzeciwnik_killed()+1);
			gra.seta(gra.geta()+1);
		}
	}
	
}

public void render(Graphics g) {
g.drawImage(tex.enemy,(int)x,(int)y,null);
}

/**
 * Getery.
 */
public Rectangle getBounds() {
	return new Rectangle((int)x, (int)y,20,50);
}

public double getY() {
	return y;
}

public void setY(double y) {
	this.y=y;
}

public double getX() {
	return x;
}
}
