package logic;

import event.DummyEventHandler;
import event.IEvent;
import event.IEventHandler;
import game.IGame;
import gui.Window;
import gui.config.GuiConfig;
import model.Player;
import model.Vector;
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
        player1 = new Player(0);
        player2 = new Player(1);
        player1.setPosition(new Vector(300, 300));
        player2.setPosition(new Vector(900, 300));

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
