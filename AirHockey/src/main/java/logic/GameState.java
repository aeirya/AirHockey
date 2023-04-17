package logic;

import model.Goal;
import model.Player;
import model.powerup.PowerUp;
import model.airhockey.Mallet;
import model.airhockey.Puck;
import model.airhockey.Table;
import model.airhockey.wall.Wall;

import java.util.List;

public class GameState {

    /** left and right players */
    private Player player1;
    private Player player2;

    private List<Mallet> mallets;

    /** time in seconds */
    private int time;

    private Puck puck;

    public Table table;

    private List<Wall> walls;

    private List<Goal> goals;

    public Puck getPuck() {
        return puck;
    }

    public Table getTable() {
        return table;
    }

    private PowerUp powerup;

    public GameState setPlayer1(Player player1) {
        this.player1 = player1;
        return this;
    }

    public GameState setPlayer2(Player player2) {
        this.player2 = player2;
        return this;
    }

    public GameState setTime(int time) {
        this.time = time;
        return this;
    }

    public GameState setPuck(Puck puck) {
        this.puck = puck;
        return this;
    }

    public GameState setTable(Table table) {
        this.table = table;
        return this;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public List<Mallet> getMallets() {
        return mallets;
    }

    public GameState setMallets(List<Mallet> mallets) {
        this.mallets = mallets;
        return this;
    }

    public int getTime() {
        return time;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public GameState setGoals(List<Goal> goals) {
        this.goals = goals;
        return this;
    }

    public void setPowerup(PowerUp powerup) {
        this.powerup = powerup;
    }

    public PowerUp getPowerup() {
        return powerup;
    }
}
