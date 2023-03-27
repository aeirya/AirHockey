package logic;

import game.GameParameters;
import model.airhockey.Table;
import util.LoopThread;

public class GameLoopThread extends LoopThread {
    private final Table table;
    private long lastTime;
    private final double gameSpeed = GameParameters.gameSpeed;

    // TODO: replace this dependency injection
    public GameLoopThread(Table table) {
        super(1000/GameParameters.FPS/2);
        this.table = table;
        lastTime = -1;
    }

    // NOTE: I feel a lot of spaghetti code here
    @Override
    protected void runOnce() {
        double dt = (double)getDeltaTime()/1000;
        dt = dt * gameSpeed;
        table.checkCollisions();
        table.passTime(dt);
    }

    private int getDeltaTime() {
        if (lastTime < 0) {
            lastTime = getTime();
            return 0;
        }
        long time = getTime();
        long dt = time - lastTime;
        lastTime = time;
        return (int) dt;
    }

    private long getTime() {
        return System.currentTimeMillis();
    }

}
