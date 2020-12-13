/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risk;
import java.lang.String;
/**
 *
 * @author Santiago Golpe
 */
public class Celda {
    private String tipo;
    private Pais pais;
    private Jugador jugador;
    private String Celda;
    private int Clase;
    private Ejercito ejercito;
    
    public Celda(){
        this.tipo="Oceano";
        this.pais=null;
        this.jugador=null;
    }
    
    public Celda(String x, int classe){
        this.tipo="Frontera Oceanica";
        this.pais=null;
        this.jugador=null;
        this.Celda=x;
        this.Clase=classe;
    }
    
    public Celda(Pais p){
        this.tipo="Pais";
        this.pais=p;
        this.jugador=p.getJugador();
    }
    
    public Ejercito getejercito(){
        return this.ejercito;
    }
    public void settipoCelda(String Tipo){
        this.tipo=Tipo;
    }
     public void setpaisCelda(Pais P){
        this.pais=P;
    }
      public void setjugadorCelda(Jugador j){
        this.jugador=j;
    }
      
      public String getTipoCelda(){
          return this.tipo;
      }
      public Pais getPaisCelda(){
          return this.pais;
      }
      public Jugador getjugadorCelda(){
          return this.jugador;
      }
      public String getCeldaCelda(){
          return this.Celda;
      }
      public int getclase(){
          return this.Clase;
      }
        //Funciones para imprimir celdas
        public String devuelveCelda(){
            String aux=null;
            if(this.tipo.equals("Pais")){
               aux=pais.getNombrePais();
            }
            if(this.tipo.equals("Oceano")){
               aux="|                                   |";
            }
            if(this.tipo.equals("Frontera Oceanica")){
                aux=this.Celda;
            }
            return aux;
        }
        //Imrimir celdas
        public void imprimeCelda(){
        String aux=String.format("|"+"                 "+"%-9s"+"         |", pais.getAbrevPais());
        if(pais.getColor().equals("red")){
            aux=String.format("|"+"\u001B[41m"+"                 "+"%-9s"+"         "+"\u001B[0m"+"|", pais.getAbrevPais());
        }
        if(pais.getColor().equals("cyan")){
            aux=String.format("|"+"\u001B[46m"+"                 "+"%-9s"+"         "+"\u001B[0m"+"|", pais.getAbrevPais());
        }
        if(pais.getColor().equals("green")){
            aux=String.format("|"+"\u001B[42m"+"                 "+"%-9s"+"         "+"\u001B[0m"+"|", pais.getAbrevPais());
        }
        if(pais.getColor().equals("magenta")){
            aux=String.format("|"+"\u001B[45m"+"                 "+"%-9s"+"         "+"\u001B[0m"+"|", pais.getAbrevPais());
        }
        if(pais.getColor().equals("blue")){
            aux=String.format("|"+"\u001B[44m"+"                 "+"%-9s"+"         "+"\u001B[0m"+"|", pais.getAbrevPais());
        }
        if(pais.getColor().equals("yellow")){
            aux=String.format("|"+"\u001B[43m"+"                 "+"%-9s"+"         "+"\u001B[0m"+"|", pais.getAbrevPais());
        }
        System.out.print(aux);
    }
        public void imprimeCeldafrontO(){
            String aux=String.format("\u001B[31m"+"%s"+"\u001B[0m", Celda);
            
            
            if(Clase==1){
                System.out.print("\u001B[31m"+"|-----------------------------------|"+ "\u001B[0m");
            }
            if(Clase==2){
                System.out.print("\u001B[31m"+"|                    |               |"+ "\u001B[0m");
            }
        }
        public void imprimeCeldaOc(){
            System.out.print("|                                   |");
             String aux=String.format("|                                   |");
        }
        public String imprimeejercito(){
        String aux;
        if(this.tipo.equals("Pais")){
            switch (pais.getJugador().getColor()) {
                case "Rojo":case "rojo":
                    aux=String.format("\u001B[31m"+"%-2d"+"\u001B[0m", pais.getEjercito().getnumero());
                    break;
                case "Cian":case "Cyan":case "cian":
                    aux=String.format("\u001B[36m"+"%-2d"+"\u001B[0m", pais.getEjercito().getnumero());
                    break;
                case "Verde":
                    aux=String.format("\u001B[32m"+"%-2d"+"\u001B[0m", pais.getEjercito().getnumero());
                    break;
                case "Violeta":
                    aux=String.format("\u001B[35m"+"%-2d"+"\u001B[0m", pais.getEjercito().getnumero());
                    break;
                case "Azul":
                    aux=String.format("\u001B[34m"+"%-2d"+"\u001B[0m", pais.getEjercito().getnumero());
                    break;
                case "Amarillo":
                    aux=String.format("\u001B[33m"+"%-2d"+"\u001B[0m", pais.getEjercito().getnumero());
                    break;
                default:
                    aux=String.format("%-2d", pais.getEjercito().getnumero());
                    break;
            }
        }
        else{
            aux=" ";
        }
        
        return aux;
    }
        
}
