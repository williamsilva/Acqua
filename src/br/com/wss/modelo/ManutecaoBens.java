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
public class ManutecaoBens {
    int idManutecao;
    int idBen;
    String numeroControle;
    String responsavel;
    String altorizada;
    String contato;
    String descricao;
    String valorConserto;
    String dataRetorno;
    String dataSaida;

    public int getIdManutecao() {
        return idManutecao;
    }

    public void setIdManutecao(int idManutecao) {
        this.idManutecao = idManutecao;
    }

    public int getIdBen() {
        return idBen;
    }

    public void setIdBen(int idBen) {
        this.idBen = idBen;
    }

    public String getNumeroControle() {
        return numeroControle;
    }

    public void setNumeroControle(String numeroControle) {
        this.numeroControle = numeroControle;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValorConserto() {
        return valorConserto;
    }

    public void setValorConserto(String valorConserto) {
        this.valorConserto = valorConserto;
    }

    public String getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(String dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public ManutecaoBens(){
        
    }
    public ManutecaoBens(int idManutecao, int idBen, String numeroControle, String responsavel, String altorizada, String contato, String descricao, String valorConserto, String dataRetorno, String dataSaida) {
        this.idManutecao = idManutecao;
        this.idBen = idBen;
        this.numeroControle = numeroControle;
        this.responsavel = responsavel;
        this.altorizada = altorizada;
        this.contato = contato;
        this.descricao = descricao;
        this.valorConserto = valorConserto;
        this.dataRetorno = dataRetorno;
        this.dataSaida = dataSaida;
    }
        
}
