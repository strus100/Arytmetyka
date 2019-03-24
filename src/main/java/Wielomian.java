import java.util.LinkedList;

public class Wielomian {


    Ulamki u = new Ulamki();
    LinkedList<Liczba> wspolczynniki;

    Liczba wyrazWolny;
    Liczba aN;

    Wielomian(LinkedList<Liczba> _wspolczynniki){
        wspolczynniki = _wspolczynniki;
        Long mnoznik = 1L;
        boolean guard = true;
        Long mnoznikTemp = 1L;
            for (Liczba w : wspolczynniki
            ) {
                if (w.getMianownik() > mnoznik)
                    mnoznik = w.getMianownik();
            }

        while (guard) {
            guard = false;
            for (int i = 0; i < wspolczynniki.size(); i++) {
                Liczba w = u.mnoz(wspolczynniki.get(i), new Liczba(mnoznik, 1L));
                wspolczynniki.remove(i);
                wspolczynniki.add(i, w);
                Long check = wspolczynniki.get(i).getMianownik();

                if (Math.abs(check) != 1) {
                    guard = true;
                    mnoznikTemp *= check;
                }
            }
            mnoznik = mnoznikTemp;
            mnoznikTemp = 1L;
        }

        wyrazWolny = wspolczynniki.getFirst();
        aN = wspolczynniki.getLast();

    }


    public String piszWielomian (){
        String wynik = "y = ";
        for (int i = wspolczynniki.size() - 1; i >=2 ; i--) {
            wynik += wspolczynniki.get(i) + "x^" + i + " + ";
        }
        wynik += wspolczynniki.get(1) + "x + " + wspolczynniki.get(0);
        return wynik;
    }

    private LinkedList dzielniki(Liczba wyraz) {
        LinkedList<Liczba> dzielniki = new LinkedList<Liczba>();
        wyraz = u.wartoscBezwzgledna(wyraz);
         Long temp;
        if (wyraz.getLicznik()> wyraz.getMianownik()) {
            temp = wyraz.getLicznik();
        }
        else{
            temp = wyraz.getMianownik();
        }

        for(int i=1;i<= temp;i++)
        {
            if (temp % i ==0){
                dzielniki.add(new Liczba((long)i,1L));
            }
        }
        return dzielniki;
    }

    public LinkedList dzielnikiWyrazuWolnego(){
       return dzielniki(wspolczynniki.getFirst());
    }

    public LinkedList dzielnikiNajwyzszejPotegi(){
        return dzielniki(wspolczynniki.getLast());
    }

    private LinkedList<Liczba> _mozliweWyniki(LinkedList<Liczba> licznik, LinkedList<Liczba> mianownik) {
        LinkedList mozliweWyniki = new LinkedList<Liczba>();
        for (int i = 0; i < licznik.size() ; i++) {
            for (int j = 0; j < mianownik.size(); j++) {
                mozliweWyniki.add(u.dziel(licznik.get(i),mianownik.get(j)));
                mozliweWyniki.add(u.dziel(
                        u.mnoz(
                                new Liczba(-1L,1L),
                                licznik.get(i)
                        ),
                        mianownik.get(j)
                ));
            }
        }
        return mozliweWyniki;
    }

    public LinkedList<Liczba> mozliweWyniki(){
      return _mozliweWyniki(dzielnikiWyrazuWolnego(),dzielnikiNajwyzszejPotegi());
    }

    public Liczba wartoscWielomianu(Liczba x){
        Liczba wartosc = new Liczba(0L,1L);
        Liczba wartoscTemp;
        Liczba xTemp;
        for (int i = wspolczynniki.size() -1; i >=1; i--) {
            xTemp = u.potega(x,i);
            wartoscTemp = u.mnoz(wspolczynniki.get(i),xTemp);
            wartosc = u.dodaj(wartosc,wartoscTemp);
            System.out.print("");
        }
        return u.dodaj(wartosc ,wspolczynniki.get(0));
    }

    public Liczba wartoscHorner(Liczba x){
        Liczba w = wspolczynniki.getLast();

        for (int i = wspolczynniki.size() -2 ; i >= 0 ; i--)
        {
            w = u.mnoz(w,x);
            w = u.dodaj(w,wspolczynniki.get(i));
        }
    return w ;



    }

    public void wynik(LinkedList<Liczba> mozliweWyniki) {
        LinkedList<Liczba> temp = new LinkedList<Liczba>();
        int stopien = wspolczynniki.size() - 1;
        Liczba bool = new Liczba(0L,1L);
            for (int i = 0; i < mozliweWyniki.size(); i++) {
                Liczba wartosc = wartoscHorner(mozliweWyniki.get(i));
                System.out.print("");
                if (wartosc.getLicznik() == bool.getLicznik() && wartosc.getMianownik() == bool.getMianownik()) {
                    if(!temp.contains(wartosc)){
                    temp.add(mozliweWyniki.get(i));
                   }
                }
            }
            System.out.print("");
            Liczba powtorz = new Liczba(wyrazWolny.getLicznik(),aN.getLicznik());

            while(stopien > 0){
                for (int i = 0; i < temp.size() ; i++) {
                    //znajdz powtórzenia
                    Long licznik0 = powtorz.getLicznik();
                    Long mianownik0 = powtorz.getMianownik();

                    Long licznik1 = temp.get(i).getLicznik();
                    Long mianownik1 = temp.get(i).getMianownik();

                    if(licznik0 % licznik1 == 0 && mianownik0 % mianownik1 == 0) {
                        powtorz = u.dziel(powtorz, temp.get(i));
                        stopien--;
                        System.out.println(temp.get(i));
                    }
                }

            }
          }

}



