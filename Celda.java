/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapa;
import Continentes.Pais;
import Jugadores.Jugador;
/**
 *
 * @author Santiago Golpe
 */
public class Celda {
    private String tipo;
    private Pais pais;
    private Jugador jugador;
    private String Celda;
    
    public Celda(){
        this.tipo="Oceano";
        this.pais=null;
        this.jugador=null;
    }
    
    public Celda(String x){
        this.tipo="Frontera Oceanica 1";
        this.pais=null;
        this.jugador=null;
        this.Celda=x;
    }
    
    public Celda(Pais p){
        this.tipo="Pais";
        this.pais=p;
        this.jugador=p.getJugador();
    }
    
    
    public void settipoCelda(String Tipo){
        this.tipo=Tipo;
    }
     public void setpaisCelda(Pais P){
        this.pais=P;
    }
      public void setjugadorCelda(Jugador j){
        this.jugador=j;
    }
      
      public String getTipoCelda(){
          return this.tipo;
      }
       public Pais getPaisCelda(){
          return this.pais;
      }
        public Jugador getjugadorCelda(){
          return this.jugador;
      }
        public String getCeldaCelda(){
          return this.Celda;
      }
        //Imrimir celdas
         public void imprimeCelda(){
            String aux=String.format("|                 "+"%-9s"+"          |\n", pais.getNombrePais());
            System.out.println("-------------------------------------\n");
            System.out.println("|                                   |\n");
            System.out.println(aux);
            System.out.println("|                                   |\n");
            System.out.println("-------------------------------------\n");
        }
        public void imprimeCeldafrontO(){
            String aux=String.format("%s", Celda);
            System.out.println("-------------------------------------\n");
            System.out.println("|                                   |\n");
            System.out.println(aux);
            System.out.println("|                                   |\n");
            System.out.println("-------------------------------------\n");
        }
        public void imprimeCeldaOc(){
            System.out.println("-------------------------------------\n");
            System.out.println("|                                   |\n");
            System.out.println("|                                   |\n");
            System.out.println("|                                   |\n");
            System.out.println("-------------------------------------\n");
        }
        //Creacion de celdas
        
}

