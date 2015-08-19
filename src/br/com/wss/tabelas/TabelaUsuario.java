/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.tabelas;

import br.com.wss.dao.UsuarioDao;
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

        linha[0] = usuario.getNome();
        linha[1] = usuario.getUsuario();
        linha[2] = usuario.getLogado();
        linha[3] = usuario.getAtivo();
        linha[4] = "Em " + usuario.getDataCadastro() + " Por " + usuario.getIdUsuarioCad();
        linha[5] = "Em " + usuario.getUltimaAlteracao() + " Por " + usuario.getIdUsuarioAlt();
        
        return linha[numCol];
    }
}
