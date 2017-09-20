package yelp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ritesh Dalvi (rd026600).
 */
public class Autocomplete
{
    public static void main(String args[])
    {
        final String file = "/usr/share/dict/words";

        final String prefix = "foo";
        final int count = 3;

        final List<String> autoComplete = autoComplete(prefix, count, file);
    }

    private static List<String> autoComplete(final String prefix, int count, final String file)
    {

        try
        {

            final List<String> result = new ArrayList<>();

            final FileReader fr = new FileReader(file);

            final BufferedReader br = new BufferedReader(fr);

            String line = null;

            boolean match = false;

            while ((line = br.readLine()) != null)
            {

                match = doesMatchPrefix(line, prefix);

                if (match)
                {
                    break;
                }
            }

            while (count != 0)
            {
                final String wordLine = br.readLine();

                match = doesMatchPrefix(wordLine, line);

                if (match)
                {
                    result.add(wordLine);
                }
                else
                {
                    break;
                }

                count--;
            }

            return result;
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    private static boolean doesMatchPrefix(final String line, final String prefix)
    {
        if (line == null || line.trim().equals(""))
        {
            return false;
        }

        char[] lineIn = line.toCharArray();
        char[] prefixIn = prefix.toCharArray();

        for (int i = 0; i < prefixIn.length; i++)
        {
            if (prefixIn[i] != lineIn[i])
            {
                return false;
            }
        }

        return true;
    }
}
