package org.uax;
import org.uax.menu.Menu;

public class Main
{
    public static void main( String[] args )
    {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }
}
