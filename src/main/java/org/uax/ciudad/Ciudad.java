package org.uax.ciudad;

public class Ciudad {
    private String nombre;
    private String pais;
    private int habitantes;

    // Constructores
    public Ciudad() {
        this.nombre = "";
        this.pais = "";
        this.habitantes = 0;
    }
    public Ciudad(String nombre, String pais, int habitantes) {
        this.nombre = nombre;
        this.pais = pais;
        this.habitantes = habitantes;
    }

    //Setters y Getters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public int getHabitantes() {
        return habitantes;
    }
    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }
    //Metodos
    @Override
    public String toString() {
        return nombre + ", " + pais + ", " + habitantes;
    }
}
