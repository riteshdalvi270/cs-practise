package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ritesh on 7/11/17.
 */
public class FindAnagrams {
    public static void main(String args[]) {
        final String input = "cbababacd";
        final String p = "abc";

        List<Integer> output = findAnagramsBySlidingWindow(input,p);

        for(final Integer ot : output) {
            System.out.println(ot);
        }
    }

    private static List<Integer> findAnagrams(final String s, final String p) {

        List<Integer> output = new ArrayList<>();

        for(int i=0;i<s.length();i++) {

            if(i+p.length() > s.length()) {
                continue;
            }

            String possibleAnagram = s.substring(i,i+p.length());

            if(isAnagram(possibleAnagram,p)) {
                output.add(i);
            }
        }

        return output;
    }

    private static boolean isAnagram(String input, String p) {

        char[] in = input.toCharArray();
        Arrays.sort(in);

        return String.valueOf(in).equals(p);
    }

    private static List<Integer> findAnagramsBySlidingWindow(final String s, final String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;

        int[] hash = new int[256]; //character hash

        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();

        while (right < s.length()) {
            //move right everytime, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            if (hash[s.charAt(right)] >= 1) {
                count--;
            }
            hash[s.charAt(right)]--;
            right++;

            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if (count == 0) {
                list.add(left);
            }
            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length() ) {

                if (hash[s.charAt(left)] >= 0) {
                    count++;
                }
                hash[s.charAt(left)]++;
                left++;

            }


        }
        return list;
    }

}
