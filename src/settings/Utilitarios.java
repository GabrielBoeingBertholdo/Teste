/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package settings;

import java.text.NumberFormat;
import javax.swing.JFormattedTextField;

/**
 *
 * @author (name= Gabriel Boeing,date=07-19-2017)
 */
public class Utilitarios {
    
    /**
     * Remover a máscara do peso
     * @param campo
     * @return o valor do peso sem a máscara
     */
    public static float retornarValorDoPesoSemMascara(JFormattedTextField campo){
        String pesoComMascara = campo.getText();
        pesoComMascara = pesoComMascara.replace("Kg", "");
        pesoComMascara = pesoComMascara.replace(" ", "");
        pesoComMascara = pesoComMascara.replace(",", ".");
        return Float.parseFloat(pesoComMascara);
    }
    
    /**
     * Converte o número para String
     * concatenando a unidade de medida
     * @param valor
     * @return o úmero covertido com a unidade de medida
     */
    public static String retornarTextoAdicionandoMascara(float valor){
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setMinimumFractionDigits(2);
        String texto = numberFormat.format(valor);
      //  texto.replace(".", ",");
        texto+= " Kg";
        return texto;
    }
    
    /**
     * Remover a máscara do altura
     * @param campo
     * @return o valor do altura sem a máscara
     */
    public static float retornarValorDoPesoSemMascaraAltura(JFormattedTextField campo){
        String pesoComMascara = campo.getText();
        pesoComMascara = pesoComMascara.replace("M", "");
        pesoComMascara = pesoComMascara.replace(" ", "");
        pesoComMascara = pesoComMascara.replace(",", ".");
        return Float.parseFloat(pesoComMascara);
    }
    
    /**
     * Converte o número para String
     * concatenando a unidade de medida
     * @param valor
     * @return o úmero covertido com a unidade de medida
     */
    public static String retornarTextoAdicionandoMascaraAltura(float valor){
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setMinimumFractionDigits(2);
        String texto = numberFormat.format(valor);
      //  texto.replace(".", ",");
        texto+= " M";
        return texto;
    }

}
