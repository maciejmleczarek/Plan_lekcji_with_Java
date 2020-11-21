package strukturaszkoly;

import java.io.Serializable;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.D775AD3A-7EBC-541B-5ACB-565B5B278517]
// </editor-fold> 
public class SchoolSubject implements Serializable{

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.24262A2B-E156-9E16-3C18-B9D8FF720C52]
    // </editor-fold> 
    private int hourOfSubject;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.CBE0CE9C-47CE-213B-0D16-981001D0CB19]
    // </editor-fold> 
    private String name;
    private String skrotPrzedmiotu;

    public SchoolSubject(String name, int hourOfSubject, String skrotPrzedmiotu) {
        this.hourOfSubject=hourOfSubject;
        this.name=name;
        this.skrotPrzedmiotu=skrotPrzedmiotu;
    }
    
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.11B7F059-6921-30E9-02DD-B16C5D8C5D83]
    // </editor-fold> 
    public String getName () {
        return name;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.4337CBAB-FACA-9D40-12A8-C03C14626311]
    // </editor-fold> 
    public void setName (String val) {
    this.name=val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.5C1D73C5-A0BA-9F5C-60D0-5B856EFDED81]
    // </editor-fold> 
    public int getHourOfSubject () {
        return hourOfSubject;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.59DF550C-92B6-6160-3D8C-0FDD3B9AE0EA]
    // </editor-fold> 
    public void setHourOfSubject (int val) {
        this.hourOfSubject = val;
    }
    public String getSkrotPrzedmiotu(){
        return this.skrotPrzedmiotu;
    }
    public void setSkrotPrzedmiotu(String val){
        this.skrotPrzedmiotu=val;
    }
}

