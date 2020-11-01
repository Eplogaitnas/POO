/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercitos;
import Jugadores.Jugador;
import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author Santiago Golpe
 */
public class Ejercito {
    private int numero;
    private Color color;
    private Jugador nombre;
    private Point posicion;
    
    public Ejercito (int numero, Jugador nombre, Point posicion){
        this.numero=numero;
        this.nombre=nombre;
        this.posicion=posicion;
        this.color=nombre.Color;
    }
    
    
    
}
    
    
