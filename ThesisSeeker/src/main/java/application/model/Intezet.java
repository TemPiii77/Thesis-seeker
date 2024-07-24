package application.model;

public class Intezet {

    String intezetNev;
    String karNev;

    public Intezet() {}

    public Intezet(String intezetNev, String karNev) {
        this.intezetNev = intezetNev;
        this.karNev = karNev;
    }

    public String getIntezetNev() {
        return intezetNev;
    }

    public void setIntezetNev(String intezetNev) {
        this.intezetNev = intezetNev;
    }

    public String getKarNev() {
        return karNev;
    }

    public void setKarNev(String karNev) {
        this.karNev = karNev;
    }
}
