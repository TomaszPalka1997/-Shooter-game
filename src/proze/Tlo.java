package proze;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

/**
 * Klasa ktorej zadaniem jest stworzenie tla z pliku.
 * Singleton
 * @author Tomasz Palka, Ignacy Katkowski
 * @version 1.0.0  8 kwiecien 2019 18:30
 */
public class Tlo extends JPanel {
	
	private static final long serialVersionUID = 1L;
	Image img;
/**
 * Deklaracja zmienncyh.
 */
public Tlo()
{
	img = Toolkit.getDefaultToolkit().createImage("chmury.jpeg");
}
public void paintComponent(Graphics g)
{
	int width = getSize().width;
	int height = getSize().height;
	g.drawImage(img,0,0,width,height,this);
}
}