/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Botones;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author guillermo.camher
 */
public class BotonXCierre extends Button {

    private final Image imagenCierreX = (Toolkit.getDefaultToolkit()).getImage("src/Imagenes/XCierres.png");//Se crea la variable que contiene la imagen del boton de cierre
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(imagenCierreX, 0, 0, getWidth(), getHeight(), this);//Se dibuja la imagen en el boton
    }
    

}
