package amazon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Frequency of each word in file words.txt Created by ritesh on 7/6/17.
 */
public class WordsFrequency
{
    public static void main(String args[])
    {

        final File file = new File("/Users/rd026600/Documents/Ritesh/cs-practise/leetcode/src/main/java/amazon/words.txt");

        wordCount(file);
    }

    private static void wordCount(final File file)
    {

        try
        {
            final FileReader fileReader = new FileReader(file);
            final BufferedReader bf = new BufferedReader(fileReader);

            String input = null;

            final Map<String, Integer> wordFrequency = new HashMap<String, Integer>();

            while ((input = bf.readLine()) != null)
            {

                final String[] splitInputs = input.split(" ");

                for (final String in : splitInputs)
                {

                    if (wordFrequency.containsKey(in))
                    {
                        Integer count = wordFrequency.get(in);
                        count = count + 1;
                        wordFrequency.put(in, count);
                    }
                    else
                    {
                        wordFrequency.put(in, 1);
                    }
                }
            }

            final List<Integer> frequencies = new ArrayList<Integer>(wordFrequency.values());

            Collections.sort(frequencies, new Comparator<Integer>()
            {
                public int compare(Integer o1, Integer o2)
                {
                    if (o1 < o2)
                    {
                        return 1;
                    }
                    else if (o1.equals(o2))
                    {
                        return 0;
                    }
                    else
                    {
                        return -1;
                    }
                }
            });

            for (Integer frequency : frequencies)
            {

                for (Map.Entry<String, Integer> entrySet : wordFrequency.entrySet())
                {

                    if (entrySet.getValue().equals(frequency))
                    {
                        System.out.println("Word:" + entrySet.getKey() + " , Frequency:" + frequency);
                        break;
                    }
                }
            }

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {

        }
    }
}
