package amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters. Example 1: Input: "tree" Output: "eert" Explanation: 'e' appears
 * twice while 'r' and 't' both appear once. So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer. Example 2: Input:
 * "cccaaa" Output: "cccaaa" Explanation: Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer. Note that "cacaca" is incorrect, as
 * the same characters must be together. Example 3: Input: "Aabb" Output: "bbAa" Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters. Created by ritesh on 7/16/17.
 */
public class SortCharactersByFrequency
{

    public static void main(String args[])
    {

        String input = "eeeee";

        System.out.println(sortByFrequency(input));
    }

    private static String sortByFrequency(final String input)
    {

        char[] inChar = input.toCharArray();

        final Map<Character, Integer> frequenyMap = new HashMap<>();

        for (int i = 0; i < input.length(); i++)
        {

            char in = inChar[i];

            if (frequenyMap.containsKey(in))
            {
                Integer frequency = frequenyMap.get(in);
                frequenyMap.put(in, frequency + 1);
            }
            else
            {
                frequenyMap.put(in, 1);
            }
        }

        List<Character>[] buckets = new ArrayList[input.length() + 1];

        for (Map.Entry<Character, Integer> entrySet : frequenyMap.entrySet())
        {

            char in = entrySet.getKey();
            int frequency = entrySet.getValue();

            if (buckets[frequency] != null)
            {

                buckets[frequency].add(in);
            }
            else
            {
                buckets[frequency] = new ArrayList<>();
                buckets[frequency].add(in);
            }
        }

        final StringBuilder sb = new StringBuilder();

        for (int pos = buckets.length - 1; pos >= 0; pos--)
        {

            List<Character> bucket = buckets[pos];

            if (bucket != null)
            {
                for (Character in : bucket)
                {
                    for (int i = 0; i < frequenyMap.get(in); i++)
                        sb.append(String.valueOf(in));
                }
            }
        }

        return sb.toString();
    }
}
