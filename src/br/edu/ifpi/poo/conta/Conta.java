package br.edu.ifpi.poo.conta;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.poo.cliente.Client;
import br.edu.ifpi.poo.notificacao.Notificacao;
import br.edu.ifpi.poo.transacao.Transacao;

public abstract class Conta  {
    private static int numeroConta = 1;
    private Client cliente;
    private int numeroAgencia;
    protected double saldo;
    private List<Transacao> transacao;
    protected Notificacao notificacao;
    private int numero;


    // Construtor da classe Conta
    public Conta(Client cliente, int numeroAgencia, Notificacao notificacao) {
        this.cliente = cliente;
        this.numeroAgencia = numeroAgencia;
        this.saldo = 0.0;
        this.transacao = new ArrayList<>();
        this.notificacao = notificacao;
        this.numero = numeroConta++;
    }

    // Método para obter o número da agência 
    public int getNumeroAgencia(){
        return numeroAgencia;
    }

    public void setNumeroAgencia(int numeroAgencia) {
    this.numeroAgencia = numeroAgencia;
    }

    public int getNumero(){
    return numero;
    }

    public Notificacao getNotificacao() {
        return notificacao;
    }

    public Client getCliente() {
        return cliente;
    }

    public void setNotificacao(Notificacao notificacao) {
        this.notificacao = notificacao;
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
    public abstract void depositar(double valor);

    // Método para realizar saque na conta, podendo diminuir o valor se tiver dinheiro suficiente 
    public abstract boolean saque(double valor);

    public abstract void transferir(Conta destino, double valor);
   
    public List<Transacao> getTransacao() {
        return transacao;
    }

    public void exibeExtrato(){
        this.transacao.forEach(t -> System.out.println(t));
        System.out.println("Saldo atual: " + this.saldo);
        System.out.println("################");
    }

    public static Conta get(int i) {
        return null;
    }
}
