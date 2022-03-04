package events;

import actors.Goblin;
import actors.Human;
import app.HumansVsGoblins;

public class Battle {
    HumansVsGoblins app;
    Human player;
    Goblin enemy;

    public Battle(HumansVsGoblins app, Object h, Object g) {
        this.app = app;
        if(h.getClass() == Human.class) {
            player = (Human) h;
            enemy = (Goblin) g;
        } else {
            player = (Human) g;
            enemy = (Goblin) h;
        }

        System.out.println(String.format("Battle commenced:\n%s vs %s", player.getClass(), enemy.getClass()));
        enemy.kill();
    }
}
