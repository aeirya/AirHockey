package logic;

import event.DummyEventHandler;
import event.EventHandler;
import event.IEvent;
import event.IEventHandler;
import game.IGame;
import gui.Window;
import gui.config.GuiConfig;
import gui.event.PlayerMoveAction;
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
        player1 = new Player(0);
        player2 = new Player(1);
        player2.getMallet().setPosition(new Vector(900, 300));
        player1.getMallet().setPosition(new Vector(300, 300));

        table = new Table(
                GuiConfig.getWindowDimension(),
                GuiConfig.getWindowCenter(),
                player1.getMallet(),
                player2.getMallet());
        state = new GameState();
        time = 0;


        eventHandler = new EventHandler();
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
    public void movePlayer(PlayerMoveAction action) {
        Player player = player2;
        if (action.playerID == 0) player = player1;
        player.getMallet().move(action.dx * 1, action.dy * 1);
    }

    @Override
    public void handle(IEvent event) {
//        eventHandler.handle(event);
        event.visit(this);
    }

    public void loop() {
        new GameLoopThread(table).start();
    }
}
