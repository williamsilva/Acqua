package MODELO;

public class modelComputador {

    String mac;
    String nome;

    public modelComputador() {

    }

    public modelComputador(String mac, String nome) {
        this.mac = mac;
        this.nome = nome;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
