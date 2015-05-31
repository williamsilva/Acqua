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
                String senha = "wssmty";

                Class.forName("com.mysql.jdbc.Driver");

                conn = DriverManager.getConnection(url, usuario, senha);

            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        return conn;
    }

//    public void executaSQL(String sql) {
//        try {
//            Statement stms = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            ResultSet rs = stms.executeQuery(sql);
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Erro de Executa SQL:\n Erro" + ex.getMessage());
//        }
//    }
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
