package facebook;

/**
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

 Note:
 The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

 Example 1:
 Given nums = [1, -1, 5, -2, 3], k = 3,
 return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

 Example 2:
 Given nums = [-2, -1, 2, 1], k = 1,
 return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
 * Created by ritesh on 7/24/17.
 */
public class MaximumSizeSubaaraySum {

    public static void main(String args[]) {

        int[] nums = new int[] {-2, -1, 2, 1};

        System.out.println(maxSubArrayLen(nums,1));
    }

    private static int maxSubArrayLenBruteForce(int[] nums, int k) {

        int max_len = 0;

        for(int i=0;i<nums.length;i++) {

            int sum = nums[i];

            for(int j = i+1; j<nums.length;j++) {

                sum = sum + nums[j];

                if(sum == k) {

                    if(j-i+1 > max_len) {
                        max_len = j-i+1;
                    }
                }
            }
        }

        return max_len;
    }

    private static int maxSubArrayLen(int[] nums, int k) {

        return calculateMaxSubArrayLen(nums, 0, nums.length-1,k);
    }

    private static int calculateMaxSubArrayLen(int[] nums, int p, int r, int k) {

        if(p>=r) {
            return 0;
        }

        int mid = (p+ r)/2;

        int max_left_len = calculateMaxSubArrayLen(nums,p,mid,k);
        int max_right_len = calculateMaxSubArrayLen(nums,mid+1, r, k);
        int max_cross_len = calculateCrossOver(nums,p,mid,r,k);

        if(max_cross_len > max_left_len && max_cross_len > max_right_len) {
            return max_cross_len;
        }else if(max_left_len > max_cross_len && max_left_len > max_right_len) {
            return max_left_len;
        }else {
            return max_right_len;
        }
    }

    private static int calculateCrossOver(int[] nums, int p, int mid, int r, int k) {

        int leftsum=0;

        int max_left_sum = 0;
        int max_left_index = 0;

        for(int i=mid;i>=p;i--) {

            leftsum = leftsum + nums[i];

            if(leftsum == k) {
                max_left_sum = leftsum;
                max_left_index = i;
            }
        }

        int rightSum = 0;
        int max_right_sum = 0;
        int max_right_index = 0;

        for(int j=mid+1;j<=r;j++) {

            rightSum = rightSum + nums[j];

            if(rightSum == k) {
                max_right_sum = rightSum;
                max_right_index = j;
            }
        }


        if(leftsum + max_right_sum ==  k) {
            return max_left_index + max_right_index + 1;
        }

        return max_left_index > max_right_index ? max_left_index : max_right_index;
    }
}
