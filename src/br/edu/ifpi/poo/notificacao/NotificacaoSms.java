package br.edu.ifpi.poo.notificacao;

public class NotificacaoSms implements Notificacao {
    @Override
    public void enviarNotificacao(String tipo) {
        
        System.out.println("enviando notificacão por SMS ");
        System.out.println("Tipo:" + tipo);
    }

}