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

        sql = "insert into login (Nome,Login,Senha,dataCadastro,ultimaAlteracao,ativo) values (?,?,?,?,?,?)";
        try {
            stms = conexao.prepareStatement(sql);
            stms.setString(1, usuario.getNome());
            stms.setString(2, usuario.getUsuario());
            stms.setString(3, usuario.getSenha());
            stms.setString(4, usuario.getDataCadastro());
            stms.setString(5, usuario.getUltimaAlteracao());
            stms.setString(6, usuario.getAtivo());

            stms.execute();
            stms.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro ao Gravar dados. \n Erro:" + error);
        }

    }

    public void atualizar(Usuario atualizar) {

        sql = "update login set nome = ?, login = ?, ultimaAlteracao = ?,ativo = ?,senha = ? where idlogin = ?";

        try {
            stms = conexao.prepareStatement(sql);
            stms.setString(1, atualizar.getNome());
            stms.setString(2, atualizar.getUsuario());
            stms.setString(3, atualizar.getUltimaAlteracao());
            stms.setString(4, atualizar.getAtivo());
            stms.setString(5, atualizar.getSenha());
            stms.setString(6, atualizar.getCodigo());

            stms.execute();
            stms.close();

            JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados!" + error);
        }
    }

    public void atualizarSenha(Usuario atualizar) {

        sql = "update login set senha= ?, ultimaAlteracao = ? where login = ?";

        try {
            stms = conexao.prepareStatement(sql);
            stms.setString(1, atualizar.getSenha());
            stms.setString(2, atualizar.getUltimaAlteracao());
            stms.setString(3, atualizar.getUsuario());

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
            ResultSet rs = statmen.executeQuery("select * from Login order by Nome");
            rs.first();
            do {
                usuarioTemp = new Usuario();
                usuarioTemp.setCodigo(rs.getString("idLogin"));
                usuarioTemp.setNome(rs.getString("nome"));
                usuarioTemp.setUsuario(rs.getString("login"));
                usuarioTemp.setDataCadastro(rs.getString("dataCadastro"));
                usuarioTemp.setUltimaAlteracao(rs.getString("ultimaAlteracao"));
                usuarioTemp.setAtivo(rs.getString("ativo"));
                usuarioTemp.setSenha(rs.getString("senha"));

                lista.add(usuarioTemp);
            } while (rs.next());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return lista;
    }

    public String buscaUsuario(int buscar) {
        String usuario = null;
        sql = "Select login from login where idLogin = '" + buscar + "'";
        try {
            stms = conexao.prepareStatement(sql);
            result = stms.executeQuery();
            usuario = result.getString("login");
            stms.close();
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
        return usuario;
    }
}
