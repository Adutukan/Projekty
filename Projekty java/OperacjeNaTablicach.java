import java.util.ArrayList;

public  class OperacjeNaTablicach {

	public static ArrayList<Integer> obliczDlaPar(ArrayList<Integer> a, ArrayList<Integer> b, Oblicz w) {
		int len=Math.min(a.size(), b.size());
		ArrayList<Integer> c= new ArrayList<>();
		for (int i=0;i <len;i++) {
			c.add(w.wynik(a.get(i), b.get(i)));
			
		}
		return c;
		
	}

}
