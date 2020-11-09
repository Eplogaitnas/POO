/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Continentes;
import java.awt.Color;
import java.util.ArrayList;
import Ejercitos.Ejercito;
import Jugadores.Jugador;
/**
 *
 * @author Santiago Golpe
 */
public class Pais {
    private String Nombre;
    private Color color;
    public Jugador nombre_j;
    private Ejercito Ejercito;
    private Continente Continente;
    private ArrayList<Pais> Fronteras;
    
    public Pais(String nombre, Continente continente){
      this.Nombre=nombre;
      this.Continente=continente;
      this.color=continente.getColorcontinente();
    }
    public String getNombrePais(){
        return this.Nombre;
    }
    public Jugador getJugador(){
        return this.nombre_j;
    }
    public Color getColor(){
        return this.color;
    }
    //Creacion de paises
   
}
