package amazon;

/**
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

 Solve it without division and in O(n).

 For example, given [1,2,3,4], return [24,12,8,6].

 Follow up:
 Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 * Created by ritesh on 7/12/17.
 */
public class ProductOfArrayExceptSelf {
    public static void main(String args[]) {

        int[] input = {1,2,3};

        int[] output = productExceptSelfOnline(input);

        for(int i=0; i<output.length;i++)
        System.out.print(output[i]+", ");
    }

    public static int[] productExceptSelf(int[] nums) {

        if(nums.length==0) {
            return new int[nums.length];
        }

        int[] out = new int[nums.length];

        for(int i=0;i<nums.length;i++) {
            int sum=1;

            int left =0;
            int right = nums.length-1;

            while(left<=right) {

                if(left!=i) {
                    sum = sum * nums[left];
                }

                if(left!=right && right!=i) {
                    sum = sum * nums[right];
                }

                left++;
                right--;
            }

            out[i] = sum;
        }

        return out;
    }

    public static int[] productExceptSelfOnline(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
