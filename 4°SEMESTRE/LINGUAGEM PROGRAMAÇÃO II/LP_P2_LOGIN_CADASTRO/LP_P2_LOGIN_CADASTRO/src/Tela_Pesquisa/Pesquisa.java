package Tela_Pesquisa;

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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Data.ConnectingDb;
import Tela_Senha.Senha;

public class Pesquisa extends JFrame {

	public JTextField campoLogin = new JTextField();
	   public ConnectingDb db =new ConnectingDb();
	    Connection conexao = null;
	    PreparedStatement pst = null;
	    ResultSet rs = null;
	    public JLabel lblStatus = new JLabel();
		JLabel login = new JLabel("Login:");


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pesquisa frame = new Pesquisa();
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
	public Pesquisa() {
		setTitle("Tela de Recuperação de Senha");
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
		JLabel titulo = new JLabel("Recuperação de Senha");
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Arial", Font.BOLD, 18));
		titulo.setBounds(100, 20, 250, 30); // Centralizado
		getContentPane().add(titulo);

		// Labels
		login.setForeground(Color.WHITE);
		login.setFont(new Font("Arial", Font.BOLD, 14));
		login.setBounds(60, 80, 60, 25);
		getContentPane().add(login);
		
		// Campos
		campoLogin.setBounds(130, 80, 200, 25);
		getContentPane().add(campoLogin);
		
		JButton pesquisar = new JButton("Pesquisar");
        pesquisar.setBounds(140, 170, 120, 30);
        getContentPane().add(pesquisar);
        pesquisar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// pesquisa e já vai para tela de atualização de senha "Senha"
				consultarEmail();
				
			}
        	
            
        });
	}
	
    private void consultarEmail(){
        String sql = "SELECT * FROM user WHERE email=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, campoLogin.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
            	campoLogin.setText(rs.getString(2));
            	JOptionPane.showMessageDialog(null, "E-mail encontrado em nossa base de dados!");
            	Senha tela = new Senha();
				tela.setVisible(true);
				dispose();
            } else {
                JOptionPane.showMessageDialog(null,"Usuário não cadastrado!");
                campoLogin.setText(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public JTextField getCampoLogin() {
    	return campoLogin;
    }

}
