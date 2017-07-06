package amazon;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Serialize and deserialize binary tree
 * Created by ritesh on 7/4/17.
 */

public class SerializeDeSerializeBinaryTree {

    public static void main(String args[]) {

        TreeNode node = new TreeNode(1);

        final String searlized = serializeBinaryTree(node);

        System.out.print(searlized);

        TreeNode ot = deserializeBinaryTree(searlized);
        System.out.print(ot.value);
    }

    private static String serializeBinaryTree(final TreeNode root) {

        if(root == null) {
            return "";
        }

        final Queue<TreeNode> queue = new ArrayDeque<TreeNode>();

        queue.add(root);

        final StringBuilder stringBuilder = new StringBuilder();
        
        while(!queue.isEmpty()) {

            final TreeNode node = queue.remove();

            if(node!=null) {
                stringBuilder.append(node.value);
                stringBuilder.append(",");

                if(node.left!=null) {
                    queue.add(node.left);
                }else {
                    stringBuilder.append("null");
                    stringBuilder.append(",");
                }

                if(node.right!=null) {
                    queue.add(node.right);
                }else {
                    stringBuilder.append("null");
                    stringBuilder.append(",");
                }

            }
        }

        stringBuilder.deleteCharAt(stringBuilder.length()-1);

        return stringBuilder.toString();
    }

    private static TreeNode deserializeBinaryTree(final String value) {

        final String[] split = value.split(",");

        final TreeNode node = new TreeNode(Integer.valueOf(split[0]));

        final Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);

        int i = 1;

        if(!queue.isEmpty()) {

            if(i==split.length) {
                return node;
            }

            TreeNode queueNode = queue.remove();

            if(!"null".equals(split[i])) {

                queueNode.left = new TreeNode(Integer.valueOf(split[i]));
                queue.add(queueNode.left);
                i++;
            }else {
                queueNode.left = null;
                i++;
            }

            if(!"null".equals(split[i])) {

                queueNode.right = new TreeNode(Integer.valueOf(split[i]));
                queue.add(queueNode.right);
                i++;
            }else {

                queueNode.right = null;
                i++;
            }
        }

        return node;
    }


    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right=null;
        }
    }
}

