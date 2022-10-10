package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/generate-parentheses/
 * @author minibig
 */
public class LeetCode22 {
	
	public List<String> generateParenthesis(int n) {
		
		List<String> strList = new ArrayList<String>();
		strList.add("");
		
		return generate(strList, n);
	}
	
	public List<String> generate(List<String> strList, int n) {
		
		List<String> list = new ArrayList<String>();
		
		if(n == 1) {
			list.add("()");
			return list;
		}else {
			for(int i = 1 ; i < n; i++) {
				for(String str1 : generate(strList, n-i)) {
					if(i == 1) {
						list.add("(" + str1 + ")");
					}
					for(String str2 : generate(strList, i)) {
						list.add(str1 + str2);
					}
				}
			}
		}
		
		return list.stream().distinct().collect(Collectors.toList());
	}
}
