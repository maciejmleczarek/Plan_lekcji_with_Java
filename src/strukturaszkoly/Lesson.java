package strukturaszkoly;

import java.io.Serializable;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
import java.util.List;
// #[regen=yes,id=DCE.07F0E8A5-8528-AD2E-257B-36BAA3935275]
// </editor-fold> 
public class Lesson implements Serializable{

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1FF827A2-29B6-79A1-78BC-E45E7D55C1DC]
    // </editor-fold> 
   // private Teacher mTeacher;
    private String nauczyciel;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5B1ADC25-ADF5-5F82-1FD1-ABECD2E9D867]
    // </editor-fold> 
    private String przedmiot;
    
    private String oddzial;
    private int iloscGodzin;
    private int nameYear;
  //  private List<SchoolGroup> mSchoolGroup;
    
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.DB449739-865C-6AE7-D1F9-8DB057C5983B]
    // </editor-fold> 
   // private SchoolGroup mSchoolGroup;
   public Lesson(int nameYear,String oddzial,String przedmiot,String nauczyciel, int iloscGodzin){
       this.nameYear=nameYear;
       this.oddzial=oddzial;
       this.przedmiot=przedmiot;
       this.nauczyciel=nauczyciel;
      this.iloscGodzin=iloscGodzin; 
   }
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.966A0C17-B4CB-34AA-0B37-793E1A21C29E]
    // </editor-fold> 
   
    public int getIloscGodzin(){
        return this.iloscGodzin;
    }
    public void setIloscGodzin(int val){
        this.iloscGodzin=val;
    }
    
    public void setNauczyciel(String val){
        this.nauczyciel=val;
    }
    public String getNauczyciel(){
        return this.nauczyciel;
    }
    public void setPrzedmiot(String val){
       this.przedmiot=val; 
    }
    public String getPrzedmiot(){
        return this.przedmiot;
    }
    public void setOddzial(String val){
        this.oddzial=val;
        
    }
    public String getOddzial(){
        return this.oddzial;
    }
    public int getNameYear(){
        return this.nameYear;
    }
    
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A31E9E58-C4C0-E2F4-D511-7AA061E69534]
    // </editor-fold> 

}

