package actors;

import app.HumansVsGoblins;
import events.DIRECTION;

public class Goblin extends Actor {

    public Goblin(int x, int y, HumansVsGoblins app) {
        super(x, y);

        this.setApp(app);
        this.setHealth(100);
        this.setStrength(5);
        this.setAlive(true);
    }

    public DIRECTION decideNorthSouth() {
        int playerX = this.getApp().getPlayer().getX();

        if(playerX - this.getX() == 0)
            return null;

        if(playerX - this.getX() > 0)
            return DIRECTION.SOUTH;

        return DIRECTION.NORTH;
    }

    public DIRECTION decideEastWest() {
        int playerY = this.getApp().getPlayer().getY();

        if(playerY - this.getY() == 0) {
            return null;
        }

        if(playerY - this.getY() > 0)
            return DIRECTION.WEST;

        return DIRECTION.EAST;
    }
}
