/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.dao;

import br.com.wss.modelo.Manutencao;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author William
 */
public class ManutencaoDao {

    Connection conexao;
    PreparedStatement stms;
    ResultSet result;
    String sql;

    public ManutencaoDao() {
        conexao = ConectionFactory.getConnection();
    }

    public void cadastrarManutencao(Manutencao manutencao) {
//        sql = ("insert into manutencao ()");
//        try {
//            stms = conexao.prepareStatement(sql);
//            //stms.setString(1, computador.getComputador());
//            
//
//            stms.execute();
//            stms.close();
//            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
//        } catch (SQLException | HeadlessException error) {
//            JOptionPane.showMessageDialog(null, "Erro ao Gravar dados. \n Erro:" + error);
//        }
    }
    public void pesquisarBens(Manutencao pesquisar){
        sql = "select * from bens where numero_controle like ?";
        try {
            stms = conexao.prepareCall(sql);
            stms.setInt(1,pesquisar.getNumeroRegistro());
            
            stms.execute();            
            stms.close();
        }catch (SQLException | HeadlessException error) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar!!! \n Erro:" + error);
        }
    }

}
