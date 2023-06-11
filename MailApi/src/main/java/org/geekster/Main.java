package org.geekster;

public class Main {
    public static void main(String[] args) {

        System.out.println("Started!!!");

        MailSender mailSender = new MailSender();
        mailSender.sendMail();
    }
}