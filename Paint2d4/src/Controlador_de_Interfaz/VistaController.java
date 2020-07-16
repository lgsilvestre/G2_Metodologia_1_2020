/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador_de_Interfaz;

import Operaciones_Logicas.OptLogicas;
import Recursos.Imagen;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

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
    public TextField letraradar;       
    OptLogicas operaciones =new OptLogicas() ;
    Imagen imagenes = new Imagen();
    
    @FXML    
    public ImageView radar= new ImageView(imagenes.getRadar());
    @FXML
    private ScrollPane sinmenu;
             
    @FXML
    private Pane canvasPane;
    boolean mover =false;
    boolean puntocontrol=false;
    String textoaux; 
    @FXML
    private Button rotarD;
    
    private TextFlow textoIngresado;
    @FXML
    private Button trasladar;
    @FXML
    private Button visualPunto;
  
    @FXML
    public void menuRotar(ActionEvent event){
       
            menuprincipal.setVisible(false);
            menudarformato.setVisible(false);
            menurotar.setVisible(true);
       
        
    }    
    @FXML
    public void rotarIzquierda(ActionEvent event){
        
        textoIngresado.setRotate(textoIngresado.getRotate()+30);
        
        letraradar.setText(operaciones.rotar(letraradar.getText(), +30));
        
         
        
        
    } 
    @FXML
    public void rotarDerecha(ActionEvent event){
        
        textoIngresado.setRotate(textoIngresado.getRotate()-30);
       
        
        letraradar.setText(operaciones.rotar(letraradar.getText(),-30));
        
       
    }    
    public void menuDarFormato(ActionEvent event){
        menuprincipal.setVisible(false);
        menudarformato.setVisible(true);
        menurotar.setVisible(false);
    }            

    @FXML
    public void getTexto(ActionEvent event) { 
        Text texto1 = new Text(texto.getText());
        texto1.setFont(Font.font("Rage Italic", 30));
        textoIngresado.getChildren().add(texto1);   
    }
    
    @FXML
    public void invertir(ActionEvent event){
        menuprincipal.setVisible(true);
       
//        operaciones.invertirTexto(operaciones.texto);
        operaciones.imprimir();
       
    }
    
    @FXML
    public void trasladarTexto(MouseEvent event){
        
        if (mover) {
            
            textoIngresado.setLayoutX(event.getX());
            textoIngresado.setLayoutY(event.getY());
            
        }
        
     
          
        
   }
    @FXML
    public void visualizarPuntos(ActionEvent event){
        menuprincipal.setVisible(true);
        
        double X=0,Y=0,rota=0;
        Text aux =new Text(texto.getText());
        X= textoIngresado.getLayoutX();
        Y= textoIngresado.getLayoutY();
        rota= textoIngresado.getRotate();
        visualPunto.setStyle("-fx-background-color: #08b2c9;");
        if (puntocontrol==false) {
            
            textoIngresado=operaciones.separarTexto(texto.getText(),textoIngresado);
            
            textoIngresado.setMaxSize(950, 200);
            textoIngresado.setLayoutX(40);
            textoIngresado.setLayoutY(40);
                    
            canvasPane.getChildren().clear();
            canvasPane.getChildren().add(textoIngresado);
            
            
            
            puntocontrol=true;
        }else{
            visualPunto.setStyle("-fx-background-color: rgb(0,68,114);");
            aux.setFont(Font.font("Rage Italic", 30));
            textoIngresado.getChildren().clear();
            textoIngresado.getChildren().add(aux);
            textoIngresado.setLayoutX(X);
            textoIngresado.setLayoutY(Y);
            textoIngresado.setRotate(rota);
            canvasPane.getChildren().clear();
            canvasPane.getChildren().add(textoIngresado);
            puntocontrol=false;
        
            
        }
//        textoIngresado.setText(operaciones.list.toString());
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO    
        textoIngresado = new TextFlow();
        canvasPane.getChildren().add(textoIngresado);
        
        
    }      

     @FXML
    private void desactivarTrasladar(MouseEvent event) {
        mover=false;
        trasladar.setStyle("-fx-background-color: rgb(0,68,114);");
         System.out.println(textoIngresado.getLayoutX()+" "+textoIngresado.getLayoutY());
        
    }

    @FXML
    private void activarTrasladar(MouseEvent event) 
    {
        mover=true;
        trasladar.setStyle("-fx-background-color: #08b2c9;");
        textoIngresado.setOnMousePressed((event2) -> {
             mover=false;
             trasladar.setStyle("-fx-background-color: rgb(0,68,114);");
        });
    }
    
}
