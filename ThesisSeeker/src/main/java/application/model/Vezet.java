package application.model;

public class Vezet {

    int dolgozatAzonosito;
    String egyetemiAzonosito;

    public Vezet() {}

    public Vezet(int dolgozatAzonosito, String egyetemiAzonosito) {
        this.dolgozatAzonosito = dolgozatAzonosito;
        this.egyetemiAzonosito = egyetemiAzonosito;
    }

    public int getDolgozatAzonosito() {
        return dolgozatAzonosito;
    }

    public void setDolgozatAzonosito(int dolgozatAzonosito) {
        this.dolgozatAzonosito = dolgozatAzonosito;
    }

    public String getEgyetemiAzonosito() {
        return egyetemiAzonosito;
    }

    public void setEgyetemiAzonosito(String egyetemiAzonosito) {
        this.egyetemiAzonosito = egyetemiAzonosito;
    }
}
