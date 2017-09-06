package yelp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.

 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:

 [
 ["ate", "eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 * Created by ritesh on 8/23/17.
 */
public class GroupAnagrams {

    public static void main(String args[]) {

        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>>groupAnagrams = groupAnagrams(strs);

        for(List<String> anagrams : groupAnagrams) {

            for(String anagram : anagrams) {
                System.out.print(anagram+" ,");
            }

            System.out.println();
        }
    }

    public static List<List<String>> groupAnagrams(String strs[]) {

        final Map<Integer,List<String>> hashCodeByString = new HashMap<>();

        for(final String str : strs) {

            int asciiCode = getAscii(str);

            if(hashCodeByString.containsKey(asciiCode)) {
                List<String> anagrams = hashCodeByString.get(asciiCode);
                anagrams.add(str);
            }else {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(str);
                hashCodeByString.put(asciiCode,anagrams);
            }
        }

        List output =  new ArrayList(hashCodeByString.values());

        return output;
    }

    private static int getAscii(final String strs) {
        int sum = 0;
        for(int i=0; i<strs.length(); i++) {
            sum = sum + strs.charAt(i);
        }

        return sum;
    }
}
