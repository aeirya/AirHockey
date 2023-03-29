package gui.event;

import event.IEvent;
import event.IEventHandler;
import game.IGame;
import model.Vector;

public class PlayerMoveAction implements IEvent {
    public final int playerID;
    public final int dx;
    public final int dy;
    public final boolean isHaste;

    public PlayerMoveAction(int playerID, int dx, int dy, boolean isHaste) {
        this.playerID = playerID;
        this.dx = dx;
        this.dy = dy;
        this.isHaste = isHaste;
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

    public Vector getVector() {
        int m = 1;
        if (isHaste) m = 2;
        return new Vector(m*dx, m*dy);
    }
}

