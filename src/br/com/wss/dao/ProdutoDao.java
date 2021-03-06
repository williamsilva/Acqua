/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.dao;

import br.com.wss.modelo.Produto;
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
public class ProdutoDao {

    Connection conexao;
    PreparedStatement stms;
    ResultSet rs;
    String sql;

    /**
     *
     */
    public ProdutoDao() {
        conexao = ConectionFactory.getConnection();
    }

    /**
     *
     * @return
     */
    public ArrayList<Produto> listar() {
        ArrayList<Produto> lista;
        lista = new ArrayList<>();

        Produto produtotemp;
        try {
            Statement statmen = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statmen.executeQuery("select "
                    + "        produto.id_produto,"
                    + "        produto.descricao,"
                    + "        produto.validade,"
                    + "        produto.valor,"
                    + "        produto.desconto,"
                    + "        produto.status,"
                    + "        produto.id_usuario_alt,"
                    + "        produto.id_usuario_cad,"
                    + "	       produto.ultima_alteracao,"
                    + "        produto.data_cadastro,"
                    + "        login.nome,"
                    + "(select login.nome from login where login.id_login = produto.id_usuario_cad) as usuario_cad"
                    + "  from produto left join login on produto.id_usuario_alt = login.id_login"
                    + "  order by produto.descricao");

            rs.first();
            do {
                produtotemp = new Produto();
                produtotemp.setDataCadastro(rs.getString("produto.data_cadastro"));
                produtotemp.setDesconto(rs.getString("produto.desconto"));
                produtotemp.setDescricao(rs.getString("produto.descricao"));
                produtotemp.setIdProduto(rs.getInt("produto.id_produto"));
                produtotemp.setIdUsuarioAlt(rs.getString("login.nome"));
                produtotemp.setIdUsuarioCad(rs.getString("usuario_cad"));
                produtotemp.setStatus(rs.getString("produto.status"));
                produtotemp.setUltimaAlteracao(rs.getString("produto.ultima_alteracao"));
                produtotemp.setValidade(rs.getString("produto.validade"));
                produtotemp.setValor(rs.getDouble("produto.valor"));

                lista.add(produtotemp);

            } while (rs.next());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return lista;
    }

    /**
     *
     * @param cadastra
     * @return
     */
    public boolean cadastrar(Produto cadastra) {
        boolean retorno;
        sql = "insert into produto (descricao,validade,valor,desconto,status,id_usuario_alt,id_usuario_cad,"
                + "ultima_alteracao,data_cadastro)values(?,?,?,?,?,?,?,?,?)";

        try {
            stms = conexao.prepareStatement(sql);
            stms.setString(1, cadastra.getDescricao());
            stms.setString(2, cadastra.getValidade());
            stms.setDouble(3, cadastra.getValor());
            stms.setString(4, cadastra.getDesconto());
            stms.setString(5, cadastra.getStatus());
            stms.setString(6, cadastra.getIdUsuarioAlt());
            stms.setString(7, cadastra.getIdUsuarioCad());
            stms.setString(8, cadastra.getUltimaAlteracao());
            stms.setString(9, cadastra.getDataCadastro());

            stms.execute();
            stms.close();
            retorno = true;
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
        } catch (SQLException | HeadlessException e) {
            retorno = false;            
            JOptionPane.showMessageDialog(null, "Produto " + "'" + cadastra.getDescricao() + "'" + " já Cadastrado...");
        }
        return retorno;
    }

    /**
     *
     * @param editar
     * @return
     */
    public boolean editar(Produto editar) {
        boolean retorno;
        sql = "update produto set descricao = ?,validade = ?,valor = ?,desconto = ?,"
                + "id_usuario_alt = ?,ultima_alteracao = ?"
                + "where id_produto = ?";
        try {
            stms = conexao.prepareStatement(sql);

            stms.setString(1, editar.getDescricao());
            stms.setString(2, editar.getValidade());
            stms.setDouble(3, editar.getValor());
            stms.setString(4, editar.getDesconto());
            stms.setString(5, editar.getIdUsuarioAlt());
            stms.setString(6, editar.getUltimaAlteracao());
            stms.setInt(7, editar.getIdProduto());

            stms.execute();
            stms.close();
            retorno = true;
            JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");
        } catch (SQLException | HeadlessException e) {
            retorno = false;
            JOptionPane.showMessageDialog(null, "Produto " + "'" + editar.getDescricao() + "'" + " já Cadastrado...");
        }
        return retorno;
    }

    /**
     *
     * @param deletar
     * @return
     */
    public boolean deletar(Produto deletar) {
        boolean retorno = false;
        sql = "Delete from produto where id_produto = ?";
        try {
            stms = conexao.prepareStatement(sql);
            stms.setInt(1, deletar.getIdProduto());
            int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza Excluir?", "Exclusão", JOptionPane.YES_NO_OPTION);
            if (confirma == JOptionPane.YES_OPTION) {
                stms.execute();
                stms.close();
                retorno = true;
                JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso!");
            }
        } catch (SQLException error) {
            retorno = false;
            JOptionPane.showMessageDialog(null, "NÃO FOI POSÍVEL CONCLUIR!\n\n" + "O item possui registros sendo utilizados!");
        }
        return retorno;
    }

    public boolean ativarProduto(Produto ativar) {
        boolean retorno;
        sql = "update produto set ultima_alteracao = ?,status = ?, id_usuario_alt =? where id_produto = ?";
        try {
            stms = conexao.prepareCall(sql);
            stms.setString(1, ativar.getUltimaAlteracao());
            stms.setString(2, ativar.getStatus());
            stms.setString(3, ativar.getIdUsuarioAlt());
            stms.setInt(4, ativar.getIdProduto());

            stms.execute();
            stms.close();
            retorno = true;
        } catch (SQLException error) {
            retorno = false;
            JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados!" + error);
        }
        return retorno;
    }
    
     public ArrayList listarProduto() {
        ArrayList<Object> objetos = new ArrayList<>();
        try {
            sql = "select descricao from produto where produto.status = 'sim' order by descricao";
            stms = conexao.prepareStatement(sql);
            rs = stms.executeQuery();
            while (rs.next()) {
                objetos.add(rs.getString("descricao"));
            }
            stms.close();
        } catch (SQLException ex) {
            Logger.getLogger(EstadoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objetos;
    }
}
