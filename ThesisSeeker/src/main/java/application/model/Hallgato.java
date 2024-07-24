package application.model;

public class Hallgato extends Szemely {

    String jogviszony;

    public Hallgato() {}

    public Hallgato(String jogviszony) {
        this.jogviszony = jogviszony;
    }

    public Hallgato(String egyetemiAzonosito, String jogviszony) {
        this.setEgyetemiAzonosito(egyetemiAzonosito);
        this.setJogviszony(jogviszony);
    }

    public Hallgato(String egyetemiAzonosito, String elotag, String vezeteknev, String keresztnev, String jelszo, String jelszoUjra, String jogosultsag, String jogviszony) {
        super(egyetemiAzonosito, elotag, vezeteknev, keresztnev, jelszo, jelszoUjra, jogosultsag);
        this.jogviszony = jogviszony;
    }

    public String getJogviszony() {
        return jogviszony;
    }

    public void setJogviszony(String jogviszony) {
        this.jogviszony = jogviszony;
    }
}
