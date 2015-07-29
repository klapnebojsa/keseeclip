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
import Stampa.Pripremi.PripremiFooter;
import Stampa.Pripremi.PripremiHeader;
import Stampa.Pripremi.PripremiKraj;
import Stampa.Pripremi.PripremiNaslov;
import Stampa.Pripremi.PripremiSve;
import Stampa.Pripremi.PripremiTabelu;
import Stampa.Pripremi.PripremiUvod;
import Stampa.Pripremi.PripremiZakljucak;
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
 * @author Nebojsa
 */
public class FormPrintPreview extends JFrame implements ActionListener{
    public MojaTabela mt1;
    public FormForme koZove;
    boolean ispravanPrikaz = true;
    public PageFormat pageFormat;
    List mojeMargine;
    public PagesPripremi prikazi;
    public PreviewMenuBar stampaMenuBar;
    PrinterJob pj;
    public StampaSetujPage stampaSetujPage;
   
    public Vector headerLineVectorAll;      //Header (na svakoj strani)
    public Vector naslovLineVectorAll;      //Naslov (samo na prvoj strani)
    public Vector uvodLineVectorAll;        //Uvod na vrhu strane(na svakoj strani)
    public Vector tableHeaderLineVector;    //ZaglavljeTabele
    public Vector tableMedjuZbirVector;     //MedjuZbir u tabeli (donos i prenos). Samo oblik. Vrednosti se dodaju dinamicki
    public Vector kojaPoljaMedjuZbirVector; //MedjuZbir u tabeli (donos i prenos). Samo oblik. Vrednosti se dodaju dinamicki    
    public Vector tableLineVectorAll;       //Tabela ili podaci za izvestaj
    public Vector zakljucakLineVectorAll;   //Zakljucak na dnu (na svakoj strani)
    public Vector krajLineVectorAll;        //Kraj na kraju zadnje strane
    public Vector footerLineVectorAll;      //Footer (na svakoj strani)

    public PripremiHeader pripremiHeader; 
    public PripremiNaslov pripremiNaslov;
    public PripremiUvod pripremiUvod;
    //Pripremi tabelu moze ds bude priprema tabele ako je Tabelarni prikaz ali i ne mora ako je potreban neki drugi oblik stampe
    public PripremiTabelu pripremiTabelu;
    
    public PripremiZakljucak pripremiZakljucak;
    public PripremiKraj pripremiKraj;    
    public PripremiFooter pripremiFooter;
    
    public String oznakaStampe;
    public String kojaStampa;
    
    public FormPrintPreview (MojaTabela mt1, FormForme koZove, String oznakaStampe, String kojaStampa){
        super();
        this.mt1 = mt1;
        this.koZove = koZove;
        this.oznakaStampe = oznakaStampe;
        this.kojaStampa = kojaStampa;
    }
    public void Prikazi() throws IOException, Exception{
        koZove.setEnabled(false);

        RezolucijaEkrana re = new RezolucijaEkrana(); //rezolucija
        Dimension fullScr = re.FullScreen();   
        setSize(fullScr);                             //Velicina Forme (Cela Strana)
        setLocationRelativeTo(null);  
        
        pj = PrinterJob.getPrinterJob();      
        pageFormat = pj.defaultPage();
        stampaSetujPage = new StampaSetujPage();                          //Postavljanje vrednosti Margina u PrinterJob.pageDialog iz BAZE
        stampaSetujPage.SetujPageSetup(pageFormat, pj, this, koZove);

        /*pripremiHeader = new PripremiHeader(this, pageFormat, new Vector(), oznakaStampe);        //HEADER
        headerLineVectorAll = pripremiHeader.HeaderLineVectorAll();       
        pripremiNaslov = new PripremiNaslov(this, pageFormat, new Vector(), oznakaStampe);        //NASLOV
        naslovLineVectorAll = pripremiNaslov.NaslovLineVectorAll(); 
        pripremiUvod = new PripremiUvod(this, pageFormat, new Vector(), oznakaStampe);            //UVOD  
        uvodLineVectorAll = pripremiUvod.UvodLineVectorAll();
        pripremiZakljucak = new PripremiZakljucak(this, pageFormat, new Vector(), oznakaStampe);  //ZAKLUCAK
        zakljucakLineVectorAll = pripremiZakljucak.ZakljucakLineVectorAll();        
        pripremiKraj = new PripremiKraj(this, pageFormat, new Vector(), oznakaStampe);            //KRAJ
        krajLineVectorAll = pripremiKraj.KrajLineVectorAll();        
        pripremiFooter = new PripremiFooter(this, pageFormat, new Vector(), oznakaStampe);        //FOOTER
        footerLineVectorAll = pripremiFooter.FooterLineVectorAll();

        //Priprema podataka za stampu Tabele(lineVector-a) sa TableHeader-om  ili neceg drugog      
        tableLineVectorAll = new Vector();
        switch (oznakaStampe){
            case "Tabela":
                pripremiTabelu = new PripremiTabelu(this, pageFormat, tableLineVectorAll);
                tableLineVectorAll = pripremiTabelu.TableLineVectorAll(mt1);
                
                tableHeaderLineVector = pripremiTabelu.TableHeaderLineVector(mt1);
                tableMedjuZbirVector = pripremiTabelu.TableMedjuZbirVector(mt1, koZove, kojaStampa);
                OgranicenjaMedjuZbir ogranicenjaStampa= new OgranicenjaMedjuZbir();
                kojaPoljaMedjuZbirVector = ogranicenjaStampa.KolonaMedjuZbir(koZove, kojaStampa);
                
                break;
            default:
                tableLineVectorAll = new Vector();
                tableHeaderLineVector = new Vector();
                tableMedjuZbirVector = new Vector();
                kojaPoljaMedjuZbirVector = new Vector();
        }*/
        
        //Priprema svih delova za Stampu - kda se bude htela stampa za neku formu a ne za tabelu u ovom delu dodati
        PripremiSve pripremiSve = new PripremiSve();
        pripremiSve.Priprema(this);
        
        //Preview Strane
        prikazi = new PagesPripremi(headerLineVectorAll, naslovLineVectorAll, uvodLineVectorAll, 
                                    zakljucakLineVectorAll, krajLineVectorAll, footerLineVectorAll,
                                    tableLineVectorAll, tableHeaderLineVector, tableMedjuZbirVector, kojaPoljaMedjuZbirVector, pageFormat, this, mt1);
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


        /*pripremiHeader = new PripremiHeader(this, pageFormat, new Vector(), oznakaStampe);        //HEADER
        headerLineVectorAll = pripremiHeader.HeaderLineVectorAll();       
        pripremiNaslov = new PripremiNaslov(this, pageFormat, new Vector(), oznakaStampe);        //NASLOV
        naslovLineVectorAll = pripremiNaslov.NaslovLineVectorAll(); 
        pripremiUvod = new PripremiUvod(this, pageFormat, new Vector(), oznakaStampe);            //UVOD  
        uvodLineVectorAll = pripremiUvod.UvodLineVectorAll();
        pripremiZakljucak = new PripremiZakljucak(this, pageFormat, new Vector(), oznakaStampe);  //ZAKLUCAK
        zakljucakLineVectorAll = pripremiZakljucak.ZakljucakLineVectorAll();        
        pripremiKraj = new PripremiKraj(this, pageFormat, new Vector(), oznakaStampe);            //KRAJ
        krajLineVectorAll = pripremiKraj.KrajLineVectorAll();        
        pripremiFooter = new PripremiFooter(this, pageFormat, new Vector(), oznakaStampe);        //FOOTER
        footerLineVectorAll = pripremiFooter.FooterLineVectorAll();

        //Priprema podataka za stampu Tabele(lineVector-a) sa TableHeader-om  ili neceg drugog      
        tableLineVectorAll = new Vector();
        switch (oznakaStampe){
            case "Tabela":
                pripremiTabelu = new PripremiTabelu(this, pageFormat, tableLineVectorAll);
                tableLineVectorAll = pripremiTabelu.TableLineVectorAll(mt1);
                
                tableHeaderLineVector = pripremiTabelu.TableHeaderLineVector(mt1);
                tableMedjuZbirVector = pripremiTabelu.TableMedjuZbirVector(mt1, koZove, kojaStampa);
                OgranicenjaMedjuZbir ogranicenjaStampa= new OgranicenjaMedjuZbir();
            try {kojaPoljaMedjuZbirVector = ogranicenjaStampa.KolonaMedjuZbir(koZove, kojaStampa);
            } catch (SQLException ex) {Logger.getLogger(FormPrintPreview.class.getName()).log(Level.SEVERE, null, ex);}
                
                break;
            default:
                tableLineVectorAll = new Vector();
                tableHeaderLineVector = new Vector();
                tableMedjuZbirVector = new Vector();
                kojaPoljaMedjuZbirVector = new Vector();
        }*/                
             
                
                PripremiSve pripremiSve = new PripremiSve();
                pripremiSve.Priprema(this);
                
                
                prikazi.setHeaderLineVectorAll(headerLineVectorAll);
                prikazi.setNaslovLineVectorAll(naslovLineVectorAll);
                prikazi.setUvodLineVectorAll(uvodLineVectorAll);                
                prikazi.setZakljucakLineVectorAll(zakljucakLineVectorAll);
                prikazi.setKrajLineVectorAll(krajLineVectorAll);                
                prikazi.setFooterLineVectorAll(footerLineVectorAll);                
                prikazi.setLineVectorAll(tableLineVectorAll);
                prikazi.setTableHeaderLineVector(tableHeaderLineVector);
                prikazi.setTableMedjuZbirVector(tableMedjuZbirVector);
                
                if (prikazi != null) prikazi.pageInit(pageFormat);
                break;
            case "nextButton":      if (prikazi != null) prikazi.sledecaStrana();    break;
            case "previousButton":  if (prikazi != null) prikazi.prethodnaStrana();  break;                
            case "lastButton":      if (prikazi != null) prikazi.poslednjaStrana();  break;                
            case "firstButton":     if (prikazi != null) prikazi.prvaStrana();       break; 
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
                    try {pj.print();} catch (PrinterException e1) {}
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
