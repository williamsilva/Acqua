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
public class Endereco extends Cidade {

    private int idCidadeEndereco;
    private int idEndereco;
    private int cep;
    private String rua;
    private String bairro;
    private Cidade cidade;

    public Endereco() {
        cidade = new Cidade();
    }

    public int getIdCidadeEndereco() {
        return idCidadeEndereco;
    }

    public void setIdCidadeEndereco(int idCidadeEndereco) {
        this.idCidadeEndereco = idCidadeEndereco;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

}
