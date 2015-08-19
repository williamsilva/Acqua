package br.com.wss.modelo;

public class Usuario {

    private String nome;
    private String usuario;
    private String codigo;
    private String dataCadastro;
    private String ultimaAlteracao;
    private String ativo;
    private String senha;
    private String idUsuarioCad;
    private String idUsuarioAlt;
    private String logado;

    public Usuario() {
    }

    public Usuario(String nome, String usuario, String codigo, String dataCadastro, String ultimaAlteracao, String ativo, String senha, String idUsuarioCad, String idUsuarioAlt) {
        this.nome = nome;
        this.usuario = usuario;
        this.codigo = codigo;
        this.dataCadastro = dataCadastro;
        this.ultimaAlteracao = ultimaAlteracao;
        this.ativo = ativo;
        this.senha = senha;
        this.idUsuarioCad = idUsuarioCad;
        this.idUsuarioAlt = idUsuarioAlt;
    }

    public String getIdUsuarioAlt() {
        return idUsuarioAlt;
    }

    public void setIdUsuarioAlt(String idUsuarioAlt) {
        this.idUsuarioAlt = idUsuarioAlt;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getIdUsuarioCad() {
        return idUsuarioCad;
    }

    public void setIdUsuarioCad(String idUsuarioCad) {
        this.idUsuarioCad = idUsuarioCad;
    }

    public String getLogado() {
        return logado;
    }

    public void setLogado(String logado) {
        this.logado = logado;
    }

}
