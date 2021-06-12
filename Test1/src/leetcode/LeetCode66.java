package leetcode;

/**
 * https://leetcode.com/problems/plus-one/
 * 
 * @author minibig
 */
public class LeetCode66 {

	public int[] plusOne(int[] digits) {

		int carry = 1;
		int sum = 0;
		for (int i = digits.length - 1; i >= 0; i--) {
			sum = digits[i] + carry;
			if (sum == 10) {
				carry = 1;
				digits[i] = 0;
			} else {
				carry = 0;
				digits[i] = sum;
			}
		}

		int answer[] = null;
		if (carry == 1) {
			answer = new int[digits.length + 1];
			answer[0] = carry;
			for (int i = 0; i < digits.length; i++) {
				answer[i + 1] = digits[i];
			}
		} else {
			answer = digits;
		}

		return answer;
	}
}
