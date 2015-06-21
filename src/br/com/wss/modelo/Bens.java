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
public class Bens {

    Double valorCompra;
    String dataCompra;
    int idGrupo;
    int idBens;
    String voltagem;
    String numeroSerie;
    String modelo;
    String fornecedor;
    String status;
    String local;
    String observacoes;
    String ultimaAlteracao;
    String dataCadastro;
    String nome;
    String numeroControle;
    String notaFiscal;
    String garantia;
    String vidaUtil;

    public Bens(String garantia, String vidaUtil, String numeroControle, String notaFiscal, Double valorCompra, String dataCompra, int idGrupo, int idBens, String voltagem, String numeroSerie, String modelo, String fornecedor, String status, String local, String observacoes, String ultimaAlteracao, String dataCadastro, String nome) {
        this.vidaUtil = vidaUtil;
        this.garantia = garantia;
        this.idBens = idBens;
        this.numeroControle = numeroControle;
        this.notaFiscal = notaFiscal;
        this.valorCompra = valorCompra;
        this.dataCompra = dataCompra;
        this.idGrupo = idGrupo;
        this.voltagem = voltagem;
        this.numeroSerie = numeroSerie;
        this.modelo = modelo;
        this.fornecedor = fornecedor;
        this.status = status;
        this.local = local;
        this.observacoes = observacoes;
        this.ultimaAlteracao = ultimaAlteracao;
        this.dataCadastro = dataCadastro;
        this.nome = nome;
    }

    public Bens() {
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public String getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(String vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    public int getIdBens() {
        return idBens;
    }

    public void setIdBens(int idBens) {
        this.idBens = idBens;
    }

    public String getNumeroControle() {
        return numeroControle;
    }

    public void setNumeroControle(String numeroControle) {
        this.numeroControle = numeroControle;
    }

    public String getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(String notalFiscal) {
        this.notaFiscal = notalFiscal;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(String voltagem) {
        this.voltagem = voltagem;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getUltimaAlteracao() {
        return ultimaAlteracao;
    }

    public void setUltimaAlteracao(String ultimaAlteracao) {
        this.ultimaAlteracao = ultimaAlteracao;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
