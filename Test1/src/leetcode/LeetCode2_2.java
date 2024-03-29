package leetcode;

public class LeetCode2_2 {
	
	
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        
//		Input: l1 = [2,4,3], l2 = [5,6,4]
//		Output: [7,0,8]
//		Explanation: 342 + 465 = 807.
		
        final ListNode newListNode = new ListNode(0);
        
        ListNode listNode = newListNode;
        
        int sum, rest, carry = 0;
        
        ListNode nextL1 = l1;
        ListNode nextL2 = l2;
        
        do{
            if(nextL1 == null){
                nextL1 = new ListNode(0);
            }
            if(nextL2 == null){
                nextL2 = new ListNode(0);
            }
            if(listNode == null){
            	listNode = new ListNode(0);
            }
            
            sum = nextL1.val + nextL2.val + carry;
            rest = sum % 10;
            carry = sum / 10;
            
            listNode.val = rest;
            
            nextL1 = nextL1.next;
            nextL2 = nextL2.next;
            
            if(nextL1 != null || nextL2 != null || carry > 0) {
            	listNode.next = new ListNode(0);
            	listNode = listNode.next;
            }
            
        }while(nextL1 != null || nextL2 != null || carry > 0);
        
        
        return newListNode;
    }
    
}
