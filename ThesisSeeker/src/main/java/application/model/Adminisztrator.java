package application.model;

public class Adminisztrator extends Szemely {

    String munkakoriBeosztas;

    public Adminisztrator() {}

    public Adminisztrator(String munkakoriBeosztas) {
        this.munkakoriBeosztas = munkakoriBeosztas;
    }

    public Adminisztrator(String egyetemiAzonosito, String munkakoriBeosztas) {
        setEgyetemiAzonosito(egyetemiAzonosito);
        setMunkakoriBeosztas(munkakoriBeosztas);
    }

    public Adminisztrator(String egyetemiAzonosito, String elotag, String vezeteknev, String keresztnev, String jelszo, String jelszoUjra, String jogosultsag, String munkakoriBeosztas) {
        super(egyetemiAzonosito, elotag, vezeteknev, keresztnev, jelszo, jelszoUjra, jogosultsag);
        this.munkakoriBeosztas = munkakoriBeosztas;
    }

    public String getMunkakoriBeosztas() {
        return munkakoriBeosztas;
    }

    public void setMunkakoriBeosztas(String munkakoriBeosztas) {
        this.munkakoriBeosztas = munkakoriBeosztas;
    }
}
