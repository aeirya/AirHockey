package gui;

import event.IEventHandler;
import event.PlayerMoveActionFactory;
import gui.event.PlayerMoveAction;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class KeyInput extends KeyAdapter {
    private final Map<Character, Boolean> pressedKeys;
    private final IEventHandler eventHandler;
    private final PlayerMoveActionFactory moveFactory;

    public KeyInput(IEventHandler eventHandler) {
        this.eventHandler = eventHandler;
        pressedKeys = new HashMap<>();
        moveFactory = new PlayerMoveActionFactory();
    }

    private char getKey(KeyEvent e) {
        return Character.toUpperCase(e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        pressedKeys.put(getKey(e), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressedKeys.put(getKey(e), false);
    }

    public void pushKeyboardEvents() {
        pushPlayerEvent(0);
        pushPlayerEvent(1);
    }

    private void pushPlayerEvent(int playerID) {
        PlayerMoveAction action = moveFactory.build(pressedKeys, playerID);
        eventHandler.handle(action);
    }
}
