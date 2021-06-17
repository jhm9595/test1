package leetcode;

/**
 * https://leetcode.com/problems/climbing-stairs/
 * @author minibig
 *
 */
public class LeetCode70 {

	public int climbStairs(int n) {
        
        int[] history = new int[45];
        
        history[0] = 1;
        history[1] = 2;
        
        for(int i = 2; i <= n-1; i++){
            history[i] = history[i-1] + history[i-2];
        }
        
        return history[n-1];
    }
}
