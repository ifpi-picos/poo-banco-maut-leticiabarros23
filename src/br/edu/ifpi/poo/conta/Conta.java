package br.edu.ifpi.poo.conta;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.poo.cliente.Client;
import br.edu.ifpi.poo.transacao.Transacao;

public abstract class Conta  {
    private Client cliente;
    private int numeroAgencia;
    private int numeroConta;
    private double saldo;
    private List<Transacao> transacao;

    // Variável estática para contar o número de contas criadas.
    private static int contadorContas = 0;

    // Construtor da classe Conta
    public Conta(Client cliente, int numeroAgencia) {
        this.cliente = cliente;
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = ++contadorContas;
        this.saldo = 0.0;
        this.transacao = new ArrayList<>();
    }

    // Método para obter o número da agência 
    public int getNumeroAgencia(){
        return numeroAgencia;
    }

    public void setNumeroAgencia(int numeroAgencia) {
    this.numeroAgencia = numeroAgencia;
}

    // Método para obter o saldo da conta 
    public double getSaldo() {
        return saldo;
    }

    // Método para definir o saldo da conta
    public void setSaldo(double saldo) {
    this.saldo = saldo;
    }

    // Método para obter o cliente da conta
    public Client getClient() {
        return cliente;
    }
    public void setCliente(Client client) {
    this.cliente = client;
    }

    // Método para obter o número da conta
    public int getNumeroConta(){
        return numeroConta;
    }

    public void SetNumeroConta(int NumeroConta){
    this.numeroConta = NumeroConta;
    }
 
    // Método para depositar na conta, aumentando o saldo
    public void depositar(double valor) {
        this.saldo += valor;
        addHistoricoTransacao(valor, "deposito");
    }

    // Método para reallizar saque na conta, podendo diminuir o valor se tiver dinheiro suficiente 
    public boolean saque(double valor){
        if(this.saldo >= valor){
            this.saldo -= valor;
            this.addHistoricoTransacao(valor*-1, "saque");
            return true;
        }else{
            return false;
        }
    }

    public void exibeExtrato(){
        this.transacao.forEach(t -> System.out.println(t));
        System.out.println("Saldo atual: " + this.saldo);
        System.out.println("################");
    }

    private void addHistoricoTransacao(double valor, String tipo){
        Transacao t = new Transacao(LocalDate.now(), valor, tipo);
        this.transacao.add(t);
    }

    public static Conta get(int i) {
        return null;
    }
}
