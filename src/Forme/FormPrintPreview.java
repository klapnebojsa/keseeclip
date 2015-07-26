/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forme;

import Forme.Konstante.Mere;
import Forme.Tabele.MojaTabela;
import Sistem.OsnovneDefinicije.RezolucijaEkrana;
import Stampa.PagesPripremi;
import Stampa.PreviewMenuBar;
import Stampa.PripremiFooter;
import Stampa.PripremiHeader;
import Stampa.PripremiTabelu;
import Stampa.StampaSetujPage;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 *
 * @author Nebojsa
 */
public class FormPrintPreview extends JFrame implements ActionListener{
    MojaTabela mt1;
    public FormForme koZove;
    boolean ispravanPrikaz = true;
    PageFormat pageFormat;
    List mojeMargine;
    public PagesPripremi prikazi;
    public PreviewMenuBar stampaMenuBar;
    PrinterJob pj;
    public StampaSetujPage stampaSetujPage;
    Vector tableLineVectorAll;
    Vector headerLineVectorAll;
    Vector footerLineVectorAll;
    
    PripremiTabelu pripremiTabelu;
    PripremiHeader pripremiHeader;    
    PripremiFooter pripremiFooter;
    
    public FormPrintPreview (MojaTabela mt1, FormForme koZove){
        super();
        this.mt1 = mt1;
        this.koZove = koZove;
    }
    public void Prikazi() throws IOException, Exception{
        koZove.setEnabled(false);

        //rezolucija
        RezolucijaEkrana re = new RezolucijaEkrana();
        Dimension fullScr = re.FullScreen();
        
        //Velicina Forme (Cela Strana)
        setSize(fullScr);
        setLocationRelativeTo(null);
        
        //Ovde ucitati format iz baze
        pj = PrinterJob.getPrinterJob();
        pageFormat = pj.defaultPage();

        //Postavljanje vrednosti Margina u PrinterJob.pageDialog
        stampaSetujPage = new StampaSetujPage();
        stampaSetujPage.SetujPageSetup(pageFormat, pj, this, koZove);

        //HEADER
        headerLineVectorAll = new Vector();
        pripremiHeader = new PripremiHeader(this, pageFormat, headerLineVectorAll);
        headerLineVectorAll = pripremiHeader.HeaderLineVectorAll();
        
        //FOOTER
        footerLineVectorAll = new Vector();
        pripremiFooter = new PripremiFooter(this, pageFormat, footerLineVectorAll);
        footerLineVectorAll = pripremiFooter.FooterLineVectorAll();
        
        //Priprema podataka za stampu Tabele(lineVector-a)        
        tableLineVectorAll = new Vector();
        pripremiTabelu = new PripremiTabelu(this, pageFormat, tableLineVectorAll);
        tableLineVectorAll = pripremiTabelu.TableLineVectorAll(mt1); 
        
        //Preview Strane
        prikazi = new PagesPripremi(headerLineVectorAll, footerLineVectorAll, tableLineVectorAll, pageFormat, this, mt1);
        add(new JScrollPane(prikazi), BorderLayout.CENTER);
        
        //Button u vrhu strane - Stampa, prethodni, sledeci
        stampaMenuBar = new PreviewMenuBar(true, this);
        add(stampaMenuBar, BorderLayout.NORTH);        
        
        setVisible(true);       
        
        //Listner-i ------------------------------------------------------------------------------------------ 
        // X-Za zatvaranje forme
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                koZove.setEnabled(true);
            }
        });
    }
    
    public void showTitle(PagesPripremi prikazi) {
        int currentPage = prikazi.getTrenutnatPage() + 1;
        int numPages = prikazi.getNumPages();
        setTitle("Print Preview - " + koZove.getOpisForme() +  " strana " + currentPage + " od " + numPages);
        try{stampaMenuBar.tekucaStrana.setText("" + currentPage);
        }catch(Exception e){} 
    }
    
    public void preracunajSirinu(String vrednost){
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String a = e.getActionCommand();
        PrinterJob pj = PrinterJob.getPrinterJob();        
        switch (a){
            //Izbor Formata Strane            
            case "pageSetupButton":
                Mere mere = new Mere();
                Double preracun = mere.getMmPageFormat() / 10;
                pageFormat = pj.pageDialog(pageFormat);
                //Setovanje koordinata, orijentacije ... - POLJA IZ MARGINA            
                stampaSetujPage.setMLeft((int)(pageFormat.getImageableX() / preracun));
                stampaSetujPage.setMRight((int)((pageFormat.getWidth() - pageFormat.getImageableX() - pageFormat.getImageableWidth() + 0.5) / preracun));                 
                stampaSetujPage.setMTop((int)(pageFormat.getImageableY() / preracun));
                stampaSetujPage.setMDown((int)((pageFormat.getHeight() - pageFormat.getImageableY() - pageFormat.getImageableHeight() + 0.5) / preracun));

                //HEADER
                pripremiHeader = new PripremiHeader(this, pageFormat, new Vector());
                headerLineVectorAll = pripremiHeader.HeaderLineVectorAll();
        
                //FOOTER
                pripremiFooter = new PripremiFooter(this, pageFormat, new Vector());
                footerLineVectorAll = pripremiFooter.FooterLineVectorAll();
                
                //Priprema podataka za stampu Tabele(lineVector-a)
                pripremiTabelu = new PripremiTabelu(this, pageFormat, new Vector());
                tableLineVectorAll = pripremiTabelu.TableLineVectorAll(mt1);
                
                prikazi.setHeaderLineVectorAll(headerLineVectorAll);
                prikazi.setFooterLineVectorAll(footerLineVectorAll);                
                prikazi.setLineVectorAll(tableLineVectorAll);

                if (prikazi != null) prikazi.pageInit(pageFormat);
                break;
            case "nextButton":
                if (prikazi != null) prikazi.sledecaStrana(); 
                break;
            case "previousButton":
                if (prikazi != null) prikazi.prethodnaStrana(); 
                break;                
            case "lastButton":
                if (prikazi != null) prikazi.poslednjaStrana();
                break;                
            case "firstButton":
                if (prikazi != null) prikazi.prvaStrana();
                break; 
            case "printButton":
                PrintService[] stampaci = PrinterJob.lookupPrintServices();
                DocPrintJob docPrintJob = null;
                
                for (PrintService printer : stampaci){
                    if (printer.getName().equalsIgnoreCase(stampaSetujPage.getMStampac())) {docPrintJob = printer.createPrintJob(); break;}
                }
                try {pj.setPrintService(docPrintJob.getPrintService());
                } catch (PrinterException ex) { Logger.getLogger(FormPrintPreview.class.getName()).log(Level.SEVERE, null, ex);}

                pj.setPrintable(prikazi, pageFormat);
                if (pj.printDialog()) {
                    prikazi.setJestStampa(true);
                    prikazi.setBrKopija(pj.getCopies());
                    try {pj.print();                            
                    } catch (PrinterException e1) {}
                    prikazi.setBrKopija(1);
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
