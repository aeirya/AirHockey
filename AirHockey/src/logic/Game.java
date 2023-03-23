package logic;

import event.DummyEventHandler;
import event.IEvent;
import event.IEventHandler;
import game.IGame;
import gui.Window;
import gui.config.GuiConfig;
import model.Player;
import model.airhockey.Table;


public class Game implements IGame {
    private GameState state;
    private Table table;
    private int time;
    private Player player1;
    private Player player2;

    private IEventHandler eventHandler;
    private Window window;

    public Game() {
        table = new Table(
                GuiConfig.getWindowDimension(),
                GuiConfig.getWindowCenter());
        state = new GameState();
        time = 0;
        player1 = new Player();
        player2 = new Player();

        eventHandler = new DummyEventHandler();
        window = new Window(this);
        window.loop();
        loop();
    }

    public GameState exportState() {
        state = table.exportState(state);
        state.setTime(time);
        state.setPlayer1(player1);
        state.setPlayer2(player2);
        return state;
    }

    @Override
    public void handle(IEvent event) {
        eventHandler.handle(event);
    }

    public void loop() {
        new GameLoopThread(table).start();
    }
}
