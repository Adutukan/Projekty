import java.util.Random;

public class circle2 implements Comparable <circle2> {

		private double radious = 1;

		public double getRadious() {
			return radious;
		}

		public void setRadious(double radious) {
			if (radious < 0)
				throw new IllegalArgumentException("r<0!");
			this.radious = radious;
		}

		public circle2(double radious) {
			setRadious(radious);
		}

		public circle2() {
			// can stay even empty, mo¿e zostaæ pusty
			this(1);
		}

		public circle2(Circle c) {
			this(c.getRadious());
			// this(c.radious);
		}

		public double area() {
			return Math.PI * radious * radious;
		}

		public String toString() {
			return "(r=" + radious + ")";
		}

		public static circle2 randomCircle(int bound) {
			Random r = new Random();
			// we choose Int radious for a nice presentation
			return new circle2(r.nextInt(bound));
		}

	//method that creates static array of n random circles
		public static Circle[] randomCircles(int bound, int n) {
			Circle[] a = new Circle[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = Circle.randomCircle(bound);
			}
			return a;
		}
	 //method that calculates total area of circles in a given array
		public static double totalArea(Circle[] a) {
			double sum=0;
			//lenghty version
//			for(int i=0;i<a.length;i++) {
//				sum+=a[i].area();
//			}
			for(Circle c:a) {
				sum=sum+c.area();
			}
			return sum;
		
	}

	@Override
	public int compareTo(circle2 o) {

		return Double.compare(this.radious, o.radious);
	}
}
