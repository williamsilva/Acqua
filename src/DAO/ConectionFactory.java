package DAO;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author ACQUAMANIA
 */
public class ConectionFactory {

    public Statement stms;
    public ResultSet rs;
    private final String drive = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/teste";
    private final String usuario = "root";
    private final String senha = "123456789";
    public Connection conn;

    public static Connection conectaBd() {

        Connection conexaoBd = null;
        try {
            String url = "jdbc:mysql://localhost:3306/teste";
            String usuario = "root";
            String senha = "123456789";

            Class.forName("com.mysql.jdbc.Driver");

            conexaoBd = DriverManager.getConnection(url, usuario, senha);

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return conexaoBd;
    }

    public void conexao() {
        try {
            System.setProperty("jdbc.Drivers", drive);
            conn = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de conexão:\n Erro" + ex.getMessage());
        }
    }

    public void executaSQL(String sql) {
        try {
            stms = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stms.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de Executa SQL:\n Erro" + ex.getMessage());
        }
    }

    public void desconecta() {
        try {
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao desconecta:\n Erro" + ex.getMessage());
        }
    }

}
