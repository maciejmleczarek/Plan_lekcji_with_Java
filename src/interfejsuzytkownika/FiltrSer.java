/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package interfejsuzytkownika;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Administrator
 */
public class FiltrSer extends FileFilter {
    public boolean accept(File p){
        return p.getName().toLowerCase().endsWith(".ser") || p.isDirectory();
    }

    @Override
    public String getDescription() {
        return "Plik planu lekcji";
    }
}
