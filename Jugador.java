/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jugadores;
import Ejercitos.Ejercito;
import Continentes.Pais;
import java.awt.Color;
import Continentes.Continente;
import java.util.ArrayList;

/**
 *
 * @author Santiago Golpe
 */
public class Jugador {
    private String Nombre;
    public Color Color;
    private Ejercito Total;
    private Pais Paises;
    private ArrayList<Continente> Continentes;
    public Mision mision;
    
    public Jugador(String Nombre,Color Color){
        this.Nombre=Nombre;
        this.Color=Color;
        this.Total=null;
        this.Continentes=null;
        this.Paises=null;
        this.mision=null;
    }
    
    public Color getColor(Jugador nombre){
        return nombre.Color;
    }
}
