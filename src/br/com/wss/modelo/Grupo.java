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

    private String dataCadastro;
    private String ultimaAlteracao;
    private String nomeGrupo;
    private String descricao;
    private int idGrupo;
    private String UsuarioCad;
    private String UsuarioAlt;

    public Grupo() {
    }

    public Grupo(String dataCadastro, String ultimaAlteracao, String nomeGrupo, String descricao, int idGrupo, String UsuarioCad, String UsuarioAlt) {
        this.dataCadastro = dataCadastro;
        this.ultimaAlteracao = ultimaAlteracao;
        this.nomeGrupo = nomeGrupo;
        this.descricao = descricao;
        this.idGrupo = idGrupo;
        this.UsuarioCad = UsuarioCad;
        this.UsuarioAlt = UsuarioAlt;
    }

    public String getUsuarioAlt() {
        return UsuarioAlt;
    }

    public void setUsuarioAlt(String UsuarioAlt) {
        this.UsuarioAlt = UsuarioAlt;
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

    public String getNomeGrupo() {
        return nomeGrupo;
    }

    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getUsuarioCad() {
        return UsuarioCad;
    }

    public void setUsuarioCad(String UsuarioCad) {
        this.UsuarioCad = UsuarioCad;
    }

    }
