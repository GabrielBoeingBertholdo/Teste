/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capivara;

import settings.Strings;
import settings.Utilitarios;
import interfaces.AcaoInterface;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.Arrays;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import modelo.Capivara;
import telasDeInicio.MenuDoSistema;
import telasDeInicio.Settings;
import static telasDeInicio.Settings.minhaImagens;

/**
 *
 * @author (name= Gabriel Boeing,date=07-21-2017)
 */
public class CadastroCapivara implements AcaoInterface {
    
    private int posicao = -1;
    private JFrame telaDeCadastroCapivara;
    public JTextField jTextFieldNome,jTextFieldTamanhoCapivara,jTextFieldClasNatacao,jTextFieldLocalDorme,jTextFieldSobreNome,jTextFieldNomeCientifico,jTextFieldRegistroGeral,jTextFieldRegistroIbama ;
    public JButton jButtonCadastroCapivara,jButtonAlterarCapivara ;
    private JComboBox jComboBoxQtdDentes,jComboBoxQtdDeFilhotes,jComboBoxQtdGrama,jComboBoxQtdSelfies;
    public  JFormattedTextField jFormattedTextFieldPeso;
    
    
    /**
     * Opção de alteração no veto da capivara.
     * @param posicao 
     */
    public CadastroCapivara(int posicao){
        this();
        this.posicao = posicao;
        Capivara capivara = MenuDoSistema.capivara.get(posicao);

        jTextFieldNome.setText(capivara.getNome());
        jTextFieldSobreNome.setText(capivara.getSobreNome());
        jTextFieldNomeCientifico.setText(capivara.getNomeCientifico());
        jTextFieldLocalDorme.setText(capivara.getLocalDorme());
        jTextFieldClasNatacao.setText(capivara.getClasNatcao());
        
        jComboBoxQtdDentes.setSelectedItem(capivara.getQtdDentes());
        jComboBoxQtdDeFilhotes.setSelectedItem(capivara.getQtdFilhotes());
        jComboBoxQtdSelfies.setSelectedItem(capivara.getQtdSelfies());
        jComboBoxQtdGrama.setSelectedItem(capivara.getQtdJaComeu());
        
        jTextFieldTamanhoCapivara.setText(String.valueOf(capivara.getAltura()));
        jTextFieldRegistroIbama.setText(String.valueOf(capivara.getRegistroIbama()));
        jTextFieldRegistroGeral.setText(String.valueOf(capivara.getRegistroGeral()));
      
        jFormattedTextFieldPeso.setText(Utilitarios.retornarTextoAdicionandoMascara(capivara.getPeso()));
        
        jButtonCadastroCapivara.setVisible(false);
        jButtonAlterarCapivara.setVisible(true);

    }
    
   /**
    * Cadastro da Capivara
    */
    public CadastroCapivara() {
   
        criarTelaCadastroCapivara();
        textoNaTela();
        jButtonNatelaCadastroCapivara();
        botaoNaTelaCadastroCapivara();
        jTextFieldNaTelaCadastroCapivara();
        tecladoNaTelaDeCadastroCapivara();
        botaoOnClickCapivara();
        jComboBoxQTD();
        definicaoJComboBox();
        mascaradoJFormattedTextField();
        jButtonAlterarCapivara.setVisible(false);
        telaDeCadastroCapivara.requestFocus();
    }
    
    /**
     * Defini a tela de cadastro
     */
    public void criarTelaCadastroCapivara(){
        telaDeCadastroCapivara = new JFrame();
        telaDeCadastroCapivara.setSize(800, 800);
        telaDeCadastroCapivara.setLayout(null);
        telaDeCadastroCapivara.setResizable(false);
        telaDeCadastroCapivara.setLocationRelativeTo(null);
        telaDeCadastroCapivara.setContentPane(new JLabel(new ImageIcon(getClass().getResource(Settings.minhaImagens))));
        telaDeCadastroCapivara.setFont(Settings.minhaFonte);
        telaDeCadastroCapivara.setTitle("Save the Capivara  "); 
        telaDeCadastroCapivara.setVisible(true);
        telaDeCadastroCapivara.setIconImage(new ImageIcon(getClass().getResource("/imagens/capybara.jpg")).getImage());
        
    }
    
    /**
     * Defini o texto de "CADASTRO DA CAPIVARA"  na tela de cadastro
     */
    public void textoNaTela(){
        //INFORMÇÃO "CADASTRAR CAPIVARA"
        Font fonteDOcadastroPrincipal = new Font("TimesRoman", Font.PLAIN, 35);
        JButton nomeDaTela = new  JButton("CADASTRO DA CAPIVARA");
        nomeDaTela.setFont(Settings.minhaFonte);
        nomeDaTela.setFont(fonteDOcadastroPrincipal);
        nomeDaTela.setBounds(100, 15, 600, 50);
        transparenciaDosBotao(nomeDaTela);
        telaDeCadastroCapivara.add(nomeDaTela);
        
    }
    
    /**
     * Defini o nome de cada JLabel. ver !!!!!!!!!!
     */
    private void jButtonNatelaCadastroCapivara(){
        //Digitar o Nome:
        JLabel jLabelNome = new JLabel("Nome");
        jLabelNome.setBounds(0,80,100,25);
        jLabelNome.setFont(Settings.minhaFonte);
        telaDeCadastroCapivara.add(jLabelNome);
        //Digita o Sobrenome:
        JLabel jLabeSobreNome = new JLabel("Sobrenome");
        jLabeSobreNome.setBounds(130,80,100,25);
        jLabeSobreNome.setFont(Settings.minhaFonte);
        telaDeCadastroCapivara.add(jLabeSobreNome);
        //Digitar a quantidade de Dentes:
        JLabel jLabeQtdDeDentes = new JLabel("Quantidade de Dentes");
        jLabeQtdDeDentes.setBounds(0,150,170,25);
        jLabeQtdDeDentes.setFont(Settings.minhaFonte);
        telaDeCadastroCapivara.add(jLabeQtdDeDentes);
        //Digita a quantidade de filhotes:
        JLabel jLabeQtdDeFilhotes = new JLabel("Quantidade de Filhotes");
        jLabeQtdDeFilhotes.setBounds(200,150,170,25);
        jLabeQtdDeFilhotes.setFont(Settings.minhaFonte);
        telaDeCadastroCapivara.add(jLabeQtdDeFilhotes);
        //Digita o tamanho da capivara:
        JLabel jLabeTamanhoCapivara= new JLabel("Tamanho");
        jLabeTamanhoCapivara.setBounds(450,150,60,25);
        jLabeTamanhoCapivara.setFont(Settings.minhaFonte);
        telaDeCadastroCapivara.add(jLabeTamanhoCapivara);
        //Digitar o Nome Cientifico:
        JLabel jLabeNomeCientifico= new JLabel("Nome Científico");
        jLabeNomeCientifico.setBounds(0,240,140,25);
        jLabeNomeCientifico.setFont(Settings.minhaFonte);
        telaDeCadastroCapivara.add(jLabeNomeCientifico);
        //Digitar o local que dorme:
        JLabel jLabeLocalDorme= new JLabel("Qual o local que ele dorme");
        jLabeLocalDorme.setBounds(310,240,160,25);
        jLabeLocalDorme.setFont(Settings.minhaFonte);
        telaDeCadastroCapivara.add(jLabeLocalDorme);
        //Digitar a quantidade de selfies:
        JLabel jLabeQtdSelfies= new JLabel("Quantidade de Selfies");
        jLabeQtdSelfies.setBounds(0,320,140,25);
        jLabeQtdSelfies.setFont(Settings.minhaFonte);
        telaDeCadastroCapivara.add(jLabeQtdSelfies);
        //Digita a quantidade de grama que já comeu:
        JLabel jLabeQtdGrama= new JLabel("Quantidade de Grama que já Comeu");
        jLabeQtdGrama.setBounds(275,320,300,25);
        jLabeQtdGrama.setFont(Settings.minhaFonte);
        telaDeCadastroCapivara.add(jLabeQtdGrama);
        //Digita o peso do animal:
        JLabel jLabePeso= new JLabel("Peso");
        jLabePeso.setBounds(600,320,50,25);
        jLabePeso.setFont(Settings.minhaFonte);
        telaDeCadastroCapivara.add(jLabePeso);
        //Digita o registro do ibama:
        JLabel jLabeRegistroIbama= new JLabel("Registro do Ibama");
        jLabeRegistroIbama.setBounds(0,365,170,25);
        jLabeRegistroIbama.setFont(Settings.minhaFonte);
        telaDeCadastroCapivara.add(jLabeRegistroIbama);
        //Digita o registro geral:
        JLabel jLabeRegistroGeral = new JLabel("Registro Geral");
        jLabeRegistroGeral.setBounds(250,365,170,25);
        jLabeRegistroGeral.setFont(Settings.minhaFonte);
        telaDeCadastroCapivara.add(jLabeRegistroGeral);
        //Digita  a classificação de natação:
        JLabel jLabeClasNatacao = new JLabel("Classificação de Natação");
        jLabeClasNatacao.setBounds(480,365,150,25);
        jLabeClasNatacao.setFont(Settings.minhaFonte);
        telaDeCadastroCapivara.add(jLabeClasNatacao);
  
        
        
    }
    
    /**
     * Defini os JTextField na tela.
     */
    private void jTextFieldNaTelaCadastroCapivara(){
        //Digitar o Nome:
        jTextFieldNome = new JTextField();
        jTextFieldNome.setFont(Settings.minhaFonte);
        jTextFieldNome.setBounds(50, 80, 80, 25);
        telaDeCadastroCapivara.add(jTextFieldNome);
        //Digita o Sobrenome:
        jTextFieldSobreNome = new JTextField();
        jTextFieldSobreNome.setFont(Settings.minhaFonte);
        jTextFieldSobreNome.setBounds(220, 80, 430, 25);
        telaDeCadastroCapivara.add(jTextFieldSobreNome);
        //Digitar o nome científico:
        jTextFieldNomeCientifico = new JTextField();
        jTextFieldNomeCientifico.setFont(Settings.minhaFonte);
        jTextFieldNomeCientifico.setBounds(100, 240, 200, 25);
        telaDeCadastroCapivara.add(jTextFieldNomeCientifico);
        //Digitar o local que dorme:
        jTextFieldLocalDorme = new JTextField();
        jTextFieldLocalDorme.setFont(Settings.minhaFonte);
        jTextFieldLocalDorme.setBounds(475, 240, 200, 25);
        telaDeCadastroCapivara.add(jTextFieldLocalDorme);
        //Digita o tamanho da capivara:
        jTextFieldTamanhoCapivara = new JTextField();
        jTextFieldTamanhoCapivara.setFont(Settings.minhaFonte);
        jTextFieldTamanhoCapivara.setBounds(510, 150, 30, 25);
        telaDeCadastroCapivara.add(jTextFieldTamanhoCapivara);  
        //Digita  a classificação de natação:
        jTextFieldClasNatacao = new JTextField();
        jTextFieldClasNatacao.setFont(Settings.minhaFonte);
        jTextFieldClasNatacao.setBounds(625, 365, 170, 25);
        telaDeCadastroCapivara.add(jTextFieldClasNatacao);
        //Digitar o registro IBAMA:
        jTextFieldRegistroIbama = new JTextField();
        jTextFieldRegistroIbama.setFont(Settings.minhaFonte);
        jTextFieldRegistroIbama.setBounds(120, 365, 90, 25);
        telaDeCadastroCapivara.add(jTextFieldRegistroIbama);         
        //Digitar o registro geral:
        jTextFieldRegistroGeral = new JTextField();
        jTextFieldRegistroGeral.setFont(Settings.minhaFonte);
        jTextFieldRegistroGeral.setBounds(350, 365, 90, 25);
        telaDeCadastroCapivara.add(jTextFieldRegistroGeral);
    
        
    }
    
    /**
     * Definir os JComboBox da tela.
     */
    public void jComboBoxQTD(){
        //Digitar a quantidade de Dentes:
        jComboBoxQtdDentes = new JComboBox();
        jComboBoxQtdDentes.setFont(Settings.minhaFonte);
        jComboBoxQtdDentes.setBounds(145, 150, 50, 25);
        telaDeCadastroCapivara.add(jComboBoxQtdDentes);
        //Digita a quantidade de filhotes:
        jComboBoxQtdDeFilhotes = new JComboBox();
        jComboBoxQtdDeFilhotes.setFont(Settings.minhaFonte);
        jComboBoxQtdDeFilhotes.setBounds(350, 150, 50, 25);
        telaDeCadastroCapivara.add(jComboBoxQtdDeFilhotes);
        //Digita a quantidade de grama que já comeu:
        jComboBoxQtdGrama = new JComboBox();
        jComboBoxQtdGrama.setFont(Settings.minhaFonte);
        jComboBoxQtdGrama.setBounds(490, 320, 50, 25);
        telaDeCadastroCapivara.add(jComboBoxQtdGrama);
        //Digitar a quantidade de selfies:
        jComboBoxQtdSelfies = new JComboBox();
        jComboBoxQtdSelfies.setFont(Settings.minhaFonte);
        jComboBoxQtdSelfies.setBounds(130, 320, 50, 25);
        telaDeCadastroCapivara.add(jComboBoxQtdSelfies);
        
    }
    
    /**
     * Definir os objetos do JComboBox
     */
    private void definicaoJComboBox(){
        //JComboBox  - a quantidade de Dentes:
        String [] QtdDentes  = new String[]{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20"};
        Arrays.sort(QtdDentes );
        jComboBoxQtdDentes.setModel(new DefaultComboBoxModel(QtdDentes ));
        jComboBoxQtdDentes.setSelectedIndex(-1);
        //JComboBox  - a quantidade de filhotes:
        String [] QtdDeFilhotes  = new String[]{"01","02","03","04","05","06","07","08","09","10"};
        Arrays.sort(QtdDeFilhotes );
        jComboBoxQtdDeFilhotes.setModel(new DefaultComboBoxModel(QtdDeFilhotes ));
        jComboBoxQtdDeFilhotes.setSelectedIndex(-1);
        //Digita a quantidade de grama que já comeu:
        String [] QtdGrama  = new String[]{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20"};
        Arrays.sort(QtdGrama );
        jComboBoxQtdGrama.setModel(new DefaultComboBoxModel(QtdGrama ));
        jComboBoxQtdGrama.setSelectedIndex(-1);
        //Digitar a quantidade de selfies:
        String [] QtdSelfies  = new String[]{"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20"};
        Arrays.sort(QtdSelfies );
        jComboBoxQtdSelfies.setModel(new DefaultComboBoxModel(QtdSelfies ));
        jComboBoxQtdSelfies.setSelectedIndex(-1);
        
    }
    
    /**
     * Definir os botoes.
     */
    public void botaoNaTelaCadastroCapivara(){
        //Cadastro:
        ImageIcon iconCadastro = new ImageIcon(getClass().getResource("/imagens/plus.png"));
        jButtonCadastroCapivara = new JButton(iconCadastro);
        jButtonCadastroCapivara.setFont(Settings.minhaFonte);
        jButtonCadastroCapivara.setBounds(50, 450, 50, 50);
        telaDeCadastroCapivara.add(jButtonCadastroCapivara);
        //Alterar:
        ImageIcon iconAlterar = new ImageIcon(getClass().getResource("/imagens/shuffle.png"));
        jButtonAlterarCapivara = new JButton(iconAlterar);
        jButtonAlterarCapivara.setFont(Settings.minhaFonte);
        jButtonAlterarCapivara.setBounds(150, 450, 50, 50);
        telaDeCadastroCapivara.add(jButtonAlterarCapivara);
        
    }
    
    /**
     * Atalha do Teclado.
     */
    public void tecladoNaTelaDeCadastroCapivara(){
 
        telaDeCadastroCapivara.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ss ){
                switch(ss.getKeyCode()){
                    case KeyEvent.VK_ESCAPE:
                        telaDeCadastroCapivara.dispose();
                    break;
                    case KeyEvent.VK_F1:
                        acaoCadastro();
                    break;
                    case KeyEvent.VK_F2:
                        
                    break;
                }
            }
        });
    }
    
    /**
     * Definir a ação ao click do botoes.
     */            
    public  void botaoOnClickCapivara(){
        jButtonCadastroCapivara.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                acaoCadastro();
                telaDeCadastroCapivara.dispose();
               // JOptionPane.showMessageDialog(null, "deu");
            }
        });
        jButtonAlterarCapivara.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                acaoAlterar();
                telaDeCadastroCapivara.dispose();
               // JOptionPane.showMessageDialog(null, "deu");
            }
        });
                
    }
    
    /**
     * Defini a transparência do botão.
     * @param jButton 
     */
    private void transparenciaDosBotao(JButton jButton){
        jButton.setOpaque(false);
        jButton.setContentAreaFilled(false);
        jButton.setBorderPainted(false);
        jButton.setFocusPainted(false);
        
    }
    
    /**
     * Definir a mascara JFormattedTextField.
     */
    public void mascaradoJFormattedTextField(){
            
            
            try {
                //cria a máscara para o que o peso seja formato
                //desejado
                 MaskFormatter mascara = new MaskFormatter("#,## Kg");
                 //cria uma instacia do compoente passando a máscara
                 //como parametro
                 jFormattedTextFieldPeso = new JFormattedTextField(mascara);
                 jFormattedTextFieldPeso.setBounds(650, 320, 60, 25);
                 telaDeCadastroCapivara.add(jFormattedTextFieldPeso);

            
            } catch (ParseException parse) {
                //apresenta qual foi a mensagem de erro e finaliza o sistema
                JOptionPane.showMessageDialog(null,"erro");
                System.exit(0);
        }
    }
    
    /**
     * Ação do botão cadastro.
     */
    public void acaoCadastro(){
        //JOptionPane.showMessageDialog(null, "deu");
        if(jTextFieldNome.equals("") ){
        JOptionPane.showMessageDialog(null, "Não não pode ser vazio");
        return;
        }
  
        Capivara capivara = new Capivara(
        jTextFieldNome.getText(),
        jTextFieldSobreNome.getText(),
        jTextFieldNomeCientifico.getText(),
        jTextFieldLocalDorme.getText(),
        jTextFieldClasNatacao.getText(),
        jComboBoxQtdDentes.getSelectedItem().toString(),
        jComboBoxQtdDeFilhotes.getSelectedItem().toString(),
        jComboBoxQtdSelfies.getSelectedItem().toString(),
        jComboBoxQtdGrama.getSelectedItem().toString(),
        Integer.parseInt(jTextFieldTamanhoCapivara.getText()),
        Integer.parseInt(jTextFieldRegistroIbama.getText()),
        Integer.parseInt(jTextFieldRegistroGeral.getText()),                
        Utilitarios.retornarValorDoPesoSemMascara(jFormattedTextFieldPeso)     
        );
        MenuDoSistema.capivara.add(capivara);
        JOptionPane.showMessageDialog(null, "Cadastro do " + capivara.getNome() + " com sucesso!");
    }
    
    /**
     * Ação do botão Alterar.
     */
    public void acaoAlterar() {
        Capivara capivara = new Capivara();
      
       
        capivara.setNome(jTextFieldNome.getText());
        capivara.setSobreNome(jTextFieldSobreNome.getText());
        capivara.setNomeCientifico(jTextFieldNomeCientifico.getText());
        capivara.setLocalDorme(jTextFieldLocalDorme.getText());
        capivara.setClasNatcao(jTextFieldClasNatacao.getText());
        
        
        capivara.setQtdDentes(jComboBoxQtdDentes.getSelectedItem().toString());
        capivara.setQtdFilhotes(jComboBoxQtdDeFilhotes.getSelectedItem().toString());
        capivara.setQtdSelfies(jComboBoxQtdSelfies.getSelectedItem().toString());
        capivara.setQtdJaComeu(jComboBoxQtdGrama.getSelectedItem().toString());
        
        int tamanho = Integer.parseInt(jTextFieldTamanhoCapivara.getText());
        int registroIbama = Integer.parseInt(jTextFieldRegistroIbama.getText());
        int registroGeral = Integer.parseInt(jTextFieldRegistroGeral.getText());
        
        
        
        
        capivara.setAltura(tamanho);
        capivara.setRegistroIbama(registroIbama);
        capivara.setRegistroGeral(registroGeral);
        capivara.setPeso(Utilitarios.retornarValorDoPesoSemMascara(jFormattedTextFieldPeso));
        
        
        MenuDoSistema.capivara.set(posicao,capivara);
        JOptionPane.showMessageDialog(null, "Capivara" + capivara.getNome() + " alterado com sucesso!");
    }
    
    /**
     * Definição
     * @param posicao 
     */
    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    @Override
    public void acaoCadastrar() {
    }

    @Override
    public void acaoCancelar() {
    }


    
    
}
