/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapa;
import java.awt.Point;
import java.util.HashMap;
import java.awt.Color;
import Continentes.Continente;
import Continentes.Pais;
import java.util.ArrayList;
/**
 *
 * @author Santiago Golpe
 */
public class Mapa {
    private HashMap<Point, Celda> mapa;
    private final Point tamaño;;
    
    
    public HashMap<Point, Celda> getMapa() {
        return mapa;
    }
    
    public Mapa(int x, int y) {

        this.tamaño = new Point(x, y);
        this.mapa = new HashMap<>();
        for (int i = 0; i < tamaño.x; i++) {
            for (int j = 0; j < tamaño.y; j++) {
                Celda celda = new Celda();
                this.insertaCelda(i, j, celda);
            }
        }
    }
    public void insertaCelda(int x, int y, Celda celda) {

        Point punto = new Point(x, y);
        mapa.put(punto, celda);

    }
    public void creaCeldaPais(Pais p, int x, int y){
        Celda c=new Celda(p);
        this.insertaCelda(x,y,c);
    }
    public void CreaPaises(String Nombre,Continente cont,int x, int y){
        Pais Pais=new Pais(Nombre,cont);
        creaCeldaPais(Pais,x,y);
    }
   public void AsignaFrontO(String Fr,int x, int y){
       Celda c=new Celda(Fr);
       this.insertaCelda(x,y,c);
   }
   
    public void CreageoMapa(){
        Continente NA=new Continente("America del Norte",Color.magenta);
        Continente SA=new Continente("America del Sur",Color.red);
        Continente EU=new Continente("Europa",Color.yellow);
        Continente AF=new Continente("África",Color.green);
        Continente AS=new Continente("Asia",Color.cyan);
        Continente OC=new Continente("Oceania",Color.blue);
        CreaPaises("Alaska",NA,0,0);
        CreaPaises("Alberta",NA,0,1);
        CreaPaises("USAOeste",NA,0,2);
        CreaPaises("TNoroeste",NA,1,0);
        CreaPaises("Ontario",NA,1,1);
        CreaPaises("Groen",NA,2,0);
        CreaPaises("Quebec",NA,2,1);
        CreaPaises("USAEste",NA,1,2);
        CreaPaises("Amecentra",NA,1,3);
        CreaPaises("Argentina",SA,1,6);
        CreaPaises("Perú",SA,1,5);
        CreaPaises("Venezuela",SA,1,4);
        CreaPaises("Brasil",SA,2,5);
        CreaPaises("Islandia",EU,4,0);
        CreaPaises("Escandina",EU,5,0);
        CreaPaises("GBretaña",EU,5,1);
        CreaPaises("EurNorte",EU,6,1);
        CreaPaises("EurOcc",EU,5,2);
        CreaPaises("EurSur",EU,6,2);
        CreaPaises("Rusia",EU,7,1);
        CreaPaises("ANorte",AF,5,4);
        CreaPaises("Egipto",AF,6,4);
        CreaPaises("Congo",AF,5,5);
        CreaPaises("AOriental",AF,6,5);
        CreaPaises("Sudafrica",AF,6,6);
        CreaPaises("Madagascar",AF,7,6);
        CreaPaises("Siberia",AS,6,0);
        CreaPaises("Yakustsk",AS,7,0);
        CreaPaises("Kamtchatka",AS,8,0);
        CreaPaises("Irkutsk",AS,8,1);
        CreaPaises("Mongolia",AS,8,2);
        CreaPaises("Japon",AS,9,2);
        CreaPaises("China",AS,8,3);
        CreaPaises("Urales",AS,7,2);
        CreaPaises("Afgan",AS,7,3);
        CreaPaises("OMedio",AS,7,4);
        CreaPaises("India",AS,8,4);
        CreaPaises("SAsiático",AS,9,4);
        CreaPaises("Indonesia",OC,9,6);
        CreaPaises("NGuinea",OC,10,6);
        CreaPaises("AusOccid",OC,9,7);
        CreaPaises("AusOrient",OC,10,7);
    }
   
    public void CreaOceano(){
        Celda c=new Celda();
        insertaCelda(0,3,c);
        insertaCelda(0,4,c);
        insertaCelda(0,5,c);
        insertaCelda(0,6,c);
        insertaCelda(0,7,c);
        insertaCelda(1,7,c);
        insertaCelda(2,7,c);
        insertaCelda(2,6,c);
        insertaCelda(2,4,c);
        insertaCelda(2,3,c);
        insertaCelda(2,2,c);
        insertaCelda(3,7,c);
        insertaCelda(3,6,c);
        insertaCelda(3,4,c);
        insertaCelda(3,3,c);
        insertaCelda(3,2,c);
        insertaCelda(3,1,c);
        insertaCelda(4,7,c);
        insertaCelda(4,6,c);
        insertaCelda(4,5,c);
        insertaCelda(4,3,c);
        insertaCelda(4,2,c);
        insertaCelda(4,1,c);
        insertaCelda(5,7,c);
        insertaCelda(5,6,c);
        insertaCelda(6,7,c);
        insertaCelda(7,7,c);
        insertaCelda(7,5,c);
        insertaCelda(8,7,c);
        insertaCelda(8,6,c);
        insertaCelda(8,5,c);
        insertaCelda(9,3,c);
        insertaCelda(9,1,c);
        insertaCelda(10,5,c);
        insertaCelda(10,4,c);
        insertaCelda(10,3,c);
        insertaCelda(10,2,c);
        insertaCelda(10,1,c);
    }
    
    public void creaFrontO(){
        AsignaFrontO("-----------------------------------",3,0);
        AsignaFrontO("-----------------------------------",9,0);
        AsignaFrontO("-----------------------------------",10,0);
        AsignaFrontO("                                  |\n"
                + "                                  |"
                + "\n-----------------------------------",3,5);
        AsignaFrontO("-----------------------------------\n"
                + "|                                  \n"
                + "|                                  ",4,4);
        AsignaFrontO("                    |               \n"
                + "                    |               ",5,3);
        AsignaFrontO("                    |               \n"
                + "                    |               ",6,3);
        AsignaFrontO("                    |               \n"
                + "                    |               ",9,5);
        
    }
   
    
     
    
     public void imprimeMapa(){
        int i=0,j=0;
        Point a=new Point(i,j);
        Celda k;
        for (i = 0; i < 11; i++) {
            System.out.print("\n");
            for (j = 0; j < 8; j++) {
                k=mapa.get(a);
                if(mapa.get(a).getTipoCelda().equals("Oceano")){
                    k.imprimeCeldaOc();
                }
                if(mapa.get(a).getTipoCelda().equals("Frontera Oceanica 1")){
                    k.imprimeCeldafrontO();
                }
                if(mapa.get(a).getTipoCelda().equals("Pais")){
                    k.imprimeCelda();
                }
            }
        }
    }
}
