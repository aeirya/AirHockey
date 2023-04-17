package gui;

import event.IEventHandler;
import event.MenuType;
import game.IGame;
import gui.panels.GamePanel;
import gui.panels.StartPanel;

import javax.swing.*;

public class MenuManager {
    private IGame api;

    public MenuManager(IGame api) {
        this.api = api;
    }

    public JPanel make(MenuType menu, IEventHandler e) {
        switch (menu) {
            case START_MENU:
                return new StartPanel(api);
            case NEW_GAME_OPTIONS:
                return null;
            case GAME_TABLE:
                GamePanel game = new GamePanel(e);
                game.update(api.exportState());
                return game;
        }
        return null;
    }
}
