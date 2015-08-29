package br.com.wss.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            Properties config = new Properties();
            String arquivo = "C:\\WssSolutions\\br\\com\\wss\\Config\\WssSolution.ini";//local do arquivo    

            try {
                config.load(new FileInputStream(arquivo));
                
                String usuario = config.getProperty("USUARIO");
                String senha = config.getProperty("SENHA");
                String url = config.getProperty("REMOTO");
                                
                Class.forName("com.mysql.jdbc.Driver");

                conn = DriverManager.getConnection(url, usuario, senha);

            } catch (ClassNotFoundException | SQLException | IOException ex) {
                JOptionPane.showMessageDialog(null, ex);
                Logger.getLogger(ConectionFactory.class.getName()).log(Level.SEVERE, null, ex);
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
