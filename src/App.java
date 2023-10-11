//
import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Client> clientes = new ArrayList<>();
        List<Conta> contas = new ArrayList<>();
        List<Endereco> enderecos = new ArrayList<>();

        while(true) {
            System.out.println("1 - Cadastro de Cliente");
            System.out.println("2- Depositar");
            System.out.println("0- Sair\n");
            System.out.print("Digite a opção desejada: ");

            int opcao = scanner.nextInt();

            if (opcao == 1) {
                cadastroCliente(clientes, contas, enderecos, scanner);
            } else if (opcao == 0) {
                System.out.print("Você saiu do programa!");
                break;
            } else if (opcao == 2) {

            }
        }
    }

    public static void cadastroCliente( List<Client> clientes, List<Conta> contas, List<Endereco> enderecos, Scanner scanner) {
        System.out.println("Cadastrar cliente:");
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o cpf do cliente: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite a data de nascimento do cliente (no formato AAAA/MM/DD): ");
        LocalDate dataNascimento = LocalDate.parse(scanner.nextLine());
        System.out.print("Digite a rua: ");
        String rua = scanner.nextLine();
        System.out.print("Digite o bairro: ");
        String bairro = scanner.nextLine();
        System.out.print("Digite seu cep: ");
        String cep = scanner.nextLine();
        System.out.print("Digite seu numero: ");
        int numero = scanner.nextInt();

        Endereco endereco = new Endereco(rua, cep, numero, bairro);
        enderecos.add(endereco);
        
        Client cliente = new Client (nome, cpf, dataNascimento, endereco);
        clientes.add(cliente);

        System.out.println("Cliente cadastrado com sucesso.");

        
        // System.out.println("\n Cadastro de conta:");
        // System.out.print("Digite o número da agência:");
        // int numeroAgencia = scanner.nextInt();
        // scanner.nextLine();

        // Conta conta = new Conta(cliente, numeroAgencia, 1, 0.0);

        // clientes.add(cliente);
        // System.out.println("Conta e cliente cadastrados com sucesso!");
        // contas.add(conta);
        // System.out.println("Dados de cadastro:");
        // System.out.println("Nome: " + cliente.getNome());
        // System.out.println("Cpf: " + cliente.getCpf());
        // System.out.println("Data de nascimento: " + cliente.getDn());
        // // System.out.println("Rua: " + cliente.getRua());
        // // System.out.println("Cep: " + cliente.getBairro());
        // // System.out.println("Numero da residência: " + cliente.getNumero());
        // // System.out.println("Bairro: " + cliente.getCep());
        // System.out.println("Agência; " + conta.getnumeroAgencia());
        // System.out.println("Conta: " + conta.getnumeroConta());
        // System.out.println("Saldo: " + conta.getSaldo());
    }

    public static void criarConta(List<Conta> conta, List<Client> clientes, Scanner scanner){
        System.out.print("Digite o número da sua agência: ");
    }
}
    