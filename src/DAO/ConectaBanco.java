/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author WILLIAM
 */
public class ConectaBanco {

    public Statement stms;
    public ResultSet rs;
    private final String drive = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/teste";
    private final String usuario = "root";
    private final String senha = "123456789";
    public Connection conn;

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
            stms = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
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
