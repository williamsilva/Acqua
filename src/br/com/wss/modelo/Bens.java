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

    private Double valorCompra;
    private String dataCompra;
    private String idUsuarioCad;
    private String idUsuarioAlt;
    private int idGrupo;
    private int idBens;
    private int idFornecedor;
    private String voltagem;
    private String numeroSerie;
    private String modelo;    
    private String status;
    private String local;
    private String observacoes;
    private String ultimaAlteracao;
    private String dataCadastro;
    private String nome;
    private String numeroControle;
    private String notaFiscal;
    private String garantia;
    private String vidaUtil;
    private String finalGarantia;
    private String inicioGarantia;

   

    public Bens() {
    }

    public Bens(Double valorCompra, String dataCompra, String idUsuarioCad, String idUsuarioAlt, int idGrupo, int idBens, int idFornecedor, String voltagem, String numeroSerie, String modelo, String status, String local, String observacoes, String ultimaAlteracao, String dataCadastro, String nome, String numeroControle, String notaFiscal, String garantia, String vidaUtil) {
        this.valorCompra = valorCompra;
        this.dataCompra = dataCompra;
        this.idUsuarioCad = idUsuarioCad;
        this.idUsuarioAlt = idUsuarioAlt;
        this.idGrupo = idGrupo;
        this.idBens = idBens;
        this.idFornecedor = idFornecedor;
        this.voltagem = voltagem;
        this.numeroSerie = numeroSerie;
        this.modelo = modelo;
        this.status = status;
        this.local = local;
        this.observacoes = observacoes;
        this.ultimaAlteracao = ultimaAlteracao;
        this.dataCadastro = dataCadastro;
        this.nome = nome;
        this.numeroControle = numeroControle;
        this.notaFiscal = notaFiscal;
        this.garantia = garantia;
        this.vidaUtil = vidaUtil;
    }

    public String getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(String vidaUtil) {
        this.vidaUtil = vidaUtil;
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

    public String getIdUsuarioCad() {
        return idUsuarioCad;
    }

    public void setIdUsuarioCad(String idUsuarioCad) {
        this.idUsuarioCad = idUsuarioCad;
    }

    public String getIdUsuarioAlt() {
        return idUsuarioAlt;
    }

    public void setIdUsuarioAlt(String idUsuarioAlt) {
        this.idUsuarioAlt = idUsuarioAlt;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public int getIdBens() {
        return idBens;
    }

    public void setIdBens(int idBens) {
        this.idBens = idBens;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
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

    public String getNumeroControle() {
        return numeroControle;
    }

    public void setNumeroControle(String numeroControle) {
        this.numeroControle = numeroControle;
    }

    public String getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public String getFinalGarantia() {
        return finalGarantia;
    }

    public void setFinalGarantia(String finalGarantia) {
        this.finalGarantia = finalGarantia;
    }

    public String getInicioGarantia() {
        return inicioGarantia;
    }

    public void setInicioGarantia(String inicioGarantia) {
        this.inicioGarantia = inicioGarantia;
    }
    
    }
