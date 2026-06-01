/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Componentes;

import ClasesLogica.Zombie;
import Botones.BotonLuchar;
import Botones.BotonTerminar;
import ClasesLogica.MansiónZombie;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author guill
 */
public class Lucha extends javax.swing.JDialog implements ActionListener {

    //Declaración de variables
    private Font fuenteEstandar;
    private JTextArea consolaVentana = new JTextArea();
    JLabel ptsVidaText;
    JLabel ptsVidaZText;
    JLabel ptsAtaqueS;
    JLabel ptsAtaqueZ;
    ImagenVictoria imagenVictoria;
    ImagenDerrota imagenDerrota;
    public static BotonLuchar botonLuchar;
    public static BotonTerminar botonTerminar;

    //Funciones
    private void actualizarTextos() {
        //Se actualiza la informacion de los JTextField con los valores de los objetos de la ventana Inicio
        ptsVidaText.setText("Vida Jugador: " + Inicio.superviviente.getVidaS());
        ptsVidaZText.setText("Vida Zombie: " + Inicio.zombie.vidaZ);
        ptsAtaqueS.setText("Ataque Superviviente: " + Inicio.superviviente.getAtaqueS());
        ptsAtaqueZ.setText("Ataque Zombie: " + Inicio.zombie.ataqueZ);
    }

    /**
     * Creates new form Acciones
     *
     * @param parent
     * @param modal
     */
    public Lucha(java.awt.Frame parent, boolean modal) {
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
        
        //Se añade una imagen de un zombie para tematizar
        ImagenZombieLucha imagenZombieLucha = new ImagenZombieLucha();
        imagenZombieLucha.setBounds(232,127,682,432);
        imagenZombieLucha.setOpaque(false);
        this.add(imagenZombieLucha);

        //Textos
        ptsVidaText = new JLabel("Vida Jugador: " + Inicio.superviviente.getVidaS());
        ptsVidaText.setFont(fuenteEstandar);
        ptsVidaText.setBounds(30, 35, 200, 20);
        ptsVidaText.setForeground(Inicio.colorFuente);
        this.add(ptsVidaText);

        ptsVidaZText = new JLabel("Vida Zombie: " + Inicio.zombie.vidaZ);
        ptsVidaZText.setFont(fuenteEstandar);
        ptsVidaZText.setBounds(200, 35, 200, 20);
        ptsVidaZText.setForeground(Inicio.colorFuente);
        this.add(ptsVidaZText);

        ptsAtaqueS = new JLabel("Ataque Superviviente: " + Inicio.superviviente.getAtaqueS());
        ptsAtaqueS.setFont(fuenteEstandar);
        ptsAtaqueS.setBounds(30, 95, 200, 20);
        ptsAtaqueS.setForeground(Inicio.colorFuente);
        this.add(ptsAtaqueS);

        ptsAtaqueZ = new JLabel("Ataque Zombie: " + Inicio.zombie.ataqueZ);
        ptsAtaqueZ.setFont(fuenteEstandar);
        ptsAtaqueZ.setBounds(250, 95, 200, 20);
        ptsAtaqueZ.setForeground(Inicio.colorFuente);
        this.add(ptsAtaqueZ);

        //Boton de lucha
        botonLuchar = new BotonLuchar();
        botonLuchar.setBounds(700, 45, 200, 75);
        this.add(botonLuchar);
        botonLuchar.addActionListener(this);

        //Boton de terminacion
        botonTerminar = new BotonTerminar();
        botonTerminar.setBounds(700, 45, 200, 75);
        this.add(botonTerminar);
        botonTerminar.addActionListener(this);
        botonTerminar.setVisible(false);

        //Imagen que se muestra en caso de que el jugador gane
        imagenVictoria = new ImagenVictoria();
        imagenVictoria.setBounds(700, 225, 200, 200);
        this.add(imagenVictoria);
        imagenVictoria.setVisible(false);

        //Imagen que se muestra en caso de que el jugador pierda
        imagenDerrota = new ImagenDerrota();
        imagenDerrota.setBounds(700, 225, 200, 200);
        this.add(imagenDerrota);
        imagenDerrota.setVisible(false);

        //Propiedades de la consola donde se muestra lo que ocurre, es un JTextArea
        consolaVentana.setBounds(30, 200, 600, 300);
        consolaVentana.setEditable(false);
        consolaVentana.setLineWrap(true);
        consolaVentana.setWrapStyleWord(true);
        this.add(consolaVentana);
        
        

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
            java.util.logging.Logger.getLogger(Lucha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lucha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lucha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lucha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Lucha dialog = new Lucha(new javax.swing.JFrame(), true);
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
        String informacion;
        //Se muestra el texto devuelto por el metodo combatirZombie en el JTextField propio del dialogo consolaVentana
        if (Inicio.zombie.vidaZ <= 0) { //Se crea un nuevo zombie en caso de que muera el anterior
            Inicio.zombie = new Zombie();
            informacion = Inicio.superviviente.combatirZombie(Inicio.superviviente, Inicio.zombie);
        } else {
            informacion = Inicio.superviviente.combatirZombie(Inicio.superviviente, Inicio.zombie);
        }
        consolaVentana.setText(informacion);

        if (MansiónZombie.numeroZombiesXHabitacion == 0 && MansiónZombie.habitacionActual == MansiónZombie.cantidadHabitaciones && Inicio.superviviente.getVidaS() > 0) { //En caso de que el jugador llegue a la ultima habitacion, no haya zombies y este vivo, significa que haganado y se muestra la imagen de victoria
            imagenVictoria.setVisible(true);
            botonLuchar.setVisible(false);
            botonTerminar.setVisible(true);
        }

        if (Inicio.superviviente.getVidaS() <= 0) { //En caso de que el jugador muera, se muestra la imagen de derrota y se desactivan todas las acciones
            imagenDerrota.setVisible(true);
            
            botonLuchar.setEnabled(false);
            Acciones.botonAvanzar.setVisible(false);
            Acciones.botonBuscar.setVisible(false);
            Acciones.botonCurarse.setVisible(false);
            Acciones.botonLuchar.setVisible(false);
            Acciones.botonAvanzar.setEnabled(false);
            Acciones.botonBuscar.setEnabled(false);
            Acciones.botonCurarse.setEnabled(false);
            Acciones.botonLuchar.setEnabled(false);
            botonLuchar.setVisible(false);
            botonTerminar.setVisible(true);
        }

        this.actualizarTextos();

        if (e.getSource().getClass() == BotonTerminar.class) {//Si se presiona el boton terminar el programa se cierra
            dispose();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
