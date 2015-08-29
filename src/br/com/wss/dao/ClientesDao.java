/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.dao;

import br.com.wss.modelo.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author William
 */
public class ClientesDao {
    Connection conexao;
    PreparedStatement stms;
    ResultSet rs;
    String sql;
    
    public ClientesDao(){
        conexao = ConectionFactory.getConnection();
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Clientes> listar() {
        ArrayList<Clientes> lista;
        lista = new ArrayList<>();

        Clientes clientesTemp;

        try {
            Statement statmen = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statmen.executeQuery("");
            rs.first();
            do {
                clientesTemp = new Clientes();
               // clientesTemp.setNome(rs.getString("nome"));
                
                lista.add(clientesTemp);
            } while (rs.next());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return lista;
    }

}
