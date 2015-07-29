/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.dao;

import br.com.wss.modelo.Estado;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Estatica
 */
public class EstadoDao {

    Connection conexao;
    PreparedStatement stms;
    ResultSet result;
    String sql;

    public EstadoDao() {
        conexao = ConectionFactory.getConnection();
    }

    public void cadastrarEstado(Estado estado) {
        try {
            sql = "insert into estado (idEstado,nome) values (?,?)";
            stms = conexao.prepareStatement(sql);

            if (conexao != null) {
                stms.setString(1, estado.getIdEstado());
                stms.setString(2, estado.getNome());

                stms.execute();
                stms.close();
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
        }

    }

    public ArrayList listarEstados() {

        ArrayList<Object> objetos = new ArrayList<>();

        try {
            sql = "select nome from estado order by nome";
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

    public String buscarIdEstado(String estado) {
        String idEstado = "";
        try {
            sql = "select idEstado from estado where nome ='" + estado + "'";
            stms = conexao.prepareStatement(sql);

            result = stms.executeQuery();

            result.next();
            idEstado = result.getString("idEstado");

        } catch (SQLException ex) {
            Logger.getLogger(EstadoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idEstado;

    }

//    public String buscarEstadoId(int id) {
//        String idEstado = "";
//        try {
//            sql = "select * from estado where id = " + id;
//            stms = conexao.prepareStatement(sql);
//            result = stms.executeQuery();
//
//            result.next();
//            idEstado = result.getString("nome");
//
//        } catch (SQLException ex) {
//            Logger.getLogger(EstadoDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return idEstado;
//
//    }
}
