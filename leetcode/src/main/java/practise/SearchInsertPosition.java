package practise;

/**
 * @author Ritesh Dalvi
 **/
public class SearchInsertPosition {

    public static void main(String args[]) {

        int[] input = {1,3,5,6};
        int target = 0;

        System.out.println(searchInsert(input,target));
    }

    public static int searchInsert(int[] nums, int target) {

        int start =0;
        int end = nums.length-1;

        int mid = (start+end)/2;

        if(target<nums[mid]) {

            while(start <= mid) {

                if(target > nums[start]) {
                    start++;
                }else if(target ==  nums[start]) {
                    return start;
                }else {
                    return start;
                }
            }
        }else {

            while(mid <= end) {

                if(target > nums[mid]) {
                    mid++;
                }else if(target ==  nums[mid]) {
                    return mid;
                }else {
                    return mid;
                }
            }
        }

        return end+1;
    }
}
