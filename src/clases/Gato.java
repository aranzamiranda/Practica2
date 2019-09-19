/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author chiky
 */
public class Gato {
  public char [] [] tablero;
  public boolean turno;
  int cont;    
  public char jugador1;
  public char jugador2;
 
  public Gato() {
    tablero    = new char[3][3];        
    turno = true;  
    cont = 0;
    jugador1   = 'X';
    jugador2   = 'O';
    inicializarTablero();
  }
 
  //Se inicia el arreglo.
  public void inicializarTablero(){
    int posicion = 1;
    for(int i=0;i<3;i++){
      for(int j=0; j<3;j++){
        tablero[i][j] = Integer.toString(posicion).charAt(0); //Sirve para convertir
        posicion++;
      }        
    }
  }
 
  //Imprime el tablero
  public void mostrarTablero(){
         
    for(int i=0; i<3; i++){
      for(int j=0; j<3; j++){
        if(j < 2) {
          System.out.print(" " + tablero[i][j] + " |");
         } else {
          System.out.print(" " + tablero[i][j] + " ");
         }
      }
     
      if(i<2) {        
        System.out.println("\n-----------\n");                    
      }
    }
    System.out.println();
    System.out.println();
    System.out.println();
  }
 
  //Se va a indicar la posicion donde se agregan los datos.   
  public void indicarPosicion (int a, int b, char c){
      tablero [a][b]=c;
  } 
  public void setTurno(boolean turn){
      turno = turn;
  }  
  public void setCont(int conta){
      cont = conta;
  }
  
  public char getPosicion(int a, int b){
      return tablero[a][b];
  }
   
  public char getJugador1(){
      return jugador1;
  }      
  public char getJugador2(){
      return jugador2;
  }      

  public boolean getTurno(){
      return turno;
  }      
  public int getCont() {
      return cont;
  }      
 

  public void indiqueTurno(){
    System.out.println( "Jugador "+(getTurno()?"1":"2")+": Indique una casilla marcando el numero correspondiente porfavor");
  }
 
  public char obtenerFigura(){
    
    if(getTurno() == true){      
      return jugador1;      
    } 
    else{      
      return jugador2;  
    }
  }  
  public void cambiaTurno(){    
    setTurno(obtenerFigura() != 'X' );
  }
   
  //Checa si la posicion que puso el jugador no esta ocupada ya.  
  public void comprobarTablero(char t, int posicion1, int posicion2){
   
    //Si es que son diferentes entonces la inserta.  
    if(t != getJugador1() && t != getJugador2()){
       
       indicarPosicion(posicion1, posicion2, obtenerFigura());
       cambiaTurno();                            
       cont++;                                 
    } 
    else{           
       System.out.println("La casilla esta ocupada, elija otra.");          
    }
  }  
  public void posicion(int posicion){
               
      switch(posicion){
        case 1: 
        {
            comprobarTablero(getPosicion(0,0),0,0);
            break;
        }
        case 2:
        {
            comprobarTablero(getPosicion(0,1),0,1);
            break;
        }
        case 3:
        {
            comprobarTablero(getPosicion(0,2),0,2);
            break;
        }
        case 4:
        {
            comprobarTablero(getPosicion(1,0),1,0);
            break;
        }
        case 5:
        {
            comprobarTablero(getPosicion(1,1),1,1);
            break;
        }
        case 6:
        {
            comprobarTablero(getPosicion(1,2),1,2);
            break;
        }
        case 7:
        {
            comprobarTablero(getPosicion(2,0),2,0);
            break;
        }
        case 8:
        {
            comprobarTablero(getPosicion(2,1),2,1);
            break;
        }
        case 9:
        {
            comprobarTablero(getPosicion(2,2),2,2);
            break;
        }
        default:
        {
          System.out.println("Favor de ingresar un nuemero del 1 al 9");
          break;  
        }
      }    
  }
  public void buscarGanador(){
         
    //Ganar de forma horizontal
    for(int i=0;i<3;i++){
      for(int j=1;j<2;j++){
        if(tablero[i][j]==tablero[i][j-1]&&tablero[i][j]==tablero[i][j+1]){
           ganador(tablero[i][j]);
           mostrarTablero();
           setCont(10);
        }          
      }        
    }
   
    //Ganar de forma vertical 
    for(int i=0;i<3;i++){
      for(int j=1;j<2;j++){
        if(tablero[j][i]==tablero[j-1][i]&&tablero[j][i]==tablero[j+1][i]){
           ganador(tablero[j][i]);
           mostrarTablero();
           setCont(10);
        }            
      }
    }
   
    //Ganar forma diagonal  
    if(tablero[1][1]==tablero[0][0]&&tablero[1][1]==tablero[2][2]){
       ganador(tablero[1][1]);
       mostrarTablero();
       setCont(10);
    }  
       
    //Ganar de la forma diagonal inversa
    if(tablero[1][1]==tablero[0][2]&&tablero[1][1]==tablero[2][0]){
       ganador(tablero[1][1]);
       mostrarTablero();          
       setCont(10);
    }    
  }   
  public void ganador(char a){
   
    System.out.println("GAME OVER: ¡El"+(a == 'X' ? "1": "2" )+"!, ha sido el ganador!");
  }

   
  //Hace funcionar el juego.
  public void jugarGato(){
   //BufferedReader es una clase de Java para leer el texto de una secuencia de entrada (como un archivo)...
   //almacenando en el búfer caracteres que leen a la perfección caracteres, matrices o líneas.
    BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
   
    System.out.println("BIENVENIDO A EL JUEGO DEL GATO");    
     
    do{
      indiqueTurno();        
      mostrarTablero();    
      try{posicion(Integer.parseInt(entrada.readLine()));}
      catch(IOException e){}  
      catch(NumberFormatException e){

        System.out.println("Ingresaste un caracter que no es valido, favor de volver a insertar JUGADOR " + (getTurno()? "1": "2"));        
      }
         
      buscarGanador();
   
    } while(getCont()<9);
   
    if(getCont()==9){
      System.out.println("El juego ha sido empatado");              
      mostrarTablero();
      System.out.println("Gracias por jugar!");      
    }
  }
}
