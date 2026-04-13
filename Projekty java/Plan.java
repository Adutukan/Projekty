import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Plan {
	
	private ArrayList<Lekcja> lekcje = new ArrayList<>();
	
	public void dodaj (Lekcja k) {
		for (Lekcja p : lekcje) {
			if(k.czyyKoliduje(p)) {
				throw new IllegalArgumentException("Koliduje");
			}
			lekcje.add(k);
		}
	}
	
	public ArrayList<Lekcja> lekcjeNaDzien(Dzien_Szkolny d){
		ArrayList<Lekcja> tablica = new ArrayList<>();
		for (Lekcja p : lekcje) {
			if (p.getDzien() == d)  
				tablica.add(p);
				tablica.sort(null);
		}
		
		return tablica;
	}
	
	public void DrukujPlan(String sciezka) {
	  try(PrintWriter p = new PrintWriter(sciezka)){	
		for (Dzien_Szkolny d : Dzien_Szkolny.values()) {
			
		}
		
	}catch(IOException e) {
		throw new IllegalArgumentException("B³¹d");
	}
	
	
	}
	
}
