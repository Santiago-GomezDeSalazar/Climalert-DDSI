package ar.edu.utn.ba.ddsi.climalert.serviciosExternos.sendGrid.impl;

import ar.edu.utn.ba.ddsi.climalert.config.SendGridProperties;
import ar.edu.utn.ba.ddsi.climalert.serviciosExternos.sendGrid.IServicioMensajeriaMailAdapter;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class SendGridAdapter implements IServicioMensajeriaMailAdapter {

  private final SendGridProperties properties;

  @Override
  public void sendEmail(String destinatario, String asunto, String mensaje) {
    try {
      Email from = new Email(properties.getFromEmail());
      Email toEmail = new Email(destinatario);
      Content content = new Content("text/plain", mensaje);
      Mail mail = new Mail(from, asunto, toEmail, content);

      SendGrid sg = new SendGrid(properties.getApiKey());

      Request request = new Request();
      request.setMethod(Method.POST);
      request.setEndpoint("mail/send");
      request.setBody(mail.build());

      sg.api(request);

    } catch (IOException e) {
      throw new RuntimeException("Error al enviar email", e);
    }
  }
}