package event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameKeys {
    private GameKeys() {}

    public static final char P1_MOVE_DOWN = 'S';
    public static final char P1_MOVE_RIGHT = 'D';
    public static final char P1_MOVE_LEFT = 'A';
    public static final char P1_MOVE_UP = 'W';

    public static final char P2_MOVE_DOWN = 'K';
    public static final char P2_MOVE_RIGHT = 'L';
    public static final char P2_MOVE_LEFT = 'J';
    public static final char P2_MOVE_UP = 'I';

    public static final List<Character> player1Keys = upperAndLowerList(
            P1_MOVE_DOWN, P1_MOVE_LEFT, P1_MOVE_RIGHT, P1_MOVE_UP);
    public static final List<Character> player2Keys = upperAndLowerList(
            P2_MOVE_DOWN, P2_MOVE_LEFT, P2_MOVE_RIGHT, P2_MOVE_UP);

    private static List<Character> upperAndLowerList(Character... chars) {
        List<Character> list = new ArrayList<>();
        for (Character c : chars) {
            list.add(c);
            list.add(Character.toLowerCase(c));
        }
        return list;
    }
}
