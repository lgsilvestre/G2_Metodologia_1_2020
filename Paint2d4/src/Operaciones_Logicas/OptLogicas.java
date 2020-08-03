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
import javafx.scene.layout.Pane;
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


             }else{
//                Text text2 = new Text(" ");
//                
//                text2.setFont(auxpalabra.getFont());
//                aux.getChildren().add(text2);
             }
             
         }
//         aux.setLayoutY(aux2.getLayoutX());
//         aux.setLayoutX(aux2.getLayoutY());
//         aux.setRotate(aux2.getRotate());
//         Canvas.getChildren().clear();
//         Canvas.getChildren().add(aux);
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
            
                
            if (aux.getText()!=" ") {
                
                
                lista.add(i+"-"+aux.getText()); 
            }
            textos.add(aux);
             
            
        }
        
        Menupalabras.getItems().addAll(lista);
        
    }
    public void detectarDatos(Text palabra,ArrayList<Text> textos){
        
        
        
    }
    
}
