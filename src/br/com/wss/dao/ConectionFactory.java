package br.com.wss.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
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
            String arquivo = "C:\\Users\\william\\Documents\\NetBeansProjects\\Solutions\\config.ini";//local do arquivo    

            try {
                config.load(new FileInputStream(arquivo));

                String usuario = config.getProperty("usuario");
                String senha = config.getProperty("senha");
                String url = config.getProperty("localhost");
                String clasForName = config.getProperty("Class.forName");
                
                Class.forName(clasForName);
                conn = DriverManager.getConnection(url, usuario, senha);

            } catch (IOException | ClassNotFoundException | SQLException ex) {
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
