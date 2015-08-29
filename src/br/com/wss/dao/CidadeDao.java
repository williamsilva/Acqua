/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.dao;

import br.com.wss.modelo.Cidade;
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
 * @author Estatica
 */
public class CidadeDao {

    Connection conexao;
    PreparedStatement stms;
    ResultSet result;
    String sql;

    public CidadeDao() {
        conexao = ConectionFactory.getConnection();
    }

    public void cadastraCidade(Cidade cidade) {
        try {
            sql = "insert into cidade (nome,idEstado) values (?,?)";
            stms = conexao.prepareStatement(sql);

            if (conexao != null) {
                stms.setString(1, cidade.getNomeCidade());
                stms.setString(2, cidade.getIdEstado());

                stms.execute();
                stms.close();
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
    }

    public ArrayList listarCidade(Object idEstado) {
        ArrayList<Object> objetos = new ArrayList<>();
        try {
            sql = "select nome from cidade where idEstado = '" + idEstado + "' order by nome";
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
   
    public ArrayList listarTodasCidade() {
        ArrayList<Object> objetos = new ArrayList<>();
        try {
            sql = "select nome from cidade order by nome";
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

    public String getIdCidade(String cidade) {
        String idCidade = "";
        try {
            sql = "select id_Cidade from cidade where nome = '" + cidade + "'";

            stms = conexao.prepareStatement(sql);
            result = stms.executeQuery();
            result.next();
            idCidade = result.getString("id_Cidade");

        } catch (SQLException ex) {
            Logger.getLogger(EstadoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idCidade;
    }

    public String buscarCidadeId(String id) {
        String cidade = "";
        try {
            sql = "select nome from cidade where id_Cidade = " + id;

            stms = conexao.prepareStatement(sql);
            result = stms.executeQuery();
            result.next();
            cidade = (result.getString("nome"));
        } catch (SQLException ex) {
            Logger.getLogger(EstadoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
           return cidade;
    }

}
