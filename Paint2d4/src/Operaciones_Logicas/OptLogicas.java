/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones_Logicas;

import com.sun.javafx.css.converters.FontConverter;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 *
 * @author Nicolas
 */
public class OptLogicas {
     public ArrayList<String> palabras = new ArrayList<>();
     public ArrayList<String> list = new ArrayList<>();
     
     public String texto2 ="";
     
     public TextFlow separarTexto(String text,TextFlow aux2,ArrayList<Text> textos){
         TextFlow aux= new TextFlow();
         aux.setLayoutY(aux2.getLayoutX());
         aux.setLayoutX(aux2.getLayoutY());
         aux.setRotate(aux2.getRotate());
         String[] texto = text.split(" ");
         for (int i = 0; i < textos.size(); i++) {
             Text text2 = new Text("*");
             text2.setFill(Color.web("#EA4335"));
             text2.setFont(textos.get(i).getFont());
             Text text3= new Text(textos.get(i).getText());
             String NombreFont = textos.get(i).getFont().getFamily();
             Double sizeFont = textos.get(i).getFont().getSize();
             String FontWeight = textos.get(i).getFont().getStyle();
             
            
             text3.setFont(textos.get(i).getFont());
             Text text4= new Text("* ");
             text4.setFill(Color.web("#EA4335"));
             text4.setFont(textos.get(i).getFont());
             aux.getChildren().add(text2);
             aux.getChildren().add(text3);
             aux.getChildren().add(text4);             
         }
         

         return aux;
        

    }
    public void imprimir(){
        for (int i = 0; i < palabras.size(); i++) {
            System.out.println(palabras.get(i));
        }
    }
    
    public void invertirTexto(String text){
        
    }
    
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
    public void cargarDatos(ObservableList lista,ChoiceBox<String> Menupalabras,TextFlow texto,ArrayList<Text> textos){
        Text aux = new Text();
        for (int i = 0; i < texto.getChildren().size(); i++) {
            aux= (Text) texto.getChildren().get(i);
            textos.add(aux);
            lista.add(aux.getText());  
            
        }
        
        Menupalabras.getItems().addAll(lista);
        
    }
    public void detectarDatos(Text palabra,ArrayList<Text> textos){
        
        
        
    }
    
}
