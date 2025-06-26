package Tela_Usuario;

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
import Tela_Login.Login;

public class Usuario extends JFrame {

	public JTextField campoLogin = new JTextField();
    public JPasswordField campoSenha = new JPasswordField();
    public ConnectingDb db =new ConnectingDb();
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    public JLabel lblStatus = new JLabel();

    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuario frame = new Usuario();
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
	public Usuario() {
		setTitle("Tela de Cadastro");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(10, 60, 100)); // Fundo azul escuro

		conexao = db.conector();
        System.out.println(conexao);
        if (conexao != null) {
            lblStatus.setText("Conectado!");
        } else {
            lblStatus.setText("Não Conectado!");
        }
		
		// Título
		JLabel titulo = new JLabel("Formulário de Cadastro");
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Arial", Font.BOLD, 18));
		titulo.setBounds(100, 20, 250, 30); // Centralizado
		getContentPane().add(titulo);

		// Labels
		JLabel login = new JLabel("Login:");
		login.setForeground(Color.WHITE);
		login.setFont(new Font("Arial", Font.BOLD, 14));
		login.setBounds(60, 80, 60, 25);
		getContentPane().add(login);

		JLabel senha = new JLabel("Senha:");
		senha.setForeground(Color.WHITE);
		senha.setFont(new Font("Arial", Font.BOLD, 14));
		senha.setBounds(60, 120, 60, 25);
		getContentPane().add(senha);

		// Campos
		campoLogin.setBounds(130, 80, 200, 25);
		getContentPane().add(campoLogin);

		campoSenha.setBounds(130, 120, 200, 25);
		getContentPane().add(campoSenha);
		
		   JButton btnCadastrar = new JButton("Cadastrar");
	        btnCadastrar.setBounds(140, 170, 120, 30);
	        getContentPane().add(btnCadastrar);
	        btnCadastrar.addActionListener(new ActionListener() {
	        	
	            public void actionPerformed(ActionEvent e) {
	            	//quando cadatrar já cair na tela de login
	            	adicionar();
	            	
	            	
	            }
	        });
	        
	 }
	
	private void adicionar(){
        String sql = "INSERT INTO user(email,senha) VALUES(?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, campoLogin.getText());
            pst.setString(2, campoSenha.getText());
            if (campoLogin.getText().isEmpty() || campoSenha.getText().isEmpty() ) {
                JOptionPane.showMessageDialog(null,"Preencha todos os campos obrigatórios!");
                
            } else {
                int adicionado = pst.executeUpdate();
            if (adicionado>0){
                JOptionPane.showMessageDialog(null,"Usuário adicionado com sucesso!");
                campoLogin.setText(null);
                campoSenha.setText(null);
                Login tela = new Login();
            	tela.setVisible(true);
				dispose();
            }
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}


