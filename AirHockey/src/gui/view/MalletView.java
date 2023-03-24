package gui.view;

import gui.config.GuiConfig;
import logic.GameState;
import model.Player;
import model.geometric.Circle;
import model.geometric.TwoCircleView;

import java.awt.*;

public class MalletView extends TwoCircleView {
    private final Player player;

    public MalletView(Player player) {
        super(Color.WHITE, Color.GRAY, 0.4f);
        this.player = player;
        if (player.getID() == 1) setOutColor(Color.DARK_GRAY);
    }

    @Override
    public void update(GameState state) {
        super.update(state);
        update(player);
    }
}
