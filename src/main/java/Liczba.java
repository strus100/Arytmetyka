public class Liczba {

    private Long licznik;
    private Long mianownik;

    public Liczba(Long licznik, Long mianownik) {
        this.licznik = licznik;
        this.mianownik = mianownik;
    }

    public Liczba(Liczba liczba0) {
        this.licznik = liczba0.licznik;
        this.mianownik = liczba0.mianownik;
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

    public void skracanie(){
        Long licznik = getLicznik();
        Long mianownik = getMianownik();

        Long dzielnik = NWD(getLicznik(),getMianownik());

        licznik = licznik / dzielnik;
        mianownik = mianownik / dzielnik;

        setLicznik(licznik);
        setMianownik(mianownik);
    }

    public Liczba() {
    }

    public Long getLicznik() {
        return licznik;
    }

    public void setLicznik(Long licznik) {
        this.licznik = licznik;
    }

    public Long getMianownik() {
        return mianownik;
    }

    public void setMianownik(Long mianownik) {
        this.mianownik = mianownik;
    }

    @Override
    public String toString() {
        return getLicznik() + "/" + getMianownik();
    }
}
