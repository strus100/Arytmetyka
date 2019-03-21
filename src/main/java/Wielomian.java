import java.util.LinkedList;

public class Wielomian {
    Ulamki u = new Ulamki();

    Long mnoznik = 1L;
    LinkedList wspolczynniki;

    Wielomian(LinkedList _wspolczynniki){
        wspolczynniki = _wspolczynniki;
        for (Object w: wspolczynniki
             ) {
            Long[]liczba = u.odczyt((String) w);
            if (liczba[1] > mnoznik)
                mnoznik = liczba[1];
        }

        for (Object w: wspolczynniki
        ) {
            w = u.mnoz((String) w, mnoznik + "/1");
        }


    }

    public String piszWielomian (){
        String wynik = "y = ";
        for (int i = wspolczynniki.size() - 1; i >=2 ; i--) {
            wynik += wspolczynniki.get(i) + "x^" + i + " + ";
        }
        wynik += wspolczynniki.get(1) + "x + " + wspolczynniki.get(0);
        return wynik;
    }

    public LinkedList dzielnikiWyrazuWolnego(){
       return dzielniki((String) wspolczynniki.getFirst());
    }


    public LinkedList dzielnikiNajwyzszejPotegi(){
        return dzielniki((String) wspolczynniki.getLast());
    }
    private LinkedList dzielniki(String wyraz) {
        LinkedList dzielniki = new LinkedList<String>();

        Long wyrazWolnyTemp;

        Long[] wyrazWolnyLiczby = u.odczyt(u.wartoscBezwzgledna(wyraz));

        if (wyrazWolnyLiczby[0] > wyrazWolnyLiczby[1]) {
            wyrazWolnyTemp = wyrazWolnyLiczby[0];
        }
        else{
            wyrazWolnyTemp = wyrazWolnyLiczby[1];
        }

        for(int i=1;i<= wyrazWolnyTemp;i++)
        {
            if (wyrazWolnyTemp % i ==0){
            dzielniki.add(i+"/1");
            }
        }
    return dzielniki;
    }


    public LinkedList mozliweWyniki(){
      return _mozliweWyniki(dzielnikiNajwyzszejPotegi(),dzielnikiWyrazuWolnego());
    }

    private LinkedList _mozliweWyniki(LinkedList licznik, LinkedList mianownik) {
        LinkedList mozliweWyniki = new LinkedList<String>();
        for (int i = 0; i < licznik.size() ; i++) {
            for (int j = 0; j < mianownik.size(); j++) {
                mozliweWyniki.add(u.dziel((String)licznik.get(i),(String)mianownik.get(j)));
            }
        }
    return mozliweWyniki;
    }

    //brak potęgowania ułamków
    public String wartoscWielomianu(String x){
        //błąd
        String wartosc ="0/1";
        String wartoscTemp;
        String xTemp;
        for (int i = wspolczynniki.size() -1; i >=1; i--) {
            //Do potęgi i-tej


            xTemp = u.potega(x,i);
            wartoscTemp = u.mnoz((String)wspolczynniki.get(i),xTemp);
            wartosc = u.dodaj(wartosc,wartoscTemp);
            System.out.print("");
        }

        return u.dodaj(wartosc ,(String)wspolczynniki.get(0));
    }

}
