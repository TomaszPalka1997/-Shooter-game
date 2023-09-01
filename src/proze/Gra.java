package proze;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import proze.classes.EntityA;
import proze.classes.EntityB;

/**
 * Klasa ktorej zadaniem jest stworzenie okna gry.
 * @author Tomasz Palka, Ignacy Katkowski
 * @version 1.0.0  8 kwiecien 2019 18:30
 */
public class Gra extends Canvas implements Runnable
{
	/**
	 * zmienne
	 */
	private static final long serialVersionUID = 1L;
	public static int szerokosc=0;
	public static int wysokosc=0;
	public static int a=0;
	public static String tytul="0";
	public static Color tloGry;
	private boolean odpalone=false;
	private Thread watek;
	JFrame oknoGry;
	String pa, pa2;
	private Menu menu;
	private Pomoc pomoc;
	private Rekordy rekordy;
	private boolean pauza=false;
	
	private boolean is_shooting=false;
	
	private int przeciwnik_count=5;
	private int przeciwnik_killed=0;
	

	Image img = Toolkit.getDefaultToolkit().createImage("chmury.jpeg");
	private BufferedImage statekGracza=null;
	private BufferedImage statekPrzeciwnika=null;
	
	private Kontroler c;
	private Gracz p;
	private Tekstury tex;
	private int i=0;
	
	public static enum STATE{
		MENU,
		GAME,
		POMOC,
		REKORDY
	}
	public static STATE state = STATE.MENU;
	
	public LinkedList<EntityA> ea;
	public LinkedList<EntityB> eb;
	public static int health=100;
	/**
	 * Definicja funkcji.
	 */
	
	public void init() {
		Parsowanie.setConstants();
		System.out.println(Parsowanie.obiektyGry);
		if(Parsowanie.obiektyGry.equals("plikGraficzny")) {
			pa="/xd.png";
			pa2="/samolot2.png";}
		else if(Parsowanie.figuraObiektuGry.equals("trojkaty")) {
			pa="/tr2.png";
			pa2="/tr.png";}
		else if(Parsowanie.figuraObiektuGry.equals("kwadraty")) {
			pa="/kw1.png"; 
			pa2="/kw2.png"; }
		else if(Parsowanie.figuraObiektuGry.equals("kolka")) {
			pa="/ka.png";
			pa2="/kb.png";}
		
		else if(Parsowanie.figuraObiektuGry.equals("prostokaty")) {
			pa="/pr.png";
			pa2="/pr2.png";}
		
		requestFocus();
		Samolot loader=new Samolot();
		try {
			statekGracza=loader.loadImage(pa);
		}catch(IOException e) {
			e.printStackTrace();
		}
		Samolot loader2=new Samolot();
		try {
			statekPrzeciwnika=loader2.loadImage(pa2);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		addKeyListener(new ObslugaKlawiatury(this));
		
		tex=new Tekstury(this);
		
		c=new Kontroler(tex, this);
		p=new Gracz(szerokosc/2,wysokosc, tex,this,c);
		menu = new Menu();
		pomoc = new Pomoc();
		rekordy = new Rekordy();
		
		ea=c.getEntityA();
		eb=c.getEntityB();
		
		c.createPzeciwnik(przeciwnik_count);
		
		this.addMouseListener(new ObslugaMyszy());
	}
	
	public synchronized void start() {
		if(odpalone)
			return;
		
		odpalone=true;
		watek=new Thread(this);
		watek.start();
	}
	
	private synchronized void stop() {
		if(!odpalone)
			return;
		
		odpalone=false;
		try {
		watek.join();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
		System.exit(1);
	}
	public void odpalenie(JFrame fr) {
		init();
		long ostatniCzas=System.nanoTime();
		final double ticks=60.0;
		double ns = 1000000000 / ticks;
		double delta=0;
		int updates=0;
		int frames=0;
		long timer=System.currentTimeMillis();
		while(odpalone) {
			szerokosc=rozmiar_szerokosc(fr);
			wysokosc=rozmiar_wysokosc(fr);
			long teraz=System.nanoTime();
			delta += (teraz-ostatniCzas)/ns;
			ostatniCzas=teraz;
			if(delta>=1) {
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis()-timer>1000) {
				timer+=1000;
				updates=0;
				frames=0;
				
			}
		}
		stop();
	}
	private static int rozmiar_wysokosc(JFrame fr) {
		return fr.getHeight();
	}
	private static int rozmiar_szerokosc(JFrame fr) {
		return fr.getWidth();
	}
	private void tick() {
		if(state == STATE.GAME) {
			if(pauza) {
				pauza=true;
				}else
				{
					p.tick();
					c.tick();}
			
		
		}else if(state == STATE.MENU) {
			//oknoGry.setVisible(false);
		}
		
		
		if(przeciwnik_killed>=przeciwnik_count) 
		{
			przeciwnik_count+=2;
			przeciwnik_killed=0;
			c.createPzeciwnik(przeciwnik_count);
		}
	}
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs==null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g=bs.getDrawGraphics();
		if(Parsowanie.tlo.equals("plikGraficzny"))
		g.drawImage(img,0,0,szerokosc,wysokosc,this);
		else {
		Color tloGry = new Color(Integer.parseInt(Parsowanie.mojeKolory[0]),Integer.parseInt(Parsowanie.mojeKolory[1]),Integer.parseInt(Parsowanie.mojeKolory[2]));
		g.setColor(tloGry);
		g.fillRect(0, 0, szerokosc, wysokosc);}
		
		if(state == STATE.GAME){
			
			p.render(g);
			c.render(g);
			
			g.setColor(Color.gray);
			g.fillRect(5,5,100,10);
			
			g.setColor(Color.green);
			g.fillRect(5,5,health,10);
			
			g.setColor(Color.white);
			g.drawRect(5,5,100,10);
			
			
			g.drawString(String.valueOf(a), 120, 15);
			 if(health<=0)
			{
				state=STATE.MENU;
				g.drawString("kutas", 120, 15);
				health=100;
				a=0;
			}

		}else if(state == STATE.MENU) {
			menu.render(g);
		}else if(state == STATE.REKORDY) {
			rekordy.render(g);
		}else if(state == STATE.POMOC) {
			pomoc.render(g);
		}
			
		g.dispose();
		bs.show();
	}
	/**
	 *Obsluga klawiatury.
	 */
public void keyPressed(KeyEvent e) {
		int key=e.getKeyCode();
		
		if(state == STATE.GAME) {
		if(key==KeyEvent.VK_RIGHT) {
			p.setVelX(7);
		}else if(key==KeyEvent.VK_LEFT){
			p.setVelX(-7);
		}else if(key==KeyEvent.VK_DOWN){
			p.setVelY(7);;
		}else if(key==KeyEvent.VK_UP){
			p.setVelY(-7);
		}else if(key==KeyEvent.VK_SPACE && !is_shooting) {
			c.addEntity(new Pocisk(p.getX(),p.getY(),tex, c, this));
			is_shooting=true;
		}
		else if(key==KeyEvent.VK_ESCAPE) {
			
			if (i%2==0) {
				i++;
			pauza=true;
			}
			else if(i%2==1) {
				pauza=false;
				i--;
			}
		}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key=e.getKeyCode();
		if(key==KeyEvent.VK_RIGHT) {
			p.setVelX(0);
		}else if(key==KeyEvent.VK_LEFT){
			p.setVelX(0);
		}else if(key==KeyEvent.VK_DOWN){
			p.setVelY(0);;
		}else if(key==KeyEvent.VK_UP){
			p.setVelY(0);
		}else if(key==KeyEvent.VK_SPACE) {
			is_shooting=false;
		}
	}
	
	void f()
	{
		//System.out.println(statekGracza.getWidth());
	}
	/**
	 * Funckja main.
	 */
	public static void main(String[] args) {
	
		
		
	
		Parsowanie.setConstants();
		szerokosc=Parsowanie.poczatkowaSzerokoscPlanszy;
		wysokosc=Parsowanie.poczatkowaWysokoscPlanszy;
		tytul=Parsowanie.nazwaGry;
		
		Gra gra= new Gra();
	
		gra.setPreferredSize(new Dimension(szerokosc,wysokosc));
		gra.setMaximumSize(new Dimension(szerokosc,wysokosc));
		gra.setMinimumSize(new Dimension(szerokosc,wysokosc));
		JFrame oknoGry=new JFrame(tytul);
		oknoGry.setBounds(0,0,szerokosc,wysokosc);
		oknoGry.add(gra);
		oknoGry.pack();
		oknoGry.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		oknoGry.setResizable(true);
		oknoGry.setLocationRelativeTo(null);
		oknoGry.setVisible(true);
		gra.start();
		gra.odpalenie(oknoGry);
		
	}
	
	/**
	 * Getery.
	 */
	
	public BufferedImage getStatekGracza() {
		return statekGracza; 
	}
	
	public BufferedImage getStatekPrzeciwnika() {
		return statekPrzeciwnika;
	}
	public int y() {
		return statekPrzeciwnika.getHeight(); 
		
	}
	public int x() {
		return statekPrzeciwnika.getWidth();
	}
	
	public int getPrzeciwnik_count() {
		return przeciwnik_count;
	}

	public void setPrzeciwnik_count(int przeciwnik_count) {
		this.przeciwnik_count = przeciwnik_count;
	}

	public int getPrzeciwnik_killed() {
		return przeciwnik_killed;
	}

	public void setPrzeciwnik_killed(int przeciwnik_killed) {
		this.przeciwnik_killed = przeciwnik_killed;
	}
	public void seta(int a) {
		this.a = a;
	}
	public int geta() {
		return a;
	}

	
	public void run() {
		
		
	}
}