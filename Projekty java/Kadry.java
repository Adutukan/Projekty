import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Kadry implements HasBankAccount {
	
private ArrayList<Pracownik> pracownik = new ArrayList<>();
private String accountss;
public boolean add(Pracownik e) {
	pracownik.add(e);
	return true;
}
public void addALL(String path) throws IOException, ReflectiveOperationException {
	BufferedReader r = new BufferedReader(new FileReader(path));
	String line = null;
	while ((line = r.readLine()) != null) {
		Class <?> c = Class.forName(line.substring(line.lastIndexOf(",")+1));
		Method m = c.getMethod("fromCSV", String.class);
		Pracownik p =(Pracownik) m.invoke(null, line);
		this.add(Pracownik.fromCSV(line));
	}
	r.close();
}

public boolean toCSVFile(String path) {
	try (PrintWriter p = new PrintWriter(path);){
		for(Pracownik e : pracownik) p.println(e.toCSVLine());
		return true;
		
	}catch(IOException e) {e.printStackTrace();return false;}
}

public void Osoby() {
	for (Pracownik p : pracownik) {
		System.out.println(p);
	}
}
	
	
public void podwy¿ka(int iloœæ ) {
	for (Pracownik p : pracownik) {
		p.SetPodstawa(p.getPodstawa()+iloœæ);
	}
	
}

public ArrayList<Pracownik> hiredBefore(LocalDate date_z){
	ArrayList<Pracownik> k = new ArrayList<>();
	for (Pracownik p : pracownik ) {
		if (p.getData_u().isBefore(date_z)) {
			k.add(p);
		}
		
	}
	return k;
}

public ArrayList<Pracownik> pensjaPoni¿ej(double liczba){
	ArrayList<Pracownik> n = new ArrayList<>();
	for(Pracownik p : pracownik) {
		if (p.pensja() < liczba) {
			n.add(p);
		}
 	}
	return n;
}

public int liczbaPracowników() {
	return pracownik.size();
}

public double przeciêtneWynagrodzenie () {
	double suma = 0;
	for (Pracownik p : pracownik) {
		suma += p.pensja();
		
	}
	return suma/liczbaPracowników();
}

public void birthdays(String path, int mounth) {
	
}
public void print() {
	// TODO Auto-generated method stub
	
}
@Override
public void setBankAccount(String accountss) {
	this.accountss = accountss;
	
	
}
@Override
public String getBankAccount() {
	return accountss;
}

public ArrayList<Pracownik> wyplacPensje() {
	for(int i=0; i <= pracownik.size();i++ ) {
	   try {
		Bank.moneyTransfer(this , pracownik.get(i), pracownik.get(i)); 
	   }catch(TransferException e) {
		   return(ArrayList<Pracownik>)       pracownik.sublist(i,pracownik.size(i));}
	   }
	   return new ArrayList<Pracownik>();
	}

public void ZaplacWybranym(ArrayList<Pracownik> dane,String sciezkaraportu) throws IOException {
	
}
}


	
	


