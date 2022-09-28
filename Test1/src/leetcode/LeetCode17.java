package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * @author minibig
 */
public class LeetCode17 {

	public List<String> letterCombinations(String digits) {
		
		List<String> list = new ArrayList<String>();
		
		if(digits.isEmpty()) return list;
		
		Map<Integer, String> digitMap = new HashMap<Integer, String>();
		
		digitMap.put(2, "abc");
		digitMap.put(3, "def");
		digitMap.put(4, "ghi");
		digitMap.put(5, "jkl");
		digitMap.put(6, "mno");
		digitMap.put(7, "pqrs");
		digitMap.put(8, "tuv");
		digitMap.put(9, "wxyz");
		
		int digitsLength = digits.length();
		
		String[] str = new String[digitsLength];
		
		int loop = 1;
		for(int i = 0; i < digits.length(); i++) {
			str[i] = digitMap.get(Integer.valueOf(String.valueOf(digits.charAt(i))));
			loop *= str[i].length();
		}
		
		String item = null;
		
		loop--;
		
		while (loop >= 0) {
			
			item = "";
			
			int rest = loop;
			
			for(int i = 0; i < str.length; i++) {
				
				int strLen = str[i].length();
				
				if(rest % strLen == 0) {
					item += str[i].charAt(strLen - 1);
					rest = rest / strLen;
				}else {
					item += str[i].charAt(rest % strLen - 1);
					rest = (rest - (rest % strLen)) / strLen;
				}
			}
			
			list.add(item);
			loop--;
		}
		
		return list;
	}
}
