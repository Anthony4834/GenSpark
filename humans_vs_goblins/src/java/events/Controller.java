package events;

import actors.Actor;
import actors.Human;

import java.util.Enumeration;
import java.util.Scanner;

public class Controller {

    private Human player;


    public Controller(Human player) {
        this.player = player;
    }

    public Object getInput() {
        Scanner input = new Scanner(System.in);

        return input.next();
    }


}
