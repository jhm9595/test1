package leetcode;

import common.CommonUtils;

/**
 * https://leetcode.com/problems/duplicate-zeros/
 * @author minibig
 *
 */
public class LeetCode1089 {
	
	public static void main(String[] args) {
		int[] arr = 
					{8,4,5,0,0,0,0,7};
//					{1,0,2,3,0,4,5,0};
		duplicateZeros(arr);
	}

	public static void duplicateZeros(int[] arr) {
	    
		int requiredZeroCnt = 0;
		int cutYn = 0; 
		for(int i = 0 ; i < arr.length; i++) {
			if(arr[i] == 0 && ((i + 1) + requiredZeroCnt) <= arr.length) {
				System.out.println("i : " + i);
				System.out.println("requiredZeroCnt : " + requiredZeroCnt);
				if(((i + 1) + requiredZeroCnt) == arr.length) {
					System.out.println("i2 : " + i);
					arr[arr.length - 1] = 0;
					cutYn = -1;
					break;
				}
				requiredZeroCnt++;
			}
		}
		
		System.out.println("requiredZeroCnt : " + requiredZeroCnt);
		
		System.out.println("cutYn : " + cutYn);
		
		int rightIdx = arr.length - 1 + cutYn - requiredZeroCnt;
		
		System.out.println("rightIdx : " + rightIdx);
		
		for(int i = rightIdx; i >= 0; i--) {
			if(arr[i] != 0) {
				arr[i + requiredZeroCnt] = arr[i];
			}else {
 				arr[i + requiredZeroCnt] = 0;
 				requiredZeroCnt--;
 				arr[i + requiredZeroCnt] = 0;
			}
		}
		CommonUtils.printArray(arr);
	}    
}