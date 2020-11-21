/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package interfejsuzytkownika;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.*;
import java.awt.event.*;
import strukturaszkoly.School;

/**
 *
 * @author Administrator
 */
public class PlanTableFrame extends JFrame {
    private School school;
    
    public PlanTableFrame(final JTable table)  {
       
        JButton printButton=new JButton("Drukuj");
        printButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try{
                    table.print();
                } 
                catch (Exception ex){
                    ex.printStackTrace();
                    
                }
            }
        });
        JPanel buttonPanel=new JPanel();
        buttonPanel.add(printButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
   

}
