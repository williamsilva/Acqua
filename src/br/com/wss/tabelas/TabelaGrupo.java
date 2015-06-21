/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.tabelas;

import br.com.wss.tabelas.Tabela;
import br.com.wss.modelo.Grupo;
import java.util.ArrayList;

/**
 *
 * @author William
 */
public class TabelaGrupo extends Tabela{

    /**
     *
     * @param lin
     * @param col
     */
    public TabelaGrupo(ArrayList lin, String[] col) {
        super(lin, col);
    }
    
    @Override
    public Object getValueAt(int numLin, int numCol) {
        Grupo grupo = (Grupo) getLinhas().get(numLin);
        
        Object[] linha = new String[colunas.length];
        linha[0] = grupo.getNome();
        linha[1] = grupo.getDescricao();
        linha[2] = grupo.getDataCadastro();
        linha[3] = grupo.getUltimaAlteracao();
        return linha[numCol];
    }
}
