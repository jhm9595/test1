package leetcode;

import common.CommonUtils;

public class BinarySearch {

	public static void main(String[] args) {
		
		int arr[] = new int[] {6,5,3,1,8,7,2,4,9};
		
		int target = 2;
		
		int[] mergedArr = _mergeSort(arr); // O(nlogn)
		
		CommonUtils.printArray(mergedArr);
		
		int targetIdx = _binarySearch(mergedArr, target); // O(n)
		
		System.out.println("targetIdx : " + targetIdx);
		
		targetIdx = _binarySearchJB(mergedArr, 9); // O(n)
		System.out.println("targetIdx : " + targetIdx);
		targetIdx = _binarySearchJB(mergedArr, 8); // O(n)
		System.out.println("targetIdx : " + targetIdx);
		targetIdx = _binarySearchJB(mergedArr, 7); // O(n)
		System.out.println("targetIdx : " + targetIdx);
		targetIdx = _binarySearchJB(mergedArr, 6); // O(n)
		System.out.println("targetIdx : " + targetIdx);
		targetIdx = _binarySearchJB(mergedArr, 5); // O(n)
		System.out.println("targetIdx : " + targetIdx);
		targetIdx = _binarySearchJB(mergedArr, 4); // O(n)
		System.out.println("targetIdx : " + targetIdx);
		targetIdx = _binarySearchJB(mergedArr, 3); // O(n)
		System.out.println("targetIdx : " + targetIdx);
		targetIdx = _binarySearchJB(mergedArr, 2); // O(n)
		System.out.println("targetIdx : " + targetIdx);
		targetIdx = _binarySearchJB(mergedArr, 1); // O(n)
		System.out.println("targetIdx : " + targetIdx);
		
	}

	private static int _binarySearch(int[] mergedArr, int target) {
		
		int left = 0;
		int right = mergedArr.length - 1;
		
		int mid = mergedArr.length / 2;
		
		while(mergedArr[mid] != target) {
			
			int midVal = mergedArr[mid];

			if(midVal < target) {
				left = mid;
				mid = (left + right) / 2;
			}else if(midVal > target){
				right = mid;
				mid = (left + right) / 2;
			}
		}
		
		return mid;
	}
	
	private static int _binarySearchJB(int[] mergedArr, int target) {
		
		int l = 0, r = mergedArr.length-1;
		
		while(l < r) {
			
			int mid = l + ((r - l) / 2);
			
			if(mergedArr[mid] < target) {
				l = mid + 1;
			}else {
				r = mid;
			}
		}
		
		return l;
	}

	private static int[] _mergeSort(int[] arr) {
		
		if(arr.length == 1) {
			return arr;
		}
		
		int cnt = arr.length;
		
		int mid = cnt / 2;
		
		int[] left = new int[mid];
		int[] right = new int[cnt - mid];
		
		for(int i = 0 ; i < cnt; i++) {
			if(i < mid) {
				left[i] = arr[i];
			}else {
				right[i-mid] = arr[i];
			}
		}
		
		return _merge(_mergeSort(left), _mergeSort(right));
	}

	private static int[] _merge(int[] left, int[] right) {
		
		int leftLength = left.length;
		int rightLength = right.length;
		
		int[] mergedArr = new int[leftLength + rightLength];
		
		int mergedArrIdx = 0, leftIdx = 0, rightIdx = 0;
		
		while(leftIdx != leftLength && rightIdx != rightLength) {
			if(left[leftIdx] < right[rightIdx]) {
				mergedArr[mergedArrIdx++] = left[leftIdx++];
			}else {
				mergedArr[mergedArrIdx++] = right[rightIdx++];
			}
		}
		
		while(leftIdx != leftLength) {
			mergedArr[mergedArrIdx++] = left[leftIdx++];
		}
		
		while(rightIdx != rightLength) {
			mergedArr[mergedArrIdx++] = right[rightIdx++];
		}
		
		return mergedArr;
	}
}