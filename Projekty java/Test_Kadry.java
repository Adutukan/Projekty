import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Test_Kadry {

	public static void main(String[] args) {
		Kadry k = new Kadry();
		try {
			k.addALL("Dane.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		k.toCSVFile("Dane.txt");
		
		System.out.println(k.przeciêtneWynagrodzenie());
		k.Osoby();
		System.out.println(k.liczbaPracowników());
		System.out.println();;
		
		try{
			ArrayList<Pracownik> prac = Database.getEmployees();
			System.out.println(prac);
			Pracownik e = prac.get(0);
			System.out.println(e.getPodstawa());
			Kierownik m = new Kierownik(e);
			Kadry d = new Kadry();
			d.add(e);
			d.add(m);
			System.out.println(m.toCSVLine());
			d.toString();
			d.toCSVFile("nowe Dane");
			
			System.out.println("Manager:" +m.pensja());
		  
		}catch(DatabaseException e) {
			e.printStackTrace();
		}
	}
	
	
		
	
	

}
