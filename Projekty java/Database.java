import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Database {

public static ArrayList<Pracownik > getEmployees() throws DatabaseException{
            String[] names= {"John","Mark","Bart","Adam","Michael","Henry","Robert","Sam"};
			String[] surnames={"Smith","Cooper","Miller","Davis","Johnson","Brown","Williams"};
			String[] account = {"112111","1122112","123123","123131313","12213131"};
			Random r=new Random();
			double p=r.nextDouble();
			if(p>=0.5) {
				ArrayList<Pracownik> a=new ArrayList<>();
				for(int i=0;i<r.nextInt(10)+1;i++) {
					a.add(new Pracownik(LocalDate.now().minusDays(r.nextInt(20)),LocalDate.of(1980+r.nextInt(20),r.nextInt(12)+1,r.nextInt(20)),names[r.nextInt(names.length)],surnames[r.nextInt(surnames.length)],r.nextInt(200),r.nextInt(2000)+1000,account[account.length]));
				}		
			 return a;	
		
	}else if(p<0.2) throw new LoginException("Invalid login or password");
	else if(p<0.3) throw new ServerException("Cannot connect to server");
	else if(p<0.4) throw new ServerTooBusyException("Server too busy");
	else throw new DatabaseException("Cannot load data");
}
}

