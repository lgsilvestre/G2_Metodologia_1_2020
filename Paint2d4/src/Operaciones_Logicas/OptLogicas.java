/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones_Logicas;

import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * Aqui es donde se haran todas las operaciones que no tienen relacion con la interfaz
 * de manera directa.
 * @author Rodrigo
 * @author Nicolas M 
 * @author Pablo
 * @author Fernanda
 * @author Felipe
 * @author Nicolas R
 */
public class OptLogicas {
    public ArrayList<String> palabras = new ArrayList<>();
    public ArrayList<String> list = new ArrayList<>();

    public String texto2 ="";

    public void separarTexto(String text,TextFlow aux2,ArrayList<Text> textos,Pane Canvas){
        TextFlow aux= new TextFlow();

       Text auxpalabra = new Text();
        for (int i = 0; i < aux2.getChildren().size(); i++) {
            auxpalabra = (Text) aux2.getChildren().get(i);

            if (auxpalabra.getText()!=" ") {
               Text text2 = new Text("*");
               text2.setFill(Color.web("#EA4335")); 
               text2.setFont(auxpalabra.getFont());
               aux2.getChildren().add(i, text2);
               i++;
               Text text4 = new Text("*");
               text4.setFill(Color.web("#EA4335")); 
               text4.setFont(auxpalabra.getFont());
               aux2.getChildren().add(i+1, text4);
               i++;
            }
        }
    }
    
    public void imprimir(){
        for (int i = 0; i < palabras.size(); i++) {
            System.out.println(palabras.get(i));
        }
    }
    
    public void invertirTexto(TextFlow text,TextField texto){
        
        int total = text.getChildren().size();
        
        ArrayList<Text> listaText = new ArrayList();
        Text aux = new Text();
        
        for (int i = 0; i < total; i++) {
            aux = (Text) text.getChildren().get(i);
            Text aux2 = new Text();
            aux2.setText(aux.getText());
            aux2.setFont(aux.getFont());
            listaText.add(aux2);
        }
        String aux3="";
        text.getChildren().clear();
        for (int i = listaText.size()-1; i >=0 ; i--) {
            aux3= aux3 + listaText.get(i).getText();
            text.getChildren().add(listaText.get(i));
        }
        System.out.println(aux3);
        texto.clear();
        texto.setText(aux3);    
    }
    
    /**
     * al dentro de la interfaz presionar algun caracter especial, aqui en donde se
     * ingresara dentro de la frase, para luego ser mostrada
     * @param simbolo caracter a ingresar
     * @param texto el texto completo
     * @param text 
     */
    public void agregarSimbolo(String simbolo,TextField texto,TextFlow text){
        int indexseleccionado=texto.getSelection().getStart();
        Font fuente = Font.font("Segoe Script",30);
        String PalabraAux="";
        System.out.println(indexseleccionado+" "+texto.getText().length());
        System.out.println(simbolo.charAt(0));
        if (indexseleccionado!=texto.getText().length()) {
            for (int i = 0; i < texto.getText().length(); i++) {
                if (i==indexseleccionado) {
                    PalabraAux= PalabraAux+""+simbolo+texto.getText().charAt(i);                  
                }else{
                     PalabraAux= PalabraAux+""+texto.getText().charAt(i);
                }
            }
        }else{
            PalabraAux= texto.getText()+simbolo;
        }
        texto.clear();
        texto.setText(PalabraAux);
        texto.selectRange(indexseleccionado,indexseleccionado);
    }
    
    /**
     * esto mostrara en el redar del dragon de la interfaz, el angulo que tiene en 
     * ese instante la palabra.
     * @param valor el valor que esta en ese momento dentro del radar
     * @param rotacion lo que se agregara o disminuira
     * @return 
     */
    public String rotar(String valor,int rotacion){
        int val =Integer.parseInt(valor);
        val+=rotacion;
         if (val<0) {
             val+=360;
         }if (val>330) {
            val=0;
        }
        valor =Integer.toString(val);
        return valor;
    }

    /**
     * 
     * @param lista
     * @param ListaPalabras
     * @param texto
     * @param textos
     * @param indicePalabra 
     */
    public void cargarDatos(ObservableList lista,ListView<String> ListaPalabras,TextFlow texto,ArrayList<Text> textos,int indicePalabra){
        Text aux = new Text();
        
        for (int i = 0; i < texto.getChildren().size(); i++) {
            aux = (Text) texto.getChildren().get(i);
            final int count = i;
                
            if (aux.getText()!=" ") {
                ListaPalabras.getItems().add(i+"-"+aux.getText());  
            }
            textos.add(aux);
        }   
    }
    
    /**
     * 
     * @param textoIngresado
     * @param texto
     * @param textos
     * @param ListaPalabras
     * @param lista
     * @param IndexPalabra 
     */
    public void Leertexto(TextFlow textoIngresado,TextField texto,ArrayList<Text> textos,ListView<String> ListaPalabras,ObservableList lista,int IndexPalabra){
        textoIngresado.setMaxSize(950, 200);
        textoIngresado.setLayoutX(40);
        textoIngresado.setLayoutY(40);
        textoIngresado.getChildren().clear();
        String palabra="";
        String [] aux3 = texto.getText().split("");
        for (int i = 0; i < aux3.length; i++) {
            try{
                char caracter= aux3[i].charAt(0);
                if ( (caracter>='a' && caracter<='z') || (caracter>='A' && caracter<='Z') || caracter==' '  ||(caracter=='ñ' || caracter=='Ñ')) {
                   palabra= palabra+caracter;
                }if (caracter>=48 && caracter<=57) {
                    palabra= palabra+caracter;
                }
                if (caracter==34 || caracter==39 || caracter==46 || caracter==60 || caracter==62) {
                    palabra= palabra+caracter;
                }
            }catch(Exception e){
                
            }    
        }
        texto.setText(palabra);
        String [] aux = texto.getText().split(" ");
        texto.selectRange(texto.getText().length(),texto.getText().length());
        for (int i = 0; i < aux.length; i++) {
            if (aux[i]!=" ") {
                Text texto1 = new Text(aux[i]);
                Font fuente = Font.font("Segoe Script",30);
                texto1.setFont(fuente);
                Text texto2 = new Text(" ");
                texto2.setFont(fuente);
                 textoIngresado.getChildren().add(texto1);
            }else{
                Text texto1 = new Text(" ");
                Font fuente = Font.font("Segoe Script",30);
                texto1.setFont(fuente);
                textoIngresado.getChildren().add(texto1); 
            }
        } 
        Text aux1 = new Text();
        for (int j = 0; j < textoIngresado.getChildren().size(); j++) {
                aux1= (Text) textoIngresado.getChildren().get(j);
                if (aux1.getText()!=" ") {
                    Text texto2 = new Text(" ");
                    Font fuente = Font.font("Segoe Script",30);
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
        for (int i = 0; i <textos.size(); i++) {
            try {
                if (textoIngresado.getChildren().size()!=0) {
                aux2= (Text) textoIngresado.getChildren().get(i);
                boolean subrayado;
                if (textos.get(i).isUnderline()) {
                    aux2.setUnderline(true);
                }else{
                    aux2.setUnderline(false);
                }
                aux2.setFont(textos.get(i).getFont());
            }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }   
        }
        textos.clear();
        ListaPalabras.getItems().clear();
        cargarDatos(lista, ListaPalabras, textoIngresado,textos,IndexPalabra);   
    }
}
