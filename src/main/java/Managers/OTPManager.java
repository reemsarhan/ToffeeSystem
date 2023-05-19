package Managers;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Objects;
import java.util.Properties;
import java.util.Random;

public class OTPManager {
    public static String otpGenerator() {
        Random random = new Random();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }


    public static boolean sendOTP(String currUser, String email, String otp) {
        boolean success = false;
        final String username = "toffeeassignex1";
        final String password = "tecxqzssauonedzq";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("toffeeassignex1@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Welcome to Toffee Store! Confirm Your Account with OTP");
            String msg = "Dear " + currUser + ",\n\n"
                    + "Please use the following OTP to verify your account: " + otp;
            message.setText(msg);

            Transport.send(message);
            success = true;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return success;
    }

    public static boolean verifyOTP(String otp, String systemOTP) {
        return Objects.equals(otp, systemOTP);
    }
}
