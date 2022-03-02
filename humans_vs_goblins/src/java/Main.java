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

}
