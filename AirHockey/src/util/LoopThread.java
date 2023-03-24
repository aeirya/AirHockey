package util;

import java.util.concurrent.TimeUnit;

public abstract class LoopThread extends Thread {
    /** sleep time in ms */
    private final int interval;

    public LoopThread(int interval) {
        this.interval = interval;
    }

    /** the thing to run in each loop */
    protected abstract void runOnce();

    @Override
    public void run() {
        while (true) {
            runOnce();
            try {
                sleep(interval);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    private void sleep(int ms) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(ms);
    }
}
