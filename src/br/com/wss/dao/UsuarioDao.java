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

    /**
     *
     */
    public UsuarioDao() {
        conexao = ConectionFactory.getConnection();
    }

    /**
     *
     * @param login
     * @return
     */
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
                    usuario.setLogado(result.getString("logado"));
                }
                stms.close();
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
        return usuario;
    }

    /**
     *
     * @param usuario
     * @return
     */
    public boolean cadastrarUsuario(Usuario usuario) {
        boolean retorno ;
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
            retorno = true;
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Nome de Usuário " + "'" + usuario.getUsuario() + "'" + " já existe...");
            retorno = false;
        }
        return retorno;
    }

    /**
     *
     * @param ativar
     * @return
     */
    public boolean ativarUsuario(Usuario ativar) {
        boolean retorno;
        sql = "update login set ultima_alteracao = ?,ativo = ?, id_usuario_alt =? where id_login = ?";
        try {
            stms = conexao.prepareCall(sql);
            stms.setString(1, ativar.getUltimaAlteracao());
            stms.setString(2, ativar.getAtivo());
            stms.setString(3, ativar.getIdUsuarioAlt());
            stms.setString(4, ativar.getCodigo());

            stms.execute();
            stms.close();
            retorno = true;
        } catch (SQLException error) {
            retorno = false;
            JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados!" + error);
        }
        return retorno;
    }

    /**
     *
     * @param libertar
     * @return
     */
    public boolean libertar(Usuario libertar) {
        boolean retorno;
        sql = "update login set logado = ? where id_login = ?";
        try {
            stms = conexao.prepareCall(sql);
            stms.setString(1, libertar.getLogado());
            stms.setString(2, libertar.getCodigo());

            stms.execute();
            stms.close();
            retorno = true;
        } catch (SQLException error) {
            retorno = false;
            JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados!" + error);
        }
        return retorno;
    }

    /**
     *
     * @param atualizar
     * @return
     */
    public boolean atualizar(Usuario atualizar) {
        boolean retorno;
        sql = "update login set nome = ?, login = ?, ultima_alteracao = ?,"
                + "senha = ?, id_usuario_alt =? where id_login = ?";

        try {
            stms = conexao.prepareStatement(sql);
            stms.setString(1, atualizar.getNome());
            stms.setString(2, atualizar.getUsuario());
            stms.setString(3, atualizar.getUltimaAlteracao());
            stms.setString(4, atualizar.getSenha());
            stms.setString(5, atualizar.getIdUsuarioAlt());
            stms.setString(6, atualizar.getCodigo());

            stms.execute();
            stms.close();
            retorno = true;
            JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");
        } catch (SQLException error) {
            retorno = false;
            JOptionPane.showMessageDialog(null, "Nome de Usuário " + "'" + atualizar.getUsuario() + "'" + " já existe...");
        }
        return retorno;
    }

    /**
     *
     * @param atualizar
     * @return
     */
    public boolean atualizarSenha(Usuario atualizar) {
        boolean retorno;
        sql = "update login set senha= ?, ultima_alteracao = ?,id_usuario_alt =? where login = ?";

        try {
            stms = conexao.prepareStatement(sql);
            stms.setString(1, atualizar.getSenha());
            stms.setString(2, atualizar.getUltimaAlteracao());
            stms.setString(3, atualizar.getIdUsuarioAlt());
            stms.setString(4, atualizar.getCodigo());

            stms.execute();
            stms.close();
            retorno = true;
            JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");
        } catch (SQLException error) {
            retorno = false;
            JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados!" + error);
        }
        return retorno;
    }

    /**
     *
     * @param deletar
     * @return
     */
    public boolean deletar(Usuario deletar) {
        boolean retorno = true;
        sql = "Delete from login where Login = ?";
        try {
            stms = conexao.prepareStatement(sql);
            stms.setString(1, deletar.getUsuario());
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
    public ArrayList<Usuario> listar() {
        ArrayList<Usuario> lista;
        lista = new ArrayList<>();

        Usuario usuarioTemp;

        try {
            Statement statmen = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statmen.executeQuery("SELECT \n"
                    + "	log.ativo,\n"
                    + "	log.data_cadastro,\n"
                    + "	log.id_login,\n"
                    + "	log.id_usuario_alt,\n"
                    + "	log.id_usuario_cad,\n"
                    + "	log.login,\n"
                    + "	log.nome,\n"
                    + "	LOG.SENHA,\n"
                    + "	LOG.LOGADO,\n"
                    + "	LOG.ULTIMA_ALTERACAO,\n"
                    + "	(SELECT logsbsql1.NOME FROM LOGIN logsbsql1 WHERE logsbsql1.ID_LOGIN = LOG.ID_USUARIO_CAD) AS USUARIO_CAD,\n"
                    + "	(SELECT logsbsql2.NOME FROM LOGIN logsbsql2 WHERE logsbsql2.ID_LOGIN = LOG.ID_USUARIO_ALT) AS USUARIO_ALT\n"
                    + "from login log \n"
                    + "order by log.nome");
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
                usuarioTemp.setIdUsuarioAlt(rs.getString("usuario_alt"));
                usuarioTemp.setIdUsuarioCad(rs.getString("usuario_cad"));
                usuarioTemp.setLogado(rs.getString("log.logado"));

                lista.add(usuarioTemp);
            } while (rs.next());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return lista;
    }

    /**
     *
     * @param buscar
     * @return
     */
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
