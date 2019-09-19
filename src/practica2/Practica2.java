/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import clases.Gato;
import java.util.Scanner;
import clases.Calculadora;

/**
 *
 * @author chiky
 */
public class Practica2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//Para la clase del juego del gato

        Gato juego = new Gato();
        juego.jugarGato();
//Para la clase de la calculadora
        Scanner read = new Scanner(System.in);
        int opc = 0;
        double res = 0, num=0;
        System.out.println("<--------MENU CALCULADORA-------->");
        System.out.println("Elige las opciones que quieres realizar por favor");
        System.out.println("1.- Suma");
        System.out.println("2.- Resta");
        System.out.println("3.- Multiplicacion");
        System.out.println("4.- Division");
        System.out.println("Escribe el numero: ");
        num = read.nextInt();
        Calculadora cal = new Calculadora();
        switch(opc){
            case 1 : 
            {
                res = cal.suma(num);
                System.out.println("El resultado es: "+res);
            }
            case 2: 
            {
                res = cal.resta(num);
                System.out.println("El resultado es: "+res);
            }
            case 3: 
            {
                 res = cal.multiplicacion(num);
                 System.out.println("El resultado es: "+res);
            }
            case 4: 
            {
                res = cal.multiplicacion(num);
                System.out.println("El resultado es: "+res);                
            }
        }
    }
    
}
