package wethack.events;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class EventBus {

    private final Map<Class<?>, List<RegisteredListener>> listeners = new ConcurrentHashMap<>();

    public void register(Object listener) {
        for (Method method : listener.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(EventHandler.class)) {
                Class<?>[] params = method.getParameterTypes();
                if (params.length == 1 && Event.class.isAssignableFrom(params[0])) {
                    method.setAccessible(true);
                    listeners
                            .computeIfAbsent(params[0], k -> new ArrayList<>())
                            .add(new RegisteredListener(listener, method));
                }
            }
        }
    }

    public void unregister(Object listener) {
        for (List<RegisteredListener> list : listeners.values()) {
            list.removeIf(registered -> registered.listener.equals(listener));
        }
    }

    public void post(Event event) {
        List<RegisteredListener> eventListeners = listeners.get(event.getClass());
        if (eventListeners != null) {
            for (RegisteredListener registered : eventListeners) {
                try {
                    registered.method.invoke(registered.listener, event);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class RegisteredListener {
        private final Object listener;
        private final Method method;

        public RegisteredListener(Object listener, Method method) {
            this.listener = listener;
            this.method = method;
        }
    }
}
