package treegraph;

/**
 * @author Ritesh Dalvi
 **/
public class DepthOfBinaryTree {

    public static void main(String args[]) {

        final Node node = new Node();

        System.out.println(maxDepthOfBinaryTree(node));
    }

    private static int maxDepthOfBinaryTree(final Node root) {

        if(root == null) {
            return -1;
        }

        int leftHeight = getHeight(root.left);

        int rightHeight = getHeight(root.right);

        return Math.max(leftHeight,rightHeight);
    }

    private static int getHeight(final Node root) {

        if(root == null) {
            return 0;
        }

        return Math.max(getHeight(root.left),getHeight(root.right)) + 1;
    }

    static class Node {
        int value;
        Node left;
        Node right;
    }
}
