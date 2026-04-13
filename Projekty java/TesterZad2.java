
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class TesterZad2 {
	
	public static Set<Day> randomDays(){
		HashSet<Day> days = new HashSet<>();
		Random r = new Random();
		int k =r.nextInt(10)+1;
		Day[] all = Day.values();
		for(int i = 0 ; i < k; i++) {
			days.add(all[r.nextInt(all.length)]);
		}
		return days;
	}

	public static void main(String[] args) {
		ArrayList<Employee> a = new ArrayList<>();
		
		a.add(new Employee("Gracjan","G³owania",TesterZad2.randomDays()));
		a.add(new Employee("Krystian","Krupnik",TesterZad2.randomDays()));
		a.add (new Employee("Micha³","Op³on",TesterZad2.randomDays()));
		a.add( new Employee("Micha³","K³ê",TesterZad2.randomDays()));
		a.add(new Employee("Filip","Latarnicz",TesterZad2.randomDays()));
		a.add (new Employee("Ester","Gawrowicz",TesterZad2.randomDays()));
		a.add (new Employee("Karol","Gawrowicz"));
		a.add(new Employee("Pawe³","Karowicz",EnumSet.allOf(Day.class)));
		a.add (new Employee("Joe","Trump",EnumSet.range(Day.MONDAY, Day.FRIDAY)));
		System.out.println(a);
		Scheduler s = new Scheduler();
		a.forEach(x -> s.add(x));
		System.out.println(s);
		System.out.println(s.workersforDay(Day.MONDAY));
		List<Employee> wybrani = s.workersforDay(Day.MONDAY); 
		

	}

}
