
public enum Day {
	
	MONDAY(20.0),TUESDAY(20.0),WEDNESDAY(30.0),THURSDAY(20.0),FRIDAY(40.0),SATURDAY(40.0),SUNDAY(50.0);

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	private double rate;

	private Day(double rate) {
		this.rate = rate;
	}
	
	
	
	
	

}
