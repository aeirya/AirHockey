package event;

import java.util.HashMap;

public class EventHandler implements IEventHandler {
//    private HashMap<GameEventType, IEvent> map;

    public void handle(IEvent event) {
        event.visit(this);
    }
}
