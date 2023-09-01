package proze;

import java.util.LinkedList;

import proze.classes.EntityA;
import proze.classes.EntityB;
/**
 * Klasa ktorej jest odpowiedzialna za cialo obiektow gry.
 * @author Tomasz Palka, Ignacy Katkowski
 * @version 1.0.0  6 maj 2019 18:30
 */
public class Physics {
	/**
	 * Definiowanie funkcji.
	 */
	public static boolean Collision(EntityA enta, EntityB entb) {
		
			if(enta.getBounds().intersects(entb.getBounds())) {
				return true;
			
		}
		return false;
	}
	
	public static boolean Collision(EntityB entb, EntityA enta) {
		
			if(entb.getBounds().intersects(enta.getBounds())) {
				return true;
		}
		return false;
	}
}
