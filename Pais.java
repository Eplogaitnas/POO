//Angel
package risk;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author angel
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Santiago Golpe
 */
public class Pais {
    private String Nombre;
    private String color;
    public Jugador nombre_j;
    private Ejercito Ejercito;
    private Continente Continente;
    private ArrayList<Point> Fronteras;
    private int vecesocupado;
    
   public Pais(String nombre, Continente continente,ArrayList<Point> L ){
      this.Nombre=nombre;
      this.Continente=continente;
      this.color=continente.getColorcontinente();
      this.Fronteras=L;
      this.Ejercito=new Ejercito(this.nombre_j);
   }
    public Continente getContinente(){
       return this.Continente; 
    }
    public String getNombrePais(){
        return this.Nombre;
    }
    public Jugador getJugador(){
        return this.nombre_j;
    }
    public String getColor(){
        return this.color;
    }
    public ArrayList<Point> getFronteras(){
        return this.Fronteras;
    }
    public Ejercito getEjercito(){
        return this.Ejercito;
    }
    public void describir_pais(){
         System.out.println("nombre: "+nombre_j.getNombreJugador()+"abreviatura: "+this.Nombre+", continente: "+this.Continente.getnombre()+", frontera: ");
        this.Fronteras.forEach((k) -> System.out.println(k+" "));
        System.out.println("], jugador: "+ this.nombre_j.getNombreJugador()+", numeroEjercitos"+ this.Ejercito.getnumero()+", numeroVecesOcupado"+ this.vecesocupado);
    }   		
}
