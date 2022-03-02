package app;

import actors.Human;
import environment.MapGrid;
import events.Controller;
import events.DIRECTION;

public class HumansVsGoblins {

    private int mapSize;
    private MapGrid mapGrid;
    private Human player;
    private Controller controller;

    public void init() {
        System.out.println("Initializing..");

        player = new Human();
        controller = new Controller(player);

        System.out.println(player.getX());
        System.out.println(player.getY());

        String input = (String) controller.getInput();

        switch(input) {
            case "w":
                player.move(DIRECTION.NORTH);
                break;
            case "a":
                player.move(DIRECTION.EAST);
                break;
            case "s":
                player.move(DIRECTION.SOUTH);
                break;
            case "d":
                player.move(DIRECTION.WEST);
                break;
            default:
                break;
        }
        System.out.println(player.getX());
        System.out.println(player.getY());
        mapGrid.printTileMap();





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
