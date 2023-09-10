package io.github.realyusufismail.edi;

import io.github.realyusufismail.edi.event.EmailSubscribeEvent;
import lombok.val;

public class Main {
    public static void main(String[] args) {
        System.out.println("All systems go with the Event driven Application");

        val eventDispatcher = new EventDispatcher();

        // Register event handlers.
        eventDispatcher.registerEventHandler(EmailSubscribeEvent.class, new WelcomeEmailSender());

        // Stimulate the event being sent.
        val mockEmailSubscribeEvent = new EmailSubscribeEvent("test@gmail.com");
        eventDispatcher.dispatchEvent(mockEmailSubscribeEvent);
    }
}
