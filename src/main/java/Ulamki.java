
public class Ulamki {

    public Liczba mnoz(Liczba liczba0, Liczba liczba1){
        Long licznik0 = liczba0.getLicznik();
        Long mianownik0 = liczba0.getMianownik();

        Long licznik1 = liczba1.getLicznik();
        Long mianownik1 = liczba1.getMianownik();

        Liczba wynik = new Liczba();
        wynik.setLicznik(licznik0 * licznik1);
        wynik.setMianownik(mianownik0 * mianownik1);
        wynik.skracanie();
        return wynik;
    }

    public Liczba potega(Liczba liczba0, int stopien){
        Liczba temp = liczba0;
        for (int i = 1; i < stopien; i++) {
            temp = mnoz(temp,liczba0);
        }
        return temp;

    }
    public Liczba dziel(Liczba liczba0, Liczba liczba1){

    return mnoz(liczba0,new Liczba(liczba1.getMianownik(),liczba1.getLicznik()));
    }

    public Liczba dodaj(Liczba liczba0, Liczba liczba1){
        Long licznik0 = liczba0.getLicznik();
        Long mianownik0 = liczba0.getMianownik();

        Long licznik1 = liczba1.getLicznik();
        Long mianownik1 = liczba1.getMianownik();

        Liczba wynik = new Liczba(licznik0,mianownik0);
        wynik.setLicznik((licznik0 * mianownik1)  + (licznik1 * mianownik0));
        wynik.setMianownik(mianownik0 * mianownik1);
        wynik.skracanie();
        return wynik;
    }

    public Liczba odejmij(Liczba liczba0, Liczba liczba1){
        Long licznik0 = liczba0.getLicznik();
        Long mianownik0 = liczba0.getMianownik();

        Long licznik1 = liczba1.getLicznik();
        Long mianownik1 = liczba1.getMianownik();

        Liczba wynik = new Liczba(licznik0,mianownik0);
        wynik.setLicznik((licznik0 * mianownik1)  - (licznik1 * mianownik0));
        wynik.setMianownik(mianownik0 * mianownik1);
        wynik.skracanie();
        return wynik;
    }

    public Liczba wartoscBezwzgledna(Liczba liczba0){
        if(liczba0.getLicznik()>=0)
            return new Liczba(liczba0);
        else
            return new Liczba(liczba0.getLicznik()*(-1),liczba0.getMianownik());
    }
}
