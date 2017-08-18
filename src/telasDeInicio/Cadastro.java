/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telasDeInicio;

import cachorro.CachorroCadastroJFrame;
import cachorro.CachorroListaJFrame;
import capivara.CadastroCapivara;
import gato.CadastroGatos;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author (name= Gabriel Boeing,date=07-20-2017)
 */
public class Cadastro {
    
    public static JFrame telaCadastroList;
    
    /**
     * Tela de cadastro.
     * Usuário escolher qual opção 
     */
    public Cadastro() {
        criarTelaCadastroList();
        keyTecladoCadastroList();
        mouseDocadastroList();
        botaoCachorro();
        botaoGato();
        botaoCapivara();
        informacao();
        telaCadastroList.requestFocus();
        
    }
    
    /**
     * Definir a tela de opção de cadastro
     */
    public void criarTelaCadastroList(){
        telaCadastroList = new JFrame();
        telaCadastroList.setSize(550,105);
        telaCadastroList.setLayout(null);
        telaCadastroList.setUndecorated(true);
        telaCadastroList.setResizable(true);
        telaCadastroList.setLocationRelativeTo(null);
        telaCadastroList.setVisible(true);
        telaCadastroList.setBackground(new Color(1.0f,1.0f,1.0f,0.5f));
        telaCadastroList.setFont(Settings.minhaFonte);
        
    }
    
    /**
     * Atalhos do teclado
     */
    private void keyTecladoCadastroList(){
        telaCadastroList.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ss ){
                switch(ss.getKeyCode()){
                    case KeyEvent.VK_ESCAPE:
                        telaCadastroList.dispose();
                    break;
                    case KeyEvent.VK_F1:
                        CachorroCadastroJFrame cadastroCachorro = new CachorroCadastroJFrame();
                    break;
                    case KeyEvent.VK_F2:
                        CadastroGatos cadastroGatos = new CadastroGatos();
                    break;
                    case KeyEvent.VK_F3:
                        CadastroCapivara cadastroCapivara = new CadastroCapivara();   
                    break;
                        
                    
                  
                     
                }
            }
        });
        
    }
    
    /**
     * Definir o click dos botões.
     */
    private void mouseDocadastroList(){ 
    MenuDoSistema.telaDeMenu.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent evt){
            telaCadastroList.dispose();
				
	}
                       
				
    });
    }
   
    /**
     * Definir o botão Cachorro.
     */
    private void botaoCachorro(){
        JButton jButtonBotaoCachorro = new JButton("Cachorro");
        jButtonBotaoCachorro.setBounds(25,30,150,50);
        jButtonBotaoCachorro.setFont(Settings.minhaFonte);
        telaCadastroList.add(jButtonBotaoCachorro);
        transparenciaDosBotao(jButtonBotaoCachorro);
        jButtonBotaoCachorro.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                acaoBotaoCachorro();
                telaCadastroList.requestFocus();
            }
        });
    }
    
    /**
     *Definir o botão Gato. 
     */
    private void botaoGato(){
        JButton jButtonBotaoGato = new JButton("Gato");
        jButtonBotaoGato.setFont(Settings.minhaFonte);
        jButtonBotaoGato.setBounds(200,30,150,50);
        telaCadastroList.add(jButtonBotaoGato);
        transparenciaDosBotao(jButtonBotaoGato);
        jButtonBotaoGato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CadastroGatos cadastroGatos = new CadastroGatos();
            }
        });
        
    }
    
    /**
     * Definir o botão Capivara.
     */
    private void botaoCapivara(){
        JButton jButtonBotaoCapivara = new JButton("Capivara");
        jButtonBotaoCapivara.setFont(Settings.minhaFonte);
        jButtonBotaoCapivara.setBounds(375,30,150,50);
        telaCadastroList.add(jButtonBotaoCapivara);
        transparenciaDosBotao(jButtonBotaoCapivara);
        jButtonBotaoCapivara.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                acaoBotaoCapivara();
            }
        });
    }
    
    /**
     * Definir a ação do botão
     */
    private void acaoBotaoCachorro(){
        CachorroCadastroJFrame cadastroCachorro = new CachorroCadastroJFrame();
    }
    
    /**
     * Definir a ação do botão
     */
    private void acaoBotaoGato(){
        CachorroCadastroJFrame cadastroGato = new CachorroCadastroJFrame();
    }
    
    /**
     * Definir a ação do botão
     */
    private void acaoBotaoCapivara(){
        CadastroCapivara cadastroCapivara = new CadastroCapivara();
    }
    
    /**
     * Defini a Transparência dos botão.
     * @param jButton 
     */
    private void transparenciaDosBotao(JButton jButton){
        jButton.setOpaque(false);
        jButton.setContentAreaFilled(false);
        jButton.setBorderPainted(true);
        jButton.setFocusPainted(false);
        
    }
    
     /**
     * Informa ao usuário
     */
    private void informacao(){
        JLabel info = new JLabel(" F1 - Cachorro / F2 - Gato / F3 - Capivara");
        info.setFont(Settings.minhaFonte);
        info.setBounds(160, 85, 300, 20);
        telaCadastroList.add(info);
    }
    
    
    
}
