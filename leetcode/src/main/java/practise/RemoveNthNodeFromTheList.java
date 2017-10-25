package practise;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * <p>
 * For example,
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 * @author Ritesh Dalvi (rd026600).
 */
public class RemoveNthNodeFromTheList {

    public static void main(String args[]) {

        final ListNode listNode = new ListNode();

        removeNthNode(listNode, 2);
    }

    private static ListNode removeNthNode(ListNode head, int n) {

        if(n == 1) {
            head = head.next;
            return head;
        }

        int count = 0;

        ListNode runner = head;

        while (runner != null) {

            runner = runner.next;
            count = count + 1;
        }

        int diff = Math.abs(count - n);

        runner = head;

        while (diff != 0) {

            runner = runner.next;
        }

        if (runner == null) {
            return head;
        }

        if (runner.next == null) {
            return head;
        }

        if (runner.next != null) {

            if (runner.next.next != null) {

                runner.next = runner.next.next;
            }

            runner.next = null;
        }

        return head;
    }

    static class ListNode {
        int val;
        ListNode next;
    }
}
