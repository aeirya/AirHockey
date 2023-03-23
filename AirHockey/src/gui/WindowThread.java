package gui;

import java.util.concurrent.TimeUnit;

public class WindowThread extends Thread {
    private final Window window;
    private final int drawInterval;

    public WindowThread(Window window, int fps) {
        this.window = window;
        this.drawInterval = 1000/fps;
    }

    @Override
    public void run() {
//        loopThread(window::pushKeyboardEvents, 1);
        loopThread(this::redraw, drawInterval);
    }

    private void loopThread(Runnable runnable, int intervalMs) {
        while (true) {
            runnable.run();
            try {
                sleep(drawInterval);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    private void redraw() {
        window.invalidate();
        window.validate();
        window.repaint();
    }

    private void sleep(int ms) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(ms);
    }
}
