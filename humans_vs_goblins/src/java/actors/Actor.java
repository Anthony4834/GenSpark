package actors;

import app.HumansVsGoblins;
import app.Main;
import environment.MapGrid;
import environment.Tile;
import events.Battle;
import events.DIRECTION;

import java.util.HashMap;

public class Actor {

    private int health;
    private int strength;
    private boolean isAlive;
    private int x, y;
    private HashMap<Integer, Tile> tileMap;
    private HumansVsGoblins app;

    public Actor(int x, int y) {
        this.x = x;
        this.y = y;
        this.tileMap = MapGrid.tileMap;

        tileMap.get(Main.parseFromCoord(this.getX(), this.getY())).occupy(this);
    }

    public boolean move(DIRECTION d) {

        int dx = this.x + d.getX();
        int dy = this.y + d.getY();

        int coords = Main.parseFromCoord(this.x, this.y);
        int dCoords = Main.parseFromCoord(dx, dy);

        if(tileMap.containsKey(dCoords)) {
            if (tileMap.containsKey(coords)) {
                tileMap.get(coords).setOccupant(null).setOccupied(false);
            }
            this.x = dx;
            this.y = dy;

            Tile destination = tileMap.get(dCoords);

            if(destination.isOccupied()) {
                Battle battle;

                battle = new Battle(this.app, this, destination.getOccupant());
                if(this.getClass() == Human.class)
                    destination.occupy(this);

                return true;
            }

            destination.occupy(this);

            return true;
        }
        return false;
    }
    public void kill() {
        this.isAlive = false;
        this.x = -1;
        this.y = -1;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public HumansVsGoblins getApp() {
        return app;
    }

    public void setApp(HumansVsGoblins app) {
        this.app = app;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
