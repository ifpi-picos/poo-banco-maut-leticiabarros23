import java.time.LocalDate;
import java.util.Scanner;
import br.edu.ifpi.poo.cliente.Client;
import br.edu.ifpi.poo.conta.Conta;
import br.edu.ifpi.poo.conta.ContaCorrente;
import br.edu.ifpi.poo.conta.ContaPoupanca;
import br.edu.ifpi.poo.endereco.Endereco;
import br.edu.ifpi.poo.notificacao.Notificacao;
import br.edu.ifpi.poo.notificacao.NotificacaoEmail;
import br.edu.ifpi.poo.notificacao.NotificacaoSms;


import java.util.ArrayList;
import java.util.List;

//Definição da classe app e criação de listas vazias para armazenar algumas informações do cliente 
public class App {
    private static Client cliente;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Notificacao> notificacaos = new ArrayList<>();
        List<Client> clientes = new ArrayList<>();
        List<Conta> contas = new ArrayList<>();
        List<Endereco> enderecos = new ArrayList<>();


        // Usado para criar um menu interativo permitindo que o usuário realize várias operações ou mesmo encerre o programa
        while (true) {
            System.out.println("1 - Cadastro de Cliente");
            System.out.println("2 - Criar conta");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Visualizar dados de conta");
            System.out.println("6 - Ver extrato");
            System.out.println("7 - Tranferir");
            System.out.println("0 - Sair\n");
            System.out.print("Digite a opção desejada: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                cadastroCliente(clientes, enderecos, scanner);
            } else if (opcao == 2) {
                criarConta(contas,clientes, scanner);
            } else if (opcao == 3) {
                deposito(contas, scanner);
            } else if (opcao == 4){
                sacar(contas, scanner, null);
            } else if (opcao == 5) {
                visualizarConta(contas, scanner);
            } else if (opcao == 6) {
                exibirExtrato(contas, scanner);
            } else if (opcao == 7) {
                transferirDinheiro(contas, scanner);
            } else if (opcao == 0) {
                System.out.println("Você saiu do programa!");
                break;
            }
        }
    }

    public static void cadastroCliente(List<Client> clientes, List<Endereco> enderecos, Scanner scanner) {
        System.out.println("Cadastrar cliente:");
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o cpf do cliente: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite a data de nascimento do cliente (no formato AAAA-MM-DD): ");
        LocalDate dataNascimento = LocalDate.parse(scanner.nextLine());
        System.out.print("Digite a rua: ");
        String rua = scanner.nextLine();
        System.out.print("Digite o bairro: ");
        String bairro = scanner.nextLine();
        System.out.print("Digite seu cep: ");
        String cep = scanner.nextLine();
        System.out.print("Digite seu número: ");
        int numero = scanner.nextInt();

        Endereco endereco = new Endereco(rua, cep, numero, bairro);
        enderecos.add(endereco);

        Client cliente = new Client(nome, cpf, dataNascimento, endereco);
        clientes.add(cliente);   
    }

    public static void criarConta(List<Conta> contas, List<Client> clientes, Scanner scanner) {
            System.out.print("Digite o CPF do cliente: ");
            String cpf = scanner.nextLine();
            
            Client cliente = findClientByCPF(clientes, cpf);
        
            if (cliente == null) {
                System.out.println("Cliente com o CPF fornecido não encontrado. Não é possível criar uma conta.");
                return;
            }
        
            System.out.println("Qual conta você deseja criar?");
            System.out.println("1 - Conta Corrente");
            System.out.println("2 - Conta Poupança");
        
            int escolha = scanner.nextInt();
        
            switch (escolha) {
                case 1:
                case 2:
                    System.out.print("Digite o número da agência: ");
                    int numeroAgencia = scanner.nextInt();
                    Conta criarConta = null;
        
                    if (escolha == 1) {
                        criarConta = new ContaCorrente(cliente, numeroAgencia, new NotificacaoSms());
                    } else if (escolha == 2) {
                        criarConta = new ContaPoupanca(cliente, numeroAgencia, new NotificacaoSms(), 0.1);
                    }
        
                    contas.add(criarConta);
                    cliente.adicionarConta(criarConta);
                    criarConta.setNotificacao(new NotificacaoEmail());
                    criarConta.setNotificacao(new NotificacaoSms());
        
                    System.out.println("\nConta criada com sucesso. Saldo inicial: " + criarConta.getSaldo() + " reais.");
                    System.out.println("Número da conta: " + criarConta.getNumero());
                    System.out.println("Número da agência: " + criarConta.getNumeroAgencia());
                    break;
        
                default:
                    System.out.println("Escolha inválida. Por favor, escolha 1 para Conta Corrente ou 2 para Conta Poupança.");
            }
        }
    
    
        private static Client findClientByCPF(List<Client> clientes, String cpf) {
            for (Client c : clientes) {
                if (c.getCpf().equals(cpf)) {
                    return c;
                }
            }
            return null;
    }

    public static void visualizarConta(List<Conta> contas,  Scanner scanner) {
        System.out.print("Digite o número da conta que deseja visualizar: ");
        int numeroConta = scanner.nextInt();
    
        Conta contaSelecionada = null;
    
        for (Conta conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                contaSelecionada = conta;
                break;
            }
        }
    
        if (contaSelecionada != null) {
            Client cliente = contaSelecionada.getClient();
    
            Endereco endereco = cliente.getEndereco();
    
            System.out.println("Informações da conta:");
            System.out.println("Número da conta: " + contaSelecionada.getNumeroConta());
            System.out.println("Saldo da conta: " + contaSelecionada.getSaldo());
    
            System.out.println("\nInformações do cliente:");
            System.out.println("Nome do cliente: " + cliente.getNome());
            System.out.println("CPF do cliente: " + cliente.getCpf());
            System.out.println("Data de nascimento do cliente: " + cliente.getDn());
    
            System.out.println("\nInformações do endereço do cliente:");
            System.out.println("Rua: " + endereco.getRua());
            System.out.println("CEP: " + endereco.getCep());
            System.out.println("Número: " + endereco.getNumero());
            System.out.println("Bairro: " + endereco.getBairro());
        } else {
            System.out.println("Conta não encontrada.");
        }
    }
    
    public static void deposito(List<Conta> contas, Scanner scanner) {
        System.out.print("Digite o número da conta para o depósito: ");
        int numeroConta = scanner.nextInt();

        // Encontrar a conta para deposito
        Conta contaParaDeposito = null;
        for (Conta conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                contaParaDeposito = conta;
                break;
            }
        }

        if (contaParaDeposito != null) {
            System.out.print("Digite o valor do depósito: ");
            double valorDeposito = scanner.nextDouble();

            //Realizar o deposito
            contaParaDeposito.depositar(valorDeposito);

            System.out.println("Depósito realizado com sucesso. Novo saldo da conta: " + contaParaDeposito.getSaldo());
            System.out.println("Enviando notificação para o cliente... Sms enviado!");
            System.out.println("Enviando notificação para o cliente... Emailenviado!");
            System.out.println("\n Novo saldo da conta:" + contaParaDeposito.getSaldo());
        } else {
            System.out.println("Conta para deposito não encontrada.");
        }
    }   
    
    public static void sacar(List<Conta> contas, Scanner scanner, Client[] clientes) {
        System.out.print("Digite o número da conta para o saque: ");
        int numeroConta = scanner.nextInt();
        scanner.nextLine();

        Conta contaSaque = null;
        for (Client cliente: clientes){
            for (Conta conta : contas) {
                if (conta.getNumeroConta() == numeroConta) {
                    contaSaque = conta;
                    break;
                }
            }
        }
        if (contaSaque != null) {
            System.out.print("Digite o valor do saque: ");
            double valorDeposito = scanner.nextDouble();

            contaSaque.saque(valorDeposito);

            System.out.println("Saque realizado com sucesso. Novo saldo da conta: " + contaSaque.getSaldo());
            System.out.println("Enviando notificação para o cliente... Sms enviado!");
            System.out.println("Enviando notificação para o cliente... Email enviado!");
        } else {
            System.out.println("Conta não encontrada."); 
        }
    }
    

        public static void transferirDinheiro(List<Conta> contas, Scanner scanner) {
        System.out.print("Digite o número da conta de origem: ");
        int numeroContaOrigem = scanner.nextInt();
    
        Conta contaOrigem = null;
    
        for (Conta conta : contas) {
            if (conta.getNumeroConta() == numeroContaOrigem) {
                contaOrigem = conta;
                break;
            }
        }

        if (contaOrigem != null) {
            System.out.print("Digite o número da conta de destino: ");
            int numeroContaDestino = scanner.nextInt();
    
            Conta contaDestino = null;
    
            for (Conta conta : contas) {
                if (conta.getNumeroConta() == numeroContaDestino) {
                contaDestino = conta;
                break;
                }
            }
    
            if (contaDestino != null) {
                System.out.print("Digite o valor a ser transferido: ");
                double valorTransferencia = scanner.nextDouble();
    
                if (contaOrigem.saque(valorTransferencia)) {
                    contaDestino.depositar(valorTransferencia);
                    System.out.println("Transferência realizada com sucesso!");
                    System.out.println("Enviando notificação para o cliente... Sms enviado!");
                    System.out.println("Enviando notificação para o cliente... Email enviado!");
                    System.out.println("Novo saldo da conta de origem: " + contaOrigem.getSaldo());
                    System.out.println("Novo saldo da conta de destino: " + contaDestino.getSaldo());
        } else {
            System.out.println("Saldo insuficiente na conta de origem para realizar a transferência.");
                }
        } else {
            System.out.println("Conta de destino não encontrada.");
            }
        } else {
            System.out.println("Conta de origem não encontrada.");
        }
    }    

    public static void exibirExtrato(List<Conta> contas, Scanner scanner) {
        System.out.print("Digite o número da conta para exibir o extrato: ");
        int numeroConta = scanner.nextInt();
    
        Conta contaSelecionada = null;
    
        for (Conta conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                contaSelecionada = conta;
                break;
            }
        }

    
        if (contaSelecionada != null) {
            contaSelecionada.exibeExtrato();
        } else {
            System.out.println("Conta não encontrada.");
        }
    }
}
    
    
    
    