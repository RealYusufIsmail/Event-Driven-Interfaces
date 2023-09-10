package io.github.realyusufismail.edi.event;

import io.github.realyusufismail.edi.generic.GenericSubscribeEvent;

/**
 * Represents an Email subscription event in an Event-Driven Architecture (EDA).
 * This class is a record of an email subscription event.
 *
 * <p>
 * In an Event-Driven Architecture, this event can be utilized to trigger various systems or
 * components in our application that keep an eye on email subscription events. For example, a
 * component may handle this event by adding a new subscriber to a mailing list or sending a
 * notification email.
 * </p>
 *
 * <p>
 * The ‹{@code EmailSubscribeEvent}› simply captures the essential data for handling a subscription event,
 * which in this case is the subscriber's email.
 * </p>
 *
 * <p>
 * In a typical application flow, an instance of ‹{@code EmailSubscribeEvent}› would be published
 * after a user subscribes to email notifications. The event would then be consumed by the necessary
 * event handlers set to listen to the email subscription events.
 * </p>
 *
 * <p>
 * {@code EmailSubscribeEvent} is an Immutable object that holds email as an event data.
 * </p>
 *
 * @param email the email of the user subscribing
 *
 */
public record EmailSubscribeEvent(String email) implements GenericSubscribeEvent { }
