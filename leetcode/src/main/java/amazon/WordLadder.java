package amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that only one letter
 * can be changed at a time and each intermediate word must exist in the dictionary. For example, given: start = "hit" end = "cog" dict =
 * ["hot","dot","dog","lot","log"] One shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", the program should return its length 5.
 * Created by ritesh on 7/9/17.
 */
public class WordLadder
{

    public static void main(String args[])
    {

        String start = "hit";
        String end = "cog";

        final List<String> dic = new ArrayList<>();
        dic.add("hot");
        dic.add("dot");
        dic.add("dog");
        dic.add("lot");
        dic.add("log");

        List<String> output = wordLadder(start, end, dic);

        for (final String word : output)
        {
            System.out.print(word + "-> ");
        }
    }

    private static List<String> wordLadder(String beginWord, String endWord, List<String> wordList)
    {

        final Stack<String> stack = new Stack<>();
        stack.push(beginWord);

        final List<String> output = new ArrayList<>();

        while (!stack.isEmpty())
        {

            int minDistance = 1;

            String poppedWord = stack.pop();

            output.add(poppedWord);

            if (poppedWord.equals(endWord))
            {
                break;
            }

            wordList.remove(poppedWord);

            for (final String dct : wordList)
            {

                int distance = editDistance(poppedWord, dct, poppedWord.length(), dct.length());

                if (minDistance == 0)
                {
                    minDistance = distance;
                    stack.push(dct);
                }
                else if (distance <= minDistance)
                {
                    minDistance = distance;
                    stack.pop();
                    stack.push(dct);
                }
            }
        }

        return output;
    }

    private static int editDistance(String word1, String word2, int n, int m)
    {

        if (n == 0)
        {
            return m;
        }

        if (m == 0)
        {
            return n;
        }

        if (word1.charAt(n - 1) == word2.charAt(m - 1))
        {
            return editDistance(word1, word2, n - 1, m - 1);
        }

        return 1 + Math.min(editDistance(word1, word2, n - 1, m - 1),
                Math.min(editDistance(word1, word2, n - 1, m), editDistance(word1, word2, n, m - 1)));
    }
}
