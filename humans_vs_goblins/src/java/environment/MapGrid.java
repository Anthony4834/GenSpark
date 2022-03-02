package environment;


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

        Tile[][] arr = new Tile[5][10];
        for(int i = 1; i <= 5; i++){
            Tile[] tArr = new Tile[10];
            for(int e = 1; e <= 10; e++) {
                Tile t = new Tile(i, e);
                tileMap.put(Main.parseFromCoord(t.getX(), t.getY()), t);
                tArr[e - 1] = t;
            }
            arr[i - 1] = tArr;
        }
        printTileMap(arr);
        return arr;
    }
    private void printTileMap(Tile[][] m) {
        for(Tile[] tA : m) {
            for(Tile t : tA) {
                if(t.getOccupant() == null)
                    Main.p(false, "*");
                else if(t.getOccupant().getClass() == Human.class)
                    Main.p(false, "p");
            }
            Main.p(false, "\n");
        }
    }
    public void printTileMap() {
        printTileMap(this.grid);
    }
}
