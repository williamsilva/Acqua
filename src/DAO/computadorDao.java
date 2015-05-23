package DAO;

import MODELO.modelComputador;
import MODELO.modelUsuario;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class computadorDao {

    Connection conexao;
    PreparedStatement stms;
    ResultSet result;
    String sql;

    public computadorDao() {
        conexao = ConectionFactory.conectaBd();
    }

    public void cadastrarComputador(modelComputador computador) {
        sql = ("insert into computador (nome_computador,mac_computador,data_cadastro,ultima_auteracao)values (?,?,?,?)");
        try {
            stms = conexao.prepareStatement(sql);
            stms.setString(1, computador.getComputador());
            stms.setString(2, computador.getMac());
            stms.setString(3, computador.getData_cadastro());
            stms.setString(4, computador.getUltima_auteracao());

            stms.execute();
            stms.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
        } catch (SQLException | HeadlessException error) {
            JOptionPane.showMessageDialog(null, "Erro ao Gravar dados. \n Erro:" + error);
        }
    }

    public void atualizar(modelComputador atualizar) {

        sql = "update from computador nome_computador = ? mac_computador = ? ultima_auteracao where id_computador = ?";

        try {
            stms = conexao.prepareStatement(sql);
            stms.setString(1, atualizar.getComputador());
            stms.setString(2, atualizar.getMac());
            stms.setString(3, atualizar.getUltima_auteracao());
            stms.setInt(4,atualizar.getId());

            stms.execute();
            stms.close();

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados!" + error);
        }
    }

    public void deletar(modelComputador deletar) {
        sql = "Delete from computador where id_computador = ?";
        try {
            stms = conexao.prepareStatement(sql);
            stms.setInt(1, deletar.getId());
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
}
