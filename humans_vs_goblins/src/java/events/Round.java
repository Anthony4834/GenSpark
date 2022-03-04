package events;
import actors.Actor;
import actors.Goblin;
import app.HumansVsGoblins;
import app.Main;
import environment.MapGrid;

public class Round {

    private HumansVsGoblins app;
    private Actor player;
    private Controller controller;
    private MapGrid mapGrid;

    public Round(HumansVsGoblins app)  {
        this.app = app;
        this.player = app.getPlayer();
        this.controller = app.getController();
        this.mapGrid = app.getMapGrid();
    }

    public void start(int team) {
        app.setPrevTurn(team);

        if(team == 1) {
            Main.p(true, "\n\nPick a direction to move");
            Main.p(true, "[w] = UP [a] = LEFT [s] = DOWN [d] = RIGHT");
            String input = (String) controller.getInput();

            boolean verdict;

            switch(input) {
                case "w":
                    verdict = player.move(DIRECTION.NORTH);
                    break;
                case "a":
                    verdict = player.move(DIRECTION.EAST);
                    break;
                case "s":
                    verdict = player.move(DIRECTION.SOUTH);
                    break;
                case "d":
                    verdict = player.move(DIRECTION.WEST);
                    break;
                default:
                    verdict = false;
                    break;
            }

            if(!verdict) {
                Main.p(true, "That direction is blocked!");
                this.start(1);
            } else {
                mapGrid.printTileMap();
                Main.p(true, "*******************************");
            }
        } else {
            int ran = (int) (Math.random() * 5);
            Goblin botChoice = this.app.getEnemies()[ran];


            if(!botChoice.isAlive()) {
                start(0);
            } else {
                DIRECTION d = botChoice.decideNorthSouth();
                if (d != null)
                    botChoice.move(d);
                else {
                    d = botChoice.decideEastWest();
                    if (d != null)
                        botChoice.move(d);
                }

                mapGrid.printTileMap();
                Main.p(true, "*******************************");
            }
        }
    }
}
