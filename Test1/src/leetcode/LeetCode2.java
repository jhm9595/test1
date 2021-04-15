package leetcode;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * @author minibig
 *
 */
public class LeetCode2 {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		int sum = l1.val + l2.val;

		if (sum == 0 && l1.next == null && l2.next == null) {
			return new ListNode(0);
		}
		return calculate(l1, l2, 0);
	}

	private ListNode calculate(ListNode l1, ListNode l2, int upNoParam) {

		if (l1 == null && l2 == null) {
			return null;
		}

		int val1 = l1 != null ? l1.val : 0;
		int val2 = l2 != null ? l2.val : 0;

		int sum = val1 + val2 + upNoParam;
		if (sum == 0 && l1.next == null && l2.next == null) {
			return null;
		}
		int rest = sum % 10;
		int upNo = sum / 10;

		ListNode l3 = l1.next == null ? new ListNode(0) : l1.next;
		ListNode l4 = l2.next == null ? new ListNode(0) : l2.next;

		return getListNode(rest, calculate(l3, l4, upNo));

	}

	private ListNode getListNode(int rest, ListNode listNode) {
		if (listNode == null) {
			return getListNode(rest);
		}
		return new ListNode(rest, listNode);
	}

	private ListNode getListNode(int rest) {
		if (rest == 0) {
			return null;
		} else {
			return new ListNode(rest);
		}

	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
