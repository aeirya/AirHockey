package event;

public class MenuEvent extends  Event {

    public void visit(IEventHandler eventHandler) {
        ((MenuEventHandler) eventHandler).handle(this);
    }

    enum Type {

    }
}
