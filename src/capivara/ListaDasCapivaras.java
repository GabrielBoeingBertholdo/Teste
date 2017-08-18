/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capivara;

import cachorro.CachorroCadastroJFrame;
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
import modelo.Capivara;
import telasDeInicio.MenuDoSistema;
import telasDeInicio.Settings;

/**
 *
 * @author (name= Gabriel Boeing,date=07-21-2017)
 */
public class ListaDasCapivaras {
    
    private int linhaSelecioadaCapivara = -1;
    public JFrame telaListCapivara;
    private JTable tabela;
    private DefaultTableModel modelo;
    private JButton excluir,alterar,adicionar;

    public ListaDasCapivaras() {
        criarTelaDeListagemCapivara();
        tabelaDeListagem();
        botoesDaLista();
        localizacaoBotoesDaLista();
        botoesDaLista();
       // acaoBotaoAdicioar();
       criarInformacaoDatela();
        keyTecladoCadastroList();
        popularModelo(); 
       acaoBotaoAlterar();
        acaoBotaoExcluir();
        definirOnClikTabela();
       
        telaListCapivara.requestFocus();
    }
    
    public void criarTelaDeListagemCapivara(){
        telaListCapivara = new JFrame();
        telaListCapivara.setSize(900,700);
        telaListCapivara.setLayout(null);
        telaListCapivara.setTitle("Save the Capivara ");
        telaListCapivara.setResizable(false);
        telaListCapivara.setFont(Settings.minhaFonte);
        telaListCapivara.setLocationRelativeTo(null);
        telaListCapivara.setVisible(true);
        telaListCapivara.setContentPane(new JLabel(new ImageIcon(getClass().getResource(Settings.minhaImagens))));
        telaListCapivara.setIconImage(new ImageIcon(getClass().getResource("/imagens/capybara.jpg")).getImage());
        
    }
    /**
     * 
     * Defii a tabela e suas Colunas.
     */
    public void tabelaDeListagem(){

        modelo = new DefaultTableModel(){
      
        
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
         
        tabela = new JTable(modelo);
        
        //modelo.setFont(Settings.minhaFonte);
        modelo.addColumn("Nome");
        modelo.addColumn("Peso");
        modelo.addColumn("Altura");
        modelo.addColumn("Classificação de Natação");
        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBounds(15,30,780,650);
        telaListCapivara.add(scroll);
       
        
        
    }
    /**
     * Texto de ajuda ao usuário ao uso de atalhos do teclado.
     */
    public void criarInformacaoDatela(){
        //Caracteristicas do texto.
        JLabel JLabelInformacao = new JLabel("F1 - CADASTRO / F2 - ALTERAR / F3 - EXCLUIR");
        JLabelInformacao.setFont(Settings.minhaFonte);
        JLabelInformacao.setBounds(5, 5 , 300, 25);
        telaListCapivara.add(JLabelInformacao);
    }
    
    /**
     * Definir os botões;
     */
    public void botoesDaLista(){
        ImageIcon adi = new ImageIcon(getClass().getResource("/imagens/alterar.png"));
        adicionar = new JButton(adi);
        adicionar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                acaoAdicioar();
                telaListCapivara.requestFocus();
            }
        });
        
        
        ImageIcon alt = new ImageIcon(getClass().getResource("/imagens/change.png"));
        alterar = new JButton(alt);
        alterar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                acaoEditar();
                telaListCapivara.requestFocus();
            }
        });
        ImageIcon del = new ImageIcon(getClass().getResource("/imagens/deletar.png"));
        excluir = new JButton(del);
         excluir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                acaoExcluir();
                telaListCapivara.requestFocus();
            }
        });
        
        
    }
    /**
     * Adicionar os botoês na tela e defini a sua localização.
     */
    public void localizacaoBotoesDaLista(){
        adicionar.setBounds(800 , 5, 65, 65);
        alterar.setBounds(800 , 75, 65, 65);
        excluir.setBounds(800 , 145, 65, 65);
        
        telaListCapivara.add(adicionar);
        telaListCapivara.add(alterar);
        telaListCapivara.add(excluir);
        
    
    }
    
    /**
     * Chamada de classe
     */
    public void acaoAdicioar(){
       CadastroCapivara cadastra = new CadastroCapivara();
        
    }
  
    /**
     * Ação do click do botão.
     */ 
    public void acaoBotaoAlterar(){
        alterar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                telaListCapivara.requestFocus();
                acaoEditar();
                //AQUI !!!!!!!!!!!!!!!!!!!!!!!!!!!!
                telaListCapivara.requestFocus();
            }
        });
       
    }
    
    /**
     * Ação ao click do boão.
     */
    public void acaoBotaoExcluir(){
        excluir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                acaoExcluir();
                //AQUI !!!!!!!!!!!!!!!!!!!!!!!!!!!!
                telaListCapivara.requestFocus();
            }
        });
      
    }
    
    /**
    *Ação ao click de algum botão do teclado "atalho"
    */
    private void keyTecladoCadastroList(){
        telaListCapivara.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ss ){
                switch(ss.getKeyCode()){
                    case KeyEvent.VK_ESCAPE:
                        telaListCapivara.dispose();
                    break;
                    case KeyEvent.VK_F1:
                        acaoAdicioar();
                        //AQUI !!!!!!!!!!!!!!!!!!!!!!!!!!!! ADICIONAR
                        //telaListCapivara.dispose();
                    break;
                    case KeyEvent.VK_F2:
                        acaoEditar();
                        //AQUI !!!!!!!!!!!!!!!!!!!!!!!!!!!! ALTERAR
                        //tela tem que atualizar
                    break;
                    case KeyEvent.VK_F3:
                        acaoExcluir();
                        //AQUI !!!!!!!!!!!!!!!!!!!!!!!!!!!! EXCLUIR
                        //tela tem que atualizar
                    break;
                        
                    
                  
                     
                }
            }
        });
        
    }
     
    /**
     * Chamada de classe
     */ 
    private void acaoEditar(){
        if(linhaSelecioadaCapivara > -1){
            CadastroCapivara cad = new CadastroCapivara(linhaSelecioadaCapivara);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione alguma Capivara");
        }
        
    }
    
    /**
     * Ação do click na tabela.
     * Selecionar as linhas
     */
    private void definirOnClikTabela(){
        tabela.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                linhaSelecioadaCapivara = tabela.getSelectedRow();
            }
        });
    }
    
    /**
     * Ação para deletar algum objeto 
     * Selecionar linha
     */
    private void acaoExcluir() {
        if (linhaSelecioadaCapivara > -1) {
            String nome = MenuDoSistema.capivara
                    .get(linhaSelecioadaCapivara).getNome();
            MenuDoSistema.capivara.remove(linhaSelecioadaCapivara);
            modelo.removeRow(linhaSelecioadaCapivara);
            linhaSelecioadaCapivara = -1;
            JOptionPane.showMessageDialog(null,
                    "Removido " + nome + " com sucesso!");
        }else{
            JOptionPane.showMessageDialog(null,
                    "Selecione um capivara", "Aviso", 
                    JOptionPane.WARNING_MESSAGE, 
                    new ImageIcon(getClass()
                            .getResource("/imagens/deletar.png")));
        }

    }
    
    /**
     * Linhas da tabela
     */
    private void popularModelo(){
        modelo.setRowCount(0);
        for(int i = 0;i < MenuDoSistema.capivara.size();i++){
            Capivara cacho = MenuDoSistema.capivara.get(i);
              modelo.addRow(new Object[]{
                    cacho.getNome(),
                    cacho.getPeso(),
                    cacho.getAltura(),
                    cacho.getClasNatcao()
                });
            
        }
    }
     //linhaSelecioadaCapivara
    

    
    
}
