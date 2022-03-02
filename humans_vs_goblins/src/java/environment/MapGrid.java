package environment;


import HumansVsGoblins;
import Main;

public class MapGrid {

    private HumansVsGoblins app;
    private int size;
    Tile[][] grid;

    public MapGrid(HumansVsGoblins app) {
        this.app = app;
        this.size = 10;

        grid = this.build();
    }

    public Tile[][] build() {
        Tile[][] arr = new Tile[5][10];
        for(int i = 1; i <= 5; i++){
            Tile[] tArr = new Tile[10];
            for(int e = 1; e <= 10; e++) {
                Tile t = new Tile(i, e);
                tArr[e - 1] = t;
            }
            arr[i - 1] = tArr;
        }

        for(Tile[] tA : arr) {
            for(Tile t : tA) {
                Main.p(false, "*");
            }
            Main.p(false, "\n");
        }
        return arr;
    }
}
