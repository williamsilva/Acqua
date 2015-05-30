package br.com.wss.dao;

import br.com.wss.modelo.Computador;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ComputadorDao {

    Connection conexao;
    PreparedStatement stms;
    ResultSet result;
    String sql;


    public ComputadorDao() {
        conexao = ConectionFactory.getConnection();

    }

    public ArrayList<Computador> listar() {
        ArrayList<Computador> lista;
        lista = new ArrayList<>();

        Computador computadorTemp;
        
        try {
             Statement stms = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stms.executeQuery("select * from computador order by nome_computador");
            rs.first();
            do {
                computadorTemp = new Computador();
                computadorTemp.setId(rs.getInt("id_computador"));
                computadorTemp.setComputador(rs.getString("nome_computador"));
                computadorTemp.setMac(rs.getString("mac_computador"));
                computadorTemp.setData_cadastro(rs.getString("data_Cadastro"));
                computadorTemp.setUltima_auteracao(rs.getString("ultima_Auteracao"));

                lista.add(computadorTemp);
            } while (rs.next());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return lista;
    }

    public void cadastrarComputador(Computador computador) {
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

    public void atualizar(Computador atualizar) {

        sql = ("update computador set nome_computador = ?, mac_computador = ?, ultima_auteracao = ? where id_computador = ?");

        try {
            stms = conexao.prepareStatement(sql);
            stms.setString(1, atualizar.getComputador());
            stms.setString(2, atualizar.getMac());
            stms.setString(3, atualizar.getUltima_auteracao());
            stms.setInt(4, atualizar.getId());

            stms.execute();
            stms.close();

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados!" + error);
            error.printStackTrace();
        }
    }

    public void deletar(Computador deletar) {
       
        
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
