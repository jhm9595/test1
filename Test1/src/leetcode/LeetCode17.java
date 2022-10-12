package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 
 * @author minibig
 */
public class LeetCode17 {

	public List<String> letterCombinations(String digits) {

		List<String> list = new ArrayList<String>();

		if (digits.isEmpty()) {
			return list;
		}

		Map<Integer, String> digitMap = new HashMap<Integer, String>();

		digitMap.put(2, "abc");
		digitMap.put(3, "def");
		digitMap.put(4, "ghi");
		digitMap.put(5, "jkl");
		digitMap.put(6, "mno");
		digitMap.put(7, "pqrs");
		digitMap.put(8, "tuv");
		digitMap.put(9, "wxyz");
		
		list.add("");

		for (int i = 0; i < digits.length(); i++) {
			String words = digitMap.get(Integer.valueOf(String.valueOf(digits.charAt(i))));

			List<String> newList = new ArrayList<String>();
			for (String s : list) {
				for (char c : words.toCharArray()) {
					newList.add(s + c);
				}
			}
			list = newList;
		}

		return list;
	}
}
