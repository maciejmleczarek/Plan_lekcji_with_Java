/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package strukturaszkoly;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class PoprawnoscOddzialow implements Serializable{
 //  String nazwaOddzialu;
    private String[] poprawnosc;
    private int liczbaOddzialow;
    public PoprawnoscOddzialow( int liczbaOddzialow){
        this.liczbaOddzialow=liczbaOddzialow;
        this.poprawnosc=new String[liczbaOddzialow];
        for(int i=0;i<liczbaOddzialow;i++){
            poprawnosc[i]="-";
        }
    }
   
    public void setLiczbaOddzialow(int val){
        this.liczbaOddzialow=val;
    }
    public void setPoprawnosc(String [] val){
        this.poprawnosc=val;
    }
    public String[] getPoprawnosc(){
        return this.poprawnosc;
    }
    public void changePoprawnoscOddzialu(int i, String val){
        this.poprawnosc[i]=val;
    }
}
