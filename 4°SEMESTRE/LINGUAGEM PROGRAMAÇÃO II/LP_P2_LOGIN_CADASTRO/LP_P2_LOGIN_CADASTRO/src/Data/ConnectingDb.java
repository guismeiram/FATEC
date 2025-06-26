package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectingDb {
	 public static Connection conector(){
	        java.sql.Connection conexao = null;
	        //chamar o driver
	        String driver = "com.mysql.jdbc.Driver";
	        //Armazenando infos do banco
	        String url = "jdbc:mysql://localhost:3306/teste";
	        String user = "root";
	        String password = "1234";
	        //Estabelecer a conexao com o DB
	        try {
	            Class.forName(driver);
	            conexao = DriverManager.getConnection(url, user, password);
	            return conexao;
	        } catch (Exception e) {
	            return null;
	        }
	    }
}
