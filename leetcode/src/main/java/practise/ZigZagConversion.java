package practise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * @author Ritesh Dalvi
 **/
public class ZigZagConversion {

    public static void main(String args[]) {

        final String input = "PAYPALISHIRING";
        int rows = 3;

        System.out.print(convert(input,rows));
    }

    public static String convert(String s, int numRows) {

        Map<Integer,List<String>> output = new HashMap<>();

        int n = 0;
        boolean down = false;

        for(int i=0; i<s.length(); i++) {

            char in = s.charAt(i);

            if(output.get(n)!=null) {
                output.get(n).add(String.valueOf(in));
            }else {
                List<String> ot = new ArrayList<>();
                ot.add(String.valueOf(in));
                output.put(n,ot);
            }

            if(n == 0) {
                down = false;
            }

            if(n == numRows-1) {
                down = true;
            }

            n = down ? n-1 : n+1;
        }

        /*for(Map.Entry<Integer,List<String>> entrySet : output.entrySet()) {

            List<String> list = entrySet.getValue();

            for(String str : list) {

                System.out.print(str);
            }
        }*/

        StringBuilder sb = new StringBuilder();

        for(List<String> ot : output.values()) {

            for(String str : ot) {
                sb.append(str);
            }
        }

        return sb.toString();
    }
}
