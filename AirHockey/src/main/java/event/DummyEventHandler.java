package event;

public class DummyEventHandler implements IEventHandler {
    @Override
    public void handle(IEvent event) {
        System.out.println("handling sample event: " + event.toString());
    }
}
