package io.github.realyusufismail.edi.handler;

import io.github.realyusufismail.edi.event.EmailSubscribeEvent;
import io.github.realyusufismail.edi.generic.GenericSubscribeEvent;
import io.github.realyusufismail.edi.generic.GenericSubscribeEventHandler;

/**
 * A handler interface for {@code EmailSubscribeEvent} objects.
 *
 * <p>
 * This interface defines the contract for any class that wishes to handle {@code EmailSubscribeEvent}s
 * as part of an Event-Driven Architecture. When an {@code EmailSubscribeEvent} occurs, the
 * ‹{@code onEmailSubscribeEvent}› method will be invoked with the event object.
 * </p>
 *
 * <p>
 * Implementing classes may for instance, send a welcome email to the new subscriber, add the subscriber
 * to a mailing list, or perform any relevant tasks related to a new email subscription.
 * </p>
 *
 * <p>
 * Here's an example of how you might use it:
 * </p>
 *
 * <pre><code>
 * public class WelcomeEmailSender implements EmailSubscribeEventHandler {
 *     &#64;Override
 *     public void onEmailSubscribeEvent(EmailSubscribeEvent event) {
 *         // Sends a welcome email to the new subscriber.
 *         sendWelcomeEmail(event.email());
 *     }
 * }
 * </code></pre>
 *
 * @see EmailSubscribeEvent
 */
public interface EmailSubscribeEventHandler extends GenericSubscribeEventHandler {
    /**
     * Invoked when an {@code EmailSubscribeEvent} occurs.
     *
     * @param event the {@code EmailSubscribeEvent} object containing the event details.
     */
    void onEmailSubscribeEvent(EmailSubscribeEvent event);

    @Override
    default void onGenericEvent(GenericSubscribeEvent event) {
        if (event instanceof EmailSubscribeEvent) {
            onEmailSubscribeEvent((EmailSubscribeEvent) event);
        }
    }
}