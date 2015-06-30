/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forme;

import Class.Apstraktne.AbstractDAO;
import Class.DAO.BrokerDAO;
import Class.KlaseBaze.Margine;
import Class.Povezivanje.Procitaj;
import Class.Povezivanje.Setuj;
import Forme.Konstante.Mere;
import Forme.Tabele.MojaTabela;
import Sistem.OsnovneDefinicije.RezolucijaEkrana;
import Stampa.Prikazi;
import Stampa.StampaMenuBar;
import Stampa.StampaSetuj;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 *
 * @author Nebojsa
 */
public class FormPrintPreview extends JFrame implements ActionListener{
    MojaTabela mt1;
    FormForme koZove;
    boolean ispravanPrikaz = true;
    File f;
    PageFormat pageFormat;
    List mojeMargine;
    Prikazi prikazi;
    StampaMenuBar stampaMenuBar;
    PrinterJob pj;
    
    public FormPrintPreview (MojaTabela mt1, FormForme koZove, File f){
        super();
        this.mt1 = mt1;
        this.koZove = koZove;
        this.f = f;
    }
    public void Prikazi() throws IOException, Exception{
        koZove.setEnabled(false);
        
        //setTitle("Print Preview - " + koZove.getOpisForme()); 
        
        //rezolucija
        RezolucijaEkrana re = new RezolucijaEkrana();
        Dimension fullScr = re.FullScreen();
        //Velicina Forme (Cela Strana)
        setSize(fullScr);
        setLocationRelativeTo(null);
        
        //Button u vrhu strane - Stampa, prethodni, sledexi
        stampaMenuBar = new StampaMenuBar(true, this);
        add(stampaMenuBar, BorderLayout.NORTH);
        //add(new StampaMenuBar(true, this), BorderLayout.NORTH);
        
        //Ovde ucitati format iz baze
        pj = PrinterJob.getPrinterJob();
        pageFormat = pj.defaultPage();

        //Postavljanje vrednosti Margina u PrinterJob.pageDialog
        StampaSetuj stampaSetuj = new StampaSetuj();
        stampaSetuj.SetujPageSetup(mojeMargine, pageFormat, pj, this, koZove);
        
        //Preview Strane
        prikazi = new Prikazi(f, pageFormat, this);
        add(new JScrollPane(prikazi), BorderLayout.CENTER);
        
        setVisible(true);       
        
        //Listner-i ------------------------------------------------------------------------------------------ 
        // X-Za zatvaranje forme
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                koZove.setEnabled(true);
            }
        });
    }
    
    public void showTitle(Prikazi prikazi) {
        int currentPage = prikazi.getCurrentPage() + 1;
        int numPages = prikazi.getNumPages();
        setTitle("Print Preview - " + koZove.getOpisForme() +  " strana " + currentPage + " od " + numPages);
        try{stampaMenuBar.tekucaStrana.setText("" + currentPage);
        }catch(Exception e){} 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String a = e.getActionCommand();
        PrinterJob pj = PrinterJob.getPrinterJob();        
        switch (a){
            //Izbor Formata Strane            
            case "pageSetupButton":

                pageFormat = pj.pageDialog(pageFormat);
                /*double ww = pageFormat.getWidth();
                double hh = pageFormat.getHeight();*/
                if (prikazi != null) prikazi.pageInit(pageFormat);
                break;
            case "nextButton":
                if (prikazi != null) prikazi.nextPage(); 
                break;
            case "previousButton":
                if (prikazi != null) prikazi.previousPage(); 
                break;                
            case "lastButton":
                if (prikazi != null) prikazi.lastPage();
                break;                
            case "firstButton":
                if (prikazi != null) prikazi.firstPage();
                break; 
            case "printButton":
                pj.setPrintable(prikazi, pageFormat);
                if (pj.printDialog()) {
                    prikazi.setJestStampa(true);
                    try {pj.print();
                    } catch (PrinterException e1) {}
                    prikazi.setJestStampa(false);
                }
                break;
            default:
                break;
        }
        if (prikazi != null) showTitle(prikazi);
    }
    public void setPageFormat(PageFormat pageFormat){
        this.pageFormat = pageFormat;
    }

}
