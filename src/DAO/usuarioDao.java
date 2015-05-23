package DAO;

import MODELO.*;
import java.sql.*;
import javax.swing.*;

public class usuarioDao {

    Connection conexao;
    PreparedStatement stms;
    ResultSet result;
    String sql;

    public usuarioDao() {
        conexao = ConectionFactory.conectaBd();
    }

    public modelUsuario logar(modelUsuario login) {
        modelUsuario usuario = null;
        try {
            sql = "select * from login where login = ? and senha = ?";
            stms = conexao.prepareStatement(sql);

            if (conexao != null) {
                stms.setString(1, login.getUsuario());
                stms.setString(2, login.getSenha());

                result = stms.executeQuery();

                if (result.next()) {
                    usuario = new modelUsuario();
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

    public void cadastrarUsuario(modelUsuario usuario) {

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

    public void atualizar(modelUsuario atualizar) {

        sql = "Update login set nome = ?, login = ?,ativo = ?";

        try {
            stms = conexao.prepareStatement(sql);
            stms.setString(1, atualizar.getNome());
            stms.setString(2, atualizar.getUsuario());
            stms.setString(3, atualizar.getAtivo());

            stms.execute();
            stms.close();

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados!" + error);
        }
    }

    public void deletar(modelUsuario deletar) {
        sql = "Delete from login where Login = ?";
        try {
            stms = conexao.prepareStatement(sql);
            stms.setString(1, deletar.getUsuario());
            int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza Excluir?", "Exclusão", JOptionPane.YES_NO_OPTION);
            if (confirma == JOptionPane.YES_OPTION) {
                stms.execute();
                stms.close();
                JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso!");

            } else {
               // repaint();
            }

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar os dados!" + error);
        }
    }
}
