package facebook;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

/**
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

 If two nodes are in the same row and column, the order should be from left to right.

 Examples:

 Given binary tree [3,9,20,null,null,15,7],
 3
 /\
 /  \
 9  20
 /\
 /  \
 15   7
 return its vertical order traversal as:
 [
 [9],
 [3,15],
 [20],
 [7]
 ]
 Given binary tree [3,9,8,4,0,1,7],
 3
 /\
 /  \
 9   8
 /\  /\
 /  \/  \
 4  01   7
 return its vertical order traversal as:
 [
 [4],
 [9],
 [3,0,1],
 [8],
 [7]
 ]
 Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
 3
 /\
 /  \
 9   8
 /\  /\
 /  \/  \
 4  01   7
 /\
 /  \
 5   2
 return its vertical order traversal as:
 [
 [4],
 [9,5],
 [3,0,1],
 [8,2],
 [7]
 ]
 * Created by ritesh on 7/26/17.
 */
public class VerticalOrderTraversal {

    public static void main(String args[]) {

        final TreeNode treeNode = new TreeNode(3);

        verticalOrder(treeNode);
    }

    private static List<List<Integer>> verticalOrder(final TreeNode treeNode) {

        final Queue<Pair<Integer,TreeNode>> queue = new ArrayDeque<>();
        final TreeMap<Integer,List<Integer>>  nodeByLevel = new TreeMap<>();

        queue.add(Pair.of(0,treeNode));

        nodeByLevel.put(0, ImmutableList.of(treeNode.val));

        int min = 0;
        while(!queue.isEmpty()) {

            Pair<Integer, TreeNode> queuePair = queue.remove();

            TreeNode node = queuePair.getRight();
            int level = queuePair.getLeft();

            if(node.left!=null) {

                queue.add(Pair.of(level-1,node.left));

                if(nodeByLevel.get(level-1)!=null) {
                    nodeByLevel.get(level-1).add(node.left.val);
                }else {
                    nodeByLevel.put(level-1 ,ImmutableList.of(node.left.val));
                }
           }

           if(node.right!=null) {

               queue.add(Pair.of(level-1,node.left));

               if(nodeByLevel.get(level+1)!=null) {
                   nodeByLevel.get(level+1).add(node.right.val);
               }else {
                   nodeByLevel.put(level+1,ImmutableList.of(node.right.val));
               }
           }

           min = Math.min(min,level);
        }

        List<List<Integer>> res = new ArrayList<>();

        while(nodeByLevel.containsKey(min)) {

            res.add(nodeByLevel.get(min++));
        }

        return res;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.val = value;
        }
    }
}
