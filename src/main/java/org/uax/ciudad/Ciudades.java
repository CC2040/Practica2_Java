package org.uax.ciudad;
import java.util.Comparator;
import java.util.TreeSet;

public class Ciudades {
    private TreeSet<Ciudad> ciudades;

    // Constructores
    public Ciudades() {
        this.ciudades=null;
    }
    public Ciudades(TreeSet<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }
    //Setters y Getters
    public TreeSet<Ciudad> getCiudades() {
        return ciudades;
    }
    public void setCiudades(TreeSet<Ciudad> ciudad) {
        this.ciudades = ciudades;
    }
    //Metodos
    public void addCiudad(Ciudad ciudad) {
        if (ciudades == null) {
            Comparator<Ciudad> comparadorHabitantes = Comparator.comparingInt(Ciudad::getHabitantes)
                    .thenComparing(Ciudad::getNombre)
                    .thenComparing(Ciudad::getPais);
            ciudades = new TreeSet<>(comparadorHabitantes);
            ciudades.add(ciudad);
        }else {
            if (!ciudades.contains(ciudad)) {
                ciudades.add(ciudad);
            }
        }
    }
    public void mostrarCiudades(){
        if(ciudades == null || ciudades.isEmpty()) {
            System.out.println("No hay ciudades en la lista.");

        }else{
            System.out.print("Ciudades: ");
            for (Ciudad ciudad : ciudades) {
                System.out.print("["+ciudad.toString()+"] ");
            }
        }
    }
    public boolean contenido(Ciudad ciudad, TreeSet<Ciudad> ciudades) {
        if (ciudades == null || ciudad == null) {
            return false;
        }
        for (Ciudad ciudadAux : ciudades) {
            if (ciudadAux.getNombre().equals(ciudad.getNombre()) &&
                    ciudadAux.getPais().equals(ciudad.getPais())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if (ciudades == null || ciudades.isEmpty()) {
            return "No hay ciudades";
        }
        StringBuilder sb = new StringBuilder();
        for (Ciudad ciudad : ciudades) {
            sb.append(ciudad.getPais())
                    .append(" ")
                    .append(ciudad.getNombre())
                    .append(" ")
                    .append(ciudad.getHabitantes())
                    .append("\n");
        }
        return sb.toString();
    }
}
