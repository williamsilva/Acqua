package MODELO;

public class modelUsuario {
     String nome;
    String senha;
    String usuario;
    String codigo;    
    String data_cadastro;
    String ultima_auteracao;
    String ativo;
  
    public modelUsuario(){
        
    }

    public modelUsuario(String nome, String senha, String usuario, String codigo, String data_cadastro, String ultima_auteracao, String ativo) {
        this.nome = nome;
        this.senha = senha;
        this.usuario = usuario;
        this.codigo = codigo;
        this.data_cadastro = data_cadastro;
        this.ultima_auteracao = ultima_auteracao;
        this.ativo = ativo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public String getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(String data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public String getUltima_auteracao() {
        return ultima_auteracao;
    }

    public void setUltima_auteracao(String ultima_auteracao) {
        this.ultima_auteracao = ultima_auteracao;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    
}
