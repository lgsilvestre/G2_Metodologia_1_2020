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
import javafx.scene.control.ScrollPane;
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
    public Button rotarderecha;  
    @FXML
    public TextField texto;       
    @FXML
    public TextField textoIngresado;       
    @FXML
    public TextField letraradar;       
    OptLogicas operaciones =new OptLogicas() ;
    Imagen imagenes = new Imagen();
    boolean mover = false;
    @FXML    
    public ImageView radar= new ImageView(imagenes.getRadar());
    @FXML
    private ScrollPane sinmenu;
    @FXML
    private Pane canvasPane;
             
    
        
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
    public void rotarDerecha(ActionEvent event){
        textoIngresado.setRotate(textoIngresado.getRotate()-30);
        letraradar.setText(operaciones.rotar(letraradar.getText(), 30));
    }    
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
    public void mostrarTexto() {
        textoIngresado.setText(operaciones.texto);        
        
    }
    @FXML
    public void trasladarTexto(MouseEvent event){
        
        if(mover){
            textoIngresado.setLayoutX(event.getX());
            textoIngresado.setLayoutY(event.getY());
        }
    }
    @FXML
    public void visualizarPuntos(ActionEvent event){
        menuprincipal.setVisible(true);
        menudarformato.setVisible(false);
        menurotar.setVisible(false);

        operaciones.agregarPuntosControl();
        textoIngresado.setText(operaciones.list.toString());
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO        
    }    

    @FXML
    private void activarTrasladar(MouseEvent event) {
        mover = true;
    }

    @FXML
    private void desactivarTrasladar(MouseEvent event) {
        mover = false;
    }
    
}
