package pl.transmar;

import java.io.Serializable;
import java.util.TreeMap;

public class Pracownik implements Serializable {

    private String name;
    private TreeMap<Integer, Integer> godziny;

    public Pracownik(String name) {
        this.name = name;
        this.godziny = new TreeMap<>();


    }

    public String getName() {
        return name;
    }

    public TreeMap<Integer, Integer> getGodziny() {
        return godziny;
    }

    @Override
    public String toString() {
        return name;
    }

    public String pokazGodziny() {
        StringBuilder sb = new StringBuilder();
        int suma=0;
        for (int i : godziny.keySet()) {
            suma = suma + godziny.get(i);


            if (i < 10 && godziny.get(i) < 10) {
                sb.append(" ").append(i).append(" ------->  ").append(godziny.get(i)).append("\n");
            } else if (i<10 && godziny.get(i) >= 10) {
                sb.append(" ").append(i).append(" -------> ").append(godziny.get(i)).append("\n");
            } else if (i >= 10 && godziny.get(i) >= 10 ){
                sb.append(i).append(" -------> ").append(godziny.get(i)).append("\n");
            } else {
                sb.append(i).append(" ------->  ").append(godziny.get(i)).append("\n");
            }

        }
        if (suma < 10) {
            sb.append("--------------\nSuma:        ").append(suma);
        } else if (suma < 100) {
            sb.append("--------------\nSuma:       ").append(suma);
        } else {
            sb.append("--------------\nSuma:      ").append(suma);
        }
        return sb.toString();
    }

    public void dodajGodziny(int data, int godziny) {
        this.godziny.put(data, godziny);
    }


}
