package project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public class Kadry2 {

    private ArrayList<Pracownik> pracownik = new ArrayList<>();

    // 1️⃣ Zapis wszystkich pracowników do pliku CSV
    public void zapiszDoPlikuCSV(String sciezka) throws IOException {
        PrintWriter pw = new PrintWriter(sciezka);
        for (Pracownik p : pracownik) {
            pw.println(p.toCSVLine());
        }
        pw.close();
    }

    // 2️⃣ Suma pensji do wypłaty
    public double doWyplaty() {
        double suma = 0;
        for (Pracownik p : pracownik) {
            suma += p.pensja();
        }
        return suma;
    }

    // 3️⃣ Pracownicy urodzeni przed daną datą
    public ArrayList<Pracownik> urodzeniPrzed(LocalDate data) {
        ArrayList<Pracownik> wynik = new ArrayList<>();
        for (Pracownik p : pracownik) {
            if (p.getData_u().isBefore(data)) {
                wynik.add(p);
            }
        }
        return wynik;
    }

    // 4️⃣ Pracownicy urodzeni przed danym rokiem
    public ArrayList<Pracownik> urodzeniPrzed(int year) {
        return urodzeniPrzed(LocalDate.of(year, 1, 1));
    }
    
    
    public ArrayList<Pracownik> urodzeniPrzed1(int year) {
        ArrayList<Pracownik> wynik = new ArrayList<>();
        for (Pracownik p : pracownik) {
            if (p.getData_u().getYear() < year) {
                wynik.add(p);
            }
        }
        return wynik;
    }


    // 5️⃣ Maksymalna liczba przepracowanych lat
    public int maksymalnaLiczbaPrzepracowanychLat() {
        int max = 0;
        for (Pracownik p : pracownik) {
            if (p.lata() > max) {
                max = p.lata();
            }
        }
        return max;
    }

    // 6️⃣ Ilu pracowników zarabia co najmniej X
    public int liczbaZarabiajacychCoNajmniej(double pensja) {
        int licznik = 0;
        for (Pracownik p : pracownik) {
            if (p.pensja() >= pensja) {
                licznik++;
            }
        }
        return licznik;
    }

    // 7️⃣ Podwyżka kwotowa dla wszystkich
    public void podwyzka(double kwota) {
        for (Pracownik p : pracownik) {
            p.SetPodstawa(p.getPodstawa() + (int) kwota);
        }
    }

    // 8️⃣ Dodanie pracownika (bez duplikatu ID)
    public boolean dodaj(Pracownik p) {
        for (Pracownik x : pracownik) {
            if (x.getId() == p.getId()) {
                return false;
            }
        }
        pracownik.add(p);
        return true;
    }

    // 9️⃣ Dodawanie pracowników z pliku CSV
    public boolean dodajZPlikuCSV(String sciezka) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(sciezka));
            String line;
            while ((line = br.readLine()) != null) {
                this.dodaj(Pracownik.fromCSV(line));
            }
            br.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 🔟 Wyświetlenie wszystkich pracowników
    public void wyswietl() {
        for (Pracownik p : pracownik) {
            System.out.println(p);
        }
    }
}
