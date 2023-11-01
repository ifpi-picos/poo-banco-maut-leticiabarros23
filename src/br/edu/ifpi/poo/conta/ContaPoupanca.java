package br.edu.ifpi.poo.conta;

import br.edu.ifpi.poo.cliente.Client;
import br.edu.ifpi.poo.notificacao.Notificacao;
import br.edu.ifpi.poo.transacao.Transacao;

public class ContaPoupanca extends Conta {
    private double rendimento = 0.1;


    public ContaPoupanca(Client cliente, int numeroAgencia, Notificacao notificacao,
            double rendimento) {
        super(cliente, numeroAgencia, notificacao);
        this.rendimento = 0.1;

    }


    @Override
    public boolean saque(double valor) {
        double taxa = valor * 0.05; // 5% de taxa
        if (this.saldo >= valor + taxa) {
            saldo -= valor + taxa;
            notificacao.enviarNotificacao("saque");
            return true;
        } else {
            notificacao.enviarNotificacao(
                    "Saldo insuficiente para saque de " + valor + " com taxa de " + taxa);
            return false;
        }
    }

    @Override
    public void transferir(Conta destino, double valor) {
        double taxa = valor * 0.10; // 10% de taxa
        if (this.saldo >= valor + taxa) {
            destino.saldo += valor;
            destino.depositar(valor);
            getTransacao().add(new Transacao(valor, "transferecia"));
            notificacao.enviarNotificacao(
                    "Transferência realizada no valor de " + valor + " com taxa de " + taxa);
        } else {
            notificacao.enviarNotificacao(
                    "Saldo insuficiente para transferência de " + valor + " com taxa de " + taxa);
        }
    }

    @Override
    public void depositar(double valor) {
        double rendimentoGanho = valor * (rendimento / 100); // Calcular o rendimento
        if (saldo > 0) {
            saldo += rendimentoGanho;
            notificacao.enviarNotificacao("Depósito realizado no valor de " + valor
                    + " com rendimento de " + rendimentoGanho);
            getTransacao().add(new Transacao(valor, "deposito"));
        }

    }
}
