package facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.

 For example, given the following binary tree:

 1
 /   \
 2     3
 \
 5
 All root-to-leaf paths are:

 ["1->2->5", "1->3"]
 * Created by ritesh on 8/9/17.
 */
public class BinaryTreePath {

    public static void main(String args[]) {

        TreeNode root = new TreeNode();

        List<String> res = new ArrayList<>();

        printPaths(root,"",res);

        for(String out : res) {
            System.out.println(out);
        }
    }

    private static void printPaths(TreeNode root, final String path, final List<String> res) {

        if(root.left == null && root.right == null) {
            res.add(path);
        }

        if(root.left!=null) {
            printPaths(root.left,path+root.value+"->",res);
        }

        if(root.right!=null) {
            printPaths(root.right,path+root.value+"->",res);
        }
    }

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
    }
}
