package leetcode;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class LeetCode21 {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		
		ListNode master = new ListNode();
		ListNode node = master;
		
		while(l1 != null && l2 != null) {
			node = node.next = new ListNode();
			if(l1.val < l2.val) {
				node.val = l1.val;
				l1 = l1.next;
			}else {
				node.val = l2.val;
				l2 = l2.next;
			}
		}
		
		while(l1 != null) {
			
			node = node.next = new ListNode();
			
			node.val = l1.val;
			l1 = l1.next;
		}
		
		while(l2 != null) {
			node = node.next = new ListNode();
			
			node.val = l2.val;
			l2 = l2.next;
		}
		
		return master.next;
    }
}
