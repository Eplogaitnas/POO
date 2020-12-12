/*
 * To change this license header, choose License Headers in Project Properties.l
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risk;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author angel
 */
public class Continente {
    private Jugador jugador;
    private String nombre;
    private String abrev;
    private String color;
    private ArrayList <Jugador> jugadores;
    private int Total_ejercitos;
    private int rearme;
    private ArrayList<Pais> Paises;
    //private String claveCon;
    public Continente(String nombre,String color){
        this.nombre = nombre;
        switch(nombre){
            case "Oceania": this.rearme= 2;
            case "Europa": this.rearme= 5;
            case "Africa": this.rearme= 3;
            case "Asia": this.rearme= 7;
            case "America del Norte": this.rearme= 5;
            case "America del Sur": this.rearme= 2;
        }
        this.color=color;
        this.jugador=null;
        //Paises = listapaises;
        System.out.println("Continente creado:" + nombre);
    }
    public String getnombre(){
        return nombre;
    }
    public void setEjercitos(int total){
        this.Total_ejercitos=total;
    }
    public String getColorcontinente(){
        return color;
    }
    public int getNumeroEjercitos(){
        return Total_ejercitos;
    }
    public ArrayList<Pais> getListaPaises(){
        return Paises;
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
    public void setPais(Pais pais){
        Paises.add(pais);
    }
   // public void setJugador(Jugador jugador){
     //   this.jugador=jugador;
    //}
    public void set_ocupante(Jugador ocupante){
        this.jugadores.add(ocupante);
    }
    public void describir_continente(){
        System.out.println("nombre: "+this.nombre+"jugadores: [");
        this.jugadores.forEach((k) -> System.out.println(k.getNombreJugador()+" "));
        System.out.println("], numeroEjercitos"+ this.Total_ejercitos+", numeroVecesOcupado"+ this.rearme);
    }
}
