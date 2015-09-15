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
public class Clientes extends Endereco{
    private int idCliente;
    private int numero;
    private String NomeCliente;    
    private String cpf;
    private String dataNascimento;    
    private String email;
    private String telefone;
    private String celular;
    private String usuarioCadClientes;
    private String usuarioAltClientes;
    private Endereco endereco;
    private String dataCadastro;
    private String UltimaAlteracao;
    private String sexo;
        
    public void Clientes(){
        endereco = new Endereco();
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNomeCliente() {
        return NomeCliente;
    }

    public void setNomeCliente(String NomeCliente) {
        this.NomeCliente = NomeCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getUsuarioCadClientes() {
        return usuarioCadClientes;
    }

    public void setUsuarioCadClientes(String usuarioCadClientes) {
        this.usuarioCadClientes = usuarioCadClientes;
    }

    public String getUsuarioAltClientes() {
        return usuarioAltClientes;
    }

    public void setUsuarioAltClientes(String usuarioAltClientes) {
        this.usuarioAltClientes = usuarioAltClientes;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getUltimaAlteracao() {
        return UltimaAlteracao;
    }

    public void setUltimaAlteracao(String UltimaAlteracao) {
        this.UltimaAlteracao = UltimaAlteracao;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
}
