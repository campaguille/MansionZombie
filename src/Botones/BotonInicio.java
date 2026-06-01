/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Botones;

import java.awt.Button;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author guill
 */
public class BotonInicio extends Button {

    private final Image imagenBotonInicio = (Toolkit.getDefaultToolkit()).createImage("src/Imagenes/ImagenBotonInicio.png");//Se crea el objeto de la imagen del fondo del boton de inicio

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.drawImage(imagenBotonInicio, 0, 0, getWidth(), getHeight(), this);//Se dibuja la imagen en el boton

    }

}
