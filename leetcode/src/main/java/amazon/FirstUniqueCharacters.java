package amazon;

/**
 * First unique characters. Created by ritesh on 7/9/17.
 */
public class FirstUniqueCharacters
{

    public static void main(String args[])
    {

        final String input = "leetcode";

        System.out.println(firstUniqueCharacter(input));
    }

    private static int firstUniqueCharacter(final String s)
    {

        char[] in = s.toCharArray();

        int index = -1;

        boolean ascii[] = new boolean[128];

        for (int i = 0; i < in.length; i++)
        {

            char ch = in[i];

            if (ascii[ch])
            {
                continue;
            }

            if (index != -1)
            {
                ascii[ch] = true;
                continue;
            }

            int startIndex = i + 1;
            int endIndex = in.length - 1;

            while (startIndex <= endIndex)
            {

                if (ch == in[startIndex])
                {
                    ascii[ch] = true;
                    index = -1;
                    break;
                }
                else if (ch == in[endIndex])
                {
                    ascii[ch] = true;
                    index = -1;
                    break;
                }
                else
                {
                    index = i;
                }

                startIndex++;
                endIndex--;
            }
        }

        if (!ascii[s.charAt(s.length() - 1)])
        {
            return s.length() - 1;
        }

        return index;

    }
}
