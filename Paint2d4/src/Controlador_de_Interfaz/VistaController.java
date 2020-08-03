/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador_de_Interfaz;

import Operaciones_Logicas.OptLogicas;

import Recursos.Imagen;
import java.awt.font.TextAttribute;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 *
 * @author Rodrigo
 */
public class VistaController implements Initializable {
    double X;
    double Y;
    double rota;
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
    
    Imagen CargarImagen;
    @FXML
    public TextField letraradar;       
    OptLogicas operaciones =new OptLogicas() ;
    
    
             
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
    private ChoiceBox<String> Menupalabras;
    ObservableList lista= FXCollections.observableArrayList();
    ArrayList<Text> textos = new ArrayList<>();
    @FXML
    private Button seleccionarPalabra;
    @FXML
    private ImageView Subrayado= new ImageView();;
    public Image SubrayadoImage = new Image("/Imagenes/boton-08.png");
    public Image SubrayadoIP = new Image("/Imagenes/boton-09.png");
    @FXML
    private ImageView Negrita= new ImageView(); ;
    public Image NegritaImage= new Image("/Imagenes/boton-11.png");
    public Image NegritaIP = new Image("/Imagenes/boton-12.png");
    @FXML
    private ImageView Cursiva = new ImageView();
    public Image CursivaImage= new Image("/Imagenes/boton-14.png");
    public Image CursivaIP = new Image("/Imagenes/boton-15.png");
    
    
    @FXML
    private ImageView radar;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO    
        menudarformato.setVisible(false);
         menurotar.setVisible(false);
        textoIngresado = new TextFlow();
        X= textoIngresado.getLayoutX();
        Y= textoIngresado.getLayoutY();
        rota= textoIngresado.getRotate();
        canvasPane.getChildren().add(textoIngresado);
        
        
    }   
    @FXML
    public void menuRotar(ActionEvent event){
       
          
            menudarformato.setVisible(false);
            menurotar.setVisible(true);
       
        
    }  
    @FXML
    public void menuDarFormato(ActionEvent event){
        
        menudarformato.setVisible(true);
        menurotar.setVisible(false);
        
        
        
        
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
             

   
    
    @FXML
    public void invertir(ActionEvent event){
         
        operaciones.invertirTexto(texto.getText());
       
       
    }
    
    @FXML
    public void trasladarTexto(MouseEvent event){
        
        if (mover) {
            textoIngresado.setLayoutX(event.getX());
            textoIngresado.setLayoutY(event.getY());    
        }     
   }
    TextFlow copiaseguridad = new TextFlow();
    @FXML
    public void visualizarPuntos(ActionEvent event){
        menuprincipal.setVisible(true);
        
        
        Text aux =new Text(texto.getText());
        X= textoIngresado.getLayoutX();
        Y= textoIngresado.getLayoutY();
        rota= textoIngresado.getRotate();
        visualPunto.setStyle("-fx-background-color: #08b2c9;");
        if (puntocontrol==false) {
            operaciones.separarTexto(texto.getText(),textoIngresado,textos,canvasPane);
            textoIngresado.setMaxSize(950, 200);
            textoIngresado.setLayoutX(X);
            textoIngresado.setLayoutY(Y);
            puntocontrol=true;
        }else{
            visualPunto.setStyle("-fx-background-color: rgb(0,68,114);");
            aux.setFont(Font.font("Segoe Script", 30));
            textoIngresado.setMaxSize(950, 200);
            textoIngresado.setLayoutX(X);
            textoIngresado.setLayoutY(Y);
            textoIngresado.setRotate(rota);
            canvasPane.getChildren().clear();
            canvasPane.getChildren().add(textoIngresado);
            puntocontrol=false;
        
            
        }
//        textoIngresado.setText(operaciones.list.toString());
        
    }
       

     @FXML
    private void desactivarTrasladar(MouseEvent event) {
        mover=false;
        trasladar.setStyle("-fx-background-color: rgb(0,68,114);");
//         System.out.println(textoIngresado.getLayoutX()+" "+textoIngresado.getLayoutY());
        
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

    TextFlow auxiliar;

    @FXML
    private void leertexto(KeyEvent event) {
        textoIngresado.setMaxSize(950, 200);
        textoIngresado.setLayoutX(40);
        textoIngresado.setLayoutY(40);
        textoIngresado.getChildren().clear();
        
        String [] aux = texto.getText().split(" ");
        String letra="";
        String espacio="";
        for (int i = 0; i < aux.length; i++) {
            if (aux[i]!=" ") {
                Text texto1 = new Text(aux[i]);
                Font fuente = Font.font("Segoe Script",65);
                texto1.setFont(fuente);
                Text texto2 = new Text(" ");
                texto2.setFont(fuente);
                 textoIngresado.getChildren().add(texto1);
                  //textoIngresado.getChildren().add(texto2);
            }else{
                Text texto1 = new Text(" ");
                Font fuente = Font.font("Segoe Script",65);
                texto1.setFont(fuente);
                
                textoIngresado.getChildren().add(texto1);
               
            }
        } 
        Text aux1 = new Text();
        for (int j = 0; j < textoIngresado.getChildren().size(); j++) {
                aux1= (Text) textoIngresado.getChildren().get(j);
                if (aux1.getText()!=" ") {
                    Text texto2 = new Text(" ");
                    Font fuente = Font.font("Segoe Script",65);
                    texto2.setFont(fuente);
                    textoIngresado.getChildren().add(j+1, texto2);
                }
                
        }
        textoIngresado.getChildren().remove(textoIngresado.getChildren().size()-1);
            
        for (int j = 0; j < textoIngresado.getChildren().size(); j++) {
                aux1= (Text) textoIngresado.getChildren().get(j);
                
                if (aux1.getText().isEmpty()) {
                    textoIngresado.getChildren().remove(j);
                
                }
        }    
        
        Text aux2 = new Text();
        
        System.out.println("...");
        
         for (int i = 0; i <textos.size(); i++) {
             aux2= (Text) textoIngresado.getChildren().get(i);
             boolean subrayado;
             if (textos.get(i).isUnderline()) {
                 aux2.setUnderline(true);
             }else{
                 aux2.setUnderline(false);
             }
             aux2.setFont(textos.get(i).getFont());
            
        }
          System.out.println("...");
    
        Menupalabras.getItems().removeAll(lista);
        lista.clear();
        textos.clear();
        operaciones.cargarDatos(lista, Menupalabras, textoIngresado,textos);
        
        if (lista.size()!=0) {
             Menupalabras.setValue((String) lista.get(0)); 
             
        }
        
    }
    Text PalabraSeleccioanda;
    int IndexPalabra;
    @FXML
    private void leerPalabra(ActionEvent event) {
        Menupalabras.valueProperty().getValue();
        if (textos.size()!=0) {
            String[] indice = Menupalabras.getValue().split("-");
            IndexPalabra= Integer.parseInt(indice[0]);
            Text aux = (Text) textoIngresado.getChildren().get(IndexPalabra);
            PalabraSeleccioanda = aux;
            if (aux.getFont().getFamily().equals("Segoe Script")) {
                Cursiva.setImage(CursivaImage);
                if (aux.getFont().getStyle().equals("Regular")) {
                    Negrita.setImage(NegritaImage);
                }else if (aux.getFont().getStyle().equals("Bold")) {
                    Negrita.setImage(NegritaIP);
                }
                if (aux.isUnderline()== true) {
                    Subrayado.setImage(SubrayadoIP);   
                }else{
                    Subrayado.setImage(SubrayadoImage);
                }
            }
            if (aux.getFont().getFamily().equals("Vladimir Script")) {
                Cursiva.setImage(CursivaIP);
                Negrita.setImage(NegritaImage);
                 if (aux.isUnderline()== true) {
                    Subrayado.setImage(SubrayadoIP);
                }else{
                    Subrayado.setImage(SubrayadoImage);
                }
            }if (aux.getFont().getFamily().equals("Mistral")) {
                Cursiva.setImage(CursivaIP);
                Negrita.setImage(NegritaIP);
                 if (aux.isUnderline()== true) {
                    Subrayado.setImage(SubrayadoIP);  
                }else{
                    Subrayado.setImage(SubrayadoImage);
                }   
            }
        }  
    }
    Boolean SubrayadoB=false;
    @FXML
    private void SubrayadoPresionado(MouseEvent event) {
        if (SubrayadoB==false) {
            SubrayadoB=true;
            Subrayado.setImage(SubrayadoIP);
            Text aux = new Text();
            aux= (Text) textoIngresado.getChildren().get(IndexPalabra);
            aux.setUnderline(true);
        }else{
            PalabraSeleccioanda.setUnderline(false);
            SubrayadoB=false;
            Subrayado.setImage(SubrayadoImage);
            Text aux = new Text();
            aux= (Text) textoIngresado.getChildren().get(IndexPalabra);
            aux.setUnderline(false);
        }
       
    }
    Boolean NegritaB =false;
    @FXML
    private void NegritaPresionado(MouseEvent event) {
            Text aux = new Text();
            aux= (Text) textoIngresado.getChildren().get(IndexPalabra);
             boolean subrayado;
                if (aux.isUnderline()) {
                    subrayado=true;
                }else{
                    subrayado=false;
                }
            if (aux.getFont().getFamily().equals("Segoe Script")) {
                if (subrayado) {
                    aux.setUnderline(true);
                }else{
                    aux.setUnderline(false);
                }
                if (aux.getFont().getStyle().equals("Regular")) {
                    Font fuente = Font.font("Segoe Script",FontWeight.BOLD,aux.getFont().getSize());
                    aux.setFont(fuente);
                    Negrita.setImage(NegritaIP);
                }else if (aux.getFont().getStyle().equals("Bold")) {
                    Font fuente = Font.font("Segoe Script",aux.getFont().getSize());
                    aux.setFont(fuente);
                    Negrita.setImage(NegritaImage);
                } 
            }
            else if (aux.getFont().getFamily().equals("Vladimir Script")) {
                Font fuente = Font.font("Mistral",aux.getFont().getSize());
                aux.setFont(fuente);
                Negrita.setImage(NegritaIP);
                if (subrayado) {
                    aux.setUnderline(true);
                }else{
                    aux.setUnderline(false);
                }
            }
            else if (aux.getFont().getFamily().equals("Mistral")) {
                Font fuente = Font.font("Vladimir Script",aux.getFont().getSize());
                aux.setFont(fuente);
                Negrita.setImage(NegritaImage);
                
            }     
    }

    @FXML
    private void CursivaPresionado(MouseEvent event) {
        Text aux = new Text();
        aux= (Text) textoIngresado.getChildren().get(IndexPalabra);
        boolean subrayado;
        if (aux.isUnderline()) {
            subrayado=true;
        }else{
            subrayado=false;
        }
        if (aux.getFont().getFamily().equals("Segoe Script")) {
                if (subrayado) {
                    aux.setUnderline(true);
                }else{
                    aux.setUnderline(false);
                }
                if (aux.getFont().getStyle().equals("Regular")) {
                    Font fuente = Font.font("Vladimir Script",aux.getFont().getSize());
                    aux.setFont(fuente);
                    Cursiva.setImage(CursivaIP);
                    
                }else if (aux.getFont().getStyle().equals("Bold")) {
                    Font fuente = Font.font("Mistral",aux.getFont().getSize());
                    aux.setFont(fuente);
                    Cursiva.setImage(CursivaIP);
                    
                }
                
            }
            else if (aux.getFont().getFamily().equals("Vladimir Script")) {
                
                
                Font fuente = Font.font("Segoe Script",aux.getFont().getSize());
                
                aux.setFont(fuente);
                
                Cursiva.setImage(CursivaImage);
                if (subrayado) {
                    aux.setUnderline(true);
                }else{
                    aux.setUnderline(false);
                }
                
                
                
                
                
                
                
                
            }
            else if (aux.getFont().getFamily().equals("Mistral")) {
                Font fuente = Font.font("Segoe Script",FontWeight.BOLD,aux.getFont().getSize());
                aux.setFont(fuente);
                Cursiva.setImage(CursivaImage);
                if (subrayado) {
                    aux.setUnderline(true);
                }else{
                    aux.setUnderline(false);
                }
                
            }
            
    }
    
}
