package leetcode;

/**
 * https://leetcode.com/problems/sqrtx/
 * @author minibig
 *
 */
public class LeetCode69 {

	public int mySqrt(int x) {
		
		if(x < 1) return 0;
		
		for(int i = 1; i < Integer.MAX_VALUE; i++) {
			if(i > x / i) {
				return i - 1;
			}else if(i == x/i){
				return i;
			}
		}
		
        return -1;
    }

}
