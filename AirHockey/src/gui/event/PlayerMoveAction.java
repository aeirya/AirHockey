package gui.event;

import event.IEvent;
import event.IEventHandler;

public class PlayerMoveAction implements IEvent {
    int playerID;
    int dx;
    int dy;

    public PlayerMoveAction(int playerID, int dx, int dy) {
        this.playerID = playerID;
        this.dx = dx;
        this.dy = dy;
    }

    public boolean isNonzero() {
        return dx != 0 || dy != 0;
    }

    @Override
    public void visit(IEventHandler handler) {
        
    }

    @Override
    public String toString() {
        return "PlayerMoveAction{" +
                "playerID=" + playerID +
                ", dx=" + dx +
                ", dy=" + dy +
                '}';
    }
}

