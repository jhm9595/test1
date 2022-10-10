package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/generate-parentheses/
 * @author minibig
 */
public class LeetCode22 {
	
	private Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
	
	public List<String> generateParenthesis(int n) {
		
		List<String> strList = new ArrayList<String>();
		strList.add("");
		
		return generate(strList, n);
	}
	
	public List<String> generate(List<String> strList, int n) {
		
		if(map.get(n) != null) {
			return map.get(n);
		}
		
		List<String> list = new ArrayList<String>();
		
		if(n == 1) {
			list.add("()");
			map.put(1, list);
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
		
		map.put(n, list.stream().distinct().collect(Collectors.toList()));
		
		return map.get(n);
	}
}
