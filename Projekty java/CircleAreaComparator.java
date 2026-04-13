import java.util.Comparator;

public class CircleAreaComparator implements Comparator<circle2> {

	public CircleAreaComparator() {
		
	}

	@Override
	public int compare(circle2 o1, circle2 o2) {
		
		return Double.compare(o1.area(), o2.area());
	}

}
