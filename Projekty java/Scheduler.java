import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class Scheduler {
	
	private HashSet<Employee> employees = new HashSet<>();
	
	public void add(Employee e) {
		employees.add(e);
	}

	public List<Employee> getEmployees() {
		//ArrayList<Employee> pracownik = new ArrayList<>(employees);
		ArrayList<Employee> pracownik = new ArrayList<>();
		pracownik.addAll(pracownik);
		return pracownik;
		
	}

	@Override
	public String toString() {
		return employees.toString();
	}

	public void addAll(Collection<Employee> a) {
		a.forEach(x -> this.add(x));
	}
    	
	public List<Employee> workersforDay(Day d){
		ArrayList<Employee> a =new ArrayList<>();
		//for (Employee e: employees) {
			//if(e.canWork(d));
			//a.add(e);
		//}
		employees.forEach(x-> {if (x.canWork(d)) a.add(x);});
		return a;
	}
	
	public double payment(Day d) {
		return d.getRate() * workersforDay(d).size();
	}
	

}
