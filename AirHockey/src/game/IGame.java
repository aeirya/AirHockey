package game;

import event.IEventHandler;
import gui.event.PlayerMoveAction;
import logic.GameState;
import model.PlayerID;

public interface IGame extends IEventHandler {
    GameState exportState();
    void startNewGame();
    void pause();
    void resume();
    void movePlayer(PlayerMoveAction action);
    void goal(PlayerID goalID);
}
