package telasDeInicio;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.AncestorListener;

/**
 *
 * @author (name= Gabriel Boeing,date=07-17-2017)
 */
public class TelaDeLogin {

    //TELA:
    private JFrame tela;
    //BOTÃO DE ENTRADA NO SISTEMA:
    private JButton jButtonBotaoDeEntrada, jButtonFoto;
    //CONT DE VEZES QUE ERROU A SENHA OU USUÁRIO;
    private byte cont = 0;
    //CAMPO DE USUÁRIO E SENHA:
    private JTextField jTextFieldUsuario;
    private JPasswordField jPasswordFieldSenha;

    public TelaDeLogin() {
        //TELA:
        criarTelaDeLogin();
        tela.requestFocus();
        //BOTÃO:
        botaoDeEntrada();
        //OUTROS:
        usuario();
        senha();
        keyTeclado();
        tela.requestFocus();
    }

    /**
     * Tela de Login do sistema.
     */
    public void criarTelaDeLogin() {
        //CRIAÇÃO DA TELA.
        tela = new JFrame("LOGIN");
        //TAMANHO DA TELA.
        tela.setSize(450, 200);
        //COLOCAR A TELA EM VISIBILIDADE AO USUÁRIO.
        tela.setVisible(true);
        //LAYOUT DA TELA:
        tela.setLayout(null);
        //TELA INICIA NO MEIO:
        tela.setLocationRelativeTo(null);
        tela.setIconImage(new ImageIcon(getClass().getResource("/imagens/login.png")).getImage());
        //FECHAR A TELA:
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //TRAVAR A TELA, USUÁRIO NÃO PODE AUMENTAR A TELA:
        tela.setResizable(false);
        //CAPTURANDO AS COORDENADAS:
        tela.addMouseListener(new MouseAdapter() {
            @Override
            //mouseClicked ou mouseEntered
            public void mouseClicked(MouseEvent e) {
                tela.requestFocus();
            }
        });
    }

    /**
     * Botão de entrada do sistema.
     */
    public void botaoDeEntrada() {
        //CRIAÇÃO DO BOTÃO:
        jButtonBotaoDeEntrada = new JButton("ENTRAR");
        //LOCALIZAÇÃO DO BOTÃO E TAMANHO:
        jButtonBotaoDeEntrada.setBounds(350, 125, 80, 35);
        //ADICIONAR O BOTÃO A TELA DE LOGIN:
        tela.add(jButtonBotaoDeEntrada);
        //AÇÃO DO BOTÃO:
        jButtonBotaoDeEntrada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                acaoDoBotaoDeEntrada();
                tela.requestFocus();
            }
        });

        jButtonBotaoDeEntrada.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                ImageIcon ico = new ImageIcon(getClass().getResource("/imagens/user.png"));
                jButtonFoto = new JButton(ico);
                jButtonFoto.setBounds(325, 25, 80, 80);
                jButtonFoto.setVisible(true);
                tela.add(jButtonFoto);

                jButtonBotaoDeEntrada.setBackground(Color.BLUE);
                jButtonBotaoDeEntrada.setForeground(Color.MAGENTA);
            }

            public void mouseExited(MouseEvent evt) {
                jButtonBotaoDeEntrada.setBackground(Color.BLUE);
                jButtonBotaoDeEntrada.setForeground(Color.GREEN);

            }

            public void mousePressed(MouseEvent evt) {

                jButtonBotaoDeEntrada.setBackground(Color.ORANGE);
                jButtonBotaoDeEntrada.setForeground(Color.darkGray);
                

            }

            public void mouseReleased(MouseEvent evt) {

                jButtonBotaoDeEntrada.setBackground(Color.WHITE);
                jButtonBotaoDeEntrada.setForeground(Color.BLACK);

            }

        });

    }

    /**
     * CAMPO DE TEXTO DA USUÁRIO:
     */
    private void usuario() {
        //CRIAÇÃO DO TEXTO 'USUÁRIO':
        JLabel jLabelUsuario = new JLabel("USUÁRIO");
        jLabelUsuario.setBounds(10, 25, 80, 25);
        tela.add(jLabelUsuario);

        //CRIAÇÃO DO CAMPO DE TEXTO PARA ESCREVER:
        jTextFieldUsuario = new JTextField();
        jTextFieldUsuario.setBounds(70, 25, 130, 25);
        tela.add(jTextFieldUsuario);
        tela.requestFocus();
    }

    /**
     * CAMPO DE TEXTO DA SENHA:
     */
    private void senha() {
        //CRIAÇÃO DO TEXTO 'SENHA':
        JLabel jLabelSenha = new JLabel("SENHA");
        jLabelSenha.setBounds(10, 80, 80, 25);
        tela.add(jLabelSenha);

        //CRIAÇÃO DO CAMPO DE TEXTO PARA ESCREVER:
        jPasswordFieldSenha = new JPasswordField();
        jPasswordFieldSenha.setBounds(70, 80, 130, 25);
        tela.add(jPasswordFieldSenha);

    }

    /**
     * AÇÃO DO BOTÃO DE ENTRADA DO SISTEMA:
     */
    private void acaoDoBotaoDeEntrada() {
        String usuarioAcesso = "admin";
        String senhaAcesso = "password";
        char[] senhaDoCampo = jPasswordFieldSenha.getPassword();
        String usuarioDoCampo = jTextFieldUsuario.getText();
        String senhaDoCampoEmString = String.valueOf(senhaDoCampo);
        String usuarioDoCampoEmString = String.valueOf(usuarioDoCampo);
        if ((senhaAcesso.equals(senhaDoCampoEmString)) && (usuarioAcesso.equals(usuarioDoCampoEmString))) {
            MenuDoSistema menuDeAcesso = new MenuDoSistema();
            tela.dispose();
        } else if (cont <= 2) {
            JOptionPane.showMessageDialog(null, "Usuário ou Senha incorreto");
            cont++;
        } else {
            JOptionPane.showMessageDialog(null, "Usuário ou Senha digitados 3 vezes !!");
            System.exit(0);
        }
    }

    /**
     * AÇÃO DO TECLADO:
     */
    public void keyTeclado() {
        tela.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ss) {
                switch (ss.getKeyCode()) {
                    case KeyEvent.VK_ENTER:
                        acaoDoBotaoDeEntrada();
                        break;
                    case KeyEvent.VK_ESCAPE:
                        System.exit(0);
                        break;

                }
            }
        });
    }

}
