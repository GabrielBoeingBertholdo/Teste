/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.awt.EventQueue;
import telasDeInicio.TelaDeLogin;

/**
 *
 * @author (name= Gabriel Boeing,date=07-17-2017)
 */
public class Principal {
    
    /**
     * Iniciar o programa
     * @param args 
     */
    public static void main (String [] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TelaDeLogin login = new TelaDeLogin();  
            }
        });
    }
    
}
