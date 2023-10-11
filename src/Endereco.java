// Declaração dos atributos da classe Endereço
public class Endereco {
    private String rua;
    private String cep;
    private int numero;
    private String bairro;

    // Construtor da classe endereço que obtém as informações iniciais do endereço
    public Endereco( String rua, String cep, int numero, String bairro) { 
        this.rua = rua;
        this.cep = cep;
        this.numero = numero;
        this.bairro = bairro;
    }

    // Método para obter a rua do cliente
    public String getRua(){
    return rua;
    }

    // Método para obter o cep do cliente
    public String getCep(){
    return cep;
    }

    //Método para obter o número
    public int getNumero(){
    return numero;
    }

    // Método para obter o bairro do cliente
    public String getBairro(){
    return bairro;
    }
}
