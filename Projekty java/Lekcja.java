import java.time.LocalTime;

public class Lekcja implements Comparable <Lekcja> {

	private Przedmiot przedmiot;
	private Dzien_Szkolny dzien;
	private int czasTrwania = 45;
	private LocalTime poczatek;
	
	
	public Przedmiot getPrzedmiot() {
		return przedmiot;
	}
	public void setPrzedmiot(Przedmiot przedmiot) {
		this.przedmiot = przedmiot;
	}
	public Dzien_Szkolny getDzien() {
		return dzien;
	}
	public void setDzien(Dzien_Szkolny dzien) {
		this.dzien = dzien;
	}
	public int getCzasTrwania() {
		return czasTrwania;
	}
	public void setCzasTrwania(int czasTrwania) {
		if (czasTrwania < 0) throw  new IllegalArgumentException("Czas trwania musi byæ powy¿ej 0 min");
		this.czasTrwania = czasTrwania;
	}
	
	public LocalTime getPoczatek() {
		return poczatek;
	}
	public void setPoczatek(LocalTime poczatek) {
		this.poczatek = poczatek;
	}
	
	public Lekcja(Przedmiot przedmiot, Dzien_Szkolny dzien, LocalTime poczatek) {
		super();
		this.setPrzedmiot(przedmiot);
		this.setDzien(dzien);
		this.setPoczatek(poczatek);
		
	}
	public Lekcja(Przedmiot przedmiot, Dzien_Szkolny dzien, int czasTrwania, LocalTime poczatek) {
		this(przedmiot,dzien,poczatek);
		this.setCzasTrwania(czasTrwania);
	}
	@Override
	public int compareTo(Lekcja o) {
		int w = this.dzien.compareTo(o.dzien);
		if (w == 0) {
			return this.poczatek.compareTo(o.poczatek);
		}
		else return 0;
	}
	
	public LocalTime getKoniec()  {return poczatek.plusMinutes(czasTrwania);}
	
	public boolean czyyKoliduje(Lekcja k) {
		if (k.getDzien() == this.getDzien()) {
			if (k.getKoniec().compareTo(this.getPoczatek())<0 || this.getKoniec().compareTo(k.getPoczatek())<0)
				return false;
			else return true;
		}
		else return false;
	}
	
	
	
	

}
