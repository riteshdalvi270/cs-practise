package amazon;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k
 * numbers in the window. Each time the sliding window moves right by one position. For example, Given nums = [1,3,-1,-3,5,3,6,7], and k = 3. Window
 * position Max --------------- ----- [1 3 -1] -3 5 3 6 7 3 1 [3 -1 -3] 5 3 6 7 3 1 3 [-1 -3 5] 3 6 7 5 1 3 -1 [-3 5 3] 6 7 5 1 3 -1 -3 [5 3 6] 7 6 1
 * 3 -1 -3 5 [3 6 7] 7 Therefore, return the max sliding window as [3,3,5,5,6,7]. Note: You may assume k is always valid, ie: 1 ≤ k ≤ input array's
 * size for non-empty array. Follow up: Could you solve it in linear time? Created by ritesh on 7/9/17.
 */
public class SlidingWindowMaximum
{

    public static void main(String args[])
    {

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};

        int k = 3;

        int[] output = slidingWindowMaximumNonLinear(nums, k);

        for (int i = 0; i < output.length; i++)
        {
            System.out.println(output[i]);
        }
    }

    private static int[] slidingWindowMaximumNonLinear(int[] nums, int k)
    {

        int[] output = new int[nums.length - (k - 1)];

        int counter = 0;

        for (int i = 0; i < nums.length; i++)
        {

            if (nums.length - i < k)
            {
                break;
            }

            int window = k;
            int max = Integer.MIN_VALUE;

            int index = i;

            while (window >= 1)
            {

                if (index >= nums.length)
                {
                    break;
                }

                int value = nums[index];

                if (value > max)
                {
                    max = value;
                }

                index++;
                window--;
            }

            output[counter] = max;
            counter = counter + 1;
        }

        return output;
    }
}
