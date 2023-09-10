package io.github.realyusufismail.edi;

import io.github.realyusufismail.edi.generic.GenericSubscribeEvent;
import io.github.realyusufismail.edi.generic.GenericSubscribeEventHandler;
import lombok.SneakyThrows;
import lombok.val;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * The {@code EventDispatcher} class serves as the pivotal point in an Event-Driven Architecture. It holds the
 * responsibility of delegating events to their suitable event handlers.
 *
 * <p>
 * Internally, it sustains a mapping of event types to their respective event handlers. This mapping ensures
 * that events are directed to the correct handlers efficiently. Such an approach supports the decentralization
 * and loose coupling of components, which are crucial elements of an Event-Driven Architecture.
 * </p>
 *
 * <p>
 * Event handlers for specific types of events can be registered using the {@code registerEventHandler} method.
 * This allows dynamic addition of event responses within the system. It is this function that ties an event
 * type to a specific sequence of operations encapsulated in an event handler.
 * </p>
 *
 * <p>
 * Dispatching of an event is executed via the {@code dispatchEvent} method. This method is responsible for
 * identifying the correct event handler(s) based on the event type. Upon finding the relevant handlers, it
 * invokes their associated handling method(s).
 * </p>
 *
 * Note: The handling method to be invoked is assumed to be {@code onOrderPlaced}. Developers may want to
 * adjust this based on their particular system's necessities.
 *
 * @see GenericSubscribeEvent
 * @see GenericSubscribeEventHandler
 */
public class EventDispatcher {
    private final Map<Class<? extends GenericSubscribeEvent>, List<GenericSubscribeEventHandler>> eventHandlers = new HashMap<>();

    /**
     * Registers an event handler to an event type.
     * <p>
     * This method is used to attach an instance of a {@link GenericSubscribeEventHandler}
     * to handle a specific type of {@link GenericSubscribeEvent}
     *
     * @param eventType     the class of the event
     * @param eventHandler  the handler for the event
     */
    public void registerEventHandler(Class<? extends GenericSubscribeEvent> eventType, GenericSubscribeEventHandler eventHandler) {
        eventHandlers.computeIfAbsent(eventType, k -> new ArrayList<>()).add(eventHandler);
    }

    /**
     * Dispatches the event to all registered handlers.
     * <p>
     * This method is used to give the passed event to all registered handlers for that type
     * of event.
     *
     * @param event the event to be dispatched
     */
    public void dispatchEvent(GenericSubscribeEvent event) {
        val handlers = eventHandlers.getOrDefault(event.getClass(), Collections.emptyList());
        handlers.forEach(handler -> invokeEventHandler(handler, event));
    }

    /**
     * Invokes an event handler to process the event.
     * <p>
     * This method will call the `onGenericEvent` method on the handler and pass the specific event to it.
     *
     * @param handler the handler to invoke
     * @param event   the event that the handler will process
     */
    private void invokeEventHandler(GenericSubscribeEventHandler handler, GenericSubscribeEvent event) {
        try {
            handler.onGenericEvent(event);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new IllegalArgumentException("Error while trying to invoke the event handle method in: " + handler.getClass().getName() +
                    " to process event type: " + event.getClass().getName(), e);
        }
    }
}