package depeng;

import org.junit.Test;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSenderTest {
    @Test
    public void testDefaultRemoveLogLastProcessTime() throws Exception {

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(".com", ".n");
                    }
                }
        );

        Message message = new MimeMessage(session);
        InternetAddress from = new InternetAddress("@gmail.com", "");
        message.setFrom(from);
        //TO
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("@gmail.com,@.com"));
        //BCC
        //message.addRecipient(Message.RecipientType.BCC, new InternetAddress(settingService.getValue("tracker_email")));

        //Subject
        message.setSubject("Hello javax mail");
        message.setContent("Hello javax 邮件", "text/html; charset=utf-8" );

        Transport.send(message, message.getAllRecipients());

    }

}
