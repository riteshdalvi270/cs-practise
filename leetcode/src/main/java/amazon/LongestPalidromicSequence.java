package amazon;

/**
 * Longest palidromic sequence. Created by ritesh on 7/9/17.
 */
public class LongestPalidromicSequence
{

    public static void main(String args[])
    {

        final String input = "babadada";

        System.out.println(findLongestPalidromicSequency(input));
    }

    private static String findLongestPalidromicSequency(String input)
    {

        if (input == null)
        {
            return "";
        }

        if (input.length() == 1)
        {
            return input;
        }

        String palidrome = null;

        final char[] in = input.toCharArray();

        for (int i = 0; i < input.length(); i++)
        {

            char charToStart = in[i];

            int start = i;
            int end = input.length() - 1;

            while (start < end)
            {
                if (in[end] == charToStart)
                {
                    String temp  = isPalidrome(input, i, end);

                    if(palidrome == null) {
                        palidrome = temp;
                    }

                    if (temp != null && palidrome!=null && temp.length() > palidrome.length())
                    {
                         palidrome =  temp;
                    }
                }
                end--;
            }
        }

        return palidrome == null ? String.valueOf(input.charAt(0)) : palidrome;
    }

    private static String isPalidrome(final String input, int start, int end)
    {
        int i = start;
        int j = end;
        while (i <= j)
        {

            if (input.charAt(i) != input.charAt(j))
            {
                return null;
            }

            i++;
            j--;
        }

        return input.substring(start, end + 1);
    }
}
