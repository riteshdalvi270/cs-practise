package facebook;

import assistant.Tree;
import assistant.TreeAssistant;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SumOfLeftLeaves {

    public static void main(String args[]) {

        int data[] = new int[] {3,9,20,15,7};

        TreeAssistant treeAssistant = new TreeAssistant();
        Tree root = treeAssistant.createBinarySearchTree(data, 0, data.length - 1);
        System.out.println(sumOfLeftLeaves(root));
    }

    private static long sumOfLeftLeaves(Tree root) {

        if(root==null) {
            return 0;
        }

        if(root.left == null) {
            return 0;
        }

        final Map<Long,Long> sumsByLevel = new HashMap<>();

         sumLeftLeaves(root,0,sumsByLevel);

         long maxSum = 0;

         for(Long sum : sumsByLevel.values()) {

             maxSum = maxSum + sum;
         }

         return Long.valueOf(maxSum).intValue();
    }

    private static void sumLeftLeaves(Tree root, long level, final Map<Long,Long> sumByLevel) {

        if(root==null) {

            return;
        }

        sumLeftLeaves(root.left,level+1,sumByLevel);

        if(root.left == null && root.right==null) {

            if(!sumByLevel.containsKey(level)) {
                    sumByLevel.put(level, Long.valueOf(root.data));
            }else {
                long sum = sumByLevel.get(level);
                sumByLevel.put(level,sum);
            }
        }else {
            sumByLevel.put(level,0L);
        }

        sumLeftLeaves(root.right,level+1,sumByLevel);
    }
}
