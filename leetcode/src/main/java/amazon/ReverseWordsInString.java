package amazon;

/**
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

 The input string does not contain leading or trailing spaces and the words are always separated by a single space.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".

 Could you do it in-place without allocating extra space?

 Related problem: Rotate Array

 * Created by ritesh on 7/12/17.
 */
public class ReverseWordsInString {
    public static void main(String args[]) {

        String input = "the sky is blue";

        System.out.println(reverseWordsInString(input));
    }

    private static String reverseWordsInString(String in) {

        int i=0;
        int j = in.length()-1;

        int previousi = 0;
        int previousj = in.length();

        while(i <=j) {

            if(in.charAt(i)!=' '){
                i++;
            }

            if(in.charAt(j)!= ' ') {
                j--;
            }

            if(in.charAt(i)==' ' && in.charAt(j)== ' ') {
                in = swap(in, previousi, i, previousj, j);

                i++;
                j--;

                previousi = i;
                previousj =j;
            }
        }

        return in;
    }

    private static String swap(String input,int previousi, int i, int previousj, int j) {

        //while()
        return null;
    }
}
