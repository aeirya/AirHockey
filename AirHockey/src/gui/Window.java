package gui;

import event.IEventHandler;
import event.MenuType;
import game.GameParameters;
import game.IGame;
import gui.config.GuiConfig;
import util.LoopThread;

import javax.swing.*;

public class Window extends JFrame {
    private final IEventHandler eventHandler;
    private final IGame game;
    private final KeyInput input;
    private final MenuManager menuManager;

    public Window(IGame game) {
        this.eventHandler = game;
        this.game = game;
        input = new KeyInput(game);
        menuManager = new MenuManager(game);

        setTitle("Air Hockey");
        setResizable(false);
        setSize(GuiConfig.getWindowWidth(), GuiConfig.getWindowHeight());

        setMenu(MenuType.GAME_TABLE);

        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void setMenu(MenuType menu) {
        JPanel panel = menuManager.make(menu, game);
        setContentPane(panel);
        if (menu == MenuType.GAME_TABLE) {
            this.addKeyListener(input);
        } else {
            this.removeKeyListener(input);
        }
    }

    public void pushKeyboardEvents() {
        input.pushKeyboardEvents();
    }

    public void loop() {
        new WindowThread(this, GameParameters.FPS).start();
        new LoopThread(2){
            @Override
            protected void runOnce() {
                input.pushKeyboardEvents();
            }
        }.start();
    }
}
