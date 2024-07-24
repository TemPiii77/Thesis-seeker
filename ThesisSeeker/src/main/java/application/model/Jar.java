package application.model;

public class Jar {

    String szakAzonosito;
    String egyetemiAzonosito;
    String kezdesSzemesztere;
    String vegzesSzemesztere;
    String diplomaSorszama;

    public Jar() {}

    public Jar(String szakAzonosito, String egyetemiAzonosito) {
        setSzakAzonosito(szakAzonosito);
        setEgyetemiAzonosito(egyetemiAzonosito);
    }

    public Jar(String szakAzonosito, String egyetemiAzonosito, String kezdesSzemesztere, String vegzesSzemesztere, String diplomaSorszama) {
        this.szakAzonosito = szakAzonosito;
        this.egyetemiAzonosito = egyetemiAzonosito;
        this.kezdesSzemesztere = kezdesSzemesztere;
        this.vegzesSzemesztere = vegzesSzemesztere;
        this.diplomaSorszama = diplomaSorszama;
    }

    public String getSzakAzonosito() {
        return szakAzonosito;
    }

    public void setSzakAzonosito(String szakAzonosito) {
        this.szakAzonosito = szakAzonosito;
    }

    public String getEgyetemiAzonosito() {
        return egyetemiAzonosito;
    }

    public void setEgyetemiAzonosito(String egyetemiAzonosito) {
        this.egyetemiAzonosito = egyetemiAzonosito;
    }

    public String getKezdesSzemesztere() {
        return kezdesSzemesztere;
    }

    public void setKezdesSzemesztere(String kezdesSzemesztere) {
        this.kezdesSzemesztere = kezdesSzemesztere;
    }

    public String getVegzesSzemesztere() {
        return vegzesSzemesztere;
    }

    public void setVegzesSzemesztere(String vegzesSzemesztere) {
        this.vegzesSzemesztere = vegzesSzemesztere;
    }

    public String getDiplomaSorszama() {
        return diplomaSorszama;
    }

    public void setDiplomaSorszama(String diplomaSorszama) {
        this.diplomaSorszama = diplomaSorszama;
    }
}
