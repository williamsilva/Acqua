/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.tabelas;

import br.com.wss.modelo.Fornecedor;
import java.util.ArrayList;

/**
 *
 * @author William
 */
public class TabelaFornecedor extends Tabela {

    /**
     *
     * @param lin
     * @param col
     */
    public TabelaFornecedor(ArrayList lin, String[] col) {
        super(lin, col);
    }

    @Override
    public Object getValueAt(int numLin, int numCol) {
        Fornecedor fornecedor = (Fornecedor) getLinhas().get(numLin);

        Object[] linha = new String[colunas.length];
        linha[0] = fornecedor.getNomeFornecedor();
        linha[1] = fornecedor.getContato();
        linha[2] = fornecedor.getCelular();
        linha[3] = fornecedor.getTelefone();
        linha[4] = fornecedor.getEstado();
        linha[5] = fornecedor.getCidade();
        linha[6] = "Em " + fornecedor.getDataCadastro() + " Por " + fornecedor.getUsuarioCad();
        linha[7] = "Em " + fornecedor.getUltimaAlteracao() + " Por " + fornecedor.getUsuarioAlt();

        return linha[numCol];
    }
}
