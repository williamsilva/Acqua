/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.dao;

import br.com.wss.modelo.Pais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author William
 */
public class PaisDao {

    Connection conexao;
    PreparedStatement stms;
    ResultSet result;
    String sql;

    /**
     *
     */
    public PaisDao() {
        conexao = ConectionFactory.getConnection();
    }

    /**
     *
     * @return
     */
    public ArrayList listarPais() {

        ArrayList<Object> objetos = new ArrayList<>();

        try {
            sql = "select nome from pais order by nome";
            stms = conexao.prepareStatement(sql);
            result = stms.executeQuery();
            while (result.next()) {
                objetos.add(result.getString("nome"));
            }
            stms.close();
        } catch (SQLException ex) {
            Logger.getLogger(EstadoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objetos;
    }

    /**
     *
     * @param pais
     * @return
     */
    public String buscarIdPais(String pais) {
        String idPais = "";
        try {
            sql = "select id_pais from pais where nome ='" + pais + "'";
            stms = conexao.prepareStatement(sql);
            result = stms.executeQuery();
            result.next();
            idPais = result.getString("id_pais");

        } catch (SQLException ex) {
            Logger.getLogger(EstadoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idPais;
    }
    
    public String buscarPais(String pais) {
        String idPais = "";
        try {
            sql = "select nome from pais where id_pais ='" + pais + "'";
            stms = conexao.prepareStatement(sql);
            result = stms.executeQuery();
            result.next();
            idPais = result.getString("nome");

        } catch (SQLException ex) {
            Logger.getLogger(EstadoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idPais;
    }

    public void cadastrarPais(Pais pais) {
        try {
            sql = "insert into pais (id_Pais,nome) values (?,?)";
            stms = conexao.prepareStatement(sql);

            if (conexao != null) {
                stms.setInt(1, pais.getIdPais());
                stms.setString(2, pais.getNomePais());

                stms.execute();
                stms.close();
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
    }
}
