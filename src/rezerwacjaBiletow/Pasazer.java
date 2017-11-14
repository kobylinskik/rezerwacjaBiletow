package rezerwacjaBiletow;

import java.util.List;
import java.util.ArrayList;

/**
 * Klasa Pasażer zawiera imię i nazwisko pasażera oraz listę jego biletów.
 * @author Karol Kobyliński
 *
 */
public class Pasazer {
	
	//Pola klasy
	
	private static int licznik = 0;
	private int id;
	private String imie;
	private String nazwisko;
	private ArrayList<Bilet> bilety;
	
	/**
	 * Konstruktor klasy Pasażer. Wymaga podania imienia i nazwiska, które zostaną przypisane pasażerowi, ponadto tworzy listę biletów danego pasażera.
	 * @param imie Imię pasażera
	 * @param nazwisko Nazwisko pasażera
	 */
	public Pasazer(String imie, String nazwisko){
		this.imie = imie;
		this.nazwisko = nazwisko;		
		id = ++licznik;
		bilety = new ArrayList<Bilet>();
		BazaDanych.dodajPasazera(this);
	}
	
	public String getImie(){
		return imie;
	}
	
	public String getNazwisko(){
		return nazwisko;
	}
	
	public List<Bilet> getBilety(){
		return bilety;
	}
	
	/**
	 * Dodaje bilet do listy danego pasażera. Metoda jest wywoływana w konstruktorze klasy Bilet; sama w sobie nie jest użyteczna.
	 * @param bilet
	 */
	
	public void dodajBilet(Bilet bilet){
		bilety.add(bilet);
	}	
	
	/**
	 * Metoda usuwająca bilet z listy pasażera. Zmniejsza również o 1 liczbę zajętych miejsc na dany Lot
	 * @param bilet Bilet, który ma zostać odwołany
	 */
	
	public void usunBilet(Bilet bilet){
		bilety.remove(bilet);
		BazaDanych.usunBilet(bilet);
		if(bilet.getKlasa().equals("pierwsza") || bilet.getKlasa().equals("Pierwsza")){
			if(bilet.getOkno())
				bilet.getLot().odwolajPierwszaKlasaOkno();
			else
				bilet.getLot().odwolajPierwszaKlasaSrodek();
		}
		else if(bilet.getKlasa().equals("business") || bilet.getKlasa().equals("Business")){
			if(bilet.getOkno())
				bilet.getLot().odwolajKlasaBusinessOkno();
			else
				bilet.getLot().odwolajKlasaBusinessSrodek();
		}
		else if(bilet.getKlasa().equals("ekonomiczna") || bilet.getKlasa().equals("Ekonomiczna")){
			if(bilet.getOkno())
				bilet.getLot().odwolajKlasaEkonomicznaOkno();
			else
				bilet.getLot().odwolajKlasaEkonomicznaSrodek();
		}
	}

	/**
	 * Wyświetla listę lotów danego pasażera
	 */
	public void wyswietlLoty(){		
		for(int i = 0; i < bilety.size(); i++){
			System.out.println(bilety.get(i).wylotToString());
			System.out.println(bilety.get(i).przylotToString());
		}
	}
	
	@Override
	public String toString(){
		return "Pasażer " + imie + " " + nazwisko + " o ID " + id;
	}
}
