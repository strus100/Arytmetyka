import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        LinkedList<Liczba> wspolczynnikiW = new LinkedList<Liczba>();

        wspolczynnikiW.add(new Liczba(-500L, 6561L));
        wspolczynnikiW.add(new Liczba(1400L, 2187L));
        wspolczynnikiW.add(new Liczba(-1565L, 729L));
        wspolczynnikiW.add(new Liczba(97L, 27L));
        wspolczynnikiW.add(new Liczba(-3L, 1L));
        wspolczynnikiW.add(new Liczba(1111L, 1L));

        Wielomian w = new Wielomian(wspolczynnikiW);

        System.out.println(w.piszWielomian());

        w.wynik(w.mozliweWyniki());

    }
}
