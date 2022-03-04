package app;

import environment.MapGrid;

public class Main {

    public static void main(String[] args) {
        HumansVsGoblins app = new HumansVsGoblins();

        app.setMapSize(25);
        app.setMapGrid(new MapGrid(app));

        app.init();
    }

    public static void p(boolean line, String s) {
        if(line)
            System.out.println(s);
        else
            System.out.print(s);
    }
    public static int parseFromCoord(int x, int y) {
        return Integer.parseInt(String.format("%s%s", x, y));
    }
    public static int[] array(int i) {
        int[] output = new int[i];

        for(int e = 0; e < i; e++) {
            output[e] = e;
        }

        return output;
    }

}
