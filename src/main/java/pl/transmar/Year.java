package pl.transmar;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Year implements Serializable {

    private List<Pracownik> styczen;
    private List<Pracownik> luty;
    private List<Pracownik> marzec;
    private List<Pracownik> kwiecien;
    private List<Pracownik> maj;
    private List<Pracownik> czerwiec;
    private List<Pracownik> lipiec;
    private List<Pracownik> sierpien;
    private List<Pracownik> wrzesien;
    private List<Pracownik> pazdziernik;
    private List<Pracownik> listopad;
    private List<Pracownik> grudzien;

    public Year() {
        this.styczen = new LinkedList<>();
        this.luty = new LinkedList<>();
        this.marzec = new LinkedList<>();
        this.kwiecien = new LinkedList<>();
        this.maj = new LinkedList<>();
        this.czerwiec = new LinkedList<>();
        this.lipiec = new LinkedList<>();
        this.sierpien = new LinkedList<>();
        this.wrzesien = new LinkedList<>();
        this.pazdziernik = new LinkedList<>();
        this.listopad = new LinkedList<>();
        this.grudzien = new LinkedList<>();
    }

    public List<Pracownik> getStyczen() {
        return styczen;
    }

    public List<Pracownik> getLuty() {
        return luty;
    }

    public List<Pracownik> getMarzec() {
        return marzec;
    }

    public List<Pracownik> getKwiecien() {
        return kwiecien;
    }

    public List<Pracownik> getMaj() {
        return maj;
    }

    public List<Pracownik> getCzerwiec() {
        return czerwiec;
    }

    public List<Pracownik> getLipiec() {
        return lipiec;
    }

    public List<Pracownik> getSierpien() {
        return sierpien;
    }

    public List<Pracownik> getWrzesien() {
        return wrzesien;
    }

    public List<Pracownik> getPazdziernik() {
        return pazdziernik;
    }

    public List<Pracownik> getListopad() {
        return listopad;
    }

    public List<Pracownik> getGrudzien() {
        return grudzien;
    }

    /*
    public void saveLists() {
        String filename = "lists.ser";
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(this);
            out.close();
            file.close();
        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }

    }

     */
}
