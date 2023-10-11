// Declaração dos atributos da classe Conta 
public class Conta {
   private Client cliente;
   private int numeroAgencia;
   private int numeroConta = 1;
   private String number;
   private double saldo;

   // Construtor da classe conta que obtém as primeiras informações da conta
    public Conta(Client cliente, int numeroAgencia) {
        this.cliente = cliente;
        this.numeroAgencia = numeroAgencia;
        this.number = getNumber();
        this.saldo = 0.0;
    }

    public String getNumber(){
        return String.format("%04d", numeroConta++);
    }

    // Método para obter o número da agência 
    public int getnumeroAgencia(){
        return numeroAgencia;
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

    // Método para obter o número da conta
    public int getnumeroConta(){
        return numeroConta;
    }
 
    // Método para depositar na conta, aumentando o saldo
    public void depositar(double valor) {
        this.saldo += valor;
    }

    // Método para reallizar saque na conta, podendo diminuir o valor se tiver dinheiro suficiente 
    public boolean saque(double valor){
        if(this.saldo >= valor){
            this.saldo -= valor;
            return true;
        }else{
            return false;
        }
    }
}
