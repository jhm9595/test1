package leetcode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 
 * @author minibig
 *
 */
public class LeetCode19 {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		
		ListNode answer = new ListNode(-1, head);
		
		ListNode curNode = answer;
		
		// Count total number of list nodes
		int totCnt = 0;
		while(curNode.next != null) {
			totCnt++;
			curNode = curNode.next;
		}
		
		ListNode prevNode = answer;
		
		// Find the nth nodes and remove it
		int curCnt = 0;
		while(prevNode != null) {
			
			curNode = prevNode.next;
			
			if(totCnt - curCnt++ == n) {
				prevNode.next = curNode.next;
				return answer.next;
			}
			
			prevNode = curNode;
		}

		return null;
	}
}
