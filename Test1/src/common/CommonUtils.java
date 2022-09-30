package common;

import java.util.List;

public class CommonUtils {
	
	public static void print2thArray(int[][] arr) {
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < arr.length; i++) {
			sb.append("[");
			for(int j = 0; j < arr[i].length; j++) {
				sb.append(arr[i][j]).append(", \t");
			}
			sb.deleteCharAt(sb.lastIndexOf(","));
			sb.append("]\n");
		}
		System.out.println(sb.toString());
	}


	public static void printArray(int[] arr) {
		
		printArray(arr, new StringBuilder());
	}

	public static void printArray(int[] arr, StringBuilder sb) {
		
		sb.append('[');
		for(int i = 0; i < arr.length; i++) {
			sb.append(arr[i]).append(',');
		}
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.append(']');
		System.out.println(sb.toString());
		System.out.println("========================");
		
	}
	
	public static void printArray(String[] arr) {
		
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for(int i = 0; i < arr.length; i++) {
			sb.append(arr[i]).append(',');
		}
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.append(']');
		System.out.println(sb.toString());
		System.out.println("========================");
	}
	
	public static void printArray(List<Integer> list) {
		
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for(int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append(',');
		}
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.append(']');
		System.out.println(sb.toString());
		System.out.println("========================");
	}
	
	public static void printStringArray(List<String> list) {
		
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for(int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append(',');
		}
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.append(']');
		System.out.println(sb.toString());
		System.out.println("========================");
	}

	public static int[] mergeSort(int[] arr) {
		
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
		
		return merge(mergeSort(left), mergeSort(right));
	}

	public static int[] merge(int[] left, int[] right) {
		
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
