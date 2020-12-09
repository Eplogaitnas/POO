/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Continentes;
import java.awt.Color;
import java.util.ArrayList;
import Jugadores.Jugador;
import java.util.Iterator;

/**
 *
 * @author Santiago Golpe
 */
public class Continente {
    private Jugador jugador;
    private String nombre;
    private String color;
    private ArrayList<Pais> Paises;
    private int Total_ejercitos;
    
  
    public Continente(String nombre, String color){
        this.nombre=nombre;
        this.color=color;
        this.jugador=null;
    }
    
    public String getColorcontinente(){
        return color;
    }
    public String getnombre(){
        return this.nombre;
    }
    
    public void setEjercitos(int total){
        this.Total_ejercitos=total;
    }
   
    public void setJugador(ArrayList<Pais> Paises){
        Iterator itr = this.Paises.iterator();
        int j=0;
        for (int i=1;i<=Paises.size();i++) {
            Pais Pais1=Paises.get(i-1);
            Pais Pais2=Paises.get(i);
            if(Pais1.getNombrePais().equals(Pais2.getNombrePais())){
                j++;
            }
        }
        if(j==Paises.size()-1){
            this.jugador=Paises.get(0).getJugador();
        }
    }
    
}
