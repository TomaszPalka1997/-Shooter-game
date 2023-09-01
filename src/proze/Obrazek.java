package proze;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * Klasa ktorej zadaniem jest wczytywanie obrazu.
 * @author Tomasz Palka, Ignacy Katkowski
 * @version 1.0.0  6 maj 2019 18:30
 */
public class Obrazek {
private BufferedImage obrazek;

public BufferedImage loadImage(String path) throws IOException{
	obrazek=ImageIO.read(getClass().getResource(path));
	return obrazek;
	}
}
