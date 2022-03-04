package events;

import actors.Human;
import app.Main;

import java.util.Scanner;

public class Controller {

    private Human player;


    public Controller(Human player) {
        this.player = player;
    }

    public Object getInput() {
        try {
            Scanner input = new Scanner(System.in);

            return input.next();
        } catch(Exception e) {
            Main.p(false, e.toString());
        }

        return null;
    }


}
