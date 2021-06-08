package leetcode;

/**
 * https://leetcode.com/problems/implement-strstr/submissions/
 * 
 * @author minibig
 *
 */
public class LeetCode28 {

	public int strStr(String haystack, String needle) {

		return kmp(haystack, needle);
	}

	private int[] getPattern(String needle) {

		int len = needle.length();
		int[] pattern = new int[len];
		int j = 0;
		for (int i = 1; i < len; i++) {
			while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
				j = pattern[j - 1];
			}

			if (needle.charAt(i) == needle.charAt(j)) {
				pattern[i] = ++j;
			}
		}
		return pattern;
	}

	private int kmp(String haystack, String needle) {

		int len = haystack.length();
		int j = 0;
		int[] pattern = getPattern(needle);

		for (int i = 1; i < len; i++) {
			while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
				j = pattern[j - 1];
			}

			if (haystack.charAt(i) == needle.charAt(j)) {
				if (j == len - 1) {
					return i - len + 1;
				} else {
					j++;
				}
			}
		}

		return -1;
	}
}
