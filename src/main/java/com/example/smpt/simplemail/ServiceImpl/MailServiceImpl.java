package com.example.smpt.simplemail.ServiceImpl;

import com.example.smpt.simplemail.Service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Override
    public String sendNormalMail(String sender, String sendto, String msgToBeSent) {
//        SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setTo(sendto);
//
//        msg.setSubject("I forgot to take subject as a parameter");
//        msg.setText(msgToBeSent);
//        javaMailSender.send(msg);

        final String username = "soumikpaulonly@gmail.com";
        final String password = "mijwpeczyrpcefet\n";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("soumikpaulonly@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(sendto)
            );
            message.setSubject("Testing Gmail TLS");
            message.setText(msgToBeSent);

            Transport.send(message);

            System.out.println("Done");

        } catch ( MessagingException e) {
            e.printStackTrace();
        }

        return "Mail Sent";
    }
}
