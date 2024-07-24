package application.model;

public class Tanszek {

    String tanszekNev;
    String intezetNev;

    public Tanszek() {}

    public Tanszek(String tanszekNev) {
        this.tanszekNev = tanszekNev;
    }

    public Tanszek(String tanszekNev, String intezetNev) {
        this.tanszekNev = tanszekNev;
        this.intezetNev = intezetNev;
    }

    public String getTanszekNev() {
        return tanszekNev;
    }

    public void setTanszekNev(String tanszekNev) {
        this.tanszekNev = tanszekNev;
    }

    public String getIntezetNev() {
        return intezetNev;
    }

    public void setIntezetNev(String intezetNev) {
        this.intezetNev = intezetNev;
    }
}
