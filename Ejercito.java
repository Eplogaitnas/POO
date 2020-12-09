/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risk;

import Jugadores.Jugador;

/**
 *
 * @author Santiago Golpe
 */
public class Ejercito {
    private Jugador jugador;
    private int numero;
    private String Color;
    private String clase;
    
    public Ejercito(Jugador J){
        this.jugador=J;
        //this.Color=J.getColor();
        this.numero=0;
    }
    
    public Jugador getJugador(){
        return this.jugador;
    }
    
    public int getnumero(){
        return this.numero;
    }
    
    public void setnumero(int i){
        this.numero=i;
    }
    
    public void setjugador( Jugador J){
        this.jugador=J;
    }
    
}
