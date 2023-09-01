package proze;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import java.io.IOException;
/**
 * Klasa ktora tworzy samolot.
 * @author Tomasz Palka, Ignacy Katkowski
 * @version 1.0.0  6 maj 2019 18:30
 */
public class Samolot {
	
private BufferedImage obraz;

/**
 * Definiowanie funkcji.
 */
public static BufferedImage resize(BufferedImage img, int newW, int newH) { 
    Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
    BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

    Graphics2D g2d = dimg.createGraphics();
    g2d.drawImage(tmp, 0, 0, null);
    g2d.dispose();

    return dimg;
}  
public BufferedImage loadImage(String path) throws IOException{
	Parsowanie.setConstants();
	double x=(Parsowanie.pocztkowaSzerokoscObiektuGryJakoProcentPoczatkowejSzerokosciPlanszy/100)*Parsowanie.poczatkowaSzerokoscPlanszy;
	Double y= x;
	int settingSize=y.intValue();
	obraz=ImageIO.read(getClass().getResource(path));
	BufferedImage resized=resize(obraz,settingSize*2, settingSize);
	return resized;
}
}
