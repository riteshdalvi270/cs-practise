package facebook;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

 Note:
 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.

 * Created by ritesh on 7/24/17.
 */
public class MoveZeros {

    public static void main(String args[]) {
        int[] input = new int[] {0,1,0,3,12};

        moveZeroes(input);

        for(int i=0;i<input.length;i++) {
            System.out.print(input[i]);
        }
    }

    public static void moveZeroes(int[] nums) {

        int i = 0;

        for(int j=1; j<nums.length;j++) {

            i = j-1;

            while(i >=0 && i+1<nums.length && nums[i+1] > nums[i] && nums[i] == 0) {
                System.out.println(nums[j]);
                swap(nums,i+1,i);
                i--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
