/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.tabelas;

import br.com.wss.modelo.Grupo;
import java.util.ArrayList;

/**
 *
 * @author William
 */
public class TabelaGrupo extends Tabela {

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
        linha[0] = grupo.getNomeGrupo();
        linha[1] = grupo.getDescricao();
        linha[2] = "Em " + grupo.getDataCadastro() + " Por " + grupo.getUsuarioCad();
        linha[3] = "Em " + grupo.getUltimaAlteracao() + " Por " + grupo.getUsuarioAlt();

        return linha[numCol];
    }
}
