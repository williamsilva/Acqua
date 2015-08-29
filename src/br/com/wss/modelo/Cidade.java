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
public class Cidade extends Estado{

    
    private int idCidade;
    private String nomeCidade;
    private String idEstadoCidade;
    private Estado estado;
    
    public Cidade() {
        estado = new Estado();
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getIdEstadoCidade() {
        return idEstadoCidade;
    }

    public void setIdEstadoCidade(String idEstadoCidade) {
        this.idEstadoCidade = idEstadoCidade;
    }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}
