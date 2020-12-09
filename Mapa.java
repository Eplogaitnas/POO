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
    
    
    
    
    public Mapa() {
        this.mapa = new HashMap<>();
    }
    
    public HashMap<Point, Celda> getMapa() {
        return mapa;
    }
    
    public Celda GetPais(String Nombre){
        int i,j;
        Point k;
        Celda c,w=new Celda();
        for(i=0;i<11;i++){
            for(j=0;j<8;j++){
                k=new Point(i,j);
                c=this.mapa.get(k);
                if(c.getTipoCelda().equals("Pais")){
                    if(c.getPaisCelda().getNombrePais().equals(Nombre)){
                        return c;
                    }
                    
                }
            }
        }
        return w;
    }
    
    public void insertaCelda(int x, int y, Celda celda) {

        Point punto = new Point(x, y);
        mapa.put(punto, celda);

    }
    public void creaCeldaPais(Pais p, int x, int y){
        Celda c=new Celda(p);
        this.insertaCelda(x,y,c);
    }
    public void CreaPaises(String Nombre,Continente cont,int x, int y, ArrayList<Point> L){
        Pais Pais=new Pais(Nombre,cont,L);
        creaCeldaPais(Pais,x,y);
    }
   public void AsignaFrontO(String Fr,int x, int y,int clase){
       Celda c=new Celda(Fr,clase);
       this.insertaCelda(x,y,c);
   }
   public Point añadecelda(int i, int j){
       Point p=new Point(i,j);
       return p;
   }
   
   
    public void CreageoMapa(){
        ArrayList<Point> ALK = new ArrayList<>();
        ArrayList<Point> ALB = new ArrayList<>();
        ArrayList<Point> USO = new ArrayList<>();
        ArrayList<Point> TNO = new ArrayList<>();
        ArrayList<Point> ONT = new ArrayList<>();
        ArrayList<Point> GRO = new ArrayList<>();
        ArrayList<Point> J0 = new ArrayList<>();
        ArrayList<Point> J1 = new ArrayList<>();
        ArrayList<Point> J2 = new ArrayList<>();
        ArrayList<Point> J3 = new ArrayList<>();
        ArrayList<Point> J4 = new ArrayList<>();
        ArrayList<Point> J5 = new ArrayList<>();
        ArrayList<Point> J6 = new ArrayList<>();
        ArrayList<Point> J7 = new ArrayList<>();
        ArrayList<Point> J8 = new ArrayList<>();
        ArrayList<Point> J9 = new ArrayList<>();
        ArrayList<Point> J10 = new ArrayList<>();
        ArrayList<Point> J11 = new ArrayList<>();
        ArrayList<Point> J12 = new ArrayList<>();
        ArrayList<Point> J13 = new ArrayList<>();
        ArrayList<Point> J14 = new ArrayList<>();
        ArrayList<Point> J15 = new ArrayList<>();
        ArrayList<Point> J16 = new ArrayList<>();
        ArrayList<Point> J17 = new ArrayList<>();
        ArrayList<Point> J18 = new ArrayList<>();
        ArrayList<Point> J19 = new ArrayList<>();
        ArrayList<Point> J20 = new ArrayList<>();
        ArrayList<Point> J21 = new ArrayList<>();
        ArrayList<Point> J22 = new ArrayList<>();
        ArrayList<Point> J23 = new ArrayList<>();
        ArrayList<Point> J24 = new ArrayList<>();
        ArrayList<Point> J25 = new ArrayList<>();
        ArrayList<Point> J26 = new ArrayList<>();
        ArrayList<Point> J27 = new ArrayList<>();
        ArrayList<Point> J28 = new ArrayList<>();
        ArrayList<Point> J29 = new ArrayList<>();
        ArrayList<Point> J30 = new ArrayList<>();
        ArrayList<Point> J31 = new ArrayList<>();
        ArrayList<Point> J32 = new ArrayList<>();
        ArrayList<Point> J33 = new ArrayList<>();
        ArrayList<Point> J34 = new ArrayList<>();
        ArrayList<Point> J35 = new ArrayList<>();
        
        
        Point a;
        
        
        Continente NA=new Continente("America del Norte","magenta");
        Continente SA=new Continente("America del Sur","red");
        Continente EU=new Continente("Europa","yellow");
        Continente AF=new Continente("África","green");
        Continente AS=new Continente("Asia","cyan");
        Continente OC=new Continente("Oceania","blue");
        
        //ALASKA
        a=añadecelda(1,0);
        ALK.add(a);
        a=añadecelda(0,1);
        ALK.add(a);
        a=añadecelda(8,0);
        ALK.add(a);
        CreaPaises("Alaska",NA,0,0,ALK);
        
        //ALBERTA
        a=añadecelda(0,0);
        ALB.add(a);
        a=añadecelda(1,1);
        ALB.add(a);
        a=añadecelda(2,0);
        ALB.add(a);
        CreaPaises("Alberta",NA,0,1,ALB);
        
        //USAOeste
        a=añadecelda(0,1);
        USO.add(a);
        a=añadecelda(1,2);
        USO.add(a);
        CreaPaises("USAOeste",NA,0,2,USO);
        
        //TNoroeste
        a=añadecelda(0,0);
        TNO.add(a);
        a=añadecelda(1,1);
        TNO.add(a);
        a=añadecelda(0,2);
        TNO.add(a);
        CreaPaises("TNoroeste",NA,1,0,TNO);
        
        //ONTARIO
        a=añadecelda(1,0);
        ONT.add(a);
        a=añadecelda(2,1);
        ONT.add(a);
        a=añadecelda(0,1);
        ONT.add(a);
        a=añadecelda(1,2);
        ONT.add(a);
        CreaPaises("Ontario",NA,1,1,ONT);
        
        //GROENLANDIA
        
        a=añadecelda(2,1);
        GRO.add(a);
        a=añadecelda(1,0);
        GRO.add(a);
        a=añadecelda(4,0);
        GRO.add(a);
        CreaPaises("Groen",NA,2,0,GRO);
        
        //QUEBEC
        a=añadecelda(2,0);
        J0.add(a);
        a=añadecelda(1,1);
        J0.add(a);
        CreaPaises("Quebec",NA,2,1,J0);
        
        //USAEste
        a=añadecelda(0,2);
        J1.add(a);
        a=añadecelda(1,1);
        J1.add(a);
        a=añadecelda(1,3);
        J1.add(a);
        CreaPaises("USAEste",NA,1,2,J1);
        
         //AMECENTRAL
        a=añadecelda(1,2);
        J2.add(a);
        a=añadecelda(1,4);
        J2.add(a);
        CreaPaises("Amecentra",NA,1,3,J2);
        
        //ARGENTINA
        a=añadecelda(1,5);
        J3.add(a);
        CreaPaises("Argentina",SA,1,6,J3);
        //PREU(LE)
        a=añadecelda(1,6);
        J4.add(a);
        a=añadecelda(1,4);
        J4.add(a);
        a=añadecelda(2,5);
        J4.add(a);
        CreaPaises("Perú",SA,1,5,J4);
        //VENEZUELA
        a=añadecelda(1,5);
        J5.add(a);
        a=añadecelda(1,3);
        J5.add(a);
        CreaPaises("Venezuela",SA,1,4,J5);
        //BRASIL
        a=añadecelda(1,5);
        J6.add(a);
        a=añadecelda(5,4);
        J6.add(a);
        CreaPaises("Brasil",SA,2,5,J6);
        //ISLANDIA
        a=añadecelda(2,0);
        J7.add(a);
        a=añadecelda(5,0);
        J7.add(a);
        CreaPaises("Islandia",EU,4,0,J7);
        //Escandina
        a=añadecelda(4,0);
        J8.add(a);
        a=añadecelda(5,1);
        J8.add(a);
        a=añadecelda(6,0);
        J8.add(a);
        CreaPaises("Escandina",EU,5,0,J8);
        //GRAN BRETAÑA
        a=añadecelda(5,0);
        J9.add(a);
        a=añadecelda(5,2);
        J9.add(a);
        a=añadecelda(6,1);
        J9.add(a);
        CreaPaises("GBretaña",EU,5,1,J9);
        //EurNorte
        a=añadecelda(7,1);
        J10.add(a);
        a=añadecelda(5,1);
        J10.add(a);
        a=añadecelda(6,0);
        J10.add(a);
        a=añadecelda(6,2);
        J10.add(a);
        CreaPaises("EurNorte",EU,6,1,J10);
        //EurOcc
        a=añadecelda(5,1);
        J11.add(a);
        a=añadecelda(6,2);
        J11.add(a);
        a=añadecelda(5,4);
        J11.add(a);
        CreaPaises("EurOcc",EU,5,2,J11);
        //EurSur
        a=añadecelda(5,2);
        J12.add(a);
        a=añadecelda(6,1);
        J12.add(a);
        a=añadecelda(7,2);
        J12.add(a);
        a=añadecelda(6,4);
        J12.add(a);
        CreaPaises("EurSur",EU,6,2,J12);
        //Rusia
        a=añadecelda(7,1);
        J13.add(a);
        a=añadecelda(6,1);
        J13.add(a);
        a=añadecelda(7,2);
        J13.add(a);
        a=añadecelda(7,0);
        J13.add(a);
        CreaPaises("Rusia",EU,7,1,J13);
        //ANorte
        J14.clear();
        a=añadecelda(5,2);
        J14.add(a);
        a=añadecelda(6,4);
        J14.add(a);
        a=añadecelda(5,5);
        J14.add(a);
        CreaPaises("ANorte",AF,5,4,J14);
        //Egipto
        a=añadecelda(6,2);
        J15.add(a);
        a=añadecelda(5,4);
        J15.add(a);
        a=añadecelda(6,5);
        J15.add(a);
        a=añadecelda(2,5);
        J15.add(a);
        CreaPaises("Egipto",AF,6,4,J15);
        //Congo
        J16.clear();
        a=añadecelda(5,4);
        J16.add(a);
        a=añadecelda(6,5);
        J16.add(a);
        CreaPaises("Congo",AF,5,5,J16);
        //AOriental
        a=añadecelda(6,4);
        J17.add(a);
        a=añadecelda(5,5);
        J17.add(a);
        a=añadecelda(6,6);
        J17.add(a);
        CreaPaises("AOriental",AF,6,5,J17);
        //Sudafrica
        a=añadecelda(6,5);
        J18.add(a);
        a=añadecelda(7,6);
        J18.add(a);
        CreaPaises("Sudafrica",AF,6,6,J18);
        //Madagascar
        a=añadecelda(6,6);
        J19.add(a);
        CreaPaises("Madagascar",AF,7,6,J19);
        //Siberia
        a=añadecelda(5,0);
        J20.add(a);
        a=añadecelda(5,1);
        J20.add(a);
        a=añadecelda(7,0);
        J20.add(a);
        CreaPaises("Siberia",AS,6,0,J20);
        //Yakustsk
        a=añadecelda(6,0);
        J21.add(a);
        a=añadecelda(8,0);
        J21.add(a);
        a=añadecelda(7,1);
        J21.add(a);
        CreaPaises("Yakustsk",AS,7,0,J21);
        //Kamtchatka
        a=añadecelda(0,0);
        J22.add(a);
        a=añadecelda(8,1);
        J22.add(a);
        a=añadecelda(7,0);
        J22.add(a);
        CreaPaises("Kamtchatka",AS,8,0,J22);
        //Irkutsk
        a=añadecelda(8,0);
        J23.add(a);
        a=añadecelda(7,1);
        J23.add(a);
        a=añadecelda(8,2);
        J23.add(a);
        CreaPaises("Irkutsk",AS,8,1,J23);
        //Mongolia
        a=añadecelda(8,1);
        J24.add(a);
        a=añadecelda(8,3);
        J24.add(a);
        a=añadecelda(7,2);
        J24.add(a);
        a=añadecelda(9,2);
        J24.add(a);
        CreaPaises("Mongolia",AS,8,2,J24);
        //Japon
        a=añadecelda(8,2);
        J25.add(a);
        CreaPaises("Japon",AS,9,2,J25);
        //China
        a=añadecelda(8,2);
        J26.add(a);
        a=añadecelda(8,1);
        J26.add(a);
        a=añadecelda(7,3);
        J26.add(a);
        CreaPaises("China",AS,8,3,J26);
        //URALES
        a=añadecelda(8,2);
        J27.add(a);
        a=añadecelda(6,2);
        J27.add(a);
        a=añadecelda(7,3);
        J27.add(a);
        a=añadecelda(7,1);
        J27.add(a);
        CreaPaises("Urales",AS,7,2,J27);
        //Afgan
        a=añadecelda(8,3);
        J28.add(a);
        a=añadecelda(7,2);
        J28.add(a);
        a=añadecelda(7,4);
        J28.add(a);
        CreaPaises("Afgan",AS,7,3,J28);
        //OMedio
        a=añadecelda(7,3);
        J29.add(a);
        a=añadecelda(8,4);
        J29.add(a);
        a=añadecelda(6,4);
        J29.add(a);
        CreaPaises("OMedio",AS,7,4,J29);
        //India
        a=añadecelda(7,4);
        J30.add(a);
        a=añadecelda(9,4);
        J30.add(a);
        a=añadecelda(8,3);
        J30.add(a);
        CreaPaises("India",AS,8,4,J30);
        //SAsiático
        a=añadecelda(8,4);
        J31.add(a);
        a=añadecelda(9,6);
        J31.add(a);
        CreaPaises("SAsiático",AS,9,4,J31);
        //Indonesia
        a=añadecelda(9,4);
        J32.add(a);
        a=añadecelda(9,7);
        J32.add(a);
        a=añadecelda(10,6);
        J32.add(a);
        CreaPaises("Indonesia",OC,9,6,J32);
        //NGuinea
        a=añadecelda(9,6);
        J33.add(a);
        a=añadecelda(10,7);
        J33.add(a);
        CreaPaises("NGuinea",OC,10,6,J33);
        //AusOccid
        a=añadecelda(9,6);
        J34.add(a);
        a=añadecelda(10,7);
        J34.add(a);
        CreaPaises("AusOccid",OC,9,7,J34);
        //AusOrient
        a=añadecelda(9,7);
        J35.add(a);
        a=añadecelda(10,6);
        J35.add(a);
        CreaPaises("AusOrient",OC,10,7,J35);
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
        AsignaFrontO("|-----------------------------------|",3,0,1);
        AsignaFrontO("|-----------------------------------|",9,0,1);
        AsignaFrontO("|-----------------------------------|",10,0,1);
        AsignaFrontO("                                  |"
                + "\n-----------------------------------",3,5,1);
        AsignaFrontO("|-----------------------------------|\n",4,4,1);
        AsignaFrontO("|                    |               |\n",5,3,2);
        AsignaFrontO("|                    |               |\n",6,3,2);
        AsignaFrontO("|                    |               |\n",9,5,2);
        
    }
   
    
    
       public void imprimeMapa1(){
        int i,j,m;
        Celda k;
            for (j = 0; j < 8; j++){
                m=0;
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("|                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                                   |");
                for(i=0;i<11;i++){
                    Point a=new Point(i,j);
                    k=mapa.get(a);
                    if(k.getTipoCelda().equals("Oceano")){
                        k.imprimeCeldaOc();
                       
                        
                    }
                    if(k.getTipoCelda().equals("Pais")){
                        k.imprimeCelda();
                        
                    }
                    if(k.getTipoCelda().equals("Frontera Oceanica")){
                        k.imprimeCeldafrontO();
                        if(k.getclase()==2){
                            m++;
                        }
                        
                    }
                    if(i==10){
                        System.out.print("\n");
                        if(m==0){
                            System.out.println("|                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                                   |");
                            System.out.println("|                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                                   |");
                            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        }
                        if(m==1){
                           System.out.println("|                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                    "+"\u001B[31m"+"|"+ "\u001B[0m"+"               ||                                   |");
                           System.out.println("|                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                    "+"\u001B[31m"+"|"+ "\u001B[0m"+"              ||                                   |");
                           System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                         
                        }
                        if(m==2){
                           System.out.println("|                                   ||                                   ||                                   ||                                   ||                                   ||                    "+"\u001B[31m"+"|"+ "\u001B[0m"+"              ||                     "+"\u001B[31m"+"|"+ "\u001B[0m"+"             ||                                   ||                                   ||                                    ||                                   |");
                           System.out.println("|                                   ||                                   ||                                   ||                                   ||                                   ||                    "+"\u001B[31m"+"|"+ "\u001B[0m"+"              ||                     "+"\u001B[31m"+"|"+ "\u001B[0m"+"             ||                                   ||                                   ||                                    ||                                   |");
                           System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                         
                        }
                    }
                }
                
            }
            } 
    public void imprimeMapa(){
        int i,j,m,b,c,d,e,f,g,h,l,n,o,p;
        String aux0=new String(),aux1=new String(),aux2=new String(),aux3=new String(),aux4=new String(),aux5=new String(),aux6=new String(),aux7=new String(),aux8=new String(),aux9=new String(),aux10=new String();
        Celda k;
            for (j = 0; j < 8; j++){
                m=0;
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("|                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                                   |");
                for(i=0;i<11;i++){
                    Point a=new Point(i,j);
                    k=mapa.get(a);
                    if(k.getTipoCelda().equals("Oceano")){
                        k.imprimeCeldaOc();
                        switch (i) {
                            case 0:
                                aux0=String.format("  ");
                                break;
                            case 1:
                                aux1=String.format("  ");
                                break;
                            case 2:
                                aux2=String.format("  ");
                                break;
                            case 3:
                                aux3=String.format("  ");
                                break;
                            case 4:
                                aux4=String.format("  ");
                                break;
                            case 5:
                                aux5=String.format("  ");
                                break;
                            case 6:
                                aux6=String.format("  ");
                                break;
                            case 7:
                                aux7=String.format("  ");
                                break;
                            case 8:
                                aux8=String.format("  ");
                                break;
                            case 9:
                                aux9=String.format("  ");
                                break;
                            case 10:
                                aux10=String.format("  ");
                                break;
                            default:
                                break;
                        }
                        
                    }
                    if(k.getTipoCelda().equals("Pais")){
                        k.imprimeCelda();
                        switch (i) {
                            case 0:
                                b=k.getPaisCelda().getEjercito().getnumero();
                                aux0=String.format("%2d",b);
                                break;
                            case 1:
                                c=k.getPaisCelda().getEjercito().getnumero();
                                aux1=String.format("%2d",c);
                                break;
                            case 2:
                                d=k.getPaisCelda().getEjercito().getnumero();
                                aux2=String.format("%2d",d);
                                break;
                            case 3:
                                e=k.getPaisCelda().getEjercito().getnumero();
                                aux3=String.format("%2d",e);
                                break;
                            case 4:
                                f=k.getPaisCelda().getEjercito().getnumero();
                                aux4=String.format("%2d",f);
                                break;
                            case 5:
                                g=k.getPaisCelda().getEjercito().getnumero();
                                aux5=String.format("%2d",g);
                                break;
                            case 6:
                                h=k.getPaisCelda().getEjercito().getnumero();
                                aux6=String.format("%2d",h);
                                break;
                            case 7:
                                l=k.getPaisCelda().getEjercito().getnumero();
                                aux7=String.format("%2d",l);
                                break;
                            case 8:
                                n=k.getPaisCelda().getEjercito().getnumero();
                                aux8=String.format("%2d",n);
                                break;
                            case 9:
                                o=k.getPaisCelda().getEjercito().getnumero();
                                aux9=String.format("%2d",o);
                                break;
                            case 10:
                                p=k.getPaisCelda().getEjercito().getnumero();
                                aux10=String.format("%2d",p);
                                break;
                            default:
                                break;
                        }
                    }
                    if(k.getTipoCelda().equals("Frontera Oceanica")){
                        k.imprimeCeldafrontO();
                        if(k.getclase()==2){
                            m++;
                        }
                        switch (i) {
                            case 0:
                                aux0=String.format("  ");
                                break;
                            case 1:
                                aux1=String.format("  ");
                                break;
                            case 2:
                                aux2=String.format("  ");
                                break;
                            case 3:
                                aux3=String.format("  ");
                                break;
                            case 4:
                                aux4=String.format("  ");
                                break;
                            case 5:
                                aux5=String.format("  ");
                                break;
                            case 6:
                                aux6=String.format("  ");
                                break;
                            case 7:
                                aux7=String.format("  ");
                                break;
                            case 8:
                                aux8=String.format("  ");
                                break;
                            case 9:
                                aux9=String.format("  ");
                                break;
                            case 10:
                                aux10=String.format("  ");
                                break;
                            default:
                                break;
                        }
                        
                    }
                    if(i==10){
                        System.out.print("\n");
                        if(m==0){
                            System.out.println("|                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                                   |");
                            System.out.println("|                                 "+ aux0 +"||                                 "+ aux1 +"||                                 "+ aux2 +"||                                 "+ aux3 +"||                                 "+ aux4 +"||                                  "+ aux5 +"||                                  "+ aux6 +"||                                  "+ aux7 +"||                                  "+ aux8 +"||                                  "+ aux9 +"||                                  "+ aux10 +"|");
                            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        }
                        if(m==1){
                           System.out.println("|                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                                   ||                    "+"\u001B[31m"+"|"+ "\u001B[0m"+"               ||                                   |");
                           System.out.println("|                                  "+ aux0 +"||                                  "+ aux1 +"||                                 "+ aux2 +"||                                 "+ aux3 +"||                                 "+ aux4 +"||                                 "+ aux5 +"||                                 "+ aux6 +"||                                 "+ aux7 +"||                                 "+ aux8 +"||                    "+"\u001B[31m"+"|"+ "\u001B[0m"+"              ||                                 "+ aux10 +"|");
                           System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                         
                        }
                        if(m==2){
                           System.out.println("|                                   ||                                   ||                                   ||                                   ||                                   ||                    "+"\u001B[31m"+"|"+ "\u001B[0m"+"              ||                     "+"\u001B[31m"+"|"+ "\u001B[0m"+"             ||                                   ||                                   ||                                    ||                                   |");
                           System.out.println("|                                  "+ aux0 +"||                                  "+ aux1 +"||                                  "+ aux2 +"||                                  "+ aux3 +"||                                  "+ aux4 +"||                    "+"\u001B[31m"+"|"+ "\u001B[0m"+"              ||                     "+"\u001B[31m"+"|"+ "\u001B[0m"+"             ||                                  "+ aux7 +"||                                  "+ aux8 +"||                                   "+ aux9 +"||                                  "+ aux10 +"|");
                           System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                         
                        }
                    }
                }
                
            }
            }
        
        
        public void imprimeFronteras(){
            int i,j,m;
            Celda k,n;
            Point p,q;
            String aux,aux2;
            ArrayList<Point> J;
            for(i=0;i<11;i++){
                for(j=0;j<8;j++){
                    p=new Point(i,j);
                    k=mapa.get(p);
                    if(k.getTipoCelda().equals("Pais")){
                        aux2=String.format("Fronteras de %s :", k.getPaisCelda().getNombrePais());
                        System.out.print(aux2);
                        J=k.getPaisCelda().getFrontera();
                        for(m=0;m<J.size();m++){
                            n=mapa.get(J.get(m));
                            aux=String.format(" %s, ", n.getPaisCelda().getNombrePais());
                            System.out.print(aux);
                        }
                        System.out.print("\n");
                    }
                   // else{
                        //System.out.print("\n");
                   // }
                }
            }
        }
        public void obtenerfrontera(String Pais){
            int i,j,m;
            Celda k,n;
            Point p;
            String aux,aux2;
            ArrayList<Point> J;
            for(i=0;i<11;i++){
                for(j=0;j<8;j++){
                    p=new Point(i,j);
                    k=mapa.get(p);
                    if(k.getTipoCelda().equals("Pais")){
                        if(k.getPaisCelda().getNombrePais().equals(Pais)){
                            aux2=String.format("Fronteras de %s :", k.getPaisCelda().getNombrePais());
                            System.out.print(aux2);
                            J=k.getPaisCelda().getFrontera();
                            for(m=0;m<J.size();m++){
                                n=mapa.get(J.get(m));
                                aux=String.format(" %s, ", n.getPaisCelda().getNombrePais());
                                System.out.print(aux);
                            }
                            System.out.print("\n");
                        }
                    }
                }
            }
        }
        public void obtenercontinente(String Pais){
            int i,j;
            Celda k;
            Point p;
            String aux,aux2;
            for(i=0;i<11;i++){
                for(j=0;j<8;j++){
                    p=new Point(i,j);
                    k=mapa.get(p);
                    if(k.getTipoCelda().equals("Pais")){
                        if(k.getPaisCelda().getNombrePais().equals(Pais)){
                            aux2=String.format("Continente de %s :", k.getPaisCelda().getNombrePais());
                            System.out.print(aux2);
                            aux=String.format("%s", k.getPaisCelda().getContinente().getnombre());
                            System.out.print(aux);
                            System.out.print("\n");
                        }
                    }
                }
            }
        }
        public void obtenercolor(String Pais){
            int i,j;
            Celda k;
            Point p;
            String aux,aux2;
            for(i=0;i<11;i++){
                for(j=0;j<8;j++){
                    p=new Point(i,j);
                    k=mapa.get(p);
                    if(k.getTipoCelda().equals("Pais")){
                        if(k.getPaisCelda().getNombrePais().equals(Pais)){
                            aux2=String.format("Color de %s :", k.getPaisCelda().getNombrePais());
                            System.out.print(aux2);
                            aux=String.format("%s", k.getPaisCelda().getColor());
                            System.out.print(aux);
                            System.out.print("\n");
                        }
                    }
                }
            }
        }
        public void obtenerpaises(String Continente){
            int i,j;
            Celda k;
            Point p;
            String aux,aux2;
            aux2=String.format("Paises de %s :", Continente);
            System.out.print(aux2);
            for(i=0;i<11;i++){
                for(j=0;j<8;j++){
                    p=new Point(i,j);
                    k=mapa.get(p);
                    if(k.getTipoCelda().equals("Pais")){
                        if(k.getPaisCelda().getContinente().getnombre().equals(Continente)){
                            aux=String.format("%s, ", k.getPaisCelda().getNombrePais());
                            System.out.print(aux);
                        }
                    }
                }
            }
            System.out.print("\n");
        }
}
   
