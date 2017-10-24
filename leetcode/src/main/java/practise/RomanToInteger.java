package practise;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a roman numeral, convert it to an integer.

 Input is guaranteed to be within the range from 1 to 3999.
 * @author Ritesh Dalvi
 **/
public class RomanToInteger {

    public static void main(String args[]) {


        System.out.println(romanToInt("MCXCIV"));
    }

    private static int romanToInt(String s) {

        final Map<String,Integer> romanByInteger = new HashMap<>();

        buildTable(romanByInteger);

        char[] inArray = s.toCharArray();

        int sum = 0;
        for(int i=inArray.length-1;i>=0;i--) {

            int value = romanByInteger.get(String.valueOf(inArray[i]));

            if(sum == 0) {
                sum = sum + value;
                continue;
            }

            int previousValue = romanByInteger.get(String.valueOf(inArray[i+1]));

            if(value < previousValue) {

                sum = Math.abs(sum - value);
            }else {
                sum = sum + value;
            }
        }

        return sum;
    }

    private static void buildTable(final Map<String,Integer> romanTable) {

        romanTable.put("I",1);
        romanTable.put("IV",4);
        romanTable.put("V",5);
        romanTable.put("IX",9);
        romanTable.put("X",10);
        romanTable.put("XL",40);
        romanTable.put("L",50);
        romanTable.put("XC",90);
        romanTable.put("C",100);
        romanTable.put("CD",400);
        romanTable.put("D",500);
        romanTable.put("CM",900);
        romanTable.put("M",1000);
    }
}
