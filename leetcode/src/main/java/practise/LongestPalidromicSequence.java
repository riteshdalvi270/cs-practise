package practise;

/**
 * Find longest palidromic string. Created by ritesh on 6/24/17.
 */
public class LongestPalidromicSequence
{

    public static void main(String args[])
    {

        String input = "forgeeksskeegfor";

        System.out.println(longestPalidromicSequence(input));
    }

    private static String longestPalidromicSequence(final String input) {

        int maxLength = 1;
        int index = 0;
        int start = 0;
        int end = 0;

        for(int i=1; i<input.length();i++) {

            // for even number of palidrome string
            start = i-1;
            end = i;

            while(start>=0 && end<=input.length()-1 && input.charAt(start) ==  input.charAt(end)) {

                if(end-start+1 > maxLength){
                    index = start;
                    maxLength = end-start+1;
                }

                start--;
                end++;
            }


            start = i-1;
            end = i+1;

            while(start>=0 && end<=input.length()-1 && input.charAt(start) ==  input.charAt(end)) {

                if(end-start+1 > maxLength) {
                    index = start;
                    maxLength = end-start +1;

                }

                start--;
                end++;
            }
        }


        final String palidrome = input.substring(index,index+maxLength);

        return palidrome;
    }
}
