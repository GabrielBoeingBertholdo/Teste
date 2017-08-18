/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telasDeInicio;

import java.awt.Font;
import static java.awt.SystemColor.window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import static telasDeInicio.MenuDoSistema.telaDeMenu;

/**
 *
 * @author (name= Gabriel Boeing,date=07-19-2017)
 */

public class Settings {
    
    public static Font minhaFonte = new Font("TimesRoman", Font.PLAIN, 12);
    public static String minhaImagens = ("/imagensFundoTela/ImagensFundo04.jpg");
    public JFrame  tela;
    public ButtonGroup buttonGroupEstadoAtual,buttonGroupEscolherImagens;
    public JRadioButton jRadioButtonBla,jRadioButtonTime;
    public JRadioButton jRadioButtonIco01,jRadioButtonIco02,jRadioButtonIco03,jRadioButtonIco04;

    
    public Settings(){
        
        telaDoSettings();
        fonteDoSistema();
        botaoDeImages();
        JButtonImagens();
        keyTecladoSettings();
        validateDoubleSelectionJRadioButton();
        tela.requestFocus();
        
        

    }
    
    /**
     * Tela da classe Settings.
     */
    public void telaDoSettings(){
        tela = new JFrame("Configuração");
        tela.setSize(330,650);
        tela.setLayout(null);
        tela.setVisible(true);
        tela.setResizable(true);
        tela.setLocationRelativeTo(null);
        tela.setContentPane(new JLabel(new ImageIcon(getClass().getResource(minhaImagens))));
        tela.setIconImage(new ImageIcon(getClass().getResource("/imagens/settings.png")).getImage());
    }
    
    /**
     * Botão da fonte "JRadioButton" e descrição.
     */
    public void fonteDoSistema(){
        JLabel jLabelNomeFonte = new JLabel("Escolha a Fonte");
        jLabelNomeFonte.setBounds(15, 2, 150, 25);
        tela.add(jLabelNomeFonte);
        
        jRadioButtonTime = new JRadioButton();
        jRadioButtonTime.setBounds(25,50,50,25);
        jRadioButtonTime.setOpaque(false);
        tela.add(jRadioButtonTime);
        
        jRadioButtonBla = new JRadioButton();
        jRadioButtonBla.setBounds(80,50,50,25);
        jRadioButtonBla.setOpaque(false);   
        tela.add(jRadioButtonBla);
        
        jRadioButtonBla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acaoFonteDoSistema();
            }
        });
        jRadioButtonTime.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                acaoFonteDoSistema();
            }
        });
        
       // Blackadder ITC
    }
    
    /**
     * Escolher qual será a Fonte.
     */
    public void acaoFonteDoSistema(){

        if (jRadioButtonTime.isSelected()){
            minhaFonte = new Font("TimesRoman", Font.PLAIN, 12);
            tela.requestFocus();
        }else if (jRadioButtonBla.isSelected()) {
            minhaFonte = new Font("Blackadder ITC", Font.ITALIC, 12);
           tela.requestFocus();
        }   
        
    }
    //ESCOLHER A IMAGENS:
    /**
     * Os JRadioButton para escolher as imagens de tema do sistema.
     */
    public void botaoDeImages(){
        jRadioButtonIco01 = new JRadioButton();
        jRadioButtonIco01.setBounds(150,80,50,25);
        jRadioButtonIco01.setOpaque(false);
        tela.add(jRadioButtonIco01);
        
        jRadioButtonIco02 = new JRadioButton();
        jRadioButtonIco02.setBounds(150,230,50,25);
        jRadioButtonIco02   .setOpaque(false);
        tela.add(jRadioButtonIco02);
        
        jRadioButtonIco03 = new JRadioButton();
        jRadioButtonIco03.setBounds(150,380,50,25);
        jRadioButtonIco03.setOpaque(false);
        tela.add(jRadioButtonIco03);
        
        jRadioButtonIco04 = new JRadioButton();
        jRadioButtonIco04.setBounds(150,530,50,25);
        jRadioButtonIco04.setOpaque(false);
        tela.add(jRadioButtonIco04);
        
        jRadioButtonIco01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acaoFotoFundo();
            }
        });
        jRadioButtonIco02.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acaoFotoFundo();
            }
        });
        jRadioButtonIco03.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acaoFotoFundo();
            }
        });
        jRadioButtonIco04.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acaoFotoFundo();
            }
        });
        
        
    }
    
    /**
     * Defini as imagens e textos.
     */
    public void JButtonImagens(){
        JLabel jLabelNomeImagens = new JLabel("Escolha alguma Foto");
        jLabelNomeImagens.setBounds(180, 15, 150, 25);
        jLabelNomeImagens.setFont(minhaFonte);
        tela.add(jLabelNomeImagens);
        
        ImageIcon icon01 = new ImageIcon(getClass().getResource("/imagensFundoTela/ImagensIcon01.jpg"));
        JButton jButtonImage01 =new JButton(icon01);
        jButtonImage01.setBounds(200, 50, 80, 80);
        tela.add(jButtonImage01);
        
        JLabel jLabelNomeImagens01 = new JLabel("Soul Eater");
        jLabelNomeImagens01.setBounds(200, 130, 150, 25);
        jLabelNomeImagens01.setFont(minhaFonte);
        tela.add(jLabelNomeImagens01);
        
        
        ImageIcon icon02 = new ImageIcon(getClass().getResource("/imagensFundoTela/ImagensIcon02.jpg"));
        JButton jButtonImage02 =new JButton(icon02);
        jButtonImage02.setBounds(200, 200, 80, 80);
        tela.add(jButtonImage02);
        
        JLabel jLabelNomeImagens02 = new JLabel("O Senhor dos Anéis");
        jLabelNomeImagens02.setBounds(200, 280, 150, 25);
        jLabelNomeImagens02.setFont(minhaFonte);
        tela.add(jLabelNomeImagens02);
        
        ImageIcon icon03 = new ImageIcon(getClass().getResource("/imagensFundoTela/ImagensIcon03.jpg"));
        JButton jButtonImage03 =new JButton(icon03);
        jButtonImage03.setBounds(200, 350, 80, 80);
        tela.add(jButtonImage03);
        
        JLabel jLabelNomeImagens03 = new JLabel("Game Of Thrones");
        jLabelNomeImagens03.setBounds(200, 430, 150, 25);
        jLabelNomeImagens03.setFont(minhaFonte);
        tela.add(jLabelNomeImagens03);
        
        ImageIcon icon04 = new ImageIcon(getClass().getResource("/imagensFundoTela/ImagensIcon04.jpg"));
        JButton jButtonImage04 =new JButton(icon04);
        jButtonImage04.setBounds(200, 500, 80, 80);
        tela.add(jButtonImage04);
        
        JLabel jLabelNomeImagens04 = new JLabel("Cèu");
        jLabelNomeImagens04.setBounds(200, 580, 150, 25);
        jLabelNomeImagens04.setFont(minhaFonte);
        tela.add(jLabelNomeImagens04);
        
        
    }
    
    /**
     * Ação ao click do botão escolher foto
     */
    public void acaoFotoFundo(){
        if (jRadioButtonIco01.isSelected()){
            minhaImagens = ("/imagensFundoTela/ImagensFundo01.jpg");
            tela.requestFocus();
        }else if (jRadioButtonIco02.isSelected()){
            minhaImagens = ("/imagensFundoTela/ImagensFundo02.jpg");
            tela.requestFocus();
        }else if (jRadioButtonIco03.isSelected()){
            minhaImagens = ("/imagensFundoTela/ImagensFundo03.jpg");
            tela.requestFocus();
        }else if (jRadioButtonIco04.isSelected()){
            minhaImagens = ("/imagensFundoTela/ImagensFundo04.jpg");
            tela.requestFocus();
        }
    }
    
    /**
     * Cofiguração do teclado.
     */
    private void keyTecladoSettings(){
        tela.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ss ){
                switch(ss.getKeyCode()){
                     case KeyEvent.VK_ESCAPE:
                        tela.dispose();
                       
                     //   MenuDoSistema.telaDeMenu.co();
                    break;
                  
                     
                }
            }
        });
        
    }
    
    /**
     * Permite que aprenas um JRadioButton seja selecionado
     * por vez
     */
     public void validateDoubleSelectionJRadioButton(){
         buttonGroupEstadoAtual = new ButtonGroup();
         buttonGroupEstadoAtual.add(jRadioButtonBla);
         buttonGroupEstadoAtual.add(jRadioButtonTime);
         
         buttonGroupEscolherImagens = new ButtonGroup();
         buttonGroupEscolherImagens.add(jRadioButtonIco01);
         buttonGroupEscolherImagens.add(jRadioButtonIco02);
         buttonGroupEscolherImagens.add(jRadioButtonIco03);
         buttonGroupEscolherImagens.add(jRadioButtonIco04);
       
    }
}
