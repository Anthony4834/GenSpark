package environment;


import actors.Goblin;
import app.HumansVsGoblins;
import app.Main;

import java.util.HashMap;
import actors.Human;

public class MapGrid {

    public static HashMap<Integer, Tile> tileMap;
    private HumansVsGoblins app;
    private int size;
    Tile[][] grid;

    public MapGrid(HumansVsGoblins app) {
        this.app = app;
        this.size = 10;

        grid = this.build();

    }

    public Tile[][] build() {
        tileMap = new HashMap<>();

        Tile[][] arr = new Tile[5][10]; //5 arrays of 10 tiles
        for(int i = 5; i >= 1; i--){
            Tile[] tArr = new Tile[10];
            for(int e = 10; e >= 1; e--) {
                Tile t = new Tile(i, e);
                tileMap.put(Main.parseFromCoord(t.getX(), t.getY()), t);
                tArr[e - 1] = t;
            }
            arr[i - 1] = tArr;
        }
        return arr;
    }
    private void printTileMap(Tile[][] m) {
        for(Tile[] tA : m) {
            for(Tile t : tA) {
                if(t.getOccupant() == null)
//                    Main.p(false, String.format("[%s, %s]", t.getX(), t.getY()));
                    Main.p(false, "[ ]");
                else if(t.getOccupant().getClass() == Human.class)
                    Main.p(false, "[x]");
                else if(t.getOccupant().getClass() == Goblin.class)
                    Main.p(false, "[z]");
            }
            Main.p(false, "\n");
        }
    }
    public void printTileMap() {
        printTileMap(this.grid);
    }
}
