/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.dao;

import br.com.wss.modelo.Clientes;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author William
 */
public class ClientesDao {

    Connection conexao;
    PreparedStatement stms;
    ResultSet rs;
    String sql;

    public ClientesDao() {
        conexao = ConectionFactory.getConnection();
    }

    /**
     *
     * @return
     */
    public ArrayList<Clientes> listar() {
        ArrayList<Clientes> lista;
        lista = new ArrayList<>();

        Clientes clientesTemp;

        try {
            Statement statmen = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statmen.executeQuery("select \n"
                    + "    cliente.id_cliente,\n"
                    + "	   cliente.id_endereco,\n"
                    + "    cliente.nome,\n"
                    + "    cliente.cpf,\n"
                    + "    cliente.data_nascimento,\n"
                    + "    cliente.email,\n"
                    + "    cliente.telefone,\n"
                    + "    cliente.celular,\n"
                    + "    cliente.id_usuario_cad,\n"
                    + "    cliente.id_usuario_alt,\n"
                    + "    cliente.endereco,\n"
                    + "    cliente.data_cadastro,\n"
                    + "    cliente.ultima_alteracao,\n"
                    + "    cliente.numero,\n"
                    + "    login.nome as usuario_alt,\n"
                    + "    endereco.rua,\n"
                    + "    endereco.cep,\n"
                    + "    endereco.bairro,\n"
                    + "    cidade.nome as cidade,\n"
                    + "    estado.nome as estado,\n"
                    + "    pais.nome as pais,\n"
                    + "   (select login.nome from login where login.id_login = cliente.id_usuario_cad) as usuario_cad\n"
                    + "    from cliente left join login on cliente.id_usuario_alt = login.id_login\n"
                    + "				 left join endereco on cliente.id_endereco = endereco.id_endereco\n"
                    + "                 left join cidade on endereco.id_cidade = cidade.id_cidade \n"
                    + "                 left join estado on cidade.idEstado = estado.idestado\n"
                    + "                 left join pais on estado.id_pais = pais.id_Pais\n"
                    + "    order by cliente.nome" );
            rs.first();
            do {
                clientesTemp = new Clientes();
                clientesTemp.setIdCliente(rs.getInt("cliente.id_cliente"));
                clientesTemp.setIdEndereco(rs.getInt("cliente.id_endereco"));
                clientesTemp.setNomeCliente(rs.getString("cliente.nome"));
                clientesTemp.setCpf(rs.getString("cliente.cpf"));
                clientesTemp.setDataNascimento(rs.getString("cliente.data_nascimento"));
                clientesTemp.setEmail(rs.getString("cliente.email"));
                clientesTemp.setTelefone(rs.getString("cliente.telefone"));
                clientesTemp.setCelular(rs.getString("cliente.celular"));
                clientesTemp.setUsuarioAltClientes(rs.getString("usuario_alt"));
                clientesTemp.setUsuarioCadClientes(rs.getString("usuario_cad"));
                clientesTemp.setRua(rs.getString("endereco.rua"));
                clientesTemp.setDataCadastro(rs.getString("cliente.data_cadastro"));
                clientesTemp.setUltimaAlteracao(rs.getString("cliente.ultima_alteracao"));
                clientesTemp.setCep(rs.getInt("endereco.cep"));
                clientesTemp.setBairro(rs.getString("endereco.bairro"));
                clientesTemp.setNomeCidade(rs.getString("cidade"));
                clientesTemp.setNomeEstado(rs.getString("estado"));
                clientesTemp.setNomePais(rs.getString("pais"));
                clientesTemp.setNumero(rs.getInt("cliente.numero"));

                lista.add(clientesTemp);
            } while (rs.next());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return lista;
    }

    public boolean cadastra(Clientes cadastrar) {
        boolean retorno;
        sql = "insert into cliente (\n"
                + "    cliente.id_endereco,\n"
                + "    cliente.nome,\n"
                + "    cliente.cpf,\n"
                + "    cliente.data_nascimento,\n"
                + "    cliente.email,\n"
                + "    cliente.telefone,\n"
                + "    cliente.celular,\n"
                + "    cliente.id_usuario_cad,\n"
                + "    cliente.id_usuario_alt,\n"
                + "    cliente.data_cadastro,\n"
                + "    cliente.ultima_alteracao,"
                + "    cliente.numero)\n"
                + "    values(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            stms = conexao.prepareStatement(sql);

            stms.setInt(1, cadastrar.getIdEndereco());
            stms.setString(2, cadastrar.getNomeCliente());
            stms.setString(3, cadastrar.getCpf());
            stms.setString(4, cadastrar.getDataNascimento());
            stms.setString(5, cadastrar.getEmail());
            stms.setString(6, cadastrar.getTelefone());
            stms.setString(7, cadastrar.getCelular());
            stms.setString(8, cadastrar.getUsuarioCadClientes());
            stms.setString(9, cadastrar.getUsuarioAltClientes());
            stms.setString(10, cadastrar.getDataCadastro());
            stms.setString(11, cadastrar.getUltimaAlteracao());
            stms.setInt(12, cadastrar.getNumero());

            stms.execute();
            stms.close();
            retorno = true;
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");

        } catch (SQLException | HeadlessException error) {
            retorno = false;
            JOptionPane.showMessageDialog(null, error);
            //JOptionPane.showMessageDialog(null, "NÃO FOI POSÍVEL CONCLUIR!\n\n" + "Cliente " + "'" + cadastrar.getNomeCliente() + "'" + " já Cadastrado..");
        }
        return retorno;
    }
    
    public boolean Atualizar(Clientes atualizar) {
        boolean retorno;
        sql = "update cliente set \n"
                + "    cliente.id_endereco = ?,\n"
                + "    cliente.nome = ?,\n"
                + "    cliente.cpf = ?,\n"
                + "    cliente.data_nascimento = ?,\n"
                + "    cliente.email = ?,\n"
                + "    cliente.telefone = ?,\n"
                + "    cliente.celular = ?,\n"
                + "    cliente.id_usuario_alt = ?,\n"
                + "    cliente.ultima_alteracao = ?,"
                + "    cliente.numero = ?\n"
                + "     where cliente.id_cliente = ?";
        try {
            stms = conexao.prepareStatement(sql);

            stms.setInt(1, atualizar.getIdEndereco());
            stms.setString(2, atualizar.getNomeCliente());
            stms.setString(3, atualizar.getCpf());
            stms.setString(4, atualizar.getDataNascimento());
            stms.setString(5, atualizar.getEmail());
            stms.setString(6, atualizar.getTelefone());
            stms.setString(7, atualizar.getCelular());
            stms.setString(8, atualizar.getUsuarioAltClientes());
            stms.setString(9, atualizar.getUltimaAlteracao());
            stms.setInt(10, atualizar.getNumero());
            stms.setInt(11,atualizar.getIdCliente());

            stms.execute();
            stms.close();
            retorno = true;
            JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");

        } catch (SQLException | HeadlessException error) {
            retorno = false;
            JOptionPane.showMessageDialog(null, error);
            //JOptionPane.showMessageDialog(null, "NÃO FOI POSÍVEL CONCLUIR!\n\n" + "Cliente " + "'" + cadastrar.getNomeCliente() + "'" + " já Cadastrado..");
        }
        return retorno;
    }
     public boolean deletar(Clientes deletar) {
        boolean retorno = false;
        sql = "Delete from cliente where id_cliente = ?";
        try {
            stms = conexao.prepareStatement(sql);
            stms.setInt(1, deletar.getIdCliente());
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
}
