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
        Calculadora calculadora1 = new Calculadora();
        Scanner read = new Scanner(System.in);
        int opc = 0, opc2 = 0;
        double num;
        do{
        System.out.println("<--------MENU CALCULADORA-------->");
        System.out.println("Elige las opciones que quieres realizar por favor");
        System.out.println("1.- Suma");
        System.out.println("2.- Resta");
        System.out.println("3.- Multiplicacion");
        System.out.println("4.- Division");
        System.out.println("Escribe el numero o accion que deseas ejecutar: ");
        switch(opc){
            case 1 : 
            {
                System.out.println("Ingrese el dato a sumar: ");
                num = read.nextDouble();
                calculadora1.suma(num);
                break;
            }
            case 2: 
            {
                System.out.println("Ingrese el dato a restar: ");
                num = read.nextDouble();
                calculadora1.resta(num);
                break;
            }
            case 3: 
            {
                 System.out.println("Ingrese el dato a multiplicar");
                 num = read.nextDouble();
                 calculadora1.multiplicacion(num);
                 break;
            }
            case 4: 
            {
                System.out.println("Ingrese el dato a dividir: ");
                num = read.nextDouble();
                calculadora1.division(num);
                break;
                
            }
        }
        System.out.println("Deseas seguir ingresando numeros?: [0-->No|1-->Si]");
        }while(opc2 != 0);
    }
    
}
