package br.com.wss.dao;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author ACQUAMANIA
 */
public class ConectionFactory {

    private static Connection conn;

    private ConectionFactory() {
    }

    public static Connection getConnection() {

        if (conn == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/acqua_dados";
                String usuario = "root";
                String senha = "12345";

                Class.forName("com.mysql.jdbc.Driver");

                conn = DriverManager.getConnection(url, usuario, senha);

            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        return conn;
    }

    public static void desconecta() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao desconecta:\n Erro" + ex.getMessage());
        }
    }

}
