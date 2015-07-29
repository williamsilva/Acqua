/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.modelo;

/**
 *
 * @author Estatica
 */
public class Estado {

    String idEstado;
    String nome;

    public Estado() {
    }

    public Estado(String idEstado, String nome) {
        this.idEstado = idEstado;
        this.nome = nome;
    }

    public String getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(String idEstado) {
        this.idEstado = idEstado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
// gerar a sigla pelo nome. 
    public String SiglaEstado(String nomeEstado){
        if (nomeEstado.equals("teste")) {
            
        }
        return "";
    }
}
