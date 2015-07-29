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
            ResultSet rs = statmen.executeQuery("SELECT \n"
                    + "		computador.nome_computador,\n"
                    + "        computador.mac_computador,\n"
                    + "        computador.data_cadastro,\n"
                    + "        computador.id_computador,\n"
                    + "		computador.ultima_alteracao,\n"
                    + "        computador.id_usuario_alt,\n"
                    + "        computador.id_usuario_cad,\n"
                    + "        login.nome\n"
                    + " FROM acqua_dados.computador left join login on computador.id_usuario_cad = login.id_login\n"
                    + " order by computador.nome_computador");
            rs.first();
            do {
                computadorTemp = new Computador();
                computadorTemp.setId(rs.getInt("id_computador"));
                computadorTemp.setComputador(rs.getString("nome_computador"));
                computadorTemp.setMac(rs.getString("mac_computador"));
                computadorTemp.setDataCadastro(rs.getString("data_cadastro"));
                computadorTemp.setUltimaAlteracao(rs.getString("ultima_alteracao"));
                computadorTemp.setIdUsuarioCad(rs.getString("login.nome"));
                computadorTemp.setIdUsuarioAlt(rs.getString("login.nome"));

                lista.add(computadorTemp);
            } while (rs.next());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return lista;
    }

    public void cadastrarComputador(Computador computador) {
        sql = ("insert into computador (nome_computador,mac_computador,"
                + "data_cadastro,ultima_alteracao,id_usuario_cad,id_usuario_alt)values (?,?,?,?,?,?)");
        try {
            stms = conexao.prepareStatement(sql);
            stms.setString(1, computador.getComputador());
            stms.setString(2, computador.getMac());
            stms.setString(3, computador.getDataCadastro());
            stms.setString(4, computador.getUltimaAlteracao());
            stms.setString(5, computador.getIdUsuarioCad());
            stms.setString(6, computador.getIdUsuarioAlt());

            stms.execute();
            stms.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
        } catch (SQLException | HeadlessException error) {
            JOptionPane.showMessageDialog(null, "Erro ao Gravar dados. \n Erro:" + error);
        }
    }

    public void atualizarComputador(Computador atualizar) {

        sql = ("update computador set nome_computador = ?, mac_computador = ?,"
                + " ultima_alteracao = ? ,Id_usuario_alt = ? where id_computador = ?");

        try {
            stms = conexao.prepareStatement(sql);
            stms.setString(1, atualizar.getComputador());
            stms.setString(2, atualizar.getMac());
            stms.setString(3, atualizar.getUltimaAlteracao());
            stms.setString(4, atualizar.getIdUsuarioAlt());
            stms.setInt(5, atualizar.getId());

            stms.execute();
            stms.close();
            JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados! " + error);
        }
    }

    public void deletar(Computador deletar) {

        sql = "Delete from computador where id_computador = ?";
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
