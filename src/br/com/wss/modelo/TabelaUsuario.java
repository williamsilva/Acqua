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
public class TabelaUsuario extends Tabela{
 public TabelaUsuario(ArrayList lin, String[] col) {
        super(lin, col);
    }
    
    @Override
    public Object getValueAt(int numLin, int numCol) {
        Usuario usuario = (Usuario) getLinhas().get(numLin);
        Object[] linha = new String[colunas.length];
        linha[0] = usuario.getNome();
        linha[1] = usuario.getUsuario();
        linha[2] = usuario.getData_cadastro();
        linha[3] = usuario.getUltima_auteracao();
        linha[4] = usuario.getAtivo();
        return linha[numCol];
    }    
}
