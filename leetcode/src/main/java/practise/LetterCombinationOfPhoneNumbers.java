package practise;

import java.util.*;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.



 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * @author Ritesh Dalvi
 **/
public class LetterCombinationOfPhoneNumbers {

    public static void main(String args[]) {

        final String digit = "999";

        List<String> output = letterCombinations(digit);

        for(final String ot : output) {
            System.out.println(ot);
        }
    }

    public static List<String> letterCombinations(String digits) {

        if(digits == null || digits.trim().isEmpty()) {
            return Collections.emptyList();
        }

        final Map<Integer,String> phoneNumbers = new HashMap<>();
        phoneNumbers.put(2,"abc");
        phoneNumbers.put(3, "def");
        phoneNumbers.put(4, "ghi");
        phoneNumbers.put(5,"jkl");
        phoneNumbers.put(6,"mno");
        phoneNumbers.put(7,"pqrs");
        phoneNumbers.put(8,"tuv");
        phoneNumbers.put(9,"wxyz");

        final List<Character> temp = new ArrayList<>();
        final List<String> results = new ArrayList<>();

        getLetters(digits,phoneNumbers,temp,results);

        return results;
    }

    private static void getLetters(final String digits, final Map<Integer,String> phoneNumbers, final List<Character> temp, final List<String> results) {

        if(digits.length() == 0) {

            char[] in = new char[temp.size()];
            for(int i=0; i<temp.size();i++) {

                in[i] = temp.get(i);
            }

            results.add(String.valueOf(in));
            return;
        }

        String digit = digits.substring(0,1);
        String numbers = phoneNumbers.get(Integer.parseInt(digit));

        for(int i=0; i<numbers.length();i++) {

            Character alphabet = numbers.charAt(i);
            temp.add(alphabet);
            getLetters(digits.substring(1),phoneNumbers,temp,results);
            temp.remove(temp.size()-1);
        }
    }
}
