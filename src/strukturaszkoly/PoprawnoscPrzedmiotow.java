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
public class PoprawnoscPrzedmiotow implements Serializable{
    String nazwaOddzialu;
    String[] poprawnosc;
    int liczbaPrzedmiotow;
    public PoprawnoscPrzedmiotow(String nazwaOdzialu, int liczbaPrzedmiotow){
        this.nazwaOddzialu=nazwaOdzialu;
        this.liczbaPrzedmiotow=liczbaPrzedmiotow;
        this.poprawnosc=new String[liczbaPrzedmiotow];
        for(int i=0;i<liczbaPrzedmiotow;i++){
            poprawnosc[i]="-";
        }
    }
    public void setPoprawnoscNazwaOddzialu(String val){
        this.nazwaOddzialu=val;
    }
    public String getPoprawnoscNazwaOddzialu(){
        return this.nazwaOddzialu;
    }
    public void setLiczbaPrzedmiotow(int val){
        this.liczbaPrzedmiotow=val;
    }
    public void setPoprawnosc(String [] val){
        this.poprawnosc=val;
    }
    public String[] getPoprawnosc(){
        return this.poprawnosc;
    }
    public void changePoprawnoscPrzedmiotu(int i, String val){
        this.poprawnosc[i]=val;
    }
}
