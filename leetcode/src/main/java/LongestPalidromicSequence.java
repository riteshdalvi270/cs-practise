/**
 * Find longest palidromic string.
 * Created by ritesh on 6/24/17.
 */
public class LongestPalidromicSequence {

    public static void main(String args[]) {

        String input = "abcda";

        System.out.println(longestPalidromicSequence(input));
    }

    private static String longestPalidromicSequence(final String input) {

        if(input == null || input.equals("") || input.equals(" ")) {
            return null;
        }

        if(input.length() == 1) {
            return input;
        }

        char[] inputCharArray = input.toCharArray();

        String output = null;

        for(int i=0;i<input.length();i++) {

            char character = inputCharArray[i];

            for(int j=input.length()-1;j>i;j--) {

                if(character == inputCharArray[j]) {

                    final String possiblePalidrome = findIfPalidrome(input,i,j);

                    if(output == null) {
                        output = possiblePalidrome;
                    }else if(possiblePalidrome!=null && possiblePalidrome.length() > output.length()) {
                        output = possiblePalidrome;
                    }
                }
            }
        }

        if(output == null) {
            return String.valueOf(input.charAt(input.length()-1));
        }

        return output;
    }


    private static String findIfPalidrome(String input,int i, int j) {

        final String possiblePalidrome = input.substring(i,j+1);

        int b = possiblePalidrome.length() - 1;

        int a = 0;

        while(a<b) {

            if(possiblePalidrome.charAt(a) !=  possiblePalidrome.charAt(b)) {
                return null;
            }

            a++;
            b--;
        }

        return possiblePalidrome;
    }
}
