/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.dao;

import br.com.wss.modelo.Computador;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author William
 */
public class ComputadorDao {

    Connection conexao;
    PreparedStatement stms;
    ResultSet result;
    String sql;

    public ComputadorDao() {
        conexao = ConectionFactory.getConnection();
    }

    public ArrayList<Computador> listar() {
        ArrayList<Computador> lista;
        lista = new ArrayList<>();

        Computador computadorTemp;

        try {
            Statement statmen = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statmen.executeQuery("select * from computador order by nomeComputador");
            rs.first();
            do {
                computadorTemp = new Computador();
                computadorTemp.setId(rs.getInt("idComputador"));
                computadorTemp.setComputador(rs.getString("nomeComputador"));
                computadorTemp.setMac(rs.getString("macComputador"));
                computadorTemp.setDataCadastro(rs.getString("dataCadastro"));
                computadorTemp.setUltimaAlteracao(rs.getString("ultimaAlteracao"));

                lista.add(computadorTemp);
            } while (rs.next());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return lista;
    }

    public void cadastrarComputador(Computador computador) {
        sql = ("insert into computador (nomeComputador,macComputador,dataCadastro,ultimaAlteracao)values (?,?,?,?)");
        try {
            stms = conexao.prepareStatement(sql);
            stms.setString(1, computador.getComputador());
            stms.setString(2, computador.getMac());
            stms.setString(3, computador.getDataCadastro());
            stms.setString(4, computador.getUltimaAlteracao());

            stms.execute();
            stms.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
        } catch (SQLException | HeadlessException error) {
            JOptionPane.showMessageDialog(null, "Erro ao Gravar dados. \n Erro:" + error);
        }
    }

    public void atualizarComputador(Computador atualizar) {

        sql = ("update computador set nomeComputador = ?, macComputador = ?, ultimaAlteracao = ? where idComputador = ?");

        try {
            stms = conexao.prepareStatement(sql);
            stms.setString(1, atualizar.getComputador());
            stms.setString(2, atualizar.getMac());
            stms.setString(3, atualizar.getUltimaAlteracao());
            stms.setInt(4, atualizar.getId());

            stms.execute();
            stms.close();
            JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados! " + error);
        }
    }

    public void deletar(Computador deletar) {

        sql = "Delete from computador where idComputador = ?";
        try {
            stms = conexao.prepareStatement(sql);
            stms.setInt(1, deletar.getId());
            int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza Excluir?", "Exclusão", JOptionPane.YES_NO_OPTION);
            if (confirma == JOptionPane.YES_OPTION) {
                stms.execute();
                stms.close();
                JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso!");

            }

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar os dados!" + error);
        }
    }
}
