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
        UsuarioDao dao = new UsuarioDao();
        String usuarioCad = dao.buscaUsuario(usuario.getIdUsuarioCad());
        String usuarioAlt = dao.buscaUsuario(usuario.getIdUsuarioAlt());
        if (usuarioCad != null && usuarioAlt != null) {
            linha[2] = "Em " + usuario.getDataCadastro() + " Por " + usuarioCad;
            linha[3] = "Em " + usuario.getUltimaAlteracao() + " Por " + usuarioAlt;
        } else {
            linha[2] = "Em " + usuario.getDataCadastro() + " Por ";
            linha[3] = "Em " + usuario.getUltimaAlteracao() + " Por ";
        }
        linha[4] = usuario.getAtivo();
        return linha[numCol];
    }
}
