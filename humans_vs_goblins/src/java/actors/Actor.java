package actors;

import events.DIRECTION;

public class Actor {

    private int x, y;

    public Actor(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean move(DIRECTION d) {

        int dx = this.x + d.getX();
        int dy = this.y + d.getY();

        if(dx < 0 || dy < 0 || dx > 10 || dy > 10) {
            return false;
        }
        this.x = dx;
        this.y = dy;

        return true;
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
