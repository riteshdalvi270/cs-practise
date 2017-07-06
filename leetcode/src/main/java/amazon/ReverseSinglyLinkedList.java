package amazon;

/**
 * Reverse a singly linked list.
 * @author Ritesh Dalvi (rd026600).
 */
public class ReverseSinglyLinkedList
{
    public static void main(String args[])
    {
        final ListNode node = new ListNode(34);

        reverseLinkedList(node);
    }

    private static void reverseLinkedList(final ListNode head)
    {
        ListNode end = head;

        while (end.next != null)
        {
            end = end.next;
        }

        ListNode first = head;
        ListNode last = end;

        while (first.next != last)
        {

            exchange(first, last);
            first = first.next;

            ListNode runner = first;

            while (runner.next != last)
            {
                runner = runner.next;
            }

            last = runner;
        }

        exchange(first, last);
    }

    private static void exchange(ListNode first, ListNode last)
    {
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
    }

    static class ListNode
    {
        int val;
        ListNode next;

        public ListNode(int val)
        {
            this.val = val;
        }
    }
}
