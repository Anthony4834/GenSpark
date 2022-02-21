import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

        public static String name;
        public static int correctNum;
        public static int numOfGuesses = 0;

        private static void genNumber() {
            correctNum = (int) Math.floor(Math.random() * 21) + 1;
        }

        public static ArrayList<String> takeGuess(int guess) {
            ArrayList<String> output = new ArrayList<String>();

            try {
                output.add(String.valueOf(guess == correctNum));
                output.add(correctNum < guess ? "High" : "Low");

                return output;
            } catch(Exception e) {
                begin();
            }
            return null;
        }
        public static String begin() {

            numOfGuesses++;
            System.out.println("\nTake a guess");

            try {
                Scanner input = new Scanner(System.in);
                int guess = input.nextInt();

                ArrayList<String> verdict = takeGuess(guess);

                switch(verdict.get(0)) {
                    case "true":
                        System.out.println(String.format("Well done, %s! You guessed my number in %s guesses!\nWould you like to play again?", name, numOfGuesses));
                        Scanner playAgain = new Scanner(System.in);
                        if(playAgain.next().equals("Y")) {
                            genNumber();
                            begin();
                        }
                        else {
                            System.out.println("Okay! Goodbye.");
                            return "end";
                        }
                    case "false":
                        System.out.println(String.format("Your guess is too %s", verdict.get(1)));
                        begin();
                    default:
                        return "";
                }
            } catch (Exception e) {
                System.out.println("I said a number..");
                begin();
            }

            return null;
        }

        public static void main(String[] args) {

            System.out.println("Hello! What is your name?");

            try {
                Scanner userInput = new Scanner(System.in);
                name = userInput.next();

                System.out.print(String.format("Well, %s, I am thinking of a number between 1 & 20", name));
                genNumber();

                begin();
            } catch (Exception e) {
                System.out.print(e);
            }
        }
}
