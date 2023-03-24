package gui.event;

import event.IEvent;
import event.IEventHandler;
import game.IGame;

public class PlayerMoveAction implements IEvent {
    public final int playerID;
    public final int dx;
    public final int dy;

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
        ((IGame) handler).movePlayer(this);
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

