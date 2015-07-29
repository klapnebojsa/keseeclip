/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stampa.Obrasci.Polja;

import Stampa.Apstraktne.OblikStampe;

/**
 *
 * @author Nebojsa
 */
public class PoljeLineTop   extends OblikStampe{
    public PoljeLineTop(String fontName, int fontSize, String vrednost, String alignment, String boldItalic, String cijeJe){
        super(fontName, fontSize, vrednost, alignment, boldItalic, cijeJe);
    } 
    public void SetujPodatke(){
        setLeftLine(false);  setLeftLineWeight(0);
        setDownLine(false);   setDownLineWeight(0);
        setRightLine(false); setRightLineWeight(0);
        setTopLine(true);   setTopLineWeight(1);

        setSmanji(true);
        setOdseci(true);      
    }
}
