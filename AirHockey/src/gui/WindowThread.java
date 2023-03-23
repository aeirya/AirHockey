package gui;

import util.LoopThread;

public class WindowThread extends LoopThread {
    private final Window window;

    public WindowThread(Window window, int fps) {
        super(1000/fps);
        this.window = window;
    }

    @Override
    protected void runOnce() {
        redraw();
    }

    private void redraw() {
        window.invalidate();
        window.validate();
        window.repaint();
        System.out.println("repaint");
    }
}
