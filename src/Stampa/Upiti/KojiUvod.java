/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stampa.Upiti;

import Forme.FormPrintPreview;
import Stampa.Apstraktne.NijeTabela;
import Stampa.Obrasci.Uvod.UvodClassic;
import java.awt.print.PageFormat;
import java.util.Vector;

/**
 *
 * @author Nebojsa
 */
public class KojiUvod {
    //OblikStampe header;
    NijeTabela uvod;
    Vector lineVectorAll;
    String imeKlase;
    String fontNameOsn;
    int fontSizeOsn;
    String alignment;
    FormPrintPreview formPrintPreview;
    PageFormat pageFormat;
    String oznakaStampe;

    public KojiUvod(FormPrintPreview formPrintPreview, String imeKlase, String fontNameOsn, int fontSizeOsn, PageFormat pageFormat, String oznakaStampe){
        this.imeKlase = imeKlase;
        this.fontNameOsn = fontNameOsn;
        this.fontSizeOsn = fontSizeOsn;
        this.formPrintPreview = formPrintPreview;
        this.pageFormat = pageFormat;
        this.oznakaStampe = oznakaStampe;
    } 
    public Vector OdrediUvod(){
        //FunkcijskiTasteri ft = new FunkcijskiTasteri();
        switch (imeKlase + oznakaStampe){
            /*case "PartneriTabela":
                header = new HeaderLine(formPrintPreview, imeKlase, fontNameOsn, fontSizeOsn, pageFormat);
                break;*/
            default:
                uvod = new UvodClassic(formPrintPreview, imeKlase, fontNameOsn, fontSizeOsn, pageFormat);
                break;
        }
        uvod.FormirajPolja();
        lineVectorAll = uvod.getLineVectorAll();        
        return lineVectorAll;
    }    
}
