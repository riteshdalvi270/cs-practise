package amazon;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Serialize and deserialize binary tree
 * Created by ritesh on 7/4/17.
 */
public class SerializeDeSerializeBinaryTree {

    public static void main(String args[]) {

    }

    private static String serializeBinaryTree(final BinaryTree root) {

        if(root == null) {
            return "";
        }

        final Queue<BinaryTree> queue = new ArrayDeque<BinaryTree>();

        queue.add(root);

        final StringBuilder stringBuilder = new StringBuilder();
        
        while(!queue.isEmpty()) {

            BinaryTree left = root.left;

            if(left!=null) {
                stringBuilder.append()
            }
        }

    }

    private static BinaryTree deserializeBinaryTree() {

    }


    class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;
    }
}
