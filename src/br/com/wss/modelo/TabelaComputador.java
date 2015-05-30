/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.modelo;

import java.util.ArrayList;

/**
 *
 * @author WILLIAM
 */
public class TabelaComputador extends Tabela{

    public TabelaComputador(ArrayList lin, String[] col) {
        super(lin, col);
    }
    
    @Override
    public Object getValueAt(int numLin, int numCol) {
        Computador computador = (Computador) getLinhas().get(numLin);
        Object[] linha = new String[colunas.length];
        linha[0] = computador.getComputador();
        linha[1] = computador.getMac();
        linha[2] = computador.getData_cadastro();
        linha[3] = computador.getUltima_auteracao();
        return linha[numCol];
    }
    
}
