package leetcode;

import common.CommonUtils;

public class LeetCode1_4 {

	public static void main(String[] args) {
		
//		int arr[] = new int[] { 10, 400, 50, 100, 1000, 800 };
		
		int arr[] = new int[] { 10, 400, 50, 100, 1000, 800 };
		
		int targetSum = 1010;

		int[] sortedArr = CommonUtils.mergeSort(arr); // O(nlogn)
		
		CommonUtils.printArray(sortedArr);
		
		CommonUtils.printArray(_binarySearch(sortedArr, targetSum)); // n * O(n)
		
	}

	private static int[] _binarySearch(int[] sortedArr, int targetSum) {

		for(int i = 0 ; i < sortedArr.length; i++) {
			
			int assume_the_first_one = sortedArr[i];
			
			int target = targetSum - assume_the_first_one;
			
			int left = i + 1;
			int right = sortedArr.length - 1;
			int mid = (left + right) / 2;
			
			while(sortedArr[mid] != target && right - left > 1) {
				System.out.println("i : " + i);	
				System.out.println("left : " + left);
				System.out.println("right : " + right);
				System.out.println("mid : " + mid);
				System.out.println("target : " + target);
				System.out.println("sortedArr[mid] : " + sortedArr[mid]);
				System.out.println("=================================");
				
				if(target < sortedArr[mid]) {
					right = mid;
					mid = (left + right) / 2;
				}else if(sortedArr[mid] < target) {
					left = mid;
					mid = (left + right) / 2;
				}
				
				// when target is the last one, mid cannot be right.
				if(right - left == 1 && sortedArr[right] == target) {
					return new int[] {i, right};
				}
				
			}

			if(sortedArr[mid] == target) {
				return new int[] {i, mid};
			}
		}
		
		return null;
	}
}
