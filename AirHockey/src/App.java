import gui.Window;
import logic.Game;

public class App {
    public static void main(String[] args) throws Exception {
        Game game = new Game();
        Window window = new Window(game);
        window.loop();
        //game.loop();
    }
}
