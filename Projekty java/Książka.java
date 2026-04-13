
public class Ksi¹¿ka implements Comparable <Ksi¹¿ka>{
	

private int liczbaStron;
private String tytul;
private Osoba autor;
public int getLiczbaStron() {
	return liczbaStron;
}
public void setLiczbaStron(int liczbaStron) {
	this.liczbaStron = liczbaStron;
}
public String getTytul() {
	return tytul;
}
public void setTytul(String tytul) {
	this.tytul = tytul;
}
public Osoba getAutor() {
	return autor;
}
public void setAutor(Osoba autor) {
	this.autor = autor;
}

public Ksi¹¿ka(int liczbaStron, String tytul, Osoba autor) {
	this.liczbaStron = liczbaStron;
	this.tytul = tytul;
	this.autor = autor;
}


@Override
public String toString() {
	return tytul + " " + autor.getImie() + " " + autor.getNazwisko();
}
@Override
public int compareTo(Ksi¹¿ka o) {
	return this.liczbaStron - o.liczbaStron;
	// return Integer.compare (this.liczbaStron,o.liczbaStron)
}









}
