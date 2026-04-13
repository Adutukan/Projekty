public class EgzemplarzBiblioteczny extends Ksi¹¿ka {
	
	private int Sygnatura;

	public int getSygnatura() {
		return Sygnatura;
	}

	public void setSygnatura(int sygnatura) {
		Sygnatura = sygnatura;
	}
	
	public EgzemplarzBiblioteczny(int liczbaStron , String tytul, Osoba autor, int Sygnatura) {
		super(liczbaStron,tytul,autor);
		this.Sygnatura = Sygnatura;
	}

	@Override
	public String toString() {
		return super.toString() + " " + Sygnatura ;
	//	return this.getTytul()
	}
	public void setliczbaStron(int n){
		if (n > 0) throw new IllegalArgumentException ("");
		else  super.setliczbaStron(n);
	}

	

}
