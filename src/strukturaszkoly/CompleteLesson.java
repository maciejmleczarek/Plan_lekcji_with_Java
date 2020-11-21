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
public class CompleteLesson implements Serializable{
 //private String nauczyciel;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5B1ADC25-ADF5-5F82-1FD1-ABECD2E9D867]
    // </editor-fold> 
  //  private String przedmiot;
    private String oddzial1;
 //   private String oddzial2;
//    private int iloscGodzin;
    private int nameYear;
    private int waga;
    private String skrotTeacher1;
    private String skrotTeacher2;
    private String skrotSubject1;
    private String skrotSubject2;
     public CompleteLesson(int nameYear, String oddzial1,  String sprzedmiot1, String snauczyciel1, String sprzedmiot2, String snauczyciel2, int waga ) {
        this.nameYear = nameYear;
        this.oddzial1 = oddzial1;
     //   this.oddzial2 = oddzial2;
        this.skrotSubject1 = sprzedmiot1;
        this.skrotTeacher1 = snauczyciel1;
        this.skrotSubject2 = sprzedmiot2;
        this.skrotTeacher2 = snauczyciel2;
        this.waga=waga;
    //    this.iloscGodzin=iloscGodzin;

    }

    public int getWaga() {
        return this.waga;
    }

    public void setWaga(int val) {
        this.waga = val;
    }
  //  public int getIloscGodzin(){
  //      return this.iloscGodzin;
  //  }
  //  public void setIloscGodzin(int val){
  //      this.iloscGodzin=val;
  //  }
//    public void setNauczyciel(String val) {
//        this.nauczyciel = val;
//    }
//
//    public String getNauczyciel() {
//        return this.nauczyciel;
//    }
//
//    public void setPrzedmiot(String val) {
//        this.przedmiot = val;
//    }
//
//    public String getPrzedmiot() {
//        return this.przedmiot;
//    }

    public void setOddzial1(String val) {
        this.oddzial1 = val;

    }

    public String getOddzial1() {
        return this.oddzial1;
    }

 //   public void setOddzial2(String val) {
 //       this.oddzial2 = val;

 //   }

//    public String getOddzial2() {
 //       return this.oddzial2;
 //   }

    public int getNameYear() {
        return this.nameYear;
    }
    public String getSkrotTeacher1(){
        return this.skrotTeacher1;
        
    }
    public void setSkrotTeacher1(String val){
        this.skrotTeacher1=val;
    }
    public String getSkrotTeacher2(){
        return this.skrotTeacher2;
        
    }
    public void setSkrotTeacher2(String val){
        this.skrotTeacher2=val;
    }
    public String getSkrotSubject1(){
        return this.skrotSubject1;
    }
    public void setSkrotSubject1(String val){
        this.skrotSubject1=val;
    }
    public String getSkrotSubject2(){
        return this.skrotSubject2;
    }
    public void setSkrotSubject2(String val){
        this.skrotSubject2=val;
    }
   
}

