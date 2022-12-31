package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/multiply-strings/description/
 * @author minibig
 */
public class LeetCode43 {
	
	public String multiply(String num1, String num2) {
		
		if(num1.equals("0") || num2.equals("0")) {
			return "0";
		}

		Map<Integer, String> map = new HashMap<>();
		map.put(0, "0");
		
		for(int i = 1; i <= 9; i++) {
			map.put(i, add(map.get(i-1), num1));
		}
		
		String answer = "0";
		for(int i = num2.length()-1; i >= 0; i--) {
			answer = add(answer, map.get(Character.getNumericValue(num2.charAt(i))) + createZero(num2.length() - i));
		}
		return answer;
	}
	
	public String add(String num1, String num2) {
		
		if(num1.equals("0")) {
			return num2;
		}
		if(num2.equals("0")) {
			return num1;
		}
		
		int carry = 0;
		int len1 = num1.length() - 1;
		int len2 = num2.length() - 1;
		StringBuilder sb = new StringBuilder();
		int sum;
		while(len1 >= 0 && len2 >= 0) {
			sum = Character.getNumericValue(num1.charAt(len1--)) + Character.getNumericValue(num2.charAt(len2--)) + carry;
			sb.append(sum % 10);
			carry = sum >= 10 ? 1 : 0;
		}
		while(len1 >= 0) {
			sum = Character.getNumericValue(num1.charAt(len1--)) + carry;
			sb.append(sum % 10);
			carry = sum >= 10 ? 1 : 0;
		}
		while(len2 >= 0) {
			sum = Character.getNumericValue(num2.charAt(len2--)) + carry;
			sb.append(sum % 10);
			carry = sum >= 10 ? 1 : 0;
		}
		if(carry > 0) {
			sb.append(carry);
		}
		return sb.reverse().toString();
	}
	
	public String createZero(int idx) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < idx - 1; i++) {
			sb.append("0");
		}
		return sb.toString();
	}
}
