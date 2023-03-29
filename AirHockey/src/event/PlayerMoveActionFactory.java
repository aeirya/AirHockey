package event;

import gui.event.PlayerMoveAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlayerMoveActionFactory {
    public PlayerMoveAction build(Map<Character, Boolean> keyPressed, int playerID) {
        List<Character> playerKeys = getKeys(playerID);
        int dx = 0;
        int dy = 0;
        boolean isHaste = false;

        for (Character key: playerKeys) {
            if (keyPressed.getOrDefault(key, false)) {
                if (Character.isUpperCase(key)) {
                    isHaste = true;
                } else {
                    key = Character.toUpperCase(key);
                }
                dx += getDX(key);
                dy += getDY(key);

            }
        }
        return new PlayerMoveAction(playerID, dx, dy, isHaste);
    }

//    private int charToDelta(char key) {
//        switch (key) {
//            case GameKeys.P1_MOVE_DOWN:
//            case GameKeys.P1_MOVE_RIGHT:
//            case GameKeys.P2_MOVE_DOWN:
//            case GameKeys.P2_MOVE_RIGHT:
//                return 1;
//            case GameKeys.P1_MOVE_UP:
//            case GameKeys.P1_MOVE_LEFT:
//            case GameKeys.P2_MOVE_UP:
//            case GameKeys.P2_MOVE_LEFT:
//                return -1;
//        }
//        return 0;
//    }

    private List<Character> getKeys(int player) {
        if (player == 0) return GameKeys.player1Keys;
        if (player == 1) return GameKeys.player2Keys;
        return new ArrayList<>();
    }

    private int getDX(char key) {
        switch (key) {
            case GameKeys.P1_MOVE_LEFT:
            case GameKeys.P2_MOVE_LEFT:
                return -1;
            case GameKeys.P1_MOVE_RIGHT:
            case GameKeys.P2_MOVE_RIGHT:
                return 1;
        }
        return 0;
    }

    private int getDY(char key) {
        switch (key) {
            case GameKeys.P1_MOVE_DOWN:
            case GameKeys.P2_MOVE_DOWN:
                return 1;
            case GameKeys.P1_MOVE_UP:
            case GameKeys.P2_MOVE_UP:
                return -1;
        }
        return 0;
    }

//    private int getPlayerID(char key) {
//        switch (key) {
//            case 'W':
//            case 'A':
//            case 'S':
//            case 'D':
//                return 0;
//            case 'I':
//            case 'J':
//            case 'K':
//            case 'L':
//                return 1;
//        }
//        return -1;
//    }
}
