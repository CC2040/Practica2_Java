package org.uax;
import org.uax.ciudad.Ciudades;
import org.uax.ciudad.Ciudad;
import org.uax.menu.Menu;

public class Main
{
    public static void main( String[] args )
    {
    Ciudad ciudad1 = new Ciudad("Madrid", "España", 3223000);
    Ciudad ciudad2 = new Ciudad("Barcelona", "España", 1620000);
    Ciudad ciudad3 = new Ciudad("Madrid", "España", 3223000);

        Ciudades ciudades = new Ciudades();
    ciudades.addCiudad(ciudad1);
    ciudades.addCiudad(ciudad2);
    ciudades.addCiudad(ciudad3);
    ciudades.mostrarCiudades();

        // Ejecutar en el hilo de eventos de Swing
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }
}
