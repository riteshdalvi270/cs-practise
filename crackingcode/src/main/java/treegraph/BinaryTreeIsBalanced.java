package treegraph;

/**
 * Determine if Binary tree is balanced.
 * @author Ritesh Dalvi
 **/
public class BinaryTreeIsBalanced {

    public static void main(String args[]) {

        final Node root = new Node();

        isTreeBalanced(root);
    }

    private static boolean isTreeBalanced(final Node root) {

        if(root == null) {

        }

        int left = getHeight(root.left);

        int right = getHeight(root.right);

        if(Math.abs(left-right) > 1) {
            return false;
        }

        return isTreeBalanced(root.left) || isTreeBalanced(root.right);
    }

    private static int getHeight(final Node node) {

        if(node == null) {
            return 0;
        }

        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    static class Node {

        int value;
        Node left;
        Node right;
    }
}
