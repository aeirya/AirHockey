package logic;

import event.EventHandler;
import event.IEvent;
import event.IEventHandler;
import event.IGameEventHandler;
import game.IGame;
import gui.config.GuiConfig;
import gui.event.PlayerMoveAction;
import model.*;
import model.airhockey.Table;
import model.powerup.ActivePowerup;
import model.powerup.impl.FastBallPowerUp;
import model.powerup.PowerUp;


public class Game implements IGame, IGameEventHandler {
    private GameState state;
    private Table table;
    private int time;
    private Player player1;
    private Player player2;
    private PowerUp powerup;
    private ActivePowerup activePowerup;
    private GameLoopThread gameLoop;
    private IEventHandler eventHandler;

    public Game() {
        player1 = new Player(0);
        player2 = new Player(1);
        player2.getMallet().setPosition(new Vector(900, 300));
        player1.getMallet().setPosition(new Vector(300, 300));

        powerup = new FastBallPowerUp(GuiConfig.getWindowCenter().add(300, 0), this);
        table = new Table(
                GuiConfig.getTableDimension(),
                GuiConfig.getWindowCenter(),
                player1.getMallet(),
                player2.getMallet(),
                powerup,
                this);
        state = new GameState();
        time = 0;

//        powerup = null;
        activePowerup = new ActivePowerup();
        eventHandler = new EventHandler();
    }

    public GameState exportState() {
        state = table.exportState(state);
        state.setTime(time);
        state.setPlayer1(player1);
        state.setPlayer2(player2);
        state.setPowerup(powerup);
        return state;
    }

    @Override
    public void startNewGame() {
        if (gameLoop != null && gameLoop.isAlive())
            gameLoop.interrupt();

        //todo
        loop();
    }

    @Override
    public void pause() {
        gameLoop.interrupt();
    }

    @Override
    public void resume() {
        loop();
    }

    @Override
    public void movePlayer(PlayerMoveAction action) {
        Player player = action.playerID == 0 ? player1 : player2;
        if (action.isZero()) {
            player.halt();
        } else {
            player.getMallet().movePlayer(action);
        }
    }

    @Override
    public void goal(PlayerID goalID) {
        if (goalID == PlayerID.ONE) {
            player2.increaseScore();
        }
        if (goalID == PlayerID.TWO) {
            player1.increaseScore();
        }
    }

    @Override
    public void handle(IEvent event) {
//        eventHandler.handle(event);
        event.visit(this);
    }

    public void loop() {
        gameLoop = new GameLoopThread(table);
        gameLoop.start();
    }

    @Override
    public void activatePowerup() {
        activePowerup.set(powerup);
    }
}
