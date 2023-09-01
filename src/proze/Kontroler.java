package proze;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;
import proze.classes.EntityA;
import proze.classes.EntityB;
/**
 * Klasa ktorej zadaniem jest kontrolowanie zdarzen.
 * @author Tomasz Palka, Ignacy Katkowski
 * @version 1.0.0  6 maj 2019 18:30
 */
public class Kontroler {
	/**
	 * Listy z obiektami.
	 */
private LinkedList<EntityA> ea=new LinkedList<EntityA>();
private LinkedList<EntityB> eb=new LinkedList<EntityB>();

/**
 * Deklaracja zmienncyh.
 */
EntityA enta;	
EntityB entb;	
 Tekstury tex;
Random r=new Random();
private Gra gra;

/**
 * Definiowanie funkcji.
 */
public Kontroler(Tekstury tex, Gra gra) {
	this.tex=tex;
	this.gra=gra;
}

public void createPzeciwnik(int przeciwnik_count) {
	for(int i=0;i<przeciwnik_count;i++) {
		addEntity(new Pzeciwnik(r.nextInt(Gra.szerokosc-50),-10,tex,this,gra));
	}
}
public void tick() {
	//A KLASA
	for(int i=0;i<ea.size();i++) {
		enta=ea.get(i);
		enta.tick();
	}
	
	//B KLASA
		for(int i=0;i<eb.size();i++) {
			entb=eb.get(i);
			entb.tick();
		}
	}
public void render(Graphics g) {
	//A KLASA
	for(int i=0;i<ea.size();i++) {
		enta=ea.get(i);
		enta.render(g);
	}
	
	//B KLASA
		for(int i=0;i<eb.size();i++) {
			entb=eb.get(i);
			entb.render(g);
		}
	
}
public void addEntity(EntityA block) {
	ea.add(block);
}
public void removeEntity(EntityA block) {
	ea.remove(block);
}

public void addEntity(EntityB block) {
	eb.add(block);
}
public void removeEntity(EntityB block) {
	eb.remove(block);
}
/**
 * Getery.
 */
public LinkedList<EntityA> getEntityA(){
	return ea;
}

public LinkedList<EntityB> getEntityB(){
	return eb;
}
}

