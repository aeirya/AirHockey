package util.config;

import com.google.gson.GsonBuilder;
import util.resource.ResourceReader;

public class ConfigLoader {
    private static final String GUI_CONFIG_PATH = "gui.config.json";
    private static final String GAME_CONFIG_PATH = "game.config.json";

    public GuiConfigJson readGuiConfig() {
        String json = new ResourceReader().readText(GUI_CONFIG_PATH);
        return new GsonBuilder().create().fromJson(json, GuiConfigJson.class);
    }

    public GameConfigJson readGameConfig() {
        String json = new ResourceReader().readText(GAME_CONFIG_PATH);
        return new GsonBuilder().create().fromJson(json, GameConfigJson.class);
    }
}
