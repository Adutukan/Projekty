import java.util.Collection;
import java.util.EnumSet;

public class Employee implements Comparable<Employee> {
	
	private String name;
	private String surname;
	private EnumSet<Day> workingDays;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public EnumSet<Day> getWorkingDays() {
		return workingDays;
	}
	public void setWorkingDays(EnumSet<Day> workingDays) {
		this.workingDays = workingDays;
	}
	
	public Employee(String name, String surname) {
		setName(name);
		setSurname(surname);
		workingDays=EnumSet.noneOf(Day.class); 
	}
	public Employee(String name, String surname,Collection<Day> dni) {
		setName(name);
		setSurname(surname);
		workingDays=EnumSet.copyOf(dni); 
	}
	
	public Employee(Employee e) {
		setName(e.name);
		setSurname(e.surname);
		workingDays=EnumSet.copyOf(e.workingDays); 
	}
	
	public void setWorkingDay(Day d) {
		workingDays.add(d);
	}
	
	public void setDayOff(Day d) {
		workingDays.remove(d);
	}
	
	public void clearWorkingDays() {
		workingDays.clear();
	}
	
	public boolean canWork(Day d) {
		return workingDays.contains(d);
	}
	public void canWorkClone() {
		workingDays.clone(); 
		
	}
	@Override
	public String toString() {
		return "Pracownik [imie=" + name + ", nazwisko=" + surname + "]";
	}
	@Override
	public int compareTo(Employee e) {
		return this.getSurname().compareTo(e.getSurname());
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}
	
	
	
	
	
	
}
