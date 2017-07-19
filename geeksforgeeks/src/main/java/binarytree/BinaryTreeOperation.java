package binarytree;

/**
 * Created by ritesh on 7/18/17.
 */
public class BinaryTreeOperation {

    public static void main(String args[]) {

        int[] data = new int[]{2,3,4,5,6,7,8};

        Tree tree = createBinaryTree(data,0,data.length-1);

        inorderTraversal(tree);

        tree = insert(tree,20);
        tree = insert(tree, 23);

        System.out.println("After Insert");

        inorderTraversal(tree);

        System.out.println(search(tree, 6));
        System.out.println(search(tree, 23));
        System.out.println(search(tree, 19));

        delete(tree,20);
        delete(tree,5);
        delete(tree,19);

        inorderTraversal(tree);
    }

    private static Tree createBinaryTree(int[]data, int start, int end) {

        if(start >  end) {
            return null;
        }

        int mid = (start+end)/2;

        final Tree firstTree = createBinaryTree(data,start,mid-1);
        final Tree secondTree = createBinaryTree(data,mid+1,end);

        Tree root = new Tree(data[mid]);

        if(firstTree!=null) {

            if(firstTree.value <= root.value) {
                root.left = firstTree;
            }else {
                root.right = firstTree;
            }
        }

        if(secondTree!=null) {

            if(secondTree.value <= root.value) {
                root.left = secondTree;
            }else {
                root.right = secondTree;
            }
        }

        return root;
    }

    private static void inorderTraversal(final Tree root) {

        if(root==null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.println(root.value);
        inorderTraversal(root.right);
    }

    private static Tree insert(Tree root, int data) {

        if(root == null) {
            Tree newRoot = new Tree(data);

            return newRoot;
        }

        if(data <= root.value) {
            Tree leftRoot = insert(root.left,data);
            root.left = leftRoot;
        }else if(data > root.value) {
            Tree rightRoot = insert(root.right, data);
            root.right = rightRoot;
        }

        return root;
    }

    private static boolean search(Tree root, int data) {

        if(root == null) {
            return false;
        }

        if(root.value == data) {
            return true;
        }

        if(data <= root.value) {
            return search(root.left,data);
        }

        if(data >= root.value) {
           return search(root.right, data);
        }

        return false;
    }

    private static Tree delete(Tree root, int data) {

        // 1. node being deleted is root node.
        // 2. node being deleted has one child
        // 3. node being deleted has two children.

    }

    static class Tree {
        int value;
        Tree left;
        Tree right;

        public Tree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
