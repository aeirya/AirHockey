package event;

@FunctionalInterface
public interface IEvent {
    void visit(IEventHandler handler);
}
