package util.config;

import model.Dimension;

public class GuiConfigJson {
    private Dimension windowDimension;

    public static void main(String[] args) {
        int x = new ConfigLoader().readGuiConfig().windowDimension.getX();
        System.out.println(x);
    }
}
