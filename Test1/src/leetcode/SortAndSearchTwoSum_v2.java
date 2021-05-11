package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import commonclass.Elements;

public class SortAndSearchTwoSum_v2 {

	public static int[] twoSum(int[] nums, int target) {
		
		List<Elements> elementsList = new ArrayList<Elements>();
		
		for(int i = 0; i < nums.length; i++) {
			elementsList.add(new Elements(nums[i], i));
		}
		
		Collections.sort(elementsList);
		
		int r = elementsList.size() - 1;
		
		for(int i = 0 ; i < elementsList.size(); i++) {
			while(i < r) {
				if((elementsList.get(i).val + elementsList.get(r).val) > target) {
					r--;
				}else {
					break;
				}
			}
			
			if(elementsList.get(i).val + elementsList.get(r).val == target) {
				if(elementsList.get(i).index > elementsList.get(r).index){
					return new int[] {elementsList.get(r).index, elementsList.get(i).index};
				}else {
					return new int[] {elementsList.get(i).index, elementsList.get(r).index};
				}
			}
		}

		return null;
	}
}
