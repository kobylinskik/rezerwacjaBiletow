package rezerwacjaBiletow;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Klasa Lot będzie zawierać informacje o dacie i godzinie wylotu i przylotu,
 * miejscu wylotu przylotu a także ilości wolnych miejsc w poszczególnych
 * klasach.</br> Miejsca są podzielone na "okno" i "środek"; połowa miejsc w
 * każdej klasie jest przy oknie, a połowa w środku. Jeśli którakolwiek z klas
 * ma nieparzystą ilość miejsc, przy oknie będzie o jedno miejsce więcej niż na
 * środku.
 * 
 * @author Karol Kobyliński
 * 
 */
public class Lot {

	// Pola klasy

	private Calendar czasWylotu;
	private Calendar czasPrzylotu;
	private Lotnisko miejsceStartu;
	private Lotnisko miejsceLadowania;
	private Samolot samolot;
	private static int licznik = 0;
	private int nrLotu;
	private int klPierwszaOkno;
	private int klPierwszaSrodek;
	private int klBusinessOkno;
	private int klBusinessSrodek;
	private int klEkonomicznaOkno;
	private int klEkonomicznaSrodek;
	private int klPierwszaOknoZajete = 0;
	private int klPierwszaSrodekZajete = 0;
	private int klBusinessOknoZajete = 0;
	private int klBusinessSrodekZajete = 0;
	private int klEkonomicznaOknoZajete = 0;
	private int klEkonomicznaSrodekZajete = 0;
	private int cenaKlPierwsza;
	private int cenaKlBusiness;
	private int cenaKlEkonomiczna;

	/**
	 * Konstruktor pozwalający stworzyć obiekt klasy Lot ze wszystkimi
	 * potrzebnymi parametrami.
	 * 
	 * @param miejsceStartu
	 * @param miejsceLadowania
	 * @param czasWylotu
	 *            Pozwala ustalić czas wylotu przy pomocy jednej zmiennej
	 *            Calendar.
	 * @param czasPrzylotu
	 *            Pozwala ustalić czas przylotu przy pomocy jednej zmiennej
	 *            Calendar.
	 * @param samolot
	 * @param cenaKlPierwsza
	 * @param cenaKlBusiness
	 * @param cenaKlEkonomiczna
	 */
	public Lot(Lotnisko miejsceStartu, Lotnisko miejsceLadowania,
			Calendar czasWylotu, Calendar czasPrzylotu, Samolot samolot,
			int cenaKlPierwsza, int cenaKlBusiness, int cenaKlEkonomiczna) {
		nrLotu = ++licznik;
		this.miejsceStartu = miejsceStartu;
		this.miejsceLadowania = miejsceLadowania;
		this.czasWylotu = czasWylotu;
		this.czasPrzylotu = czasPrzylotu;
		this.samolot = samolot;
		this.cenaKlPierwsza = cenaKlPierwsza;
		this.cenaKlBusiness = cenaKlBusiness;
		this.cenaKlEkonomiczna = cenaKlEkonomiczna;
		klPierwszaSrodek = samolot.getPierwszaKlasa() / 2;
		klPierwszaOkno = samolot.getPierwszaKlasa() - klPierwszaSrodek;
		klBusinessSrodek = samolot.getKlasaBusiness() / 2;
		klBusinessOkno = samolot.getKlasaBusiness() - klBusinessSrodek;
		klEkonomicznaSrodek = samolot.getKlasaEkonomiczna() / 2;
		klEkonomicznaOkno = samolot.getKlasaEkonomiczna() - klEkonomicznaSrodek;
		BazaDanych.dodajLot(this);
	}

	/**
	 * 
	 * Konstruktor pozwalający stworzyć obiekt klasy Lot ze wszystkimi
	 * potrzebnymi parametrami. </br> Pozwala ustalić daty wylotu i przylotu bez
	 * używania parametru typu Calendar; potrzebne zmienne typu Calendar zostaną
	 * zainicjowane przy użyciu wprowadzonych zmiennych typu int.
	 * 
	 * @param miejsceStartu
	 * @param miejsceLadowania
	 * @param godzinaWylotu
	 * @param minutaWylotu
	 * @param dzienWylotu
	 * @param miesiacWylotu
	 * @param rokWylotu
	 * @param godzinaPrzylotu
	 * @param minutaPrzylotu
	 * @param dzienPrzylotu
	 * @param miesiacPrzylotu
	 * @param rokPrzylotu
	 * @param samolot
	 * @param cenaKlPierwsza
	 * @param cenaKlBusiness
	 * @param cenaKlEkonomiczna
	 */
	public Lot(Lotnisko miejsceStartu, Lotnisko miejsceLadowania,
			int godzinaWylotu, int minutaWylotu, int dzienWylotu,
			int miesiacWylotu, int rokWylotu, int godzinaPrzylotu,
			int minutaPrzylotu, int dzienPrzylotu, int miesiacPrzylotu,
			int rokPrzylotu, Samolot samolot, int cenaKlPierwsza,
			int cenaKlBusiness, int cenaKlEkonomiczna) {
		nrLotu = ++licznik;
		this.miejsceStartu = miejsceStartu;
		this.miejsceLadowania = miejsceLadowania;
		this.czasWylotu = new GregorianCalendar(rokWylotu, miesiacWylotu,
				dzienWylotu, godzinaWylotu, minutaWylotu);
		this.czasPrzylotu = new GregorianCalendar(rokPrzylotu, miesiacPrzylotu,
				dzienPrzylotu, godzinaPrzylotu, minutaPrzylotu);
		this.samolot = samolot;
		this.cenaKlPierwsza = cenaKlPierwsza;
		this.cenaKlBusiness = cenaKlBusiness;
		this.cenaKlEkonomiczna = cenaKlEkonomiczna;
		klPierwszaSrodek = samolot.getPierwszaKlasa() / 2;
		klPierwszaOkno = samolot.getPierwszaKlasa() - klPierwszaSrodek;
		klBusinessSrodek = samolot.getKlasaBusiness() / 2;
		klBusinessOkno = samolot.getKlasaBusiness() - klBusinessSrodek;
		klEkonomicznaSrodek = samolot.getKlasaEkonomiczna() / 2;
		klEkonomicznaOkno = samolot.getKlasaEkonomiczna() - klEkonomicznaSrodek;
		BazaDanych.dodajLot(this);
	}

	/**
	 * Metoda pozwalająca zmienić samolot na dany lot. Zmieni się również ilość
	 * dostępnych miejsc w poszczególnych klasach.</br> Metoda nie pozwoli
	 * zmienić samolotu, jeżeli nowy samolot ma w jakiejkolwiek klasie mniej
	 * miejsc niż liczba zarezerwowanych dotychczas biletów.
	 * 
	 * @param samolot
	 *            Nowy typ samolotu, który zostanie przypisany do danego lotu.
	 */

	public void setSamolot(Samolot samolot) {
		if (checkSamolot(samolot)) {
			this.samolot = samolot;
			klPierwszaSrodek = samolot.getPierwszaKlasa() / 2;
			klPierwszaOkno = samolot.getPierwszaKlasa() - klPierwszaSrodek;
			klBusinessSrodek = samolot.getKlasaBusiness() / 2;
			klBusinessOkno = samolot.getKlasaBusiness() - klBusinessSrodek;
			klEkonomicznaSrodek = samolot.getKlasaEkonomiczna() / 2;
			klEkonomicznaOkno = samolot.getKlasaEkonomiczna()
					- klEkonomicznaSrodek;
		} else
			System.out
					.println("Nie można zmienić samolotu, ponieważ nowy samolot posiada zbyt mało miejsc.");

	}

	/**
	 * Metoda sprawdzająca, czy nowy typ samolotu ma wystarczająco dużo miejsc
	 * na dany lot.
	 * 
	 * @param samolot
	 * @return Zwraca true, jeśli samolot ma wystarczająco dużo miejsc na dany
	 *         lot.
	 */
	private boolean checkSamolot(Samolot samolot) {
		return (samolot.getPierwszaKlasa() >= klPierwszaOknoZajete
				+ klPierwszaSrodekZajete
				&& samolot.getKlasaBusiness() >= klBusinessOknoZajete
						+ klBusinessSrodekZajete && samolot
				.getKlasaEkonomiczna() >= klEkonomicznaOknoZajete
				+ klEkonomicznaSrodekZajete);
	}

	// Metody typu set

	public void setCenaKlPierwsza(int cenaKlPierwsza) {
		this.cenaKlPierwsza = cenaKlPierwsza;
	}

	public void setCenaKlBusiness(int cenaKlBusiness) {
		this.cenaKlBusiness = cenaKlBusiness;
	}

	public void setCenaKlEkonomiczna(int cenaKlEkonomiczna) {
		this.cenaKlEkonomiczna = cenaKlEkonomiczna;
	}

	// Metody typu get

	public int getNrLotu() {
		return nrLotu;
	}

	public Lotnisko getMiejsceStartu() {
		return miejsceStartu;
	}

	public Lotnisko getMiejsceLadowania() {
		return miejsceLadowania;
	}

	public Calendar getCzasWylotu() {
		return czasWylotu;
	}

	public Calendar getCzasPrzylotu() {
		return czasPrzylotu;
	}

	public Samolot getSamolot() {
		return samolot;
	}

	public int getCenaKlPierwsza() {
		return cenaKlPierwsza;
	}

	public int getCenaKlBusiness() {
		return cenaKlBusiness;
	}

	public int getCenaKlEkonomiczna() {
		return cenaKlEkonomiczna;
	}

	public int getWolneMiejscaKlPierwszaOkno() {
		return klPierwszaOkno - klPierwszaOknoZajete;
	}

	public int getWolneMiejscaKlPierwszaSrodek() {
		return klPierwszaSrodek - klPierwszaSrodekZajete;
	}

	public int getWolneMiejscaKlBusinessOkno() {
		return klBusinessOkno - klBusinessOknoZajete;
	}

	public int getWolneMiejscaKlBusinessSrodek() {
		return klBusinessSrodek - klBusinessSrodekZajete;
	}

	public int getWolneMiejscaKlEkonomicznaOkno() {
		return klEkonomicznaOkno - klEkonomicznaOknoZajete;
	}

	public int getWolneMiejscaKlEkonomicznaSrodek() {
		return klEkonomicznaSrodek - klEkonomicznaSrodekZajete;
	}

	// Metody rezerwujące miejsce w poszczególnych klasach

	public void rezerwujPierwszaKlasaOkno() {
		klPierwszaOknoZajete++;
	}

	public void rezerwujPierwszaKlasaSrodek() {
		klPierwszaSrodekZajete++;
	}

	public void rezerwujKlasaBusinessOkno() {
		klBusinessOknoZajete++;
	}

	public void rezerwujKlasaBusinessSrodek() {
		klBusinessSrodekZajete++;
	}

	public void rezerwujKlasaEkonomicznaOkno() {
		klEkonomicznaOknoZajete++;
	}

	public void rezerwujKlasaEkonomicznaSrodek() {
		klEkonomicznaSrodekZajete++;
	}

	public void odwolajPierwszaKlasaOkno() {
		klPierwszaOknoZajete--;
	}

	public void odwolajPierwszaKlasaSrodek() {
		klPierwszaSrodekZajete--;
	}

	public void odwolajKlasaBusinessOkno() {
		klBusinessOknoZajete--;
	}

	public void odwolajKlasaBusinessSrodek() {
		klBusinessSrodekZajete--;
	}

	public void odwolajKlasaEkonomicznaOkno() {
		klEkonomicznaOknoZajete--;
	}

	public void odwolajKlasaEkonomicznaSrodek() {
		klEkonomicznaSrodekZajete--;
	}
	
	@Override
	public String toString(){
		return "lot z lotniska " + miejsceStartu.toString() + " do " + miejsceLadowania ;
	}
}
