package rezerwacjaBiletow;

import java.text.SimpleDateFormat;
/**
 * Klasa służąca do rezerwacji biletów. Bilet posiada numer, lot, cenę, klasę oraz rodzaj miejsca (przy oknie lub na środku). ,/br>
 * Bilet musi być przypisany do konkretnego pasażera.
 * @author Karol Kobyliński
 *
 */
 
public class Bilet {
	
	//Pola klasy
	
	private static int licznik = 0;
	private int nrBiletu;
	private Lot lot;
	private String klasa;
	private boolean okno;
	private int cena;
	private Pasazer pasazer;
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm, dd.MM.yyyy");
	
	/**
	 * Metoda fabryczna używana do rezerwacji biletu. </br>
	 * Najpierw sprawdza, czy są dostępne miejsca o podanych parametrach.</br>
	 * @param lot Lot, na który rezerwowany jest bilet
	 * @param klasa "pierwsza", "business", "ekonomiczna". Można zacząć z małej lub wielkiej litery.
	 * @param okno Jeśli ma wartość true, rezerwuje miejsce przy oknie.
	 * @param pasazer Pasażer, na którego zostanie zarezerwowany bilet.
	 * @return Jeśli miejca są dostępne, wywołuje konstruktor klasy Bilet z tymi parametrami. </br>Jeśli nie ma miejsc lub nazwa klasy została wprowadzona nieprawidłowo, wyświetli sie informacja o braku miejsc oraz metoda zwróci Null.
	 */
	
	public static Bilet rezerwuj(Lot lot, String klasa, boolean okno, Pasazer pasazer){
		if(Bilet.sprawdzDostepnosc(lot, klasa, okno)){
			System.out.println("Bilet został zarezerwowany.");
			return new Bilet(lot, klasa, okno, pasazer);
		}
		System.out.println("Bilety na podany lot w tej klasie są niedostępne.");
		return null;
	}
		
	/**
	 * Konstruktor jest prywatny, żeby nie można było go wywołać bez sprawdzania czy miejsca na dany lot są dostępne.</br>
	 * Ma być wywoływany tylko wewnątrz metody fabrycznej Rezerwuj.
	 * @param lot Lot, na który rezerwowany jest bilet
	 * @param klasa "pierwsza", "business", "ekonomiczna". Można zacząć z małej lub wielkiej litery.
	 * @param okno Jeśli ma wartość true, rezerwuje miejsce przy oknie.
	 * @param pasazer Pasażer, na którego zostanie zarezerwowany bilet. </br> Bilet zostanie automatycznie dodany do listy biletów danego Pasażera.
	 */
	private Bilet(Lot lot, String klasa, boolean okno, Pasazer pasazer){
		nrBiletu = ++licznik;
		this.lot = lot;
		this.klasa = klasa;
		this.okno = okno;
		if(klasa.equals("pierwsza") || klasa.equals("Pierwsza")){
			if(okno)
				lot.rezerwujPierwszaKlasaOkno();
			else
				lot.rezerwujPierwszaKlasaSrodek();
			cena = this.lot.getCenaKlPierwsza();
		}
		else if(klasa.equals("business") || klasa.equals("Business")){
			if(okno)
				lot.rezerwujKlasaBusinessOkno();
			else
				lot.rezerwujKlasaBusinessSrodek();
			cena = this.lot.getCenaKlBusiness();
		}
		else if(klasa.equals("ekonomiczna") || klasa.equals("Ekonomiczna")){
			if(okno)
				lot.rezerwujKlasaEkonomicznaOkno();
			else
				lot.rezerwujKlasaEkonomicznaSrodek();
			cena = this.lot.getCenaKlEkonomiczna();
		}
		pasazer.dodajBilet(this);
		BazaDanych.dodajBilet(this);
	}
	
	//Metody typu get
	
	public Lot getLot(){
		return lot;
	}
	
	public int getNrBiletu(){
		return nrBiletu;
	}
	
	public int getCena(){
		return cena;
	}
	
	public String getKlasa(){
		return klasa;
	}
	
	public boolean getOkno(){
		return okno;
	}
	
	public Pasazer getPasazer(){
		return pasazer;
	}
	
	/**
	 * 
	 * @return Zwraca obiekt typu String z miejscem oraz godziną i datą wylotu
	 */
	
	public String wylotToString(){
		return "Wylot z lotniska " + lot.getMiejsceStartu().getNazwa() + " w " + lot.getMiejsceStartu().getMiasto() + " o godzinie " + dateFormat.format(lot.getCzasWylotu().getTime());
	}
	
	/**
	 * 
	 * @return Zwraca obiekt typu String z miejscem oraz godziną i datą przylotu
	 */
	public String przylotToString(){
		return "Przylot na lotnisko " + lot.getMiejsceLadowania().getNazwa() + " w " + lot.getMiejsceLadowania().getMiasto() + " o godzinie " + dateFormat.format(lot.getCzasPrzylotu().getTime());
	}
	
	/**
	 * Metoda sprawdzająca dostępność biletów na dany lot.
	 * @param lot Lot, na który sprawdzana jest dostępność.
	 * @param klasa Klasa "pierwsza", "business", "ekonomiczna" (z małej lub wielkiej litery). </br> Wprowadzenie jakiejkolwiek innej nazwy klasy spowoduje, że metoda zawsze zwróci false.
	 * @param okno wartość true oznacza miejsce przy oknie
	 * @return Zwraca true jeśli są dostępne miejsca o podanych parametrach.
	 */
	public static boolean sprawdzDostepnosc(Lot lot, String klasa, boolean okno){
		if(klasa.equals("pierwsza") || klasa.equals("Pierwsza")){
			if(okno)
				return lot.getWolneMiejscaKlPierwszaOkno() > 0;
			return lot.getWolneMiejscaKlPierwszaSrodek() > 0;
		}
		if(klasa.equals("business") || klasa.equals("Business")){
			if(okno)
				return lot.getWolneMiejscaKlBusinessOkno() > 0;
			return lot.getWolneMiejscaKlBusinessSrodek() > 0;
		}
		if(klasa.equals("ekonomiczna") || klasa.equals("Ekonomiczna")){
			if(okno)
				return lot.getWolneMiejscaKlEkonomicznaOkno() > 0;
			return lot.getWolneMiejscaKlEkonomicznaSrodek() > 0;
		}
		return false;
	}
	
	@Override
	public String toString(){
		return "Bilet nr " + nrBiletu + " na " + lot.toString() + " w klasie " + klasa + " w cenie " + cena;
	}
}
	