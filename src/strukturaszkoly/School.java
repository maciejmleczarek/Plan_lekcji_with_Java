package strukturaszkoly;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
import java.util.Map;
import java.util.Set;
// #[regen=yes,id=DCE.761FE7D5-7C71-A04D-EAE0-E48127F789B8]
import javax.swing.JComboBox;
import javax.swing.JList;
import generowaniePlanu.GenerowanyPlan;
// </editor-fold> 

public class School implements Serializable {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.ED45A04B-3F8F-D2FA-8C06-B38C08FF9804]
    // </editor-fold> 
    private List<SchoolYear> mSchoolYear;
    private List<SchoolGroup> mSchoolGroups;
    private List<Lesson> mLesson;
    private List<CompleteLesson> mCompleteLessons;
    private List<PoprawnoscPrzedmiotow> mPoprawnoscPrzedmiotows;
    private PoprawnoscOddzialow mPoprawnoscOddzialows;
    private int[] jo = new int[]{2, 2, 2, 3, 3, 3};
    private int[] iloscGodzinRocznikow = new int[]{20, 20, 20, 20, 20, 20, 24, 24, 24};
    private int[] maxIloscGodzinRocznikow = new int[]{23, 23, 23, 28, 28, 28, 31, 31, 31};
    private int maxIloscGodzinNauczyciela = 27;
    private ArrayList<String> informacja;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E8D8824C-1A29-722D-12FF-7DAB4F8D0A83]
    // </editor-fold> 
    private String schoolType;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.19903A9C-689E-7E16-749C-8BF921DC937A]
    // </editor-fold> 
    private int maxDayHours;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.60FF01D2-FCAC-465A-4268-B60F402A9A55]
    // </editor-fold> 
    private List<Classroom> mClassroom;
    private List<SchoolSubject> mSchoolSubjects;
    private List<Language> mLanguages;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8738B1E7-BB7B-D817-5E60-91A208E62A48]
    // </editor-fold> 
    private List<Teacher> mTeacher;
    private String[] classRoomTypes = new String[16];
    private String[] primaryRoomTypes = new String[16];
    private String[] gymnasiumRoomTypes = new String[16];
    private int maxLiczbaZajec;
    private int liczbaOddzialow;
    private int liczbaPrzedmiotow;
    private int liczbaZajec;
    private int iloscSalNZ;
    private int poprawnoscWarunkowWstepnych = 0;
    private int poprawnoscIlosciZajecSzkoly;
    private int poprawnoscZaznaczeniaLekcjiOddzialow;
    private int poprawnoscIlosciGodzinRocznikow;
    private int poprawnoscIlosciGodzinGrup;
    private int poprawnoscIlosciGodzinNauczycieli;
    private int poprawnoscIlosciSalInformatyki;
    private int poprawnoscIloscSalWF;
    private int poprawnoscIlosciSalNZ;
    private int poprawnoscIlosciZajecOldPrimary;
    private boolean poprawnoscPlanu = false;
    private int iloscOldGroup = 0;
    private int obecnoscSkrotuNauczyciela;

    public School getSchool() {
        return this;
    }

    public int getObecnoscSkrotuNauczyciela() {
        return obecnoscSkrotuNauczyciela;
    }

    public void setObecnoscSkrotuNauczyciela(int val) {
        this.obecnoscSkrotuNauczyciela = val;
    }

    public List getInformacja() {
        return this.informacja;
    }

    public void setPoprawnoscPlanu(boolean val) {
        this.poprawnoscPlanu = val;
    }

    public boolean getPoprawnoscPlanu() {
        return this.poprawnoscPlanu;
    }

    public int getPoprawnoscWarunkowWstepnych() {
        return this.poprawnoscWarunkowWstepnych;
    }

    public List getCompleteLessons() {
        return this.mCompleteLessons;
    }

    public void setIloscGodzinRocznikow(int[] val) {
        this.iloscGodzinRocznikow = val;
    }

    public int[] getIloscGodzinRocznikow() {
        return this.iloscGodzinRocznikow;
    }

    public void setPrimaryClassRoomTypes() {
        this.classRoomTypes = this.primaryRoomTypes;
    }

    public void setGymnasiumClassRoomTypes() {
        this.classRoomTypes = this.gymnasiumRoomTypes;

    }

    public void addSchoolSubject(SchoolSubject schoolSubject) {
        this.mSchoolSubjects.add(schoolSubject);
    }

    public void remSchoolSubject(SchoolSubject schoolSubject) {
        this.mSchoolSubjects.remove(schoolSubject);
    }

    public void addPoprawnoscPrzedmiotow(PoprawnoscPrzedmiotow poprawnoscPrzedmiotow) {
        this.mPoprawnoscPrzedmiotows.add(poprawnoscPrzedmiotow);
    }

    public void remPoprawnoscPrzedmiotow(PoprawnoscPrzedmiotow poprawnoscPrzedmiotow) {
        this.mPoprawnoscPrzedmiotows.remove(poprawnoscPrzedmiotow);
    }

    public void removeallSchoolSubject() {
        this.mSchoolSubjects.removeAll(mSchoolSubjects);
    }

    public void addSchoolYear(SchoolYear schoolYear) {
        this.mSchoolYear.add(schoolYear);
    }

    public void addSchoolGroup(SchoolGroup schoolGroup) {
        this.mSchoolGroups.add(schoolGroup);
    }

    public void remSchoolGroup(SchoolGroup schoolGroup) {
        this.mSchoolGroups.remove(schoolGroup);
    }

    public void removeallSchoolYears() {
        this.mSchoolYear.removeAll(mSchoolYear);
    }

    public void defaultPrimarySubiectObiects() {
        removeallSchoolSubject();
        this.addSchoolSubject(new SchoolSubject("Nauczanie zintegrowane", 19, "Nz"));
        System.out.print(mSchoolSubjects.get(0).getName());
        System.out.println(mSchoolSubjects.get(0).getHourOfSubject());
        this.addSchoolSubject(new SchoolSubject("Religia(1-3)", 1, "Rel"));
        System.out.print(mSchoolSubjects.get(1).getName());
        System.out.println(mSchoolSubjects.get(1).getHourOfSubject());
        //   this.addSchoolSubject(new SchoolSubject("Język angielski(1-3)", 1));
        this.addSchoolSubject(new SchoolSubject("Język polski", 4, "Jp"));
        this.addSchoolSubject(new SchoolSubject("Historia i społeczeństwo", 1, "His"));
        this.addSchoolSubject(new SchoolSubject("Matematyka", 4, "Mat"));
        this.addSchoolSubject(new SchoolSubject("Przyroda", 3, "Przyr"));
        this.addSchoolSubject(new SchoolSubject("Muzyka", 0, "Muz"));
        this.addSchoolSubject(new SchoolSubject("Plastyka", 0, "Plas"));
        this.addSchoolSubject(new SchoolSubject("Technika", 0, "Tech"));
        this.addSchoolSubject(new SchoolSubject("Informatyka", 0, "Inf"));
        this.addSchoolSubject(new SchoolSubject("Religia(4-6)", 1, "Rel"));
        this.addSchoolSubject(new SchoolSubject("Godziny z wychowawcą", 1, "Wych"));
        this.addSchoolSubject(new SchoolSubject("WF", 4, "WF"));

        System.out.println("Liczba przedmiotów = " + this.mSchoolSubjects.size());


    }

    public int getJo(int i) {
        return this.jo[i];
    }

    public void setJo(int i, int j) {
        this.jo[i] = j;
    }

    public void defaultGymnasiumSubjectObiects() {
        removeallSchoolSubject();
        this.addSchoolSubject(new SchoolSubject("Język polski", 4, "Jp"));
        System.out.print(mSchoolSubjects.get(0).getName());
        System.out.println(mSchoolSubjects.get(0).getHourOfSubject());
        this.addSchoolSubject(new SchoolSubject("Historia", 2, "His"));
        System.out.print(mSchoolSubjects.get(1).getName());
        System.out.println(mSchoolSubjects.get(1).getHourOfSubject());
        this.addSchoolSubject(new SchoolSubject("Wiedza o społeczeństwie", 1, "WOS"));
        this.addSchoolSubject(new SchoolSubject("Matematyka", 4, "Mat"));
        this.addSchoolSubject(new SchoolSubject("Fizyka i astronomia", 1, "Fiz"));
        this.addSchoolSubject(new SchoolSubject("Chemia", 1, "Chem"));
        this.addSchoolSubject(new SchoolSubject("Biologia", 1, "Bio"));
        this.addSchoolSubject(new SchoolSubject("Geografia", 1, "Geo"));
        this.addSchoolSubject(new SchoolSubject("Plastyka", 0, "Plas"));
        this.addSchoolSubject(new SchoolSubject("Muzyka", 0, "Muz"));
        this.addSchoolSubject(new SchoolSubject("Technika", 0, "Tech"));
        this.addSchoolSubject(new SchoolSubject("Informatyka", 0, "Inf"));
        this.addSchoolSubject(new SchoolSubject("Religia", 1, "Rel"));
        this.addSchoolSubject(new SchoolSubject("Godziny z wychowawcą", 1, "Wych"));
        this.addSchoolSubject(new SchoolSubject("WF", 4, "WF"));

        System.out.println("Liczba przedmiotów = " + this.mSchoolSubjects.size());

    }

    public void defaultPrimaryYears() {
        removeallSchoolYears();
        defaultPrimarySubiectObiects();
        List<SchoolSubject> listOfSubject = mSchoolSubjects;
        List<SchoolSubject> first = new ArrayList<SchoolSubject>();
        List<SchoolSubject> second = new ArrayList<SchoolSubject>();
        for (int j = 0; j < 2; j++) {
            first.add(listOfSubject.get(j));
        }
        for (int j = 2; j < 13; j++) {
            second.add(listOfSubject.get(j));
        }
        for (int i = 1; i < 4; i++) {
            this.addSchoolYear(new SchoolYear(i, first));
        }
        for (int i = 4; i < 7; i++) {
            this.addSchoolYear(new SchoolYear(i, second));
        }

        System.out.println("Liczba roczników podstawówki = " + this.mSchoolYear.size());
        System.out.println("Liczba przedmiotów dla rocznika 1 " + this.mSchoolYear.get(0).getSchoolSubject().size());


    }
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.E3DF0FD4-DD03-2143-4530-9B98CD54394C]
    // </editor-fold> 

    public void defaultGymnasiumYears() {
        removeallSchoolYears();
        defaultGymnasiumSubjectObiects();
        List<SchoolSubject> subjects = mSchoolSubjects;
        List<SchoolSubject> gym = new ArrayList<SchoolSubject>();
        for (int j = 0; j < subjects.size(); j++) {
            gym.add(subjects.get(j));
        }
        for (int i = 1; i < 4; i++) {
            this.addSchoolYear(new SchoolYear(i, gym));
        }

        System.out.println("Liczba roczników gimnazjum = " + this.mSchoolYear.size());
        System.out.println("Liczba przedmiotów dla rocznika 1 " + this.mSchoolYear.get(0).getSchoolSubject().size());
    }

    public List getLanguage() {
        return mLanguages;
    }

    public List getClassroom() {
        return mClassroom;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A5C550F3-7D24-75A5-8FC2-966E3542C36E]
    // </editor-fold> 
    public void setClassroom(List val) {
        mClassroom = val;
    }

    public void setLanguage(List val) {
        mLanguages = val;
    }
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.9F36FA7F-55A0-C57C-8F75-270A8262F7B4]
    // </editor-fold> 

    public List getSchoolYear() {
        return mSchoolYear;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.1B6B6999-C228-3218-1629-8742633527BC]
    // </editor-fold> 
    public void setSchoolYear(List val) {
        mSchoolYear = val;
    }

    public List getSchoolGroup() {
        return mSchoolGroups;
    }

    public void setSchoolGroup(List val) {
        mSchoolGroups = val;
    }

    public void setPoprawnoscOddzialow(PoprawnoscOddzialow val) {
        mPoprawnoscOddzialows = val;
    }

    public PoprawnoscOddzialow getPoprawnoscOddzialow() {
        return mPoprawnoscOddzialows;
    }

    public void setListPoprawnosciOddzialow(String[] val) {
        mPoprawnoscOddzialows.setPoprawnosc(val);
    }

    public String[] getListaPoprawnosciOddzialow() {
        return mPoprawnoscOddzialows.getPoprawnosc();
    }
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.ED412CFF-7BD4-4D63-D291-F93BEC73F50F]
    // </editor-fold> 

    public List getTeacher() {
        return mTeacher;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.7C0203A6-2F22-E094-E976-0A527F192F17]
    // </editor-fold> 
    public void setTeacher(List val) {
        mTeacher = val;
    }

    public List getLesson() {
        return mLesson;
    }

    public void setLesson(List val) {
        mLesson = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.884B2F64-D7C8-D41C-C495-AD18DDF8FF9E]
    // </editor-fold> 

    public int getMaxDayHours() {
        return maxDayHours;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.7661C425-A819-E714-4E6E-9F7B8C62BB99]
    // </editor-fold> 
    public void setMaxDayHours(int val) {
        maxDayHours = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.9FAEDE8E-204C-AB74-0A21-E285A8207537]
    // </editor-fold> 
    public String getSchoolType() {
        return schoolType;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.8C21069C-E328-CF76-B7F7-6167BDA9AD57]
    // </editor-fold> 
    public void setSchoolType(String val) {
        schoolType = val;
    }

    public String[] getClassTypes() {
        return this.classRoomTypes;
    }

    public void addClassroom(Classroom classroom) {
        this.mClassroom.add(classroom);
    }

    public void remClassroom(Classroom classroom) {
        this.mClassroom.remove(classroom);
    }

    public void addLesson(Lesson lesson) {
        this.mLesson.add(lesson);
    }

    public void remLesson(Lesson lesson) {
        this.mLesson.remove(lesson);
    }



    public void addLanguage(Language language) {
        this.mLanguages.add(language);
    }

    public void remLanguage(Language language) {
        this.mLanguages.remove(language);
    }

    public void addTeacher(Teacher teacher) {
        this.mTeacher.add(teacher);
    }

    public void remTeacher(Teacher teacher) {
        this.mTeacher.remove(teacher);
    }

    public void remLessonByGroup(String group) {
        for (int i = 0; i < mLesson.size(); i++) {
            System.out.println(i);
            if (mLesson.get(i).getOddzial().equals(group)) {
                remLesson(mLesson.get(i));
                i = 0;
            }
        }
        for (int i = 0; i < mLesson.size(); i++) {
            System.out.println(i);
            if (mLesson.get(i).getOddzial().equals(group)) {
                remLesson(mLesson.get(i));
                i = 0;
            }
        }
    }

    public void remLessonByGroupAndWF(String group) {
        for (int i = 0; i < mLesson.size(); i++) {
            System.out.println(i);
            if ((mLesson.get(i).getOddzial().equals(group)) && ((mLesson.get(i).getPrzedmiot().equals("WF")) || (mLesson.get(i).getPrzedmiot().equals("WF grupa 1")) || (mLesson.get(i).getPrzedmiot().equals("WF grupa 2")))) {
                remLesson(mLesson.get(i));
                i = 0;
            }
        }
        for (int i = 0; i < mLesson.size(); i++) {
            System.out.println(i);
            if ((mLesson.get(i).getOddzial().equals(group)) && ((mLesson.get(i).getPrzedmiot().equals("WF")) || (mLesson.get(i).getPrzedmiot().equals("WF grupa 1")) || (mLesson.get(i).getPrzedmiot().equals("WF grupa 2")))) {
                remLesson(mLesson.get(i));
                i = 0;
            }
        }
    }

    public void remLessonByGroupAndLanguage(String group, String jezyk) {
        for (int i = 0; i < mLesson.size(); i++) {
            System.out.println(i);
            if ((mLesson.get(i).getOddzial().equals(group)) && ((mLesson.get(i).getPrzedmiot().equals(jezyk)))) {
                remLesson(mLesson.get(i));
                i = 0;

            }
        }
        for (int i = 0; i < mLesson.size(); i++) {
            System.out.println(i);
            if ((mLesson.get(i).getOddzial().equals(group)) && ((mLesson.get(i).getPrzedmiot().equals(jezyk)))) {
                remLesson(mLesson.get(i));
                i = 0;

            }

        }
    }

    public void remLessonByTeacher(String teacher) {
        for (int i = 0; i < mLesson.size(); i++) {
            System.out.println(i);
            if (mLesson.get(i).getNauczyciel().equals(teacher)) {
                remLesson(mLesson.get(i));
                i = 0;

            }
        }
        for (int i = 0; i < mLesson.size(); i++) {
            System.out.println(i);
            if (mLesson.get(i).getNauczyciel().equals(teacher)) {
                remLesson(mLesson.get(i));
                i = 0;

            }
        }
    }

    public void remLessonByLanguage(String language) {
        for (int i = 0; i < mLesson.size(); i++) {
            System.out.println(i);
            if (mLesson.get(i).getPrzedmiot().equals(language)) {
                remLesson(mLesson.get(i));
                if (mLesson.get(0).getPrzedmiot().equals(language)) {
                    remLesson(mLesson.get(0));
                }
                i = 0;

            }
        }
        for (int i = 0; i < mLesson.size(); i++) {
            System.out.println(i);
            if (mLesson.get(i).getPrzedmiot().equals(language)) {
                remLesson(mLesson.get(i));
                if (mLesson.get(0).getPrzedmiot().equals(language)) {
                    remLesson(mLesson.get(0));
                }
                i = 0;

            }
        }
    }

    public String[] getClassRoomNames() {
        System.out.print("Pobieram nazwy");
        String[] names = new String[mClassroom.size()];
        for (int i = 0; i < mClassroom.size(); i++) {
            names[i] = mClassroom.get(i).getName();
        }
        return names;
    }

    public String[] getListaPoprawnosciPrzedmiotow(String oddzial) {

        PoprawnoscPrzedmiotow nazwa = null;
        for (int i = 0; i < mPoprawnoscPrzedmiotows.size(); i++) {
            if (mPoprawnoscPrzedmiotows.get(i).getPoprawnoscNazwaOddzialu().equals(oddzial)) {
                nazwa = mPoprawnoscPrzedmiotows.get(i);
            }
        }
        String[] przedmioty = new String[nazwa.getPoprawnosc().length];
        przedmioty = nazwa.getPoprawnosc();
        return przedmioty;
    }

    public String[] setListaPoprawnosciNaMinus(int wielkosc) {
        String[] przedmioty = new String[wielkosc];
        for (int i = 0; i < wielkosc; i++) {
            przedmioty[i] = "-";
        }
        return przedmioty;
    }

    public String[] getSubjectNames() {
        String[] names = new String[mSchoolSubjects.size()];
        for (int i = 0; i < mSchoolSubjects.size(); i++) {
            names[i] = mSchoolSubjects.get(i).getName();
        }
        return names;
    }

    public String[] getLanguageNames() {
        String[] names = new String[mLanguages.size()];
        for (int i = 0; i < mLanguages.size(); i++) {
            names[i] = mLanguages.get(i).getLanguageName();
        }
        return names;
    }

    public String[] getTeacherNames() {
        String[] names = new String[mTeacher.size()];
        for (int i = 0; i < mTeacher.size(); i++) {
            names[i] = mTeacher.get(i).getTeacherName();
        }
        return names;
    }

    public String[] getSchoolSubjectNames() {
        String[] names = new String[mSchoolSubjects.size()];
        for (int i = 0; i < mSchoolSubjects.size(); i++) {
            names[i] = mSchoolSubjects.get(i).getName();
        }
        return names;
    }

    public String[] getSchoolCompleteGroupNames() {
        String[] names = new String[mSchoolGroups.size()];
        for (int i = 0; i < mSchoolGroups.size(); i++) {
            names[i] = mSchoolGroups.get(i).getCompleteGroupName();
        }
        return names;
    }

    public String[] getSubjecNamesByGroup(String name) {
        SchoolGroup onList = getSchoolGroupByName(name);
        String[] przedmioty = new String[onList.getSubjectGroupList().size()];
        for (int i = 0; i < onList.getSubjectGroupList().size(); i++) {
            SchoolSubject obiektPrzedmiotu = (SchoolSubject) onList.getSubjectGroupList().get(i);
            przedmioty[i] = obiektPrzedmiotu.getName();
        }
        return przedmioty;
    }

    public String[] getTeacherBySubject(String przedmiot) {
        List<Teacher> onList = mTeacher;
        String[] jezyki = this.getLanguageNames();
        int wielkoscJezykow = jezyki.length;
        String[] nauczyciele = new String[onList.size()];
        int pozycja = 0;
        for (int i = 0; i < onList.size(); i++) {
            for (int j = 0; j < onList.get(i).getNauczanePrzedmioty().size(); j++) {
                if (onList.get(i).getNauczanePrzedmioty().get(j).equals(przedmiot)) {
                    nauczyciele[pozycja++] = onList.get(i).getTeacherName();

                }
                if ((onList.get(i).getNauczanePrzedmioty().get(j).equals("WF")) && ((przedmiot.equals("WF grupa 1")) || (przedmiot.equals("WF grupa 2")))) {
                    nauczyciele[pozycja++] = onList.get(i).getTeacherName();
                }
                if ((onList.get(i).getNauczanePrzedmioty().get(j).equals("Informatyka")) && ((przedmiot.equals("Informatyka grupa 1")) || (przedmiot.equals("Informatyka grupa 2")))) {
                    nauczyciele[pozycja++] = onList.get(i).getTeacherName();
                }
                for (int n = 0; n < wielkoscJezykow; n++) {
                    if ((onList.get(i).getNauczanePrzedmioty().get(j).equals(jezyki[n])) && ((przedmiot.equals(jezyki[n] + " grupa 1")) || (przedmiot.equals(jezyki[n] + " grupa 2")))) {
                        nauczyciele[pozycja++] = onList.get(i).getTeacherName();
                    }
                }


            }
        }
        int liczba = 0;
        for (int n = 0; n < nauczyciele.length; n++) {
            if (nauczyciele[n] != null) {
                liczba++;
            }
        }
        String[] nauczycieleZwrot = new String[liczba];
        for (int i = 0; i < liczba; i++) {
            nauczycieleZwrot[i] = nauczyciele[i];
        }
        return nauczycieleZwrot;
    }

    public boolean sprawdzLekcje(String oddzial, String przedmiot) {
        List<Lesson> onList = mLesson;
        boolean lekcja = false;
        for (int i = 0; i < onList.size(); i++) {
            if (onList.get(i).getOddzial().equals(oddzial) && (onList.get(i).getPrzedmiot().equals(przedmiot))) {
                lekcja = true;
            }
        }
        return lekcja;
    }

    public String getTeacherByGroupAndSubject(String oddzial, String przedmiot) {
        List<Lesson> onList = mLesson;
        String nauczyciel = null;
        for (int i = 0; i < mLesson.size(); i++) {
            if (onList.get(i).getOddzial().equals(oddzial) && onList.get(i).getPrzedmiot().equals(przedmiot)) {
                nauczyciel = onList.get(i).getNauczyciel();
            }
        }
        return nauczyciel;
    }

    public Lesson getLessonByGroupAndSubject(String oddzial, String przedmiot) {
        for (int i = 0; i < mLesson.size(); i++) {
            if ((mLesson.get(i).getOddzial().equals(oddzial)) && (mLesson.get(i).getPrzedmiot().equals(przedmiot))) {
                return mLesson.get(i);
            }
        }
        return null;
    }

    public Classroom getClassRoomByName(String name) {
        for (int i = 0; i < mClassroom.size(); i++) {
            if (mClassroom.get(i).getName().equals(name)) {
                System.out.print(i);
                return mClassroom.get(i);
            }
        }
        return null;
    }

    public SchoolSubject getSchoolSubjectByName(String name) {
        for (int i = 0; i < mSchoolSubjects.size(); i++) {
            if (mSchoolSubjects.get(i).getName().equals(name)) {
                System.out.print(i);
                return mSchoolSubjects.get(i);
            }
        }
        return null;
    }

    public PoprawnoscPrzedmiotow getPoprawnoscPrzedmiotowByName(String name) {
        for (int i = 0; i < mPoprawnoscPrzedmiotows.size(); i++) {
            if (mPoprawnoscPrzedmiotows.get(i).getPoprawnoscNazwaOddzialu().equals(name)) {
                return mPoprawnoscPrzedmiotows.get(i);
            }
        }
        return null;
    }

    public Language getLanguageByName(String name) {
        for (int i = 0; i < mLanguages.size(); i++) {
            if (mLanguages.get(i).getLanguageName().equals(name)) {
                return mLanguages.get(i);
            }
        }
        return null;
    }

    public Teacher getTeacherByName(String name) {
        for (int i = 0; i < mTeacher.size(); i++) {
            if (mTeacher.get(i).getTeacherName().equals(name)) {
                return mTeacher.get(i);
            }
        }
        return null;
    }

    public int sprawdzenieObesnosciSkrotuNauczyciela(String skrot) {
        for (int i = 0; i < mTeacher.size(); i++) {
            if (mTeacher.get(i).getNazwaSkrotowa().equals(skrot)) {

                return 1;
            }
        }
        return 0;
    }

    public SchoolGroup getSchoolGroupByName(String name) {
        System.out.println(mSchoolGroups.size());
        for (int i = 0; i < mSchoolGroups.size(); i++) {
            if (mSchoolGroups.get(i).getCompleteGroupName().equals(name)) {
                return mSchoolGroups.get(i);
            }
        }
        return null;
    }

    public String getSkrotByTeacherName(String name) {
        return this.getTeacherByName(name).getNazwaSkrotowa();

    }

    public String getSkrotByGroupAndSubject(String grupa, String przedmiot) {
        SchoolSubject ourSubject;
        SchoolGroup ourGroup = getSchoolGroupByName(grupa);
        if (ourGroup.getLanguage().equals(przedmiot)) {
            return ourGroup.getLanguage();
        }
        for (int i = 0; i < ourGroup.getSubjectGroupList().size(); i++) {
            ourSubject = (SchoolSubject) ourGroup.getSubjectGroupList().get(i);
            if (ourSubject.getName().equals(przedmiot)) {
                return ourSubject.getSkrotPrzedmiotu();
            }
        }
        return null;
    }

    public void setSubjectHourByYearAndSubject(int year, String przedmiot, int ilosc) {
        SchoolYear ourYear = mSchoolYear.get(year - 1);
        SchoolSubject ourSubject = null;
        String przedmiotRocznika;
        for (int i = 0; i < ourYear.getSchoolSubject().size(); i++) {
            ourSubject = (SchoolSubject) ourYear.getSchoolSubject().get(i);
            if (ourSubject.getName().equals(przedmiot)) {
                ourSubject.setHourOfSubject(ilosc);
            }
        }
    }

    public int getSubjectHourByYearAndSubject(int year, String przedmiot) {
        SchoolYear ourYear = mSchoolYear.get(year - 1);
        SchoolSubject ourSubject = null;
        String przedmiotRocznika;
        int ilosc = 0;
        for (int i = 0; i < ourYear.getSchoolSubject().size(); i++) {
            ourSubject = (SchoolSubject) ourYear.getSchoolSubject().get(i);
            if (ourSubject.getName().equals(przedmiot)) {
                ilosc = ourSubject.getHourOfSubject();
            }
        }
        return ilosc;
    }

    public List<SchoolSubject> getSubjectOfGymnasiumOrOldPrimary(int yearName, boolean WFpodzial, boolean jezykPodzial, String jezykObcy, int iloscGodzinJezyka) {
        SchoolYear ourYear = ((List<SchoolYear>) getSchoolYear()).get(yearName - 1);
        List<SchoolSubject> subjectList = (List) ourYear.getSchoolSubject();
        List<SchoolSubject> groupSubjectList = new ArrayList<SchoolSubject>();
        int iloscInformy = 0;
        int godzinyWF = 0;
        for (int i = 0; i < subjectList.size(); i++) {
            if (subjectList.get(i).getName().equals("Informatyka")) {
                iloscInformy = subjectList.get(i).getHourOfSubject();
            }
            if (subjectList.get(i).getName().equalsIgnoreCase("WF")) {
                godzinyWF = subjectList.get(i).getHourOfSubject();
            }
            if (!(subjectList.get(i).getName().equals("Informatyka")) && !(subjectList.get(i).getName().equals("WF"))) {
                if (subjectList.get(i).getHourOfSubject() != 0) {

                    groupSubjectList.add(subjectList.get(i));
                }
            }
        }

        if (WFpodzial) {
            groupSubjectList.add(new SchoolSubject("WF grupa 1", godzinyWF, "WF1"));
            groupSubjectList.add(new SchoolSubject("WF grupa 2", godzinyWF, "WF2"));

        } else {
            groupSubjectList.add(new SchoolSubject("WF", godzinyWF, "WF"));

        }
        if (jezykPodzial) {
            groupSubjectList.add(new SchoolSubject(jezykObcy + " grupa 1", iloscGodzinJezyka, jezykObcy + "1"));
            groupSubjectList.add(new SchoolSubject(jezykObcy + " grupa 2", iloscGodzinJezyka, jezykObcy + "2"));
            if (iloscInformy != 0) {
                groupSubjectList.add(new SchoolSubject("Informatyka grupa 1", iloscInformy, "Inf1"));
                groupSubjectList.add(new SchoolSubject("Informatyka grupa 2", iloscInformy, "Inf2"));

            }
        } else {
            groupSubjectList.add(new SchoolSubject(jezykObcy, iloscGodzinJezyka, jezykObcy));
            if (iloscInformy != 0) {
                groupSubjectList.add(new SchoolSubject("Informatyka", iloscInformy, "Inf"));

            }
        }
        return groupSubjectList;

    }

    public void sprawdzenieWarunkowWsepnych() {
        informacja.removeAll(informacja);
        poprawnoscWarunkowWstepnych = 0;
        poprawnoscWarunkowWstepnych = poprawnoscWarunkowWstepnych + sprawdzenieIlosciSalInformatyki();
        //informacja.add("Poprawność ilości sal informatyki = " + sprawdzenieIlosciSalInformatyki());
        poprawnoscWarunkowWstepnych = poprawnoscWarunkowWstepnych + sprawdzenieIlosciSalWF();
        //informacja.add("Poprawność ilości sal WF = " + sprawdzenieIlosciSalWF());

        //   informacja.add("Max liczba zajęć = " + this.getMaxLiczbaZajecGimnazium());
        //    informacja.add("Liczba zajęć = " + this.getLiczbaZajecGimnazjum());
        if (this.schoolType.equals("primary")) {
            poprawnoscWarunkowWstepnych = poprawnoscWarunkowWstepnych + sprawdzeniePoprawnoscIliosciZajecOldPrimary();
            poprawnoscWarunkowWstepnych = poprawnoscWarunkowWstepnych + sprawdzenieIlosciSalNZ();
        //        this.sprawdzeniePoprawnoscIliosciZajecOldPrimary();
        //         this.sprawdzenieIlosciSalNZ();
        }
        poprawnoscWarunkowWstepnych = poprawnoscWarunkowWstepnych + this.sprawdzeniePoprawnoscIliosciZajecGimnaziumAndYoungPrimary();
        poprawnoscWarunkowWstepnych = poprawnoscWarunkowWstepnych + this.sprawdzenieZaznaczeniaPoprawnosciOddzialow();
        poprawnoscWarunkowWstepnych = poprawnoscWarunkowWstepnych + this.sprawdzenieIloscigodzinOddzialow();
        //  informacja.add("Poprawnosc ilosci zajec szkoly = " + this.sprawdzeniePoprawnoscIliosciZajecGimnaziumAndYoungPrimary());
        //  informacja.add("Poprawnosc zaznaczenia lekcji = " + this.sprawdzenieZaznaczeniaPoprawnosciOddzialow());
        //  informacja.add("Poprawnosc ilosci godzin rocznikow = " + this.sprawdzenieIloscigodzinOddzialow());
        poprawnoscWarunkowWstepnych = poprawnoscWarunkowWstepnych + this.sprawdzenieIlosciGodzinNauczycieli();
        //    informacja.add("Poprawność ilości godzin nauczycieli = " + sprawdzenieIlosciGodzinNauczycieli());
        if (this.getSchoolGroup().size() == 0) {
            informacja.add("Nie wprowadzono żadnego oddziału");
            poprawnoscWarunkowWstepnych++;
        }
        laczenieGrupINadanieWag();
        poprawnoscWarunkowWstepnych=poprawnoscWarunkowWstepnych+ sprawdzenieIlosciZajecGrup();
        if (poprawnoscWarunkowWstepnych == 0) {

            informacja.add("Nie występują błędy, można generować plan.");
     //       informacja.add("liczba complete w school " + this.getCompleteLessons().size());
        } else {
            informacja.add(" ");
            informacja.add("Liczba błędów = " + Integer.toString(poprawnoscWarunkowWstepnych) + ". Popraw je aby móc generować plan.");

        }
    }

    public int sprawdzeniePoprawnoscIliosciZajecGimnaziumAndYoungPrimary() {

        if (getMaxLiczbaZajecGimnazium() > getLiczbaZajecGimnazjum()) {
            return poprawnoscIlosciZajecSzkoly = 0;
        } else {
            informacja.add("Nie możana rozlokować wszystkich zajęć dla klas I-III.");
            informacja.add("Zwiększ maksymalną liczbę godzin dziennie, bądź dodaj salę.");
            return poprawnoscIlosciZajecSzkoly = 1;
        }

    }

    public int sprawdzeniePoprawnoscIliosciZajecOldPrimary() {
        poprawnoscIlosciZajecOldPrimary = 0;
        int liczbaZajec = 0;
        int iloscSalNZ = 0;
        iloscOldGroup = 0;
        Classroom ourSala = null;
        //int iloscSalWF = 0;
        for (int i = 0; i < this.getClassroom().size(); i++) {
            ourSala = (Classroom) this.getClassroom().get(i);
            if (ourSala.getDestinyType().equals("Nauczanie zintegrowane")) {
                iloscSalNZ = iloscSalNZ + 1;
            }
        }
        int iloscSalOldPrimary = this.getClassroom().size() - iloscSalNZ;
        //    informacja.add("Ilość sal dla roczników IV-VI = " + iloscSalOldPrimary);
        int maxLiczbaZajecOldPrimary = 0;
        for (int i = 0; i < this.getSchoolGroup().size(); i++) {
            SchoolGroup ourGroup = (SchoolGroup) this.getSchoolGroup().get(i);
            if (ourGroup.getYearName() > 3) {
                iloscOldGroup = iloscOldGroup + 1;
                liczbaPrzedmiotow = ourGroup.getSubjectGroupList().size();
                for (int j = 0; j < liczbaPrzedmiotow; j++) {

                    SchoolSubject ourSubject = (SchoolSubject) ourGroup.getSubjectGroupList().get(j);
                    liczbaZajec = liczbaZajec + ourSubject.getHourOfSubject();
                }
            }

        }
        maxLiczbaZajecOldPrimary = iloscSalOldPrimary * 5 * this.getMaxDayHours();
        //      informacja.add("Liczba zajęć dla roczników IV-VI = " + liczbaZajec);
        //     informacja.add("Max ilość zajęć dla roczników IV-VI =" + maxLiczbaZajecOldPrimary);

        if (maxLiczbaZajecOldPrimary > liczbaZajec) {
            poprawnoscIlosciZajecOldPrimary = 0;

        } else if (iloscOldGroup != 0) {
            informacja.add("Nie można rozlokować wszystkich zajęć dla klas IV-VI.");
            informacja.add("Zwiększ maksymalną liczbę godzin dziennie, bądź dodaj salę.");

            poprawnoscIlosciZajecOldPrimary = 1;
        }
        return poprawnoscIlosciZajecOldPrimary;
    }

    public int sprawdzenieZaznaczeniaPoprawnosciOddzialow() {
        poprawnoscZaznaczeniaLekcjiOddzialow = 0;
        SchoolGroup ourOddzial;
        String[] tablica = this.getPoprawnoscOddzialow().getPoprawnosc();
        for (int i = 0; i < this.getPoprawnoscOddzialow().getPoprawnosc().length; i++) {
            if (tablica[i].equals("-")) {
                poprawnoscZaznaczeniaLekcjiOddzialow = 1;
                ourOddzial = (SchoolGroup) this.getSchoolGroup().get(i);
                informacja.add("Oddzial " + ourOddzial.getCompleteGroupName() + " nie ma przyporządkowanych wszystkich nauczycieli do przedmiotów.");

            }
        }
        return poprawnoscZaznaczeniaLekcjiOddzialow;
    }

    public int sprawdzenieIloscigodzinOddzialow() {
        poprawnoscIlosciGodzinRocznikow = 0;
        SchoolGroup ourGroup;
        SchoolSubject ourSubject;
        for (int i = 0; i < 9; i++) {
            if (iloscGodzinRocznikow[i] > maxIloscGodzinRocznikow[i]) {
                poprawnoscIlosciGodzinRocznikow = 1;
                informacja.add("Tygodniowy wymiar godzin zajęć rocznika " + (i + 1) + " wynosi " + iloscGodzinRocznikow[i] + " i przekracza dopuszczalną normę.");
            }
            if (iloscGodzinRocznikow[i]>(5*this.getMaxDayHours())){
                poprawnoscIlosciGodzinRocznikow=1;
                informacja.add("Zbyt mało godzin pracy szkoły aby rozlokować wszystkie lekcje");
                
            }
        }
        return poprawnoscIlosciGodzinRocznikow;
    }
    public int sprawdzenieIlosciZajecGrup(){
        poprawnoscIlosciGodzinGrup=0;
        SchoolGroup ourGroup;
        CompleteLesson ourCompleteLesson;
        int iloscGodzinGrupy;
        for (int i=0;i<this.getSchoolGroup().size();i++){
            ourGroup=(SchoolGroup) this.getSchoolGroup().get(i);
            iloscGodzinGrupy=0;
            for (int n=0;n<this.getCompleteLessons().size();n++){
                ourCompleteLesson=(CompleteLesson) this.getCompleteLessons().get(n);
                if(ourCompleteLesson.getOddzial1().equals(ourGroup.getCompleteGroupName())){
                    iloscGodzinGrupy=iloscGodzinGrupy+1;
                }
            }
            if (iloscGodzinGrupy>(5*this.getMaxDayHours())){
                poprawnoscIlosciGodzinGrup=1;
                informacja.add("Nie można rozlokować zajęć oddzialu "+ourGroup.getCompleteGroupName()+" zwiększ ilość godzin pracy szkoly");
            }
        }
        return poprawnoscIlosciGodzinGrup;
    }
    public int sprawdzenieIlosciGodzinNauczycieli() {
        poprawnoscIlosciGodzinNauczycieli = 0;
        int iloscNauczycieli = this.getTeacher().size();
        int iloscGodzinNauczyciela = 0;
        Teacher ourTeacher;
        String name;
        Lesson ourLesson;
        for (int i = 0; i < iloscNauczycieli; i++) {
            iloscGodzinNauczyciela = 0;
            ourTeacher = (Teacher) this.getTeacher().get(i);

            name = ourTeacher.getTeacherName();
            for (int j = 0; j < this.getLesson().size(); j++) {
                ourLesson = (Lesson) this.getLesson().get(j);
                if (ourLesson.getNauczyciel().equals(name)) {
                    iloscGodzinNauczyciela = iloscGodzinNauczyciela + ourLesson.getIloscGodzin();

                }

            }

       //     informacja.add("Ilosc godzin nauczyciela " + name + " wynosi " + iloscGodzinNauczyciela);

            if (iloscGodzinNauczyciela > maxIloscGodzinNauczyciela) {
                informacja.add("Ilosc godzin nauczyciela " + name + " wynosi " + iloscGodzinNauczyciela + " i przekracza dopuszczalną normę.");
                poprawnoscIlosciGodzinNauczycieli = 1;
            }

        }
        return poprawnoscIlosciGodzinNauczycieli;
    }

    public int sprawdzenieIlosciSalInformatyki() {
        poprawnoscIlosciSalInformatyki = 0;
        Classroom ourSala;
        SchoolGroup ourGroup;
        SchoolSubject ourSubject = null;
        int liczbaInformatyk = 0;
        int maxLiczbaInformatyk = 0;
        int iloscSalInformatyki = 0;
        for (int i = 0; i < this.getClassroom().size(); i++) {
            ourSala = (Classroom) this.getClassroom().get(i);
            if (ourSala.getDestinyType().equals("Informatyka")) {
                iloscSalInformatyki = iloscSalInformatyki + 1;
            }

        }
  //      this.informacja.add("Liczba sal Informatyki = " + iloscSalInformatyki);

        for (int i = 0; i < this.getSchoolGroup().size(); i++) {
            ourGroup = (SchoolGroup) this.getSchoolGroup().get(i);
            for (int j = 0; j < ourGroup.getSubjectGroupList().size(); j++) {
                ourSubject = (SchoolSubject) ourGroup.getSubjectGroupList().get(j);
                if ((ourSubject.getName().equals("Informatyka")) || (ourSubject.getName().equals("Informatyka grupa 1")) || (ourSubject.getName().equals("Informatyka grupa 2"))) {
                    liczbaInformatyk = liczbaInformatyk + ourSubject.getHourOfSubject();
                }
            }

        }
  //      this.informacja.add("Liczba zajęć Informatyki = " + liczbaInformatyk);
        maxLiczbaInformatyk = iloscSalInformatyki * 5 * this.maxDayHours;
        if (liczbaInformatyk > maxLiczbaInformatyk) {
            this.informacja.add("Istnieje za mało sal informatycznych.");
            poprawnoscIlosciSalInformatyki = 1;
        }

        return poprawnoscIlosciSalInformatyki;
    }

    public int sprawdzenieIlosciSalWF() {
        poprawnoscIloscSalWF = 0;
        //  tworzenieLekcjiWF();
        Classroom ourSala;
        //   WFLesson ourWFLesson;
        SchoolGroup ourGroup;
        SchoolSubject ourSubject = null;
        int liczbaWF = 0;
        int maxLiczbaWF = 0;
        int iloscSalWF = 0;
        for (int i = 0; i < this.getClassroom().size(); i++) {
            ourSala = (Classroom) this.getClassroom().get(i);
            if (ourSala.getDestinyType().equals("WF")) {
                iloscSalWF = iloscSalWF + 1;
            }

        }
   //     this.informacja.add("Liczba sal WF = " + iloscSalWF);
        for (int i = 0; i < this.getSchoolGroup().size(); i++) {
            ourGroup = (SchoolGroup) this.getSchoolGroup().get(i);
            for (int j = 0; j < ourGroup.getSubjectGroupList().size(); j++) {
                ourSubject = (SchoolSubject) ourGroup.getSubjectGroupList().get(j);
                if ((ourSubject.getName().equals("WF")) || (ourSubject.getName().equals("WF grupa 1")) || (ourSubject.getName().equals("WF grupa 2"))) {
                    liczbaWF = liczbaWF + ourSubject.getHourOfSubject();
                }
            }
        }


    //    this.informacja.add("Liczba zajęć WF = " + liczbaWF);
        maxLiczbaWF = iloscSalWF * 5 * this.maxDayHours;
        if (liczbaWF > maxLiczbaWF) {
            this.informacja.add("Istnieje za mało sal WF.");
            poprawnoscIloscSalWF = 1;
        }

        return poprawnoscIloscSalWF;
    }

    public int sprawdzenieIlosciSalNZ() {
        poprawnoscIlosciSalNZ = 0;
        Classroom ourSala;
        SchoolGroup ourGroup;
        SchoolSubject ourSubject = null;
        int liczbaRocznikowNZ = 0;
        int iloscSalNZ = 0;
        for (int i = 0; i < this.getClassroom().size(); i++) {
            ourSala = (Classroom) this.getClassroom().get(i);
            if (ourSala.getDestinyType().equals("Nauczanie zintegrowane")) {
                iloscSalNZ = iloscSalNZ + 1;
            }
        }
        //      this.informacja.add("Liczba sal Nauczania zintegrowanego = " + iloscSalNZ);

        for (int i = 0; i < this.getSchoolGroup().size(); i++) {
            ourGroup = (SchoolGroup) this.getSchoolGroup().get(i);
            if ((ourGroup.getYearName() == 1) || (ourGroup.getYearName() == 2) || (ourGroup.getYearName() == 3)) {
                liczbaRocznikowNZ = liczbaRocznikowNZ + 1;
            }

        }
        //     this.informacja.add("Liczba Rocznikow z NZ = " + liczbaRocznikowNZ);

        if (liczbaRocznikowNZ > iloscSalNZ) {
            this.informacja.add("Istnieje za mało sal nauczania zintegrowanego.");
            poprawnoscIlosciSalNZ = 1;

        }
        return poprawnoscIlosciSalNZ;
    }

    public int getMaxLiczbaZajecGimnazium() {

        maxLiczbaZajec = 5 * this.getMaxDayHours() * this.getClassroom().size();
        return this.maxLiczbaZajec;
    }

    public int getLiczbaZajecGimnazjum() {
        liczbaZajec = 0;
        liczbaOddzialow = this.getSchoolGroup().size();
        for (int i = 0; i < liczbaOddzialow; i++) {
            SchoolGroup ourGroup = (SchoolGroup) this.getSchoolGroup().get(i);
            liczbaPrzedmiotow = ourGroup.getSubjectGroupList().size();
            for (int j = 0; j < liczbaPrzedmiotow; j++) {
                SchoolSubject ourSubject = (SchoolSubject) ourGroup.getSubjectGroupList().get(j);
                liczbaZajec = liczbaZajec + ourSubject.getHourOfSubject();
            }
        }
        return this.liczbaZajec;
    }

    public void laczenieGrupINadanieWag() {
        mCompleteLessons.removeAll(mCompleteLessons);
        ArrayList<CompleteLesson> CompleteLessonList = new ArrayList<CompleteLesson>();
        Lesson ourLesson;
        Classroom ourClassroom;
        CompleteLesson ourComlpeteLesson1;
        CompleteLesson ourComlpeteLesson2;
        String ourTeacherSkrot;
        String ourSubjectSkrot;
        String ourLanguage = null;
        int iloscSalWF = 0;
        int iloscSalInf = 0;
        int waga = 0;
        int wagaWF = 100;
        int wagaLaczonychGrup2WF = 200;
        int wagaLaczonychGrup2Inf = 180;
        int wagaLaczonychGrup2JO = 150;
        int wagaLaczonychGrupWFzJO = 180;
        int wagaLaczonychGrupWFzInf = 190;
        int wagaLaczonychGrupJOzInf = 170;

        int wagaNieLaczonychGrup = 400;
        int wagaInf = 50;
        int wagaReszta = 30;
        int wagaNz = 300;
        int wagaRel13 = 310;

        String[] listaJezykow = this.getLanguageNames();
        for (int i = 0; i < mLesson.size(); i++) {
            ourLesson = (Lesson) this.getLesson().get(i);
            for (int j = 0; j < ourLesson.getIloscGodzin(); j++) {
                ourTeacherSkrot = getSkrotByTeacherName(ourLesson.getNauczyciel());
                ourSubjectSkrot = getSkrotByGroupAndSubject(ourLesson.getOddzial(), ourLesson.getPrzedmiot());
                CompleteLessonList.add(new CompleteLesson(ourLesson.getNameYear(), ourLesson.getOddzial(), ourSubjectSkrot, ourTeacherSkrot, "", "", j));
            }
        }
        /* sprawdzenie dostępności sal*/
        for (int i = 0; i < this.getClassroom().size(); i++) {
            ourClassroom = (Classroom) this.getClassroom().get(i);
            if (ourClassroom.getDestinyType().equals("WF")) {
                iloscSalWF = iloscSalWF + 1;
            }
            if (ourClassroom.getDestinyType().equals("Informatyka")) {
                iloscSalInf = iloscSalInf + 1;
            }
        }
        /*Łaczenie grup WF*/
        if (iloscSalWF > 1) {
            /* gdy jest więcej niz 1 sala WF*/
    //        informacja.add("Jest więcej niz 1 sala WF");
            for (int i = 0; i < CompleteLessonList.size(); i++) {
                ourComlpeteLesson1 = CompleteLessonList.get(i);
                if ((ourComlpeteLesson1.getSkrotSubject2().isEmpty()) && (ourComlpeteLesson1.getSkrotSubject1().equals("WF1"))) {
        //            informacja.add("Znalazłem WF1 bez drugiego przedmiotu");
                    /* Gdy nie ma 2 przedmiotu a pierwszy jest WF1*/
                    for (int j = 0; j < CompleteLessonList.size(); j++) {
                        ourComlpeteLesson2 = CompleteLessonList.get(j);
                        if ((ourComlpeteLesson2.getSkrotSubject2().isEmpty()) && (ourComlpeteLesson2.getSkrotSubject1().equals("WF2"))) {
                            if ((ourComlpeteLesson1.getOddzial1().equals(ourComlpeteLesson2.getOddzial1()) && !(ourComlpeteLesson1.getSkrotTeacher1().equals(ourComlpeteLesson2.getSkrotTeacher1())))) {
                                /* gdy zgadzają się oddziały a różni nauczyciele*/
                                /* dodanie drugiej lekcji WF*/
         //                       informacja.add("Łączę grupy WF");
                                ourComlpeteLesson1.setSkrotSubject2(ourComlpeteLesson2.getSkrotSubject1());
                                ourComlpeteLesson2.setSkrotSubject2(ourComlpeteLesson1.getSkrotSubject1());
                                ourComlpeteLesson1.setSkrotTeacher2(ourComlpeteLesson2.getSkrotTeacher1());
                                ourComlpeteLesson2.setSkrotTeacher2(ourComlpeteLesson1.getSkrotTeacher1());
                                waga = ourComlpeteLesson1.getWaga();
                                ourComlpeteLesson1.setWaga(waga + wagaLaczonychGrup2WF);
                                mCompleteLessons.add(ourComlpeteLesson1);
                                break;

                            }
                        }

                    }
                }
            }
        }  /* koniec łączenia WF*/
        /*Łączenie grup Inf*/
        if (iloscSalInf > 1) {
            /* gdy jest więcej niz 1 sala WF*/
            for (int i = 0; i < CompleteLessonList.size(); i++) {
                ourComlpeteLesson1 = CompleteLessonList.get(i);
                if ((ourComlpeteLesson1.getSkrotSubject2().isEmpty()) && (ourComlpeteLesson1.getSkrotSubject1().equals("Inf1"))) {
                    /* Gdy nie ma 2 przedmiotu a pierwszy jest Inf1*/
    //                informacja.add("Znalazłem Inf1 bez drugiego przedmiotu");
                    for (int j = 0; j < CompleteLessonList.size(); j++) {
                        ourComlpeteLesson2 = CompleteLessonList.get(j);
                        if ((ourComlpeteLesson2.getSkrotSubject2().isEmpty()) && (ourComlpeteLesson2.getSkrotSubject1().equals("Inf2"))) {
                            if ((ourComlpeteLesson1.getOddzial1().equals(ourComlpeteLesson2.getOddzial1()) && !(ourComlpeteLesson1.getSkrotTeacher1().equals(ourComlpeteLesson2.getSkrotTeacher1())))) {
                                /* gdy zgadzają się oddziały a różni nauczyciele*/
                                /* dodanie drugiej lekcji Inf*/
   //                             informacja.add("Łączę grupy Inf");
                                ourComlpeteLesson1.setSkrotSubject2(ourComlpeteLesson2.getSkrotSubject1());
                                ourComlpeteLesson2.setSkrotSubject2(ourComlpeteLesson1.getSkrotSubject1());
                                ourComlpeteLesson1.setSkrotTeacher2(ourComlpeteLesson2.getSkrotTeacher1());
                                ourComlpeteLesson2.setSkrotTeacher2(ourComlpeteLesson1.getSkrotTeacher1());
                                waga = ourComlpeteLesson1.getWaga();
                                ourComlpeteLesson1.setWaga(waga + wagaLaczonychGrup2Inf);
                                mCompleteLessons.add(ourComlpeteLesson1);
                                break;

                            }
                        }

                    }
                }
            }
        }  /* koniec łączenia Inf*/
        /*Łaczenie grup Języków obcych*/
        for (int n = 0; n < (listaJezykow.length); n++) {
            ourLanguage = listaJezykow[n];
    //        informacja.add("znalazłem język " + ourLanguage);
            for (int i = 0; i < CompleteLessonList.size(); i++) {
                ourComlpeteLesson1 = CompleteLessonList.get(i);
                if ((ourComlpeteLesson1.getSkrotSubject2().isEmpty()) && (ourComlpeteLesson1.getSkrotSubject1().equals(ourLanguage + "1"))) {
                    /* Gdy nie ma 2 przedmiotu a pierwszy jest Język1*/
                    for (int j = 0; j < CompleteLessonList.size(); j++) {
                        ourComlpeteLesson2 = CompleteLessonList.get(j);
                        if ((ourComlpeteLesson2.getSkrotSubject2().isEmpty()) && (ourComlpeteLesson2.getSkrotSubject1().equals(ourLanguage + "2"))) {
                            if ((ourComlpeteLesson1.getOddzial1().equals(ourComlpeteLesson2.getOddzial1()) && !(ourComlpeteLesson1.getSkrotTeacher1().equals(ourComlpeteLesson2.getSkrotTeacher1())))) {
                                /* gdy zgadzają się oddziały a różni nauczyciele*/
                                /* dodanie drugiej lekcji Języka*/
                                ourComlpeteLesson1.setSkrotSubject2(ourComlpeteLesson2.getSkrotSubject1());
                                ourComlpeteLesson2.setSkrotSubject2(ourComlpeteLesson1.getSkrotSubject1());
                                ourComlpeteLesson1.setSkrotTeacher2(ourComlpeteLesson2.getSkrotTeacher1());
                                ourComlpeteLesson2.setSkrotTeacher2(ourComlpeteLesson1.getSkrotTeacher1());
                                waga = ourComlpeteLesson1.getWaga();
                                ourComlpeteLesson1.setWaga(waga + wagaLaczonychGrup2JO);
                                mCompleteLessons.add(ourComlpeteLesson1);
                                break;

                            }
                        }

                    }
                }
            }
        }/*Koniec łaczenia języków*/
        /*Łaczenie grup Języków obcych z WF */
        for (int n = 0; n < (listaJezykow.length); n++) {
            ourLanguage = listaJezykow[n];
   //         informacja.add("znalazłem język " + ourLanguage);
            for (int i = 0; i < CompleteLessonList.size(); i++) {
                ourComlpeteLesson1 = CompleteLessonList.get(i);
                if ((ourComlpeteLesson1.getSkrotSubject2().isEmpty()) && (ourComlpeteLesson1.getSkrotSubject1().equals(ourLanguage + "1"))) {
                    /* Gdy nie ma 2 przedmiotu a pierwszy jest Język1*/
                    for (int j = 0; j < CompleteLessonList.size(); j++) {
                        ourComlpeteLesson2 = CompleteLessonList.get(j);
                        if ((ourComlpeteLesson2.getSkrotSubject2().isEmpty()) && (ourComlpeteLesson2.getSkrotSubject1().equals("WF2"))) {
                            if ((ourComlpeteLesson1.getOddzial1().equals(ourComlpeteLesson2.getOddzial1()) && !(ourComlpeteLesson1.getSkrotTeacher1().equals(ourComlpeteLesson2.getSkrotTeacher1())))) {
                                /* gdy zgadzają się oddziały a różni nauczyciele*/
                                /* dodanie drugiej lekcji WF do języka*/
                                ourComlpeteLesson1.setSkrotSubject2(ourComlpeteLesson2.getSkrotSubject1());
                                ourComlpeteLesson2.setSkrotSubject2(ourComlpeteLesson1.getSkrotSubject1());
                                ourComlpeteLesson1.setSkrotTeacher2(ourComlpeteLesson2.getSkrotTeacher1());
                                ourComlpeteLesson2.setSkrotTeacher2(ourComlpeteLesson1.getSkrotTeacher1());
                                waga = ourComlpeteLesson2.getWaga();
                                ourComlpeteLesson1.setWaga(waga + wagaLaczonychGrupWFzJO);
                                mCompleteLessons.add(ourComlpeteLesson1);
                                break;

                            }
                        }

                    }
                }
                if ((ourComlpeteLesson1.getSkrotSubject2().isEmpty()) && (ourComlpeteLesson1.getSkrotSubject1().equals(ourLanguage + "2"))) {
                    /* Gdy nie ma 2 przedmiotu a pierwszy jest Język1*/
                    for (int j = 0; j < CompleteLessonList.size(); j++) {
                        ourComlpeteLesson2 = CompleteLessonList.get(j);
                        if ((ourComlpeteLesson2.getSkrotSubject2().isEmpty()) && (ourComlpeteLesson2.getSkrotSubject1().equals("WF1"))) {
                            if ((ourComlpeteLesson1.getOddzial1().equals(ourComlpeteLesson2.getOddzial1()) && !(ourComlpeteLesson1.getSkrotTeacher1().equals(ourComlpeteLesson2.getSkrotTeacher1())))) {
                                /* gdy zgadzają się oddziały a różni nauczyciele*/
                                /* dodanie drugiej lekcji WF do języka*/
                                ourComlpeteLesson1.setSkrotSubject2(ourComlpeteLesson2.getSkrotSubject1());
                                ourComlpeteLesson2.setSkrotSubject2(ourComlpeteLesson1.getSkrotSubject1());
                                ourComlpeteLesson1.setSkrotTeacher2(ourComlpeteLesson2.getSkrotTeacher1());
                                ourComlpeteLesson2.setSkrotTeacher2(ourComlpeteLesson1.getSkrotTeacher1());
                                waga = ourComlpeteLesson2.getWaga();
                                ourComlpeteLesson2.setWaga(waga + wagaLaczonychGrupWFzJO);
                                mCompleteLessons.add(ourComlpeteLesson2);
                                break;

                            }
                        }

                    }
                }
            }
        }/*Koniec łaczenia języków z WF*/
        /*Łaczenie grup Języków obcych z Inf */
        for (int n = 0; n < (listaJezykow.length); n++) {
            ourLanguage = listaJezykow[n];
 //           informacja.add("znalazłem język " + ourLanguage);
            for (int i = 0; i < CompleteLessonList.size(); i++) {
                ourComlpeteLesson1 = CompleteLessonList.get(i);
                if ((ourComlpeteLesson1.getSkrotSubject2().isEmpty()) && (ourComlpeteLesson1.getSkrotSubject1().equals(ourLanguage + "1"))) {
                    /* Gdy nie ma 2 przedmiotu a pierwszy jest Język1*/
                    for (int j = 0; j < CompleteLessonList.size(); j++) {
                        ourComlpeteLesson2 = CompleteLessonList.get(j);
                        if ((ourComlpeteLesson2.getSkrotSubject2().isEmpty()) && (ourComlpeteLesson2.getSkrotSubject1().equals("Inf2"))) {
                            if ((ourComlpeteLesson1.getOddzial1().equals(ourComlpeteLesson2.getOddzial1()) && !(ourComlpeteLesson1.getSkrotTeacher1().equals(ourComlpeteLesson2.getSkrotTeacher1())))) {
                                /* gdy zgadzają się oddziały a różni nauczyciele*/
                                /* dodanie drugiej lekcji Inf do języka*/
                                ourComlpeteLesson1.setSkrotSubject2(ourComlpeteLesson2.getSkrotSubject1());
                                ourComlpeteLesson2.setSkrotSubject2(ourComlpeteLesson1.getSkrotSubject1());
                                ourComlpeteLesson1.setSkrotTeacher2(ourComlpeteLesson2.getSkrotTeacher1());
                                ourComlpeteLesson2.setSkrotTeacher2(ourComlpeteLesson1.getSkrotTeacher1());
                                waga = ourComlpeteLesson1.getWaga();
                                ourComlpeteLesson1.setWaga(waga + wagaLaczonychGrupJOzInf);
                                mCompleteLessons.add(ourComlpeteLesson1);
                                break;

                            }
                        }

                    }
                }
                if ((ourComlpeteLesson1.getSkrotSubject2().isEmpty()) && (ourComlpeteLesson1.getSkrotSubject1().equals(ourLanguage + "2"))) {
                    /* Gdy nie ma 2 przedmiotu a pierwszy jest Język1*/
                    for (int j = 0; j < CompleteLessonList.size(); j++) {
                        ourComlpeteLesson2 = CompleteLessonList.get(j);
                        if ((ourComlpeteLesson2.getSkrotSubject2().isEmpty()) && (ourComlpeteLesson2.getSkrotSubject1().equals("Inf1"))) {
                            if ((ourComlpeteLesson1.getOddzial1().equals(ourComlpeteLesson2.getOddzial1()) && !(ourComlpeteLesson1.getSkrotTeacher1().equals(ourComlpeteLesson2.getSkrotTeacher1())))) {
                                /* gdy zgadzają się oddziały a różni nauczyciele*/
                                /* dodanie drugiej lekcji Inf do języka*/
                                ourComlpeteLesson1.setSkrotSubject2(ourComlpeteLesson2.getSkrotSubject1());
                                ourComlpeteLesson2.setSkrotSubject2(ourComlpeteLesson1.getSkrotSubject1());
                                ourComlpeteLesson1.setSkrotTeacher2(ourComlpeteLesson2.getSkrotTeacher1());
                                ourComlpeteLesson2.setSkrotTeacher2(ourComlpeteLesson1.getSkrotTeacher1());
                                waga = ourComlpeteLesson1.getWaga();
                                ourComlpeteLesson2.setWaga(waga + wagaLaczonychGrupJOzInf);
                                mCompleteLessons.add(ourComlpeteLesson2);
                                break;

                            }
                        }

                    }
                }
            }
        }/*Koniec łaczenia języków z Inf*/
        /*Łączenie WF z Inf*/
        for (int i = 0; i < CompleteLessonList.size(); i++) {
            ourComlpeteLesson1 = CompleteLessonList.get(i);
            if ((ourComlpeteLesson1.getSkrotSubject2().isEmpty()) && (ourComlpeteLesson1.getSkrotSubject1().equals("WF1"))) {
//                informacja.add("Znalazłem WF1 bez drugiego przedmiotu");
                /* Gdy nie ma 2 przedmiotu a pierwszy jest WF1*/
                for (int j = 0; j < CompleteLessonList.size(); j++) {
                    ourComlpeteLesson2 = CompleteLessonList.get(j);
                    if ((ourComlpeteLesson2.getSkrotSubject2().isEmpty()) && (ourComlpeteLesson2.getSkrotSubject1().equals("Inf2"))) {
                        if ((ourComlpeteLesson1.getOddzial1().equals(ourComlpeteLesson2.getOddzial1()) && !(ourComlpeteLesson1.getSkrotTeacher1().equals(ourComlpeteLesson2.getSkrotTeacher1())))) {
                            /* gdy zgadzają się oddziały a różni nauczyciele*/
                            /* dodanie Inf do lekcji WF*/
  //                          informacja.add("Łączę grupy WF");
                            ourComlpeteLesson1.setSkrotSubject2(ourComlpeteLesson2.getSkrotSubject1());
                            ourComlpeteLesson2.setSkrotSubject2(ourComlpeteLesson1.getSkrotSubject1());
                            ourComlpeteLesson1.setSkrotTeacher2(ourComlpeteLesson2.getSkrotTeacher1());
                            ourComlpeteLesson2.setSkrotTeacher2(ourComlpeteLesson1.getSkrotTeacher1());
                            waga = ourComlpeteLesson1.getWaga();
                            ourComlpeteLesson1.setWaga(waga + wagaLaczonychGrupWFzInf);
                            mCompleteLessons.add(ourComlpeteLesson1);
                            break;

                        }
                    }

                }
            }
            if ((ourComlpeteLesson1.getSkrotSubject2().isEmpty()) && (ourComlpeteLesson1.getSkrotSubject1().equals("WF2"))) {
    //            informacja.add("Znalazłem WF1 bez drugiego przedmiotu");
                /* Gdy nie ma 2 przedmiotu a pierwszy jest WF1*/
                for (int j = 0; j < CompleteLessonList.size(); j++) {
                    ourComlpeteLesson2 = CompleteLessonList.get(j);
                    if ((ourComlpeteLesson2.getSkrotSubject2().isEmpty()) && (ourComlpeteLesson2.getSkrotSubject1().equals("Inf1"))) {
                        if ((ourComlpeteLesson1.getOddzial1().equals(ourComlpeteLesson2.getOddzial1()) && !(ourComlpeteLesson1.getSkrotTeacher1().equals(ourComlpeteLesson2.getSkrotTeacher1())))) {
                            /* gdy zgadzają się oddziały a różni nauczyciele*/
                            /* dodanie Inf do lekcji WF*/
   //                         informacja.add("Łączę grupy WF");
                            ourComlpeteLesson1.setSkrotSubject2(ourComlpeteLesson2.getSkrotSubject1());
                            ourComlpeteLesson2.setSkrotSubject2(ourComlpeteLesson1.getSkrotSubject1());
                            ourComlpeteLesson1.setSkrotTeacher2(ourComlpeteLesson2.getSkrotTeacher1());
                            ourComlpeteLesson2.setSkrotTeacher2(ourComlpeteLesson1.getSkrotTeacher1());
                            waga = ourComlpeteLesson1.getWaga();
                            ourComlpeteLesson2.setWaga(waga + wagaLaczonychGrupWFzInf);
                            mCompleteLessons.add(ourComlpeteLesson2);
                            break;

                        }
                    }

                }
            }

        }  /* koniec łączenia WF z Inf*/
        /*dodaję do completelesson lekcje nie polaczone lub nielaczone*/
        for (int i = 0; i < CompleteLessonList.size(); i++) {
            if (CompleteLessonList.get(i).getSkrotSubject2().isEmpty()) {
                ourComlpeteLesson1 = CompleteLessonList.get(i);
                int staraWaga = ourComlpeteLesson1.getWaga();
                waga = wagaReszta;
                if (ourComlpeteLesson1.getSkrotSubject1().equals("WF")) {
                    waga = wagaWF;
                }
                if (ourComlpeteLesson1.getSkrotSubject1().equals("WF1")) {
                    waga = wagaNieLaczonychGrup;
                }
                if (ourComlpeteLesson1.getSkrotSubject1().equals("WF2")) {
                    waga = wagaNieLaczonychGrup;
                }
                if (ourComlpeteLesson1.getSkrotSubject1().equals("Inf")) {
                    waga = wagaInf;
                }
                if (ourComlpeteLesson1.getSkrotSubject1().equals("Inf1")) {
                    waga = wagaNieLaczonychGrup;
                }
                if (ourComlpeteLesson1.getSkrotSubject1().equals("Inf2")) {
                    waga = wagaNieLaczonychGrup;
                }
                if (ourComlpeteLesson1.getSkrotSubject1().equals("Nz")) {
                    waga = wagaNz;
                }
                if ((ourComlpeteLesson1.getNameYear() < 4) && this.getSchoolType().equals("primary") && (ourComlpeteLesson1.getSkrotSubject1().equals("Rel"))) {
                    waga = wagaRel13;
                }
                for (int j = 0; j < (listaJezykow.length); j++) {
                    ourLanguage = listaJezykow[j];
                    if ((ourComlpeteLesson1.getSkrotSubject1().equals(ourLanguage+"1"))||(ourComlpeteLesson1.getSkrotSubject1().equals(ourLanguage+"2"))){
                        waga=wagaNieLaczonychGrup;
                    }
                }
                ourComlpeteLesson1.setWaga(staraWaga + waga);
                mCompleteLessons.add(ourComlpeteLesson1);

            }
        }
        for (int i = 0; i < CompleteLessonList.size(); i++) {
            ourComlpeteLesson1 = CompleteLessonList.get(i);
  //          informacja.add(ourComlpeteLesson1.getOddzial1() + "Przedmiot " + ourComlpeteLesson1.getSkrotSubject1() + ourComlpeteLesson1.getSkrotTeacher1() + "Przedmiot " + ourComlpeteLesson1.getSkrotSubject2() + ourComlpeteLesson1.getSkrotTeacher2() + " " + ourComlpeteLesson1.getWaga());
        }
//        informacja.add("");
//        informacja.add("Wyswietlam prawidłowe Kompletne lekcje");
        for (int i = 0; i < mCompleteLessons.size(); i++) {
            ourComlpeteLesson1 = mCompleteLessons.get(i);
 //           informacja.add((i + 1) + " " + ourComlpeteLesson1.getOddzial1() + "Przedmiot " + ourComlpeteLesson1.getSkrotSubject1() + ourComlpeteLesson1.getSkrotTeacher1() + "Przedmiot " + ourComlpeteLesson1.getSkrotSubject2() + ourComlpeteLesson1.getSkrotTeacher2() + " " + ourComlpeteLesson1.getWaga());
        }
   
    }
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.A299ED6C-5655-75A7-6C50-1A14F05D28D1]
// </editor-fold> 

    public School() {
        this.schoolType = "primary";
        this.maxDayHours = 5;
        this.mClassroom = new ArrayList<Classroom>();
        this.mTeacher = new ArrayList<Teacher>();
        this.mSchoolYear = new ArrayList<SchoolYear>();
        this.mSchoolGroups = new ArrayList<SchoolGroup>();
        this.mSchoolSubjects = new ArrayList<SchoolSubject>();
        this.mLanguages = new ArrayList<Language>();
        this.mLesson = new ArrayList<Lesson>();
        this.mCompleteLessons = new ArrayList<CompleteLesson>();
        this.mPoprawnoscPrzedmiotows = new ArrayList<PoprawnoscPrzedmiotow>();
        this.mPoprawnoscOddzialows = new PoprawnoscOddzialow(0);
        this.informacja = new ArrayList<String>();
        this.defaultPrimaryYears();

        this.primaryRoomTypes[0] = "Ogólnodostępna";
        this.primaryRoomTypes[1] = "Nauczanie zintegrowane";
        this.primaryRoomTypes[2] = "Religia";
        this.primaryRoomTypes[3] = "Język polski";
        this.primaryRoomTypes[4] = "Historia i społeczeństwo";
        this.primaryRoomTypes[5] = "Matematyka";
        this.primaryRoomTypes[6] = "Przyroda";
        this.primaryRoomTypes[7] = "Muzyka";
        this.primaryRoomTypes[8] = "Plastyka";
        this.primaryRoomTypes[9] = "Technika";
        this.primaryRoomTypes[10] = "Informatyka";
        this.primaryRoomTypes[11] = "WF";
        this.primaryRoomTypes[12] = "Język obcy";
        this.gymnasiumRoomTypes[0] = "Ogólnodostępna";
        this.gymnasiumRoomTypes[1] = "Język polski";
        this.gymnasiumRoomTypes[2] = "Historia";
        this.gymnasiumRoomTypes[3] = "Wiedza o społeczeństwie";
        this.gymnasiumRoomTypes[4] = "Matematyka";
        this.gymnasiumRoomTypes[5] = "Fizyka i astronomia";
        this.gymnasiumRoomTypes[6] = "Chemia";
        this.gymnasiumRoomTypes[7] = "Biologia";
        this.gymnasiumRoomTypes[8] = "Geografia";
        this.gymnasiumRoomTypes[9] = "Plastyka";
        this.gymnasiumRoomTypes[10] = "Muzyka";
        this.gymnasiumRoomTypes[11] = "Technika";
        this.gymnasiumRoomTypes[12] = "Informatyka";
        this.gymnasiumRoomTypes[13] = "WF";
        this.gymnasiumRoomTypes[14] = "Język obcy";
        this.gymnasiumRoomTypes[15] = "Religia";


        this.classRoomTypes = this.primaryRoomTypes;
    }
}

