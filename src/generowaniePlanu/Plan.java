/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package generowaniePlanu;

import java.io.Serializable;

/**
 * sluzy do wyswietlenia wynikow generowanego planu
 * @author Administrator
 */
public class Plan implements Serializable{
    String oddzial1;
  //  String oddzial2;
    int dzien;
    int godzina;
    String zawartosc;
        public Plan(String oddzial1, int dzien, int godzina, String zawartosc){
            this.oddzial1=oddzial1;
    //        this.oddzial2=oddzial2;
            this.dzien=dzien;
            this.godzina=godzina;
            this.zawartosc=zawartosc;
        }
        public void setOddzial1(String val){
            this.oddzial1=val;
        }
        public String getOddzial1(){
            return this.oddzial1;
        }
 //       public void setOddzial2(String val){
   //         this.oddzial2=val;
     //   }
 //       public String getOddzial2(){
   //         return this.oddzial2;
     //   }
        public void setDzien(int val){
            this.dzien=val;
        }
        public int getDzien(){
            return this.dzien;
        }
        public void setGodzina(int val){
            this.godzina=val;
        }
        public int getGodzina(){
            return this.godzina;
        }
        public void setZawartosc(String val){
            this.zawartosc=val;
        }
        public String getZawartosc(){
            return this.zawartosc;
        }
}
