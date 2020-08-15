package com.customer.comman;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;

import java.util.Properties;

@Component
public class EmailUtil {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);

    private String emailId = "info@playersvictory.com";

    private String password = "pv@victory";

    public void sendingEmailProcess(String toEmail, String ccEmail, String emailSubject, String emailBody) throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "mail.playersvictory.com");
        props.put("mail.smtp.debug", "true");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailId, password);
            }
        });

        session.setDebug(true);
        Multipart multipart = new MimeMultipart();
        Message mes = new MimeMessage(session);
        mes.setFrom(new InternetAddress(emailId));
        mes.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
        mes.setRecipients(RecipientType.CC, InternetAddress.parse(ccEmail));
        mes.setSubject(emailSubject);

        mes.setContent(emailBody, "text/html; charset=utf-8");

        String filename = "";
        MimeBodyPart messageBodyPart = new MimeBodyPart();


        if (!filename.equals("")) {
            messageBodyPart = new MimeBodyPart();
            String fileName = "attachmentName";
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(fileName);
            multipart.addBodyPart(messageBodyPart);
            mes.setContent(multipart);
        }

        LOGGER.info("Sending");

        Transport.send(mes);

        LOGGER.info("mail has been sent");
    }
}
