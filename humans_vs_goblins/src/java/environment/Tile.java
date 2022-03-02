package environment;

public class Tile {

    private int size;
    private int x;
    private int y;
    private Object occupant;
    private boolean isOccupied;

    public Tile(int x, int y) {
        this.size = 1;
        this.x = x;
        this.y = y;
    }
    public void occupy(Object o) {
        this.occupant = o;
        this.isOccupied = true;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Object getOccupant() {
        return occupant;
    }

    public void setOccupant(Object occupant) {
        this.occupant = occupant;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
