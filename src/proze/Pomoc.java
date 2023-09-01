package proze;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public class Pomoc {

	public Rectangle powrot = new Rectangle(Gra.szerokosc-140,15,115,50);
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		Font fnt0 = new Font("arial", Font.BOLD, 50);
		g.setFont(fnt0);
		g.setColor(Color.black);
		g.drawString("Pomoc", Gra.szerokosc/2-75, 55);
		
		Font fnt1 = new Font("arial", Font.BOLD, 25);
		g.setFont(fnt1);
		g.drawString("Punktowanie", Gra.szerokosc/2-70, 100);
		g.drawString("Poziomy Trudności", Gra.szerokosc/2-110, 200);
		g.drawString("Strzelanie", Gra.szerokosc/2-50, 300);
		g.drawString("Elementy Dodatkowe", Gra.szerokosc/2-105, 400);
		
		Font fnt2 = new Font("jazz let", Font.BOLD, 15);
		g.setFont(fnt2);
		g.drawString("Za zabicie zwykłego przeciwnika dostaje sie 10 pkt, za zabicie bosa ", Gra.szerokosc/2-300, 120);
		g.drawString("100 punktów. Punkty sa wyswietlane na koniec gry w centralnej czesci\r\n" , Gra.szerokosc/2-300, 135);
		g.drawString("ekranu i jesli gracz zakwalifikował sie wsród 10 najlepszych zdobytych\r\n" , Gra.szerokosc/2-300, 150);
		g.drawString("punktów, to wynik zostanie zapisany w tabeli rekordów.", Gra.szerokosc/2-300, 165);
		
		
		g.drawString("Poziomy trudnosci róznia sie predkoscia poruszania sie przeciwników ", Gra.szerokosc/2-300, 220);
		g.drawString("czestotliwoscia strzelania przez nich oraz na najwyzszym poziomie obrazenia ", Gra.szerokosc/2-300, 235);
		g.drawString("zadawane przez bohatera sa dwa razy mniejsze, tzn. zwykłego przeciwnika", Gra.szerokosc/2-300, 250);
		g.drawString("trzeba strzelic 2 razy a bosa 20 zamiast 10 oraz liczba punktów zycia gracza.", Gra.szerokosc/2-300, 265);
		
		g.drawString("Uzytkownik strzela czerwonym laserem, przeciwnicy zielonym. Jako", Gra.szerokosc/2-300, 320);
		g.drawString("bonus mozna wylosowac lepsza bron czyli rakiety, które zadaja tyle", Gra.szerokosc/2-300, 335);
		g.drawString("samo obrazen co zwykły laser, ale wybuchaja po trafieniu celu i wylatuja", Gra.szerokosc/2-300, 350);
		g.drawString("z niej 4 lasery w innych kierunkach.", Gra.szerokosc/2-300, 365);
		
		g.drawString("Po przejsciu mapy na koniec pojawia sie super przeciwnik(bos), który", Gra.szerokosc/2-300, 420);
		g.drawString("ma wiecej punktów zycia.", Gra.szerokosc/2-300, 435);
		g.drawString("Jezeli uzytkownik zestrzeli 5 przeciwników bez chybienia na mapie", Gra.szerokosc/2-300, 450);
		g.drawString("pojawia sie bonus (punkt zycia, ulepszona bron, dodatkowe punkty,", Gra.szerokosc/2-300, 465);
		g.drawString("niesmiertelnosc na okreslony czas(zalezny od poziomu trudnosci)", Gra.szerokosc/2-300, 480);
		
		g.setFont(fnt1);
		powrot.setBounds(Gra.szerokosc-140,15,115,50);		
		g.drawString("Powrót", Gra.szerokosc-120, 45);
		g2d.draw(powrot);
	}
}
