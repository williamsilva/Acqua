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
                    usuario.setCodigo(result.getString("id_login"));
                    usuario.setNome(result.getString("nome"));

                }
                stms.close();
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
        return usuario;
    }

    public void cadastrarUsuario(Usuario usuario) {

        sql = "insert into login (Nome,Login,Senha,data_cadastro,ultima_alteracao,"
                + "ativo,id_usuario_cad,id_usuario_alt) values (?,?,?,?,?,?,?,?)";
        try {
            stms = conexao.prepareStatement(sql);
            stms.setString(1, usuario.getNome());
            stms.setString(2, usuario.getUsuario());
            stms.setString(3, usuario.getSenha());
            stms.setString(4, usuario.getDataCadastro());
            stms.setString(5, usuario.getUltimaAlteracao());
            stms.setString(6, usuario.getAtivo());
            stms.setString(7, usuario.getIdUsuarioCad());
            stms.setString(8, usuario.getIdUsuarioAlt());

            stms.execute();
            stms.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro ao Gravar dados. \n Erro:" + error);
        }

    }

    public void atualizar(Usuario atualizar) {

        sql = "update login set nome = ?, login = ?, ultima_alteracao = ?,"
                + "ativo = ?, senha = ?, id_usuario_alt =? where id_login = ?";

        try {
            stms = conexao.prepareStatement(sql);
            stms.setString(1, atualizar.getNome());
            stms.setString(2, atualizar.getUsuario());
            stms.setString(3, atualizar.getUltimaAlteracao());
            stms.setString(4, atualizar.getAtivo());
            stms.setString(5, atualizar.getSenha());
            stms.setString(6, atualizar.getIdUsuarioAlt());
            stms.setString(7, atualizar.getCodigo());

            stms.execute();
            stms.close();

            JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados!" + error);
        }
    }

    public void atualizarSenha(Usuario atualizar) {

        sql = "update login set senha= ?, ultima_alteracao = ?,id_usuario_alt =? where login = ?";

        try {
            stms = conexao.prepareStatement(sql);
            stms.setString(1, atualizar.getSenha());
            stms.setString(2, atualizar.getUltimaAlteracao());
            stms.setString(3, atualizar.getIdUsuarioAlt());
            stms.setString(4, atualizar.getCodigo());

            stms.execute();
            stms.close();

            JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");
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
            Statement statmen = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statmen.executeQuery("SELECT \n"
                    + "         login.ativo,\n"
                    + "        login.data_cadastro,\n"
                    + "        login.id_login,\n"
                    + "        login.id_usuario_alt,\n"
                    + "        login.id_usuario_cad,\n"
                    + "        login.login,\n"
                    + "        login.nome,\n"
                    + "        login.senha,\n"
                    + "        login.ultima_alteracao \n"
                    + " from login order by login.nome");
            rs.first();
            do {
                usuarioTemp = new Usuario();
                usuarioTemp.setCodigo(rs.getString("id_login"));
                usuarioTemp.setNome(rs.getString("nome"));
                usuarioTemp.setUsuario(rs.getString("login"));
                usuarioTemp.setDataCadastro(rs.getString("data_cadastro"));
                usuarioTemp.setUltimaAlteracao(rs.getString("ultima_alteracao"));
                usuarioTemp.setAtivo(rs.getString("ativo"));
                usuarioTemp.setSenha(rs.getString("senha"));
                usuarioTemp.setIdUsuarioAlt(rs.getString("nome"));
                usuarioTemp.setIdUsuarioCad(rs.getString("nome"));

                lista.add(usuarioTemp);
            } while (rs.next());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return lista;
    }

    public String buscaUsuario(String buscar) {
        String usuario = "";
        try {
            sql = "Select nome from login where id_login = '" + buscar + "'";
            stms = conexao.prepareStatement(sql);
            result = stms.executeQuery();
            result.next();
            usuario = result.getString("nome");
            stms.close();
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
        return usuario;
    }
}
