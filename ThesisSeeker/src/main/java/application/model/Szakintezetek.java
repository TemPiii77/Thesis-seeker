package application.model;

public class Szakintezetek {

    String szakAzonosito;
    String intezetNev;

    public Szakintezetek() {}

    public Szakintezetek(String szakAzonosito, String intezetNev) {
        this.szakAzonosito = szakAzonosito;
        this.intezetNev = intezetNev;
    }

    public String getSzakAzonosito() {
        return szakAzonosito;
    }

    public void setSzakAzonosito(String szakAzonosito) {
        this.szakAzonosito = szakAzonosito;
    }

    public String getIntezetNev() {
        return intezetNev;
    }

    public void setIntezetNev(String intezetNev) {
        this.intezetNev = intezetNev;
    }
}
