package proze;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
/**
 * Klasa ktorej zadaniem jest stworzenie menu.
 * Singleton
 * @author Tomasz Palka, Ignacy Katkowski
 * @version 1.0.0  8 kwiecien 2019 18:30
 */
public class Menu{
	/**
	 * Deklaracja przyciskow.
	 */
	
	public Rectangle startButton = new Rectangle(Gra.szerokosc/2-50,100,150,50);
	public Rectangle rankingButton = new Rectangle(Gra.szerokosc/2 -50,175,150,50);
	public Rectangle pomocButton = new Rectangle(Gra.szerokosc/2 -50,250,150,50);
	public Rectangle wyjscieButton = new Rectangle(Gra.szerokosc/2 -50,325,150,50);
	
	/**
	 * Rysowanie przyciskow.
	 */
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		startButton.setBounds(Gra.szerokosc/2-50,100,150,50);
		rankingButton.setBounds(Gra.szerokosc/2 -50,175,150,50);
		pomocButton.setBounds(Gra.szerokosc/2 -50,250,150,50);
		wyjscieButton.setBounds(Gra.szerokosc/2 -50,325,150,50);
		
		Font fnt0 = new Font("arial", Font.BOLD, 50);
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("Menu", Gra.szerokosc/2-50, 75);
		
		Font fnt1 = new Font("arial", Font.BOLD, 30);
		g.setFont(fnt1);
		g.drawString("Start", startButton.x+16, startButton.y+35);
		g2d.draw(startButton);
		g.drawString("Ranking", rankingButton.x+16, rankingButton.y+35);
		g2d.draw(rankingButton);
		g.drawString("Pomoc", pomocButton.x+16, pomocButton.y+35);
		g2d.draw(pomocButton);
		g.drawString("Wyjscie", wyjscieButton.x+16, wyjscieButton.y+35);
		g2d.draw(wyjscieButton);
	}
}