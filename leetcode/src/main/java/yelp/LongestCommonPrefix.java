package yelp;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Given a set of strings, find the longest common prefix.

 Input  : {“geeksforgeeks”, “geeks”, “geek”, “geezer”}
 Output : "gee"

 Input  : {"apple", "ape", "april"}
 Output : "ap"
 * Created by ritesh on 8/23/17.
 */
public class LongestCommonPrefix {

    public static void main(String args[]) {

        final String input[] = new String[] {"c", "acc", "cc"};

        System.out.println(longestCommonPrefix(input));
    }

    private static String longestCommonPrefix(String[] strs) {

        if(strs.length == 0) {
            return "";
        }else if(strs.length == 1) {
            return strs[0];
        }

        final StringBuilder st = new StringBuilder();

        final String value = strs[0];
        for(int i= 0;i<value.length();i++) {

            final char ch = value.charAt(i);

            if(findCommonPrefix(strs,1, i, ch)) {
                st.append(String.valueOf(ch));
            }else {
                break;
            }
        }

        return st.toString();
    }

    private static boolean findCommonPrefix(String[] input, int index, int charCounter, char ch) {

        boolean common = false;

        for(int j = index; j<input.length; j++) {

            if(charCounter > input[j].length()-1) {
                return false;
            }

            if(input[j].charAt(charCounter) == ch) {
                common = true;
            }else {
                common = false;
                break;
            }
        }

        return common;
    }
}
