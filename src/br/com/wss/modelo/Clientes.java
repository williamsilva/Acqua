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
    int idCliente;
    int idEnderecoCliente;
    String NomeCliente;
    Endereco endereco;
    String cpf;
    String dataNascimento;
    String dataCastro;
    String ultimaVisita;
    String email;
    String telefone;
    String celular;
    
    public void Clientes(){
        endereco = new Endereco();
    }
    
}
