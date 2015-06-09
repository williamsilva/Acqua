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
public class Grupo {

    String dataCadastro;
    String ultimaAlteracao;
    String nome;
    String descricao;
    int idGrupo;

    public Grupo() {
    }

    public Grupo(String dataCadastro, String ultimaAlteracao, String nome, String descricao,int idGrupo) {
        this.dataCadastro = dataCadastro;
        this.ultimaAlteracao = ultimaAlteracao;
        this.nome = nome;
        this.descricao = descricao;
        this.idGrupo = idGrupo;
    }
    public int getIdGrupo(){
        return idGrupo;
    }
    public void setIdGrupo(int idGrupo){
        this.idGrupo = idGrupo;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
