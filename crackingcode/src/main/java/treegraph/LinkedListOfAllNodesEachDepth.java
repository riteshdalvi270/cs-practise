package treegraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Sum 4.2 page 109 cracking code 6th edition.
 * @author Ritesh Dalvi
 **/
public class LinkedListOfAllNodesEachDepth {

    public static void main(String args[]) {

        final Node node = new Node();

        final List<List<Node>> temp = new ArrayList<List<Node>>();

        linkedListOfLevels(node,0,temp);
    }

    private static void linkedListOfLevels(Node root,int level, List<List<Node>> temp) {

        if(root == null) {
            return;
        }

        if(temp.get(level)!=null) {
            List<Node> list = temp.get(level);
            list.add(root);
            temp.add(level, list);
        }else {
            final List<Node> list = new ArrayList<Node>();
            list.add(root);
            temp.add(level,list);
        }

        linkedListOfLevels(root.left,level + 1, temp);

        linkedListOfLevels(root.right,level + 1, temp);
    }

    static class Node {
        int value;
        Node left;
        Node right;
    }
}
