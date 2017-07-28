package facebook;

/**
 * Design a data structure that supports the following two operations:

 void addWord(word)
 bool search(word)
 search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

 For example:

 addWord("bad")
 addWord("dad")
 addWord("mad")
 search("pad") -> false
 search("bad") -> true
 search(".ad") -> true
 search("b..") -> true
 * Created by ritesh on 7/27/17.
 */
public class Dictionary {

    public static void main(String args[]) {

        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        System.out.println(obj.search("bad"));
    }

    static class WordDictionary {

        Trie trie = null;

        public WordDictionary() {

            trie = new Trie();
        }

        public void addWord(String word) {


        }

        public boolean search(String word) {
            return true;
        }
    }

    static class Trie {

        char value;
        Trie[] trie;
        boolean isLeaf;

        public Trie() {

        }

        public Trie(final char value) {
            this.value = value;
        }
    }
}
