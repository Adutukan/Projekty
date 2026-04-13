import java.util.ArrayList;

public class Test3 {

	public static void main(String[] args) {
		ArrayList<circle2>  dane = new ArrayList<>();
		for (int i =0; i<5;i++)
			dane.add(circle2.randomCircle(10));
		System.out.println(dane);
		//dane.sort(null);
		//System.out.println(dane);
		//dane.sort(new CircleAreaComparator());
		dane.sort((x,y) -> - Double.compare(x.area(), y.area()));
		System.out.println(dane);
		


	}

}
