package rezerwacjaBiletow;

/**
 * Klasa Samolot będzie zawierać obiekty określające typy samolotów, które będą wykorzystywane przy tworzeniu lotów i rezerwacji biletów na nie.
 * @author Karol Kobyliński
 *
 */
public class Samolot {
	
	//Pola klasy
		
	private String typ;
	private int pierwszaKlasa;
	private int klasaBusiness;
	private int klasaEkonomiczna;
	
	/**
	 * Konstruktor klasy Samolot.
	 * @param pierwszaKlasa parametr typu Int, określa ile miejsc w pierwszej klasie posiada dany typ samolotu.
	 * @param klasaBusiness parametr typu Int, określa ile miejsc w klasie business posiada dany typ samolotu.
	 * @param klasaEkonomiczna parametr typu Int, określa ile miejsc w klasie ekonomicznej posiada dany typ samolotu.
	 */
	public Samolot(String typ, int pierwszaKlasa, int klasaBusiness, int klasaEkonomiczna){
		
		this.typ = typ;
		this.pierwszaKlasa = pierwszaKlasa;
		this.klasaBusiness = klasaBusiness;
		this.klasaEkonomiczna = klasaEkonomiczna;
		BazaDanych.dodajSamolot(this);
	}
	
	//Metody typu get
	
	public String getTyp(){
		return typ;
	}
	
	public int getPierwszaKlasa(){
		return pierwszaKlasa;
	}
	

	public int getKlasaBusiness(){
		return klasaBusiness;
	}
	

	public int getKlasaEkonomiczna(){
		return klasaEkonomiczna;
	}
	
	@Override
	public String toString(){
		return "Samolot typu " + typ;
	}		
}
