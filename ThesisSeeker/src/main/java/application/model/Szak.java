package application.model;

public class Szak {

    String szakAzonosito;
    String szaknev;
    String karNev;

    public Szak() {}

    public Szak(String szakAzonosito, String szaknev, String karNev) {
        this.szakAzonosito = szakAzonosito;
        this.szaknev = szaknev;
        this.karNev = karNev;
    }

    public String getSzakAzonosito() {
        return szakAzonosito;
    }

    public void setSzakAzonosito(String szakAzonosito) {
        this.szakAzonosito = szakAzonosito;
    }

    public String getSzaknev() {
        return szaknev;
    }

    public void setSzaknev(String szaknev) {
        this.szaknev = szaknev;
    }

    public String getKarNev() {
        return karNev;
    }

    public void setKarNev(String karNev) {
        this.karNev = karNev;
    }
}
