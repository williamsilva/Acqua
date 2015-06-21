/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.tabelas;

import br.com.wss.modelo.Bens;
import java.util.ArrayList;

/**
 *
 * @author William
 */
public class TabelaBens extends Tabela {

    public TabelaBens(ArrayList lin, String[] col) {
        super(lin, col);
    }

    @Override
    public Object getValueAt(int numLin, int numCol) {
        Bens bens = (Bens) getLinhas().get(numLin);
        Object[] linha = new String[colunas.length];

        linha[0] = bens.getNome();
        linha[1] = bens.getLocal();
        linha[2] = bens.getStatus();
        linha[3] = bens.getNumeroControle();
        linha[4] = bens.getNotaFiscal();
        linha[5] = bens.getNumeroSerie();
        linha[6] = bens.getDataCadastro();
        linha[7] = bens.getUltimaAlteracao();
        
                
        return linha[numCol];
    }
}
