/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.tabelas;

import br.com.wss.dao.UsuarioDao;
import br.com.wss.modelo.Manutencao;
import java.util.ArrayList;

/**
 *
 * @author William
 */
public class TabelaManutecao extends Tabela {

    public TabelaManutecao(ArrayList lin, String[] col) {
        super(lin, col);
    }

    @Override
    public Object getValueAt(int numLin, int numCol) {
        Manutencao manutencao = (Manutencao) getLinhas().get(numLin);
        Object[] linha = new String[colunas.length];
        
        linha[0] = manutencao.getNomeBens();
        linha[1] = manutencao.getNumeroRegistro();
        linha[2] = manutencao.getResponsavel();
        linha[3] = manutencao.getAltorizada();
        linha[4] = manutencao.getContato();
        linha[5] = manutencao.getDataSaida();
        linha[6] = manutencao.getDataRetorno();
        UsuarioDao dao = new UsuarioDao();
        String usuario = dao.buscaUsuario(manutencao.getUsuarioCad());
        if (usuario != null) {
            linha[7] = "Em " + manutencao.getDataCadastro() + " Por " + usuario;
            linha[8] = "Em " + manutencao.getUltimaAlteracao() + " Por " + manutencao.getUsuarioAlt();
        } else {
            linha[7] = "Em " + manutencao.getDataCadastro() + " Por ";
            linha[8] = "Em " + manutencao.getUltimaAlteracao() + " Por " + manutencao.getUsuarioAlt();
        }

        return linha[numCol];
    }
}
