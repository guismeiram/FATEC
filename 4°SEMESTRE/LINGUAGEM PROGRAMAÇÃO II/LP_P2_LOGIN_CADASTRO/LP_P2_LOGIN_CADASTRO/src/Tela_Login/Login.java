package Tela_Login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Data.ConnectingDb;
import Tela_Pesquisa.Pesquisa;
import Tela_Principal.TelaPrincipal;
import Tela_Usuario.Usuario;

public class Login extends JFrame {

	public JTextField campoLogin = new JTextField();
    public JPasswordField campoSenha = new JPasswordField();
    public JLabel lblStatus = new JLabel();
    public String sql;
    public ConnectingDb db =new ConnectingDb();
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Tela de login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        getContentPane().setBackground(new Color(10, 60, 100)); // Fundo azul escuro

        JLabel titulo = new JLabel("Formulário de login");
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setBounds(110, 10, 200, 30);
        getContentPane().add(titulo);

        // Campo login
        JLabel iconLogin = new JLabel("\uD83D\uDC64"); // Ícone de usuário
        iconLogin.setForeground(Color.WHITE);
        iconLogin.setBounds(60, 60, 30, 30);
        getContentPane().add(iconLogin);

       
        campoLogin.setBounds(100, 60, 200, 30);
        getContentPane().add(campoLogin);

     

        // Campo senha
        JLabel iconSenha = new JLabel("\uD83D\uDD12"); // Ícone de cadeado
        iconSenha.setForeground(Color.WHITE);
        iconSenha.setBounds(60, 100, 30, 30);
        getContentPane().add(iconSenha);

        campoSenha.setBounds(100, 100, 200, 30);
        getContentPane().add(campoSenha);

        
        
        JLabel checkLogin = new JLabel("\u2714"); // ✔️
        checkLogin.setForeground(Color.GREEN);
        checkLogin.setBounds(310, 60, 30, 30);
        getContentPane().add(checkLogin);
        
        conexao = db.conector();
        System.out.println(conexao);
        
        if (conexao != null){
            lblStatus.setText("Conectado!");
            
        } else{
            lblStatus.setText("Não Conectado!");
        }
        
        JLabel xSenha = new JLabel("\u274C"); // ❌
        xSenha.setForeground(Color.RED);
        xSenha.setBounds(310, 100, 30, 30);
        getContentPane().add(xSenha);
        // Botão Acessar
        JButton botaoAcessar = new JButton("Acessar");
        botaoAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logar();
			}
        });
        botaoAcessar.setBounds(120, 150, 150, 35);
        getContentPane().add(botaoAcessar);
        
        JButton esqueceuSenha = new JButton("Esqueceu a senha?");
        esqueceuSenha.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Pesquisa tela = new Pesquisa();
				tela.setVisible(true);
				dispose();
        	}
        });
        esqueceuSenha.setForeground(Color.BLACK);
        esqueceuSenha.setFont(new Font("Arial", Font.PLAIN, 12));
        esqueceuSenha.setBounds(50, 200, 150, 30);
        getContentPane().add(esqueceuSenha);

        JButton cadastreSe = new JButton("Cadastre-se aqui!");
        cadastreSe.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Usuario tela = new Usuario();
				tela.setVisible(true);
				dispose();
        	}
        });
        cadastreSe.setForeground(Color.BLACK);
        cadastreSe.setFont(new Font("Arial", Font.PLAIN, 12));
        cadastreSe.setBounds(220, 200, 150, 30);
        getContentPane().add(cadastreSe);

        // Exibe a janela
        setVisible(true);

	}
	
	
	public void logar(){
        String sql = "SELECT * FROM user WHERE email=? AND senha=?";
        //digite try CTRL+Espaço
    	db.conector();

        try {
        	
            pst = conexao.prepareStatement(sql);
            pst.setString(1, campoLogin.getText());
            //ALTERAÇÃO PARA CAPTURA DOS CARACTERES DA SENHA
            
            //pst.setString(2, txtSenha.getText());
            String captura_senha = new String(campoSenha.getPassword());
            pst.setString(2, captura_senha);
            
            rs = pst.executeQuery();
            
            if (rs.next()){
               
                 TelaPrincipal principal = new TelaPrincipal();
                 principal.setVisible(true);
                 this.dispose();
                 conexao.close();
                
            }else{
                JOptionPane.showMessageDialog(null, "Usuário/Senha Inválidos!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
	

}
