import java.util.ArrayList;

public class Testowa2026 {
	public static void przyklad (Oblicz k) {
		System.out.println("*" +k.wynik(2, 4));
	}
	public static void main(String[] args) {
		Oblicz o=(p,t) -> p+t;
		System.out.println(o.wynik(3, 4));
		Testowa2026.przyklad(o);
		Testowa2026.przyklad((x,y)-> 2*x*y);
		Testowa2026.przyklad (new Rachmistrz());
		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer> b = new ArrayList<>();
		for (int i=0; i<5;i++) {
			a.add(i);
		}
		for (int i=0; i<7;i++) {
			b.add(i*2+1);
		}
		int z=4;
		z++;
		System.out.println(a);
		System.out.println(b);
		System.out.println(OperacjeNaTablicach.obliczDlaPar(a,b,(x,y) -> x+y));
		a.forEach(x-> b.add(x));
		System.out.println(b);
	}

}
