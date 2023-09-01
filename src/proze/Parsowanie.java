package proze;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Klasa ktorej zadaniem jest parsowanie plikow konfiguracyjnych gry.
 * Singleton
 * @author Tomasz Palka, Ignacy Katkowski
 * @version 1.0.0  8 kwiecien 2019 18:30
 */

public class Parsowanie {
	/**
	 * Deklaracja zmiennych.
	 */
	
	public static double pocztkowaSzerokoscObiektuGryJakoProcentPoczatkowejSzerokosciPlanszy;
	public static int poczatkowaSzerokoscPlanszy;
	public static int poczatkowaWysokoscPlanszy;
	public static String nazwaGry;
	public static int liczbaPoziomow;
	public static int liczbaStopniTrudnosci;
	public static int numeracjaPoziomowZaczynaSieOd;
	public static String tlo;
	public static String kolorTla;
	public static String nazwaBazowaPlikuZOpisemPoziomu;
	public static int zmianaStopniaTrudnosci;
	public static String rozszerzeniePlikuZOpisemPoziomu;
	public static String figuraObiektuGry;
	public static String plikTla;
	public static String kolorsy;
	public static String obiektyGry;
	public static String[] mojeKolory;
	
	/**
	 * Metoda otwierajaca plik "par.txt" i pobiera z niego parametry gry wraz z geterami.
	 */
public static void setConstants(){
	
	Properties prop = new Properties();
	InputStream input = null;
	try {
		input = new FileInputStream("par.txt");
				prop.load(input);
		nazwaBazowaPlikuZOpisemPoziomu=prop.getProperty("nazwaBazowaPlikuZOpisemPoziomu");
		tlo=prop.getProperty("tlo");
		obiektyGry=prop.getProperty("obiektyGry");
		figuraObiektuGry=prop.getProperty("figuraObiektuGry");
		poczatkowaSzerokoscPlanszy=Integer.parseInt(prop.getProperty("poczatkowaSzerokoscPlanszy"));
		poczatkowaWysokoscPlanszy=Integer.parseInt(prop.getProperty("poczatkowaWysokoscPlanszy"));
		liczbaPoziomow=Integer.parseInt(prop.getProperty("liczbaPoziomow"));
		numeracjaPoziomowZaczynaSieOd=Integer.parseInt(prop.getProperty("numeracjaPoziomowZaczynaSieOd"));
		nazwaGry=prop.getProperty("nazwaGry");
		pocztkowaSzerokoscObiektuGryJakoProcentPoczatkowejSzerokosciPlanszy=Double.parseDouble(prop.getProperty("pocztkowaSzerokoscObiektuGryJakoProcentPoczatkowejSzerokosciPlanszy"));
		liczbaStopniTrudnosci=Integer.parseInt(prop.getProperty("liczbaStopniTrudnosci"));
		zmianaStopniaTrudnosci=Integer.parseInt(prop.getProperty("zmianaStopniaTrudnosci"));
		rozszerzeniePlikuZOpisemPoziomu=prop.getProperty("rozszerzeniePlikuZOpisemPoziomu");
		
		if(tlo.contentEquals("jednolite")) {
			kolorsy=prop.getProperty("kolorTla");
			mojeKolory=kolorsy.split(" ");
		}
		else {
			plikTla=prop.getProperty("plikTla");
		}
	} 
	catch (IOException ex) {
		ex.printStackTrace();
	} 
	finally {
		if (input != null) {
			try {
				input.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
}