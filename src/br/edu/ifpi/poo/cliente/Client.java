package br.edu.ifpi.poo.cliente;
import java.time.LocalDate;

import br.edu.ifpi.poo.conta.Conta;
import br.edu.ifpi.poo.endereco.Endereco;

// Declaração dos atributos da classe Cliente
public class Client {
    private String nome;
    private String cpf;
    private LocalDate Dn;
    private Endereco endereco;


    // Construtor da classe cliente para obter as informações iniciais do cliente
    public Client(String nome, String cpf, LocalDate Dn, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.Dn = Dn;
        this.endereco = endereco;
        
    }

    // Método para obter o nome do cliente
    public String getNome(){
        return nome;
    }

    //Permite definir ou atualizar o valor do nome
    public void setNome(String nome) {
    this.nome = nome;
    }

    // Método para obter o CPF do cliente
    public String getCpf(){
        return cpf;
    }

    // Método para obter a data de nascimento do cliente
    public LocalDate getDn(){
        return Dn;
    }

    // Permite definir ou ataualizar a data de nascimento
    public void setDn(LocalDate Dn){
    this.Dn = Dn;
    }

    // Método que retorna o objeto endereço, contendo informações do cliente
    // Usado para ter acesso aos detalhes do endereço do cliente
    public Endereco getEndereco(){
        return endereco;
    }

    public void adicionarConta(Conta criarConta) {
    }
}   

    
