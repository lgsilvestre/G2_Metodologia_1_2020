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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * Aqui es donde se haran todas las operaciones que tienen relacion con la interfaz
 * de manera directa.
 * @author Rodrigo
 * @author Nicolas M 
 * @author Pablo
 * @author Fernanda
 * @author Felipe
 * @author Nicolas R
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
    boolean darformato =false;
    boolean rotar =false;   
    String textoaux; 
    private TextFlow textoIngresado;
    @FXML
    private Button trasladar;
    @FXML
    private Button visualPunto;
    ObservableList lista= FXCollections.observableArrayList();
    ArrayList<Text> textos = new ArrayList<>();
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
    private Button botonDarFormato;
    @FXML
    private ListView<String> ListaPalabras;
    int IndexPalabra;
    @FXML
    private Label tamanio;
    @FXML
    private ImageView aumentar;
    @FXML
    private ImageView disminuir;
    
   /**
    * Coloca todas las variables en sus valores iniciales, de manera que el programa 
    * inicie de manera correcta
    */ 
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
        disminuir.setVisible(false);
        aumentar.setVisible(false);
        tamanio.setVisible(false);        
    } 
    
    /**
     * Al presionar el boton de "rotar", mostrara lo relacionado a la rotacion, haciendo 
     * posible en cambiar los grados en los que se encuenta la palabra escrita
     * @param event al hacer click en el boton dentro de la interfaz
     */
    @FXML
    public void menuRotar(ActionEvent event){
       
        if (rotar==false) {
            mrotar.setStyle("-fx-background-color: #08b2c9;");
            botonDarFormato.setStyle("-fx-background-color: rgb(0,68,114);");
            menudarformato.setVisible(false);
            menurotar.setVisible(true);
            rotar=true;
            darformato=false;
        }
        else{
            mrotar.setStyle("-fx-background-color: rgb(0,68,114);");
            menurotar.setVisible(false);
            menudarformato.setVisible(false);
            rotar=false;
        }           
    }  
    
    /**
     * Al presionar el boton de "Dar formato", mostrara dentro de la interfaz todo 
     * lo relacionado a cambiar el formato de cada palabra, mostrando la lista de
     * palabras, para que seleccione la que quiera formatear.
     * @param event al hacer click en el boton dentro de la interfaz
     */
    @FXML
    public void menuDarFormato(ActionEvent event){
        
        if (darformato==false) {
            botonDarFormato.setStyle("-fx-background-color: #08b2c9;");
            menudarformato.setVisible(true);
            mrotar.setStyle("-fx-background-color: rgb(0,68,114);");
            menurotar.setVisible(false);
            darformato=true;
            rotar=false;
        }
        else{
            botonDarFormato.setStyle("-fx-background-color: rgb(0,68,114);");
            menudarformato.setVisible(false);
            menurotar.setVisible(false);
            darformato=false;
        }    
    }   
    
    /**
     * Los dos siguientes metodos actuan de igual manera, sinedo la unica diferencia
     * el sentido en el que cambian el grado de rotacion.
     * 
     * Este metodo suma 30° a la inclinacion de la palabra.
     * @param event al hacer click en el boton dentro de la interfaz
     */
    @FXML
    public void rotarIzquierda(ActionEvent event){
        
        textoIngresado.setRotate(textoIngresado.getRotate()+30);
        letraradar.setText(operaciones.rotar(letraradar.getText(), +30));
    } 
    /**
     * Este metodo resta 30° a la inclinacion de la palabra.
     * @param event al hacer click en el boton dentro de la interfaz
     */
    @FXML
    public void rotarDerecha(ActionEvent event){
        textoIngresado.setRotate(textoIngresado.getRotate()-30);
        letraradar.setText(operaciones.rotar(letraradar.getText(),-30));
    }    
             
    /**
     * Al presionar el boton de "Invertir", esta invertira el orden de las palabras
     * de la frase ingresada por el usuario
     * @param event al hacer click en el boton dentro de la interfaz
     */
    @FXML
    public void invertir(ActionEvent event){   
        if (puntocontrol) {
            visualizarPuntos(event);
        }
        operaciones.invertirTexto(textoIngresado,texto);
    }
    
    /**
     * Al presionar el boton de "Trasladar", se le permitira al usuario mover el cursor por
     * la superficie de la pizarra, asi tambien moviendo la frase, al dar clic dentro de la 
     * pizarra la frase se quedara en esa nueva posicion.
     * @param event al hacer click en el boton dentro de la interfaz
     */
    @FXML
    public void trasladarTexto(MouseEvent event){
        if (mover) {
            textoIngresado.setLayoutX(event.getX());
            textoIngresado.setLayoutY(event.getY());    
        }     
    }
    
    // copia de lo ingresado en el textFlow por seguridad y asi no perderla durante la ejecucion
    TextFlow copiaseguridad = new TextFlow();
    
    /**
     * Al presionar el boton de "Visualizar punto de control", dentro de la pizarra apareceran
     * una serie de "*", los cuales mostraran el inicio y el final de cada palabra.
     * @param event al hacer click en el boton dentro de la interfaz
     */
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
            textoIngresado.setRotate(rota);
            puntocontrol=true;
            
            lista.clear();
            textos.clear();    
        }else{
            visualPunto.setStyle("-fx-background-color: rgb(0,68,114);");
            aux.setFont(Font.font("Segoe Script", 30));
            Text aux2= new Text();
            for (int i = 0; i < textoIngresado.getChildren().size(); i++) {
                aux2 = (Text) textoIngresado.getChildren().get(i);
                if (aux2.getFill().equals(Color.web("#EA4335"))) {
                    textoIngresado.getChildren().remove(aux2);
                }
            }
            
            lista.clear();
            textos.clear();
            operaciones.cargarDatos(lista, ListaPalabras, textoIngresado,textos,IndexPalabra);
            puntocontrol=false;
        }    
    }
       
//    // borrar
//    @FXML
//    private void desactivarTrasladar(MouseEvent event) {
//        mover=false;
//        trasladar.setStyle("-fx-background-color: rgb(0,68,114);");
//       
////         System.out.println(textoIngresado.getLayoutX()+" "+textoIngresado.getLayoutY());
//        
//    }
//    //
//    @FXML
//    private void activarTrasladar(MouseEvent event) 
//    {
//        mover=true;
//        trasladar.setStyle("-fx-background-color: #08b2c9;");
//        textoIngresado.setOnMousePressed((event2) -> {
//             mover=false;
//             trasladar.setStyle("-fx-background-color: rgb(0,68,114);");
//        });
//    }

    TextFlow auxiliar;

    @FXML
    private void leertexto(KeyEvent event) {     
        operaciones.Leertexto(textoIngresado, texto, textos, ListaPalabras, lista, IndexPalabra);
    }
    
    Text PalabraSeleccioanda;  
    Boolean SubrayadoB=false;
    
    /**
     * al presionar la capsula de Subrayado, esta cambiara de color haciendo mas visual
     * el que este activada esta caracteristica para la palabra, y en caso de volver a 
     * presionarla devolvera la palabra a su estado anterior, y la capsula tambien regresara
     * al anterior estado.
     * @param event al hacer click en el boton dentro de la interfaz
     */
    @FXML
    private void SubrayadoPresionado(MouseEvent event) {
        if (IndexPalabra<textoIngresado.getChildren().size()) {
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
       
    }
    Boolean NegritaB =false;
    
    /**
     * al presionar la capsula de negrita, esta cambiara de color haciendo mas visual
     * el que este activada esta caracteristica para la palabra, y en caso de volver a 
     * presionarla devolvera la palabra a su estado anterior, y la capsula tambien regresara
     * al anterior estado.
     * @param event al hacer click en el boton dentro de la interfaz
     */
    @FXML
    private void NegritaPresionado(MouseEvent event) {
        if (IndexPalabra<textoIngresado.getChildren().size()) {
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
    }

    /**
     * al presionar la capsula de cursiva, esta cambiara de color haciendo mas visual
     * el que este activada esta caracteristica para la palabra, y en caso de volver a 
     * presionarla devolvera la palabra a su estado anterior, y la capsula tambien regresara
     * al anterior estado.
     * @param event al hacer click en el boton dentro de la interfaz
     */
    @FXML
    private void CursivaPresionado(MouseEvent event) {
        if (IndexPalabra<textoIngresado.getChildren().size()) {
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

    /**
     * Al ingresar una letra dentro del TextField de la interfaz, se recogeran las letras y los 
     * caracteres ingresados y se mostraran dentro de la pizarra del programa.
     * @param event 
     */
    @FXML
    private void LeerPalabra(MouseEvent event) {        
        if (textos.size()!=0) {
            if (ListaPalabras.getSelectionModel().getSelectedItem()!=null) {
                String[] indice = ListaPalabras.getSelectionModel().getSelectedItem().split("-");
                IndexPalabra = Integer.parseInt(indice[0]);
                aumentar.setVisible(true);
                disminuir.setVisible(true);
                tamanio.setVisible(true);
                Text aux = (Text) textoIngresado.getChildren().get(IndexPalabra);
                PalabraSeleccioanda = aux;
                tamanio.setText(""+aux.getFont().getSize());
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
    }

    /**
     * al hacer presionar el boton son el simbolo, este se ingresara dentro del TextField 
     * en la pocision en que se encuentre el cursor de escritura, mostrandose graficamente
     * que ya esta ingresado el caracter especial seleccionado.
     * @param event al hacer click en el boton dentro de la interfaz
     */
    @FXML
    private void dobleizquierda(MouseEvent event) {
        operaciones.agregarSimbolo("\"", texto,textoIngresado);
        operaciones.Leertexto(textoIngresado, texto, textos, ListaPalabras, lista, IndexPalabra);
        textos.clear();
        ListaPalabras.getItems().clear();
        operaciones.cargarDatos(lista, ListaPalabras, textoIngresado,textos,IndexPalabra);  
    }

    /**
     * al hacer presionar el boton son el simbolo, este se ingresara dentro del TextField 
     * en la pocision en que se encuentre el cursor de escritura, mostrandose graficamente
     * que ya esta ingresado el caracter especial seleccionado.
     * @param event al hacer click en el boton dentro de la interfaz
     */
    @FXML
    private void doblederecha(MouseEvent event) {
         operaciones.agregarSimbolo("\"", texto,textoIngresado);
        operaciones.Leertexto(textoIngresado, texto, textos, ListaPalabras, lista, IndexPalabra);
        textos.clear();
        ListaPalabras.getItems().clear();
        operaciones.cargarDatos(lista, ListaPalabras, textoIngresado,textos,IndexPalabra);       
    }

    /**
     * al hacer presionar el boton son el simbolo, este se ingresara dentro del TextField 
     * en la pocision en que se encuentre el cursor de escritura, mostrandose graficamente
     * que ya esta ingresado el caracter especial seleccionado.
     * @param event al hacer click en el boton dentro de la interfaz
     */
    @FXML
    private void simpleizquierda(MouseEvent event) {
        operaciones.agregarSimbolo("'", texto,textoIngresado);
        operaciones.Leertexto(textoIngresado, texto, textos, ListaPalabras, lista, IndexPalabra);
        textos.clear();
        ListaPalabras.getItems().clear();
        operaciones.cargarDatos(lista, ListaPalabras, textoIngresado,textos,IndexPalabra);   
    }

    /**
     * al hacer presionar el boton son el simbolo, este se ingresara dentro del TextField 
     * en la pocision en que se encuentre el cursor de escritura, mostrandose graficamente
     * que ya esta ingresado el caracter especial seleccionado.
     * @param event al hacer click en el boton dentro de la interfaz
     */
    @FXML
    private void simplederecha(MouseEvent event) {
        operaciones.agregarSimbolo("'", texto,textoIngresado);
       operaciones.Leertexto(textoIngresado, texto, textos, ListaPalabras, lista, IndexPalabra);
        textos.clear();
        ListaPalabras.getItems().clear();
        operaciones.cargarDatos(lista, ListaPalabras, textoIngresado,textos,IndexPalabra);
    }

    /**
     * al hacer presionar el boton son el simbolo, este se ingresara dentro del TextField 
     * en la pocision en que se encuentre el cursor de escritura, mostrandose graficamente
     * que ya esta ingresado el caracter especial seleccionado.
     * @param event al hacer click en el boton dentro de la interfaz
     */
    @FXML
    private void trespuntos(MouseEvent event) {
        operaciones.agregarSimbolo("...", texto,textoIngresado);
       operaciones.Leertexto(textoIngresado, texto, textos, ListaPalabras, lista, IndexPalabra);
        textos.clear();
        ListaPalabras.getItems().clear();
        operaciones.cargarDatos(lista, ListaPalabras, textoIngresado,textos,IndexPalabra);       
    }

    /**
     * al hacer presionar el boton son el simbolo, este se ingresara dentro del TextField 
     * en la pocision en que se encuentre el cursor de escritura, mostrandose graficamente
     * que ya esta ingresado el caracter especial seleccionado.
     * @param event al hacer click en el boton dentro de la interfaz
     */
    @FXML
    private void mayoresizquierda(MouseEvent event) {
        operaciones.agregarSimbolo("<<", texto,textoIngresado);
        operaciones.Leertexto(textoIngresado, texto, textos, ListaPalabras, lista, IndexPalabra);
        textos.clear();
        ListaPalabras.getItems().clear();
        operaciones.cargarDatos(lista, ListaPalabras, textoIngresado,textos,IndexPalabra);       
    }

    /**
     * al hacer presionar el boton son el simbolo, este se ingresara dentro del TextField 
     * en la pocision en que se encuentre el cursor de escritura, mostrandose graficamente
     * que ya esta ingresado el caracter especial seleccionado.
     * @param event al hacer click en el boton dentro de la interfaz
     */
    @FXML
    private void mayoresderecha(MouseEvent event) {
          
        operaciones.agregarSimbolo(">>", texto,textoIngresado);
        operaciones.Leertexto(textoIngresado, texto, textos, ListaPalabras, lista, IndexPalabra);
        textos.clear();
        ListaPalabras.getItems().clear();
        operaciones.cargarDatos(lista, ListaPalabras, textoIngresado,textos,IndexPalabra);      
    }

    /**
     * al presionar la capsula para aumentar tamaño, esta ahara que la palabra seleccionada
     * aumente su tamaño en una cantidad predeterminada, y dentro de la interfaz se mostrara
     * este dicho aumento.
     * @param event al hacer click en el boton dentro de la interfaz
     */
    @FXML
    private void aumentarTamanio(MouseEvent event) {
        if (textos.size()!=0) {
            
            if (ListaPalabras.getSelectionModel().getSelectedItem()!=null) {
                System.out.println("ss");
                String[] indice = ListaPalabras.getSelectionModel().getSelectedItem().split("-");
                IndexPalabra = Integer.parseInt(indice[0]);
                aumentar.setVisible(true);
                disminuir.setVisible(true);
                tamanio.setVisible(true);
                Text aux = (Text) textoIngresado.getChildren().get(IndexPalabra);
                if (!aux.getFont().getFamily().equals("Segoe Script")) {
                    Font fuente = Font.font(aux.getFont().getFamily(),aux.getFont().getSize()+2);
                    tamanio.setText(""+aux.getFont().getSize());
                    aux.setFont(fuente);
                }else{
                    if (aux.getFont().getStyle().equals("Bold")) {
                        Font fuente = Font.font(aux.getFont().getFamily(),FontWeight.BOLD,aux.getFont().getSize()+2);
                        tamanio.setText(""+aux.getFont().getSize());
                        aux.setFont(fuente);
                    }else{
                         Font fuente = Font.font(aux.getFont().getFamily(),aux.getFont().getSize()+2);
                        tamanio.setText(""+aux.getFont().getSize());
                        aux.setFont(fuente);
                    }
                }
            }
        }        
    }

    /**
     * al presionar la capsula para disminuir tamaño, esta ahara que la palabra seleccionada
     * disminuya su tamaño en una cantidad predeterminada, y dentro de la interfaz se mostrara
     * este dicha resta.
     * @param event al hacer click en el boton dentro de la interfaz
     */
    @FXML
    private void disminuirTamanio(MouseEvent event) {
        if (textos.size()!=0) {
            
            if (ListaPalabras.getSelectionModel().getSelectedItem()!=null) {
                System.out.println("ss");
                String[] indice = ListaPalabras.getSelectionModel().getSelectedItem().split("-");
                IndexPalabra = Integer.parseInt(indice[0]);
                aumentar.setVisible(true);
                disminuir.setVisible(true);
                tamanio.setVisible(true);
                Text aux = (Text) textoIngresado.getChildren().get(IndexPalabra);
                if (!aux.getFont().getFamily().equals("Segoe Script")) {
                    Font fuente = Font.font(aux.getFont().getFamily(),aux.getFont().getSize()-2);
                    tamanio.setText(""+aux.getFont().getSize());
                    aux.setFont(fuente);
                }else{
                    if (aux.getFont().getStyle().equals("Bold")) {
                        Font fuente = Font.font(aux.getFont().getFamily(),FontWeight.BOLD,aux.getFont().getSize()-2);
                        tamanio.setText(""+aux.getFont().getSize());
                        aux.setFont(fuente);
                    }else{
                         Font fuente = Font.font(aux.getFont().getFamily(),aux.getFont().getSize()-2);
                        tamanio.setText(""+aux.getFont().getSize());
                        aux.setFont(fuente);
                    }
                } 
            }
        }
    }

    /**
     * al presionar el boton "X", este cerrara por completo el programa, terminando asi su ejecucion
     * @param event al hacer click en el boton dentro de la interfaz
     */
    @FXML
    private void salir(ActionEvent event) {
        System.exit(0);
    }
}
