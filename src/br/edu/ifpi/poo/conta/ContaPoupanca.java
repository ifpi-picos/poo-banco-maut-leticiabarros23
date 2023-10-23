package br.edu.ifpi.poo.conta;
import br.edu.ifpi.poo.cliente.Client;
import br.edu.ifpi.poo.notificacoes.Notificacoes;
import br.edu.ifpi.poo.transacao.Transacao;

public class ContaPoupanca extends Conta{
    private String nome;
    private double valor;
    private double taxaTransferencia = 0.1;
    private double taxaSaque = 0.05;
    private double rendimento = 0.1;
    private Transacao transacao;
    private Notificacoes notificacoes;
    
    
    public ContaPoupanca(Client cliente, int numeroAgencia, String nome, double valor, double taxaTransferencia,
            double taxaSaque, double rendimento, Transacao transacao, Notificacoes notificacoes) {
        super(cliente, numeroAgencia);
        this.nome = nome;
        this.valor = valor;
        this.taxaTransferencia = taxaTransferencia;
        this.taxaSaque = taxaSaque;
        this.rendimento = rendimento;
        this.transacao = transacao;
        this.notificacoes = notificacoes;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public double getValor() {
        return valor;
    }


    public void setValor(double valor) {
        this.valor = valor;
    }


    public double getTaxaTransferencia() {
        return taxaTransferencia;
    }


    public void setTaxaTransferencia(double taxaTransferencia) {
        this.taxaTransferencia = taxaTransferencia;
    }


    public double getTaxaSaque() {
        return taxaSaque;
    }


    public void setTaxaSaque(double taxaSaque) {
        this.taxaSaque = taxaSaque;
    }


    public double getRendimento() {
        return rendimento;
    }


    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }


    public Transacao getTransacao() {
        return transacao;
    }


    public void setTransacao(Transacao transacao) {
        this.transacao = transacao;
    }


    public Notificacoes getNotificacoes() {
        return notificacoes;
    }


    public void setNotificacoes(Notificacoes notificacoes) {
        this.notificacoes = notificacoes;
    }

    
}
