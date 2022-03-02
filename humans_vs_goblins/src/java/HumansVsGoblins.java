import environment.MapGrid;

public class HumansVsGoblins {

    private int mapSize;
    private MapGrid mapGrid;

    public void init() {
        System.out.println("Initializing..");
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
