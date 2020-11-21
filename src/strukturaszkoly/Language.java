package strukturaszkoly;

import java.io.Serializable;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.7AAD42CC-92AF-5FEC-C11B-5037BE56C116]
// </editor-fold> 
public class Language implements Serializable {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B9B1FFB7-88AC-56D6-06B6-C1171F1A10B3]
    // </editor-fold> 
    private int hourOfLanguage;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2E6B8D97-F243-230F-9D63-0DDC750ACE64]
    // </editor-fold> 
    private String languageName;
   // private String skrotLanguage;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.EF5B484C-D9E0-E69E-3FD6-241121993B69]
    // </editor-fold> 
    public Language (String languageName, int hourOfLanguage) {
        this.hourOfLanguage=hourOfLanguage;
        this.languageName=languageName;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.01AD5BEA-D2E6-00B0-DCDA-320861657964]
    // </editor-fold> 
    public int getHourOfLanguage () {
        return hourOfLanguage;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.875C709A-5814-6085-21A3-54D3AEAC4177]
    // </editor-fold> 
    public void setHourOfLanguage (int val) {
        this.hourOfLanguage = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.913983D4-6A4D-EE7A-74B6-133BA5B35D31]
    // </editor-fold> 
    public String getLanguageName () {
        return languageName;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.6A2CDE14-85E0-8D91-4574-E583F8E7CF0F]
    // </editor-fold> 
    public void setLanguageName (String val) {
        this.languageName = val;
    }

}

