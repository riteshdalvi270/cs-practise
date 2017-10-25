package practise;

/**
 * Implement atoi to convert a string to an integer.
 *
 * @author Ritesh Dalvi (rd026600).
 */
public class StringToInteger {

    public static void main(String args[]) {

        final String input = "2147483648";

        System.out.println(convertStringToInteger(input));
    }

    private static int convertStringToInteger(final String input) {

        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        char inArray[] = input.trim().toCharArray();

        int multiplier = 1;
        int sum = 0;

        boolean isSign = false;

        for (int i = inArray.length - 1; i >= 0; i--) {

            if (isDigit(inArray[i])) {
                sum = sum + Integer.parseInt(String.valueOf(inArray[i])) * multiplier;
                multiplier = multiplier * 10;
            } else if (isSign(inArray[i]) && i == 0) {

                isSign = true;

                switch (inArray[i]) {
                    case '-':
                        sum = 0 - sum;
                        break;
                }
            } else {
                sum = 0;
                multiplier = 1;
            }
        }

        if (isSign) {
            return sum;
        }

        return Math.abs(sum);
    }

    private static boolean isSign(char ch) {

        switch (ch) {

            case '-':
            case '+':
                return true;
            default:
                return false;
        }
    }

    private static boolean isDigit(char in) {

        if (in >= '0' && in <= '9') {
            return true;
        }

        return false;
    }
}
