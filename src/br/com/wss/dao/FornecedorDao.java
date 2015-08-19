/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.dao;

import br.com.wss.modelo.Fornecedor;
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
public class FornecedorDao {

    Connection conexao;
    PreparedStatement stms;
    ResultSet result;
    String sql;

    public FornecedorDao() {
        conexao = ConectionFactory.getConnection();
    }

    public ArrayList<Fornecedor> listar() {
        ArrayList<Fornecedor> lista;
        lista = new ArrayList<>();

        Fornecedor fornecedorTemp;

        try {
            Statement statmen = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statmen.executeQuery("select\n"
                    + "		fornecedor.nome_fornecedor,\n"
                    + "		fornecedor.id_usuario_cad,\n"
                    + "		fornecedor.id_usuario_alt,\n"
                    + "		fornecedor.numero,\n"
                    + "		fornecedor.contato,\n"
                    + "		fornecedor.email,\n"
                    + "		fornecedor.telefone,\n"
                    + "		fornecedor.endereco,\n"
                    + "		fornecedor.ultima_alteracao,\n"
                    + "		fornecedor.data_cadastro,\n"
                    + "		fornecedor.celular,"
                    + "         fornecedor.id_fornecedor,\n"
                    + "		fornecedor.bairro,\n"
                    + "		fornecedor.cep,\n"
                    + "		cidade.nome,\n"
                    + "		estado.nome,\n"
                    + "		login.nome,"
                    + " (select login.nome from login where login.id_login = fornecedor.id_usuario_cad) as usuario_cad "
                    + " from fornecedor left join cidade on fornecedor.id_cidade = cidade.id_cidade\n"
                    + "				left join estado on cidade.idEstado = estado.idestado\n"
                    + "				left join login  on fornecedor.id_usuario_alt = login.id_login\n"
                    + "order by nome_fornecedor");

            rs.first();
            do {
                fornecedorTemp = new Fornecedor();
                fornecedorTemp.setNomeFornecedor(rs.getString("nome_fornecedor"));
                fornecedorTemp.setUsuarioCad(rs.getString("usuario_cad"));
                fornecedorTemp.setUsuarioAlt(rs.getString("login.nome"));
                fornecedorTemp.setCidade(rs.getString("cidade.nome"));
                fornecedorTemp.setEstado(rs.getString("estado.nome"));
                fornecedorTemp.setNumero(rs.getString("numero"));
                fornecedorTemp.setContato(rs.getString("contato"));
                fornecedorTemp.setEmail(rs.getString("email"));
                fornecedorTemp.setTelefone(rs.getString("telefone"));
                fornecedorTemp.setEndereco(rs.getString("endereco"));
                fornecedorTemp.setUltimaAlteracao(rs.getString("ultima_alteracao"));
                fornecedorTemp.setDataCadastro(rs.getString("data_cadastro"));
                fornecedorTemp.setCelular(rs.getString("celular"));
                fornecedorTemp.setBairro(rs.getString("bairro"));
                fornecedorTemp.setIdFornecedor(rs.getInt("id_fornecedor"));
                fornecedorTemp.setCep(rs.getString("cep"));

                lista.add(fornecedorTemp);
            } while (rs.next());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return lista;
    }

    public void cadastra(Fornecedor cadastrar, int idCidade) {
        sql = "insert into fornecedor (nome_fornecedor,id_usuario_cad,id_usuario_alt,"
                + "id_cidade,numero,contato,email,telefone,endereco,"
                + "ultima_alteracao,data_cadastro,celular, bairro,cep)values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            stms = conexao.prepareStatement(sql);

            stms.setString(1, cadastrar.getNomeFornecedor());
            stms.setString(2, cadastrar.getUsuarioCad());
            stms.setString(3, cadastrar.getUsuarioAlt());
            stms.setInt(4, idCidade);
            stms.setString(5, cadastrar.getNumero());
            stms.setString(6, cadastrar.getContato());
            stms.setString(7, cadastrar.getEmail());
            stms.setString(8, cadastrar.getTelefone());
            stms.setString(9, cadastrar.getEndereco());
            stms.setString(10, cadastrar.getUltimaAlteracao());
            stms.setString(11, cadastrar.getDataCadastro());
            stms.setString(12, cadastrar.getCelular());
            stms.setString(13, cadastrar.getBairro());
            stms.setString(14, cadastrar.getCep());

            stms.execute();
            stms.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");

        } catch (SQLException | HeadlessException error) {
            JOptionPane.showMessageDialog(null, "Erro ao Gravar dados. \n Erro:" + error);
        }
    }

    public void atualizar(Fornecedor atualizar, int idCidade) {
        sql = "update fornecedor set "
                + "nome_fornecedor = ?,"
                + "id_usuario_alt = ?,"
                + "id_cidade = ?,"
                + "numero = ?,"
                + "contato = ?,"
                + "email = ?,"
                + "telefone = ?,"
                + "endereco = ?,"
                + "ultima_alteracao = ?,"
                + "celular = ?,"
                + "bairro = ?,"
                + "cep = ?"
                + "where id_fornecedor = ?";
        try {
            stms = conexao.prepareStatement(sql);

            stms.setString(1, atualizar.getNomeFornecedor());
            stms.setString(2, atualizar.getUsuarioAlt());
            stms.setInt(3, idCidade);
            stms.setString(4, atualizar.getNumero());
            stms.setString(5, atualizar.getContato());
            stms.setString(6, atualizar.getEmail());
            stms.setString(7, atualizar.getTelefone());
            stms.setString(8, atualizar.getEndereco());
            stms.setString(9, atualizar.getUltimaAlteracao());
            stms.setString(10, atualizar.getCelular());
            stms.setString(11, atualizar.getBairro());
            stms.setString(12, atualizar.getCep());
            stms.setInt(13, atualizar.getIdFornecedor());

            stms.execute();
            stms.close();
            JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados! " + error);
        }

    }

    public void deletar(Fornecedor deletar) {

        sql = "Delete from fornecedor where id_fornecedor = ?";
        try {
            stms = conexao.prepareStatement(sql);
            stms.setInt(1, deletar.getIdFornecedor());
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

    public ArrayList<Object> listarFornecedor() {
        ArrayList<Object> objetos = new ArrayList<>();

        try {
            sql = "select nome_fornecedor from fornecedor order by nome_fornecedor";
            stms = conexao.prepareStatement(sql);

            result = stms.executeQuery();

            while (result.next()) {
                objetos.add(result.getString("nome_fornecedor"));
            }
            stms.close();
        } catch (SQLException ex) {
            Logger.getLogger(GrupoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objetos;
    }

    public String getIdFornecedor(String fornecedor) {
        String idFornecedor = "";
        try {
            sql = "select id_fornecedor from fornecedor where nome_fornecedor = '" + fornecedor + "'";

            stms = conexao.prepareStatement(sql);
            result = stms.executeQuery();
            result.next();
            idFornecedor = result.getString("id_fornecedor");
        } catch (SQLException ex) {
            Logger.getLogger(GrupoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idFornecedor;
    }

    public String getNomeFornecedor(String fornecedor) {
        String idFornecedor = "";
        try {
            sql = "select nome_fornecedor from fornecedor where id_fornecedor = '" + fornecedor + "'";
            stms = conexao.prepareStatement(sql);
            result = stms.executeQuery();
            result.next();
            idFornecedor = result.getString("nome_fornecedor");

        } catch (SQLException ex) {
            Logger.getLogger(GrupoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idFornecedor;
    }
}
