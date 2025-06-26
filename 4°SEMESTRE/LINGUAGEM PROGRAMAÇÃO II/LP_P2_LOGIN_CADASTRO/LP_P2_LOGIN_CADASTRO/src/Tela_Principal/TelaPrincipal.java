package Tela_Principal;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Data.ConnectingDb;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	private JTable tabela;
    private DefaultTableModel modeloTabela;
    public ConnectingDb db =new ConnectingDb();
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    JTextField campoNome = new JTextField();
    JTextField campoDuracao = new JTextField();
    JTextField campoGenero = new JTextField();
    public JLabel lblStatus = new JLabel();
    JTextField campoId = new JTextField(); 
    
    public TelaPrincipal() {
    	setTitle("Tela de Acesso");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela
        getContentPane().setLayout(null); // Usando layout nulo

        getContentPane().setBackground(new Color(10, 60, 100));
        
        table_update();
     
        
        // Conexão com o banco (simulado)
        conexao = db.conector();
        System.out.println(conexao);
        if (conexao != null) {
            lblStatus.setText("Conectado!");
        } else {
            lblStatus.setText("Não Conectado!");
        }

        // Campo ID
        JLabel lblId = new JLabel("ID:");
        lblId.setForeground(Color.WHITE);
        lblId.setFont(new Font("Arial", Font.BOLD, 14));
        lblId.setBounds(60, 20, 80, 25);
        getContentPane().add(lblId);

        campoId.setBounds(150, 20, 300, 25);
        getContentPane().add(campoId);

        // Campo Nome
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setForeground(Color.WHITE);
        lblNome.setFont(new Font("Arial", Font.BOLD, 14));
        lblNome.setBounds(60, 60, 80, 25);
        getContentPane().add(lblNome);

        campoNome.setBounds(150, 60, 300, 25);
        getContentPane().add(campoNome);

        // Campo Gênero
        JLabel lblGenero = new JLabel("Gênero:");
        lblGenero.setForeground(Color.WHITE);
        lblGenero.setFont(new Font("Arial", Font.BOLD, 14));
        lblGenero.setBounds(60, 100, 80, 25);
        getContentPane().add(lblGenero);

        campoGenero.setBounds(150, 100, 300, 25);
        getContentPane().add(campoGenero);

        // Campo Duração
        JLabel lblDuracao = new JLabel("Duração:");
        lblDuracao.setForeground(Color.WHITE);
        lblDuracao.setFont(new Font("Arial", Font.BOLD, 14));
        lblDuracao.setBounds(60, 140, 80, 25);
        getContentPane().add(lblDuracao);

        campoDuracao.setBounds(150, 140, 300, 25);
        getContentPane().add(campoDuracao);

        // Botões de ação
        JButton btnInsert = new JButton("Insert");
        btnInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionar();
            }
        });
        btnInsert.setBounds(150, 190, 100, 30);
        getContentPane().add(btnInsert);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                alterar();
            }
        });
        btnUpdate.setBounds(270, 190, 100, 30);
        getContentPane().add(btnUpdate);

        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		remover();
        	}
        });
        btnDelete.setBounds(390, 190, 100, 30);
        getContentPane().add(btnDelete);

        // Botões de consulta
        JButton btnSelectNome = new JButton("Select Por Nome");
        btnSelectNome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                consultarNome();
            }
        });
        btnSelectNome.setBounds(89, 240, 150, 30);
        getContentPane().add(btnSelectNome);

        JButton btnSelectId = new JButton("Select Por Id");
        btnSelectId.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                consultarId();
            }
        });
        btnSelectId.setBounds(259, 240, 150, 30);
        getContentPane().add(btnSelectId);

        JButton btnLimpar = new JButton("Limpar");
        btnLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                campoId.setText("");
                campoNome.setText("");
                campoGenero.setText("");
                campoDuracao.setText("");
            }
        });
        btnLimpar.setBounds(444, 240, 150, 30); // Corrigido para ficar separado
        getContentPane().add(btnLimpar);

        JButton btnSelectAll = new JButton("Select All");
        btnSelectAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Exibir todos os dados
                table_update();

            }
        });
        btnSelectAll.setBounds(259, 281, 150, 30);
        getContentPane().add(btnSelectAll);

        // Tabela para exibição dos dados
        modeloTabela = new DefaultTableModel(new Object[]{"ID", "Nome", "Gênero", "Duração"}, 0);
        tabela = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(60, 340, 576, 100); // Ajustei o tamanho da tabela
        getContentPane().add(scrollPane);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaPrincipal().setVisible(true);
        });
    }
    
    private void adicionar(){
        String sql = "INSERT INTO Filme(nome,genero,duracao) VALUES(?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, campoNome.getText());
            pst.setString(2, campoGenero.getText());
            pst.setString(3, campoDuracao.getText());
            if (campoNome.getText().isEmpty() || campoGenero.getText().isEmpty() || 
                    campoDuracao.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Preencha todos os campos obrigatórios!");
                
            } else {
                int adicionado = pst.executeUpdate();
            if (adicionado>0){
                JOptionPane.showMessageDialog(null,"Usuário adicionado com sucesso!");
                campoNome.setText(null);
                campoGenero.setText(null);
                campoDuracao.setText(null);                
            }
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void consultarNome(){
        String sql = "SELECT * FROM Filme WHERE nome=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, campoNome.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
            	campoNome.setText(rs.getString(2));
                campoGenero.setText(rs.getString(3));
                campoDuracao.setText(rs.getString(4));
            	campoId.setText(rs.getString(1));

               
            } else {
                JOptionPane.showMessageDialog(null,"Usuário não cadastrado!");
                campoNome.setText(null);
                campoGenero.setText(null);
                campoDuracao.setText(null);
                campoId.setText(null);

              
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void consultarId(){
        String sql = "SELECT * FROM Filme WHERE id=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, campoId.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
            	campoNome.setText(rs.getString(2));
                campoGenero.setText(rs.getString(3));
                campoDuracao.setText(rs.getString(4));
               
            } else {
                JOptionPane.showMessageDialog(null,"Usuário não cadastrado!");
                campoNome.setText(null);
                campoGenero.setText(null);
                campoDuracao.setText(null);
              
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void alterar(){
        String sql = "UPDATE Filme set nome=?, genero=?, duracao=? "
                + "WHERE id=?;";
        try {
            pst = conexao.prepareStatement(sql);
            //pst.setString(1, campoId.getText());
            pst.setString(1, campoNome.getText());
            pst.setString(2, campoGenero.getText());
            pst.setString(3, campoDuracao.getText());
            pst.setString(4, campoId.getText());
           
            if (campoId.getText().isEmpty() || campoNome.getText().isEmpty() || campoGenero.getText().isEmpty() || campoDuracao.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Preencha todos os campos obrigatórios!");
            } else {
                int adicionado = pst.executeUpdate();
                System.out.println(adicionado + " Passou aqui ");
                if (adicionado>0){
                    JOptionPane.showMessageDialog(null,"Dados do usuário alterado com sucesso!");
                    //System.out.println(adicionado + " Passou aqui");
                    //campoId.setText(null);
                    campoNome.setText(null);
                    campoGenero.setText(null);
                    campoDuracao.setText(null); 
                    campoId.setText(null);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void remover(){
        //antes de remover fazer uma confirmação de remoção
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja remover este usuário?",
                "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION){
            String sql = "DELETE FROM Filme WHERE id=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, campoId.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0){
                    JOptionPane.showMessageDialog(null, "Usuário removido com sucesso!");
                    campoId.setText(null);
                    campoNome.setText(null);
                    campoGenero.setText(null);
                    campoDuracao.setText(null);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
    private void table_update() {
        int CC;
        try {
            
            pst = conexao.prepareStatement("SELECT * FROM Filme");
            ResultSet Rs = pst.executeQuery();
            
            ResultSetMetaData RSMD = Rs.getMetaData();
            CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel) tabela.getModel();
            DFT.setRowCount(0);

            while (Rs.next()) {
                Vector v2 = new Vector();
           
                for (int ii = 1; ii <= CC; ii++) {
                    v2.add(Rs.getString("id"));
                    v2.add(Rs.getString("nome"));
                    v2.add(Rs.getString("genero"));
                    v2.add(Rs.getString("duracao"));
                }
                DFT.addRow(v2);
            }
        } catch (Exception e) {
        }
    }
    
}
