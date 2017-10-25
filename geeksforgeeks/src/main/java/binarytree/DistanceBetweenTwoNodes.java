package binarytree;

import java.util.List;

/**
 * @author Ritesh Dalvi
 **/
public class DistanceBetweenTwoNodes {

    public static void main(String args[]) {

        final Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left =  new Node(6);
        root.right.right = new Node(7);

        root.right.left.right = new Node(8);

        System.out.println(distanceBetweenNodes(root,4,8));
    }

    private static int distanceBetweenNodes(Node root, int node1, int node2) {

        int count = 0;

        int level1 = getLevel(root,node1,count);

        int level2 = getLevel(root,node2,count);

        // if one of the node is the root, subtract level
        // if node1 and node 2 lie in the same level and same root parent (not the root), then return the level
        // if node1 and node2 lie in the same level but different root parent (the root passed), then add.
        // if node1 and node2 lie in the different level then add.

        Node rootToCompare1 = determineTheRoot(root,node1);
        Node rootToCompare2 = determineTheRoot(root,node2);



        if(rootToCompare1.val == node1 || rootToCompare1.val == node2 || rootToCompare2.val == node1 || rootToCompare2.val == node2) {
            return Math.abs(level1-level2);
        }

        if(level1 == level2) {

            if (rootToCompare1.val != rootToCompare2.val) {
                return level1+ level2;
            }else {
                return level1;
            }
        }else {
            return level1 + level2;
        }
    }

    private static int getLevel(Node root, int node, int count) {

        if(root == null) {
            return -1;
        }

        if(root.val ==  node) {
            return count;
        }

        int leftlevel = getLevel(root.left,node,count+1);

        if(leftlevel!=-1) {
            return leftlevel;
        }

        return getLevel(root.right,node,count+1);
    }

    private static Node determineTheRoot(Node root, int node) {

        if(root == null) {
            return null;
        }

        if((root.left!=null && node == root.left.val) || (root.right!=null && node == root.right.val)) {
            return root;
        }

        Node leftRoot = determineTheRoot(root.left,node);

        if(leftRoot != null) {
            return leftRoot;
        }

        Node rightNode = determineTheRoot(root.right,node);

        if(rightNode != null) {
            return rightNode;
        }

        return null;
    }

    static class Node{

        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
            left = null;
            right = null;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
