package hashtable;

/**
 * Write an algorithm to determine if a number is "happy".

 A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

 Example: 19 is a happy number

 12 + 92 = 82
 82 + 22 = 68
 62 + 82 = 100
 12 + 02 + 02 = 1


 * Created by ritesh on 9/21/17.
 */
public class HappyNumber {

    public static void main(String args[]) {

        int n = 3;

        System.out.println(isHappy(n));
    }

    public static boolean isHappy(int n) {

        try {
            if (n == 1) {
                return true;
            }

            int m = n;
            int a = 0;

            while (m > 0) {
                int remainder = (m % 10);
                a = a + remainder * remainder;
                m = m / 10;
            }

            n = a;

            return isHappy(n);
        }catch (final StackOverflowError stackOverflowError) {
            return false;
        }
    }
}
