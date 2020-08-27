package com.example.smpt.simplemail.controller;


import com.example.smpt.simplemail.Service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MailController {

    @Autowired
    private MailService mailService;

    @RequestMapping(value = "/mail",params = {"sender","sendto","msg"},method = RequestMethod.GET)
    public String sendMail(@RequestParam("sender") String sender,
                           @RequestParam("sendto") String sendto,
                           @RequestParam("msg") String msg){
        return mailService.sendNormalMail(sender,sendto,msg);
    }
}
