public class ShorterMain {
    public static void main(String[] args) {
        String input = "Step on no pets";
        String ifOrNot = checkPalindrome(input) ? "palindrome" : "not a palindrome";
        System.out.println("\"" + input + "\" is a " + ifOrNot + ".");
    }

    private static boolean checkPalindrome(String input) {
        input = input.replaceAll(" ", "");
        StringBuilder b = new StringBuilder(input);
        return input.equalsIgnoreCase(b.reverse().toString());
    }
}