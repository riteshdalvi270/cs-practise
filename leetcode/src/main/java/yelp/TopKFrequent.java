package yelp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a non-empty array of integers, return the k most frequent elements.

 For example,
 Given [1,1,1,2,2,3] and k = 2, return [1,2].

 Note:
 You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

 * Created by ritesh on 8/27/17.
 */
public class TopKFrequent {

    public static void main(String args[]) {

        int[] nums = {3,0,1,0};
        int k = 1;

        List<Integer> max = topKFrequent(nums, k);

        for(Integer mx : max) {
            System.out.println(mx);
        }
    }

    private static List<Integer> topKFrequent(int[] nums, int k) {

        if(nums.length == 0 || k == 0) {
            return new ArrayList<>();
        }

        Map<Integer,Integer> valueByKey = new HashMap<>();

        topKFrequent(nums,0,nums.length-1,valueByKey);

        int max = Integer.MIN_VALUE;
        int element = 0;

        List<Integer> ot = new ArrayList<>();

        while(k!=0) {

            for(Map.Entry<Integer, Integer> entrySet : valueByKey.entrySet()) {

                if(entrySet.getValue() > max) {
                    max = entrySet.getValue();
                    element = entrySet.getKey();
                }
            }

            ot.add(element);
            valueByKey.remove(element);
            max = Integer.MIN_VALUE;
            element = 0;

            k--;
        }

        return ot;
    }

    private static void topKFrequent(int[] nums, int start, int end, Map<Integer,Integer> valueByKey) {

        if(start > end) {
            return;
        }

        int mid = (start+end)/2;

        if(valueByKey.containsKey(nums[mid])) {

            int count = valueByKey.get(nums[mid]);
            count = count + 1;
            valueByKey.put(nums[mid],Integer.valueOf(count));
        }else {
            valueByKey.put(nums[mid],1);
        }

        topKFrequent(nums,start,mid-1,valueByKey);
        topKFrequent(nums,mid+1,end,valueByKey);
    }
}
