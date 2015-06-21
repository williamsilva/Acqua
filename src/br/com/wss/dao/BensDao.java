/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.dao;

import br.com.wss.modelo.Bens;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author William
 */
public class BensDao {

    Connection conexao;
    PreparedStatement stms;
    ResultSet result;
    String sql;

    public BensDao() {
        conexao = ConectionFactory.getConnection();
    }

    public ArrayList<Bens> listar() {
        ArrayList<Bens> lista;
        lista = new ArrayList<>();

        Bens bensTemp;

        try {
            Statement statmen = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statmen.executeQuery("select * from bens  order by nome");
            rs.first();
            do {
                bensTemp = new Bens();
                bensTemp.setNome(rs.getString("nome"));
                bensTemp.setNumeroControle(rs.getString("numero_controle"));
                bensTemp.setNotaFiscal(rs.getString("nota_fiscal"));
                bensTemp.setValorCompra(rs.getDouble("valor_compra"));
                bensTemp.setDataCompra(rs.getString("data_compra"));
                bensTemp.setIdGrupo(rs.getInt("idGrupoBens"));
                bensTemp.setVoltagem(rs.getString("voltagem"));
                bensTemp.setNumeroSerie(rs.getString("numero_serie"));
                bensTemp.setModelo(rs.getString("modelo"));
                bensTemp.setFornecedor(rs.getString("fornecedor"));
                bensTemp.setLocal(rs.getString("localizacao"));
                bensTemp.setStatus(rs.getString("status"));
                bensTemp.setDataCadastro(rs.getString("data_cadastro"));
                bensTemp.setUltimaAlteracao(rs.getString("ultima_alteracao"));
                bensTemp.setObservacoes(rs.getString("observacao"));
                bensTemp.setIdBens(rs.getInt("idBens"));
                bensTemp.setVidaUtil(rs.getString("vida_util"));
                bensTemp.setGarantia(rs.getString("garantia"));

                lista.add(bensTemp);
            } while (rs.next());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return lista;
    }

    public void cadastraBens(Bens cadastrar, String grupo) {
        sql = "insert into bens (numero_controle,nota_fiscal,valor_compra,"
                + "data_compra,voltagem,numero_serie,modelo,fornecedor,status,"
                + "localizacao,observacao,idGrupobens,data_cadastro,ultima_alteracao,nome,garantia,vida_util)"
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            stms = conexao.prepareStatement(sql);

            stms.setString(1, cadastrar.getNumeroControle());
            stms.setString(2, cadastrar.getNotaFiscal());
            stms.setDouble(3, cadastrar.getValorCompra());
            stms.setString(4, cadastrar.getDataCompra());
            stms.setString(5, cadastrar.getVoltagem());
            stms.setString(6, cadastrar.getNumeroSerie());
            stms.setString(7, cadastrar.getModelo());
            stms.setString(8, cadastrar.getFornecedor());
            stms.setString(9, cadastrar.getStatus());
            stms.setString(10, cadastrar.getLocal());
            stms.setString(11, cadastrar.getObservacoes());
            stms.setInt(12, Integer.parseInt(grupo));
            stms.setString(13, cadastrar.getDataCadastro());
            stms.setString(14, cadastrar.getUltimaAlteracao());
            stms.setString(15, cadastrar.getNome());
            stms.setString(16, cadastrar.getGarantia());
            stms.setString(17, cadastrar.getVidaUtil());

            stms.execute();
            stms.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");

        } catch (SQLException | HeadlessException error) {
            JOptionPane.showMessageDialog(null, "Erro ao Gravar dados. \n Erro:" + error);
        }
    }

    public void atualizarBens(Bens atualizar, String grupo) {
        sql = "update bens set numero_controle = ?, nota_fiscal =? ,valor_compra =? ,"
                + "data_compra =? ,voltagem =? ,numero_serie =? ,modelo =? ,fornecedor =? ,status =? ,"
                + "localizacao =? ,observacao =? ,idGrupobens =? ,ultima_alteracao =? ,nome =?,vida_util = ? ,garantia = ? where idBens= ? ";
        try {
            stms = conexao.prepareStatement(sql);
            stms.setString(1, atualizar.getNumeroControle());
            stms.setString(2, atualizar.getNotaFiscal());
            stms.setDouble(3, atualizar.getValorCompra());
            stms.setString(4, atualizar.getDataCompra());
            stms.setString(5, atualizar.getVoltagem());
            stms.setString(6, atualizar.getNumeroSerie());
            stms.setString(7, atualizar.getModelo());
            stms.setString(8, atualizar.getFornecedor());
            stms.setString(9, atualizar.getStatus());
            stms.setString(10, atualizar.getLocal());
            stms.setString(11, atualizar.getObservacoes());
            stms.setInt(12, Integer.parseInt(grupo));
            stms.setString(13, atualizar.getUltimaAlteracao());
            stms.setString(14, atualizar.getNome());
            stms.setString(15, atualizar.getVidaUtil());
            stms.setString(16, atualizar.getGarantia());
            stms.setInt(17, atualizar.getIdBens());

            stms.execute();
            stms.close();
            JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados! " + error);
        }

    }

    public void deletar(Bens deletar) {

        sql = "Delete from bens where idBens = ?";
        try {
            stms = conexao.prepareStatement(sql);
            stms.setInt(1, deletar.getIdBens());
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
