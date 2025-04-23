package org.uax.menu;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.*;

import org.uax.ciudad.Ciudades;
import org.uax.ciudad.Ciudad;

public class Menu extends JFrame {
    private JButton anadirCiudad;
    private JButton mostrarCiudades;
    private JButton salir;
    private JTextField areaCiudad;
    private JTextField areaPais;
    private JTextField areaHabitantes;
    private JTextArea mostrar;
    private Ciudades ciudades;

    public Menu() {
        setTitle("Menu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        anadirCiudad = new JButton("Añadir Ciudad");
        mostrarCiudades = new JButton("Mostrar Ciudades");
        salir = new JButton("Salir");
        areaCiudad = new JTextField(10);
        areaPais = new JTextField(10);
        areaHabitantes = new JTextField(10);
        mostrar = new JTextArea(10, 30);

        //Panel North
        JPanel panelNorth1 = new JPanel(new GridLayout(2, 1));
        JLabel intrucciones = new JLabel("Ingrese las ciudades");
        panelNorth1.add(intrucciones);
        JPanel panelNoth2= new JPanel(new GridLayout(3, 2));
        panelNoth2.add(new JLabel("Ciudad:"));
        panelNoth2.add(areaCiudad);
        panelNoth2.add(new JLabel("Pais:"));
        panelNoth2.add(areaPais);
        panelNoth2.add(new JLabel("Habitantes:"));
        panelNoth2.add(areaHabitantes);
        panelNorth1.add(panelNoth2);

        add(panelNorth1, BorderLayout.NORTH);

        //Panel Center
        mostrar.setEditable(false);
        JPanel panelCenter = new JPanel();
        panelCenter.add(mostrar);

        add(panelCenter, BorderLayout.CENTER);

        //Panel South
        JPanel panelSouth = new JPanel(new GridLayout(1, 3));
        panelSouth.add(anadirCiudad);
        panelSouth.add(mostrarCiudades);
        panelSouth.add(salir);

        add(panelSouth, BorderLayout.SOUTH);




        anadirCiudad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ciudad = areaCiudad.getText();
                String pais = areaPais.getText();
                String habitantes = areaHabitantes.getText();
                int numHabitantes;
                try {
                    if (habitantes.equals("")) {
                        numHabitantes = 0;
                    } else {
                        numHabitantes = Integer.parseInt(habitantes);
                    }
                }catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El número de habitantes debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Ciudad ciudadAux = new Ciudad(ciudad, pais,numHabitantes);


                if (ciudad.isEmpty() || pais.isEmpty() || habitantes.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                }else {
                    try {
                        if(ciudades == null) {
                            ciudades = new Ciudades();
                            ciudades.addCiudad(ciudadAux);
                            ciudades.addCiudad(ciudadAux);
                            mostrar.append("Ciudad añadida: " + ciudad + ", " + pais + ", " + numHabitantes + "\n");
                            areaCiudad.setText("");
                            areaPais.setText("");
                            areaHabitantes.setText("");
                        }else{
                            if(ciudades.contenido(ciudadAux,ciudades.getCiudades())){
                                JOptionPane.showMessageDialog(null, "La ciudad ya existe en la lista.");
                            }else{
                                mostrar.setText("");
                                ciudades.addCiudad(ciudadAux);
                                mostrar.append("Ciudad añadida: " + ciudad + ", " + pais + ", " + numHabitantes + "\n");
                                areaCiudad.setText("");
                                areaPais.setText("");
                                areaHabitantes.setText("");
                            }

                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Error.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        mostrarCiudades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ciudades == null || ciudades.getCiudades().isEmpty()) {
                    mostrar.setText("No hay ciudades en la lista.");
                } else {
                    mostrar.setText("");
                    mostrar.append("Mostrando ciudades...\n");
                    mostrar.append(ciudades.toString());
                }
            }
        });

        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
