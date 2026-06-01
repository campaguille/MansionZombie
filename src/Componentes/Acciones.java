/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Componentes;

import ClasesLogica.MansiónZombie;
import Botones.BotonAvanzar;
import Botones.BotonBuscar;
import Botones.BotonCurarse;
import Botones.BotonLuchar;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author guill
 */
public class Acciones extends javax.swing.JDialog implements ActionListener {

    //Declaración de variables
    private Font fuenteEstandar;
    JLabel ptsVidaText = new JLabel("Puntos de vida:   " + Inicio.superviviente.getVidaS());
    JLabel cantidadProteccionesText = new JLabel("Cantidad de protecciones:   " + Inicio.superviviente.getCantidadProteccionesS());
    JLabel cantidadArmasText = new JLabel("Cantidad de armas:   " + Inicio.superviviente.getCantidadArmasS());
    JLabel botiquinText = new JLabel("¿Botiquín?:   " + Inicio.superviviente.getBotiquinS());
    JLabel intentosText = new JLabel("Intentos:   " + MansiónZombie.intentosBusqueda);
    JLabel CantidadZombiesText = new JLabel("Zombies:   " + MansiónZombie.numeroZombiesXHabitacion);
    JLabel habitacionActualText = new JLabel("Habitación Actual:  (MAX " + MansiónZombie.cantidadHabitaciones + ")    " + MansiónZombie.habitacionActual);
    //Los botones se tipan como estático para poder ser deshabilitados desde la clase superviviente por ejemplo se desactivan cuando el superviviente muere
    public static BotonLuchar botonLuchar = new BotonLuchar();
    public static BotonCurarse botonCurarse = new BotonCurarse();
    public static BotonBuscar botonBuscar = new BotonBuscar();
    public static BotonAvanzar botonAvanzar = new BotonAvanzar();

    //Métodos
    private void crearVentanaLucha() {
        Lucha ventanaLucha = new Lucha(null, true);
        ventanaLucha.setVisible(true);
    }

    private void actualizarTextos() {
        //Se actualiza la informacion de los JLabel con los valores de los objetos de la ventana Inicio
        ptsVidaText.setText("Puntos de vida:   " + Inicio.superviviente.getVidaS());
        cantidadProteccionesText.setText("Cantidad de protecciones:   " + Inicio.superviviente.getCantidadProteccionesS());
        cantidadArmasText.setText("Cantidad de armas:   " + Inicio.superviviente.getCantidadArmasS());
        botiquinText.setText("¿Botiquín?:   " + Inicio.superviviente.getBotiquinS());
        intentosText.setText("Intentos:   " + MansiónZombie.intentosBusqueda);
        CantidadZombiesText.setText("Zombies:   " + MansiónZombie.numeroZombiesXHabitacion);
        habitacionActualText.setText("Habitación Actual:  (MAX " + MansiónZombie.cantidadHabitaciones + ")    " + MansiónZombie.habitacionActual);
    }

    /**
     * Creates new form Acciones
     *
     * @param parent
     * @param modal
     */
    public Acciones(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        //Se define la fuente a usar en la ventana
        try {
            this.fuenteEstandar = Font.createFont(Font.TRUETYPE_FONT, new File("src/fuentes/GhoulFriAOE.ttf")).deriveFont(23f);//Se inicializa la fuente a utilizar 
        } catch (FontFormatException ex) {
            System.out.println("Error en el formato de la fuente: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error entrada salida: " + ex.getMessage());
        }

        //Se definen las propiedades de la ventana
        this.setResizable(false);

        this.setSize(1000, 600);
        this.setLocation(400, 250);

        //Fondo de la ventana, panel con imagen dibujada.
        FondoVentanaInicio panelFondo = new FondoVentanaInicio();
        panelFondo.setSize(1200, 800);
        panelFondo.setVisible(true);
        this.setContentPane(panelFondo);

        //Textos
        ptsVidaText.setFont(fuenteEstandar);
        ptsVidaText.setBounds(30, 35, 200, 20);
        ptsVidaText.setForeground(Inicio.colorFuente);
        this.add(ptsVidaText);

        cantidadProteccionesText.setFont(fuenteEstandar);
        cantidadProteccionesText.setBounds(30, 95, 300, 20);
        cantidadProteccionesText.setForeground(Inicio.colorFuente);
        this.add(cantidadProteccionesText);

        cantidadArmasText.setFont(fuenteEstandar);
        cantidadArmasText.setBounds(30, 155, 300, 20);
        cantidadArmasText.setForeground(Inicio.colorFuente);
        this.add(cantidadArmasText);

        botiquinText.setFont(fuenteEstandar);
        botiquinText.setBounds(30, 215, 300, 20);
        botiquinText.setForeground(Inicio.colorFuente);
        this.add(botiquinText);

        intentosText.setFont(fuenteEstandar);
        intentosText.setBounds(30, 275, 300, 20);
        intentosText.setForeground(Inicio.colorFuente);
        this.add(intentosText);

        habitacionActualText.setFont(fuenteEstandar);
        habitacionActualText.setBounds(30, 335, 300, 20);
        habitacionActualText.setForeground(Inicio.colorFuente);
        this.add(habitacionActualText);

        CantidadZombiesText.setFont(fuenteEstandar);
        CantidadZombiesText.setBounds(30, 395, 300, 20);
        CantidadZombiesText.setForeground(Inicio.colorFuente);
        this.add(CantidadZombiesText);

        //Botones
        botonLuchar.setBounds(600, 100, 125, 50);
        this.add(botonLuchar);
        botonLuchar.addActionListener(this);

        botonCurarse.setBounds(600, 180, 125, 50);
        this.add(botonCurarse);
        botonCurarse.addActionListener(this);

        botonBuscar.setBounds(600, 260, 125, 50);
        this.add(botonBuscar);
        botonBuscar.addActionListener(this);

        botonAvanzar.setBounds(600, 340, 125, 50);
        this.add(botonAvanzar);
        botonAvanzar.addActionListener(this);

        botonAvanzar.setVisible(false);
        botonBuscar.setVisible(false);
        botonCurarse.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Acciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Acciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Acciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Acciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Acciones dialog = new Acciones(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object objetoProcedenciaEvento = e.getSource();

        //Se abre el dialogo Lucha en caso de que se haya dado al boton de luchar
        if (objetoProcedenciaEvento.getClass() == BotonLuchar.class) {
            this.crearVentanaLucha();
        }
        //Se invoca el metodo de curarse propio del objeto superviviente definido en inicio en caso de que se presione el boton curarse
        if (objetoProcedenciaEvento.getClass() == BotonCurarse.class) {
            Inicio.superviviente.curarse();
        }
        //Se invoca el metodo de buscar por la habitacion propio del objeto superviviente definido en inicio en caso de que se presione el boton buscar
        if (objetoProcedenciaEvento.getClass() == BotonBuscar.class) {
            JOptionPane.showMessageDialog(null, Inicio.superviviente.buscarPorLaHabitacion());
        }
        //Se invoca el metodo de avanzar de habitacion propio del objeto superviviente definido en inicio en caso de que se presione el boton avanzar
        if (objetoProcedenciaEvento.getClass() == BotonAvanzar.class) {
            Inicio.superviviente.avanzarHabitacion();
        }
        if (MansiónZombie.numeroZombiesXHabitacion <= 0) {
            botonLuchar.setVisible(false);
        } else {
            botonLuchar.setVisible(true);
        }

        if (Inicio.superviviente.getBotiquinS().equalsIgnoreCase("SI")) {
            botonCurarse.setVisible(true);
        } else {
            botonCurarse.setVisible(false);
        }

        if (MansiónZombie.intentosBusqueda > 0 && MansiónZombie.numeroZombiesXHabitacion <= 0) {
            botonBuscar.setVisible(true);
        } else {
            botonBuscar.setVisible(false);
        }

        if (MansiónZombie.numeroZombiesXHabitacion <= 0 && MansiónZombie.habitacionActual != MansiónZombie.cantidadHabitaciones) {
            botonAvanzar.setVisible(true);
        } else {
            botonAvanzar.setVisible(false);
        }
        this.actualizarTextos();

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
