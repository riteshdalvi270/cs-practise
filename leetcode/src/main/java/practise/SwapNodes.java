package practise;

public class SwapNodes {

	public static void main(String args[]) {
		
		
	}
	
	// wrong
	private static ListNode swapPairs(ListNode head) {
        
	    ListNode dummy = head;
		
		ListNode current = head;
		ListNode second = null;
		while(current!=null && current.next!=null && current.next.next!=null) {
			
			ListNode first = current.next;
		    second = current.next.next;
			
			current = first.next;
			current.next = second.next;
			second.next = current.next.next;
			second = current.next.next;
			
		}
		
		dummy = second;
		
		return dummy;
    }
	
	class ListNode {
		
		int val;
		ListNode next;
		
		
		public ListNode(int val) {
			this.val=val;
			this.next = null;
		}
		
		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
