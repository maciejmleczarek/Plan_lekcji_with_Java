/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package generowaniePlanu;

import java.io.Serializable;
import strukturaszkoly.Classroom;
import strukturaszkoly.CompleteLesson;

/**
 *
 * @author Maciek
 */
public class RekordPlanu implements Serializable{
    int dzien;
    int godzina;
    CompleteLesson ourLesson;
    //String sala;
    Classroom ourClassRoom;
    public RekordPlanu(int dzien, int godzina, CompleteLesson ourLesson, Classroom ourClassRoom){
        this.dzien=dzien;
        this.godzina=godzina;
        this.ourLesson=ourLesson;
        this.ourClassRoom=ourClassRoom;
    }
    public int getDzien(){
        return this.dzien;
    }
    
    public void setDzien(int val){
        this.dzien=val;
    }
    public int getGodzina(){
        return this.godzina;
    }
    public void setGodzina(int val){
        this.godzina=val;
    }
    public CompleteLesson getOurLesson(){
        return this.ourLesson;
    }
    public void setOurLesson(CompleteLesson val){
        this.ourLesson=val;
    }
    public Classroom getOurClassRoom(){
        return this.ourClassRoom;
    }
    public void setOurClassRoom(Classroom val){
        this.ourClassRoom=val;
    }
}
