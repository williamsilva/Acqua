package MODELO;

public class modelUsuario {
    String nome;
    String senha;
    String usuario;
    String codigo;
    public modelUsuario(){
        
    }
    public modelUsuario(String nome, String senha, String usuario, String codigo) {
        this.nome = nome;
        this.senha = senha;
        this.usuario = usuario;
        this.codigo = codigo;
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
    
}
