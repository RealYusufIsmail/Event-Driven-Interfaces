package io.github.realyusufismail.edi.generic;

/**
 * A representation of a generic subscription event in an Event-Driven Architecture system.
 *
 * <p>
 * An object of a type implementing this interface serves as the catalyst for a series of actions or
 * updates the state in an Event-Driven Architecture system upon a subscription event. The specifics
 * of which actions should be taken or how the system state should be updated are determined by the
 * associated {@code GenericSubscribeEventHandler}.
 * </p>
 *
 * <p>
 * This is particularly useful in scenarios where the specifics of the subscription event don't
 * affect the event's effect in the system - instead, all subscription events can be treated in
 * the same manner.
 * </p>
 *
 */
public interface GenericSubscribeEvent {
}