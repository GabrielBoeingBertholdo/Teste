package cachorro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
import modelo.Cachorro;
import telasDeInicio.MenuDoSistema;
import telasDeInicio.Settings;

/**
 *
 * @author (name= Gabriel Boeing,date=07-21-2017)
 */
public class CachorroListaJFrame extends JFrame{
    private int linhaSelecioada = -1;
    private JButton adicionar;
    private JButton alterar;
    private JButton excluir;

    //componente que nos permite visualizar informações
    //em forma de tabela porém é necessário um modelo
    //para que a tabela apresenta alguma informação
    private JTable tabela;
    //componente que nos permite dicionar as colunas e
    //as linha para tabela.
    private DefaultTableModel modelo;
    //componente que permite algum outro componente ter 
    //a barra de scroll tanto na vertical como na horizontal
    private JScrollPane scroll;
    
    public void criarTela(){
        setSize(900, 750);
        setLocationRelativeTo(null);
        setLayout(null);
        setTitle("Save the Capivara - Cachorro - Cadastro");
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(new JLabel(new ImageIcon(getClass().getResource(Settings.minhaImagens))));
        setIconImage(new ImageIcon(getClass().getResource("/imagens/dog.png")).getImage());
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ss ){
                switch(ss.getKeyCode()){
                    case KeyEvent.VK_ESCAPE:
                        dispose();
                    break;
                    
                }
            }
        });
        addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        
        });
        
        setVisible(true);
        
    }
    
   
    public void criarComponentes(){
        ImageIcon adi = new ImageIcon(getClass().getResource("/imagens/alterar.png"));
        adicionar = new JButton(adi);
        ImageIcon alt = new ImageIcon(getClass().getResource("/imagens/change.png"));
        alterar = new JButton(alt);
        ImageIcon del = new ImageIcon(getClass().getResource("/imagens/deletar.png"));
        excluir = new JButton(del);
        modelo = new DefaultTableModel(){
            //ele não permitir que o usuário
            //altere alguma célula na tabela
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };
        tabela = new JTable(modelo);
        //método que adiciona as colunas de modelo
        adicionarCabecalhoModelo();
       // tabela = new JTable()
       // tabela.setModel(modelo);   

        scroll = new JScrollPane(tabela);
        definirOnClikTabela();
      
 
    }
    
    private void adicionarCabecalhoModelo(){
        modelo.addColumn("Nome");
        modelo.addColumn("Raça");
        modelo.addColumn("Peso");
        modelo.addColumn("Sexo");
        modelo.addColumn("Estado Atual");

        
        
    }
    
    private void definirPosicoes(){
        adicionar.setBounds(650, 0, 65, 65);
        alterar.setBounds(725, 0, 65, 65);
        excluir.setBounds(800, 0, 65, 65);
        scroll.setBounds(10,80,800,600);
    }
    
    private void adicionarComponentes(){
        add(adicionar);
        add(alterar);
        add(excluir);
        add(scroll);

    }
    
    /**
     * method tem como utilidade adicioar as linhas
     * com as característica do cachorro ao modelo
     */
    private void popularModelo(){

        modelo.setRowCount(0);
        for(int i = 0;i < MenuDoSistema.cachorros.size();i++){
            Cachorro cacho = MenuDoSistema.cachorros.get(i);
            
            /*
            String estadoAtual = "";
            if (cacho.isVivo()){
                estadoAtual = "Vivo"; 
            }else{
                estadoAtual = "Morreu";
            }
            */
            //Famoso operador ternário
            String estadoAtual = cacho.isVivo() ? "Vivo" : "Morreu";
            
            
            String sexo = "";
            if (Character.toUpperCase(cacho.getSexo()) == 'M'){
           // if(cacho.getSexo() =='M'|| cacho.getSexo() == 'm'){
                sexo = "Macho";
            }else if (Character.toUpperCase(cacho.getSexo()) == 'F'){
                sexo = "Fêmea";
            }else{
                sexo = "Não foi defiido";
            }
            
              modelo.addRow(new Object[]{
                    cacho.getNome(),
                    cacho.getRaca(),
                    cacho.getPeso() + " Kg",
                    sexo,estadoAtual
                });
            
        }
    }
    private void acaoAdicionar(){
        CachorroCadastroJFrame cadastro = new CachorroCadastroJFrame();
        
    }
    
    private void acaoEditar(){
        if(linhaSelecioada > -1){
            CachorroCadastroJFrame cad = new CachorroCadastroJFrame(linhaSelecioada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione algum cachorro");
        }
        
    }
    
    private void acaoExcluir(){
        if(linhaSelecioada > -1){
            String nome= MenuDoSistema.cachorros.get(linhaSelecioada).getNome();
            MenuDoSistema.cachorros.remove(linhaSelecioada);
            modelo.removeRow(-1);
            linhaSelecioada = -1;
            JOptionPane.showMessageDialog(null, "Removido " + nome + " Com sucesso!");
           // requestFocus();
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um cachorro","Aviso",JOptionPane.WARNING_MESSAGE,new ImageIcon(getClass().getResource("/imagens/trash.png")));
        }
    }
    
    private void definirClickDosBotoes(){
        adicionar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                acaoAdicionar();
            }
        });
        
        alterar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                acaoEditar();
            }
        });
        
        excluir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                acaoExcluir();
            }
        });
        excluir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                acaoExcluir();
            }
        });
    }
    
    public CachorroListaJFrame(){
        criarTela();
        criarComponentes();
        definirPosicoes();
        definirClickDosBotoes();
        adicionarComponentes();
        popularModelo();
        requestFocus();
    }
    
    /**
     *Permite que o usuário 
     */
    private void definirOnClikTabela(){
        tabela.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                linhaSelecioada = tabela.getSelectedRow();
            }
        });
    }
  
    
}
