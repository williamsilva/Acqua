/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.tabelas;

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

        if (produto.getStatus().equals("Sim")) {
            linha[0] = "";
        } else {
            linha[0] = " X ";
        }

        linha[1] = produto.getDescricao();
        linha[2] = produto.getValidade();
        linha[3] = produto.getStatus();
        linha[4] = "Em " + produto.getDataCadastro() + " Por " + produto.getIdUsuarioCad();
        linha[5] = "Em " + produto.getUltimaAlteracao() + " Por " + produto.getIdUsuarioAlt();

        return linha[numCol];
    }

}
