/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.tabelas;

import br.com.wss.dao.UsuarioDao;
import br.com.wss.modelo.Produto;
import java.util.ArrayList;

/**
 *
 * @author William
 */
public class TabelaProduto extends Tabela {

    public TabelaProduto(ArrayList lin, String[] col) {
        super(lin, col);
    }

    @Override
    public Object getValueAt(int numLin, int numCol) {
        Produto produto = (Produto) getLinhas().get(numLin);
        Object[] linha = new String[colunas.length];

        linha[0] = produto.getDescricao();
        linha[1] = produto.getValidade();
        linha[2] = produto.getStatus();
        UsuarioDao dao = new UsuarioDao();
        String usuario = dao.buscaUsuario(produto.getIdUsuarioCad());
        if (usuario != null) {
            linha[3] = "Em " + produto.getDataCadastro() + " Por " + usuario;
            linha[4] = "Em " + produto.getUltimaAlteracao() + " Por " + produto.getIdUsuarioCad();
        } else {
            linha[3] = "Em " + produto.getDataCadastro() + " Por ";
            linha[4] = "Em " + produto.getUltimaAlteracao() + " Por " + produto.getIdUsuarioCad();
        }
        return linha[numCol];
    }

}
