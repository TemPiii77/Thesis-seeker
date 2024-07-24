package application.model;

public class Temavezeto extends Szemely {

    String munkakoriBeosztas;
    String szerepkor;
    String tanszekNev;

    public Temavezeto() {}

    public Temavezeto(String egyetemiAzonosito, String munkakoriBeosztas, String tanszekNev) {
        this.egyetemiAzonosito = egyetemiAzonosito;
        this.munkakoriBeosztas = munkakoriBeosztas;
        this.tanszekNev = tanszekNev;
    }

    public Temavezeto(String egyetemiAzonosito, String elotag, String vezeteknev, String keresztnev, String jelszo, String jelszoUjra, String jogosultsag, String munkakoriBeosztas, String szerepkor, String tanszekNev) {
        super(egyetemiAzonosito, elotag, vezeteknev, keresztnev, jelszo, jelszoUjra, jogosultsag);
        this.munkakoriBeosztas = munkakoriBeosztas;
        this.szerepkor = szerepkor;
        this.tanszekNev = tanszekNev;
    }

    public String getMunkakoriBeosztas() {
        return munkakoriBeosztas;
    }

    public void setMunkakoriBeosztas(String munkakoriBeosztas) {
        this.munkakoriBeosztas = munkakoriBeosztas;
    }

    public String getSzerepkor() {
        return szerepkor;
    }

    public void setSzerepkor(String szerepkor) {
        this.szerepkor = szerepkor;
    }

    public String getTanszekNev() {
        return tanszekNev;
    }

    public void setTanszekNev(String tanszekNev) {
        this.tanszekNev = tanszekNev;
    }
}
