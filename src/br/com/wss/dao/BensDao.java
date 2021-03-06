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
import java.util.logging.Level;
import java.util.logging.Logger;
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

    /**
     *
     */
    public BensDao() {
        conexao = ConectionFactory.getConnection();
    }

    /**
     *
     * @return
     */
    public ArrayList<Bens> listar() {
        ArrayList<Bens> lista;
        lista = new ArrayList<>();

        Bens bensTemp;

        try {
            Statement statmen = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statmen.executeQuery("select    bens.nome,"
                    + "                               bens.numero_controle,"
                    + "                               bens.nota_fiscal,"
                    + "				      bens.valor_compra,"
                    + "				      bens.data_compra,"
                    + "                               bens.id_grupo_bens,"
                    + "                               bens.voltagem,"
                    + "                               bens.numero_serie,"
                    + "                               bens.modelo,"
                    + "                               bens.id_fornecedor,"
                    + "                               bens.localizacao,"
                    + "                               bens.status,"
                    + "                               bens.data_cadastro,"
                    + "                               bens.ultima_alteracao,"
                    + "                               bens.observacao,"
                    + "                               bens.id_bens,"
                    + "			              bens.vida_util,"
                    + "                               bens.garantia,"
                    + "                               bens.id_usuario_alt,"
                    + "                               bens.id_usuario_cad,"
                    + "                               bens.fim_garantia_manutencao,"
                    + "                               bens.inicio_garantia_manutencao,"
                    + "                               grupo.nome_grupo,"
                    + "                               login.nome,"
                    + "          (select login.nome from login where login.id_login = bens.id_usuario_cad) as usuario_cad"
                    + "                    from bens left join grupo on bens.id_grupo_bens = grupo.id_grupo"
                    + "                    		  left join login on bens.id_usuario_alt = login.id_login"
                    + "                    order by bens.nome");
            rs.first();
            do {
                bensTemp = new Bens();
                bensTemp.setNome(rs.getString("nome"));
                bensTemp.setNumeroControle(rs.getString("numero_controle"));
                bensTemp.setNotaFiscal(rs.getString("nota_fiscal"));
                bensTemp.setValorCompra(rs.getDouble("valor_compra"));
                bensTemp.setDataCompra(rs.getString("data_compra"));
                bensTemp.setIdGrupo(rs.getInt("id_grupo_bens"));
                bensTemp.setVoltagem(rs.getString("voltagem"));
                bensTemp.setNumeroSerie(rs.getString("numero_serie"));
                bensTemp.setModelo(rs.getString("modelo"));
                bensTemp.setIdFornecedor(rs.getInt("id_fornecedor"));
                bensTemp.setLocal(rs.getString("localizacao"));
                bensTemp.setStatus(rs.getString("status"));
                bensTemp.setDataCadastro(rs.getString("data_cadastro"));
                bensTemp.setUltimaAlteracao(rs.getString("ultima_alteracao"));
                bensTemp.setObservacoes(rs.getString("observacao"));
                bensTemp.setIdBens(rs.getInt("id_bens"));
                bensTemp.setVidaUtil(rs.getString("vida_util"));
                bensTemp.setGarantia(rs.getString("garantia"));
                bensTemp.setIdUsuarioAlt(rs.getString("login.nome"));
                bensTemp.setIdUsuarioCad(rs.getString("usuario_cad"));
                bensTemp.setInicioGarantia(rs.getString("bens.inicio_garantia_manutencao"));
                bensTemp.setFinalGarantia(rs.getString("bens.fim_garantia_manutencao"));

                lista.add(bensTemp);
            } while (rs.next());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return lista;
    }

    /**
     *
     * @param cadastrar
     * @param grupo
     * @param idFornecedor
     * @return
     */
    public boolean cadastraBens(Bens cadastrar, String grupo, String idFornecedor) {
        boolean retorno;
        sql = "insert into bens (numero_controle,nota_fiscal,valor_compra,"
                + "data_compra,voltagem,numero_serie,modelo,id_fornecedor,status,"
                + "localizacao,observacao,id_grupo_bens,data_cadastro,ultima_alteracao,"
                + "nome,garantia,vida_util,id_usuario_cad,"
                + "id_usuario_alt) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            stms = conexao.prepareStatement(sql);

            stms.setString(1, cadastrar.getNumeroControle());
            stms.setString(2, cadastrar.getNotaFiscal());
            stms.setDouble(3, cadastrar.getValorCompra());
            stms.setString(4, cadastrar.getDataCompra());
            stms.setString(5, cadastrar.getVoltagem());
            stms.setString(6, cadastrar.getNumeroSerie());
            stms.setString(7, cadastrar.getModelo());
            stms.setInt(8, Integer.parseInt(idFornecedor));
            stms.setString(9, cadastrar.getStatus());
            stms.setString(10, cadastrar.getLocal());
            stms.setString(11, cadastrar.getObservacoes());
            stms.setInt(12, Integer.parseInt(grupo));
            stms.setString(13, cadastrar.getDataCadastro());
            stms.setString(14, cadastrar.getUltimaAlteracao());
            stms.setString(15, cadastrar.getNome());
            stms.setString(16, cadastrar.getGarantia());
            stms.setString(17, cadastrar.getVidaUtil());
            stms.setString(18, cadastrar.getIdUsuarioCad());
            stms.setString(19, cadastrar.getIdUsuarioAlt());

            stms.execute();
            stms.close();
            retorno = true;
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");

        } catch (SQLException | HeadlessException error) {
            retorno = false;
            JOptionPane.showMessageDialog(null, "Numero de registro " + "'" + cadastrar.getNumeroControle() + "'" + " já existe...");
        }
        return retorno;
    }

    /**
     *
     * @param atualizar
     * @param grupo
     * @param idFornecedor
     * @return
     */
    public boolean atualizarBens(Bens atualizar, String grupo, int idFornecedor) {
        boolean retorno;
        sql = "update bens set numero_controle = ?, nota_fiscal =? ,valor_compra =? ,"
                + "data_compra =? ,voltagem =? ,numero_serie =? ,modelo =? ,id_fornecedor =? ,status =? ,"
                + "localizacao =? ,observacao =? ,id_grupo_bens =? ,"
                + "ultima_alteracao =? ,nome =?,vida_util = ? ,garantia = ?, "
                + "id_usuario_alt =? where id_bens= ? ";
        try {
            stms = conexao.prepareStatement(sql);
            stms.setString(1, atualizar.getNumeroControle());
            stms.setString(2, atualizar.getNotaFiscal());
            stms.setDouble(3, atualizar.getValorCompra());
            stms.setString(4, atualizar.getDataCompra());
            stms.setString(5, atualizar.getVoltagem());
            stms.setString(6, atualizar.getNumeroSerie());
            stms.setString(7, atualizar.getModelo());
            stms.setInt(8, idFornecedor);
            stms.setString(9, atualizar.getStatus());
            stms.setString(10, atualizar.getLocal());
            stms.setString(11, atualizar.getObservacoes());
            stms.setInt(12, Integer.parseInt(grupo));
            stms.setString(13, atualizar.getUltimaAlteracao());
            stms.setString(14, atualizar.getNome());
            stms.setString(15, atualizar.getVidaUtil());
            stms.setString(16, atualizar.getGarantia());
            stms.setString(17, atualizar.getIdUsuarioAlt());
            stms.setInt(18, atualizar.getIdBens());

            stms.execute();
            stms.close();
            retorno = true;
            JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");
        } catch (SQLException error) {
            retorno = false;
            JOptionPane.showMessageDialog(null, "Numero de registro " + "'" + atualizar.getNumeroControle() + "'" + " já existe...");
        }
        return retorno;
    }

    /**
     *
     * @param deletar
     * @return
     */
    public boolean deletar(Bens deletar) {
        boolean retorno = true;
        sql = "Delete from bens where id_bens = ?";
        try {
            stms = conexao.prepareStatement(sql);
            stms.setInt(1, deletar.getIdBens());
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
     * @param bens
     * @return
     */
    public String buscarIdBens(String bens) {
        String idBens = "";
        try {
            sql = "select id_bens from bens where numero_controle = '" + bens + "'";
            stms = conexao.prepareStatement(sql);
            result = stms.executeQuery();
            result.next();
            idBens = result.getString("id_bens");
        } catch (SQLException ex) {
            Logger.getLogger(GrupoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idBens;

    }

    /**
     *
     * @param registro
     * @return
     */
    public String getNomeBens(String registro) {
        String nomeBen = "";
        try {
            sql = "select nome from bens where numero_controle ='" + registro + "'";
            stms = conexao.prepareStatement(sql);
            result = stms.executeQuery();
            result.next();
           // if(result.first()){
            nomeBen = result.getString("nome");
            //}
        } catch (SQLException ex) {
           // Logger.getLogger(BensDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nomeBen;
    }
}
