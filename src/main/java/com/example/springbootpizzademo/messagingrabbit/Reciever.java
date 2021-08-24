package com.example.springbootpizzademo.messagingrabbit;

import org.springframework.stereotype.Component;

@Component
public class Reciever {

    public void recieveMessage(String message){
        System.out.println("Recieved order [" +message+"] ");
    }
}
