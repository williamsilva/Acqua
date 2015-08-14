/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.tabelas;

import br.com.wss.modelo.Computador;
import java.util.ArrayList;
import br.com.wss.dao.UsuarioDao;

/**
 *
 * @author WILLIAM
 */
public class TabelaComputador extends Tabela {

    public TabelaComputador(ArrayList lin, String[] col) {
        super(lin, col);
    }

    @Override
    public Object getValueAt(int numLin, int numCol) {
        Computador computador = (Computador) getLinhas().get(numLin);
        Object[] linha = new String[colunas.length];

        linha[0] = computador.getComputador();
        linha[1] = computador.getMac();
        UsuarioDao dao = new UsuarioDao();
        String usuario = dao.buscaUsuario(computador.getIdUsuarioCad());
        if (usuario != null) {
            linha[2] = "Em " + computador.getDataCadastro() + " Por " + usuario;
            linha[3] = "Em " + computador.getUltimaAlteracao() + " Por " + computador.getIdUsuarioAlt();
        } else {
            linha[2] = "Em " + computador.getDataCadastro() + " Por ";
            linha[3] = "Em " + computador.getUltimaAlteracao() + " Por " + computador.getIdUsuarioAlt();
        }
        return linha[numCol];
    }

}
