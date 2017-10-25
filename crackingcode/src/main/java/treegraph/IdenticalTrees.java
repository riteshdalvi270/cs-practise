package treegraph;

/**
 * @author Ritesh Dalvi (rd026600).
 */
public class IdenticalTrees {

    public static void main(String args[]) {

        final Node t1 = new Node(1);
        t1.left = new Node(2);
        t1.right = new Node(3);
        t1.left.left = new Node(4);
        t1.left.right = new Node(5);

        final Node t2 = new Node(2);
        t2.left = new Node(4);
        t2.right = new Node(5);

        System.out.println(identicalNodes(t1, t2));
    }

    private static boolean identicalNodes(final Node t1, final Node t2) {

        if (t1 == null && t2 == null) {
            return true;
        }

        if (t1 == null || t2 == null) {
            return false;
        }

        boolean isIdentical = false;

        if (t1.val == t2.val) {

            isIdentical = isIdentical(t1, t2);
        }

        if (isIdentical) {
            return true;
        }

        return identicalNodes(t1.left, t2) || isIdentical(t1.right, t2);
    }

    private static boolean isIdentical(final Node t1, final Node t2) {

        if (t1 == null && t2 == null) {
            return true;
        }

        if (t1 == null || t2 == null) {
            return false;
        }

        if (t1.val == t2.val) {
            return isIdentical(t1.left, t2.left) && isIdentical(t1.right, t2.right);
        } else {
            return false;
        }
    }

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }
}
