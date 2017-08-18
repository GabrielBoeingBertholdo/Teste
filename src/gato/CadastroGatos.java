/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gato;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.Arrays;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import modelo.Gato;
import settings.Strings;
import settings.Utilitarios;
import telasDeInicio.MenuDoSistema;
import telasDeInicio.Settings;

/**
 *
 * @author (name= Gabriel Boeing,date=07-22-2017)
 */
public class CadastroGatos {
    //Posição para alterar
    private int posicao = -1;
    //Tela do Menu de cadastro de gato:
    private JFrame telaDeCadastroGatos;
    //Botões da tabela == excluir - alterar  - adicionar:
    private JButton excluir,alterar,adicionar;
    //JTextField variáveis de gato:
    private JTextField jTextFieldNome,jTextFieldNomeDono,jTextFieldRacao;
    //JFormattedTextField variáveis de gato:
    private JFormattedTextField jFormattedTextFieldPeso,jFormattedTextFieldAltura,jFormattedTextFieldComprimento,jFormattedTextFieldQtdVidas,jFormattedTextFieldQtsFiosPelos,jFormattedTextFieldidade;
    //JComboBox variáveis de gato:
    private JComboBox jComboBoxCordaPataTraseiraDireita,jComboBoxCorDaPataTraseiraEsquerda,jComboBoxCorDaPataFrontalDireita,jComboBoxCorDaPataFrontalEsquerda, jComboBoxCorDoOlhoDireito,jComboBoxCorOlhoEsquerdo,jComboBoxRaca,jComboBoxNivelPreguica,jComboBoxQtdcirurgias,jComboBoxQtdFilhotes;
    //JRadioButton variáveis de gato:
    private JRadioButton jRadioButtonSexoM,jRadioButtonSexoF,jRadioButtonCirurgiaSim,jRadioButtonCirurgiaNao,jRadioButtonPedigreeSim,jRadioButtonPedigreeNao,jRadioButtonFilhotesSim,jRadioButtonFilhotesNao,jRadioButtonCastradoSim,jRadioButtonCastradoNao,jRadioButtonTossaSim,jRadioButtonTossaNao;
    //ButtonGroup grupos de variáveis de JRadioButton:
    private ButtonGroup buttonGroupSexo,buttonGroupTossa,buttonGroupCirurgia,buttonGroupPedigree,buttonGroupFilhotes,buttonGroupCastrado;
 
  
    public CadastroGatos(int posicao){
        this();
        this.posicao = posicao;
        //String filhos = (getBytes(gato.getQtdFilhotes()));
        Gato gato = MenuDoSistema.gatos.get(posicao);
        jTextFieldNome.setText(gato.getNome());
        jComboBoxRaca.setSelectedItem(gato.getRaca());
        jComboBoxNivelPreguica.setSelectedItem(gato.getNivelPreguica());
        jTextFieldRacao.setText(gato.getRacao());
        jTextFieldNomeDono.setText(gato.getNomeDono());
        jComboBoxCordaPataTraseiraDireita.setSelectedItem(gato.getCordaPataTraseiraDireita());
        jComboBoxCorDaPataTraseiraEsquerda.setSelectedItem(gato.getCorDaPataTraseiraEsquerda());
        jComboBoxCorDaPataFrontalDireita.setSelectedItem(gato.getCorDaPataFrontalDireita());
        jComboBoxCorDaPataFrontalEsquerda.setSelectedItem(gato.getCorDaPataFrontalEsquerda());
        jComboBoxCorDoOlhoDireito.setSelectedItem(gato.getCorDoOlhoDireito());
        jComboBoxCorOlhoEsquerdo.setSelectedItem(gato.getCorOlhoEsquerdo());
        jFormattedTextFieldQtdVidas.setText(String.valueOf(gato.getQuantidadeVidas()));
        jFormattedTextFieldQtsFiosPelos.setText(String.valueOf(gato.getQuantidadeDeFiosDePelos()));
        jFormattedTextFieldidade.setText(String.valueOf(gato.getIdade()));
        //Problema com esses 2:
        jComboBoxQtdcirurgias.setSelectedItem(String.valueOf(gato.getQtdcirurgias()));
        jComboBoxQtdFilhotes.setSelectedItem(String.valueOf(gato.getQtdFilhotes()));
        
        
        jFormattedTextFieldComprimento.setText(Utilitarios.retornarTextoAdicionandoMascaraAltura(gato.getComprimento()));
        jFormattedTextFieldAltura.setText(Utilitarios.retornarTextoAdicionandoMascaraAltura(gato.getAltura()));
        jFormattedTextFieldPeso.setText(Utilitarios.retornarTextoAdicionandoMascaraAltura(gato.getPeso()));
        if(gato.getSexo() == 'F'){
            jRadioButtonSexoF.setSelected(true);
        }else{
            jRadioButtonSexoM.setSelected(true);
        }
        if(gato.getTossa()== 'S'){
            jRadioButtonTossaSim.setSelected(true);
        }else{
            jRadioButtonTossaNao.setSelected(true);
        }
        if(gato.getCirurgia()== 'S'){
            jRadioButtonCirurgiaSim.setSelected(true);
        }else{
            jRadioButtonCirurgiaNao.setSelected(true);
        }
        if(gato.getPedigree()== 'S'){
            jRadioButtonPedigreeSim.setSelected(true);
        }else{
            jRadioButtonPedigreeNao.setSelected(true);
        }
        if(gato.getFilhotes()== 'S'){
            jRadioButtonFilhotesSim.setSelected(true);
        }else{
            jRadioButtonFilhotesNao.setSelected(true);
        }
        if(gato.getCastrado()== 'S'){
            jRadioButtonCastradoSim.setSelected(true);
        }else{
            jRadioButtonCastradoNao.setSelected(true);
        }
        alterar.setVisible(true);
        adicionar.setVisible(false);
        excluir.setVisible(false);
        
       
      
        
        
        
    }

    public CadastroGatos() {
        criarTelaDoCadastroGatos();
        criarInformacaoDatela();
        criarPrincipaisBotoes();
        opcoesTeclado();
        //Problema ver
       // opcoesMouse();
        criarCamposDosNomesDasVariaveis();
        criarCamposJTextField();
        criarCamposJFormattedTextField(); 
        criarCamposJComboBox();
        opcaoJComboBoxCores();

        criarCamposJRadioButton();
        validaSomenteUmClickJRadioButton();
        
        alterar.setVisible(false);
        adicionar.setVisible(true);
        
        telaDeCadastroGatos.requestFocus();
    }
    
    /**
     * Definir a tela de cadastro de Gato,localização e tamanho.
     */
    public void criarTelaDoCadastroGatos(){
        telaDeCadastroGatos = new JFrame();
        telaDeCadastroGatos.setSize(800, 800);
        telaDeCadastroGatos.setLayout(null);
        telaDeCadastroGatos.setResizable(false);
        telaDeCadastroGatos.setLocationRelativeTo(null);
        telaDeCadastroGatos.setContentPane(new JLabel(new ImageIcon(getClass().getResource(Settings.minhaImagens))));
        telaDeCadastroGatos.setFont(Settings.minhaFonte);
        telaDeCadastroGatos.setTitle("Save the cat - cat - Cadastro");
        telaDeCadastroGatos.setVisible(true);
        telaDeCadastroGatos.setIconImage(new ImageIcon(getClass().getResource("/imagens/cat.png")).getImage());
    }
    
    /**
     * Definir Texto da janela "CADASTRO DE GATOS".
     */
    public void criarInformacaoDatela(){
        //INFORMÇÃO "CADASTRO DE GATOS"
        Font fonteDOcadastroPrincipal = new Font("TimesRoman", Font.PLAIN, 35);
        JLabel nomeDaTela = new  JLabel("CADASTRO DE GATOS");
        nomeDaTela.setFont(Settings.minhaFonte);
        nomeDaTela.setFont(fonteDOcadastroPrincipal);
        nomeDaTela.setBounds(200, 15, 600, 50);
        telaDeCadastroGatos.add(nomeDaTela);
    }
    
    /**
     * Definir os botões Principais e suas localização na tela.
     * adicionar - alterar  - excluir
     */
    public void criarPrincipaisBotoes(){
        //Cadastro:
        ImageIcon iconCadastro = new ImageIcon(getClass().getResource("/imagens/plus.png"));
        adicionar = new JButton(iconCadastro);
        adicionar.setFont(Settings.minhaFonte);
        adicionar.setBounds(50, 550, 50, 50);
        adicionar.setVisible(false);
        telaDeCadastroGatos.add(adicionar);
        adicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                acaoCadastro();   
                telaDeCadastroGatos.requestFocus();
            }
        });
        //Alterar:
        ImageIcon iconAlterar = new ImageIcon(getClass().getResource("/imagens/change.png"));
        alterar = new JButton(iconAlterar);
        alterar.setFont(Settings.minhaFonte);
        alterar.setBounds(150, 550, 50, 50);
        telaDeCadastroGatos.add(alterar);
        alterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                acaoAlterar();
                telaDeCadastroGatos.requestFocus();
            }
        });
        //Excluir:
        ImageIcon iconExcluir = new ImageIcon(getClass().getResource("/imagens/deletar.png"));
        excluir = new JButton(iconExcluir);
        excluir.setFont(Settings.minhaFonte);
        excluir.setBounds(250, 550, 50, 50);
       // telaDeCadastroGatos.add(excluir); 

    }
    
    /**
     * Definir as opções de atalhos do teclado.
     */
    public void opcoesTeclado(){
        telaDeCadastroGatos.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ss ){
                switch(ss.getKeyCode()){
                    case KeyEvent.VK_ESCAPE:
                        telaDeCadastroGatos.dispose();
                    break;
                    case KeyEvent.VK_F1:
                        acaoCadastro();
                        telaDeCadastroGatos.requestFocus();
                    break;
                    case KeyEvent.VK_F2:
                        acaoAlterar();
                        telaDeCadastroGatos.requestFocus();
                    break;
                    case KeyEvent.VK_F3:
                        //acaoExcluir();
                        telaDeCadastroGatos.requestFocus();
                    break;
                }
            }; 
        });
    }
        
    /**
     * Denifir as acôes do click nos botões.
     */
    public void opcoesMouse(){
        //Botao Adicionar:
        adicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                acaoCadastro();   
                telaDeCadastroGatos.requestFocus();
            }
        });
        //Botao Alterar:
        alterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                acaoAlterar();
                telaDeCadastroGatos.requestFocus();
            }
        });
        //Botao Excluir:
        excluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               // acaoExcluir();
                telaDeCadastroGatos.requestFocus();
            }
        });
        
    }
    
    /**
     * Acão Cadastro.
     *Realizar o cadastro do Gato.
     */
    public void acaoCadastro(){
        //JOptionPane.showMessageDialog(null, "deu");
        
        if(jTextFieldNome.equals("")){
            JOptionPane.showMessageDialog(null, "Nome não pode ser vazio");
            return;
        }
                
        Gato gato = new Gato(
            jTextFieldNome.getText(),
            jComboBoxRaca.getSelectedItem().toString(),
            jComboBoxNivelPreguica.getSelectedItem().toString(),
            jTextFieldRacao.getText(),
            jTextFieldNomeDono.getText(),
            jComboBoxCordaPataTraseiraDireita.getSelectedItem().toString(),
            jComboBoxCorDaPataTraseiraEsquerda.getSelectedItem().toString(),
            jComboBoxCorDaPataFrontalDireita.getSelectedItem().toString(),
            jComboBoxCorDaPataFrontalEsquerda.getSelectedItem().toString(),
            jComboBoxCorDoOlhoDireito.getSelectedItem().toString(),
            jComboBoxCorOlhoEsquerdo.getSelectedItem().toString(),
            Integer.parseInt(jFormattedTextFieldQtdVidas.getText()),
            Integer.parseInt(jFormattedTextFieldQtsFiosPelos.getText()),
            Byte.parseByte(jFormattedTextFieldidade.getText()),
            Byte.parseByte(jComboBoxQtdcirurgias.getSelectedItem().toString()),      
            Byte.parseByte(jComboBoxQtdFilhotes.getSelectedItem().toString()),
            Utilitarios.retornarValorDoPesoSemMascaraAltura(jFormattedTextFieldComprimento),
            Utilitarios.retornarValorDoPesoSemMascaraAltura(jFormattedTextFieldAltura),
            Utilitarios.retornarValorDoPesoSemMascara(jFormattedTextFieldPeso),
            (jRadioButtonSexoM.isSelected()?'F':'M'),
            (jRadioButtonTossaSim.isSelected()?'S':'M'),
            (jRadioButtonCirurgiaSim.isSelected()?'S':'M'),
            (jRadioButtonPedigreeSim.isSelected()?'S':'M'),
            (jRadioButtonFilhotesSim.isSelected()?'S':'M'),
            (jRadioButtonCastradoSim.isSelected()?'S':'M')
        );  
        MenuDoSistema.gatos.add(gato);
        adicionar.setVisible(false);
        alterar.setVisible(true);
        JOptionPane.showMessageDialog(null, "Cadastro do " + gato.getNome() + " com sucesso!");
       
       
    
    }

    /**
     *Acão Alterar.
     *Realiza a alteração do cachorro já cadastrado no sistema.
     */
    public void acaoAlterar() {
        //
        Gato gato = new Gato();
        //JTextField:
        gato.setNome(jTextFieldNome.getText());
        gato.setNomeDono(jTextFieldNomeDono.getText());
        gato.setRacao(jTextFieldRacao.getText());
        //JFormattedTextField:
        gato.setPeso(Utilitarios.retornarValorDoPesoSemMascara(jFormattedTextFieldPeso));
        gato.setAltura(Utilitarios.retornarValorDoPesoSemMascaraAltura(jFormattedTextFieldAltura));
        gato.setComprimento(Utilitarios.retornarValorDoPesoSemMascaraAltura(jFormattedTextFieldComprimento));
        gato.setQuantidadeVidas(Integer.parseInt(jFormattedTextFieldQtdVidas.getText()));
        gato.setQuantidadeDeFiosDePelos(Integer.parseInt(jFormattedTextFieldQtsFiosPelos.getText()));
        gato.setIdade(Byte.parseByte(jFormattedTextFieldidade.getText()));
        //JComboBox:
        gato.setCordaPataTraseiraDireita(jComboBoxCordaPataTraseiraDireita.getSelectedItem().toString());
        gato.setCorDaPataTraseiraEsquerda(jComboBoxCorDaPataTraseiraEsquerda.getSelectedItem().toString());
        gato.setCorDaPataFrontalDireita(jComboBoxCorDaPataFrontalDireita.getSelectedItem().toString());
        gato.setCorDaPataFrontalEsquerda(jComboBoxCorDaPataFrontalEsquerda.getSelectedItem().toString());
        gato.setCorDoOlhoDireito(jComboBoxCorDoOlhoDireito.getSelectedItem().toString());
        gato.setCorOlhoEsquerdo(jComboBoxCorOlhoEsquerdo.getSelectedItem().toString());
        gato.setRaca(jComboBoxRaca.getSelectedItem().toString());
        gato.setNivelPreguica(jComboBoxNivelPreguica.getSelectedItem().toString());
        //JRadioButton
        gato.setSexo(jRadioButtonSexoM.isSelected()?'F':'M');
        gato.setSexo(jRadioButtonTossaSim.isSelected()?'S':'M');
        gato.setCirurgia(jRadioButtonCirurgiaSim.isSelected()?'S':'M');
        gato.setPedigree(jRadioButtonPedigreeSim.isSelected()?'S':'M');
        gato.setFilhotes(jRadioButtonFilhotesSim.isSelected()?'S':'M');
        gato.setCastrado(jRadioButtonCastradoSim.isSelected()?'S':'M');
  
        MenuDoSistema.gatos.set(posicao,gato);
        JOptionPane.showMessageDialog(null, "Capivara" + gato.getNome() + " alterado com sucesso!");

    }
    
    /**
     * Defini a transparência do botão.
     * @param jButton 
     */
    private void transparenciaDosBotaoGato(JButton jButton){
        jButton.setOpaque(false);
        jButton.setContentAreaFilled(false);
        jButton.setBorderPainted(false);
        jButton.setFocusPainted(false);
        
    }
    
    /**
     * Definir as posição do nome das variaveis.
     * JLabel
     */
    public void criarCamposDosNomesDasVariaveis(){
        //JTextField:
        //Nome:
        JLabel jLabelNome = new JLabel("Nome");
        jLabelNome.setFont(Settings.minhaFonte);
        jLabelNome.setBounds(15, 80, 50, 25);
        telaDeCadastroGatos.add(jLabelNome);
        //Nome do Dono:
        JLabel jLabelNomeDoDono = new JLabel("Nome do Dono");
        jLabelNomeDoDono.setFont(Settings.minhaFonte);
        jLabelNomeDoDono.setBounds(210, 80, 90, 25);
        telaDeCadastroGatos.add(jLabelNomeDoDono);
        //Ração
        JLabel jLabelRacao = new JLabel("Ração");
        jLabelRacao.setFont(Settings.minhaFonte);
        jLabelRacao.setBounds(455, 80, 40, 25);
        telaDeCadastroGatos.add(jLabelRacao);
        
        //JFormattedTextField:
        //Peso:
        JLabel jLabelPeso = new JLabel("Peso");
        jLabelPeso.setFont(Settings.minhaFonte);
        jLabelPeso.setBounds(15, 130, 50, 25);
        telaDeCadastroGatos.add(jLabelPeso);
        //Altura:
        JLabel jLabelAltura = new JLabel("Altura");
        jLabelAltura.setFont(Settings.minhaFonte);
        jLabelAltura.setBounds(160, 130, 50, 25);
        telaDeCadastroGatos.add(jLabelAltura);
        //Comprimento:
        JLabel jLabelComprimento = new JLabel("Comprimento");
        jLabelComprimento.setFont(Settings.minhaFonte);
        jLabelComprimento.setBounds(290, 130, 85, 25);
        telaDeCadastroGatos.add(jLabelComprimento);
        //QtdVidas:
        JLabel jLabelQtdVidas= new JLabel("Quantidade de vidas");
        jLabelQtdVidas.setFont(Settings.minhaFonte);
        jLabelQtdVidas.setBounds(450, 130, 130, 25);
        telaDeCadastroGatos.add(jLabelQtdVidas);
        //QtsFiosPelos:
        JLabel jLabelQtsFiosPelos= new JLabel("Quantidade de Fios de Pelos");
        jLabelQtsFiosPelos.setFont(Settings.minhaFonte);
        jLabelQtsFiosPelos.setBounds(15, 180, 180, 25);
        telaDeCadastroGatos.add(jLabelQtsFiosPelos);
        //idade 
        JLabel jLabelIdade= new JLabel("Idade");
        jLabelIdade.setFont(Settings.minhaFonte);
        jLabelIdade.setBounds(555, 180, 50, 25);
        telaDeCadastroGatos.add(jLabelIdade);
        
        //JComboBox:
        //CordaPataTraseiraDireita:
        JLabel jLabelCordaPataTraseiraDireita= new JLabel("Cor da Pata Traseira Direita");
        jLabelCordaPataTraseiraDireita.setFont(Settings.minhaFonte);
        jLabelCordaPataTraseiraDireita.setBounds(250, 180, 180, 25);
        telaDeCadastroGatos.add(jLabelCordaPataTraseiraDireita);
        //jComboBoxCorDaPataTraseiraEsquerda:
        JLabel jLabeljComboBoxCorDaPataTraseiraEsquerda= new JLabel("Cor da Pata Traseira Esquerda");
        jLabeljComboBoxCorDaPataTraseiraEsquerda.setFont(Settings.minhaFonte);
        jLabeljComboBoxCorDaPataTraseiraEsquerda.setBounds(15, 230, 180, 25);
        telaDeCadastroGatos.add(jLabeljComboBoxCorDaPataTraseiraEsquerda);
        //jComboBoxCorDaPataFrontalDireita:
        JLabel jLabeljComboBoxCorDaPataFrontalDireita= new JLabel("Cor da Pata Frontal Direita");
        jLabeljComboBoxCorDaPataFrontalDireita.setFont(Settings.minhaFonte);
        jLabeljComboBoxCorDaPataFrontalDireita.setBounds(325, 230, 180, 25);
        telaDeCadastroGatos.add(jLabeljComboBoxCorDaPataFrontalDireita);
        //jComboBoxCorDaPataFrontalEsquerda:
        JLabel jLabeljComboBoxCorDaPataFrontalEsquerda= new JLabel("Cor da Pata Frontal Esquerda");
        jLabeljComboBoxCorDaPataFrontalEsquerda.setFont(Settings.minhaFonte);
        jLabeljComboBoxCorDaPataFrontalEsquerda.setBounds(15, 280, 180, 25);
        telaDeCadastroGatos.add(jLabeljComboBoxCorDaPataFrontalEsquerda);
        //jComboBoxCorDoOlhoDireito:
        JLabel jLabeljComboBoxCorDoOlhoDireito= new JLabel("Cor Do Olho Direito");
        jLabeljComboBoxCorDoOlhoDireito.setFont(Settings.minhaFonte);
        jLabeljComboBoxCorDoOlhoDireito.setBounds(325, 280, 180, 25);
        telaDeCadastroGatos.add(jLabeljComboBoxCorDoOlhoDireito);
        //jComboBoxCorOlhoEsquerdo:
        JLabel jLabeljComboBoxCorOlhoEsquerdo = new JLabel("Cor Do Olho Esquerdo");
        jLabeljComboBoxCorOlhoEsquerdo.setFont(Settings.minhaFonte);
        jLabeljComboBoxCorOlhoEsquerdo.setBounds(15, 320, 180, 25);
        telaDeCadastroGatos.add(jLabeljComboBoxCorOlhoEsquerdo);
        //jComboBoxRaca:
        JLabel jLabeljComboBoxRaca = new JLabel("Raça");
        jLabeljComboBoxRaca.setFont(Settings.minhaFonte);
        jLabeljComboBoxRaca.setBounds(325, 320, 180, 25);
        telaDeCadastroGatos.add(jLabeljComboBoxRaca);
        //jComboBoxNivelPreguica:
        JLabel jLabeljComboBoxNivelPreguica = new JLabel("Nível de Preguica");
        jLabeljComboBoxNivelPreguica.setFont(Settings.minhaFonte);
        jLabeljComboBoxNivelPreguica.setBounds(15, 370, 180, 25);
        telaDeCadastroGatos.add(jLabeljComboBoxNivelPreguica);
        //jComboBoxQtdcirurgias:                                                                      ver --- fazer sumir
        JLabel jLabeljComboBoxQtdcirurgias = new JLabel("Quantidade de cirurgias");
        jLabeljComboBoxQtdcirurgias.setFont(Settings.minhaFonte);
        jLabeljComboBoxQtdcirurgias.setBounds(325, 370, 180, 25);
        telaDeCadastroGatos.add(jLabeljComboBoxQtdcirurgias);
        //jComboBoxQtdFilhotes:                                                                       ver --- fazer sumir
        JLabel jLabeljComboBoxQtdFilhotes = new JLabel("Quantidade de Filhotes");
        jLabeljComboBoxQtdFilhotes.setFont(Settings.minhaFonte);
        jLabeljComboBoxQtdFilhotes.setBounds(15, 420, 180, 25);
        telaDeCadastroGatos.add(jLabeljComboBoxQtdFilhotes);
        
        //JRadioButton:
        //jRadioButtonSexoM e jRadioButtonSexoF:                                                                    
        JLabel jLabelSexo = new JLabel("Sexo");
        jLabelSexo.setFont(Settings.minhaFonte);
        jLabelSexo.setBounds(325, 420, 180, 25);
        telaDeCadastroGatos.add(jLabelSexo);
        //jRadioButtonCirurgiaSim e jRadioButtonCirurgiaNao:                                                                     
        JLabel jLabelCirugia = new JLabel("Cirugia");
        jLabelCirugia.setFont(Settings.minhaFonte);
        jLabelCirugia.setBounds(555, 420, 180, 25);
        telaDeCadastroGatos.add(jLabelCirugia);
        //jRadioButtonPedigreeSim e jRadioButtonPedigreeNao:                                                                     
        JLabel jLabelPedigree= new JLabel("Pedigree");
        jLabelPedigree.setFont(Settings.minhaFonte);
        jLabelPedigree.setBounds(15, 470, 180, 25);
        telaDeCadastroGatos.add(jLabelPedigree);
        //jRadioButtonFilhotesSim e jRadioButtonFilhotesNao:                                                                      
        JLabel jLabelFilhote = new JLabel("Filhote");
        jLabelFilhote.setFont(Settings.minhaFonte);
        jLabelFilhote.setBounds(325, 470, 180, 25);
        telaDeCadastroGatos.add(jLabelFilhote);
        //RadioButtonCastradoSim e jRadioButtonCastradoNao:                                                                       
        JLabel jLabelCastrado = new JLabel("Castrado");
        jLabelCastrado.setFont(Settings.minhaFonte);
        jLabelCastrado.setBounds(555, 470, 180, 25);
        telaDeCadastroGatos.add(jLabelCastrado);
        //jRadioButtonTossaSim e jRadioButtonTossaNao:
        JLabel jLabelTossa = new JLabel("Tossa");
        jLabelTossa.setFont(Settings.minhaFonte);
        jLabelTossa.setBounds(15, 520, 180, 25);
        telaDeCadastroGatos.add(jLabelTossa);
        
        
    }
    
    /**
     * Definir sua posição e Características dos campos JTextField na tela.
     */
    public void criarCamposJTextField(){
        //Nome:
        jTextFieldNome = new JTextField();
        jTextFieldNome.setFont(Settings.minhaFonte);
        jTextFieldNome.setBounds(55, 80, 150, 25);
        telaDeCadastroGatos.add(jTextFieldNome);
        //Nome do Dono:
        jTextFieldNomeDono = new JTextField();
        jTextFieldNomeDono.setFont(Settings.minhaFonte);
        jTextFieldNomeDono.setBounds(300, 80, 150, 25);
        telaDeCadastroGatos.add(jTextFieldNomeDono);
        //Ração
        jTextFieldRacao = new JTextField();
        jTextFieldRacao.setFont(Settings.minhaFonte);
        jTextFieldRacao.setBounds(500, 80, 150, 25);
        telaDeCadastroGatos.add(jTextFieldRacao);
        
        
        
        
    }
    
    /**
     * Definir sua posição e Características dos campos JFormattedTextField na tela.
     */
    public void criarCamposJFormattedTextField(){
        //Peso:
        try {
            MaskFormatter mascaraPeso = new MaskFormatter("#,## Kg");
            jFormattedTextFieldPeso = new JFormattedTextField(mascaraPeso);
        } catch (ParseException parse) {
            JOptionPane.showMessageDialog(null,parse.getMessage());
            System.exit(0);
        }
        jFormattedTextFieldPeso.setBounds(55, 130, 60, 25);
        jFormattedTextFieldPeso.setFont(Settings.minhaFonte);
        telaDeCadastroGatos.add(jFormattedTextFieldPeso);
        //Altura:
        try {
            MaskFormatter mascaraAltura = new MaskFormatter("#,## M");
            jFormattedTextFieldAltura = new JFormattedTextField(mascaraAltura);
        } catch (ParseException parse) {
            JOptionPane.showMessageDialog(null,parse.getMessage());
            System.exit(0);
        }
        jFormattedTextFieldAltura.setBounds(200, 130, 50, 25);
        jFormattedTextFieldAltura.setFont(Settings.minhaFonte);
        telaDeCadastroGatos.add(jFormattedTextFieldAltura);
        //Comprimento
        try {
            MaskFormatter mascaraComprimento = new MaskFormatter("#,## M");
            jFormattedTextFieldComprimento = new JFormattedTextField(mascaraComprimento);
        } catch (ParseException parse) {
            JOptionPane.showMessageDialog(null,parse.getMessage());
            System.exit(0);
        }
        jFormattedTextFieldComprimento.setBounds(375, 130, 50, 25);
        jFormattedTextFieldComprimento.setFont(Settings.minhaFonte);
        telaDeCadastroGatos.add(jFormattedTextFieldComprimento);
        //QtdVidas:
        try {
            MaskFormatter mascaraComprimento = new MaskFormatter("##");
            jFormattedTextFieldQtdVidas = new JFormattedTextField(mascaraComprimento);
        } catch (ParseException parse) {
            JOptionPane.showMessageDialog(null,parse.getMessage());
            System.exit(0);
        }
        jFormattedTextFieldQtdVidas.setBounds(580, 130, 25, 25);
        jFormattedTextFieldQtdVidas.setFont(Settings.minhaFonte);
        telaDeCadastroGatos.add(jFormattedTextFieldQtdVidas);
        //QtsFiosPelos:
        try {
            MaskFormatter mascaraComprimento = new MaskFormatter("###");
            jFormattedTextFieldQtsFiosPelos = new JFormattedTextField(mascaraComprimento);
        } catch (ParseException parse) {
            JOptionPane.showMessageDialog(null,parse.getMessage());
            System.exit(0);
        }
        jFormattedTextFieldQtsFiosPelos.setBounds(185, 180, 35, 25);
        jFormattedTextFieldQtsFiosPelos.setFont(Settings.minhaFonte);
        telaDeCadastroGatos.add(jFormattedTextFieldQtsFiosPelos);
        //idade:
        try {
            MaskFormatter mascaraComprimento = new MaskFormatter("##");
            jFormattedTextFieldidade = new JFormattedTextField(mascaraComprimento);
        } catch (ParseException parse) {
            JOptionPane.showMessageDialog(null,parse.getMessage());
            System.exit(0);
        }
        jFormattedTextFieldidade.setBounds(600, 180, 35, 25);
        jFormattedTextFieldidade.setFont(Settings.minhaFonte);
        telaDeCadastroGatos.add(jFormattedTextFieldidade);
        
        
    }
    
    /**
     * Definir sua posição e Características dos campos JComboBox na tela.
     */
    public void criarCamposJComboBox(){
        //CordaPataTraseiraDireita
        jComboBoxCordaPataTraseiraDireita = new JComboBox();
        jComboBoxCordaPataTraseiraDireita.setBounds(415, 180, 90, 25);
        telaDeCadastroGatos.add(jComboBoxCordaPataTraseiraDireita);
        //jComboBoxCorDaPataTraseiraEsquerda
        jComboBoxCorDaPataTraseiraEsquerda = new JComboBox();
        jComboBoxCorDaPataTraseiraEsquerda.setBounds(200, 230, 90, 25);
        telaDeCadastroGatos.add(jComboBoxCorDaPataTraseiraEsquerda);
        //jComboBoxCorDaPataFrontalDireita
        jComboBoxCorDaPataFrontalDireita = new JComboBox();
        jComboBoxCorDaPataFrontalDireita.setBounds(480, 230, 90, 25);
        telaDeCadastroGatos.add(jComboBoxCorDaPataFrontalDireita);
        //jComboBoxCorDaPataFrontalEsquerda:
        jComboBoxCorDaPataFrontalEsquerda = new JComboBox();
        jComboBoxCorDaPataFrontalEsquerda.setBounds(200, 280, 90, 25);
        telaDeCadastroGatos.add(jComboBoxCorDaPataFrontalEsquerda);
        //jComboBoxCorDoOlhoDireito:
        jComboBoxCorDoOlhoDireito = new JComboBox();
        jComboBoxCorDoOlhoDireito.setBounds(480, 280, 90, 25);
        telaDeCadastroGatos.add(jComboBoxCorDoOlhoDireito);
        //jComboBoxCorOlhoEsquerdo:
        jComboBoxCorOlhoEsquerdo = new JComboBox();
        jComboBoxCorOlhoEsquerdo.setBounds(200, 320, 90, 25);
        telaDeCadastroGatos.add(jComboBoxCorOlhoEsquerdo);
        //jComboBoxRaca:
        jComboBoxRaca= new JComboBox();
        jComboBoxRaca.setBounds(480, 320, 90, 25);
        telaDeCadastroGatos.add(jComboBoxRaca);
        //jComboBoxNivelPreguica:
        jComboBoxNivelPreguica= new JComboBox();
        jComboBoxNivelPreguica.setBounds(200, 370, 90, 25);
        telaDeCadastroGatos.add(jComboBoxNivelPreguica);
        //jComboBoxQtdcirurgias:
        jComboBoxQtdcirurgias= new JComboBox();
        jComboBoxQtdcirurgias.setBounds(480, 370, 90, 25);
        telaDeCadastroGatos.add(jComboBoxQtdcirurgias);
        //jComboBoxQtdFilhotes:
        jComboBoxQtdFilhotes= new JComboBox();
        jComboBoxQtdFilhotes.setBounds(200, 420, 90, 25);
        telaDeCadastroGatos.add(jComboBoxQtdFilhotes);
        
    }
    
    /**
     * Caracteristicas do JComboBox 
     * para o usuario escolher
     */
    private void opcaoJComboBoxCores(){
        //Cores:
        String [] cores = new String[]{"Branco","Preto","Vermelho","Laranja","Amarelo","Verde","Azul","Violeta"};
        Arrays.sort(cores);
        //CordaPataTraseiraDireita
        jComboBoxCordaPataTraseiraDireita.setModel(new DefaultComboBoxModel(cores));
        jComboBoxCordaPataTraseiraDireita.setSelectedIndex(-1);
        //jComboBoxCorDaPataTraseiraEsquerda
        jComboBoxCorDaPataTraseiraEsquerda.setModel(new DefaultComboBoxModel(cores));
        jComboBoxCorDaPataTraseiraEsquerda.setSelectedIndex(-1);
        //jComboBoxCorDaPataFrontalDireita
        jComboBoxCorDaPataFrontalDireita.setModel(new DefaultComboBoxModel(cores));
        jComboBoxCorDaPataFrontalDireita.setSelectedIndex(-1);
        //jComboBoxCorDaPataFrontalEsquerda:
        jComboBoxCorDaPataFrontalEsquerda.setModel(new DefaultComboBoxModel(cores));
        jComboBoxCorDaPataFrontalEsquerda.setSelectedIndex(-1);
        //jComboBoxCorDoOlhoDireito:
        jComboBoxCorDoOlhoDireito.setModel(new DefaultComboBoxModel(cores));
        jComboBoxCorDoOlhoDireito.setSelectedIndex(-1);
        //jComboBoxCorOlhoEsquerdo:
        jComboBoxCorOlhoEsquerdo.setModel(new DefaultComboBoxModel(cores));
        jComboBoxCorOlhoEsquerdo.setSelectedIndex(-1);
        //Raças:
        String [] racas = new String[]{"Persa","Siamês","Himalaia","Maine Coon","Angolá","Siberiano"};
        Arrays.sort(racas);
        //jComboBoxRaca:
        jComboBoxRaca.setModel(new DefaultComboBoxModel(racas));
        jComboBoxRaca.setSelectedIndex(-1);
        //Quantidades:
        String [] Qtd = new String[]{"01","02","03","04","05","06","06","07","8","09","10"};
        Arrays.sort(Qtd);
        //jComboBoxNivelPreguica
        jComboBoxNivelPreguica.setModel(new DefaultComboBoxModel(Qtd));
        jComboBoxNivelPreguica.setSelectedIndex(-1);
        //jComboBoxQtdcirurgias:
        jComboBoxQtdcirurgias.setModel(new DefaultComboBoxModel(Qtd));
        jComboBoxQtdcirurgias.setSelectedIndex(-1);
        //jComboBoxQtdFilhotes:
        jComboBoxQtdFilhotes.setModel(new DefaultComboBoxModel(Qtd));
        jComboBoxQtdFilhotes.setSelectedIndex(-1);
    }
    
    /**
     * Definir sua posição e Características dos campos JRadioButton na tela.
     */
    public void criarCamposJRadioButton(){
        //Sexo:
        jRadioButtonSexoM = new JRadioButton("Masculino");
        jRadioButtonSexoM.setBounds(360, 410, 150, 50);
        jRadioButtonSexoM.setOpaque(false);
        telaDeCadastroGatos.add(jRadioButtonSexoM);
       
        jRadioButtonSexoF = new JRadioButton("Ferminino");
        jRadioButtonSexoF.setBounds(450, 410, 150, 50);
        jRadioButtonSexoF.setOpaque(false);
        telaDeCadastroGatos.add(jRadioButtonSexoF);   
        //Cirurgia:
        jRadioButtonCirurgiaSim = new JRadioButton("Sim");
        jRadioButtonCirurgiaSim.setBounds(600, 410, 50, 50);
        jRadioButtonCirurgiaSim.setOpaque(false);
        telaDeCadastroGatos.add(jRadioButtonCirurgiaSim);
       
        jRadioButtonCirurgiaNao = new JRadioButton("Não");
        jRadioButtonCirurgiaNao.setBounds(655, 410, 50, 50);
        jRadioButtonCirurgiaNao.setOpaque(false);
        telaDeCadastroGatos.add(jRadioButtonCirurgiaNao); 
        //Pedigree:
        jRadioButtonPedigreeSim = new JRadioButton("Sim");
        jRadioButtonPedigreeSim.setBounds(95, 460, 50, 50);
        jRadioButtonPedigreeSim.setOpaque(false);
        telaDeCadastroGatos.add(jRadioButtonPedigreeSim);
       
        jRadioButtonPedigreeNao = new JRadioButton("Não");
        jRadioButtonPedigreeNao.setBounds(145, 460, 50, 50);
        jRadioButtonPedigreeNao.setOpaque(false);
        telaDeCadastroGatos.add(jRadioButtonPedigreeNao); 
        //Filhote:
        jRadioButtonFilhotesSim = new JRadioButton("Sim");
        jRadioButtonFilhotesSim.setBounds(360, 460, 50, 50);
        jRadioButtonFilhotesSim.setOpaque(false);
        telaDeCadastroGatos.add(jRadioButtonFilhotesSim);
       
        jRadioButtonFilhotesNao = new JRadioButton("Não");
        jRadioButtonFilhotesNao.setBounds(450, 460, 50, 50);
        jRadioButtonFilhotesNao.setOpaque(false);
        telaDeCadastroGatos.add(jRadioButtonFilhotesNao); 
        //Castrado
        jRadioButtonCastradoSim = new JRadioButton("Sim");
        jRadioButtonCastradoSim.setBounds(610, 460, 50, 50);
        jRadioButtonCastradoSim.setOpaque(false);
        telaDeCadastroGatos.add(jRadioButtonCastradoSim);
       
        jRadioButtonCastradoNao = new JRadioButton("Não");
        jRadioButtonCastradoNao.setBounds(665, 460, 50, 50);
        jRadioButtonCastradoNao.setOpaque(false);
        telaDeCadastroGatos.add(jRadioButtonCastradoNao); 
        //Tossa:
        jRadioButtonTossaSim = new JRadioButton("Sim");
        jRadioButtonTossaSim.setBounds(95, 510, 50, 50);
        jRadioButtonTossaSim.setOpaque(false);
        telaDeCadastroGatos.add(jRadioButtonTossaSim);
       
        jRadioButtonTossaNao = new JRadioButton("Não");
        jRadioButtonTossaNao.setBounds(145, 510, 50, 50);
        jRadioButtonTossaNao.setOpaque(false);
        telaDeCadastroGatos.add(jRadioButtonTossaNao); 
    }
   
    /**
     * Permite que aprenas um JRadioButton seja selecionado por vez pelo usuário
     */
    private void  validaSomenteUmClickJRadioButton(){
        //Sexo:
        buttonGroupSexo = new ButtonGroup();
        buttonGroupSexo.add(jRadioButtonSexoF);
        buttonGroupSexo.add(jRadioButtonSexoM);
        //Cirurgia:
        buttonGroupSexo = new ButtonGroup();
        buttonGroupSexo.add(jRadioButtonCirurgiaSim);
        buttonGroupSexo.add(jRadioButtonCirurgiaNao);
        //Pedigree:
        buttonGroupCirurgia = new ButtonGroup();
        buttonGroupCirurgia.add(jRadioButtonPedigreeSim);
        buttonGroupCirurgia.add(jRadioButtonPedigreeNao); 
        //Filhote:
        buttonGroupFilhotes = new ButtonGroup();
        buttonGroupFilhotes.add(jRadioButtonFilhotesNao);
        buttonGroupFilhotes.add(jRadioButtonFilhotesSim);
        //Castrado:
        buttonGroupCastrado = new ButtonGroup();
        buttonGroupCastrado.add(jRadioButtonCastradoSim);
        buttonGroupCastrado.add(jRadioButtonCastradoNao); 
        //Tossa:
        buttonGroupTossa = new ButtonGroup();
        buttonGroupTossa.add(jRadioButtonTossaSim);
        buttonGroupTossa.add(jRadioButtonTossaNao); 
    }
    
    
    
    
    
}
