/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.tabelas;

import br.com.wss.modelo.Clientes;
import java.util.ArrayList;

/**
 *
 * @author William
 */
public class TabelaClientes extends Tabela{
    
      public TabelaClientes(ArrayList lin, String[] col) {
        super(lin, col);
    }

    @Override
    public Object getValueAt(int numLin, int numCol) {
        Clientes clientes = (Clientes) getLinhas().get(numLin);
        Object[] linha = new String[colunas.length];

        linha[0] = clientes.getNomeCliente();
        linha[1] = clientes.getCpf();
        linha[2] = clientes.getCelular();
        linha[3] = clientes.getTelefone();
        linha[4] = clientes.getNomeEstado();
        linha[5] = clientes.getNomeCidade();
        linha[6] = "Em " + clientes.getDataCadastro() + " Por " + clientes.getUsuarioCadClientes();
        linha[7] = "Em " + clientes.getUltimaAlteracao() + " Por " + clientes.getUsuarioAltClientes();                     
                
        return linha[numCol];
    }
    
}
