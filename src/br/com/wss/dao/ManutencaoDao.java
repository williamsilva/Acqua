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
import java.sql.Statement;
import java.util.ArrayList;
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

    /**
     *
     */
    public ManutencaoDao() {
        conexao = ConectionFactory.getConnection();
    }

    /**
     *
     * @return
     */
    public ArrayList<Manutencao> listar() {
        ArrayList<Manutencao> lista;
        lista = new ArrayList<>();

        Manutencao manutencaoTemp;

        try {
            Statement statmen = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statmen.executeQuery("select manutencao.id_manutencao,"
                    + " manutencao.responsavel, manutencao.altorizada, "
                    + " manutencao.contato, manutencao.descricao, manutencao.valor_conserto,"
                    + " manutencao.data_retorno, manutencao.data_saida, manutencao.id_bens,"
                    + " manutencao.data_cadastro,manutencao.ultima_alteracao,"
                    + " manutencao.fim_garantia_manutencao,"
                    + " bens.nome, bens.numero_controle"
                    + " from manutencao left join bens on manutencao.id_bens = bens.id_Bens");

            rs.first();
            do {
                manutencaoTemp = new Manutencao();
                manutencaoTemp.setNomeBens(rs.getString("bens.nome"));
                manutencaoTemp.setNumeroRegistro(rs.getString("bens.numero_controle"));
                manutencaoTemp.setAltorizada(rs.getString("altorizada"));
                manutencaoTemp.setResponsavel(rs.getString("responsavel"));
                manutencaoTemp.setDataRetorno(rs.getString("data_retorno"));
                manutencaoTemp.setDataSaida(rs.getString("data_saida"));
                manutencaoTemp.setContato(rs.getString("contato"));
                manutencaoTemp.setObservacoes(rs.getString("descricao"));
                manutencaoTemp.setValorConserto(rs.getDouble("valor_conserto"));
                manutencaoTemp.setIdManutecao(rs.getInt("id_manutencao"));
                manutencaoTemp.setInBens(rs.getInt("id_bens"));
                manutencaoTemp.setDataCadastro(rs.getString("data_cadastro"));
                manutencaoTemp.setUltimaAlteracao(rs.getString("ultima_alteracao"));
                manutencaoTemp.setFinalGarantia(rs.getString("manutencao.fim_garantia_manutencao"));

                lista.add(manutencaoTemp);
            } while (rs.next());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return lista;
    }

    /**
     *
     * @param manutencao
     * @param bens
     */
    public void cadastrarManutencao(Manutencao manutencao, String bens) {
        sql = ("insert into manutencao (altorizada, contato, data_retorno, "
                + "data_saida, descricao, responsavel, valor_conserto, id_bens, "
                + "id_usuario_cad,id_usuario_alt,data_cadastro,"
                + "ultima_alteracao,fim_garantia_manutencao) "
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
        try {
            stms = conexao.prepareStatement(sql);

            stms.setString(1, manutencao.getAltorizada());
            stms.setString(2, manutencao.getContato());
            stms.setString(3, manutencao.getDataRetorno());
            stms.setString(4, manutencao.getDataSaida());
            stms.setString(5, manutencao.getObservacoes());
            stms.setString(6, manutencao.getResponsavel());
            stms.setDouble(7, manutencao.getValorConserto());
            stms.setInt(8, Integer.parseInt(bens));
            stms.setString(9, manutencao.getUsuarioCad());
            stms.setString(10, manutencao.getUsuarioAlt());
            stms.setString(11, manutencao.getDataCadastro());
            stms.setString(12, manutencao.getUltimaAlteracao());
            stms.setString(13, manutencao.getFinalGarantia());

            stms.execute();
            stms.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
        } catch (SQLException | HeadlessException error) {
            JOptionPane.showMessageDialog(null, "Erro ao Gravar dados. \n Erro:" + error);
        }
    }

    /**
     *
     * @param manutencao
     * @param bens
     */
    public void atualizarManutencao(Manutencao manutencao, String bens) {
        sql = "update manutencao set altorizada = ?, contato = ?, data_retorno = ?, "
                + "data_saida = ?, descricao = ?, responsavel = ?, "
                + "valor_conserto = ?, id_bens = ?, "
                + "id_usuario_alt = ?,ultima_alteracao =?,fim_garantia_manutencao = ?"
                + " where id_manutencao = ?";

        try {
            stms = conexao.prepareStatement(sql);

            stms.setString(1, manutencao.getAltorizada());
            stms.setString(2, manutencao.getContato());
            stms.setString(3, manutencao.getDataRetorno());
            stms.setString(4, manutencao.getDataSaida());
            stms.setString(5, manutencao.getObservacoes());
            stms.setString(6, manutencao.getResponsavel());
            stms.setDouble(7, manutencao.getValorConserto());
            stms.setInt(8, Integer.parseInt(bens));
            stms.setString(9, manutencao.getUsuarioAlt());
            stms.setString(10, manutencao.getUltimaAlteracao());
            stms.setString(11, manutencao.getFinalGarantia());
            stms.setInt(12, manutencao.getIdManutecao());

            stms.execute();
            stms.close();

            JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");
        } catch (SQLException | HeadlessException error) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar dados. \n Erro:" + error);
        }
    }

    /**
     *
     * @param deletar
     */
    public void deletarManutencao(Manutencao deletar) {
        sql = "Delete from manutencao where id_manutencao = ?";
        try {
            stms = conexao.prepareStatement(sql);
            stms.setInt(1, deletar.getIdManutecao());
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

    /**
     *
     * @param atualizar
     */
    public void setGarantiaManutencao(Manutencao atualizar) {
        sql = "update bens set inicio_garantia_manutencao = ?,fim_garantia_manutencao = ?,"
                + "ultima_alteracao =?, id_usuario_alt =? where numero_controle= ?";
        try {
            stms = conexao.prepareStatement(sql);
            stms.setString(1, atualizar.getDataRetorno());
            stms.setString(2, atualizar.getFinalGarantia());
            stms.setString(3, atualizar.getUltimaAlteracao());
            stms.setString(4, atualizar.getUsuarioAlt());
            stms.setString(5, atualizar.getNumeroRegistro());

            stms.execute();
            stms.close();

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados! " + error);
        }

    }

}
