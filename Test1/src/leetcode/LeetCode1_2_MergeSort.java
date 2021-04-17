package leetcode;

public class LeetCode1_2_MergeSort {

	public static void main(String[] args) {

		// let it be for find index later
		int problem[] = new int[] { 6, 5, 3, 1, 8, 7, 2, 4 };

		// Copy new one for sorting.
		int copy[] = new int[8];

		// Copying...
		for (int i = 0; i < problem.length; i++) {
			copy[i] = problem[i];
		}

		divideIntoHalves(copy);
	}

	private static int[] divideIntoHalves(int[] copy) {

		if (copy.length == 1)
			return copy;

		// find middle index for division.
		int mdlIdx = copy.length / 2;

		System.out.println("mdlIdx : " + mdlIdx);
		System.out.println("copy.length- mdlIdx : " + (copy.length - mdlIdx));

		// divide into halves.
		int left[] = new int[mdlIdx];
		int right[] = new int[copy.length - mdlIdx];

		int result[] = new int[] {};

		// set left and right data
		for (int i = 0; i < copy.length; i++) {
			System.out.println("i: " + i);
			if (i < mdlIdx) {
				System.out.println("left copy[i] : " + copy[i]);
				left[i] = copy[i];
			} else {
				System.out.println("right copy[i] : " + copy[i]);
				right[i - mdlIdx] = copy[i];
			}
		}

		System.out.println("left");
		int[] leftResult = divideIntoHalves(left);

		for (int j = 0; j < leftResult.length; j++) {
			System.out.println("leftResult" + "[" + j + "]" + " : " + leftResult[j]);
		}

		System.out.println("right");
		int[] rightResult = divideIntoHalves(right);

		for (int j = 0; j < rightResult.length; j++) {
			System.out.println("rightResult" + "[" + j + "]" + " : " + rightResult[j]);
		}

		result = combine(leftResult, rightResult);

		for (int i = 0; i < result.length; i++) {
			System.out.println("result : " + result[i]);
		}

		return result;
	}

	private static int[] combine(int[] leftResult, int[] rightResult) {

		System.out.println("=============================================");
		System.out.println("leftResult.length : " + leftResult.length);
		System.out.println("rightResult.length : " + rightResult.length);

		int totalLength = leftResult.length + rightResult.length;
		System.out.println("totalLength : " + totalLength);

		int newArr[] = new int[totalLength];

		int baseNumber = 0, j = 0, k = 0;
		for(int i = 0; i < totalLength; i++) {
			if(i == 0) {
				if(leftResult[j] < rightResult[k]) {
					newArr[i] = leftResult[j++];
				}else {
					newArr[i] = rightResult[k++];
				}
			}else {
				if(j == leftResult.length) {
					baseNumber = newArr[i-1];
					if(baseNumber < rightResult[k]) {
						newArr[i] = rightResult[k++];
					}
				}else if(k == rightResult.length){
					baseNumber = newArr[i-1];
					if(baseNumber < leftResult[j]) {
						newArr[i] = leftResult[j++];
					}
				}else {
					if(leftResult[j] < rightResult[k]) {
						newArr[i] = leftResult[j++];
					}else {
						newArr[i] = rightResult[k++];
					}
				}
			}
		}

		for (int i = 0; i < newArr.length; i++) {
			System.out.println("newArr result : " + newArr[i]);
		}

		return newArr;
	}
}
