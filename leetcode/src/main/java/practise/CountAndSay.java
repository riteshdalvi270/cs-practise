package practise;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:

 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221
 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth term of the count-and-say sequence.

 Note: Each term of the sequence of integers will be represented as a string.

 Example 1:

 Input: 1
 Output: "1"
 Example 2:

 Input: 4
 Output: "1211"
 * @author Ritesh Dalvi
 **/
public class CountAndSay {

    public static void main(String args[]) {

        int n = 6;

        System.out.println(countAndSay(n));
    }

    public static String countAndSay(int n) {

        String st = "1";

        if(n == 1) {
            return st;
        }

        for(int i=2; i<=n; i++) {

            st = count(st);
        }

        return st;
    }

    private static String count(String st) {

        int count = 1;

        char[] inArray = st.toCharArray();

        final StringBuilder stringBuilder = new StringBuilder();

        for(int i=0; i< inArray.length; i++) {

            if(i+1 <= inArray.length-1 && inArray[i] ==  inArray[i+1]) {
                count = count+1;
            }else {
                stringBuilder.append(count).append(inArray[i]);
                count = 1;
            }
        }

        return stringBuilder.toString();
    }
}
