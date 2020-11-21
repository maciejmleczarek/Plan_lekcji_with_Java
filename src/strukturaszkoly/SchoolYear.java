package strukturaszkoly;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
import java.util.Map;
// #[regen=yes,id=DCE.BFB0710D-936D-6021-9CB6-EDDDC80E46C1]
// </editor-fold> 

public class SchoolYear implements Serializable{

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.BACDBB7A-4E26-8541-D095-5394A2DC6462]
    // </editor-fold> 
    private int yearName;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1AA9D473-9B5A-91AE-629E-2EBD1265208D]
    // </editor-fold> 
    private List mSchoolSubject=new ArrayList<SchoolSubject>();

    public SchoolYear(int yearName, List<SchoolSubject> schoolSubject) {
        this.yearName = yearName;
        this.mSchoolSubject=schoolSubject;
    }

    

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.80CC72EF-AEAA-9EF8-F98E-81E86EF12C9B]
    // </editor-fold> 
    public List getSchoolSubject() {
        return this.mSchoolSubject;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.689E33F0-65ED-8D18-46E7-930BC4BFEADC]
    // </editor-fold> 
    public void setSchoolSubject(List val) {
        this.mSchoolSubject=val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.171917B9-59B2-6B23-2D69-99456048BC06]
    // </editor-fold> 
    public int getYearName() {
        return this.yearName;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.10C3E2A8-8886-1A81-26A9-A2BEA730CBCF]
    // </editor-fold> 
    public void setYearName(int val) {
        this.yearName = val;
    }
}

