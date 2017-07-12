package amazon;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

 According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

 _______6______
 /              \
 ___2__          ___8__
 /      \        /      \
 0      _4       7       9
 /  \
 3   5
 For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.


 * Created by ritesh on 7/12/17.
 */
public class LowestCommonAncestor {

    public static void main(String args[]) {


    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == p) {
            return p;
        }

        if(root == q) {
            return q;
        }

        boolean isPonLeft = isNodeOnLeft(root.left,p);
        boolean isQonLeft = isNodeOnLeft(root.left,q);

        if(isPonLeft && !isQonLeft) {
            return root;
        }else if(isPonLeft && isQonLeft) {
            return lowestCommonAncestor(root.left,p,q);
        }else if (!isPonLeft && !isQonLeft) {
            return lowestCommonAncestor(root.right,p,q);
        }

        return null;
    }

    private static boolean isNodeOnLeft(TreeNode root, TreeNode p) {

        if(root == p) {
            return true;
        }

        return isNodeOnLeft(root.left,p) || isNodeOnLeft(root.right,p);
    }


      static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
