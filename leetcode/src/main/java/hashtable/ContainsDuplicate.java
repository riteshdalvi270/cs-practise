package hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 *  Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 * Created by ritesh on 9/20/17.
 */
public class ContainsDuplicate {

    public static void main(String args[]) {

        final int[] nums = new int[]{2,9,4,3,1,6,7,5};

        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {

        Set<Integer> ascii = new HashSet<>();

        return containsDuplicate(nums,0,nums.length-1,ascii);
    }

    private static boolean containsDuplicate(int[] nums, int start, int end, Set<Integer> ascii) {

        if(start > end) {
            return false;
        }

        int mid = (start+end)/2;

        if(ascii.contains(nums[mid])) {
            return true;
        }else {
            ascii.add(nums[mid]);
        }

        return containsDuplicate(nums,start,mid-1,ascii) || containsDuplicate(nums,mid+1,end,ascii);
    }
}
