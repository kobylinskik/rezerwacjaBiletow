package rezerwacjaBiletow;

/**
 * Klasa Lotnisko będzie zawierać obiekty określające istniejące lotniska. Będą one używane w celu określania punktów początkowych i końcowych trasy oraz ew. punktów przesiadek.
 * @author Karol Kobyliński
 *
 */
public class Lotnisko {
	
	//Pola klasy
	
	private String nazwa;
	private String panstwo;
	private String miasto;
	
	/**
	 * Konstruktor klasy Lotnisko.
	 * @param nazwa parametr typu String, określa nazwę danego lotniska.
	 * @param panstwo parametr typu String, określa państwo, w którym znajduje się dane lotnisko.
	 * @param miasto parametr typu String, określa miasto, w którym znajduje się dane lotnisko.
	 */
	public Lotnisko(String nazwa, String panstwo, String miasto){
		this.nazwa=nazwa;
		this.panstwo=panstwo;
		this.miasto=miasto;
		BazaDanych.dodajLotnisko(this);
	}
	
	 	//Metody typu get
	
	public String getNazwa(){
		return nazwa;
	}
	
	public String getPanstwo(){
		return panstwo;
	}
	
	public String getMiasto(){
		return miasto;
	}
	
	@Override
	public String toString(){
		return nazwa + " " + miasto + ", " + panstwo;
	}
}
