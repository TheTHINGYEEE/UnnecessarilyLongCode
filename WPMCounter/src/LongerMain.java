import java.util.Scanner;

public class LongerMain {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Typing Speed Test!");

        System.out.print("Enter the text to be typed: ");
        String input = sc.nextLine();

        int countdown = 5;
        performCountdown(countdown);

        long startTime = getNanoTime();
        String userTypedText = getUserInput();
        long endTime = getNanoTime();

        if (!compareStrings(userTypedText, input)) {
            System.out.println("You have typed it incorrectly!");
            return;
        }

        int typedCharacters = getCharacterCount(input);
        double elapsedSeconds = getElapsedSeconds(startTime, endTime);
        int wpm = calculateWPM(typedCharacters, elapsedSeconds);
        displayTypingStats(elapsedSeconds, typedCharacters, wpm);
    }

    private static void performCountdown(int countdown) throws InterruptedException {
        while (countdown > 0) {
            System.out.println("Starting in " + countdown + "...");
            Thread.sleep(1000);
            countdown--;
        }
    }

    private static long getNanoTime() {
        return System.nanoTime();
    }

    private static String getUserInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private static boolean compareStrings(String str1, String str2) {
        return str1.equals(str2);
    }

    private static int getCharacterCount(String text) {
        return text.length();
    }

    private static double getElapsedSeconds(long startTime, long endTime) {
        return (endTime - startTime) / 1_000_000_000.0;
    }

    private static int calculateWPM(int characters, double timeInSeconds) {
        double minutes = timeInSeconds / 60;
        return (int) (characters / 5 / minutes);
    }

    private static void displayTypingStats(double elapsedSeconds, int characters, int wpm) {
        System.out.println("Typing Test Results:");
        System.out.printf("Took %.2f seconds for %d characters!%n", elapsedSeconds, characters);
        System.out.println("You typed " + wpm + " WPM!");
    }
}
