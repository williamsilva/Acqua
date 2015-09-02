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

    /**
     *
     */
    public FornecedorDao() {
        conexao = ConectionFactory.getConnection();
    }

    /**
     *
     * @return
     */
    public ArrayList<Fornecedor> listar() {
        ArrayList<Fornecedor> lista;
        lista = new ArrayList<>();

        Fornecedor fornecedorTemp;

        try {
            Statement statmen = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statmen.executeQuery("select \n"
                    + "    fornecedor.celular,\n"
                    + "    fornecedor.cnpj,\n"
                    + "    fornecedor.data_cadastro,\n"
                    + "    fornecedor.email,\n"
                    + "    fornecedor.id_endereco,\n"
                    + "    fornecedor.id_fornecedor,\n"
                    + "    fornecedor.id_usuario_alt,\n"
                    + "    fornecedor.id_usuario_cad,\n"
                    + "    fornecedor.razao_social,\n"
                    + "    fornecedor.responsavel,\n"
                    + "    fornecedor.telefone,\n"
                    + "    fornecedor.ultima_alteracao,\n"
                    + "    endereco.bairro,\n"
                    + "    endereco.cep,\n"
                    + "    endereco.rua,\n"
                    + "    cidade.nome as cidade,\n"
                    + "    estado.nome as estado,\n"
                    + "    pais.nome as pais,\n"
                    + "    login.nome as usuario_alt,\n"
                    + "    (select login.nome from login where login.id_login = fornecedor.id_usuario_cad) as usuario_cad\n"
                    + "from fornecedor left join endereco on fornecedor.id_endereco = endereco.id_endereco\n"
                    + "				left join cidade on endereco.id_cidade = cidade.id_cidade\n"
                    + "                left join estado on cidade.idEstado = estado.idestado\n"
                    + "                left join pais on estado.id_pais = pais.id_Pais\n"
                    + "                left join login on fornecedor.id_usuario_alt = login.id_login");

            rs.first();
            do {
                fornecedorTemp = new Fornecedor();

                fornecedorTemp.setCelular(rs.getLong("fornecedor.celular"));
                fornecedorTemp.setCnpj(rs.getLong("fornecedor.cnpj"));
                fornecedorTemp.setDataCadastro(rs.getString("fornecedor.data_cadastro"));
                fornecedorTemp.setEmail(rs.getString("fornecedor.email"));
                fornecedorTemp.setIdEndereco(rs.getInt("fornecedor.id_endereco"));
                fornecedorTemp.setIdFornecedor(rs.getInt("fornecedor.id_fornecedor"));
                fornecedorTemp.setUsuarioCad(rs.getString("usuario_cad"));
                fornecedorTemp.setUsuarioAlt(rs.getString("usuario_alt"));
                fornecedorTemp.setRazaoSocial(rs.getString("fornecedor.razao_social"));
                fornecedorTemp.setResponsavel(rs.getString("fornecedor.responsavel"));
                fornecedorTemp.setTelefone(rs.getString("fornecedor.telefone"));
                fornecedorTemp.setUltimaAlteracao(rs.getString("fornecedor.ultima_alteracao"));
                fornecedorTemp.setBairro(rs.getString("endereco.bairro"));
                fornecedorTemp.setCep(rs.getInt("endereco.cep"));
                fornecedorTemp.setRua(rs.getString("endereco.rua"));
                fornecedorTemp.setNomeCidade(rs.getString("cidade"));
                fornecedorTemp.setNomeEstado(rs.getString("estado"));
                fornecedorTemp.setNomePais(rs.getString("pais"));

                lista.add(fornecedorTemp);

            } while (rs.next());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return lista;
    }

    /**
     *
     * @param cadastrar
     * @return
     */
    public boolean cadastra(Fornecedor cadastrar) {
        boolean retorno;
        sql = "insert into fornecedor (fornecedor.celular,\n"
                + "    fornecedor.cnpj,\n"
                + "    fornecedor.data_cadastro,\n"
                + "    fornecedor.email,\n"
                + "    fornecedor.id_endereco,\n"
                + "    fornecedor.id_usuario_alt,\n"
                + "    fornecedor.id_usuario_cad,\n"
                + "    fornecedor.razao_social,\n"
                + "    fornecedor.responsavel,\n"
                + "    fornecedor.numero,\n"
                + "    fornecedor.referencia,\n"
                + "    fornecedor.telefone,\n"
                + "    fornecedor.ultima_alteracao)values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            stms = conexao.prepareStatement(sql);

            stms.setLong(1, cadastrar.getCelular());
            stms.setLong(2, cadastrar.getCnpj());
            stms.setString(3, cadastrar.getDataCadastro());
            stms.setString(4, cadastrar.getEmail());
            stms.setInt(5, cadastrar.getIdEndereco());
            stms.setString(6, cadastrar.getUsuarioAlt());
            stms.setString(7, cadastrar.getUsuarioCad());
            stms.setString(8, cadastrar.getRazaoSocial());
            stms.setString(9, cadastrar.getResponsavel());
            stms.setInt(10, cadastrar.getNumero());
            stms.setString(11, cadastrar.getReferencia());
            stms.setString(12, cadastrar.getTelefone());
            stms.setString(13, cadastrar.getUltimaAlteracao());

            stms.execute();
            stms.close();
            retorno = true;
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");

        } catch (SQLException | HeadlessException error) {
            retorno = false;
            JOptionPane.showMessageDialog(null, "NÃO FOI POSÍVEL CONCLUIR!\n\n" + "A Empresa " + "'" + cadastrar.getRazaoSocial()+ "'" + " já Cadastrada..");
        }
        return retorno;
    }

    /**
     *
     * @param atualizar
     * @return
     */
    public boolean atualizar(Fornecedor atualizar) {
        boolean retorno;
        sql = "update fornecedor set"
                + "    fornecedor.celular = ?,\n"
                + "    fornecedor.cnpj= ?,\n"
                + "    fornecedor.data_cadastro= ?,\n"
                + "    fornecedor.email= ?,\n"
                + "    fornecedor.id_endereco= ?,\n"
                + "    fornecedor.id_usuario_alt= ?,\n"
                + "    fornecedor.id_usuario_cad= ?,\n"
                + "    fornecedor.razao_social= ?,\n"
                + "    fornecedor.responsavel= ?,\n"
                + "    fornecedor.numero= ?,\n"
                + "    fornecedor.referencia= ?,\n"
                + "    fornecedor.telefone= ?,\n"
                + "    fornecedor.ultima_alteracao= ?"
                + "    where id_fornecedor = ?";
        try {
            stms = conexao.prepareStatement(sql);
            stms.setLong(1, atualizar.getCelular());
            stms.setLong(2, atualizar.getCnpj());
            stms.setString(3,atualizar.getDataCadastro());
            stms.setString(4, atualizar.getEmail());
            stms.setInt(5, atualizar.getIdEndereco());
            stms.setString(6, atualizar.getUsuarioAlt());
            stms.setString(7, atualizar.getUsuarioCad());
            stms.setString(8, atualizar.getRazaoSocial());
            stms.setString(9, atualizar.getResponsavel());
            stms.setInt(10, atualizar.getNumero());
            stms.setString(11, atualizar.getReferencia());
            stms.setString(12, atualizar.getTelefone());
            stms.setString(13, atualizar.getUltimaAlteracao());
            stms.setInt(14, atualizar.getIdFornecedor());           
            
            stms.execute();
            stms.close();
            retorno = true;
            JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");
        } catch (SQLException error) {
            retorno = false;
            JOptionPane.showMessageDialog(null, error);
            //JOptionPane.showMessageDialog(null, "NÃO FOI POSÍVEL CONCLUIR!\n\n" + "Numero de registro " + "'" + atualizar.getRazaoSocial()+ "'" + " já existe...");
        }
        return retorno;
    }
    /**
     *
     * @param deletar
     * @return
     */
    public boolean deletar(Fornecedor deletar) {
        boolean retorno = false;
        sql = "Delete from fornecedor where id_fornecedor = ?";
        try {
            stms = conexao.prepareStatement(sql);
            stms.setInt(1, deletar.getIdFornecedor());
            int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza Excluir?", "Exclusão", JOptionPane.YES_NO_OPTION);
            if (confirma == JOptionPane.YES_OPTION) {
                stms.execute();
                stms.close();
                retorno = true;
                JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso!");
            }
        } catch (SQLException error) {
            retorno = false;
            JOptionPane.showMessageDialog(null, "NÃO FOI POSÍVEL CONCLUIR!\n\n" + "O item possui registros sendo utilizados!");
        }
        return retorno;
    }

    /**
     *
     * @return
     */
    public ArrayList<Object> listarFornecedor() {
        ArrayList<Object> objetos = new ArrayList<>();

        try {
            sql = "select razao_social from fornecedor order by razao_social";
            stms = conexao.prepareStatement(sql);

            result = stms.executeQuery();

            while (result.next()) {
                objetos.add(result.getString("razao_social"));
            }
            stms.close();
        } catch (SQLException ex) {
            Logger.getLogger(GrupoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objetos;
    }

    /**
     *
     * @param fornecedor
     * @return
     */
    public String getIdFornecedor(String fornecedor) {
        String idFornecedor = "";
        try {
            sql = "select id_fornecedor from fornecedor where razao_social = '" + fornecedor + "'";

            stms = conexao.prepareStatement(sql);
            result = stms.executeQuery();
            result.next();
            idFornecedor = result.getString("id_fornecedor");
        } catch (SQLException ex) {
            Logger.getLogger(GrupoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idFornecedor;
    }

    /**
     *
     * @param fornecedor
     * @return
     */
    public String getNomeFornecedor(String fornecedor) {
        String idFornecedor = "";
        try {
            sql = "select razao_social from fornecedor where id_fornecedor = '" + fornecedor + "'";
            stms = conexao.prepareStatement(sql);
            result = stms.executeQuery();
            result.next();
            idFornecedor = result.getString("razao_social");

        } catch (SQLException ex) {
            Logger.getLogger(GrupoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idFornecedor;
    }
}
