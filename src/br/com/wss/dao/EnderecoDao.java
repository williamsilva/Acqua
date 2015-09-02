/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.dao;

import br.com.wss.modelo.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author William
 */
public class EnderecoDao {

    Connection conexao;
    PreparedStatement stms;
    ResultSet result;
    String sql;

    public EnderecoDao() {
        conexao = ConectionFactory.getConnection();
    }

    public boolean cadastra(Endereco cadastrar) {
        boolean retorno;
        sql = "insert into endereco (cep,"
                + "     bairro,"
                + "     rua,"
                + "     id_cidade)values (?,?,?,?)";
        try {
            stms = conexao.prepareStatement(sql);

            stms.setLong(1, cadastrar.getCep());
            stms.setString(2, cadastrar.getBairro());
            stms.setString(3, cadastrar.getRua());
            stms.setInt(4, cadastrar.getIdCidade());

            stms.execute();
            stms.close();
            retorno = true;

        } catch (SQLException error) {
            retorno = false;
        }
        return retorno;
    }

    public boolean atualizar(Endereco atualizar) {
        boolean retorno;
        sql = "update endereco set "
                + "    cep = ?,"
                + "    bairro = ?,"
                + "    rua = ?,"
                + "    id_cidade = ? "
                + " where cep = ?";
        try {
            stms = conexao.prepareStatement(sql);

            stms.setLong(1, atualizar.getCep());
            stms.setString(2, atualizar.getBairro());
            stms.setString(3, atualizar.getRua());
            stms.setInt(4, atualizar.getIdCidade());
            stms.setLong(5, atualizar.getCep());

            stms.execute();
            stms.close();
            retorno = true;

        } catch (SQLException error) {
            retorno = false;
        }
        return retorno;
    }

    public String getIdEndereco(String cep) {
        String idEndereco = "";
        try {
            sql = "select id_endereco from endereco where cep = '" + cep + "'";

            stms = conexao.prepareStatement(sql);
            result = stms.executeQuery();
            result.next();
            idEndereco = result.getString("id_endereco");

        } catch (SQLException ex) {
            Logger.getLogger(EstadoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idEndereco;
    }

    public boolean getEndereco(int cep) {
        boolean retorno = false;
        try {
            sql = "select * from endereco where cep = '" + cep + "'";

            stms = conexao.prepareStatement(sql);
            result = stms.executeQuery();
            result.next();
            if (!result.getString("cep").equalsIgnoreCase(null)) {
                retorno = true;
            }
        } catch (SQLException ex) {
            retorno = false;
        }
        return retorno;
    }

    public boolean verifica(int cep) {
        boolean retorno = false;
        try {
            sql = "select * from endereco where cep = '" + cep + "'";

            stms = conexao.prepareStatement(sql);
            result = stms.executeQuery();

            if (result.first()) {
                retorno = true;
            }
        } catch (SQLException ex) {
            retorno = false;
        }
        return retorno;
    }
}
