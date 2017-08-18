/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telasDeInicio;


import static telasDeInicio.MenuDoSistema.cachorros;
import capivara.CadastroCapivara;
import gato.ListaDosGatos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import modelo.Cachorro;
import modelo.Capivara;
import modelo.Gato;
import settings.Utilitarios;

/**
 *
 * @author (name= Gabriel Boeing,date=07-17-2017)
 */

public class MenuDoSistema {
    //JFRAME DA TELA DO MENU DO SISTEMA:
    static JFrame telaDeMenu;
    static Object location;
    private JButton jButtonBotaoDeCadastrar,jButtonBotaoDeListar,jButtonBotaoConfig,jButtonBotaoInformacao;
    private byte contJanelaCadastro,contJanelaListar;
    public  static ArrayList<Capivara> capivara;
    public  static ArrayList<Cachorro> cachorros;   
    public  static ArrayList<Gato> gatos;   
  
    
    public MenuDoSistema(){
        capivara = new ArrayList<>();
        cachorros = new ArrayList<>();
        gatos = new ArrayList<>();
        //TELA:
        criarTelaDoMenu();
        botaoDeCadastrar();
        botaoDeListar();
        botaoConfig();
        botaoInformacao();
        textoDeInformacao();
        keyTeclado();

      
        telaDeMenu.requestFocus();
        
    }
    
   /**
    * Difinir a tela do sistema
    */ 
    public void criarTelaDoMenu(){
        telaDeMenu = new JFrame("Menu");
        telaDeMenu.setSize(650, 350);
        telaDeMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaDeMenu.setLocationRelativeTo(null);
        telaDeMenu.setResizable(false);
        telaDeMenu.setLayout(null);
        telaDeMenu.setVisible(true);
        telaDeMenu.setContentPane(new JLabel(new ImageIcon(getClass().getResource(Settings.minhaImagens))));
        telaDeMenu.setIconImage(new ImageIcon(getClass().getResource("/imagens/menu.png")).getImage());
    //    telaDeMenu.setContentPane(new JLabel(new ImageIcon(getClass().getResource("/imagens/ImagenFundo1.jpg"))));
      
    }
    
    /**
     * Botão de Cadastrar
     */
    private void botaoDeCadastrar(){
        ImageIcon ico = new ImageIcon(getClass().getResource("/imagens/registerMenu.png"));
        jButtonBotaoDeCadastrar = new JButton(ico);
        jButtonBotaoDeCadastrar.setBounds(45,50,262,65);
        transparenciaDosBotao(jButtonBotaoDeCadastrar);
        telaDeMenu.add(jButtonBotaoDeCadastrar);
        jButtonBotaoDeCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                acaoCadastro();
                telaDeMenu.requestFocus();
                contJanelaCadastro++;
            }
        });
        
        
    }
    
    /**
     * Botão de listar os arquivos.
     */
    private void botaoDeListar(){
        ImageIcon ico = new ImageIcon(getClass().getResource("/imagens/listMenu.png"));
        jButtonBotaoDeListar = new JButton(ico);
        jButtonBotaoDeListar.setBounds(350,50,182,65);
        transparenciaDosBotao(jButtonBotaoDeListar);
        telaDeMenu.add(jButtonBotaoDeListar);
        telaDeMenu.requestFocus();
        jButtonBotaoDeListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListCadastro listar = new ListCadastro();
                telaDeMenu.requestFocus();
                contJanelaListar++;
            }
        });
        
    }
    
    /**
     *Botão de configuração
     */
    private void botaoConfig(){
        ImageIcon ico = new ImageIcon(getClass().getResource("/imagens/settings.png"));
        jButtonBotaoConfig = new JButton(ico);
        jButtonBotaoConfig.setOpaque(false);
        jButtonBotaoConfig.setBounds(5, 5, 35, 35);
        transparenciaDosBotao(jButtonBotaoConfig);
        telaDeMenu.add(jButtonBotaoConfig);
        jButtonBotaoConfig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                acaoBotaoConfig();
                telaDeMenu.requestFocus();
            }
        });
    
        
        
    }
    
    /**
     *Botão de configuração do sistema
     */
    private void acaoBotaoConfig(){
        Settings Configuracao = new Settings();
        
    }
    
    /**
     *Botão de informação do sistema.
     */
    private void botaoInformacao(){
        ImageIcon ico = new ImageIcon(getClass().getResource("/imagens/info.png"));
        jButtonBotaoInformacao = new JButton(ico);
        jButtonBotaoInformacao.setBounds(5, 283, 35, 35);
        telaDeMenu.add(jButtonBotaoInformacao);
        jButtonBotaoInformacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                acaoBotaoInformacao();
                telaDeMenu.requestFocus();
            }
        });
       
    }
    
    /**
     * Defini a ação do Botão de informação.
     * return a classe 'InformacaoDoSistema()'
     */
    private void acaoBotaoInformacao(){
        InformacaoDoSistema info = new InformacaoDoSistema();  
    }
       
    /**
     *Mostra ao usuário as informação da tela de Menu.
     */
    private void textoDeInformacao(){
       JButton jTextFieldInformacao = new JButton("F1 - PARA CADASTRAR / F2 - PARA LISTAS / F3 - PARA CONFIGURAÇÃO / F4 - PARA INFORMAÇÃO");
        jTextFieldInformacao.setBounds(50,290,600,25);
        jTextFieldInformacao.setFont(Settings.minhaFonte);
        transparenciaDosBotao(jTextFieldInformacao);
        telaDeMenu.add(jTextFieldInformacao);
    }
    
    /**
     * veerrrrrrrrrrrrrrrrrrrrrrrr
     * @param jButton 
     */
    private void transparenciaDosBotao(JButton jButton){
        jButton.setOpaque(false);
        jButton.setContentAreaFilled(false);
        jButton.setBorderPainted(false);
        jButton.setFocusPainted(false);
        
    }
    
    /**
     *Atalho do teclado
     */
    private void keyTeclado(){
        telaDeMenu.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ss ){
                switch(ss.getKeyCode()){
                    case KeyEvent.VK_F1:
                        //contJanelaListar
                   //  aquiiiii   MenuListDosCadastro.telaMenuList.dispose();
                        new Cadastro();
                    break;
                    case KeyEvent.VK_F2:
                        /*
                        if(contJanelaCadastro == 1){
                          CadastroList.telaCadastroList.dispose(); 
                          contJanelaCadastro = 0;
                          new MenuListDosCadastro();
                        }else{
                        new MenuListDosCadastro();
                        }
                        */
                          new ListCadastro();
                    break;
                    case KeyEvent.VK_F3:
                        acaoBotaoConfig();
                    break;
                    case KeyEvent.VK_F4:
                        acaoBotaoInformacao();
                    break;
                  
                     
                }
            }
        });
        
    }
    
    /**
     * Ação do click ou chamado do botão cadastro
     */
    private void acaoCadastro(){
       Cadastro cadastro = new Cadastro();
    }
    
    
    
    
    
    
    
    
    
    
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     
}
