//Menu, Angel

package risk;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
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
    int validar=0;
    public HashMap< String, Mision> Misiones;
    public HashMap<String, Jugador> Jugadores = new HashMap<>();
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
                    case "ver mapa":
                        mapa.imprimeMapa();
                        break;
                    default:
                        System.out.println("\nComando incorrecto.");
                        break;
                    
                        
                }   
            }
        } catch(Exception excepcion) {
            excepcion.printStackTrace();
        }
        while(validar==0){
             for (Jugador value : Jugadores.values()) {
                //añadirejercitos
                //Usar cartas
                //repartirejercitos
                //atacar
                //recibir cartas
             }
        }
    }

    /**
     * 
     * @param file 
     */
    public Color tipocolor(String color){
        switch(color){
            case "ROJO": return Color.red;
            case "AMARILLO": return Color.yellow;
            case "VERDE": return Color.green;
            case "CIAN": return Color.cyan;
            case "AZUL": return Color.blue;
            case "VIOLETA": return Color.magenta;
        }
        return null;
    }

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
        aux= new Jugador(nombre,tipocolor(color));
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
        Color colorj;
        Mision aux;
        int a=0;
        if (identificacionmision.charAt(0)!='M'){System.out.println("identificacion no valida");}
        else{
            if(Misiones.get(identificacionmision)==null){
                if(identificacionmision.charAt(1)=='4'){
                    switch(identificacionmision.charAt(2)){
                        case 1: colorj=Color.yellow; break;
                        case 2: colorj=Color.blue;break;
                        case 3: colorj=Color.cyan;break;
                        case 4: colorj=Color.red;break;
                        case 5: colorj=Color.green;break;
                        case 6: colorj=Color.magenta;break;
                        default: System.out.println("Mision no valida"); return;
                    }
                    a=1;
                    for (Jugador value : Jugadores.values()) {
                        if(value.getColor(value)== colorj && nombre.equals(value.getNombreJugador())){
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
        String tipo;
        Pais country;
        Jugador player = Jugadores.get(jugador);
        for (Celda value : mapa.getMapa().values()) {
            tipo=value.getTipoCelda();
            if(tipo.equals("Pais")){
                country=value.getPaisCelda();
                if(country.getNombrePais().equals(pais)){
                    player.añadirPais(country);
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
    public void cambiar_cartas(){
        
    }
    public void acabar_turno(){
        
    }
    
}
