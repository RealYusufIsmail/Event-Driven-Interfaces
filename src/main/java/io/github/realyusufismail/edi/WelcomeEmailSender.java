package io.github.realyusufismail.edi;

import io.github.realyusufismail.edi.event.EmailSubscribeEvent;
import io.github.realyusufismail.edi.handler.EmailSubscribeEventHandler;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class WelcomeEmailSender implements EmailSubscribeEventHandler {
    private final List<String> subscribedEmails = new ArrayList<>();

    @Override
    public void onEmailSubscribeEvent(EmailSubscribeEvent event) {
        System.out.println("Received the email " + event.email() + ". Will now be added to email subscriber list");
        subscribedEmails.add(event.email());
    }
}
