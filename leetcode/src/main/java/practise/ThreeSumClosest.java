package practise;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 * @author Ritesh Dalvi
 **/
public class ThreeSumClosest {

    public static void main(String args[]) {

        int[] input = {1,1,1,1};

        int target = 0;

        System.out.println(threeSumClosest(input,target));
    }

    public static int threeSumClosest(int[] nums, int target) {

        if(nums.length == 0) {
            return -1;
        }

        if(nums.length-1 == 2) {
            return nums[0] + nums[1]+ nums[2];
        }

        Arrays.sort(nums);

        int closest = nums[0] + nums[1]+ nums[2];

        for(int i=0; i<nums.length-2; i++) {

            int j = i+1;
            int k = nums.length-1;

            while(j<k) {

                int sum = nums[i] + nums[j] + nums[k];

                if(sum == target) {
                    closest = sum;
                }else if(Math.abs(target - sum) == target) {
                    closest = sum;
                }else if(Math.abs(target - closest) > Math.abs(target-sum)) {
                    closest = sum;
                }

                if(sum<target) {
                    j++;
                }else {
                    k--;
                }
            }
        }

        return closest;
    }
}
