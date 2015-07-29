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
public class Fornecedor {

    private String UsuarioCad;
    private String UsuarioAlt;
    private int idFornecedor;
    private String nomeFornecedor;
    private String telefone;
    private String contato;
    private String email;
    private String cidade;
    private String endereco;
    private String numero;
    private String ultimaAlteracao;
    private String dataCadastro;
    private String celular;
    private String bairro;
    private String estado;
    private String cep;

    public Fornecedor() {
    }

    public Fornecedor(String UsuarioCad, String UsuarioAlt, int idFornecedor, String nomeFornecedor, String telefone, String contato, String email, String cidade, String endereco, String numero, String ultimaAlteracao, String dataCadastro, String celular, String bairro, String estado, String cep) {
        this.UsuarioCad = UsuarioCad;
        this.UsuarioAlt = UsuarioAlt;
        this.idFornecedor = idFornecedor;
        this.nomeFornecedor = nomeFornecedor;
        this.telefone = telefone;
        this.contato = contato;
        this.email = email;
        this.cidade = cidade;
        this.endereco = endereco;
        this.numero = numero;
        this.ultimaAlteracao = ultimaAlteracao;
        this.dataCadastro = dataCadastro;
        this.celular = celular;
        this.bairro = bairro;
        this.estado = estado;
        this.cep = cep;
    }

    public String getUsuarioCad() {
        return UsuarioCad;
    }

    public void setUsuarioCad(String UsuarioCad) {
        this.UsuarioCad = UsuarioCad;
    }

    public String getUsuarioAlt() {
        return UsuarioAlt;
    }

    public void setUsuarioAlt(String UsuarioAlt) {
        this.UsuarioAlt = UsuarioAlt;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

}