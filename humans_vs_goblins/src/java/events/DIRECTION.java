package events;

public enum DIRECTION{
    NORTH(-1, 0),
    SOUTH(1, 0),
    EAST(0, -1),
    WEST(0, 1)
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
