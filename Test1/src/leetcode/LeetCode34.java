package leetcode;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/ 
 * @author minibig
 */
public class LeetCode34 {
	
    public int[] searchRange(int[] nums, int target) {
        int[] answer = new int[] {-1,-1};
        if(nums.length == 0){
            return answer;
        }
        
        int l = 0;
        int r = nums.length - 1;
        
        int midIdx = (l + r) / 2;
        
        while(l < r){
        	int midVal = nums[midIdx];
        	
        	if(midVal < target) {
        		l = midIdx + 1;
        	}else if(midVal > target) {
        		r = midIdx - 1;
        	}else {
        		break;
        	}

        	midIdx = (l + r) / 2;
        }
        
        int minIdx = -1;
		for(int i = midIdx; i >= 0; i--) {
			if(nums[i] == target) {
				minIdx = i;
			}else {
				break;
			}
		}
		
		int maxIdx = -1;
		for(int i = midIdx; i < nums.length; i++) {
			if(nums[i] == target) {
				maxIdx = i;
			}else {
				break;
			}
		}
		
		answer[0] = minIdx;
		answer[1] = maxIdx;
		
        return answer;
    }
}
