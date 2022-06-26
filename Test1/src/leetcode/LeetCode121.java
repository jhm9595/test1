package leetcode;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * @author minibig
 *
 */
public class LeetCode121 {

	public int maxProfit(int[] prices) {
		
		int maxProfit = Integer.MIN_VALUE;
		
		int minValue = prices[0];
		
		for(int i = 1; i < prices.length; i++) {
			
			maxProfit = Math.max(maxProfit, prices[i] - minValue);
			
			if(prices[i] < minValue) {
				minValue = prices[i];
			}
		}
		
		return maxProfit < 0 ? 0 : maxProfit;
	}
}