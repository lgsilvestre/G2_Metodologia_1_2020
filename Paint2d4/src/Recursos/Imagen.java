/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Nicolas
 */
public class Imagen {
    
    private Image puntoControl = new Image(getClass().getResourceAsStream("/Recursos/Imagenes/puntoControl.png"));
    private Image capsulaSubrayar = new Image(getClass().getResourceAsStream("/Recursos/Imagenes/boton-08.png"));
    private Image capsulaSubrayarSeleccionado = new Image(getClass().getResourceAsStream("/Recursos/Imagenes/boton-09.png"));
    private Image capsulaNegrita = new Image(getClass().getResourceAsStream("/Recursos/Imagenes/boton-11.png"));
    private Image capsulaNegritaSeleccionado = new Image(getClass().getResourceAsStream("/Recursos/Imagenes/boton-12.png"));
    private Image capsulaCursiva = new Image(getClass().getResourceAsStream("/Recursos/Imagenes/boton-14.png"));
    private Image capsulaCursivaSeleccionado = new Image(getClass().getResourceAsStream("/Recursos/Imagenes/boton-15.png"));
    private Image radar = new Image(getClass().getResourceAsStream("/Recursos/Imagenes/radar.png"));
    private Image capsulaHorizontal = new Image(getClass().getResourceAsStream("/Recursos/Imagenes/boton-18.png"));

    public Image getPuntoControl() {
        return puntoControl;
    }

    public Image getCapsulaSubrayar() {
        return capsulaSubrayar;
    }

    public Image getCapsulaSubrayarSeleccionado() {
        return capsulaSubrayarSeleccionado;
    }

    public Image getCapsulaNegrita() {
        return capsulaNegrita;
    }

    public Image getCapsulaNegritaSeleccionado() {
        return capsulaNegritaSeleccionado;
    }

    public Image getCapsulaCursiva() {
        return capsulaCursiva;
    }

    public Image getCapsulaCursivaSeleccionado() {
        return capsulaCursivaSeleccionado;
    }

    public Image getRadar() {
        return radar;
    }
    
    public Image getCapsulaHorizontal() {
        return capsulaHorizontal;
    }
}
