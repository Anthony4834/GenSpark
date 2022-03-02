package actors;

public class Human extends Actor {
    private int health;
    private int strength;
    private boolean isAlive;
    private int x, y;

    public Human() {
        super(1, 1);
        this.health = 100;
        this.strength = 5;
        this.isAlive = true;
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
}
