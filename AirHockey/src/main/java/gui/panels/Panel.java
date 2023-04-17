package gui.panels;

import event.IEvent;
import event.IEventHandler;

import javax.swing.*;

public class Panel extends JPanel {
    private final IEventHandler eventHandler;

    public Panel(IEventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    protected void dispatchGameEvent(IEvent event) {
        eventHandler.handle(event);
    }
}
