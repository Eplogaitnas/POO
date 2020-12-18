/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private String abrev;
    private String Nombre;
    private String color;
    private Jugador jugador;
    private Ejercito Ejercito;
    private Continente Continente;
    private final ArrayList<Point> Fronteras;
    private int vecesocupado;
    
   public Pais(String nombre,String abrev, Continente continente,ArrayList<Point> L ){
      this.abrev=abrev;
      this.Nombre=nombre;
      this.Continente=continente;
      this.color=continente.getColorcontinente();
      this.Fronteras=L;
      //this.Ejercito=new Ejercito(this.nombre_j);
   }
    public Continente getContinente(){
       return this.Continente; 
    }
    public String getNombrePais(){
        return this.abrev;
    }
    public String getNombrelargoPais(){
        return this.Nombre;
    }
    public void setJugador(Jugador jugador){
        this.jugador=jugador;
        this.Ejercito=new Ejercito(this.jugador);
    }
    public Jugador getJugador(){
        return this.jugador;
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
   public int getvecesocupado(){
       return this.vecesocupado;
    } 		
}
