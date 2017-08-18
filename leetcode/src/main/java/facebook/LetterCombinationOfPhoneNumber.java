package facebook;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ritesh on 8/16/17.
 */
public class LetterCombinationOfPhoneNumber {

    public static void main(String args[]) {
        List<String> ot = letterCombinations("23");

        for(String o : ot) {
            System.out.println(o);
        }
    }

    

    private static List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length() == i) {
                String t = ans.remove();
                for (char s : mapping[x].toCharArray())
                    ans.add(t + s);
            }
        }
        return ans;
    }
}