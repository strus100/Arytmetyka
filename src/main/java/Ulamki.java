
public class Ulamki {

    //TODO potęgowanie
    public Long[] odczyt(String liczba){
        String [] liczbyStr = liczba.split("/");
        Long[] liczby = {0L,0L};

        for (int i = 0; i < liczbyStr.length ; i++) {
            liczby[i] = Long.parseLong(liczbyStr[i]);
        }
        return liczby;
    }

    private Long NWD(Long a, Long b){
    Long temp;
        while(b != 0){
        temp = b;
        b = a % b;
        a = temp;
        }
    return a;
    }

    public String skracanie(String liczba){
        Long[]liczby = odczyt(liczba);
        Long licznik = liczby[0];
        Long mianownik = liczby[1];

        Long dzielnik = NWD(licznik,mianownik);
        ////////////////////////////////////////////

        licznik = licznik / dzielnik;
        mianownik = mianownik / dzielnik;

        return licznik + "/" + mianownik;
    }


    public String mnoz(String liczba0, String liczba1){
        liczba0 = skracanie(liczba0);
        Long[]liczby = odczyt(liczba0);
        Long licznik0 = liczby[0];
        Long mianownik0 = liczby[1];

        liczba1 = skracanie(liczba1);
        liczby = odczyt(liczba1);
        Long licznik1 = liczby[0];
        Long mianownik1 = liczby[1];

        return skracanie(licznik0 * licznik1 + "/" + mianownik0 * mianownik1);

    }

    public String potega(String liczba0, int stopien){
        String temp = liczba0;
        for (int i = 1; i < stopien; i++) {
            temp = mnoz(temp,liczba0);
        }
        return temp;

    }
    public String dziel(String liczba0, String liczba1){
        skracanie(liczba0);
        Long[]liczby = odczyt(liczba0);
        Long licznik0 = liczby[0];
        Long mianownik0 = liczby[1];

        skracanie(liczba1);
        liczby = odczyt(liczba1);
        Long licznik1 = liczby[1];
        Long mianownik1 = liczby[0];

        return skracanie(licznik0 * licznik1 + "/" + mianownik0 * mianownik1);

    }


    public String dodaj(String liczba0, String liczba1){
        skracanie(liczba0);
        Long[]liczby = odczyt(liczba0);
        Long licznik0 = liczby[0];
        Long mianownik0 = liczby[1];

        skracanie(liczba1);
        liczby = odczyt(liczba1);
        Long licznik1 = liczby[0];
        Long mianownik1 = liczby[1];

        return skracanie((licznik0 * mianownik1)  + (licznik1 * mianownik0) + "/" + mianownik0 * mianownik1);

    }


    public String odejmij(String liczba0, String liczba1){
        skracanie(liczba0);
        Long[]liczby = odczyt(liczba0);
        Long licznik0 = liczby[0];
        Long mianownik0 = liczby[1];

        skracanie(liczba1);
        liczby = odczyt(liczba1);
        Long licznik1 = liczby[0];
        Long mianownik1 = liczby[1];

        return skracanie((licznik0 * mianownik1)  - (licznik1 * mianownik0) + "/" + mianownik0 * mianownik1);

    }

    public String wartoscBezwzgledna(String liczba0){
        return liczba0.replace("-","");
    }
}
