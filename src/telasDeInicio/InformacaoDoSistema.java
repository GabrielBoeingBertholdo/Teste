/*
 *
 */
package telasDeInicio;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.plaf.FontUIResource;
import static telasDeInicio.Settings.minhaImagens;

/**
 *
 * @author (name= Gabriel Boeing,date=07-18-2017)
 */
public class InformacaoDoSistema {
    
    private JFrame telaDaInformacao;
    public Font fonteTela;
    
    /**
     * Classe de informação para o usuário
     */
    public InformacaoDoSistema(){
        criarTelaInformacao();
        jTextFieldInformacaoDoSistema();
        jLabelImagGabriel();
        keyTecladoInformacao();
  
        telaDaInformacao.requestFocus();
    }
    
    /**
     * Definir a tela de visão do usuário.
     */
    public void criarTelaInformacao(){
        telaDaInformacao = new JFrame("INFORMAÇÃO");
        telaDaInformacao.setSize(500, 625);
        telaDaInformacao.setLayout(null);
        telaDaInformacao.setResizable(false);
        telaDaInformacao.setVisible(true);  
        telaDaInformacao.setLocationRelativeTo(null);
        telaDaInformacao.setContentPane(new JLabel(new ImageIcon(getClass().getResource(Settings.minhaImagens))));
        telaDaInformacao.setIconImage(new ImageIcon(getClass().getResource("/imagens/iconeInfoJanelaInformacao.png")).getImage());
        
    }
    
    /**
     * Texto informativo
     */
    public void jTextFieldInformacaoDoSistema(){
        JLabel jLabelInfo = new JLabel("Programa feito por Gabriel Ronaldo Boeing Bertholdo");
        JLabel jLabelInfo1 = new JLabel("Entra21 - 2017");
        JLabel jLabelInfo2 = new JLabel("Desenvolvimento Java");
        jLabelInfo.setFont(Settings.minhaFonte);
        jLabelInfo1.setFont(Settings.minhaFonte);
        jLabelInfo2.setFont(Settings.minhaFonte);
        jLabelInfo.setBounds(25,25,500,50); 
        jLabelInfo1.setBounds(25,50,500,50); 
        jLabelInfo2.setBounds(25,75,500,50); 
        telaDaInformacao.add(jLabelInfo);
        telaDaInformacao.add(jLabelInfo1);
        telaDaInformacao.add(jLabelInfo2);
    }
    
    /**
     * Foto do Sr. Gabriel
     */
    public void jLabelImagGabriel(){
        ImageIcon perfil = new ImageIcon(getClass().getResource("/imagens/icoGabriel.jpg"));
        JButton jLabelGabriel = new JButton(perfil);
        jLabelGabriel.setBounds(15,120,450,450);
        telaDaInformacao.add(jLabelGabriel);
        jLabelGabriel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                telaDaInformacao.requestFocus();
            }
        });
        
    }
    
    /**
     * Ação do atalho de teclado
     */
    private void keyTecladoInformacao(){
        telaDaInformacao.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ss ){
                switch(ss.getKeyCode()){
                    case KeyEvent.VK_ESCAPE:
                        telaDaInformacao.dispose();
                    break;
                  
                     
                }
            }
        });
        
    }
    
}
