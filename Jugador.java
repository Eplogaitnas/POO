/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risk;
import risk.Carta.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Jugador {
    public String Color;
    private Ejercito Total;
    private Mision mision;
    private int Ejercitos;
    private String nombre;
    private HashMap<String,Pais> Paises;
    private HashMap<String, Continente> Continentes;
    private ArrayList<Carta> Cartas;
    public Jugador(String Nombre,String Color){
        this.nombre=Nombre;
        this.Color=Color;
        this.Total=null;
        this.mision=null;
        this.Ejercitos = Ejercitos;
        Paises= new HashMap<String, Pais>();
        Continentes= new HashMap<String, Continente>();
    }
    public String getColor(){
        return this.Color;
    }
    public void setJugador(String jugador){
        this.nombre = jugador;
    }
    public Mision getmision(){
       return this.mision; 
    }   
    public void setmision(Mision Mision){
        this.mision=Mision;
    }
    public ArrayList<Carta> getcartas(){
       return this.Cartas; 
    }   
    public void setcartas(Carta carta){
        this.Cartas.add(carta);
    }
    public void eliminarcarta(Carta carta){
        for (int i=0;i<Cartas.size();i++) {
            if(Cartas.get(i)==carta){
                 Cartas.remove(i);
           }
            //System.out.println(lista.get(i));
        }
    }
    public void crear_carta(String id){
        Carta c;
        String[] parts;
        parts=id.split("&");
        switch(parts[0]){
            case "Antiaerea":
                c= new Antiaerea(id);
                  break;
            case "DeCaballo":
                c= new DeCaballo(id);
                break;
            case "DeCamello":
                c=new DeCamello(id);
                break;
            case "DeCampanha":
                c=new DeCampanha(id);
                break;
            case "Fusilero":
                c=new Fusilero(id);
                break;
            case "Granadero":
                c=new Granadero(id);
                break;  
            default:
                System.out.println("fallo al crear carta");
                return;
        }
        this.Cartas.add(c);
    }
    public void cambiar_cartas(String id1, String id2, String id3){
          Carta c1=null;
          for(Carta k : this.Cartas){
              if(k.getid().equals(id1)){
                  c1=k;
              }
          }
          if(c1==null){return;}
           Carta c2=null;
           for(Carta k : this.Cartas){
              if(k.getid().equals(id1)){
                  c2=k;
              }
          }
           if(c2==null){return;}
            Carta c3=null;
            for(Carta k : this.Cartas){
              if(k.getid().equals(id1)){
                  c3=k;
              }
            }
            if(c3==null){return;}
          this.incrementarEjercitos(c1.getvalor()+c2.getvalor()+c3.getvalor());
          this.eliminarcarta(c1); this.eliminarcarta(c2); this.eliminarcarta(c3);
    }
    public void cambiar_cartas_todas(){
        System.out.println("\ncartasCambio: ");
        for (int i=0;i<(Cartas.size())-2;i=i+3) {
            this.incrementarEjercitos(Cartas.get(i).getvalor()+Cartas.get(i+1).getvalor()+Cartas.get(i+2).getvalor());
            Cartas.remove(i); Cartas.remove(i+1); Cartas.remove(i+2);
            System.out.println(Cartas.get(i).getid()+" "+Cartas.get(i+1).getid()+", "+Cartas.get(i+2).getid()+" ");
        }
        System.out.println("\ncartas quedan");
        for (int i=0;i<(Cartas.size());i++) {
            System.out.println(Cartas.get(i).getid()+" ");
        }
    }
    public String getNombreJugador() {
            return this.nombre;
    }
    public Ejercito getEjercitos() {
            return this.Total;
    } 
    public HashMap<String, Pais> getPaises(){
        return this.Paises;
    }
    public HashMap<String, Continente> getContinentes(){
        return this.Continentes;
    }
   //public Mision setMision(){
      //  this.mision;
    // }
    public void disminuirEjercitos(int numEjercitos) {
            if(Ejercitos - numEjercitos>=0){
                Ejercitos = Ejercitos - numEjercitos;
                System.out.println(nombre + "tiene" + Ejercitos + "Ejercitos restantes.");
            }
            else System.out.println("No se pueden eliminar tantas tropas");
    }
    public void incrementarEjercitos(int numEjercitos) {
        Ejercitos = Ejercitos + numEjercitos;
        System.out.println(nombre + "tiene" + Ejercitos + "Ejercitos restantes.");
    }
    public void añadirPais(Pais pais) {
	
        System.out.println(nombre + " ha ocupado " + pais.getNombrePais());
        Paises.put(pais.getNombrePais(), pais);
    }


    public void quitarPais(String NombrePais) {
		
		System.out.println(nombre + " ya no ocupa " + NombrePais);
		Paises.remove(NombrePais);
    }

    /**
     * When a player occupies all the countries on a continent the continent must be added to
     * a data structure that tracks which continents the player occupies
     **/
    public void añadirContinente (Continente Continente) {
        System.out.println(nombre + "ha ocupado todo" + Continente.getnombre() + ", consiguiendo" + /*Continente.getBonusArmies()+  */" tropas más por turno");
        Continentes.put(Continente.getnombre(),  Continente);
    }

    /**
     * Removes a contient from the data structure to reflect that the player no longer controls
     * the whole continent
     **/
    public void removeContinent(String continentName) {
        Continentes.remove(continentName);
    }
    public void jugador(){
        System.out.println("nombre: "+this.nombre+", color:"+this.Color+ ", mision: "+this.mision.getDescripcion()+", numeroEjercitos: "+this.Total.getnumero()+", Paises: [ ");
        this.Paises.forEach((k,v) -> System.out.println(k+" "));
        System.out.println("], continentes: [");
        this.Continentes.forEach((k,v) -> System.out.println(k+" "));
        System.out.println("], cartas: [");
        this.Cartas.forEach((k) -> System.out.println(k+" "));
        System.out.println("], numero ejercitos rearmar:"+ this.Ejercitos);
      }   		
    }


