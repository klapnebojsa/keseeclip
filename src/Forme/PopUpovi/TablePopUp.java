/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forme.PopUpovi;

import Forme.Konstante.FunkcijskiTasteri;
import Forme.Polja.Listeneri.OgranicenjaListeneri;
import Forme.Polja.Prikazi.PoljaIzTabeleDefinicija;
import Forme.Tabele.MojaTabela;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author Nebojsa
 */
public class TablePopUp implements ActionListener {
    JMenuItem menuItemNovi;
    JMenuItem menuItemIzmeni;
    JMenuItem menuItemBrisi;
    JMenuItem menuItemMargine;
    JMenuItem menuItemStampa;
    MojaTabela mt1;
    MouseEvent me;
    PoljaIzTabeleDefinicija poljaIzTabele;
    
    public TablePopUp(MojaTabela mt1, MouseEvent me, PoljaIzTabeleDefinicija poljaIzTabele){
        this.mt1=mt1;
        this.me=me;
        this.poljaIzTabele=poljaIzTabele;
    }

    //Mouse right click    
    public void rightClick(){
        JPopupMenu menu = new JPopupMenu("Popup");
        menu.setPreferredSize(new Dimension(200, 150));

        if ( me.getButton() == MouseEvent.BUTTON3) {
            if(mt1.getTable().isEnabled()){
                
                OgranicenjaListeneri oL = new OgranicenjaListeneri(poljaIzTabele.brokerDAO.a.ImeKlase());
                
                oL.proveriNoviListener();
                if (!oL.getOgranicenja()){                
                    menuItemNovi = new JMenuItem("Novi");
                    menu.add(menuItemNovi);
                    menuItemNovi.addActionListener(this);                    
                }
                
                oL.proveriIzmenaListener();
                menuItemIzmeni = new JMenuItem("Izmeni");
                if (mt1.getTable().getSelectedRow()!= -1 && !oL.getOgranicenja()){
                    menu.add(menuItemIzmeni);
                    menuItemIzmeni.addActionListener(this);                    
                }

                oL.proveriBrisiListener();                
                menuItemBrisi = new JMenuItem("Brisi");
                if (mt1.getTable().getSelectedRow()!= -1 && !oL.getOgranicenja()){
                    menu.add(menuItemBrisi);
                    menuItemBrisi.addActionListener(this);                
                }
                
                oL.proveriStampaListener();
                if (!oL.getOgranicenja()){                
                    menuItemStampa = new JMenuItem("Stampa");
                    menu.add(menuItemStampa);
                    menuItemStampa.addActionListener(this);                    
                }
                
                oL.proveriMargineListener();
                if (!oL.getOgranicenja()){                 
                    menuItemMargine = new JMenuItem("Unos Margina");
                    menu.add(menuItemMargine);
                    menuItemMargine.addActionListener(this);                    
                }
                
                mt1.setComponentPopupMenu(menu);
                menu.add("Odustani");               
                menu.show(me.getComponent(), me.getX(), me.getY());
            }
        }      
    }    

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem menu = (JMenuItem) e.getSource();
        FunkcijskiTasteri ft = new FunkcijskiTasteri();
        Robot robot = null;
        try {robot = new Robot();
        } catch (AWTException ex) {Logger.getLogger(TablePopUp.class.getName()).log(Level.SEVERE, null, ex);}        
        
        if(menu == menuItemIzmeni){
            robot.keyPress(ft.getFtIspravi());            
        }
        if(menu == menuItemNovi){          
            robot.keyPress(ft.getFtNovi());            
        }
        if(menu == menuItemBrisi){          
            robot.keyPress(ft.getFtBrisi());            
        } 
        if(menu == menuItemMargine){          
            robot.keyPress(ft.getFtMargine());            
        }        
        if(menu == menuItemStampa){          
            robot.keyPress(ft.getFtStampa());            
        }        
    }
}
