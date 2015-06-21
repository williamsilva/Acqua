/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.tabelas;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author WILLIAM
 */
public abstract class Tabela extends AbstractTableModel {

    protected ArrayList linhas = null;
    protected String[] colunas = null;

    public Tabela(ArrayList lin, String[] col) {
        setLinhas(lin);
        setColunas(col);
    }

    public ArrayList getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList dados) {
        linhas = dados;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] nomes) {
        colunas = nomes;
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public String getColumnName(int numCol) {
        return colunas[numCol];
    }

    @Override
    public abstract Object getValueAt(int numLin, int numCol);
}
