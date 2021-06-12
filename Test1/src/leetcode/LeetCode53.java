package leetcode;

/**
 * https://leetcode.com/problems/maximum-subarray/submissions/
 * 
 * @author minibig
 *
 */
public class LeetCode53 {

	public int maxSubArray(int[] nums) {

		int maxSum = Integer.MIN_VALUE;

		int[] pattern = new int[nums.length];

		int tmpSum = 0;

		for (int i = 0; i < nums.length; i++) {

			tmpSum = tmpSum + nums[i];

			pattern[i] = tmpSum;

			if (tmpSum > maxSum) {
				maxSum = tmpSum;
			}
		}

		int minusIdx;
		for (int i = 1; i < pattern.length; i++) {

			minusIdx = 0;
			tmpSum = 0;
			while (minusIdx < i) {

				tmpSum = pattern[i] - pattern[minusIdx];

				if (tmpSum > maxSum) {
					maxSum = tmpSum;
				}
				minusIdx++;
			}
		}

		return maxSum;
	}
}