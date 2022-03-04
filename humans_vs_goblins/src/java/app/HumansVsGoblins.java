package app;

import actors.Goblin;
import actors.Human;
import environment.MapGrid;
import events.Controller;
import events.DIRECTION;
import events.Round;

import java.util.HashSet;

public class HumansVsGoblins {

    private int mapSize;
    private MapGrid mapGrid;
    private Human player;
    private Controller controller;
    private Round round;
    private Goblin[] enemies;
    private int prevTurn;

    public void init() {
        System.out.println("Initializing..");

        player = new Human();
        enemies = generateEnemies(5);
        controller = new Controller(player);
        prevTurn = -1;


        mapGrid.printTileMap();

        while(true) {
            this.round = new Round(this);

            if(prevTurn == -1)
                this.round.start(1);

            this.round.start(prevTurn == 1 ? 0 : 1);
        }

    }

    public Goblin[] generateEnemies(int i) {
        Goblin[] output = new Goblin[i];
        HashSet<Integer> usedNums = new HashSet<>();

        for(int e : Main.array(output.length)) {
            int ran = 1 + (int) (Math.random() * 9);

            while(usedNums.contains(ran)) {
                if(ran < 1)
                    ran = 10;

                ran--;
            }

            output[e] = new Goblin(1, ran, this);
            usedNums.add(ran);
        }

        return output;
    }

    public Goblin[] getEnemies() {
        return enemies;
    }

    public int getPrevTurn() {
        return prevTurn;
    }

    public void setPrevTurn(int prevTurn) {
        this.prevTurn = prevTurn;
    }

    public Human getPlayer() {
        return player;
    }

    public Controller getController() {
        return controller;
    }

    public int getMapSize() {
        return mapSize;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    public MapGrid getMapGrid() {
        return mapGrid;
    }

    public void setMapGrid(MapGrid mapGrid) {
        this.mapGrid = mapGrid;
    }
}
