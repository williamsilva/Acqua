package MODELO;

public class modelComputador {

    String computador;
    String mac;
    String data_cadastro;
    String ultima_auteracao;
    int id;

    
    
    public modelComputador() {

    }

    public modelComputador(String computador, String mac, String data_cadastro, String ultima_auteracao, int id) {
        this.computador = computador;
        this.mac = mac;
        this.data_cadastro = data_cadastro;
        this.ultima_auteracao = ultima_auteracao;
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    

}
