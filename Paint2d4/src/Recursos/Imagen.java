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
    
    
    private Image radar = new Image(getClass().getResourceAsStream("/Recursos/Imagenes/radar.png"));

    public Image getRadar() {
        return radar;
    }
}
