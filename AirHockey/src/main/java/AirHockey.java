import gui.Window;
import logic.Game;

public class AirHockey {
    public static void main(String[] args) {
        Game game = new Game();
        Window window = new Window(game);
        window.loop();
        game.startNewGame();
    }
}
