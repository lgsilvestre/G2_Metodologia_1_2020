/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones_Logicas;

import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 *
 * @author Nicolas
 */
public class OptLogicas {
     public ArrayList<String> palabras = new ArrayList<>();
     public ArrayList<String> list = new ArrayList<>();
     public String texto ="";
     public String texto2 ="";
     
     public TextFlow separarTexto(String text,TextFlow aux2){
         TextFlow aux= new TextFlow();
         aux.setLayoutY(aux2.getLayoutX());
         aux.setLayoutX(aux2.getLayoutY());
         aux.setRotate(aux2.getRotate());
         String[] texto = text.split(" ");
         
         for (int i = 0; i <texto.length; i++) {
             if (texto[i]!=" ") {
                 
                 Text text2= new Text("*");
                 text2.setFill(Color.web("#EA4335"));
                 
                 Text text3= new Text(texto[i]);
                 
                 Text text4= new Text("* ");
                 text4.setFill(Color.web("#EA4335"));
//                System.out.println(text2.getText()+""+text3.getText()+""+text4.getText());
                 aux.getChildren().add(text2);
                 aux.getChildren().add(text3);
                 aux.getChildren().add(text4);
             }
            
         }
         return aux;
        

    }
    public void imprimir(){
        for (int i = 0; i < palabras.size(); i++) {
            System.out.println(palabras.get(i));
        }
    }
    
//    public void invertirTexto(String text){
//        String invertida ="";
//        for (int i = text.length()-1; i >= 0; i--) {
//            invertida+=text.charAt(i);
//        }
//        separarTexto(invertida);
//    }
    
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
    
    
    public void agregarPuntosControl(){

    }
}
