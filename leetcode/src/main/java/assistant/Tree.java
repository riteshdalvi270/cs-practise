package assistant;

/**
 * Created by ritesh on 12/20/15.
 */
public class Tree {

    public int data;
    public Tree left;
    public Tree right;
    public Tree parent;

    public Tree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public int getData() {
        return data;
    }
}
