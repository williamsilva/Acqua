/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.dao;

import br.com.wss.modelo.Grupo;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author William
 */
public class GrupoDao {

    Connection conexao;
    PreparedStatement stms;
    ResultSet result;
    String sql;

    public GrupoDao() {
        conexao = ConectionFactory.getConnection();
    }

    public ArrayList<Grupo> listar() {
        ArrayList<Grupo> lista;
        lista = new ArrayList<>();

        Grupo grupoTemp;

        try {
            Statement statmen = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statmen.executeQuery("select * from Grupo order by nome");
            rs.first();
            do {
                grupoTemp = new Grupo();

                grupoTemp.setNome(rs.getString("nome"));
                grupoTemp.setDescricao(rs.getString("descricao"));
                grupoTemp.setDataCadastro(rs.getString("dataCadastro"));
                grupoTemp.setUltimaAlteracao(rs.getString("ultimaAlteracao"));
                grupoTemp.setIdGrupo(rs.getInt("idGrupo"));

                lista.add(grupoTemp);
            } while (rs.next());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return lista;
    }

    public void cadastrarGrupo(Grupo cadastrar) {
        sql = ("insert into grupo (nome,descricao,dataCadastro,ultimaAlteracao)values (?,?,?,?)");
        try {
            stms = conexao.prepareStatement(sql);
            stms.setString(1, cadastrar.getNome());
            stms.setString(2, cadastrar.getDescricao());
            stms.setString(3, cadastrar.getDataCadastro());
            stms.setString(4, cadastrar.getUltimaAlteracao());

            stms.execute();
            stms.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
        } catch (SQLException | HeadlessException error) {
            JOptionPane.showMessageDialog(null, "Erro ao Gravar dados. \n Erro:" + error);
        }
    }

    public void atualizar(Grupo atualizar) {

        sql = ("update Grupo set nome= ?, descricao = ?, ultimaAlteracao = ? where idGrupo = ?");

        try {
            stms = conexao.prepareStatement(sql);
            stms.setString(1, atualizar.getNome());
            stms.setString(2, atualizar.getDescricao());
            stms.setString(3, atualizar.getUltimaAlteracao());
            stms.setInt(4, atualizar.getIdGrupo());

            stms.execute();
            stms.close();

            JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados! " + error);
        }
    }

    public void deletar(Grupo deletar) {

        sql = "Delete from grupo where idGrupo = ?";
        try {
            stms = conexao.prepareStatement(sql);
            stms.setInt(1, deletar.getIdGrupo());
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

    public ArrayList<Object> listarGrupos() {

        ArrayList<Object> objetos = new ArrayList<>();

        try {
            sql = "select nome from grupo order by nome";
            stms = conexao.prepareStatement(sql);

            result = stms.executeQuery();

            while (result.next()) {
                objetos.add(result.getString("nome"));
            }
            stms.close();
        } catch (SQLException ex) {
            Logger.getLogger(GrupoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objetos;
    }

    public String buscarIdGrupo(String grupo) {
        String idGrupo = "";
        try {
            sql = "select idGrupo from grupo where nome = '" + grupo + "'";

            stms = conexao.prepareStatement(sql);
            result = stms.executeQuery();
            result.next();
            idGrupo = result.getString("idGrupo");

        } catch (SQLException ex) {
            Logger.getLogger(GrupoDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return idGrupo;
    }
    public String buscarNomeGrupo(String nome) {
        String nomeGrupo = "";
        try {
            sql = "select nome from grupo where idGrupo = '" + nome + "'";

            stms = conexao.prepareStatement(sql);
            result = stms.executeQuery();
            result.next();
            nomeGrupo = result.getString("nome");

        } catch (SQLException ex) {
            Logger.getLogger(GrupoDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return nomeGrupo;
    }
}
