package veeva;

/**
 * Decide whether a string is palidrome or not.
 * @author Ritesh Dalvi
 **/
public class PalidromeOrNot {

    public static void main(String args[]) {

        String palidrome = "geeksskeeg";
        String notPalidrome = "forgeeksskeegfor";

        System.out.println(isPalidrome(palidrome));
        System.out.println(isPalidrome(notPalidrome));
    }

    private static boolean isPalidrome(final String input) {

        if(input == null || input.trim().isEmpty()) {
            return true;
        }

        int start = 0;
        int end = input.length()-1;

        while(start<end) {

            char startChar = input.charAt(start);
            char endChar = input.charAt(end);

            if(startChar !=  endChar) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
