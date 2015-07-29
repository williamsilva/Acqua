package br.com.wss.modelo;

public class Computador {

    private String computador;
    private String mac;
    private String dataCadastro;
    private String ultimaAlteracao;
    private int id;
    private String idUsuarioCad;
    private String idUsuarioAlt;

    public Computador() {
    }

    public Computador(String computador, String mac, String dataCadastro, String ultimaAlteracao, int id, String idUsuarioCad, String idUsuarioAlt) {
        this.computador = computador;
        this.mac = mac;
        this.dataCadastro = dataCadastro;
        this.ultimaAlteracao = ultimaAlteracao;
        this.id = id;
        this.idUsuarioCad = idUsuarioCad;
        this.idUsuarioAlt = idUsuarioAlt;
    }

    public String getIdUsuarioAlt() {
        return idUsuarioAlt;
    }

    public void setIdUsuarioAlt(String idUsuarioAlt) {
        this.idUsuarioAlt = idUsuarioAlt;
    }

    public String getComputador() {
        return computador;
    }

    public void setComputador(String computador) {
        this.computador = computador;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdUsuarioCad() {
        return idUsuarioCad;
    }

    public void setIdUsuarioCad(String idUsuarioCad) {
        this.idUsuarioCad = idUsuarioCad;
    }

    }
