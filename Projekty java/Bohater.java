
public class Bohater {
	private String imie;
	private Atak sposóbAtaku;
	
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public Atak getSposóbAtaku() {
		return sposóbAtaku;
	}
	public void setSposóbAtaku(Atak sposóbAtaku) {
		this.sposóbAtaku = sposóbAtaku;
	}
	public Bohater(String imie, Atak sposóbAtaku) {
		this.imie = imie;
		this.sposóbAtaku = sposóbAtaku;
	}
	
	public void Atakuj() {
		this.sposóbAtaku.wykonajAtak();
	}
	
	
	
	
	
	
}
