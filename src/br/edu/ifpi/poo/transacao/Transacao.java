package br.edu.ifpi.poo.transacao;
// Usado para permitir o uso de datas
import java.time.LocalDate;
import java.util.Date;

    // Declaração dos atributos da classe transação
    public class Transacao {
    private Date data;
    private double valor;
    private String tipo;

    // Construtor da classe transação que recebe as informações iniciais da transação
    public Transacao(double valor, String tipo){
    this.data = new Date();
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

    public Date getData() {
        return data;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

}
