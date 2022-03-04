package actors;

public class Human extends Actor {

    private int x, y;

    public Human() {
        super(5, 1);
        this.setHealth(100);
        this.setStrength(5);
        this.setAlive(true);
    }

}
