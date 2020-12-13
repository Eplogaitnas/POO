/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risk;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author angel
 */
public class Dados {
    private ArrayList<Integer> tiradas;
    public Dados(int numero, char ataque){
        switch(ataque){
            case 'a':
                if(numero-1>0)tiradas.add((int) (Math.random() * 6 + 1));
                if(numero-2>0)tiradas.add((int) (Math.random() * 6 + 1));
                if(numero-3>0)tiradas.add((int) (Math.random() * 6 + 1));
                break;
            case 'd':
                tiradas.add((int) (Math.random() * 6 + 1));
                if(numero-1>0)tiradas.add((int) (Math.random() * 6 + 1));
        }
        Collections.sort(tiradas, Collections.reverseOrder());
    }
    public ArrayList<Integer> gettiradas(){
        return this.tiradas;
    }
}
