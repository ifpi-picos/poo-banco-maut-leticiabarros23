package br.edu.ifpi.poo.notificacao;

public class NotificacaoEmail implements Notificacao{
    @Override
    public void enviarNotificacao(String tipo) {
        
        System.out.println("Enviando notificação por email " );
        System.out.println("Tipo:" + tipo);
    }
   
} 
