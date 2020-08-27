package com.example.smpt.simplemail.Service;

import org.springframework.stereotype.Service;

@Service
public interface MailService {
    String sendNormalMail(String sender, String sendto, String msg);
}
