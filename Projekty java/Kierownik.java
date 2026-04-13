import java.time.LocalDate;
import java.util.Arrays;

public class Kierownik extends Pracownik {

	public Kierownik(LocalDate data_z, LocalDate data_u, String imie, String nazwisko, int id, int podstawa) {
		super(data_z, data_u, imie, nazwisko, id, podstawa);
		// TODO Auto-generated constructor stub
	}

	public Kierownik(LocalDate data_u, String imie, String nazwisko, int id, int podstawa) {
		super(data_u, imie, nazwisko, id, podstawa);
		// TODO Auto-generated constructor stub
	}

	public Kierownik(Pracownik p) {
		this(p.getData_z(),p.getData_u(),p.getImie(),p.getNazwisko(),p.getId(),p.getPodstawa());
	}

	@Override
	public double pensja() {
		// TODO Auto-generated method stub
		return super.pensja() *1.1;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "(M)";
	}
	
	public static Kierownik fromCSV(String line) {
		String[] tab = line.split(",");
		System.out.println(Arrays.toString(tab));
		if (tab.length != 6) throw new IllegalArgumentException("Niepoprawny format");
		int id = Integer.parseInt(tab[0]);
		String imie = tab[1];
		String nazwisko = tab[2];
		int podstawa = Integer.parseInt(tab[3]);
		LocalDate data_z = LocalDate.parse(tab[4]);
		LocalDate data_u = LocalDate.parse(tab[5]);
		return new Kierownik(data_z,data_u,imie,nazwisko,id,podstawa);
		 
	}
		
	
	
	
	
}
