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
public class TabelaProduto extends Tabela{
    public TabelaProduto(ArrayList lin, String[] col) {
        super(lin, col);
    }

    @Override
    public Object getValueAt(int numLin, int numCol) {
        Produto bens = (Produto) getLinhas().get(numLin);
        Object[] linha = new String[colunas.length];

        linha[0] = bens.getDescricao();
        linha[1] = bens.getValidade();
        linha[2] = bens.getStatus();
        linha[3] = "Em "+bens.getDataCadastro()+" Por "+bens.getIdUsuarioCad();
        linha[4] = "Em "+bens.getUltimaAlteracao()+" Por "+bens.getIdUsuarioAlt();       
                
        return linha[numCol];
    }
    
}
