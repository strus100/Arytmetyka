import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        Ulamki u = new Ulamki();

        LinkedList wspolczynnikiW = new LinkedList<String>();
        wspolczynnikiW.add("-1/64");
        wspolczynnikiW.add("7/32");
        wspolczynnikiW.add("-7/8");
        wspolczynnikiW.add("1/1");

        Wielomian w = new Wielomian(wspolczynnikiW);


        for (int i = 0; i < w.mozliweWyniki().size(); i++) {
            if(w.wartoscWielomianu(w.mozliweWyniki().get(i).toString()).equals("0/1")){
                System.out.println(w.mozliweWyniki().get(i));
            }
        }


    }

}
