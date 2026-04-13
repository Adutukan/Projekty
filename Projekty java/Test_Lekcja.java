import java.time.LocalTime;

public class Test_Lekcja {

	public Test_Lekcja() {
	}

	public static void main(String[] args) {
		Dzien_Szkolny d= Dzien_Szkolny.WTOREK;
		System.out.println(d);
		if (d== Dzien_Szkolny.WTOREK)
			System.out.println("OK");
		if (d.compareTo(Dzien_Szkolny.SRODA) < 0)
			System.out.println("Pocz¹tek Tygodnia");
	}
	
	Lekcja k = new Lekcja(Przedmiot.MATEMATYKA,Dzien_Szkolny.PONIEDZIALE,45,LocalTime.of(8, 45));
	Lekcja w = new Lekcja(Przedmiot.HISTORIA,Dzien_Szkolny.WTOREK,45,LocalTime.of(8, 00));
	Lekcja p = new Lekcja(Przedmiot.POLSKA,Dzien_Szkolny.WTOREK,45,LocalTime.of(9, 00));
	Lekcja g = new Lekcja(Przedmiot.POLSKA,Dzien_Szkolny.SRODA,45,LocalTime.of(9, 00));
	
}
