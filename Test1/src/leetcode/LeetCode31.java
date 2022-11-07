package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/next-permutation/
 * @author jhm95
 */
public class LeetCode31 {

	public void nextPermutation(int[] nums) throws Exception{
		
		int[] copyNums;
		int[] partNums;
		
		boolean isReversed = true;
		for(int i = 0; i < nums.length - 1; i++) {
			copyNums = Arrays.copyOfRange(nums, nums.length - 2 - i, nums.length);
			
			partNums = copyNums.clone();
			Arrays.sort(partNums);
			
			isReversed = true;
			for(int j = nums.length - 2 - i, k=i+1; j < nums.length; j++,k--) {
				if(nums[j] != partNums[k]) {
					isReversed = false;
					break;
				}
			}
			
			if(isReversed) {
				continue;
			}else {
				_calNextPermutation(copyNums);
				
				for(int j = nums.length - 2 - i, k=0; j < nums.length; j++,k++) {
					nums[j] = copyNums[k];
				}
				
				break;
			}
		}
		
		if(isReversed) {
			Arrays.sort(nums);
		}
    }

	private void _calNextPermutation(int[] nums) {

        int[] copyNums = nums.clone();
        Arrays.sort(copyNums);
        int maxNum = copyNums[copyNums.length -1];
      	int[] sortNum = new int[maxNum+1];
      
      	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      	for(int i = 0; i < copyNums.length; i++) {
      		map.put(copyNums[i], i);
      		sortNum[copyNums[i]]++;
      	}
      	int[] tempSortNum;
      	
      	int len = nums.length;
      	while(!isSameArr(nums, copyNums)) {
      		int curIdx;
      		int lastIdx = len-1;
      		int carry = 1;
      		while(carry != 0) {
      			if(map.get(nums[lastIdx]) + carry < len){
      				curIdx = map.get(nums[lastIdx]) + carry;
      				carry = 0;
      				nums[lastIdx] = copyNums[curIdx];
      			}else {
      				curIdx = 0;
      				nums[lastIdx--] = copyNums[curIdx];
      				carry = 1;
      			}
      		}
      		
      		tempSortNum = new int[maxNum +1];
      		for(int t : nums) {
      			tempSortNum[t]++;
      		}
      		
      		boolean isSame = true;
      		
      		for(int i = 0; i < tempSortNum.length; i++) {
      			if(tempSortNum[i] != sortNum[i]) {
      				isSame = false;
      				break;
      			}
      		}
      		
      		if(isSame) {
      			return;
      		}
      	}
	}

	private boolean isSameArr(int[] nums, int[] reversecopyNum) {
		for(int i = 0, j = nums.length -1 ; i < nums.length; i++, j--) {
			if(nums[i] != reversecopyNum[j]) {
				return false;
			}
		}
		return true;
	}
}
