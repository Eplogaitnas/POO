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
import java.util.Iterator;

/**
 *
 * @author Santiago Golpe
 */
public class Continente {
    private Jugador jugador;
    private String nombre;
    public Color color;
    private ArrayList<Pais> Paises;
    private Ejercito Total_ejercitos;
    
  
    public Continente(String nombre, Color color){
        this.nombre=nombre;
        this.color=color;
        this.jugador=null;
    }
    
    public Color getColorcontinente(){
        return color;
    }
    
    public void setEjercitos(Ejercito total){
        this.Total_ejercitos=total;
    }
   
    public void setJugador(ArrayList<Pais> Paises){
        Iterator itr = this.Paises.iterator();
        int j=0;
        for (int i=1;i<=Paises.size();i++) {
            Pais Pais1=Paises.get(i-1);
            Pais Pais2=Paises.get(i);
            if(Pais1.nombre_j==Pais2.nombre_j){
                j++;
            }
        }
        if(j==Paises.size()-1){
            this.jugador=Paises.get(0).nombre_j;
        }
    }
    
}
