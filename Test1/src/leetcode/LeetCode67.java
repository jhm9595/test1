package leetcode;

public class LeetCode67 {

	public String addBinary(String a, String b) {
		
		StringBuilder sb = new StringBuilder();
		int a_digit = 0;
		int b_digit = 0;
		
		int a_idx = a.length() - 1;
		int b_idx = b.length() - 1;
		
		int carry = 0;
		while(a_idx >= 0 || b_idx >= 0) {
			
			a_digit = a_idx < 0 ? 0 : Integer.valueOf(a.substring(a_idx, a_idx+1));
			b_digit = b_idx < 0 ? 0 : Integer.valueOf(b.substring(b_idx, b_idx+1));
			
			int sum = a_digit + b_digit + carry;
			
			if(sum >= 2){
				carry = 1;
				sb.append(sum % 2);
			}else {
				carry = 0;
				sb.append(sum);
			}
			
			a_idx--;
			b_idx--;
		}
		
		if(carry == 1) {
			sb.append(carry);
		}
		
		return sb.reverse().toString();
    }

}
