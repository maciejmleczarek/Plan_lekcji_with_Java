package strukturaszkoly;

import java.io.Serializable;



// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.8A65283D-C20C-6998-F035-7F2F66FDD087]
// </editor-fold> 
public class Classroom implements Serializable{
public Classroom(String name,String destinyType){
    this.name = name;
    this.destinyType = destinyType;
}


    private String destinyType;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D40A8173-8972-3E3F-C2F0-BDC4F3C67873]
    // </editor-fold> 
    private String name;
    public String getDestinyType(){
        return destinyType;
    }
    public void setDestinyType(String destinyType){
        this.destinyType=destinyType;
    }
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.E53F0924-80C6-96B6-FD61-155F2B4603EE]
    // </editor-fold> 
    public String getName () {
        return name;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.172DCA62-015B-1835-9438-FEC3DC7D33BC]
    // </editor-fold> 
    public void setName (String val) {
        this.name = val;
    }

}

