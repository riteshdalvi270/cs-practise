package amazon;

/**
 * Longest substring without repeating characters.
 * Created by ritesh on 7/5/17.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String args[]) {

        final String input = "abcabcbb";

        int max = longestSubstringWithoutRepeatedCharacters(input);

        System.out.println(max);
    }

    private static int longestSubstringWithoutRepeatedCharacters(final String s) {

        boolean[] ascii = new boolean[128];

        char[] inputChars = s.toCharArray();

        int max = 0;
        int count = 0;
        int previousIndex = -1;

        for(int i = 0; i<inputChars.length; i++) {

            if(ascii[inputChars[i]]) {

                if(count > max) {
                    max = count;
                }

                ascii = new boolean[128];
                count = 0;
                i = previousIndex;
                previousIndex = -1;
            }else {

                if(previousIndex == -1) {
                    previousIndex = i;
                }

                ascii[inputChars[i]] = true;
                count++;
            }
        }

        return count>max?count:max;
    }
}
