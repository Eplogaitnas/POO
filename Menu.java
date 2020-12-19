package risk;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import risk.Carta.*;
import risk.Excepcion.*;
/**
 *
 * @author Manuel Lama
 */
public final class Menu {
    // En esta clase se deberían de definir los atributos a los que será 
    // necesario acceder durante la ejecución del programa como, por ejemplo,
    // el mapa o los jugadores
    
    /**
     * 
     */
    int verificador;
    private Mapa mapa;
    private HashMap< String, Mision> Misiones=new HashMap<>();
    private HashMap<String, Jugador> Jugadores = new HashMap<>();
    private Jugador actual;
    private int n_cartas;
    public Menu(){
        this.n_cartas = 0;
        // Inicialización de algunos atributos
        // Iniciar juego
        String orden;
        int asiginicio=0;
        BufferedReader bufferLector;
        try {
            File fichero=  new File("comandos.csv");
            FileReader lector= new FileReader(fichero);
            bufferLector= new BufferedReader(lector);
            while((orden= bufferLector.readLine())!=null) {
                try{
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
                    switch (partes.length) {
                        case 2:
                            if(partes[1].equals("mapa")) {
                                // crearMapa es un método de la clase Menú desde el que se puede invocar
                                // a otros métodos de las clases que contienen los atributos y los métodos
                                // necesarios para realizar esa invocación 
                                crearMapa();
                                
                            } else {
                                throw new ExcepcionComando(" Codigo de error: 101, Comando incorrecto");
                            }   break;
                        case 3:
                            if(partes[1].equals("jugadores")) { 
                                crearJugador(new File(partes[2]));
                                //FALTA PRINTF DE CADA JUGADOR
                            } else {
                                crearJugador(partes[1], partes[2]);
                            }
                            actual=Jugadores.get(Jugadores.keySet().toArray()[0]);
                            break;
                        default:
                            throw new ExcepcionComando(" Codigo de error: 101, Descripcion: \"Comando incorrecto\"");
                    }
                        break;

                    case "asignar":
                        if(partes.length==3) {
                            switch (partes[1]) {
                                case "paises":
                                    // asignarPaises es un método de la clase Menu que recibe como entrada el fichero
                                    // en el que se encuentra la asignación de países a jugadores. Dentro de este
                                    // método se invocará a otros métodos de las clases que contienen los atributos
                                    // y los métodos necesarios para realizar esa invocación
                                    asignarPaises(new File(partes[2]));
                                    break;
                                case "misiones":
                                    asignar_misiones(new File(partes[2]));
                                    break;
                                case "carta":
                                    asignar_carta(partes[2],n_cartas);
                                    break;
                                default:
                                     throw new ExcepcionComando(" Codigo de error: 101, Descripcion: \"Comando incorrecto\"");
                            }
                        }
                        else if(partes.length==4){
                            switch (partes[1]){
                             case "mision":
                                    asignar_mision (partes[2],partes[3]);
                                    break;
                             case "pais":
                                    asignarPaises(partes[2], partes[3]);
                                    break;
                            }
                        }
                        break;
                    case "cambiar":
                    switch (partes.length) {
                        case 5:
                            actual.cambiar_cartas(partes[2],partes[3],partes[4]);
                            break;
                        case 3:                
                            actual.cambiar_cartas_todas();
                            break;
                        default:
                            throw new ExcepcionComando(" Codigo de error: 101, Descripcion: \"Comando incorrecto\"");
                    }
                        break;

                    case "repartir":
                        if(partes[1].equals("ejercitos")){
                            if(asiginicio==0){
                                int tam=Jugadores.size();
                                this.Jugadores.forEach((k,value) ->   value.getEjercitos().aumentarejercitos(35-(5*(tam-3))));
                                asiginicio++;
                            }
                            if(partes.length==4){
            
                                repartir_ejercitos(Integer.parseInt(partes[2]),partes[3]);
                            }
                            //if(partes.length==2)
                        }
                        else throw new ExcepcionComando(" Codigo de error: 101, Descripcion: \"Comando incorrecto\"");
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
                                default:throw new ExcepcionComando(" Codigo de error: 101, Descripcion: \"Comando incorrecto\"");
                        
                            }
                        }
                        else{
                           throw new ExcepcionComando(" Codigo de error: 101, Descripcion: \"Comando incorrecto\"");
                        }
                        break;
                    case "atacar":
                    switch (partes.length) {
                        case 5:
                            atacar(partes[1],partes[2],partes[3],partes[4]);
                            break;
                        case 3:
                            atacar(partes[1],partes[2]);
                            break;
                        default:
                            throw new ExcepcionComando(" Codigo de error: 101, Descripcion: \"Comando incorrecto\"");
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
                               break;
                           }
                       }
                        System.out.println("nombre: \""+actual.getNombreJugador()+"\", numeroEjercitosRearmar: "+actual.getEjercitos().getnumero());
                        if(verificador==1){
                            actual = Jugadores.get(Jugadores.keySet().toArray()[0]);
                        }
                        break;
                    case "jugador":
                        actual.jugador();
                        break;
                    case "ver":
                        mapa.imprimeMapa();
                        break;
                    case "rearmar":
                        rearmar(partes[1], Integer.parseInt(partes[2]),partes[3]);
                   default:
                        throw new ExcepcionComando(" Codigo de error: 101, Descripcion: \"Comando incorrecto\"");
                } 
            }catch(NumberFormatException | ExcepcionComando | ExcepcionGeo | ExcepcionJugador excepcion ){
                 excepcion.printStackTrace();
            }
            }      
            }catch(IOException | NumberFormatException  excepcion ) {
                excepcion.printStackTrace();
        }
        
    }

    /**
     * 
     */
    

    
    public void crearMapa() throws ExcepcionGeo {
        // Código necesario para crear el mapa
        if(mapa!=null) throw new ExcepcionGeo("\nCodigo de error: 107, Descripcion: \"El mapa ya ha sido creado\"");
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
     * @param nombre
     * @param color 
     * @throws risk.Excepcion.ExcepcionGeo 
     * @throws risk.Excepcion.ExcepcionJugador 
     */
    
    public void crearJugador(String nombre, String color) throws ExcepcionGeo, ExcepcionJugador{
        if (this.mapa==null) throw new ExcepcionGeo("\nCodigo de error: 106, Descripcion: \"El mapa no esta creado\"");
        if(Jugadores.containsKey(nombre))throw new ExcepcionJugador(" Codigo de error: 104, Descripcion: \"El jugador ya existe\"");
        Jugador aux;
        switch(color){
            case "AMARILLO": break;
            case "AZUL":break;
            case "CYAN":break;
            case "ROJO":break;
            case "VERDE":break;
            case "VIOLETA":break;
            default: throw new ExcepcionGeo("\nCodigo de error: 100, Descripcion: \"Color no permitido\"");
        }
        aux= new Jugador(nombre,color);
        Jugadores.put(nombre, aux);
        System.out.println("Jugador "+aux.getNombreJugador()+"añadido");
    }
    public void crearJugador(File file) throws ExcepcionGeo, ExcepcionJugador {
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
    
    public void asignar_mision (String nombre,String identificacionmision) throws ExcepcionJugador {
        String colorj;
        Mision aux;
        int a=0;
        if(Jugadores.isEmpty())throw new ExcepcionJugador(" Codigo de error: 105, Descripcion: \"Los jugadores no están creados\"");
        if(!Jugadores.containsKey(nombre)){
            throw new ExcepcionJugador(" Codigo de error: 103, Descripcion: \"El jugador no existe\"");
        }
        Jugador player = Jugadores.get(nombre);
        if (identificacionmision.charAt(0)!='M')System.out.println("identificacion no valida");
        else{
            if(Misiones.containsKey(identificacionmision)){
               System.out.println("Mision ya asignada"); 
            }
            else{   
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
                else aux = new Mision("M1");
                Misiones.put(identificacionmision, aux);
                player.setmision(aux);
            }
        }
    }
    public void asignar_misiones (File file) throws ExcepcionJugador{
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
    public void asignarPaises(String jugador, String pais) throws ExcepcionJugador, ExcepcionGeo {
        Pais country;
        Jugador player;
        if((player=this.Jugadores.get(jugador))==null) throw new ExcepcionJugador(" Codigo de error: 103, Descripcion: \"El jugador no existe\"");
        if(!mapa.getPaises().containsKey(pais))throw new ExcepcionGeo("\nCodigo de error: 109, Descripcion: \"El pais no existe\"");
        country=mapa.getPaises().get(pais);
        country.setJugador(player);
        player.añadirPais(country);
        this.mapa.describir_asignapais(pais);

    }
    public void asignarPaises(File file)throws ExcepcionJugador, ExcepcionGeo {
            // Código necesario para crear a los jugadores del RISK
        BufferedReader br = null;
        String line;
        //Se define separador ","
        try{
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {                
                String[] datos = line.split(";");
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
    /*public void acabar_turno(){
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
                if(actual.getPaises().size()>=18/*&& min 2 ejercitos ){
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
    }*/
    public void repartir_ejercitos(int numero, String pais) throws ExcepcionGeo, ExcepcionJugador{
        Pais country;
        if (actual.getEjercitos().getnumero()<numero){
            System.out.println("numero no valido: mayor al numero de ejercitos disponibles");
            return;
        }
        if(!mapa.getPaises().containsKey(pais))throw new ExcepcionGeo("\nCodigo de error: 109, Descripcion: \"El pais no existe\"");
        if(!actual.getPaises().containsKey(pais))throw new ExcepcionJugador("\nCodigo de error: 110, Descripcion: \"El pais no pertenece al jugador\"");
        country=actual.getPaises().get(pais);
        country.getEjercito().aumentarejercitos(numero);
        country.getContinente().aumentarEjercitos(numero);
        actual.getEjercitos().disminuirjercitos(numero);
        
    }

    /**
     *
     * @param jugador
     * @throws ExcepcionJugador
     */
    public void describir_jugador(String jugador) throws ExcepcionJugador{
        if(!Jugadores.containsKey(jugador)) throw new ExcepcionJugador(" Codigo de error: 103, Descripcion: \"El jugador no existe\"");
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
    public void describir_pais(String nombre_pais) throws ExcepcionGeo{
        Pais country;
        if(mapa.getPaises().containsKey(nombre_pais)){
            country=mapa.getPaises().get(nombre_pais);
            if(country.getNombrePais().equals(nombre_pais)){
                mapa.describir_pais(nombre_pais);
                return;
            }       
        }
        System.out.println("Nombre de pais no valido");
    }
    public void describir_continente(String nombre_continente) throws ExcepcionGeo{
        Continente Continente;
        for (Pais value : mapa.getPaises().values()) {
            if(value.getContinente().getabrev().equals(nombre_continente)){
                Continente=value.getContinente();
                Continente.describir_continente();
                return;
            }
        }
        throw new ExcepcionGeo("\nCodigo de error: 102, Descripcion: \"El continente no existe\"");
           
    }
    public void atacar(String pais1,String dados1, String pais2, String dados2) throws ExcepcionGeo, ExcepcionJugador{
        String valores1[], valores2[];
        ArrayList<Integer> dados_ataque=  new ArrayList<>(),dados_defensa = new ArrayList<>();
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

        Pais country1, country2;
        verificador=0;
        if(!mapa.getPaises().containsKey(pais1))throw new ExcepcionGeo("\nCodigo de error: 109, Descripcion: \"El pais no existe\"");
        if(!(actual.getPaises().containsKey(pais1)))throw new ExcepcionJugador("\nCodigo de error: 110, Descripcion: \"El pais no pertenece al jugador\"");
        country1=actual.getPaises().get(pais1);
        if(!mapa.getPaises().containsKey(pais2))throw new ExcepcionGeo("\nCodigo de error: 109, Descripcion: \"El pais no existe\"");
        if(actual.getPaises().containsKey(pais2))throw new ExcepcionJugador("\nCodigo de error: 111, Descripcion: \"El pais pertenece al jugador\"");
        country2=mapa.getPaises().get(pais2);
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
             if(valor>dados_ataque.get(i)){ 
                 country2.getEjercito().disminuirjercitos(1); 
                 country2.getContinente().disminuirEjercitos(1);
             }
             else if(valor<dados_defensa.get(i)){
                 country1.getEjercito().disminuirjercitos(1);
                 country1.getContinente().disminuirEjercitos(1);
             }
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
         Pais country1, country2=null;
         verificador=0;
         if((country1=actual.getPaises().get(pais1))==null){
             System.out.println("El pais seleccionado no pertencece al jugador actual");
             return;
         }
          if(mapa.getPaises().containsKey(pais2)){
            if(actual.getPaises().get(pais2)== null){
                 country2=mapa.getPaises().get(pais2);
            }
            else{
                System.out.println("El jugador esta atacando a un pais propio ");
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
         d2=new Dados(country2.getEjercito().getnumero(),'d');
         int i=0;
         for (Integer valor: d1.gettiradas()){
             if(valor>d2.gettiradas().get(i)){
                 country2.getEjercito().disminuirjercitos(1);
                 country2.getContinente().disminuirEjercitos(1);
             }
             else if(valor<d2.gettiradas().get(i)){
                 country1.getEjercito().disminuirjercitos(1);
                 country1.getContinente().disminuirEjercitos(1);
             }
             if(country2.getEjercito().getnumero()==0){
               country2.getJugador().getPaises().remove(country2);
               actual.añadirPais(country2);
               n_cartas++;
               break;
             }
             i++;
             if(i==d2.gettiradas().size())break;
         }  
     }
    public void rearmar(String pais1, int num,String pais2) throws ExcepcionJugador, ExcepcionGeo{
        Pais country1, country2; 
        verificador=0;
        if(!mapa.getPaises().containsKey(pais1)) throw new ExcepcionGeo("\nCodigo de error: 109, Descripcion: \"El pais no existe\"");
        if(!mapa.getPaises().containsKey(pais2)) throw new ExcepcionGeo("\nCodigo de error: 109, Descripcion: \"El pais no existe\"");
        if((country1=actual.getPaises().get(pais1))==null)throw new ExcepcionJugador("\nCodigo de error: 110, Descripcion: \"El pais no pertenece al jugador\"");
        if((country2=actual.getPaises().get(pais2))==null)throw new ExcepcionJugador("\nCodigo de error: 110, Descripcion: \"El pais no pertenece al jugador\"");
        for (Point value : country1.getFronteras()) {
            if(mapa.getMapa().get(value).getPaisCelda().equals(country2)){
                verificador=1;
                break;
            }
                
         }
         if(verificador==0){
             System.out.println("Los paises no son fronterizos");
             return;
         }
        if(country1.getEjercito().getnumero()<num+1){
            System.out.println("pais no tiene suficientes ejercitos");
        }
        else{
            country1.getEjercito().disminuirjercitos(num);
            country1.getContinente().disminuirEjercitos(num);
            country2.getEjercito().aumentarejercitos(num);
            country2.getContinente().aumentarEjercitos(num);
        }
    }
    public void asignar_carta(String id, int numero){
        Carta c;
        String tipo;
        tipo=id.split("&")[0];
        if(numero>0){
            switch(tipo){
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
                case "Infanteria":
                    c=new Infanteria(id);
                    break; 
                case "Caballeria":
                    c=new Caballeria(id);
                    break;
                case "Artilleria":
                    c=new Artilleria(id);
                    break; 
                default:
                    System.out.println("fallo al crear carta");
                    return;
        }
            actual.getcartas().add(c);
            numero--;
        }
        else{
            System.out.println("\nNo puede reclamar más cartas. ");
        }
    }
