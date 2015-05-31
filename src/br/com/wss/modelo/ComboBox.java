/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.modelo;

import java.util.ArrayList;

/**
 *
 * @author William
 */
public abstract class ComboBox {
     protected ArrayList linhas = null;

    public ArrayList getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList linhas) {
        this.linhas = linhas;
    }
    public abstract Object getValueAt(int numLin);
}
