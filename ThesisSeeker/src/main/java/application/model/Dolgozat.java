package application.model;

public class Dolgozat {

    int dolgozatAzonosito;
    String cim;
    String beadasEve;
    String vedesEve;
    int vedesErdemjegye;
    String egyetemiAzonosito;
    String szakAzonosito;
    String tanszekNev;

    public Dolgozat() {}

    public Dolgozat(int dolgozatAzonosito) {
        setDolgozatAzonosito(dolgozatAzonosito);
    }

    public Dolgozat(int dolgozatAzonosito, String cim) {
        this.dolgozatAzonosito = dolgozatAzonosito;
        this.cim = cim;
    }

    public Dolgozat(String cim, String beadasEve, String vedesEve, int vedesErdemjegye, String egyetemiAzonosito, String szakAzonosito, String tanszekNev) {
        this.cim = cim;
        this.beadasEve = beadasEve;
        this.vedesEve = vedesEve;
        this.vedesErdemjegye = vedesErdemjegye;
        this.egyetemiAzonosito = egyetemiAzonosito;
        this.szakAzonosito = szakAzonosito;
        this.tanszekNev = tanszekNev;
    }

    public Dolgozat(int dolgozatAzonosito, String cim, String beadasEve, String vedesEve, int vedesErdemjegye, String egyetemiAzonosito, String szakAzonosito, String tanszekNev) {
        this.dolgozatAzonosito = dolgozatAzonosito;
        this.cim = cim;
        this.beadasEve = beadasEve;
        this.vedesEve = vedesEve;
        this.vedesErdemjegye = vedesErdemjegye;
        this.egyetemiAzonosito = egyetemiAzonosito;
        this.szakAzonosito = szakAzonosito;
        this.tanszekNev = tanszekNev;
    }

    public int getDolgozatAzonosito() {
        return dolgozatAzonosito;
    }

    public void setDolgozatAzonosito(int dolgozatAzonosito) {
        this.dolgozatAzonosito = dolgozatAzonosito;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public String getBeadasEve() {
        return beadasEve;
    }

    public void setBeadasEve(String beadasEve) {
        this.beadasEve = beadasEve;
    }

    public String getVedesEve() {
        return vedesEve;
    }

    public void setVedesEve(String vedesEve) {
        this.vedesEve = vedesEve;
    }

    public int getVedesErdemjegye() {
        return vedesErdemjegye;
    }

    public void setVedesErdemjegye(int vedesErdemjegye) {
        this.vedesErdemjegye = vedesErdemjegye;
    }

    public String getEgyetemiAzonosito() {
        return egyetemiAzonosito;
    }

    public void setEgyetemiAzonosito(String egyetemiAzonosito) {
        this.egyetemiAzonosito = egyetemiAzonosito;
    }

    public String getSzakAzonosito() {
        return szakAzonosito;
    }

    public void setSzakAzonosito(String szakAzonosito) {
        this.szakAzonosito = szakAzonosito;
    }

    public String getTanszekNev() {
        return tanszekNev;
    }

    public void setTanszekNev(String tanszekNev) {
        this.tanszekNev = tanszekNev;
    }
}
