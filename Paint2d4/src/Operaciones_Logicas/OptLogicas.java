/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones_Logicas;

import java.util.ArrayList;
import javafx.scene.transform.Translate;

/**
 *
 * @author Nicolas
 */
public class OptLogicas {
     public ArrayList<String> palabras = new ArrayList<>();
     public String texto ="";
     
     public void separarTexto(String text){
        palabras.clear();
        texto = text;
        System.out.println(texto);
        String palabra ="";
        
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i)!=' ') {
                palabra+=text.charAt(i);
            }
            else {
                palabras.add(palabra);
                palabra = "";
            }
            if (i == text.length()-1) {
                palabras.add(palabra);
            }
        }
    }
    public void imprimir(){
        for (int i = 0; i < palabras.size(); i++) {
            System.out.println(palabras.get(i));
        }
    }
    
    public void invertirTexto(String text){
        String invertida ="";
        for (int i = text.length()-1; i >= 0; i--) {
            invertida+=text.charAt(i);
        }
        separarTexto(invertida);
    }
    
    public String rotar(String valor,int rotacion){
        int val =Integer.parseInt(valor);
        val+=rotacion;
         if (val<0) {
             val+=360;
         }
        valor =Integer.toString(val);
        return valor;
    }
    
    public void trasladarTexto(String text){
        Translate trasladar = new Translate();
        trasladar.setX(100);
        trasladar.setY(100);
        palabras.clear();
        
    }
    
    public void agregarPuntosControl(){
        palabras.clear();
        String text = "";
         for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i)==' ') {
                
            }
        }     
    }
}
