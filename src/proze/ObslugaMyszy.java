package proze;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 * Klasa ktorej zadaniem jest obslugiwanie przyciskow menu.
 * Singleton
 * @author Tomasz Palka, Ignacy Katkowski
 * @version 1.0.0  8 kwiecien 2019 18:30
 */
public class ObslugaMyszy implements MouseListener{

	/**
	 * Obsluga myszy.
	 */
	public void mouseClicked(MouseEvent e) {
		
		
	}

	/**
	 * Obsluga przyciskow.
	 */
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
	
		//start
		if(mx >= Gra.szerokosc /2 -50 && mx <= Gra.szerokosc /2 +100 && Gra.state == Gra.STATE.MENU) {
			if( my>= 100 && my <= 150) {
				Gra.state = Gra.STATE.GAME;
			}
		}
		//renking
		if(mx >= Gra.szerokosc /2 -50 && mx <= Gra.szerokosc /2 +100 && Gra.state == Gra.STATE.MENU) {
			if( my>= 175 && my <= 225) {
				Gra.state = Gra.STATE.REKORDY;
			}
		}
		//pomoc
		if(mx >= Gra.szerokosc /2 -50 && mx <= Gra.szerokosc /2 +100 && Gra.state == Gra.STATE.MENU) {
			if( my>= 250 && my <= 275) {
				Gra.state = Gra.STATE.POMOC;
			}
		}
		//wyjscie
		if(mx >= Gra.szerokosc /2 -50 && mx <= Gra.szerokosc /2 +100 && Gra.state == Gra.STATE.MENU) {
			if( my>= 325 && my <= 375) {
				System.exit(1);
			}
		}
		if(mx >= Gra.szerokosc -140 && mx <= Gra.szerokosc -25 && Gra.state == Gra.STATE.POMOC) {
			if( my>= 15 && my <= 65) {
				Gra.state = Gra.STATE.MENU;
			}
		}
		
		if(mx >= Gra.szerokosc -140 && mx <= Gra.szerokosc -25 && Gra.state == Gra.STATE.REKORDY) {
			if( my>= 15 && my <= 65) {
				Gra.state = Gra.STATE.MENU;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
