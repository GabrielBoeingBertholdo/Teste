/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gato;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import modelo.Gato;
import telasDeInicio.MenuDoSistema;
import telasDeInicio.Settings;

/**
 *
 * @author (name= Gabriel Boeing,date=07-22-2017)
 */
public class ListaDosGatos {
    
    //Tela do sistema:
    private JFrame telaDeListagemGatos;
    //Definir as colunas da tabela:
    private DefaultTableModel modelo;
    //Tabela:
    private JTable tabela;
    //Botões da tabela == excluir - alterar  - adicionar:
    private JButton excluir,alterar,adicionar;
    //Selecionar objeto para editar ou excluir:
    private int linhaSelecioadaGato = -1;
    

    public ListaDosGatos() {
        criarTelaDeGatos();
        criarTabelaDeListagem();
        criarBotoes();
        criarInformacaoDatela();
        opcoesTeclado();
        opcoesMouse();
        listagemDosGatos();
        definirOnClickTabela();
        telaDeListagemGatos.requestFocus();
    }
    
    /**
     * Defini o tamanho da tela e suas caracteristicas
     */
    public void criarTelaDeGatos(){
        telaDeListagemGatos = new JFrame("Tela de listagem de Gatos");
        telaDeListagemGatos.setFont(Settings.minhaFonte);
        telaDeListagemGatos.setContentPane(new JLabel(new ImageIcon(getClass().getResource(Settings.minhaImagens))));
        telaDeListagemGatos.setSize(900,725);
        telaDeListagemGatos.setLayout(null);
        telaDeListagemGatos.setResizable(false);
        telaDeListagemGatos.setLocationRelativeTo(null);
        telaDeListagemGatos.setVisible(true);
        telaDeListagemGatos.setIconImage(new ImageIcon(getClass().getResource("/imagens/cat.png")).getImage());
    }
    
    /**
     * Definir a tabela e suas Colunas.
     */
    public void criarTabelaDeListagem(){
        modelo = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabela = new JTable(modelo);
        modelo.addColumn("Pedrigre");
        modelo.addColumn("Nome do Dono");
        modelo.addColumn("Nome");
        modelo.addColumn("Cor do Olho Direito");
        modelo.addColumn("Cor do Olho Esquerdo");
        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBounds(15,30,780,650);
        telaDeListagemGatos.add(scroll);  
    }
    
    /**
     * Definir os botoes e suas localização na tela.
     */
    public void criarBotoes(){
        //Criar os botôes:
        ImageIcon adi = new ImageIcon(getClass().getResource("/imagens/alterar.png"));
        adicionar = new JButton(adi);
        ImageIcon alt = new ImageIcon(getClass().getResource("/imagens/change.png"));
        alterar = new JButton(alt);
        ImageIcon del = new ImageIcon(getClass().getResource("/imagens/deletar.png"));
        excluir = new JButton(del);
        //Tamanho e localização dos botões: 
        adicionar.setBounds(800 , 5, 65, 65);
        alterar.setBounds(800 , 75, 65, 65);
        excluir.setBounds(800 , 145, 65, 65);
        //Adicionar os botões:
        telaDeListagemGatos.add(adicionar);
        telaDeListagemGatos.add(alterar);
        telaDeListagemGatos.add(excluir);    
    }
    
    /**
     * Texto de ajuda ao usuário ao uso de atalhos do teclado.
     */
    public void criarInformacaoDatela(){
        //Caracteristicas do texto.
        JLabel JLabelInformacao = new JLabel("F1 - CADASTRO / F2 - ALTERAR / F3 - EXCLUIR");
        JLabelInformacao.setFont(Settings.minhaFonte);
        JLabelInformacao.setBounds(5, 5 , 300, 25);
        telaDeListagemGatos.add(JLabelInformacao);
    }
    
    /**
     * Definir as opções de atalhos do teclado.
     */
    public void opcoesTeclado(){
        telaDeListagemGatos.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ss ){
                switch(ss.getKeyCode()){
                    case KeyEvent.VK_ESCAPE:
                        telaDeListagemGatos.dispose();
                    break;
                    case KeyEvent.VK_F1:
                        acaoAdicioar();
                         telaDeListagemGatos.requestFocus();
                    break;
                    case KeyEvent.VK_F2:
                        acaoEditar();
                         telaDeListagemGatos.requestFocus();
                    break;
                    case KeyEvent.VK_F3:
                        acaoExcluir();
                         telaDeListagemGatos.requestFocus();
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
                acaoAdicioar();   
                 telaDeListagemGatos.requestFocus();
            }
        });
        //Botao Alterar:
        alterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                acaoEditar();
                 telaDeListagemGatos.requestFocus();
            }
        });
        //Botao Excluir:
        excluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                acaoExcluir();
                 telaDeListagemGatos.requestFocus();
            }
        });
        
    }
    
    /**
     *Acão Adicionar.
     */
    public void acaoAdicioar(){
        CadastroGatos cadastroDoGatos = new CadastroGatos();
    }
    
    
    /**
     *Acão Editar.
     */
    public void acaoEditar(){
        if(linhaSelecioadaGato > -1){
            CadastroGatos cadastroDoGatos = new CadastroGatos(linhaSelecioadaGato);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione algum Gato");
        }
        
    }
    
    /**
     *Acão Excluir.
     */
    private void acaoExcluir() {
        if (linhaSelecioadaGato > -1) {
            String nome = MenuDoSistema.capivara.get(linhaSelecioadaGato).getNome();
            MenuDoSistema.capivara.remove(linhaSelecioadaGato);
            modelo.removeRow(linhaSelecioadaGato);
            linhaSelecioadaGato = -1;
            JOptionPane.showMessageDialog(null,
                    "Removido " + nome + " com sucesso!");
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um Gato", "Aviso", JOptionPane.WARNING_MESSAGE, new ImageIcon(getClass().getResource("/imagens/deletar.png")));
        }

    }
    
    private void listagemDosGatos(){
        modelo.setRowCount(0);
        for(int i = 0;i < MenuDoSistema.gatos.size();i++){
            Gato cacho = MenuDoSistema.gatos.get(i);
                modelo.addRow(new Object[]{
                    cacho.getPedigree(),
                    cacho.getNomeDono(),
                    cacho.getNome(),
                    cacho.getCorDoOlhoDireito(),
                    cacho.getCorOlhoEsquerdo()
                });
        }
    }
    
    /**
     * Permiti que o usuário trabalha em cima da tabela.
     */
    private void definirOnClickTabela() {
        tabela.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                linhaSelecioadaGato = tabela.getSelectedRow();
            }
        });
    }
     
     
    
}
