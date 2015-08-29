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

    /**
     *
     */
    public GrupoDao() {
        conexao = ConectionFactory.getConnection();
    }

    /**
     *
     * @return
     */
    public ArrayList<Grupo> listar() {
        ArrayList<Grupo> lista;
        lista = new ArrayList<>();

        Grupo grupoTemp;

        try {
            Statement statmen = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statmen.executeQuery("SELECT \n"
                    + "	       grupo.data_cadastro,\n"
                    + "        grupo.descricao,\n"
                    + "        grupo.id_grupo,\n"
                    + "        grupo.id_usuario_alt,\n"
                    + "        grupo.id_usuario_cad,\n"
                    + "        grupo.nome_grupo,\n"
                    + "        grupo.ultima_alteracao,\n"
                    + "        login.nome,"
                    + "(select login.nome from login where login.id_login = grupo.id_usuario_cad) as usuario_cad"
                    + " from grupo left join login on grupo.id_usuario_alt = login.id_login\n"
                    + "order by grupo.nome_grupo");
            rs.first();
            do {
                grupoTemp = new Grupo();

                grupoTemp.setNomeGrupo(rs.getString("nome_grupo"));
                grupoTemp.setDescricao(rs.getString("descricao"));
                grupoTemp.setDataCadastro(rs.getString("data_cadastro"));
                grupoTemp.setUltimaAlteracao(rs.getString("ultima_alteracao"));
                grupoTemp.setIdGrupo(rs.getInt("id_grupo"));
                grupoTemp.setUsuarioAlt(rs.getString("login.nome"));
                grupoTemp.setUsuarioCad(rs.getString("usuario_cad"));

                lista.add(grupoTemp);
            } while (rs.next());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return lista;
    }

    /**
     *
     * @param cadastrar
     * @return
     */
    public boolean cadastrarGrupo(Grupo cadastrar) {
        boolean retorno;
        sql = ("insert into grupo (nome_grupo,descricao,data_cadastro,"
                + "ultima_alteracao,id_usuario_cad,id_usuario_alt)values (?,?,?,?,?,?)");
        try {
            stms = conexao.prepareStatement(sql);
            stms.setString(1, cadastrar.getNomeGrupo());
            stms.setString(2, cadastrar.getDescricao());
            stms.setString(3, cadastrar.getDataCadastro());
            stms.setString(4, cadastrar.getUltimaAlteracao());
            stms.setString(5, cadastrar.getUsuarioCad());
            stms.setString(6, cadastrar.getUsuarioAlt());

            stms.execute();
            stms.close();
            retorno = true;
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
        } catch (SQLException | HeadlessException error) {
            retorno = false;
            JOptionPane.showMessageDialog(null, "NÃO FOI POSÍVEL CONCLUIR!\n\n"+"Numero de registro " + "'" + cadastrar.getNomeGrupo() + "'" + " já existe...");
        }
        return retorno;
    }

    /**
     *
     * @param atualizar
     * @return
     */
    public boolean atualizar(Grupo atualizar) {
        boolean retorno;
        sql = ("update Grupo set nome_grupo= ?, descricao = ?, ultima_alteracao = ?,"
                + "id_usuario_alt = ? where id_grupo = ?");

        try {
            stms = conexao.prepareStatement(sql);
            stms.setString(1, atualizar.getNomeGrupo());
            stms.setString(2, atualizar.getDescricao());
            stms.setString(3, atualizar.getUltimaAlteracao());
            stms.setString(4, atualizar.getUsuarioAlt());
            stms.setInt(5, atualizar.getIdGrupo());

            stms.execute();
            stms.close();
            retorno = true;
            JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");
        } catch (SQLException error) {
            retorno = false;
            JOptionPane.showMessageDialog(null, "NÃO FOI POSÍVEL CONCLUIR!\n\n"+"Numero de registro " + "'" + atualizar.getNomeGrupo() + "'" + " já existe...");
        }
        return retorno;
    }

    /**
     *
     * @param deletar
     * @return
     */
    public boolean deletar(Grupo deletar) {
        boolean retorno = false;
        sql = "Delete from grupo where id_grupo = ?";
        try {
            stms = conexao.prepareStatement(sql);
            stms.setInt(1, deletar.getIdGrupo());
            int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza Excluir?", "Exclusão", JOptionPane.YES_NO_OPTION);
            if (confirma == JOptionPane.YES_OPTION) {
                stms.execute();
                stms.close();
                retorno = true;
                JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso!");
            }
        } catch (SQLException error) {
            retorno = false;
            JOptionPane.showMessageDialog(null, "NÃO FOI POSÍVEL CONCLUIR!\n\n"+"O item possui registros sendo utilizados!");
        }
        return retorno;
    }

    /**
     *
     * @return
     */
    public ArrayList<Object> listarGrupos() {

        ArrayList<Object> objetos = new ArrayList<>();

        try {
            sql = "select nome_grupo from grupo order by nome_grupo";
            stms = conexao.prepareStatement(sql);

            result = stms.executeQuery();

            while (result.next()) {
                objetos.add(result.getString("nome_grupo"));
            }
            stms.close();
        } catch (SQLException ex) {
            Logger.getLogger(GrupoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objetos;
    }

    /**
     *
     * @param grupo
     * @return
     */
    public String buscarIdGrupo(String grupo) {
        String idGrupo = "";
        try {
            sql = "select id_grupo from grupo where nome_grupo = '" + grupo + "'";

            stms = conexao.prepareStatement(sql);
            result = stms.executeQuery();
            result.next();
            idGrupo = result.getString("id_grupo");

        } catch (SQLException ex) {
            Logger.getLogger(GrupoDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return idGrupo;
    }

    /**
     *
     * @param nome
     * @return
     */
    public String buscarNomeGrupo(String nome) {
        String nomeGrupo = "";
        try {
            sql = "select nome_grupo from grupo where id_grupo = '" + nome + "'";
            stms = conexao.prepareStatement(sql);
            result = stms.executeQuery();
            result.next();
            nomeGrupo = result.getString("nome_grupo");

        } catch (SQLException ex) {
            Logger.getLogger(GrupoDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return nomeGrupo;
    }
}
