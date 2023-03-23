package game;

import event.IEventHandler;
import logic.GameState;

public interface IGame extends IEventHandler {
    GameState exportState();
}
