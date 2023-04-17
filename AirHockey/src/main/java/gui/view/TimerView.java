package gui.view;

import logic.GameState;

import java.awt.*;

public class TimerView extends View{
    private int x;
    private int y;
    private int width;
    private int height;
    private Color bgColor;
    private Color textColor;
    private int fontSize;
    private int time; //in second

    public TimerView(int x, int y, int width, int height, Color bgColor, Color textColor , int fontSize) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.bgColor = bgColor;
        this.textColor = textColor;
        this.fontSize = fontSize;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(bgColor);
        g.fillRect(x , y , width , height);

        g.setFont(new Font("Arial", Font.PLAIN, fontSize));
        g.setColor(textColor);

        String text = getTimeStr();
        //fit text center of rectangle
        int textWidth = g.getFontMetrics().stringWidth(text);
        int textHeight = g.getFontMetrics().getHeight();
        int centerX = x + (width - textWidth) / 2;
        int centerY = y + (height - textHeight) / 2 + g.getFontMetrics().getAscent();
        g.drawString(text, centerX, centerY);
    }

    @Override
    public void update(GameState state) {
        super.update(state);
        time = state.getTime();
    }

    private String getTimeStr(){
        int minuets = time/60;
        int second = time%60;

        String s = minuets < 10 ? "0" + minuets : minuets + "";
        s += " : ";
        s += second < 10 ? "0" + second : second + "";
        return s;
    }
}
