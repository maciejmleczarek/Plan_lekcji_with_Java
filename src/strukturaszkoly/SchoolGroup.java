package strukturaszkoly;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.1A593E2E-18B8-F6DD-3961-5D19D14C0434]
// </editor-fold> 
public class SchoolGroup extends SchoolYear implements Serializable{

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.65AB5FC5-02B9-80B4-5D5D-5F48B409507D]
    // </editor-fold> 
    //  private SchoolSubject language;
   // private List<Language> mGroupLanguage;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.36A85F76-DABE-6D37-14F3-1F477BA7E241]
    // </editor-fold> 
    private String groupName;
    private boolean podzialWF;
    private boolean podzialJezyka;
    private String completeGroupName;
    private List subjectGroupList =new ArrayList<SchoolSubject>();
    private String language;
//    public int getYearofGroup;
    private int groupYear;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6981D622-60B9-9AC7-514C-BEB9E7E3E432]
    // </editor-fold> 
   // private SchoolSubject mLanguageSubject;

    public SchoolGroup(int yearName, List<SchoolSubject> subjectList, String text, boolean podzialWF, boolean podzialJezyka, String language) {
        super(yearName,subjectList);
        this.groupYear=yearName;
        this.subjectGroupList=subjectList;
        this.groupName=text;
        this.podzialWF=podzialWF;
        this.podzialJezyka=podzialJezyka;
        this.completeGroupName=Integer.toString(yearName)+text;
        this.language=language;
    }
    
       

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.903FA76A-ACBA-D732-D01E-57A618F8BD03]
    // </editor-fold> 
//    public void setLanguageSubject (SchoolSubject val) {
//    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.2D5405C9-4AC9-207E-AA4D-312F93A82AB0]
    // </editor-fold> 
    public String getGroupName() {
        return this.groupName;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.C28D8435-E41E-EDE8-2893-A56E0503E8A6]
    // </editor-fold> 
    public void setGroupName(String val) {
        this.groupName = val;
    }
    public String getCompleteGroupName(){
 
        return this.completeGroupName;
    }
    public void setCompleteGroupName(String val){
        this.completeGroupName=val;
    }
    public boolean getPodzialWF() {
        return this.podzialWF;
    }

    public void setPodzialWF(boolean val) {
        this.podzialWF = val;
    }
    public boolean getPodzialJezyka() {
        return this.podzialJezyka;
    }

    public void setPodzialJezyka(boolean val) {
        this.podzialJezyka = val;
    }
    public int getYearofGroup(){
        return this.groupYear;
    }

  
    public void setYearofGroup(int val){
       this.groupYear=val;
    }
//    public void addSchoolGroupSubject(SchoolSubject schoolSubject){
//        this.subjectGroupList.add(schoolSubject);
//    }
    public void setSubjectGroupList(List val){
        this.subjectGroupList=val;
    }
    public List getSubjectGroupList(){
        return this.subjectGroupList;
    }
//    public void setGroupHourOfSubjectBySubject(String subject, int hourOfSubject){
//        SchoolSubject mojSubject = null;
//        for (int i=0;i<this.subjectGroupList.size();i++){
//         if(this.subjectGroupList.get(i).equals(subject)){
//             mojSubject=(SchoolSubject) subjectGroupList.get(i);
//             mojSubject.setHourOfSubject(hourOfSubject);
//         }
//        }
//    }
//    public int getGroupHourOfSubjectBySubject(String subject){
//        SchoolSubject mojSubject=null;
//        for (int i=0;i<this.subjectGroupList.size();i++){
//         if(this.subjectGroupList.get(i).equals(subject)){
//             mojSubject=(SchoolSubject) subjectGroupList.get(i);
//         }
//        }
//        
//        return mojSubject.getHourOfSubject(); 
//    }
    public void setLanguage(String val){
        this.language=val;
    }
    public String getLanguage(){
        return this.language;
    }
}   


