package Programa;

public class Nodo {

    private String dato;
    Nodo sig, ant;

    public Nodo() {
        dato = "";
        sig = null;
        ant = null;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

}
