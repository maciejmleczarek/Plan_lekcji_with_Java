/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generowaniePlanu;

import strukturaszkoly.School;
import strukturaszkoly.CompleteLesson;

import interfejsuzytkownika.wwprowadz;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JTextArea;
import strukturaszkoly.Classroom;
import strukturaszkoly.Language;
import strukturaszkoly.SchoolGroup;

/**
 *
 * @author Administrator
 */
public class GenerowanyPlan implements Serializable {

    School school;
    private List<CompleteLesson> mCompleteLessons;
    private List<RekordPlanu> mRekordyPlanu;
    private List<Plan> mAktualneRekordyPlanu;
    private List<Plan> mPlany;
    private boolean[] mPomocniczeRekordyPlanu1;
    private boolean[] mPomocniczeRekordyPlanu2;
    private int[] kary;
    private int kara = 0;
    private int karaPomocnicza;
    private int maxKara = 10000;
    private int liczbaOkienek;
    private int[] okienka;
    private boolean[] godziny;
    private int[] dni;
    private boolean poprawnoscPlanu = false;
    private int przesuniecie;
    private List<Integer> dostepnoscPrzesuniec;
    private int obnizenieKar;
    private int pozycja = 0;
    private int pozycja2 = 0;
    private ArrayList<String> informacja;

    public GenerowanyPlan() {
        this.mRekordyPlanu = new ArrayList<RekordPlanu>();
        this.mAktualneRekordyPlanu = new ArrayList<Plan>();
        this.mPlany = new ArrayList<Plan>();
        this.dni = new int[5];
        this.informacja = new ArrayList<String>();


    }
    /*Pobiera informacje*/

    public List getInformacja() {
        return this.informacja;
    }
    /*ustawia strukture szkoly*/

    public void setSchool(School val) {
        this.school = val;
    }
    /*pobiera strukture szkoly*/

    public School getSchool() {
        return this.school;
    }
    /*pobiera poprawnosc planu */

    public boolean getPoprawnoscPlanu() {
        return this.poprawnoscPlanu;
    }
    /*ustawia poprawnosc planu*/

    public void setPoprawnoscPlanu(boolean val) {
        this.poprawnoscPlanu = val;
    }

    public void getTekst() {
        informacja.add("Generowanie planu, proszę czekać...");

    }
    /*ustawia kompletne lekcje*/

    public void setCompleteLessons() {
        mCompleteLessons = this.school.getCompleteLessons();

    }
    /*pobiera kompletne lekcje*/

    public List getComleteLessons() {
        return mCompleteLessons;
    }
    /*sortuje lekcje wg ich wagi*/

    public void sortowanie(List<CompleteLesson> a, int lo, int hi) {
        int i = lo, j = hi;
        CompleteLesson x = a.get((lo + hi) / 2), h;
        do {
            while (a.get(i).getWaga() < x.getWaga()) {
                i++;
            }
            while (a.get(j).getWaga() > x.getWaga()) {
                j--;
            }
            if (i <= j) {
                h = a.get(i);
                a.set(i, a.get(j));
                a.set(j, h);
                i++;
                j--;

            }

        } while (i <= j);
        if (lo < j) {
            sortowanie(a, lo, j);
        }
        if (i < hi) {
            sortowanie(a, i, hi);
        }
    }
    /*pobiera plan do wyswietlenia*/

    public List getPlan() {
        return this.mPlany;
    }
    /*pobiera rekordy planu*/

    public List getRekordyPlanu() {
        return this.mRekordyPlanu;
    }
    /*ustawia rekordy planu*/

    public void setRekordyPlanu(List val) {
        this.mRekordyPlanu = val;
    }
    /*pomocnicze - wyswietla liste nieuporzadkowanych lekcji*/

    public void wyswietlLesson() {
        System.out.println("Lista nieuporządkowana w hierarchii");
        for (int i = 0; i < mCompleteLessons.size(); i++) {
            System.out.println(mCompleteLessons.get(i).getOddzial1() + " " + mCompleteLessons.get(i).getSkrotSubject1() + " " + mCompleteLessons.get(i).getWaga());
        }
        System.out.println("Koniec zajęć");
    }
    /*ustawia puste rekordy planu*/

    public void setPusteRekordyPlanu() {
        Classroom ourClassRoom;
        mRekordyPlanu.removeAll(mRekordyPlanu);
        for (int d = 1; d < 6; d++) {
            for (int g = 1; g <= this.school.getMaxDayHours(); g++) {
                for (int s = 0; s < this.school.getClassroom().size(); s++) {
                    ourClassRoom = (Classroom) this.school.getClassroom().get(s);
                    mRekordyPlanu.add(new RekordPlanu(d, g, null, ourClassRoom));
                }
            }
        }
    //  System.out.println("Wielkość pustej listy rekordów " + this.mRekordyPlanu.size());
    }
    /*ustawia puste pomocnicze rekordy planu - potrzebne w generuj()*/

    public void setPustePomocniczeRekordyPlanu() {
        for (int i = 0; i < mRekordyPlanu.size(); i++) {
            mPomocniczeRekordyPlanu1[i] = true;
            mPomocniczeRekordyPlanu2[i] = true;
        }
    }
    /*zeruje kary w generuj()*/

    public void setPusteKaryIPrzesuniecia() {
        for (int i = 0; i < mRekordyPlanu.size(); i++) {
            kary[i] = 0;
//            dostepnoscPrzesuniecGrup[i]=0;
        }
    }

    /*sprawdza czy danego dnia o danej godzinie dana sala jest dostepna*/
    public void sprawdzDostepnoscDniaGodzinySali() {
        for (int i = 0; i < this.mRekordyPlanu.size(); i++) {
            if (mRekordyPlanu.get(i).getOurLesson() != null) {
                mPomocniczeRekordyPlanu1[i] = false;
                mPomocniczeRekordyPlanu2[i] = false;
            }
        }
    //    return mPomocniczeRekordyPlanu;
    }
    /*liczy okienka dla oddzialow*/

    public void liczOkienka() {
        SchoolGroup ourGroup;
        String nazwaGrupy;
        zerujOkienka();
        liczbaOkienek = 0;

        for (int i = 0; i < this.school.getSchoolGroup().size(); i++) {
            ourGroup = (SchoolGroup) this.school.getSchoolGroup().get(i);
            nazwaGrupy = ourGroup.getCompleteGroupName();
            sprawdzanieOkienekOddzial(nazwaGrupy);
            for (int n = 0; n < 5; n++) {
                okienka[i] = okienka[i] + dni[n];
            }
            liczbaOkienek = liczbaOkienek + okienka[i];
        //           System.out.println("Odzial " + nazwaGrupy + " ma " + okienka[i] + "okienek");

        }
    }
    /*wybiera najlepszy wygenerowany plan pod wzgledem ilosci okienek */

    public void algorytm() {
        this.informacja.removeAll(informacja);
        obnizenieKar = 0;
        liczbaOkienek = 0;
        int podejscie = 0;
        int maxOkienek = 1000;
        int aktualnaLiczbaOkienek = maxOkienek;
        this.okienka = new int[this.school.getSchoolGroup().size()];
        mAktualneRekordyPlanu.removeAll(mAktualneRekordyPlanu);
        
        for (int i = 0; i < 500; i++) {
            generuj();
            if (mCompleteLessons.size() == this.getPlan().size()) {
                liczOkienka();
            //    informacja.add("Podejscie nr " + (i + 1));
                System.out.println("Liczba okienek = " + liczbaOkienek + " aktualne =" + aktualnaLiczbaOkienek);
                if ((liczbaOkienek < aktualnaLiczbaOkienek)) {
                    aktualnaLiczbaOkienek = liczbaOkienek;
                    mAktualneRekordyPlanu.removeAll(mAktualneRekordyPlanu);
                    mAktualneRekordyPlanu.addAll(mPlany);
                    podejscie = i + 1;
                    System.out.println("Podejscie nr " + podejscie);
            //        informacja.add("wybieram podejscie " + (i + 1));
                    if (liczbaOkienek == 0) {
                        break;
                    //     System.out.println("liczba okienek wynosi " + liczbaOkienek);
                    }
                }

            }
        }
        System.out.println("Aktualna liczba okienek wynosi " + aktualnaLiczbaOkienek);
//        informacja.add("   Najlepsze podejscie nr " + podejscie);
        mPlany.removeAll(mPlany);
        mPlany.addAll(mAktualneRekordyPlanu);
        System.out.println("coplete size " + mCompleteLessons.size());

        //   tworzenieTabeliplanu();
        System.out.println("Liczba karteczek " + this.getPlan().size());
        if (mCompleteLessons.size() == this.getPlan().size()) {
            this.setPoprawnoscPlanu(true);
            this.informacja.add("Plan został poprawnie ułożony.");
            this.informacja.add("Liczba okienek wynosi " + aktualnaLiczbaOkienek + ".");
            if (aktualnaLiczbaOkienek != 0) {
                this.informacja.add("Jeżeli liczba okienek jest zbyt wielka ponownie generuj plan.");
            }
        } else {
            this.setPoprawnoscPlanu(false);
            this.informacja.add("Nie udało się poprawnie ułożyć planu, spróbuj generować jeszcze raz");
            this.informacja.add("liczba complete " + mCompleteLessons.size() + " liczba rekordow planu " + this.getPlan().size());
        }

    }
    /*generuje plan*/

    public void generuj() {
        CompleteLesson ourLesson;
        String oddzial1;
        // String oddzial2;

        String przedmiot1;
        String nauczyciel1;
        String przedmiot2;
        String nauczyciel2;
        String zawartosc;
        String zawartosc1;
        String zawartosc2;
        int p;
        int p2;
        Random losowe = new Random();
        setPusteRekordyPlanu();
        mPomocniczeRekordyPlanu1 = new boolean[mRekordyPlanu.size()];
        mPomocniczeRekordyPlanu2 = new boolean[mRekordyPlanu.size()];
        dostepnoscPrzesuniec = new ArrayList<Integer>();

        this.kary = new int[mRekordyPlanu.size()];
        int n = 0;
        this.mPlany.removeAll(mPlany);
        for (int i = (mCompleteLessons.size()) - 1; i >= 0; i--) {
            setPustePomocniczeRekordyPlanu();
            setPusteKaryIPrzesuniecia();
            pozycja = 0;
            pozycja2 = 0;
            ourLesson = mCompleteLessons.get(i);
            oddzial1 = ourLesson.getOddzial1();
            przedmiot1 = ourLesson.getSkrotSubject1();
            nauczyciel1 = ourLesson.getSkrotTeacher1();
            przedmiot2 = ourLesson.getSkrotSubject2();
            nauczyciel2 = ourLesson.getSkrotTeacher2();
            /*wspolne*/

            sprawdzDostepnoscDniaGodzinySali(); 

            sprawdzDostepnoscCzasuOddzialu(oddzial1); 

            sprawdzDostepnoscCzasuNauczyciela(nauczyciel1);  

            nadajKaryDostepnosciDniIGodzinOddzialu(oddzial1);

            if (!przedmiot1.equals("Nz")) {
                nadajKaryDostepnosciDniIGodzinPrzedmiotu(oddzial1, przedmiot1);

                nadajKaryDostepnosciTypowSali(przedmiot1); 

            }
            nadajKareGodzin(); 

            nadajKareDni(oddzial1);
            /*tylko niedzielone*/
            if (ourLesson.getSkrotSubject2().isEmpty()) {
                sprawdzDostepnoscTypuSaliInformatyki(przedmiot1); 

                nadajKaryNielaczonychGrup(przedmiot1);
                sprawdzDostepnoscTypuSaliWF(przedmiot1);

                sprawdzDostepnoscTypuSaliNZ(przedmiot1);

                sprawdzTaSamaSalaDlaNz(oddzial1);

                nadajKareWF(przedmiot1); 


                /*koniec sprawdzania dla niedzielonych*/



                kara = maxKara;
                dostepnoscPrzesuniec.removeAll(dostepnoscPrzesuniec);
                for (p = 0; p < mPomocniczeRekordyPlanu1.length; p++) { //wybor najlepszej pozycji

                    if (mPomocniczeRekordyPlanu1[p] == true) {
                        if (kary[p] < kara) {
                            kara = kary[p];
                            pozycja = p;

                        //      System.out.println("Tymczasowo ustawiam karę dla pozycji " + p + " wynosi " + kara + " dzien " + mRekordyPlanu.get(p).getDzien() + " Godzina " + mRekordyPlanu.get(p).getGodzina() + " sala " + mRekordyPlanu.get(p).getOurClassRoom().getName());
                        }
                    //          System.out.println("sprawdzałem pozycję " + p + "o karze " + kary[p]);

                    }
                }
                //       System.out.println("ustawiam pozycje poczatkowa na "+pozycja);
                if ((ourLesson.getNameYear() > 3) || (!this.school.getSchoolType().equals("primary"))) {
                    for (int a = 0; a < mPomocniczeRekordyPlanu1.length; a++) {
                        if (mPomocniczeRekordyPlanu1[a] == true) {
                            if (kara == kary[a]) {
                                dostepnoscPrzesuniec.add(a);
                            }
                        }
                    }
                    n = dostepnoscPrzesuniec.size();
                    if (n == 0) {
                        break;
                    //       System.out.println("liczba dostepnych pozycji = " + n);
                    }
                    przesuniecie = losowe.nextInt(n);

                    pozycja = dostepnoscPrzesuniec.get(przesuniecie);
                }
                mRekordyPlanu.get(pozycja).setOurLesson(ourLesson);
                zawartosc = mRekordyPlanu.get(pozycja).getOurLesson().getOddzial1() + " " + mRekordyPlanu.get(pozycja).getOurLesson().getSkrotSubject1() + " " + mRekordyPlanu.get(pozycja).getOurLesson().getSkrotTeacher1() + " s. " + mRekordyPlanu.get(pozycja).getOurClassRoom().getName();
                this.mPlany.add(new Plan(mRekordyPlanu.get(pozycja).getOurLesson().getOddzial1(), mRekordyPlanu.get(pozycja).getDzien(), mRekordyPlanu.get(pozycja).getGodzina() - 1, zawartosc));
            /*koniec ukladania dla niedzielonych*/



            } else {
                /*tylko dzielone*/
                //  informacja.add("znalazlem laczony przedmiot");
                sprawdzDostepnoscCzasuNauczyciela(nauczyciel2); 

                nadajKaryDostepnosciDniIGodzinPrzedmiotu(oddzial1, przedmiot2);

                nadajKaryDostepnosciTypowSali(przedmiot2); 

                nadajKareWFdzielone(przedmiot1, przedmiot2);

                sprawdzDostepnoscTypuSaliInfLubWFDlaDzielonych(przedmiot1, przedmiot2);
                sprawdzKiedyMoznaWsadzicOdzialDzielony();
                kara = maxKara;

                for (p = 0; p < mPomocniczeRekordyPlanu1.length; p++) { //wybor najlepszej pozycji

                    if (mPomocniczeRekordyPlanu1[p] == true) {

                        for (p2 = 0; p2 < mPomocniczeRekordyPlanu2.length; p2++) {
                            if ((mPomocniczeRekordyPlanu2[p2] == true) && (p != p2) && (mRekordyPlanu.get(p).getDzien() == mRekordyPlanu.get(p2).getDzien()) && (mRekordyPlanu.get(p).getGodzina() == mRekordyPlanu.get(p2).getGodzina())) {
                                if ((kary[p] + kary[p2]) < kara) {
                                    kara = kary[p] + kary[p2];
                                    pozycja = p;
                                    pozycja2 = p2;

                                //      System.out.println("Tymczasowo ustawiam karę dla pozycji " + p + " wynosi " + kara + " dzien " + mRekordyPlanu.get(p).getDzien() + " Godzina " + mRekordyPlanu.get(p).getGodzina() + " sala " + mRekordyPlanu.get(p).getOurClassRoom().getName());
                                }
                            }
                        }

                    //          System.out.println("sprawdzałem pozycję " + p + "o karze " + kary[p]);

                    }
                }


                mRekordyPlanu.get(pozycja).setOurLesson(ourLesson);
                mRekordyPlanu.get(pozycja2).setOurLesson(ourLesson);
                //           informacja.add(mRekordyPlanu.get(pozycja).getOurLesson().getSkrotSubject1() + "pozyzja 1 = " + pozycja + " sala " + mRekordyPlanu.get(pozycja).getOurClassRoom().getName());
                //         informacja.add(mRekordyPlanu.get(pozycja2).getOurLesson().getSkrotSubject2() + "pozyzja 2 = " + pozycja2 + " sala " + mRekordyPlanu.get(pozycja2).getOurClassRoom().getName());
                zawartosc1 = mRekordyPlanu.get(pozycja).getOurLesson().getSkrotSubject1() + " " + mRekordyPlanu.get(pozycja).getOurLesson().getSkrotTeacher1() + " s. " + mRekordyPlanu.get(pozycja).getOurClassRoom().getName();
                zawartosc2 = mRekordyPlanu.get(pozycja2).getOurLesson().getSkrotSubject2() + " " + mRekordyPlanu.get(pozycja2).getOurLesson().getSkrotTeacher2() + " s. " + mRekordyPlanu.get(pozycja2).getOurClassRoom().getName();
                zawartosc = mRekordyPlanu.get(pozycja).getOurLesson().getOddzial1() + " " + zawartosc1 + " " + zawartosc2;
                this.mPlany.add(new Plan(mRekordyPlanu.get(pozycja).getOurLesson().getOddzial1(), mRekordyPlanu.get(pozycja).getDzien(), mRekordyPlanu.get(pozycja).getGodzina() - 1, zawartosc));


            }
        }
    }
    
    /*pomocnicze - wypisuje rekordy planu aby sprawdzic ilejest wolnych miejsc*/

    void wypiszRekordyPlanu() {
        int liczba = 0;
        int liczba2 = 0;
        for (int i = 0; i < mRekordyPlanu.size(); i++) {
            if (mRekordyPlanu.get(i).getOurLesson() != null) {
                liczba++;
                System.out.println("pozycja " + i + " oddzial " + mRekordyPlanu.get(i).ourLesson.getOddzial1() + mRekordyPlanu.get(i).getOurLesson().getSkrotSubject1());
            }
            if (mPomocniczeRekordyPlanu1[i] == true) {
                liczba2++;
            }
        }
        System.out.println("Liczba lekcji na planie = " + liczba);
        System.out.println("Liczba true w tablicy pomocniczej = " + liczba2);

    }
    /*sprawdza dostepnosc czasu nauczyciela*/

    public void sprawdzDostepnoscCzasuNauczyciela(String nauczyciel) {
        RekordPlanu ourRekordPlanu;
        RekordPlanu newRekordPlanu;
        int hisDay;
        int hisHour;
        for (int i = 0; i < this.mRekordyPlanu.size(); i++) {
            ourRekordPlanu = this.mRekordyPlanu.get(i);
            if (ourRekordPlanu.getOurLesson() != (null)) {
                if ((ourRekordPlanu.getOurLesson().getSkrotTeacher1().equals(nauczyciel)) || (ourRekordPlanu.getOurLesson().getSkrotTeacher2().equals(nauczyciel))) {
                    hisDay = ourRekordPlanu.getDzien();
                    hisHour = ourRekordPlanu.getGodzina();
                    for (int j = 0; j < this.mRekordyPlanu.size(); j++) {
                        newRekordPlanu = this.mRekordyPlanu.get(j);
                        if ((newRekordPlanu.getDzien() == hisDay) && (newRekordPlanu.getGodzina() == hisHour)) {
                            mPomocniczeRekordyPlanu1[j] = false;
                            mPomocniczeRekordyPlanu2[j] = false;
                        }
                    }
                }
            }
        }
    }
    /*sprawdza dostepnosc oddzialu*/

    public void sprawdzDostepnoscCzasuOddzialu(String oddzial) {
        RekordPlanu ourRekordPlanu;
        RekordPlanu newRekordPlanu;
        int hisDay;
        int hisHour;
        for (int i = 0; i < this.mRekordyPlanu.size(); i++) {
            ourRekordPlanu = this.mRekordyPlanu.get(i);
            if (ourRekordPlanu.getOurLesson() != (null)) {
                if ((ourRekordPlanu.getOurLesson().getOddzial1().equals(oddzial))) {
                    hisDay = ourRekordPlanu.getDzien();
                    hisHour = ourRekordPlanu.getGodzina();
                    for (int j = 0; j < this.mRekordyPlanu.size(); j++) {
                        newRekordPlanu = this.mRekordyPlanu.get(j);
                        if ((newRekordPlanu.getDzien() == hisDay) && (newRekordPlanu.getGodzina() == hisHour)) {
                            mPomocniczeRekordyPlanu1[j] = false;
                            mPomocniczeRekordyPlanu2[j] = false;
                        }
                    }
                }
            }
        }
    }
    /*sprawdza dostepnosc sali informatyki*/

    public void sprawdzDostepnoscTypuSaliInformatyki(String przedmiot) {
        RekordPlanu ourRekordPlanu;
        for (int i = 0; i < this.mRekordyPlanu.size(); i++) {
            ourRekordPlanu = this.mRekordyPlanu.get(i);

            if (((przedmiot.equals("Inf")) || (przedmiot.equals("Inf1")) || (przedmiot.equals("Inf2"))) && (!ourRekordPlanu.getOurClassRoom().getDestinyType().equals("Informatyka"))) {
                mPomocniczeRekordyPlanu1[i] = false;

            }
        //      if (((przedmiot.equals("Inf1"))||(przedmiot.equals("Inf2"))) && (!ourRekordPlanu.getOurClassRoom().getDestinyType().equals("Informatyka"))) {
        //        mPomocniczeRekordyPlanu[i] = false;

        //  }
        }
    }
    /*sprawdza dostepnosc sali wf*/

    public void sprawdzDostepnoscTypuSaliInfLubWFDlaDzielonych(String przedmiot1, String przedmiot2) {
        RekordPlanu ourRekordPlanu;
        for (int i = 0; i < this.mRekordyPlanu.size(); i++) {
            ourRekordPlanu = this.mRekordyPlanu.get(i);

            if ((przedmiot1.equals("Inf1")) && (!ourRekordPlanu.getOurClassRoom().getDestinyType().equals("Informatyka"))) {
                mPomocniczeRekordyPlanu1[i] = false;
            }
            if ((przedmiot2.equals("Inf2")) && (!ourRekordPlanu.getOurClassRoom().getDestinyType().equals("Informatyka"))) {
                mPomocniczeRekordyPlanu2[i] = false;
            }
            if ((przedmiot1.equals("WF1")) && (!ourRekordPlanu.getOurClassRoom().getDestinyType().equals("WF"))) {
                mPomocniczeRekordyPlanu1[i] = false;
            }
            if ((przedmiot2.equals("WF2")) && (!ourRekordPlanu.getOurClassRoom().getDestinyType().equals("WF"))) {
                mPomocniczeRekordyPlanu2[i] = false;
            }


        }
    }

    public void sprawdzKiedyMoznaWsadzicOdzialDzielony() {
        int liczbaPom1NaTrue;
        int liczbaPom2NaTrue;
        for (int d = 1; d <= 5; d++) {
            for (int g = 1; g <= this.school.getMaxDayHours(); g++) {
                liczbaPom1NaTrue = 0;
                liczbaPom2NaTrue = 0;
                for (int n = 0; n < mRekordyPlanu.size(); n++) {
                    if ((mRekordyPlanu.get(n).getDzien() == d) && (mRekordyPlanu.get(n).getGodzina() == g)) {
                        if (mPomocniczeRekordyPlanu1[n] == true) {
                            liczbaPom1NaTrue = liczbaPom1NaTrue + 1;
                        }
                        if (mPomocniczeRekordyPlanu2[n] == true) {
                            liczbaPom2NaTrue = liczbaPom2NaTrue + 1;
                        }
                    }
                }
                if ((liczbaPom1NaTrue == 0) || (liczbaPom2NaTrue == 0)) {
                    //    System.out.println("Znalazłem zły dzien " + d + " o godzinie " + g);
                    for (int n = 0; n < mRekordyPlanu.size(); n++) {
                        if ((mRekordyPlanu.get(n).getDzien() == d) && (mRekordyPlanu.get(n).getGodzina() == g)) {
                            mPomocniczeRekordyPlanu1[n] = false;
                            mPomocniczeRekordyPlanu2[n] = false;
                        }
                    }
                }

            }
        }



    }

    public void sprawdzDostepnoscTypuSaliWF(String przedmiot) {
        RekordPlanu ourRekordPlanu;
        for (int i = 0; i < this.mRekordyPlanu.size(); i++) {
            ourRekordPlanu = this.mRekordyPlanu.get(i);

            if (((przedmiot.equals("WF")) || (przedmiot.equals("WF1")) || (przedmiot.equals("WF2"))) && (!ourRekordPlanu.getOurClassRoom().getDestinyType().equals("WF"))) {
                mPomocniczeRekordyPlanu1[i] = false;

            }
        /*    if (((przedmiot.equals("WF1"))||(przedmiot.equals("WF2"))) && (!ourRekordPlanu.getOurClassRoom().getDestinyType().equals("WF"))) {
        mPomocniczeRekordyPlanu[i] = false;
        
        }*/
        }
    }
    /*sprawdza dostepnosc sali Nz*/

    public void sprawdzDostepnoscTypuSaliNZ(String przedmiot) {
        RekordPlanu ourRekordPlanu;
        String ourClassroom;
        for (int i = 0; i < this.mRekordyPlanu.size(); i++) {
            ourRekordPlanu = this.mRekordyPlanu.get(i);
            ourClassroom = ourRekordPlanu.getOurClassRoom().getName();
            if ((przedmiot.equals("Nz")) && (!ourRekordPlanu.getOurClassRoom().getDestinyType().equals("Nauczanie zintegrowane"))) {
                mPomocniczeRekordyPlanu1[i] = false;
            }
        }
    }
    /*ustawia aby oddzial mial Nz w tej samej sali*/

    public void sprawdzTaSamaSalaDlaNz(String oddzial1) {
        String numerSali;
        RekordPlanu ourRekord;
        for (int i = 0; i < mRekordyPlanu.size(); i++) {
            ourRekord = mRekordyPlanu.get(i);
            if (ourRekord.getOurLesson() != null) {
                if ((ourRekord.getOurLesson().getOddzial1().equals(oddzial1)) && (ourRekord.getOurLesson().getSkrotSubject1().equals("Nz"))) {
                    numerSali = ourRekord.getOurClassRoom().getName();
                    for (int n = 0; n < mRekordyPlanu.size(); n++) {
                        if (!mRekordyPlanu.get(n).getOurClassRoom().getName().equals(numerSali)) {
                            mPomocniczeRekordyPlanu1[n] = false;
                        }
                    //     }
                    }
                }

            }
        }
    }
    /*ustawia kary dla typow sali aby zgadzaly sie typy jezeli to mozliwe*/

    public void nadajKaryDostepnosciTypowSali(String przedmiot) {

        RekordPlanu ourRekord = null;
        String ourDestiny;
        String[] jobcy;
        int swlasciwa = 10;
        int sogolnod = 5;
        int swf = 600;
        int snz = 1000;
        int sinna = 10;
        jobcy = this.school.getLanguageNames();
        for (int i = 0; i < mRekordyPlanu.size(); i++) {
            ourRekord = mRekordyPlanu.get(i);
            ourDestiny = ourRekord.getOurClassRoom().getDestinyType();
            for (int n = 0; n < jobcy.length; n++) {
                if ((przedmiot.equals(jobcy[n])) || (przedmiot.equals(jobcy[n] + "1")) || (przedmiot.equals(jobcy[n] + "2"))) {
                    if (ourDestiny.equals("Język obcy")) {
                        kary[i] = kary[i] - swlasciwa;
                    } else if (ourDestiny.equals("Ogólnodostępna")) {
                        kary[i] = kary[i] + sogolnod;
                    } else if (ourDestiny.equals("Nauczanie zintegrowane")) {
                        kary[i] = kary[i] + snz;
                    } else if (ourDestiny.equals("WF")) {
                        kary[i] = kary[i] + swf;
                    } else {
                        kary[i] = kary[i] + sinna;
                    }

                }
            }
            if (przedmiot.equals("Rel")) {

                if (ourDestiny.equals("Religia")) {
                    kary[i] = kary[i] - swlasciwa;
                } else if (ourDestiny.equals("Ogólnodostępna")) {
                    kary[i] = kary[i] + sogolnod;
                } else if (ourDestiny.equals("Nauczanie zintegrowane")) {
                    kary[i] = kary[i] + snz;
                } else if (ourDestiny.equals("WF")) {
                    kary[i] = kary[i] + swf;
                } else {
                    kary[i] = kary[i] + sinna;
                }
            }
            if (przedmiot.equals("Jp")) {
                // System.out.println("nadaje kary polskiemu");
                if (ourDestiny.equals("Język polski")) {
                    kary[i] = kary[i] - swlasciwa;
                } else if (ourDestiny.equals("Ogólnodostępna")) {
                    kary[i] = kary[i] + sogolnod;
                } else if (ourDestiny.equals("Nauczanie zintegrowane")) {
                    kary[i] = kary[i] + snz;
                } else if (ourDestiny.equals("WF")) {
                    kary[i] = kary[i] + swf;
                } else {
                    kary[i] = kary[i] + sinna;
                }
            }

            if (przedmiot.equals("His")) {
                if ((ourDestiny.equals("Historia i społeczeństwo")) || (ourDestiny.equals("Historia"))) {
                    kary[i] = kary[i] - swlasciwa;
                } else if (ourDestiny.equals("Ogólnodostępna")) {
                    kary[i] = kary[i] + sogolnod;
                } else if (ourDestiny.equals("Nauczanie zintegrowane")) {
                    kary[i] = kary[i] + snz;
                } else if (ourDestiny.equals("WF")) {
                    kary[i] = kary[i] + swf;
                } else {
                    kary[i] = kary[i] + sinna;
                }
            }
            if (przedmiot.equals("Mat")) {
                if (ourDestiny.equals("Matematyka")) {
                    kary[i] = kary[i] - swlasciwa;
                } else if (ourDestiny.equals("Ogólnodostępna")) {
                    kary[i] = kary[i] + sogolnod;
                } else if (ourDestiny.equals("Nauczanie zintegrowane")) {
                    kary[i] = kary[i] + snz;
                } else if (ourDestiny.equals("WF")) {
                    kary[i] = kary[i] + swf;
                } else {
                    kary[i] = kary[i] + sinna;
                }
            }
            if (przedmiot.equals("Przyr")) {
                if (ourDestiny.equals("Przyroda")) {
                    kary[i] = kary[i] - swlasciwa;
                } else if (ourDestiny.equals("Ogólnodostępna")) {
                    kary[i] = kary[i] + sogolnod;
                } else if (ourDestiny.equals("Nauczanie zintegrowane")) {
                    kary[i] = kary[i] + snz;
                } else if (ourDestiny.equals("WF")) {
                    kary[i] = kary[i] + swf;
                } else {
                    kary[i] = kary[i] + sinna;
                }
            }
            if (przedmiot.equals("Muz")) {
                if (ourDestiny.equals("Muzyka")) {
                    kary[i] = kary[i] - swlasciwa;
                } else if (ourDestiny.equals("Ogólnodostępna")) {
                    kary[i] = kary[i] + sogolnod;
                } else if (ourDestiny.equals("Nauczanie zintegrowane")) {
                    kary[i] = kary[i] + snz;
                } else if (ourDestiny.equals("WF")) {
                    kary[i] = kary[i] + swf;
                } else {
                    kary[i] = kary[i] + sinna;
                }
            }
            if (przedmiot.equals("Plas")) {
                if (ourDestiny.equals("Plastyka")) {
                    kary[i] = kary[i] - swlasciwa;
                } else if (ourDestiny.equals("Ogólnodostępna")) {
                    kary[i] = kary[i] + sogolnod;
                } else if (ourDestiny.equals("Nauczanie zintegrowane")) {
                    kary[i] = kary[i] + snz;
                } else if (ourDestiny.equals("WF")) {
                    kary[i] = kary[i] + swf;
                } else {
                    kary[i] = kary[i] + sinna;
                }
            }
            if (przedmiot.equals("Tech")) {
                if (ourDestiny.equals("Technika")) {
                    kary[i] = kary[i] - swlasciwa;
                } else if (ourDestiny.equals("Ogólnodostępna")) {
                    kary[i] = kary[i] + sogolnod;
                } else if (ourDestiny.equals("Nauczanie zintegrowane")) {
                    kary[i] = kary[i] + snz;
                } else if (ourDestiny.equals("WF")) {
                    kary[i] = kary[i] + swf;
                } else {
                    kary[i] = kary[i] + sinna;
                }
            }
            if (przedmiot.equals("Wych")) {
                if (ourDestiny.equals("Nauczanie zintegrowane")) {
                    kary[i] = kary[i] + snz;
                } else if (ourDestiny.equals("WF")) {
                    kary[i] = kary[i] + swf;
                } else {
                    kary[i] = kary[i] + sinna;
                }
            }
            if (przedmiot.equals("WOS")) {
                if (ourDestiny.equals("Wiedza o społeczeństwie")) {
                    kary[i] = kary[i] - swlasciwa;
                } else if (ourDestiny.equals("Ogólnodostępna")) {
                    kary[i] = kary[i] + sogolnod;
                } else if (ourDestiny.equals("Nauczanie zintegrowane")) {
                    kary[i] = kary[i] + snz;
                } else if (ourDestiny.equals("WF")) {
                    kary[i] = kary[i] + swf;
                } else {
                    kary[i] = kary[i] + sinna;
                }
            }
            if (przedmiot.equals("Fiz")) {
                if (ourDestiny.equals("Fizyka i astronomia")) {
                    kary[i] = kary[i] - swlasciwa;
                } else if (ourDestiny.equals("Ogólnodostępna")) {
                    kary[i] = kary[i] + sogolnod;
                } else if (ourDestiny.equals("Nauczanie zintegrowane")) {
                    kary[i] = kary[i] + snz;
                } else if (ourDestiny.equals("WF")) {
                    kary[i] = kary[i] + swf;
                } else {
                    kary[i] = kary[i] + sinna;
                }
            }
            if (przedmiot.equals("Chem")) {
                if (ourDestiny.equals("Chemia")) {
                    kary[i] = kary[i] - swlasciwa;
                } else if (ourDestiny.equals("Ogólnodostępna")) {
                    kary[i] = kary[i] + sogolnod;
                } else if (ourDestiny.equals("Nauczanie zintegrowane")) {
                    kary[i] = kary[i] + snz;
                } else if (ourDestiny.equals("WF")) {
                    kary[i] = kary[i] + swf;
                } else {
                    kary[i] = kary[i] + sinna;
                }
            }
            if (przedmiot.equals("Bio")) {
                if (ourDestiny.equals("Biologia")) {
                    kary[i] = kary[i] - swlasciwa;
                } else if (ourDestiny.equals("Ogólnodostępna")) {
                    kary[i] = kary[i] + sogolnod;
                } else if (ourDestiny.equals("Nauczanie zintegrowane")) {
                    kary[i] = kary[i] + snz;
                } else if (ourDestiny.equals("WF")) {
                    kary[i] = kary[i] + swf;
                } else {
                    kary[i] = kary[i] + sinna;
                }
            }
            if (przedmiot.equals("Geo")) {
                if (ourDestiny.equals("Geografia")) {
                    kary[i] = kary[i] - swlasciwa;
                } else if (ourDestiny.equals("Ogólnodostępna")) {
                    kary[i] = kary[i] + sogolnod;
                } else if (ourDestiny.equals("Nauczanie zintegrowane")) {
                    kary[i] = kary[i] + snz;
                } else if (ourDestiny.equals("WF")) {
                    kary[i] = kary[i] + swf;
                } else {
                    kary[i] = kary[i] + sinna;
                }
            }

        }

    }
    /*ustawia aby przedmioty byley rozlozone rownomiernie*/

    public void nadajKaryDostepnosciDniIGodzinPrzedmiotu(String oddzial1, String przedmiot) {

        RekordPlanu ourRekord;
        RekordPlanu znalezionyRekord;
        CompleteLesson naszaLekcja;
        int dzien;
        int znalezionyDzien;
        int godzina;
        int znalezionaGodzina;
        //    int iloscGodz;
        int godzDziennie;
        int roznicaDni;
        int roznicaGodzin = 0;
        int karnoscDni;
        int karnoscGodzin;
        for (int i = 0; i < mRekordyPlanu.size(); i++) {
            ourRekord = mRekordyPlanu.get(i);
            if (ourRekord.getOurLesson() != null) {
                if ((ourRekord.getOurLesson().getOddzial1().equals(oddzial1)) && ((ourRekord.getOurLesson().getSkrotSubject1().equals(przedmiot)) || (ourRekord.getOurLesson().getSkrotSubject2().equals(przedmiot))) && (!przedmiot.equals("Nz"))) {
                    dzien = ourRekord.getDzien();
                    godzina = ourRekord.getGodzina();
                   for (int n = 0; n < mRekordyPlanu.size(); n++) {
                        znalezionyRekord = mRekordyPlanu.get(n);
                        znalezionyDzien = znalezionyRekord.getDzien();
                        znalezionaGodzina = znalezionyRekord.getGodzina();
                        roznicaDni = Math.abs(znalezionyDzien - dzien);
                        roznicaGodzin = Math.abs(znalezionaGodzina - godzina);
                        if (roznicaDni != 0) {
                            karnoscDni = 0;
                        } else {
                            karnoscDni = 10;
                        }
                        if (roznicaGodzin != 0) {
                            karnoscGodzin = Math.round(1 / roznicaGodzin * 10);
                        } else {
                            karnoscGodzin = 10;
                        }
                        kary[n] = kary[n] + karnoscDni /*+ karnoscGodzin*/;
                    //             System.out.println("Nadałem kary dla dnia " + mRekordyPlanu.get(n).getDzien() + " godzina " + mRekordyPlanu.get(n).getGodzina() + "Nadaję karę dni " + karnoscDni + " dla przedmiotu " + przedmiot);
                    }
                //    break;
                }
            }
        }

    }
    /*ustawia aby odzialy mialy podobna ilosc zajec dziennie*/

    public void nadajKaryNielaczonychGrup(String przedmiot1) {
        String[] listaJezykow = this.school.getLanguageNames();
        String ourLanguage = null;
        RekordPlanu ourRekord;
        for (int j = 0; j < (listaJezykow.length); j++) {
            ourLanguage = listaJezykow[j];
            if ((przedmiot1.equals(ourLanguage + "1")) || (przedmiot1.equals(ourLanguage + "2"))) {
                for (int i = 0; i < mRekordyPlanu.size(); i++) {
                    ourRekord = mRekordyPlanu.get(i);
                    if (ourRekord.getGodzina() == 12) {
                        kary[i] = kary[i] + 1000;
                    }
                    if (ourRekord.getGodzina() == 11) {
                        kary[i] = kary[i] + 9000;
                    }
                    if (ourRekord.getGodzina() == 10) {
                        kary[i] = kary[i] + 8000;
                    }
                    if (ourRekord.getGodzina() == 9) {
                        kary[i] = kary[i] + 7000;
                    }
                    if (ourRekord.getGodzina() == 8) {
                        kary[i] = kary[i] + 6000;
                    }
                    if (ourRekord.getGodzina() == 7) {
                        kary[i] = kary[i] + 5000;
                    }
                    if (ourRekord.getGodzina() == 6) {
                        kary[i] = kary[i] + 1000;
                    }
                    if (ourRekord.getGodzina() == 2) {
                        kary[i] = kary[i] + 200;
                    }
                    if (ourRekord.getGodzina() == 5) {
                        kary[i] = kary[i] + 200;
                    }
                    if (ourRekord.getGodzina() == 3) {
                        kary[i] = kary[i] + 400;
                    }
                    if (ourRekord.getGodzina() == 4) {
                        kary[i] = kary[i] + 400;
                    }

                }
            }

        //   if (przedmiot1.e)
        }
        if ((przedmiot1.equals("WF1")) || (przedmiot1.equals("WF2")) || (przedmiot1.equals("Inf1")) || (przedmiot1.equals("Inf2"))) {
            for (int i = 0; i < mRekordyPlanu.size(); i++) {
                ourRekord = mRekordyPlanu.get(i);
                if (ourRekord.getGodzina() == 12) {
                    kary[i] = kary[i] + 1000;
                }
                if (ourRekord.getGodzina() == 11) {
                    kary[i] = kary[i] + 9000;
                }
                if (ourRekord.getGodzina() == 10) {
                    kary[i] = kary[i] + 8000;
                }
                if (ourRekord.getGodzina() == 9) {
                    kary[i] = kary[i] + 7000;
                }
                if (ourRekord.getGodzina() == 8) {
                    kary[i] = kary[i] + 6000;
                }
                if (ourRekord.getGodzina() == 7) {
                    kary[i] = kary[i] + 5000;
                }
                if (ourRekord.getGodzina() == 6) {
                    kary[i] = kary[i] + 1000;
                }
                if (ourRekord.getGodzina() == 2) {
                    kary[i] = kary[i] + 200;
                }
                if (ourRekord.getGodzina() == 5) {
                    kary[i] = kary[i] + 200;
                }
                if (ourRekord.getGodzina() == 3) {
                    kary[i] = kary[i] + 400;
                }
                if (ourRekord.getGodzina() == 4) {
                    kary[i] = kary[i] + 400;
                }

            }
        }
    }

    public void nadajKaryNielaczonychGrupOstatnich(String oddzial1) {
    }

    public void nadajKaryDostepnosciDniIGodzinOddzialu(String oddzial1) {
        RekordPlanu ourRekord;
        RekordPlanu znalezionyRekord;
        // CompleteLesson naszaLekcja;
        int dzien;
        int znalezionyDzien;
        int godzina;
        int znalezionaGodzina;
        //     int iloscGodz;
        int godzDziennie;
        int roznicaDni;
        int roznicaGodzin = 0;
        int karnoscDni;
        for (int i = 0; i < mRekordyPlanu.size(); i++) {
            ourRekord = mRekordyPlanu.get(i);
            if (ourRekord.getOurLesson() != null) {
                if (ourRekord.getOurLesson().getOddzial1().equals(oddzial1)) {
                    dzien = ourRekord.getDzien();
                    godzina = ourRekord.getGodzina();
                    //       iloscGodz = ourRekord.getOurLesson().getIloscGodzin();
                    //         System.out.println("Sprawdzam " + oddzial1 + " w dniu " + dzien + " o godzinie " + godzina);
                    for (int n = 0; n < mRekordyPlanu.size(); n++) {
                        znalezionyRekord = mRekordyPlanu.get(n);
                        znalezionyDzien = znalezionyRekord.getDzien();
                        znalezionaGodzina = znalezionyRekord.getGodzina();

                        roznicaGodzin = Math.abs(znalezionaGodzina - godzina) * 3;
                        kary[n] = kary[n] + roznicaGodzin;
                    //              System.out.println("Nadałem kary dla dnia " + mRekordyPlanu.get(n).getDzien() + " godzina " + mRekordyPlanu.get(n).getGodzina() + " godziny" + roznicaGodzin);
                    }
                // break;
                }
            }
        }

    }
    /*ustawia kary dla godzin - im pozniejsza godzina tym wieksza kara*/

    public void nadajKareGodzin() {
        int godzina;
        for (int i = 0; i < mRekordyPlanu.size(); i++) {
            godzina = mRekordyPlanu.get(i).getGodzina();
            kary[i] = kary[i] + godzina;
        }
    }
    /*ustawia kary dla wf tylko gdy nie ma drugiego przedmiotu - maja byc rozlozone rownomiernie po srodku*/

    public void nadajKareWF(String przedmiot) {
        int iloscGodzinDziennie = this.getSchool().getMaxDayHours();
        int srednia = Math.round(iloscGodzinDziennie / 2);
        int godzina;
        if ((przedmiot.equals("WF"))) {
            for (int i = 0; i < mRekordyPlanu.size(); i++) {
                godzina = mRekordyPlanu.get(i).getGodzina();
                kary[i] = kary[i] + Math.abs(godzina - srednia);
            }
        }
    }
    /*ustawia kary dla wf tylko gdy jest drugi przedmiot - maja byc rozlozone rownomiernie po srodku*/

    public void nadajKareWFdzielone(String przedmiot1, String przedmiot2) {
        int iloscGodzinDziennie = this.getSchool().getMaxDayHours();
        int srednia = Math.round(iloscGodzinDziennie / 2);
        int godzina;
        if ((przedmiot1.equals("WF1")) || ((przedmiot2.equals("WF2")))) {
            for (int i = 0; i < mRekordyPlanu.size(); i++) {
                godzina = mRekordyPlanu.get(i).getGodzina();
                kary[i] = kary[i] + Math.abs(godzina - srednia);
            }
        }
    }
    /*ustawia kare dni - im dalszy dzien, tym wieksza kara*/

    public void nadajKareDni(String oddzial) {
        RekordPlanu ourRekord;
        int[] karaDni = new int[5];
        for (int i = 0; i < mRekordyPlanu.size(); i++) {
            ourRekord = mRekordyPlanu.get(i);
            if (ourRekord.getOurLesson() != null) {
                for (int d = 1; d < 6; d++) {
                    if ((ourRekord.getDzien() == d) && (ourRekord.getOurLesson().getOddzial1().equals(oddzial))) {
                        karaDni[d - 1] = karaDni[d - 1] + 5;
                    }
                }
            }

        }
        for (int i = 0; i < mRekordyPlanu.size(); i++) {
            ourRekord = mRekordyPlanu.get(i);
            if (ourRekord.getDzien() == 1) {
                kary[i] = kary[i] + karaDni[0];
            }
            if (ourRekord.getDzien() == 2) {
                kary[i] = kary[i] + karaDni[1];
            }
            if (ourRekord.getDzien() == 3) {
                kary[i] = kary[i] + karaDni[2];
            }
            if (ourRekord.getDzien() == 4) {
                kary[i] = kary[i] + karaDni[3];
            }
            if (ourRekord.getDzien() == 5) {
                kary[i] = kary[i] + karaDni[4];
            }
        }
    }
    /*zeruje godziny - potrzebne przy ustalaniu okienek*/

    public void zerujGodziny() {
        for (int i = 0; i < godziny.length; i++) {
            godziny[i] = false;
        }
    }
    /*zeruje dni - potrzebne przy ustalaniu okienek*/

    public void zerujDni() {
        for (int i = 0; i < dni.length; i++) {
            dni[i] = 0;
        }
    }
    /*zeruje okienka*/

    public void zerujOkienka() {
        for (int i = 0; i < okienka.length; i++) {
            okienka[i] = 0;
        }
    }
    /*sprawdzanie ilosci okienek danego odzialu*/

    public int[] sprawdzanieOkienekOddzial(String oddzial) {

        godziny = new boolean[this.getSchool().getMaxDayHours()];
        zerujDni();
        RekordPlanu ourRekord;
        String[] listaJezykow = this.school.getLanguageNames();
        String ourLanguage = null;
        //   System.out.println(oddzial);
        int godzina;
        int pierwsza = 0;
        int ostatnia = 0;
        for (int dzien = 1; dzien < 6; dzien++) {
            zerujGodziny();
            for (int i = 0; i < mRekordyPlanu.size(); i++) {
                ourRekord = mRekordyPlanu.get(i);
                // if (ourRekord.getOurLesson() != null) {
                /*sprawdza czy danego dnia jest dany oddzial*/
                /*jezeli znajdzie do dla tej godziny ustawia flagę*/
                if (ourRekord.getOurLesson() != null) {
                    if ((ourRekord.getDzien() == dzien) && (ourRekord.getOurLesson().getOddzial1().equals(oddzial))) {
                        godzina = ourRekord.getGodzina();
                        godziny[godzina - 1] = true;
                    //                 informacja.add(oddzial+ dzien+ godzina+ ourRekord.getOurLesson().getSkrotSubject1()+" "+ourRekord.getOurLesson().getSkrotTeacher1()+" "+ourRekord.getOurLesson().getSkrotSubject2()+" "+ourRekord.getOurLesson().getSkrotTeacher2()+" "+ourRekord.getOurClassRoom().getName());
                    }
                }
            //  }}

            }
            /*po sprawdzeniu wszystkich godzin tego oddzialu znajduje pierwsza godzine*/
            for (int n = 0; n < godziny.length; n++) {
                if (godziny[n] == true) {
                    pierwsza = n;
                    //          System.out.println("Dzien " + dzien + " godzina pierwsza " + n);
                    break;
                }
            }
            /*szuka ostatniej godziny*/
            for (int m = (godziny.length) - 1; m >= 0; m--) {
                if (godziny[m] == true) {
                    ostatnia = m;
                    //                System.out.println("Dzien " + dzien + " godzina ostatnia" + m);

                    break;
                }
            }

            if ((ostatnia - pierwsza) > 0) {/*zawsze spełniony*/
                for (int z = pierwsza; z <= ostatnia; z++) {
                    if (!godziny[z]) {
                        dni[dzien - 1] = dni[dzien - 1] + 1;
          //              informacja.add("1 " + oddzial + " w dniu" + dzien + " ma okienko o godz. " + (z + 1));
                    //                  System.out.println(1+oddzial+"w dniu " + dzien + " ma okienko o godz " + (z + 1));

                    }
                    if ((z > pierwsza + 1) && (z < ostatnia + 1) && (godziny[z - 1])) {
                        for (int j = 0; j < (listaJezykow.length); j++) {
                            ourLanguage = listaJezykow[j];
                            for (int a = 0; a < mRekordyPlanu.size(); a++) {
                                ourRekord = mRekordyPlanu.get(a);
                                if (ourRekord.getOurLesson() != null) {
                                    if ((ourRekord.getDzien() == dzien) && (ourRekord.getOurLesson().getOddzial1().equals(oddzial)) && (ourRekord.getGodzina() == z) && ((ourRekord.getOurLesson().getSkrotSubject1().equals(ourLanguage + "1")) || ourRekord.getOurLesson().getSkrotSubject1().equals(ourLanguage + "2") || ourRekord.getOurLesson().getSkrotSubject1().equals("WF1") || ourRekord.getOurLesson().getSkrotSubject1().equals("WF2") || ourRekord.getOurLesson().getSkrotSubject1().equals("Inf1") || ourRekord.getOurLesson().getSkrotSubject1().equals("Inf2")) && (ourRekord.getOurLesson().getSkrotSubject2().isEmpty())) {
                                        dni[dzien - 1] = dni[dzien - 1] + 1;
             //                           informacja.add(2 + oddzial + " w dniu" + dzien + " ma okienko o godz. " + z);
                                    //      System.out.println(2+oddzial+"w dniu " + dzien + " ma okienko o godz " + (z ));

                                    }
                                }
                            }
                        }

                    }
                }
            }
        }
        return dni;
    }
    /*tworzy tabele planu*/

    public void tworzenieTabeliplanu() {
        RekordPlanu ourRekord;
        RekordPlanu ourRekord2;
        String oddzial1;
        //   String oddzial2;

        int dzien;
        int godzina;
        int dzienTakiSam;
        int godzinaTakiSam;
        String zawartosc;
        this.mPlany.removeAll(mPlany);
        System.out.println("wielkosc mRekordyPlanu " + mRekordyPlanu.size());
        String oddzialTakiSam;
        for (int i = 0; i < mRekordyPlanu.size(); i++) {
            if (mRekordyPlanu.get(i).getOurLesson() != null) {
                ourRekord = this.mRekordyPlanu.get(i);
                oddzial1 = ourRekord.getOurLesson().getOddzial1();
                //       oddzial2 = ourRekord.getOurLesson().getOddzial2();
                dzien = ourRekord.getDzien();
                godzina = ourRekord.getGodzina() - 1;
                zawartosc = ourRekord.getOurLesson().getOddzial1() + " " + ourRekord.getOurLesson().getSkrotSubject1() + " " + ourRekord.getOurLesson().getSkrotTeacher1() + " s. " + ourRekord.getOurClassRoom().getName() + " " + ourRekord.getOurLesson().getSkrotSubject2() + " " + ourRekord.getOurLesson().getSkrotTeacher2();
                if (!ourRekord.getOurLesson().getSkrotSubject2().isEmpty()) {
                    for (int n = 0; n < mRekordyPlanu.size(); n++) {
                        if ((mRekordyPlanu.get(n).getOurLesson() != null) && (i != n)) {
                            ourRekord2 = this.mRekordyPlanu.get(n);
                            oddzialTakiSam = ourRekord2.getOurLesson().getOddzial1();
                            dzienTakiSam = ourRekord2.getDzien();
                            godzinaTakiSam = ourRekord2.getGodzina() - 1;
                            if ((oddzial1.equals(oddzialTakiSam)) && (dzien == dzienTakiSam) && (godzina == godzinaTakiSam)) {
                                zawartosc = zawartosc + " s. " + ourRekord2.getOurClassRoom().getName();
                            }
                        }
                    }
                }
                this.mPlany.add(new Plan(oddzial1, dzien, godzina, zawartosc));
            }
        }

    }
    /*dodaje kary pomocnicze - nieuzywane*/

    public void DodajKaryPomocnicze() {
        for (int i = 0; i < kary.length; i++) {
            karaPomocnicza = karaPomocnicza + kary[i];
        }
    }
}

