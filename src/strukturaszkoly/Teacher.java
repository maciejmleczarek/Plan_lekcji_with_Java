package strukturaszkoly;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.3E911FEC-DA9B-D531-6294-3036BFAA49C8]
// </editor-fold> 
public class Teacher implements Serializable{

    private String teacherName;
    private String nazwaSkrotowa;
    private String opiekunSali;
    private ArrayList nauczanePrzedmioty= new ArrayList();

    public Teacher(String teacherName, String nazwaSkrotowa, String opiekunSali, ArrayList nauczanePrzedmioty) {
        this.teacherName=teacherName;
        this.nazwaSkrotowa=nazwaSkrotowa;
        this.opiekunSali=opiekunSali;
        this.nauczanePrzedmioty=new ArrayList() ;
  //      throw new UnsupportedOperationException("Not yet implemented");
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E84154C2-C849-05B4-7C71-00155935113E]
    // </editor-fold> 
//    private SchoolSubject mSchoolSubject;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.1AB9CCD0-CCF0-D0C5-74BB-A1D3AEDA21C5]
    // </editor-fold> 
    

    public void setTeacherName(String val) {
        this.teacherName = val;
    }

    public String getTeacherName() {
        return this.teacherName;
    }

    public void setNazwaSktotowa(String val) {
        this.nazwaSkrotowa = val;
    }

    public String getNazwaSkrotowa() {
        return this.nazwaSkrotowa;
    }
    public void setOpiekunSali (String val) {
        this.opiekunSali= val;
    }
    public String getOpiekunSali (){
        return this.opiekunSali;
    }
    public void addNauczanyPrzedmiot(String przedmiot){
       this.nauczanePrzedmioty.add(przedmiot);
    }
    public ArrayList getNauczanePrzedmioty(){
        return nauczanePrzedmioty;
    }
    
    public void remNauczanyPrzedmiot (String przedmiot){
        this.nauczanePrzedmioty.remove(przedmiot);
    }
}