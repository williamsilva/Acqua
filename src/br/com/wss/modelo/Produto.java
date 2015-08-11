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
public class Produto {
    private int idProduto;
    private int idUsuarioAlt;
    private int IdUsuarioCad;
    private String descricao;
    private String validade;
    private Double valor;
    private String desconto;
    private String status;
    private String dataCadastro;
    private String ultimaAlteracao;
    
    public Produto() {
    }

    public Produto(int idProduto, int idUsuarioAlt, int IdUsuarioCad, String descricao, String validade, Double valor, String desconto, String status, String dataCadastro, String ultimaAlteracao) {
        this.idProduto = idProduto;
        this.idUsuarioAlt = idUsuarioAlt;
        this.IdUsuarioCad = IdUsuarioCad;
        this.descricao = descricao;
        this.validade = validade;
        this.valor = valor;
        this.desconto = desconto;
        this.status = status;
        this.dataCadastro = dataCadastro;
        this.ultimaAlteracao = ultimaAlteracao;
    }   

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdUsuarioAlt() {
        return idUsuarioAlt;
    }

    public void setIdUsuarioAlt(int idUsuarioAlt) {
        this.idUsuarioAlt = idUsuarioAlt;
    }

    public int getIdUsuarioCad() {
        return IdUsuarioCad;
    }

    public void setIdUsuarioCad(int IdUsuarioCad) {
        this.IdUsuarioCad = IdUsuarioCad;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDesconto() {
        return desconto;
    }

    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
   
}
