/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador_de_Interfaz;

import Operaciones_Logicas.OptLogicas;
import Recursos.Imagen;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

/**
 *
 * @author Rodrigo
 */
public class VistaController implements Initializable {
    
    @FXML
    public Button aceptar;    
    @FXML
    public Pane menurotar;    
    @FXML
    public Pane menudarformato;
    @FXML
    public Pane menuprincipal;            
    @FXML
    public Button invertir;    
    @FXML
    public Button mrotar;  
    @FXML
    public Button rotarizquierda;  
    @FXML
    public Button rotarderecha;  
    @FXML
    public TextField texto;       
    @FXML
    public TextField textoIngresado;       
    @FXML
    public TextField letraradar;       
    OptLogicas operaciones =new OptLogicas() ;
    Imagen imagenes = new Imagen();
    
    @FXML    
    public ImageView radar= new ImageView(imagenes.getRadar());
             
    
        
    @FXML
    public void menuRotar(ActionEvent event){
        menuprincipal.setVisible(false);
        menudarformato.setVisible(false);
        menurotar.setVisible(true);
    }    
    @FXML
    public void rotarIzquierda(ActionEvent event){
        
        textoIngresado.setRotate(textoIngresado.getRotate()+30);
        letraradar.setText(operaciones.rotar(letraradar.getText(), -30));
        
    }    
    @FXML
    public void rotarDerecha(ActionEvent event){
        textoIngresado.setRotate(textoIngresado.getRotate()-30);
        letraradar.setText(operaciones.rotar(letraradar.getText(), 30));
    }    
    @FXML
    public void menuDarFormato(ActionEvent event){
        menuprincipal.setVisible(false);
        menudarformato.setVisible(true);
        menurotar.setVisible(false);
    }            

    @FXML
    public void getTexto(ActionEvent event) {
        String text = texto.getText();        
        operaciones.separarTexto(text);
        operaciones.imprimir();
        mostrarTexto();
    }
    
    @FXML
    public void invertir(ActionEvent event){
        menuprincipal.setVisible(true);
        menudarformato.setVisible(false);
        menurotar.setVisible(false);
        operaciones.invertirTexto(operaciones.texto);
        operaciones.imprimir();
        mostrarTexto();
    }
    @FXML
    public void mostrarTexto() {
        textoIngresado.setText(operaciones.texto);        
        
    }
    @FXML
    public void trasladarTexto(MouseEvent event){
        menudarformato.setVisible(false);
        menurotar.setVisible(false);
        menuprincipal.setVisible(true);
        textoIngresado.setLayoutX(event.getSceneX());
        textoIngresado.setLayoutY(event.getSceneY());
    }
    @FXML
    public void visualizarPuntos(ActionEvent event){
        menuprincipal.setVisible(true);
        menudarformato.setVisible(false);
        menurotar.setVisible(false);
        /*
        //Dibujando el primer punto
        Circle circle = new Circle();
        
        //Configurando la posición del circulo
        circle.setCenterX(100.0f);
        circle.setCenterY(100.0f);
        
        //Configurando el radio del circulo con el color de relleno
        circle.setRadius(10.0f);
        circle.setFill(Color.RED);*/
        operaciones.agregarPuntosControl();
        
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO        
    }    
    
}
