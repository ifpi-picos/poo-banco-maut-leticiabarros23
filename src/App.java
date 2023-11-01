import br.edu.ifpi.poo.cliente.Client;
import br.edu.ifpi.poo.conta.Conta;
import br.edu.ifpi.poo.conta.ContaCorrente;
import br.edu.ifpi.poo.conta.ContaPoupanca;
import br.edu.ifpi.poo.notificacao.NotificacaoEmail;
import br.edu.ifpi.poo.notificacao.NotificacaoSms;

// Definição da classe app e criação de listas vazias para armazenar algumas informações do cliente
public class App {
    private static Client cliente;

    public static void main(String[] args) {

        Client client = new Client("Leticia", null, null, null);
        Conta cc = new ContaCorrente(client, 1, new NotificacaoEmail());
        Conta cc2 = new ContaCorrente(client, 1, new NotificacaoEmail());
        Conta cp = new ContaPoupanca(client, 2, new NotificacaoSms(), 0.1);

        cc.depositar(100);
        System.out.println(cc.getSaldo());
        cc.saque(50);
        System.out.println(cc.getSaldo());
        cc.transferir(cc2, 10);
        cc.transferir(cc2, 10);
        cc.transferir(cc2, 10);
        cc.transferir(cc2, 10);
        cc.transferir(cc2, 10);
        // uso do cheque especial não está funcionando corretamente
        cc.transferir(cc2, 10);
        System.out.println(cc.getSaldo());
        cc.exibeExtrato();
        System.out.println(cp);
        cp.depositar(100); // deposito na conta poupança não está funcionando
        System.out.println("saldo: " + cp.getSaldo());
        cp.saque(10);

        System.out.println(cp.getSaldo());
        cp.exibeExtrato();
    }
}


