package project;

public class BinaryCounterBeta extends BinaryCounter {
	
	private int overflows;
	
	public BinaryCounterBeta(int numberOfBits) {
		super( numberOfBits);
	}
	
	public int getOverflows() {
		return overflows;
	}
	
	public void increase(int k) {
		for (int i = 0 ; i <= k; i++) {
			increase() ;
		}
	}
	
	public void increase() {
		int old = this.value();
		super.increase();
		if (old > this.value()) {
			overflows ++;
		} 
	}
	
	

}

public class EightBitsBinaryCounter extends BinaryCounter {
	// 1) Maksymalna wartość licznika 8-bitowego = 255
    private final int MAX_VALUE = 255;

    // 2) Ile razy WSZYSTKIE liczniki 8-bitowe zostały zwiększone (statyczne!)
    private static int totalIncreases = 0;

    // Konstruktor – zawsze 8 bitów
    public EightBitsBinaryCounter() {
        super(8);
    }

    // Getter liczby wszystkich zwiększeń
    public static int getTotalIncreases() {
        return totalIncreases;
    }

    // Nadpisanie increase()
    @Override
    public void increase() {
        totalIncreases++;  // zlicza każde zwiększenie licznika
        super.increase();  // wykonuje normalne zwiększenie
    }

    // 3) Zwrot tablicy bitów
    public int[] getBitsArray() {
        // tworzymy nową tablicę aby nie ujawniać prywatnych pól
        int[] arr = new int[8];
        String s = this.toString(); // np. "01011001"

        for (int i = 0; i < 8; i++) {
            arr[i] = s.charAt(i) - '0';
        }
        return arr;
    }

    // Getter maksymalnej wartości
    public int getMaxValue() {
        return MAX_VALUE;
    }

}


public class BinaryCounter {
	private int[] bits;

	public BinaryCounter(int numberOfBits) {
		bits = new int[numberOfBits];
	}

	public void increase() {
		int i = 0;
		while (i < bits.length && bits[i] == 1) {
			bits[i] = 0;
			i++;
		}
		if (i == bits.length)
			bits[0] = 1;
		else
			bits[i] = 1;
	}

	public String toString() {
		StringBuffer s = new StringBuffer();
		for (int i = bits.length - 1; i >= 0; i--) {
			s.append(bits[i]);
		}
		return s.toString();

	}

	public int value() {
		int m = 1;
		int sum = 0;
		for (int i = 0; i < bits.length; i++) {
			sum = sum + m * bits[i];
			m *= 2;
		}
		return sum;
	}

}