import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

public class Pracownik implements HasBankAccount {
	
	
	private LocalDate data_z;
	private LocalDate data_u;
	private String imie;
	private String nazwisko;
	private int id;
	private int podstawa;
	private int min_data;
	private double MAX_DODATEK;
	private static int wiek = 18;
	private static boolean czyPoprawnaParaData(LocalDate data_z,LocalDate data_u) {
		if (data_z == null || data_u == null) {
			return true;
		} 
		else {
			if (data_z.getYear()-data_u.getYear() >= wiek) {
				return true;
			}
			return false;
		}
	}
	private String account;
	
	public LocalDate getData_z(){
		return data_z;
		
	}
	
	public LocalDate getData_u(){
		return data_u;
		
	}
	
	public String getImie() {
		return imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	
	public int getId() {
		return id;
	}
	
	public int getPodstawa() {
		return podstawa;
	}
	public double getMaxDodatek() {
		return MAX_DODATEK;
	}
	
	public void SetData_z(LocalDate data_z) {
		this.data_z = data_z;
	}
	public void SetData_u(LocalDate data_u) {
		if(data_u.isAfter(LocalDate.now()))
			throw new IllegalArgumentException("B³êdna data");
		else if(czyPoprawnaParaData(this.getData_z(),data_u)) 
		this.data_u = data_u;
		else throw new IllegalArgumentException("B³êdna data");
	}
	
	
	public void SetImie(String imie) {
		this.imie = imie;
	}
	
	public void SetNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	
	public void SetId(int id) {
		this.id = id;
	}
	
	public void SetPodstawa(int podstawa){
		if (podstawa < 0) throw new IllegalArgumentException("B³êdna kwotwa");
		this.podstawa = podstawa;
	}
	
	public void SetMaxDodatek(double MAX_DODATEK) {
		this.MAX_DODATEK = MAX_DODATEK;
	}
	
	public Pracownik(LocalDate data_z,LocalDate data_u,String imie,String nazwisko,int id,int podstawa,String account) {
		this.data_z = data_z;
		this.data_u = data_u;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.id = id;
		this.podstawa = podstawa;
		this.account=account;
	}
	
	public Pracownik(LocalDate data_u,String imie,String nazwisko,int id,int podstawa,String account) {
		this.data_u = data_u;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.id = id;
		this.podstawa = podstawa;
		this.account=account;
		
	}

	@Override
	public String toString() {
		return "Pracownik [data_z=" + data_z + ", data_u=" + data_u + ", imie=" + imie + ", nazwisko=" + nazwisko
				+ ", id=" + id + ", podstawa=" + podstawa + ", min_data=" + min_data + "" + account + "]";
	}
	
	public int lata () {
		Period p = Period.between(this.data_z,LocalDate.now());
				return p.getYears();
	}
	
	public double pensja() {
		int lata = this.lata();
		
		if(lata < MAX_DODATEK) {
			return podstawa * (1 + (lata/100.0));
		}else {
			return podstawa * (1 + (MAX_DODATEK/100.0));
		}
		
		
	}
	
	public String toCSVLine() {
		return id + "," + imie + "," + nazwisko + "," + podstawa + "," + data_z + "," + data_u + "," + "," + account + ","+this.getClass().getName(); 
	}
	
	public static Pracownik fromCSV(String line) {
		String[] tab = line.split(",");
		System.out.println(Arrays.toString(tab));
		if (tab.length != 7) throw new IllegalArgumentException("Niepoprawny format");
		int id = Integer.parseInt(tab[0]);
		String imie = tab[1];
		String nazwisko = tab[2];
		int podstawa = Integer.parseInt(tab[3]);
		LocalDate data_z = LocalDate.parse(tab[4]);
		LocalDate data_u = LocalDate.parse(tab[5]);
		String account = tab[6];
		return new Pracownik(data_z, data_u, imie, nazwisko, id, podstawa,account);
	}


	@Override
	public void setBankAccount(String account) {
		this.account = account;
		
	}


	@Override
	public String getBankAccount() {
		return account;
	}
		
		
	} 
	
	
	


