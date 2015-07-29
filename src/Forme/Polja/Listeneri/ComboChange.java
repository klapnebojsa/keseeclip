/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forme.Polja.Listeneri;

import Sistem.OsnovneDefinicije.RezolucijaEkrana;
import Stampa.PreviewMenuBar;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JMenuItem;
/**
 *
 * @author Nebojsa
 */
public class ComboChange implements ItemListener {
    JMenuItem menuItemNovi;
    JMenuItem menuItemIzmeni;
    PreviewMenuBar previewMenuBar; 

    public ComboChange(PreviewMenuBar previewMenuBar) {
        this.previewMenuBar = previewMenuBar;
    }

    Object vrednost = null;
    public void itemStateChanged(ItemEvent event) {
        if (event.getStateChange() == ItemEvent.SELECTED) {
            vrednost = event.getItem();
            try {
                previewMenuBar.tekuceUvecanje.setText(vrednost.toString());
                try{
                    vrednost = vrednost.toString().replace(" %", "");
                    previewMenuBar.formPrintPreview.prikazi.p = Double.parseDouble(vrednost.toString()) / 100;                
                }catch(Exception e){
                    RezolucijaEkrana re = new RezolucijaEkrana();
                    Dimension fullScr = re.FullScreen();

                    Dimension ukupnoOsnovno = previewMenuBar.formPrintPreview.prikazi.getUkupnoOsnovno();
                    switch (vrednost.toString()){
                        case "page Width":
                            previewMenuBar.formPrintPreview.prikazi.p = (double)fullScr.width / ukupnoOsnovno.width;
                            break;
                        case "page Height":
                            previewMenuBar.formPrintPreview.prikazi.p = (double)fullScr.height / ukupnoOsnovno.height;                            
                            break;
                    }
                }
                previewMenuBar.formPrintPreview.revalidate();
                previewMenuBar.formPrintPreview.repaint();   
            }catch(Exception e1){}
       }
    }
}
