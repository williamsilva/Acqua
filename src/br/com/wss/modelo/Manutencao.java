/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wss.modelo;

/**
 *
 * @author William
 */
public class Manutencao {

    private int idManutecao;
    private int inBens;
    private int numeroRegistro;
    private String responsavel;
    private String altorizada;
    private String contato;
    private String observacoes;
    private String dataSaida;
    private String dataRetorno;
    private Double valorConserto;

    public Manutencao() {
    }

    public Manutencao(int numeroRegistro, int idManutecao, int inBens, String responsavel, String altorizada, String contato, String observacoes, String dataSaida, String dataRetorno, Double valorConserto) {
        this.numeroRegistro = numeroRegistro;
        this.idManutecao = idManutecao;
        this.inBens = inBens;
        this.responsavel = responsavel;
        this.altorizada = altorizada;
        this.contato = contato;
        this.observacoes = observacoes;
        this.dataSaida = dataSaida;
        this.dataRetorno = dataRetorno;
        this.valorConserto = valorConserto;
    }

    public int getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(int numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public Double getValorConserto() {
        return valorConserto;
    }

    public void setValorConserto(Double valorConserto) {
        this.valorConserto = valorConserto;
    }

    public int getIdManutecao() {
        return idManutecao;
    }

    public void setIdManutecao(int idManutecao) {
        this.idManutecao = idManutecao;
    }

    public int getInBens() {
        return inBens;
    }

    public void setInBens(int inBens) {
        this.inBens = inBens;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getAltorizada() {
        return altorizada;
    }

    public void setAltorizada(String altorizada) {
        this.altorizada = altorizada;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(String dataRetorno) {
        this.dataRetorno = dataRetorno;
    }
}
