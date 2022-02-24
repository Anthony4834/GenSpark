public class Main {

    private static Hangman app;
    public static void main(String[] args) {
        try {
            app = new Hangman();
            app.init();
        } catch (Exception e) {
            System.out.println("Something went wrong..");
        }
    }
}
