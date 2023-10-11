// Usado para permitir o uso de datas
import java.time.LocalDate;

    // Declaração dos atributos da classe transação
    public class Transaçao {
    LocalDate data;
    double valor;
    String tipo;

    // Construtor da classe transação que recebe as informações iniciais da transação
    public Transaçao( LocalDate data, double valor, String tipo){
    this.data = data;
    this.valor = valor;
    this.tipo = tipo;
    }

    @Override
    public String toString(){
    return "Transaçao{" +
    "data=" + data + 
    ", valor=" + valor +
    ", tipo='" + tipo + '\'' +
    '}';
    }
}
