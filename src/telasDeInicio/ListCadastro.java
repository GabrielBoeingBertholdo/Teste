/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telasDeInicio;

import cachorro.CachorroListaJFrame;
import capivara.ListaDasCapivaras;
import gato.ListaDosGatos;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author (name= Gabriel Boeing,date=07-21-2017)
 */
public class ListCadastro {
    
    public static JFrame telaMenuList;
    
    /**
     * Classe para listagem do animais.
     */
    public ListCadastro() {
        criarTelaDeListCadastro();
        mouseDolistCadastro();
        keyTecladoListCadastro();
        botaoCapivara();
        botaoGato();
        informacao();
        botaoCachorro();
        telaMenuList.requestFocus();
    }
    
    /**
     * Definir a tela de visão do usuário
     */
    public void criarTelaDeListCadastro(){
        telaMenuList = new JFrame();
        telaMenuList.setSize(550,105);
        telaMenuList.setLayout(null);
        telaMenuList.setUndecorated(true);
        telaMenuList.setResizable(true);
        telaMenuList.setLocationRelativeTo(null);
        telaMenuList.setVisible(true);
        telaMenuList.setBackground(new Color(1.0f,1.0f,1.0f,0.5f));
    }
    
    /**
     * Definir ação do click em cima dos botôes.
     */
    private void mouseDolistCadastro(){ 
    MenuDoSistema.telaDeMenu.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent evt){
            telaMenuList.dispose();
          //  new MenuDoSistema();
				
	}
                       
				
    });
    }
    
    /**
     * Atalho do teclado
     */
    private void keyTecladoListCadastro(){
        telaMenuList.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ss ){
                switch(ss.getKeyCode()){
                    case KeyEvent.VK_ESCAPE:
                        telaMenuList.dispose();
                    break;
                    case KeyEvent.VK_F1:
                        new CachorroListaJFrame();
                    break;
                    case KeyEvent.VK_F2:
                        new ListaDosGatos();
                    break;
                    case KeyEvent.VK_F3:
                        new ListaDasCapivaras();
                    break;
                        
                    
                  
                     
                }
            }
        });
        
    }
    
    /**
     * Definir o botão Gato.
     */
    private void botaoGato(){
        JButton jButtonBotaoGato = new JButton("Gato");
        jButtonBotaoGato.setFont(Settings.minhaFonte);
        jButtonBotaoGato.setBounds(200,30,150,50);
        telaMenuList.add(jButtonBotaoGato);
        transparenciaDosBotao(jButtonBotaoGato);
        jButtonBotaoGato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new ListaDosGatos();
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
        telaMenuList.add(jButtonBotaoCapivara);
        transparenciaDosBotao(jButtonBotaoCapivara);
        jButtonBotaoCapivara.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              new  ListaDasCapivaras();
              telaMenuList.dispose();
            }
        });
    }
    
    /**
     * Definir o botão Cachorro.
     */
    private void botaoCachorro(){
        JButton jButtonBotaoCachorro = new JButton("Cachorro");
        jButtonBotaoCachorro.setFont(Settings.minhaFonte);
        jButtonBotaoCachorro.setBounds(25,30,150,50);
        telaMenuList.add(jButtonBotaoCachorro);
        transparenciaDosBotao(jButtonBotaoCachorro);
        jButtonBotaoCachorro.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              new  CachorroListaJFrame();
              telaMenuList.dispose();
            }
        });
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
        telaMenuList.add(info);
    }
    
    
    
    
}
