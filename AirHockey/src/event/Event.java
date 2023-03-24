package event;

public class Event implements IEvent {

    @Override
    public void visit(IEventHandler handler) {

    }

    enum Type {
        GUI, GAME
    }
}
