/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risk.Carta;

/**
 *
 * @author angel
 */
public abstract class Carta {
    private String id;
    public int valor;
    private String pais;
    private String tropa;
    public Carta(String ID){
        this.id=ID;
        String[] parts =ID.split("&");
        this.tropa=parts[0];
        this.pais=parts[1];
    }
    public String getid(){
        return this.id;
    }
    public String gettropa(){
        return this.tropa;
    }
    public int getvalor(){
        return this.valor;
    }
    public abstract void tropavalor();
}

    
