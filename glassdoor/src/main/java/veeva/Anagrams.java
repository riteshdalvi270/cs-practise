package veeva;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Determine if two strings are anagrams.
 * @author Ritesh Dalvi
 **/
public class Anagrams {

    public static void main(String args[]) {

        final String input1 = "cineman";
        final String input2 = "icenman";

        System.out.print(anagrams(input1,input2));
    }

    private static boolean anagrams(final String input1, final String input2) {

        if(input1.length()!=input2.length()) {
            return false;
        }

        final Map<Character,Integer> countByCharacter =  new HashMap<>();

        for(int i=0;i<input1.length();i++) {

            char in = input1.charAt(i);

            if(countByCharacter.containsKey(in)) {
                int count = countByCharacter.get(in);
                count =  count + 1;
                countByCharacter.put(in,count);
            }else {
                countByCharacter.put(in,1);
            }
        }

        for(int i=0; i<input2.length(); i++) {

            char in = input1.charAt(i);

            if(!countByCharacter.containsKey(in)) {
                return false;
            }

            int count = countByCharacter.get(in);
            count = count - 1;
            countByCharacter.put(in,count);
        }


        for(int i=0;i<input1.length();i++) {

            char in = input1.charAt(i);

            if(countByCharacter.get(in) != 0) {
                return false;
            }
        }

        return true;
    }
}
