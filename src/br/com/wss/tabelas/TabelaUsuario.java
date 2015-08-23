/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.tabelas;

import br.com.wss.modelo.Usuario;
import java.util.ArrayList;

/**
 *
 * @author WILLIAM
 */
public class TabelaUsuario extends Tabela {

    public TabelaUsuario(ArrayList lin, String[] col) {
        super(lin, col);
    }

    @Override
    public Object getValueAt(int numLin, int numCol) {
        Usuario usuario = (Usuario) getLinhas().get(numLin);
        Object[] linha = new String[colunas.length];
        if(usuario.getAtivo().equals("Sim")){
            linha[0] = " ";
        }else{
            linha[0] = " X ";
        }        
        linha[1] = usuario.getNome();
        linha[2] = usuario.getUsuario();
        linha[3] = usuario.getLogado();
        linha[4] = usuario.getAtivo();
        linha[5] = "Em " + usuario.getDataCadastro() + " Por " + usuario.getIdUsuarioCad();
        linha[6] = "Em " + usuario.getUltimaAlteracao() + " Por " + usuario.getIdUsuarioAlt();
        
        return linha[numCol];
    }
}
