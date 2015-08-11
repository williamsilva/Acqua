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

    private String usuarioCad;
    private String usuarioAlt;
    private int idManutecao;
    private int inBens;
    private String numeroRegistro;
    private String responsavel;
    private String altorizada;
    private String contato;
    private String observacoes;
    private String dataSaida;
    private String dataRetorno;
    private String nomeBens;
    private Double valorConserto;
    private String dataCadastro;
    private String ultimaAlteracao;
    private String finalGarantia;

    public Manutencao() {
    }

    public Manutencao(String usuarioCad, String usuarioAlt, int idManutecao, int inBens, String numeroRegistro, String responsavel, String altorizada, String contato, String observacoes, String dataSaida, String dataRetorno, String nomeBens, Double valorConserto) {
        this.usuarioCad = usuarioCad;
        this.usuarioAlt = usuarioAlt;
        this.idManutecao = idManutecao;
        this.inBens = inBens;
        this.numeroRegistro = numeroRegistro;
        this.responsavel = responsavel;
        this.altorizada = altorizada;
        this.contato = contato;
        this.observacoes = observacoes;
        this.dataSaida = dataSaida;
        this.dataRetorno = dataRetorno;
        this.nomeBens = nomeBens;
        this.valorConserto = valorConserto;
        
    }
    public String getUsuarioCad() {
        return usuarioCad;
    }

    public void setUsuarioCad(String usuarioCad) {
        this.usuarioCad = usuarioCad;
    }

    public String getUsuarioAlt() {
        return usuarioAlt;
    }

    public void setUsuarioAlt(String usuarioAlt) {
        this.usuarioAlt = usuarioAlt;
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

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(String numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
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

    public String getNomeBens() {
        return nomeBens;
    }

    public void setNomeBens(String nomeBens) {
        this.nomeBens = nomeBens;
    }

    public Double getValorConserto() {
        return valorConserto;
    }

    public void setValorConserto(Double valorConserto) {
        this.valorConserto = valorConserto;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getUltimaAlteracao() {
        return ultimaAlteracao;
    }

    public void setUltimaAlteracao(String ultimaAlteracao) {
        this.ultimaAlteracao = ultimaAlteracao;
    }

    public String getFinalGarantia() {
        return finalGarantia;
    }

    public void setFinalGarantia(String finalGarantia) {
        this.finalGarantia = finalGarantia;
    }

}
