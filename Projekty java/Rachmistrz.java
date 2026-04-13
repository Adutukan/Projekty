
public class Rachmistrz implements Oblicz{
private int w = 9;
private int k = 10;
// dalszy kod
@Override
public int wynik(int x, int y) {
	return w - k + k*y;
}
}
