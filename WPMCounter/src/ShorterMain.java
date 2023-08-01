import java.util.Scanner;

public class ShorterMain {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the text to be typed:");
        String input = sc.nextLine();

        int countdown = 5;
        for (int i = countdown; i > 0; i--) {
            System.out.println("Starting in " + i + "...");
            Thread.sleep(1000);
        }

        long startTime = System.nanoTime();
        String userTypedText = sc.nextLine();
        long endTime = System.nanoTime();

        if (!userTypedText.equals(input)) {
            System.out.println("You have typed it incorrectly!");
            return;
        }

        int typedCharacters = input.length();
        double elapsedSeconds = (endTime - startTime) / 1_000_000_000.0;
        int wpm = (int) (typedCharacters / 5 / (elapsedSeconds / 60.0));
        System.out.printf("Took %.2f seconds for %d characters!%n", elapsedSeconds, typedCharacters);
        System.out.println("You typed " + wpm + " WPM!");
    }
}
