package leetcode;

/**
 * https://leetcode.com/problems/search-insert-position/submissions/
 * @author minibig
 *
 */
public class LeetCode35 {
	
	public int searchInsert(int[] nums, int target) {
        
        int l = 0;
        int r = nums.length;
        int mid = 0;
        
        while(l < r){
            
            mid = (l + r) / 2;
            
            if(nums[mid] < target){
                l = mid + 1;
            }else if(nums[mid] > target){
                r = mid;
            }else{
                return mid;
            }
        }
        return l;
    }

}
