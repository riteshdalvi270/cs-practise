package veeva;

import java.util.Arrays;

/**
 * Given an array A[] and a number x, check for pair in A[] with sum as x
 Write a program that, given an array A[] of n numbers and another number x, determines whether or not there exist two elements in S whose sum is exactly x.
 * @author Ritesh Dalvi
 **/
public class CheckForPairs {

    public static void main(String args[]) {

        int input[] = new int[] {1, 4, 45, 6, 10, 8}; // 1,4,6,8,10,46
        int x = 16;

        int[] ot = checkForPairs(input,x);

        for(int i=0; i<ot.length; i++) {
            System.out.print(ot[i]);
        }
    }

    private static int[] checkForPairs(int[] input, int x) {

        Arrays.sort(input);

        int start = 0;
        int end = input.length-1;

        while(start<end) {

            if(input[start]+input[end] == x){
                return new int[] {input[start],input[end]};
            }

            if(input[start]+input[end] < x) {
                start++;
            }else {
                end--;
            }
        }

        return new int[]{-1,-1};
    }
}
