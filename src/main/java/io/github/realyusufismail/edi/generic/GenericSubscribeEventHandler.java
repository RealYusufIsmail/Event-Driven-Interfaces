package io.github.realyusufismail.edi.generic;

/**
 * Defines a contract for the handler of generic subscription events.
 *
 * <p>
 * An implementer of this interface acts as the receiver for an event-based subscription mechanism. A class
 * implementing this interface should define how it handles the occurrence of a subscription event in an
 * Event-Driven Architecture system.
 * </p>
 *
 * <p>
 * When a generic subscription event takes place, the handler provided by the implementing object
 * is triggered according to the specifications laid out by the implementer.
 * </p>
 *
 * <p>
 * This is particularly useful in scenarios where the specifics of the subscription event don't affect
 * how the system should react, and allows the system's behavior to be adjusted dynamically at runtime
 * via different implementations of this interface.
 * </p>
 *
 */
@FunctionalInterface
public interface GenericSubscribeEventHandler {
    void onGenericEvent(GenericSubscribeEvent event);
}