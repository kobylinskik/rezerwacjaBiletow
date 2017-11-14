package rezerwacjaBiletow;

import java.util.ArrayList;

public class BazaDanych {

	private static ArrayList<Lotnisko> lotniska = new ArrayList<Lotnisko>();
	private static ArrayList<Lot> loty = new ArrayList<Lot>();
	private static ArrayList<Samolot> samoloty = new ArrayList<Samolot>();
	private static ArrayList<Bilet> bilety = new ArrayList<Bilet>();
	private static ArrayList<Pasazer> pasazerowie = new ArrayList<Pasazer>();

	//Metody typu get
	
	public static ArrayList<Samolot> getSamoloty() {
		return samoloty;
	}

	public static ArrayList<Lotnisko> getLotniska() {
		return lotniska;

	}

	public static ArrayList<Lot> getLoty() {
		return loty;
	}

	public static ArrayList<Bilet> getBilety() {
		return bilety;
	}

	public static ArrayList<Pasazer> getPasazerowie() {
		return pasazerowie;
	}
	
	//Metody dodające nowe pozycje to baz danych

	public static void dodajLotnisko(Lotnisko lotnisko) {
		lotniska.add(lotnisko);
	}

	public static void dodajSamolot(Samolot samolot) {
		samoloty.add(samolot);
	}

	public static void dodajLot(Lot lot) {
		loty.add(lot);
	}

	public static void dodajBilet(Bilet bilet) {
		bilety.add(bilet);
	}

	public static void dodajPasazera(Pasazer pasazer) {
		pasazerowie.add(pasazer);
	}

	//Metoda usuwająca bilet
	
	public static void usunBilet(Bilet bilet) {
		bilety.remove(bilet);
	}

	public static String drukujSamoloty(){
		String output = "";
		for(int i = 0; i < samoloty.size(); i++){
			output += samoloty.get(i) + "\n";
		}
		return output;
	}
	
	//Metody zwracające toString wszystkich elementów list
	
	public static String drukujLotniska(){
		String output = "";
		for(int i = 0; i < lotniska.size(); i++){
			output += lotniska.get(i) + "\n";
		}
		return output;
	}
	
	public static String drukujLoty(){
		String output = "";
		for(int i = 0; i < loty.size(); i++){
			output += loty.get(i) + "\n";
		}
		return output;
	}
	
	public static String drukujBilety(){
		String output = "";
		for(int i = 0; i < bilety.size(); i++){
			output += bilety.get(i) + "\n";
		}
		return output;
	}
	
	public static String drukujPasazerow(){
		String output = "";
		for(int i = 0; i < pasazerowie.size(); i++){
			output += pasazerowie.get(i) + "\n";
		}
		return output;
	}
}
