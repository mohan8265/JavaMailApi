package org.geekster;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailSender {
    void sendMail(){

        Properties properties = System.getProperties();

        System.out.println(properties);

        properties.put("mail.smtp.host",MailMetadata.hostServer);
        properties.put("mail.smtp.port",MailMetadata.emailPort);
        properties.put(MailMetadata.sslProperty,"true");
        properties.put(MailMetadata.authPermission,"true");

        Authenticator authenticator = new MailAuthentication();
        Session session = Session.getInstance(properties,authenticator);

        MimeMessage mailMessage = new MimeMessage(session);

        try {
            mailMessage.setFrom(MailMetadata.myMail);
            mailMessage.setSubject("For testing purpose");
            mailMessage.setText("Hello This is Mohan, checking API of email sending");

            Address receiverEmail = new InternetAddress(MailMetadata.receiverEmail);
            mailMessage.setRecipient(Message.RecipientType.TO, receiverEmail);

            Transport.send(mailMessage);
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
