package risk;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import risk.Carta.*;
/**
 *
 * @author Manuel Lama
 */
public class Menu {
    // En esta clase se deberían de definir los atributos a los que será 
    // necesario acceder durante la ejecución del programa como, por ejemplo,
    // el mapa o los jugadores
    
    /**
     * 
     */
    int verificador;
    String ganador;
    public HashMap< String, Mision> Misiones;
    public HashMap<String, Jugador> Jugadores = new HashMap<>();
    public Jugador actual;
    public Menu() {
        // Inicialización de algunos atributos
        Scanner aux=new Scanner(System.in);
        // Iniciar juego
        String orden= null;
        BufferedReader bufferLector= null;
        try {
            File fichero=  new File("comandos.csv");
            FileReader lector= new FileReader(fichero);
            bufferLector= new BufferedReader(lector);
            while((orden= bufferLector.readLine())!=null) {
                System.out.println("$> " + orden);
                String[] partes=orden.split(" ");
                String comando= partes[0];
                // COMANDOS INICIALES PARA EMPEZAR A JUGAR
                //    crear mapa
                //    crear jugadores <nombre_fichero>
                //    crear <nombre_jugador> <nombre_color>
                //    asignar misiones
                //    asignar paises <nombre_fichero>
                //    asignar <nombre_pais> <nombre_jugador>

                // COMANDOS DISPONIBLES DURANTE EL JUEGO
                //    acabar
                //    atacar <nombre_pais> <nombre_pais>
                //    describir continente <nombre_continente>
                //    describir frontera <nombre_pais>
                //    describir frontera <nombre_continente>
                //    describir jugador <nombre_jugador>
                //    describir pais <nombre_pais>
                //    jugador
                //    repartir ejercitos
                //    ver mapa
                //    ver pais <nombre_pais>
                switch(comando) {
                    case "crear":
                        if(partes.length==2) {
                            if(partes[1].equals("mapa")) {
                                // crearMapa es un método de la clase Menú desde el que se puede invocar
                                // a otros métodos de las clases que contienen los atributos y los métodos
                                // necesarios para realizar esa invocación 
                                crearMapa();
                            } else {
                                System.out.println("\nComando incorrecto.");
                            }
                            
                            
                        System.out.println(partes.length);
                        }if(partes.length==3) {
                            if(partes[1].equals("jugadores")) { 
                                crearJugador(new File(partes[2]));
                            } else {
                                crearJugador(partes[1], partes[2]);
                            }
                            actual=Jugadores.get(Jugadores.keySet().toArray()[0]);
                        } else {
                            System.out.println("\nComando incorrecto.");
                        }
                        break;
                    case "asignar":
                        if(partes.length!=3) {
                            System.out.println("\nComando incorrecto.");
                        } else if(partes[1].equals("paises")) {
                            // asignarPaises es un método de la clase Menu que recibe como entrada el fichero
                            // en el que se encuentra la asignación de países a jugadores. Dentro de este
                            // método se invocará a otros métodos de las clases que contienen los atributos
                            // y los métodos necesarios para realizar esa invocación
                            asignarPaises(new File(partes[2]));
                        } else {
                            asignarPaises(partes[1], partes[2]);
                        }
                        break;
                    case "cambiar":
                        if(partes.length==5){
                            System.out.println("\nComando incorrecto.");
                            //actual.cambiar_cartas(partes[2],partes[3],partes[4]);
                        }
                        else if(partes.length==3){
                            actual.cambiar_cartas_todas();
                        }
                        break;
                    case "repartir":
                        break;
                    case "describir":
                        if(partes.length==3){
                            switch(partes[1]){
                                case "jugador":
                                    describir_jugador(partes[2]);
                                    break;
                                case "pais": 
                                    describir_pais(partes[2]);
                                    break;
                                case "continente":
                                    describir_continente(partes[2]);
                                    break;
                            }
                        }
                        else{
                            System.out.println("\nComando incorrecto.");
                        }
                        break;
                    case "atacar":
                        if(partes.length==5){
                            atacar(partes[1],partes[2],partes[3],partes[4]);
                        }
                        else if(partes.length==3){
                            atacar(partes[1],partes[2]);
                        }
                        break;
                    case "acabar":
                        verificador=0;
                        for (Jugador value : Jugadores.values()) {
                           if (actual.equals(value)){
                               verificador=1;
                           }
                           else if(verificador==1){
                               actual=value;
                               verificador=0;
                           }
                       }
                        if(verificador==1){
                            actual=Jugadores.get(Jugadores.keySet().toArray()[0]);
                        }
                        break;
                    case "jugador":
                        actual.jugador();
                        break;
                    default:
                        System.out.println("\nComando incorrecto.");
                        break;
                } 
            }
        } catch(Exception excepcion) {
            excepcion.printStackTrace();
        }
        
    }

    /**
     * 
     * @param file 
     */
    

    Mapa mapa;
    public void crearMapa() {
        // Código necesario para crear el mapa
        mapa=new Mapa();
        mapa.CreageoMapa();
        mapa.creaFrontO();
        mapa.CreaOceano();
        mapa.imprimeMapa();
        
    }
    public void imprimircambios() {
        mapa.imprimeMapa();
        
    }

        
    /**
     * 
     * @param file 
     */
    
    /**
     * 
     * @param jugador
     * @param color
     * @param file 
     */
    
    public void crearJugador(String nombre, String color){
        Jugador aux;
        aux= new Jugador(nombre,color);
        Jugadores.put(nombre, aux);
        System.out.println("Jugador "+aux.getNombreJugador()+"añadido");
    }
    public void crearJugador(File file) {
        // Código necesario para crear a los jugadores del RISK
        BufferedReader br = null;
        String line = "";
        //Se define separador ","
        String cvsSplitBy = ";";
        try{
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {                
                String[] datos = line.split(cvsSplitBy);
                //Imprime datos.
               //System.out.println(datos[0] + ", " + datos[1] + ", " + datos[2] + ", " + datos[3] + ", " + datos[4] + ", " + datos[5]);
               crearJugador(datos[0],datos[1]);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    
    public void asignar_mision (String nombre,String identificacionmision) {
        String colorj;
        Mision aux;
        int a=0;
        if (identificacionmision.charAt(0)!='M'){System.out.println("identificacion no valida");}
        else{
            if(Misiones.get(identificacionmision)==null){
                if(identificacionmision.charAt(1)=='4'){
                    switch(identificacionmision.charAt(2)){
                        case 1: colorj="AMARILLO"; break;
                        case 2: colorj="AZUL";break;
                        case 3: colorj="CYAN";break;
                        case 4: colorj="ROJO";break;
                        case 5: colorj="VERDE";break;
                        case 6: colorj="VIOLETA";break;
                        default: System.out.println("Mision no valida"); return;
                    }
                    a=1;
                    for (Jugador value : Jugadores.values()) {
                        if(value.getColor()== colorj && nombre.equals(value.getNombreJugador())){
                            a=0;
                        }
                
                    }
                }
                if(a==0){aux = new Mision(identificacionmision); }
                else {aux = new Mision("M1");}
                Jugador player = Jugadores.get(nombre);
                if(player!=null){
                    Misiones.put(identificacionmision, aux);
                    player.setmision(aux);

                }
            }
            else{
                System.out.println("Mision ya asignada");
            }
        }
    }
    public void asignar_misiones (File file){
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        try{
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {                
               String[] datos = line.split(cvsSplitBy);
               asignar_mision(datos[0],datos[1]);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void asignarPaises(String jugador, String pais) {
        String tipo, id;
        Carta c;
        Pais country;
        Jugador player = Jugadores.get(jugador);
        for (Celda value : mapa.getMapa().values()) {
            tipo=value.getTipoCelda();
            if(tipo.equals("Pais")){
                country=value.getPaisCelda();
                if(country.getNombrePais().equals(pais)){
                    player.añadirPais(country);
                    switch((int)(Math.random()*6+1)){
                        case 1:
                            id= String.join("&","Antiaerea",pais);
                              break;
                        case 2:
                            id= String.join("&","DeCaballo",pais);
                            break;
                        case 3:
                            id= String.join("&","DeCamello",pais);
                            break;
                        case 4:
                            id= String.join("&","DeCampanha",pais);
                            break;
                        case 5:
                            id= String.join("&","Fusilero",pais);
                            break;
                        case 6:
                            id= String.join("&","Granadero",pais);
                            break;  
                        default:
                            System.out.println("fallo al crear carta");
                            return;
                    }
                    player.crear_carta(id);
                    return;
                }       
            }
        }
        System.out.println("Nombre de pais no valido");
    }
    public void asignarPaises(File file){
            // Código necesario para crear a los jugadores del RISK
        BufferedReader br = null;
        String line = "";
        //Se define separador ","
        String cvsSplitBy = ";";
        try{
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {                
                String[] datos = line.split(cvsSplitBy);
                //Imprime datos.
               //System.out.println(datos[0] + ", " + datos[1] + ", " + datos[2] + ", " + datos[3] + ", " + datos[4] + ", " + datos[5]);
               asignarPaises(datos[0],datos[1]);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void repartir_ejercitos(int numero, String nombrepais){
        
    }
    public void acabar_turno(){
        //verifico si alguna mision ha sido cumplida.
        String identificador;
        identificador=actual.getmision().getcode();
        switch(identificador.charAt(1)){
            case '1':
                if(actual.getPaises().size()>=24){
                    ganador=actual.getNombreJugador();
                }
                break;
            case '2':
                if(actual.getPaises().size()>=18/*&& min 2 ejercitos*/ ){
                    ganador=actual.getNombreJugador();
                    }
                break;
            case '3':
                switch(identificador.charAt(2)){
                    case '1':
                        if(actual.getContinentes().get("Asia")!=null && actual.getContinentes().get("America del Sur")!=null){
                            ganador=actual.getNombreJugador();
                        }
                        break;
                    case '2':
                        if(actual.getContinentes().get("Asia")!=null && actual.getContinentes().get("Africa")!=null){
                            ganador=actual.getNombreJugador();
                        }
                        break;
                    case '3':
                        if(actual.getContinentes().get("America del Norte")!=null && actual.getContinentes().get("Africa")!=null){
                            ganador=actual.getNombreJugador();
                        }
                        break;
                    case '4':
                        if(actual.getContinentes().get("America del Norte")!=null && actual.getContinentes().get("Oceania")!=null){
                            ganador=actual.getNombreJugador();
                        }
                        break;
                }
                break;
            case '4':
                switch(identificador.charAt(2)){
                    case '1':
                        for (Jugador value : Jugadores.values()) {
                            if(value.getColor()=="AMARILLO" && value.getPaises().isEmpty()){
                                ganador=actual.getNombreJugador();
                            }
                        }
                        break;
                    case '2':
                        for (Jugador value : Jugadores.values()) {
                            if(value.getColor()=="AZUL" && value.getPaises().isEmpty()){
                                ganador=actual.getNombreJugador();
                            }
                        }
                        break;
                    case '3':
                        for (Jugador value : Jugadores.values()) {
                            if(value.getColor()=="CYAN" && value.getPaises().isEmpty()){
                                ganador=actual.getNombreJugador();
                            }
                        }
                        break;
                    case '4':
                        for (Jugador value : Jugadores.values()) {
                            if(value.getColor()=="ROJO" && value.getPaises().isEmpty()){
                                ganador=actual.getNombreJugador();
                            }
                        }
                        break;
                    case '5':
                        for (Jugador value : Jugadores.values()) {
                            if(value.getColor()=="VERDE" && value.getPaises().isEmpty()){
                                ganador=actual.getNombreJugador();
                            }
                        }
                        break;
                    case '6':
                        for (Jugador value : Jugadores.values()) {
                            if(value.getColor()=="VIOLETA" && value.getPaises().isEmpty()){
                                ganador=actual.getNombreJugador();
                            }
                        }
                        break;
                }
                break;
        }
    }
     public void describir_jugador(String jugador){
        Jugador aux = Jugadores.get(jugador);
        if(aux.equals(actual)){
            aux.jugador();
        }
        else{
            System.out.println("nombre: "+aux.getNombreJugador()+", color:"+aux.getColor()+", numeroEjercitos: "+aux.getEjercitos().getnumero()+", Paises: [ ");
            aux.getPaises().forEach((k,v) -> System.out.println(k+" "));
            System.out.println("], continentes: [");
            aux.getContinentes().forEach((k,v) -> System.out.println(k+" "));
            System.out.println("], cartas: [");
            aux.getcartas().forEach((k) -> System.out.println(k+" "));
            System.out.println("], numero ejercitos rearmar:"+ aux.getEjercitos().getnumero());
        }   		
    }
     public void describir_pais(String nombre_pais){
        String tipo;
        Pais country;
        for (Celda value : mapa.getMapa().values()) {
            tipo=value.getTipoCelda();
            if(tipo.equals("Pais")){
                country=value.getPaisCelda();
                if(country.getNombrePais().equals(nombre_pais)){
                    country.describir_pais();
                    return;
                }       
            }
        }
        System.out.println("Nombre de pais no valido");
    }
     public void describir_continente(String nombre_continente){
        String tipo;
        Pais country;
        Continente Continente;
        for (Celda value : mapa.getMapa().values()) {
            tipo=value.getTipoCelda();
            if(tipo.equals("Pais")){
                Continente=value.getPaisCelda().getContinente();
                if(Continente.getnombre().equals(nombre_continente)){
                    Continente.describir_continente();
                    return;
                }       
            }
        }
        System.out.println("Nombre de pais no valido");
    }
     public void atacar(String pais1,String dados1, String pais2, String dados2){
         String valores1[], valores2[];
        ArrayList<Integer> dados_ataque = null,dados_defensa = null;
        valores1= dados2.split("x");
        valores2= dados1.split("x");
        for(int i=0;i<valores1.length;i++){
            dados_ataque.add(Integer.parseInt(valores1[i]));
        }
        for(int i=0;i<valores2.length;i++){
            dados_defensa.add(Integer.parseInt(valores2[i]));
        }
        Collections.sort(dados_ataque, Collections.reverseOrder());
        Collections.sort(dados_defensa, Collections.reverseOrder());
        String tipo;
         Pais country1, country2=null;
         verificador=0;
         if((country1=actual.getPaises().get(pais1))==null){
             System.out.println("El pais seleccionado no pertencece al jugador actual");
             return;
         }
          for (Celda value : mapa.getMapa().values()) {
            tipo=value.getTipoCelda();
            if(tipo.equals("Pais")){
               if(value.getPaisCelda().getNombrePais().equals(pais2)){
                    if(actual.getPaises().get(pais2)== null){
                         country2=value.getPaisCelda();
                    }
                    else{
                        System.out.println("El jugador esta atacando a un pais propio ");
                    }
                }       
            }
         }
         if(country2==null){
             System.out.println("pais no encontrado");
             return;
         }
         for (Point value : country1.getFronteras()) {
           /*for (Point value2 : country2.getFronteras()) {
               if(value1.equals(value2)){
                   verificador=1;
                   break;
               }
           }*/
            if(mapa.getMapa().get(value).getPaisCelda().equals(country2)){
                verificador=1;
                break;
            }
                
         }
         if(verificador==0){
             System.out.println("Los paises no son fronterizos");
             return;
         }
         int i=0;
         for (Integer valor: dados_ataque){
             if(valor>dados_ataque.get(i)) country2.getEjercito().disminuirjercitos(1);
             else if(valor<dados_defensa.get(i)) country2.getEjercito().disminuirjercitos(1);
             if(country2.getEjercito().getnumero()==0){
               country2.getJugador().getPaises().remove(country2);
               actual.añadirPais(country2);
               break;
             }
             i++;
             if(i==dados_defensa.size())break;
         }  
     }
      public void atacar(String pais1, String pais2){
         Dados d1,d2;
         String tipo;
         Pais country1, country2=null;
         verificador=0;
         if((country1=actual.getPaises().get(pais1))==null){
             System.out.println("El pais seleccionado no pertencece al jugador actual");
             return;
         }
          for (Celda value : mapa.getMapa().values()) {
            tipo=value.getTipoCelda();
            if(tipo.equals("Pais")){
               if(value.getPaisCelda().getNombrePais().equals(pais2)){
                    if(actual.getPaises().get(pais2)== null){
                         country2=value.getPaisCelda();
                    }
                    else{
                        System.out.println("El jugador esta atacando a un pais propio ");
                    }
                }       
            }
         }
         if(country2==null){
             System.out.println("pais no encontrado");
             return;
         }
         for (Point value : country1.getFronteras()) {
           /*for (Point value2 : country2.getFronteras()) {
               if(value1.equals(value2)){
                   verificador=1;
                   break;
               }
           }*/
            if(mapa.getMapa().get(value).getPaisCelda().equals(country2)){
                verificador=1;
                break;
            }
                
         }
         if(verificador==0){
             System.out.println("Los paises no son fronterizos");
             return;
         }
         d1=new Dados(country1.getEjercito().getnumero(),'a');
         d2=new Dados(country1.getEjercito().getnumero(),'d');
         int i=0;
         for (Integer valor: d1.gettiradas()){
             if(valor>d2.gettiradas().get(i)) country2.getEjercito().disminuirjercitos(1);
             else if(valor<d2.gettiradas().get(i)) country2.getEjercito().disminuirjercitos(1);
             if(country2.getEjercito().getnumero()==0){
               country2.getJugador().getPaises().remove(country2);
               actual.añadirPais(country2);
               break;
             }
             i++;
             if(i==d2.gettiradas().size())break;
         }  
     }
    
}
