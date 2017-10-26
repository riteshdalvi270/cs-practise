package practise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 * @author Ritesh Dalvi
 **/
public class SearchForRange {

    public static void main(String args[]) {

        int[] input = {5, 7, 7, 8, 8, 10};

        int target = 8;

        int[] ot = searchRange(input,target);

        for(int out : ot) {
            System.out.println(out);
        }
    }

    public static int[] searchRange(int[] nums, int target) {

        if(nums.length == 0) {
            return new int[]{};
        }

        int start = 0;
        int end = nums.length-1;

        List<Integer> output = new ArrayList<>();
        search(nums,start,end,target,output);

        int size = output.size();

        if(size == 0) {
            return new int[]{-1,-1};
        }

        Collections.sort(output);

        int[] ot = new int[2];


        ot[0] = output.get(0);
        ot[1] = output.get(size-1);

        return ot;
    }

    private static void search(int[] nums, int start, int end, int target, List<Integer> output) {

        if(start > end) {
            return;
        }

        int mid = (start+end)/2;

        if(nums[mid] == target) {
            output.add(mid);
        }

        if(target<nums[mid]) {
            // search left;
            search(nums,start,mid-1,target,output);

        }else if(target > nums[mid]) {
            // search right;
            search(nums,mid+1,end,target,output);

        }else if(target == nums[mid]) {

            if(mid+1 <= end && target==nums[mid+1]) {
                search(nums, mid+1, end, target, output);
            }else if(mid-1 >= start && target == nums[mid-1]) {
                search(nums, start, mid-1, target, output);
            }
        }
    }
}
