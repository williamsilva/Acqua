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
        sql = "insert into usuario(codigo,usuario,senha,nome) values(?,?,?,?)";

        try {
            stms = conexao.prepareStatement(sql);

            stms.setString(1, usuario.getCodigo());
            stms.setString(2, usuario.getUsuario());
            stms.setString(3, usuario.getSenha());
            stms.setString(4, usuario.getNome());

            stms.execute();
            stms.close();

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }

    }
}
