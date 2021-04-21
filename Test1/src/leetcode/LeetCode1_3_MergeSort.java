package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1_3_MergeSort {

	public static void main(String[] args) {

		int arr[] = new int[] { 11, 7, 2, 15 };
		
//		int arr[] = new int[] { 6,5,3,1,8,7,2,4};

		int target = 9;

		Element element = null;
		List<Element> elementList = new ArrayList<Element>();
		for (int i = 0; i < arr.length; i++) {
			element = new Element();
			element.index = i;
			element.value = arr[i];
			elementList.add(element);
		}

		List<Element> sortedList = mergeSort(elementList, 0, elementList.size());
		
		int count = 0;
		for(Element item : sortedList) {
			System.out.println("item[" + count++ +"] : "+ item.value  + "(" + item.index + ")");
		}
		
//		int[] sorted = mergeSort(arr, 0, arr.length);
//		
//		for(int i = 0; i < sorted.length; i++){
//			System.out.println("sorted[" + i+"] : " + sorted[i]);
//		}
		
		
		
	}

	private static List<Element> mergeSort(List<Element> elementList, int begin, int end) {
		
		if(elementList.size() <=1) {
			
			return elementList;
		}
		
		int mid = (begin + end) / 2;
		
		List<Element> leftList = new ArrayList<Element>();
		List<Element> rightList = new ArrayList<Element>();
		
		for(int i = 0; i < elementList.size(); i++) {
			if(i < mid) {
				leftList.add(elementList.get(i));
			}else {
				rightList.add(elementList.get(i));
			}
		}
		
		return combine(mergeSort(leftList, 0, mid), mergeSort(rightList, 0, end - mid));
	}
	
	private static List<Element> combine(List<Element> a, List<Element> b){
		
		List<Element> sortedList = new ArrayList<Element>();
		int totalSize = a.size() + b.size();
		for(int i = 0; i < totalSize; i++) {
			if(a.size() != 0 && b.size() != 0) {
				if(a.get(0).value < b.get(0).value) {
					sortedList.add(a.get(0));
					a.remove(0);
				}else {
					sortedList.add(b.get(0));
					b.remove(0);
				}
			}else {
				if(a.size() == 0) {
					sortedList.add(b.get(0));
					b.remove(0);
				}else if(b.size() == 0) {
					sortedList.add(a.get(0));
					a.remove(0);
				}
			}
		}
		
		return sortedList;
	}
	
	private static int[] mergeSort(int[] arr, int begin, int end) {
		
		if(arr.length == 1) {
			return arr;
		}
		
		int mid = (begin + end) / 2;
		
		int[] leftArr = new int[mid];
		int[] rightArr = new int[end - mid];
		for(int i = 0; i < arr.length; i++) {
			if(i < mid) {
				leftArr[i] = arr[i];
			}else {
				rightArr[i - mid] = arr[i];
			}
		}
		
		return combine(mergeSort(leftArr, 0, mid), mergeSort(rightArr, 0, end- mid));
	}
	
	private static int[] combine(int[] a, int[] b) {
		
		for(int i = 0; i < a.length; i++){
			System.out.println("a[" + i+"] : " + a[i]);
		}
		
		for(int i = 0; i < b.length; i++){
			System.out.println("b[" + i+"] : " + b[i]);
		}
		
		System.out.println("==============================");
		
		int totalLength = a.length + b.length;
		
		int[] sortedArr = new int[totalLength];
		
		int aIdx = 0;
		int bIdx = 0;
		for(int i = 0; i < totalLength; i++) {
			if(aIdx != a.length && bIdx != b.length) {
				if(a[aIdx] < b[bIdx]) {
					sortedArr[i] = a[aIdx++];
				}else {
					sortedArr[i] = b[bIdx++];
				}
			}else if(aIdx == a.length) { // a가 다 없을 때 
				sortedArr[i] = b[bIdx++];
			}else if(bIdx == b.length) { // b가 다 없을 
				sortedArr[i] = a[aIdx++];
			}
		}
		
		return sortedArr;
	}
}

class Element {
	int index;
	int value;
}
