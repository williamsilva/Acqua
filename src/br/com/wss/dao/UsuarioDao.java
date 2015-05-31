package br.com.wss.dao;

import br.com.wss.modelo.Usuario;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class UsuarioDao {

    Connection conexao;
    PreparedStatement stms;
    ResultSet result;
    String sql;

    public UsuarioDao() {
        conexao = ConectionFactory.getConnection();
    }

    public Usuario logar(Usuario login) {
        Usuario usuario = null;
        try {
            sql = "select * from login where login = ? and senha = ?";
            stms = conexao.prepareStatement(sql);

            if (conexao != null) {
                stms.setString(1, login.getUsuario());
                stms.setString(2, login.getSenha());

                result = stms.executeQuery();

                if (result.next()) {
                    usuario = new Usuario();
                    usuario.setUsuario(result.getString("login"));
                    usuario.setSenha(result.getString("senha"));
                   // usuario.setNome(result.getString("nome"));
                }
                stms.close();
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
        return usuario;
    }

    public void cadastrarUsuario(Usuario usuario) {

        sql = "insert into login (Nome,Login,Senha,data_cadastro,ultima_auteracao,ativo) values (?,?,?,?,?,?)";
        try {
            stms = conexao.prepareStatement(sql);
            stms.setString(1, usuario.getNome());
            stms.setString(2, usuario.getUsuario());
            stms.setString(3, usuario.getSenha());
            stms.setString(4, usuario.getData_cadastro());
            stms.setString(5, usuario.getUltima_auteracao());
            stms.setString(6, usuario.getAtivo());

            stms.execute();
            stms.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro ao Gravar dados. \n Erro:" + error);
        }

    }

    public void atualizar(Usuario atualizar) {

        sql = "update login set nome = ?, login = ?, ultima_auteracao = ?,ativo = ? where idlogin = ?";

        try {
            stms = conexao.prepareStatement(sql);
            stms.setString(1, atualizar.getNome());
            stms.setString(2, atualizar.getUsuario());
            stms.setString(3,atualizar.getUltima_auteracao());
            stms.setString(4, atualizar.getAtivo());
            stms.setString(5,atualizar.getCodigo());

            stms.execute();
            stms.close();

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados!" + error);
        }
    }

    public void deletar(Usuario deletar) {
        sql = "Delete from login where Login = ?";
        try {
            stms = conexao.prepareStatement(sql);
            stms.setString(1, deletar.getUsuario());
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

    public ArrayList<Usuario> listar() {
        ArrayList<Usuario> lista;
        lista = new ArrayList<>();

        Usuario usuarioTemp;

        try {
            Statement stms = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stms.executeQuery("select * from login order by Nome");
            rs.first();
            do {
                usuarioTemp = new Usuario();
                usuarioTemp.setCodigo(rs.getString("idLogin"));
                usuarioTemp.setNome(rs.getString("nome"));
                usuarioTemp.setUsuario(rs.getString("login"));
                usuarioTemp.setData_cadastro(rs.getString("data_cadastro"));
                usuarioTemp.setUltima_auteracao(rs.getString("ultima_auteracao"));
                usuarioTemp.setAtivo(rs.getString("ativo"));

                lista.add(usuarioTemp);
            } while (rs.next());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return lista;
    }
}
