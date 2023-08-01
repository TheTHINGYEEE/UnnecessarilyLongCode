import java.util.Scanner;

public class LongerMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence to check if it's a palindrome: ");
        String input = scanner.nextLine();

        String sanitizedInput = removeSpaces(input);
        String reversedInput = reverseString(sanitizedInput);
        boolean isPalindrome = compareStrings(sanitizedInput, reversedInput);

        String ifOrNot;
        if (isPalindrome) {
            ifOrNot = "a palindrome";
        } else {
            ifOrNot = "not a palindrome";
        }

        System.out.println("The input sentence \"" + input + "\" is " + ifOrNot + ".");
    }

    private static String removeSpaces(String input) {
        String sanitizedInput = "";
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.isLetterOrDigit(currentChar)) {
                sanitizedInput += currentChar;
            }
        }
        return sanitizedInput;
    }

    private static String reverseString(String input) {
        String reversedString = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversedString += input.charAt(i);
        }
        return reversedString;
    }

    private static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (Character.toLowerCase(str1.charAt(i)) != Character.toLowerCase(str2.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
