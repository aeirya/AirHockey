package gui.view;

import gui.config.GuiConfig;
import logic.GameState;
import model.Player;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class ScoreView extends View{
    private final Player player;
    private final int x;
    private final int y;

    public ScoreView(Player player){
        this.player = player;
        x = player.getID() == 0 ? GuiConfig.getWindowWidth()/4 : GuiConfig.getWindowWidth()*3/4;
        y = GuiConfig.getWindowHeight()/2;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(new Color(0x51EE0404, true));

        Font font = new Font("Arial" , Font.BOLD , 50);
        g.setFont(font);
        int textWidth = g.getFontMetrics().stringWidth(getScoreStr());

        // rotate text
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.rotate(Math.toRadians(90), 0, 0);
        Font rotatedFont = font.deriveFont(affineTransform);

        g.setFont(rotatedFont);
        //g.scale(-1, 1);
        g.drawString(getScoreStr() , x , y - textWidth/2);
    }

    private String getScoreStr(){
        return "SCORE : " + player.getScore();
    }
}
