package proze;

import java.awt.Dimension;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import proze.classes.EntityA;
import proze.classes.EntityB;
/**
 * Klasa ktorej zadaniem jest stworzenie gracza.
 * @author Tomasz Palka, Ignacy Katkowski
 * @version 1.0.0  6 maj 2019 18:30
 */
public class Gracz extends ObiektGry implements EntityA{
	 
	/**
	 * Deklaracja zmiennych.
	 */
private double velX=0;
private double velY=0;

Gra gra;
Kontroler kontroler;
//private BufferedImage gracz;

private Tekstury tex;

public Gracz(double x,double y, Tekstury tex, Gra gra, Kontroler kontroler) {
	super(x,y);
	this.tex=tex;
	this.gra=gra;
	this.kontroler=kontroler;
}
/**
 * Definiowanie funkcji.
 */
public void tick() {
	x+=velX;
	y+=velY;
	if(x<=0)
		x=0;
	if(x>=Gra.szerokosc-120)
		x=Gra.szerokosc-120;
	if(y<0)
		y=0;
	if(y>=Gra.wysokosc-90)
		y=Gra.wysokosc-90;
	
	for(int i=0;i<gra.eb.size();i++) {
		EntityB tempEnt=gra.eb.get(i);
		
		if(Physics.Collision(this, tempEnt))
		{
			kontroler.removeEntity(tempEnt);
			Gra.health-=10;
			gra.setPrzeciwnik_killed(gra.getPrzeciwnik_killed()+1);
			gra.seta(gra.geta()+1);
		}
	}
}

/**
 * Getery.
 */
public Rectangle getBounds() {
	return new Rectangle((int)x, (int)y,100,50);
}

public void render(Graphics g) {
	g.drawImage(/*gracz*/ tex.p,(int)x,(int)y,null);
}

public double getX() {
	return x;
}
public double getY() {
	return y;
}
public void setX(double x) {
	this.x=x;
}
public void setY(double y) {
	this.y=y;
}
public void setVelX(double velX) {
	this.velX=velX;
}
public void setVelY(double velY) {
	this.velY=velY;
}
}
