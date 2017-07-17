package amazon;

/**
 * KMP string matching algorithm. Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of
 * the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000. Example 1:
 * Input: "abab" Output: True Explanation: It's the substring "ab" twice. Example 2: Input: "aba" Output: False Example 3: Input: "abcabcabcabc"
 * Output: True Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.) Created by ritesh on 7/16/17.
 */
public class RepeatedSubstring
{

    public static void main(String args[])
    {

        final String text = "abab";

        System.out.println(repeatedSubstringPattern(text));
    }

    private static boolean repeatedSubstringPattern(String input)
    {

        int length = input.length();
        int[] lbs = patternTable(input, length);

        int lbsLength = lbs[input.length() - 1];

        return (lbsLength > 0 && (length % (length - lbsLength)) == 0);
    }

    private static int[] patternTable(String input, int length)
    {

        int j = 0;

        int[] lbs = new int[input.length()];

        lbs[j] = 0;

        int i = 1;

        while (i < length)
        {

            if (input.charAt(i) == input.charAt(j))
            {
                j = j + 1;
                lbs[i] = j;
                i++;
            }
            else
            {

                if (j != 0)
                {

                    j = lbs[j - 1];
                }
                else
                {

                    lbs[i] = j;
                    i++;
                }
            }
        }

        return lbs;
    }
}
