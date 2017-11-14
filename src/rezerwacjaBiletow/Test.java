package rezerwacjaBiletow;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test {

	public static void main(String[]args){
		
		System.out.println("Tworzenie samolotów");
		Samolot samolot1 = new Samolot("Boeing 737", 51, 51, 200);
		System.out.println("Powstał obiekt samolot1");
		System.out.println(samolot1.getTyp());
		System.out.println(samolot1.getPierwszaKlasa());
		System.out.println(samolot1.getKlasaBusiness());
		System.out.println(samolot1.getKlasaEkonomiczna());
		
		Samolot samolot2 = new Samolot("Jakas awionetka", 0, 0, 3);
		System.out.println("Powstał obiekt samolot2");
		System.out.println(samolot2.getTyp());
		System.out.println(samolot2.getPierwszaKlasa());
		System.out.println(samolot2.getKlasaBusiness());
		System.out.println(samolot2.getKlasaEkonomiczna());
		
		System.out.println();
		System.out.println("Tworzenie lotnisk");
		
		Lotnisko lotnisko1 = new Lotnisko("Heathrow", "Zjednoczone Królestwo", "Londyn");
		System.out.println("powstał obiekt lotnisko1");
		System.out.println(lotnisko1.getNazwa());
		System.out.println(lotnisko1.getMiasto());
		System.out.println(lotnisko1.getPanstwo());
		
		
		Lotnisko lotnisko2 = new Lotnisko("Okęcie", "Polska", "Warszawa");
		System.out.println("powstał obiekt lotnisko2");
		System.out.println(lotnisko2.getNazwa());
		System.out.println(lotnisko2.getMiasto());
		System.out.println(lotnisko2.getPanstwo());
		
		System.out.println();
		System.out.println("Tworzenie lotów");
		Lot lot1 = new Lot(lotnisko1, lotnisko2, 8, 15, 23, 10, 2017, 10, 20, 23, 10, 2017, samolot1, 600, 300, 100);
		System.out.println("powstał obiekt lot1");
		System.out.println(lot1.getMiejsceStartu().getMiasto());
		System.out.println(lot1.getCzasWylotu().getTime());
		System.out.println(lot1.getCzasPrzylotu().getTime());
		System.out.println(lot1.getCenaKlPierwsza());
		System.out.println(lot1.getCenaKlBusiness());
		System.out.println(lot1.getCenaKlEkonomiczna());
		System.out.println(lot1.getWolneMiejscaKlPierwszaOkno());
		System.out.println(lot1.getWolneMiejscaKlPierwszaSrodek());
		System.out.println(lot1.getWolneMiejscaKlBusinessOkno());
		System.out.println(lot1.getWolneMiejscaKlBusinessSrodek());
		System.out.println(lot1.getWolneMiejscaKlEkonomicznaOkno());
		System.out.println(lot1.getWolneMiejscaKlEkonomicznaSrodek());
		
		
		Calendar czasWylotu2 = new GregorianCalendar(2017, 10, 25, 12, 30);
		Calendar czasPrzylotu2 = new GregorianCalendar(2017, 10, 25, 14, 50);
		Lot lot2 = new Lot(lotnisko2, lotnisko1, czasWylotu2, czasPrzylotu2, samolot2, 600, 300, 100);
		System.out.println("powstał obiekt lot2");
		System.out.println(lot2.getMiejsceStartu().getMiasto());
		System.out.println(lot2.getCzasWylotu().getTime());
		System.out.println(lot2.getCzasPrzylotu().getTime());
		System.out.println(lot2.getCenaKlPierwsza());
		System.out.println(lot2.getCenaKlBusiness());
		System.out.println(lot2.getCenaKlEkonomiczna());
		System.out.println(lot2.getWolneMiejscaKlPierwszaOkno());
		System.out.println(lot2.getWolneMiejscaKlPierwszaSrodek());
		System.out.println(lot2.getWolneMiejscaKlBusinessOkno());
		System.out.println(lot2.getWolneMiejscaKlBusinessSrodek());
		System.out.println(lot2.getWolneMiejscaKlEkonomicznaOkno());
		System.out.println(lot2.getWolneMiejscaKlEkonomicznaSrodek());
		
		System.out.println();
		System.out.println("Tworzenie pasażerów");
		
		Pasazer janKowalski = new Pasazer("Jan", "Kowalski");
		System.out.println(janKowalski.getImie());
		System.out.println(janKowalski.getNazwisko());
		janKowalski.wyswietlLoty();
		
		Pasazer mariaKowalska = new Pasazer("Maria", "Kowalska");
		System.out.println(mariaKowalska.getImie());
		System.out.println(mariaKowalska.getNazwisko());
		
		Pasazer zbigniewNowak = new Pasazer("Zbigniew", "Nowak");
		System.out.println(zbigniewNowak.getImie());
		System.out.println(zbigniewNowak.getNazwisko());
		
		Pasazer aleksandraKwiatkowska = new Pasazer("Aleksanda", "Kwiatkowska");
		System.out.println(aleksandraKwiatkowska.getImie());
		System.out.println(aleksandraKwiatkowska.getNazwisko());
		
		System.out.println();
		System.out.println("Rezerwacje lotów");
		
		System.out.println("Rezerwacja w klasie pierwszej przy oknie, lot1, Jan Kowalski.");
		Bilet.rezerwuj(lot1, "pierwsza", true, janKowalski);
		
		System.out.println("Rezerwacja w klasie askas przy oknie, lot1, Jan Kowalski.");
		Bilet.rezerwuj(lot1, "askas", true, janKowalski);

		System.out.println("Rezerwacja w klasie business przy oknie, lot2,  Jan Kowalski.");
		Bilet.rezerwuj(lot2, "business", true, janKowalski);
		
		System.out.println("Rezerwacja w klasie ekonomicznej przy oknie, lot2, Jan Kowalski.");
		Bilet.rezerwuj(lot2, "ekonomiczna", true, janKowalski);
		
		System.out.println("Rezerwacja w klasie ekonomicznej na środku, lot2, Maria Kowalska.");
		Bilet.rezerwuj(lot2, "ekonomiczna", false, mariaKowalska);
		
		System.out.println("Rezerwacja w klasie ekonomicznej na środku, lot2, Aleksandra Kwiatkowska.");
		Bilet.rezerwuj(lot2, "ekonomiczna", false, aleksandraKwiatkowska);
		
		System.out.println("Rezerwacja w klasie ekonomicznej przy oknie, lot2, Aleksandra Kwiatkowska.");
		Bilet.rezerwuj(lot2, "ekonomiczna", true, aleksandraKwiatkowska);
		
		System.out.println("Rezerwacja w klasie ekonomicznej przy oknie, lot2, Zbigniew Nowak.");
		Bilet.rezerwuj(lot2, "ekonomiczna", true, zbigniewNowak);
		
		System.out.println("Zmiana samolotu na samolot1 w obiekcie lot2");
		lot2.setSamolot(samolot1);
		
		System.out.println("Nowe ilości wolnych miejsc w klasach na lot2: ");
		System.out.println(lot2.getWolneMiejscaKlPierwszaOkno());
		System.out.println(lot2.getWolneMiejscaKlPierwszaSrodek());
		System.out.println(lot2.getWolneMiejscaKlBusinessOkno());
		System.out.println(lot2.getWolneMiejscaKlBusinessSrodek());
		System.out.println(lot2.getWolneMiejscaKlEkonomicznaOkno());
		System.out.println(lot2.getWolneMiejscaKlEkonomicznaSrodek());
		
		System.out.println("Rezerwacja w klasie ekonomicznej przy oknie, lot2, Zbigniew Nowak.");
		Bilet.rezerwuj(lot2, "ekonomiczna", true, zbigniewNowak);
		
		System.out.println("Loty Zbigniewa Nowaka przed odwołaniem: ");
		zbigniewNowak.wyswietlLoty();
		
		
		System.out.println("Próba ponownej zmiany na samolot2 po dorezerwowaniu miejsca: ");
		lot2.setSamolot(samolot2);
		
		System.out.println("Nowe ilości wolnych miejsc w klasach na lot2: ");
		System.out.println(lot2.getWolneMiejscaKlPierwszaOkno());
		System.out.println(lot2.getWolneMiejscaKlPierwszaSrodek());
		System.out.println(lot2.getWolneMiejscaKlBusinessOkno());
		System.out.println(lot2.getWolneMiejscaKlBusinessSrodek());
		System.out.println(lot2.getWolneMiejscaKlEkonomicznaOkno());
		System.out.println(lot2.getWolneMiejscaKlEkonomicznaSrodek());
		
		zbigniewNowak.usunBilet(zbigniewNowak.getBilety().get(0));
		System.out.println("Loty Zbigniewa Nowaka po odwołaniu: ");
		zbigniewNowak.wyswietlLoty();
		
		System.out.println(janKowalski);
		
		System.out.println(janKowalski.getBilety().get(0));
		
		System.out.println();
		System.out.print("Metody drukowania z bazy danych: ");		
		System.out.println(BazaDanych.drukujSamoloty());
		System.out.println(BazaDanych.drukujLotniska());
		System.out.println(BazaDanych.drukujLoty());
		System.out.println(BazaDanych.drukujBilety());
		System.out.println(BazaDanych.drukujPasazerow());
		

	}
}
