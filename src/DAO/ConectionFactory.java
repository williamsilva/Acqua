package DAO;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author ACQUAMANIA
 */
public class ConectionFactory {

    public static Connection conectaBd() {
        Connection conexao = null;
        try {
            String url = "jdbc:mysql://localhost:3306/teste";
            String usuario = "root";
            String senha = "123456789";

            Class.forName("com.mysql.jdbc.Driver");

            conexao = DriverManager.getConnection(url, usuario, senha);

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return conexao;
    }
    
}
