package ar.edu.utn.ba.ddsi.climalert.serviciosExternos.sendGrid;

public interface IServicioMensajeriaMailAdapter {
  void sendEmail(String destinatario, String asunto, String mensaje);
}
