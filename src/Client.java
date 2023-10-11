// Usado para permitir o uso de datas 
import java.time.LocalDate;

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

    // Método para obter o CPF do cliente
    public String getCpf(){
        return cpf;
    }

    // Método para obter a data de nascimento do cliente
    public LocalDate getDn(){
        return Dn;
    }

    public Endereco getEndereco(){
        return endereco;
    }
}
