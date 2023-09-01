package proze;

import java.awt.image.BufferedImage;
/**
 * Klasa ktora tworzy tekstury.
 * @author Tomasz Palka, Ignacy Katkowski
 * @version 1.0.0  6 maj 2019 18:30
 */
public class Tekstury {

	public BufferedImage p,missile,enemy;
	
	private StatekGracza ss;
	private StatekGracza xd;
	/**
	 * Definiowanie funkcji.
	 */
	public Tekstury(Gra gra){
		ss=new StatekGracza(gra.getStatekGracza());
		xd=new StatekGracza(gra.getStatekPrzeciwnika());
		
		getTekstury(gra);
	}
	
	private void getTekstury(Gra gra) {
		p=ss.grabImage(1,1,gra.x(),gra.y());
		enemy=xd.grabImage(1,1,gra.x(),gra.y());
	}
}
