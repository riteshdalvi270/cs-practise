package veeva;

/**
 * Reverse a string.
 * @author Ritesh Dalvi
 **/
public class ReverseString {

    public static void main(String args[]) {

        final String input= "forgeeksskeegfor";

        System.out.print(reverseString(input));
    }

    private static String reverseString(final String input) {

        final StringBuilder sb = new StringBuilder();

        for(int i=input.length()-1;i>=0;i--) {
            sb.append(input.charAt(i));
        }

        return sb.toString();
    }
}
