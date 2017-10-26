package practise;

import java.util.Collections;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note: The solution set must not contain duplicate triplets.

 For example, given array S = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 * @author Ritesh Dalvi
 **/
public class ThreeSum {

    public static void main(String args[]) {

        int[] input = {-1,0,1,2,-1,-4};

        List<List<Integer>> output = threeSum(input);
    }

    // wont work
    public static List<List<Integer>> threeSum(int[] nums) {

        if(nums.length == 0) {
            return Collections.emptyList();
        }

        return Collections.emptyList();
    }
}
