package br.edu.ifpi.poo.conta;

import br.edu.ifpi.poo.cliente.Client;
import br.edu.ifpi.poo.notificacao.Notificacao;
import br.edu.ifpi.poo.notificacao.NotificacaoSms;
import br.edu.ifpi.poo.transacao.Transacao;

public class ContaCorrente extends Conta {
    private int transferenciasGratis;
    private double chequeEspecial;

    public ContaCorrente(Client cliente, int numeroAgencia, Notificacao notificacao) {
        super(cliente, numeroAgencia, notificacao);
        this.transferenciasGratis = 2;
        this.chequeEspecial = 1000;
    }

    @Override
    public void transferir(Conta destino, double valor) {
        if (transferenciasGratis > 0) {
            if (this.saldo >= valor) {
                this.saque(valor);
                destino.depositar(valor);
                getTransacao().add(new Transacao(valor, "transferecia"));
                transferenciasGratis--;
                System.out.println("Transferência realizada no valor de " + valor);
            } else {
                System.out.println("Saldo insuficiente para transferência de " + valor);
            }
        } else {
            double taxa = valor * 0.10; // 10% de taxa
            if (this.saldo >= valor + taxa) {
                this.saque(valor + taxa);
                destino.depositar(valor);
                getTransacao().add(new Transacao(valor, "transferecia"));

                System.out.println("Transferência realizada no valor de " + valor + " com taxa de " + taxa);
            } else {
                System.out.println("Saldo insuficiente para transferência de " + valor + " com taxa de " + taxa);
            }
        }
    }

    @Override
    public boolean saque(double valor) {

        if (this.saldo + chequeEspecial >= valor) {
            this.saldo -= valor;
            getTransacao().add(new Transacao(valor, "saque"));
            notificacao.enviarNotificacao("Saque");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");

        } else {
            System.out.println("Erro: O valor do depósito deve ser maior que zero.");

        }

    }
}
