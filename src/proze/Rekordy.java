package proze;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Rekordy {

	public Rectangle powrot = new Rectangle(Gra.szerokosc-140,15,115,50);
	
public void render(Graphics g) {
	Graphics2D g2d = (Graphics2D) g;
		
		Font fnt0 = new Font("arial", Font.BOLD, 50);
		g.setFont(fnt0);
		g.setColor(Color.black);
		g.drawString("Rekordy", Gra.szerokosc/2-75, 55);
		
		Font fnt1 = new Font("arial", Font.BOLD, 25);
		g.setFont(fnt1);
		powrot.setBounds(Gra.szerokosc-140,15,115,50);		
		g.drawString("Powrót", Gra.szerokosc-120, 45);
		g2d.draw(powrot);
		
	}
}
