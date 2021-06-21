package leetcode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/submissions/
 * @author minibig
 *
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class LeetCode83 {

	public ListNode deleteDuplicates(ListNode head) {
		
		if(head == null) return head;
	        
        int val = head.val;
        ListNode nextNode = head;
        while(nextNode.next != null){
            if(val == nextNode.next.val){
            	nextNode.next = nextNode.next.next;
            }else{
                val = nextNode.next.val;
                nextNode = nextNode.next;
            }
        }
        return head;
    }
}
