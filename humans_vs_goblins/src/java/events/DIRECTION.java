package events;

public enum DIRECTION{
    NORTH(0, 1),
    SOUTH(0, -1),
    EAST(-1, 0),
    WEST(1, 0)
    ;

    private int x, y;

    private DIRECTION(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
