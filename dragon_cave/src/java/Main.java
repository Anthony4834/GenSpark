import java.util.Scanner;

public class Main {

    public static String enter(int input) {
        if(input != 1 && input != 2)
            return("There are no dragons here...");

        System.out.print("You approach the cave...\nIt is dark and spooky...\nA large dragon jumps out in front of you!");
        try {
            switch(input) {
                case 1:
                    return " He opens his jaws and...\nGobbles you down in one bite!\n\n\n";
                case 2:
                    return " He leads you to his mountain of gold!\nHe lets you take as much as you need for your village to thrive like never before.\n\n\n";
                default: return null;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    public static void main(String[] args) {

        System.out.print("You are in a land full of dragons. In front of you, \nyou see two caves. In one cave, the dragon is friendly\nand will share his treasure with you. The other dragon\nis greedy and hungry and will eat you on sight.\n\nWhich cave will you go into? (1 or 2)\n");

        try {
            Scanner userInput = new Scanner(System.in);
            int choice = userInput.nextInt();
            System.out.print(enter(choice));
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}