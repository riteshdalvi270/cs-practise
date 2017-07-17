package amazon;

/**
 * Using tie implement word dictionary. Created by ritesh on 7/16/17.
 */
public class WordDictionary
{

    static Trie trie = new Trie();

    public static void main(String args[])
    {

        addWord("bab");
        addWord("dad");
        addWord("mad");

        searchWord("dad");
    }

    private static void addWord(String word)
    {

        char[] wordChar = word.toCharArray();

        Trie[] children = trie.getChildren();

        for (int i = 0; i < word.length(); i++)
        {

            char in = wordChar[i];

            int position = in - 'a';

            Trie child = null;
            if (children[position] == null)
            {

                child = new Trie(in);

                children[position] = child;

            }
            else
            {

                child = children[position];

                children = child.getChildren();
            }

            if (i == word.length() - 1)
            {
                child.isLeaf = true;
            }
        }
    }

    private static boolean searchWord(String word)
    {

        char[] wordChar = word.toCharArray();

        Trie[] children = trie.getChildren();
        Trie childTree = null;
        for (int i = 0; i < wordChar.length; i++)
        {

            char in = wordChar[i];

            int position = in - 'a';

            if (children[position] == null)
            {
                return false;
            }
            else
            {

                childTree = children[position];

                children = childTree.getChildren();
            }
        }

        if (childTree != null && childTree.isLeaf)
        {
            return true;
        }

        return false;
    }

    static class Trie
    {

        char value;
        Trie[] children;
        boolean isLeaf;

        Trie()
        {
            children = new Trie[26];
        }

        Trie(char value)
        {
            this.value = value;
            children = new Trie[26];
        }

        public char getValue()
        {
            return value;
        }

        public void setValue(char value)
        {
            this.value = value;
        }

        public Trie[] getChildren()
        {
            return children;
        }

        public void setChildren(Trie[] children)
        {
            this.children = children;
        }
    }
}
