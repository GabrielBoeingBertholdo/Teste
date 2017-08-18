/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cachorro;

import com.sun.corba.se.spi.ior.MakeImmutable;
import settings.Utilitarios;
import interfaces.AcaoInterface;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.event.PrintJobEvent;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import modelo.Cachorro;
import settings.Strings;
import telasDeInicio.MenuDoSistema;
import telasDeInicio.Settings;
/**
 *Permitir com que o usuário realize o cadastro
 * do cachorro
 * 
 * @author (name=Gabriel Boeing, date=07-17-2017)
 */
public class CachorroCadastroJFrame extends JFrame implements AcaoInterface{
    
    private int posicao = -1;
    public JTextField jTextFieldNome,jTextFieldTamanho;
    private JComboBox jComboBoXRaca;
    private JFormattedTextField jFormattedTextFieldPeso;
    private JRadioButton jRadioButtonFemea,jRadioButtonMacho,jRadioButtonVivo,jRadioButttonMorto;
    private JButton jButtonCadastrar,jButtonAlterar,jButtonCancelar;
    //ButtonGroup só deixa selecionar uma opção.
    private ButtonGroup buttonGroupSexo,buttonGroupEstadoAtual;
    
    public CachorroCadastroJFrame(int posicao){
        this();
        this.posicao = posicao;
        Cachorro cachorro = MenuDoSistema.cachorros.get(posicao);
        jTextFieldNome.setText(cachorro.getNome());
        jComboBoXRaca.setSelectedItem(cachorro.getRaca());
        jTextFieldTamanho.setText(String.valueOf(cachorro.getTamanho()));
        jFormattedTextFieldPeso.setText(Utilitarios.retornarTextoAdicionandoMascara(cachorro.getPeso()));
        if(cachorro.isVivo()){
            jRadioButtonVivo.setSelected(true);
        }else{
            jRadioButttonMorto.setSelected(true);
        }
        if(cachorro.getSexo() == 'F'){
            jRadioButtonFemea.setSelected(true);
        }else{
            jRadioButtonMacho.setSelected(true);
        }
        
        jButtonCadastrar.setVisible(false);
        jButtonAlterar.setVisible(true);
        
    }
    
    public CachorroCadastroJFrame(){
        createWindows();
        createComponents();
        defineBoundsOfComponents();
        defineOnClick();
        putComponentsOnWindows();
        popularJComboBoxRaca();
        requestFocus();
        jButtonCadastrar.setVisible(true);
        jButtonAlterar.setVisible(false);
        
    }
    
    /**
     * Criar a janela para o usuário ter interação
     */
    private void createWindows(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension d = toolkit.getScreenSize();
        setSize(600,400);

        //MAXIMIZAR:
        //setExtendedState(getExtendedState()| JFrame.MAXIMIZED_BOTH);
        //FECHA A TELA:
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //TITULO DA JANELA:
        setTitle("Save the Capivara - Cachorro - Cadastro");
        //OUTROS:
        setResizable(false);
        setLayout(null);
        setContentPane(new JLabel(new ImageIcon(getClass().getResource(Settings.minhaImagens))));
        setIconImage(new ImageIcon(getClass().getResource("/imagens/dog.png")).getImage());
        setVisible(true);
        
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ss ){
                switch(ss.getKeyCode()){
                    case KeyEvent.VK_ESCAPE:
                         dispose();
                    break;
                  
                     
                }
            }
        });
        
        
    }
    
    /**
     * Cirar a instacia dos componentes para interação
     */
    private void createComponents(){
   
            jTextFieldNome = new JTextField();
            jTextFieldTamanho = new JTextField();
            
            jRadioButtonVivo = new JRadioButton("Vivo");
            jRadioButttonMorto = new JRadioButton("Morto");
            
            
            jButtonAlterar = new JButton("Alterar");
            jButtonCadastrar = new JButton("Cadastrar");
            jButtonCancelar = new JButton("Cancelar");
            
            jRadioButtonFemea = new JRadioButton("Fêmea");
            jRadioButtonMacho = new JRadioButton("Macho");
            
            jRadioButtonFemea.setOpaque(false);
            jRadioButttonMorto.setOpaque(false);
            jRadioButtonVivo.setOpaque(false);
            jRadioButtonMacho.setOpaque(false); 
            
            ImageIcon iconAlterar = new ImageIcon(getClass().getResource("/imagens/shuffle.png"));
            jButtonAlterar = new JButton(iconAlterar);
            
            ImageIcon iconCadastro = new ImageIcon(getClass().getResource("/imagens/register.png"));
            jButtonCadastrar = new JButton(iconCadastro);
            
            ImageIcon iconCancelar= new ImageIcon(getClass().getResource("/imagens/cancel.png"));
            jButtonCancelar= new JButton(iconCancelar);
            
            defieTransparencyToButton(jButtonAlterar);
            defieTransparencyToButton(jButtonCadastrar);
            defieTransparencyToButton(jButtonCancelar);
            
            
            
            
            
            try {
                //cria a máscara para o que o peso seja formato
                //desejado
                 MaskFormatter mascara = new MaskFormatter("#,## Kg");
                 //cria uma instacia do compoente passando a máscara
                 //como parametro
                 jFormattedTextFieldPeso = new JFormattedTextField(mascara);

            
            } catch (ParseException parse) {
                //apresenta qual foi a mensagem de erro e finaliza o sistema
                JOptionPane.showMessageDialog(null,parse.getMessage());
                System.exit(0);
        }
            validateDoubleSelectionJRadioButton();
            jComboBoXRaca = new JComboBox();
            popularJComboBoxRaca();
           
             
        
    }
    
    /**
     * Permite que aprenas um JRadioButton seja selecionado
     * por vez
     */
    private void validateDoubleSelectionJRadioButton(){
         buttonGroupEstadoAtual = new ButtonGroup();
         buttonGroupEstadoAtual.add(jRadioButtonVivo);
         buttonGroupEstadoAtual.add(jRadioButttonMorto);
            
         buttonGroupSexo = new ButtonGroup();
         buttonGroupSexo.add(jRadioButtonFemea);
         buttonGroupSexo.add(jRadioButtonMacho);
    }
    
    /**
     *Definir a localização e tamanho dos componentes
     */
    private void defineBoundsOfComponents(){
        createJLabelToUser("Nome", 10, 10, 100, 25);
        jTextFieldNome.setBounds(10, 33, 180, 25);
        
        createJLabelToUser("Tamanho", 200, 10, 70, 22);
        jTextFieldTamanho.setBounds(200, 33, 70, 25);
        
        createJLabelToUser("Raça", 280, 10, 100, 22);
        jComboBoXRaca.setBounds(280, 33, 180, 25);
        
        createJLabelToUser("Sexo", 10, 58, 60, 20);
        jRadioButtonFemea.setBounds(10, 78, 100, 25);
        jRadioButtonMacho.setBounds(110, 78, 100, 25);
        
        createJLabelToUser("Estado Atual", 220, 58, 140, 20);
        jRadioButtonVivo.setBounds(220, 78, 100, 25);
        jRadioButttonMorto.setBounds(320, 78, 100, 25);
        
        createJLabelToUser("Peso", 10, 113, 140, 20);
        jFormattedTextFieldPeso.setBounds(10, 133, 100, 25);
        
        jButtonCancelar.setBounds(10,200,65,65);
        jButtonCadastrar.setBounds(75,200,65,65);
        jButtonAlterar.setBounds(135,200,65,65);
        
       //http://www.flaticon.com/
       //flaticons.net
       //iconfinder
        
    }
    
    /**
     * Método que criará o JLabel para o usuário saber qual
     * a utilidade de determinado componente
     * @param texto
     * @param x
     * @param y
     * @param width
     * @param height 
     */
    private void createJLabelToUser(String texto,int x,int y,int width,int height){
        JLabel jLabel = new JLabel(texto);
        jLabel.setBounds(x,y,width,height);
        add(jLabel);
    }
    
    /**
     * Criar a ação para alguns componentes
     */
    private void defineOnClick(){
        jButtonCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acaoCadastrar();
            }
        });
        jButtonAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acaoAlterar();
            }
        });
    }
    
    /**
     * Adiciona os componentes na tela
     */
    private void putComponentsOnWindows(){
        jButtonAlterar.setVisible(false);
        jButtonCadastrar.setVisible(false);
        add(jTextFieldNome);
        add(jTextFieldTamanho);
        
        add(jRadioButtonFemea);
        add(jRadioButtonMacho);
        add(jRadioButttonMorto);
        add(jRadioButtonVivo);
        
        add(jButtonCadastrar);
        add(jButtonAlterar);
        add(jButtonCancelar);
        
        add(jComboBoXRaca);
        
        add(jFormattedTextFieldPeso);
        
        
    }
    
    /**
     * Definir as opções do combo box das raças para
 * o cachorro
     */
    private void popularJComboBoxRaca(){
        String [] raca = new String[]{"Pinscher","Rnd","Boxer","Labrador"};
        Arrays.sort(raca);
        jComboBoXRaca.setModel(new DefaultComboBoxModel(raca));
        jComboBoXRaca.setSelectedIndex(-1);
        
    }
    
    /**
     *  Defiir a transparencia para o componente passado
     * como parametro
     * @param jButton 
     */
    private void defieTransparencyToButton(JButton jButton){
        jButton.setOpaque(false);
        jButton.setContentAreaFilled(false);
        jButton.setBorderPainted(false);
        jButton.setFocusPainted(false);
        
    }
    /**
     * Permite que o usuário realize o cadastro do cachorro.
     */
    @Override
    public void acaoCadastrar() {
        if(jTextFieldNome.equals("")){
        JOptionPane.showMessageDialog(null, "Nome não pode fiar vazio");
        return;
        }
        /*
        //Obtém a iformação do campo que contém a máscara
        //do peso do cachorro e substituí os caracteres para
        //gerar o valor em float
        String pesoString = jFormattedTextFieldPeso.getText();
        pesoString = pesoString.replace(" Kg", "");
        //pesoString = pesoString.replace(" ","");
        pesoString = pesoString.replace(",", ".");
        float peso = Float.parseFloat(pesoString);
        */
        
        
        //cria uma instância de cachorro passando todos 
        //os parametrôs no construtor necessários para
        //a existencia do cachorro.
        Cachorro cachorro = new Cachorro(
           jTextFieldNome.getText(),
           jComboBoXRaca.getSelectedItem().toString(),Utilitarios.retornarValorDoPesoSemMascara(jFormattedTextFieldPeso),jRadioButtonVivo.isSelected(),
                Integer.parseInt(jTextFieldTamanho.getText()),(jRadioButtonFemea.isSelected()?'F':'M')
           
          //(jRadioButtonVivo.isSelected()? true : false), 
        
        
        
        );
        MenuDoSistema.cachorros.add(cachorro);
        jButtonCadastrar.setVisible(false);
        jButtonAlterar.setVisible(true);
        JOptionPane.showMessageDialog(null, "Cadastro do " + cachorro.getNome() + " com sucesso!");
        
        
        
    }

    /**
     * Realiza a alteração do cachorro já casatrado
     */
    @Override
    public void acaoAlterar() {
        Cachorro cachorro = new Cachorro();
        cachorro.setNome(jTextFieldNome.getText());
        cachorro.setRaca(jComboBoXRaca.getSelectedItem().toString());
        cachorro.setSexo(jRadioButtonFemea.isSelected()?'F':'M');
        
        //morto -> verdadeiro - > falso
        //morto -> falso - > verdadeiro
        cachorro.setVivo(!jRadioButttonMorto.isSelected());
        int tamanho = Integer.parseInt(jTextFieldTamanho.getText());
        cachorro.setTamanho(tamanho);
        cachorro.setPeso(Utilitarios.retornarValorDoPesoSemMascara(jFormattedTextFieldPeso));
        
        MenuDoSistema.cachorros.set(posicao,cachorro);
        JOptionPane.showMessageDialog(null, "Cachorro" + cachorro.getNome() + " alterado com sucesso!");
    }
    
    @Override
    public void acaoCancelar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
    
 
}
